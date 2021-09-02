package com.generalassembly.yourdash.controllers;

import java.util.Optional;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCrypt;

import com.generalassembly.yourdash.entities.UserAccount;
import com.generalassembly.yourdash.repositories.UserAccountRepository;

@RestController
public class UserAccountController {
    @Autowired
    private UserAccountRepository users;

    @CrossOrigin
    @GetMapping("/users")
    public Iterable<UserAccount> index(){
        return users.findAll();
    }

    @CrossOrigin
    @GetMapping("/users/{id}")
    public Optional<UserAccount> show(@PathVariable Integer id){
        return users.findById(id);
    }

    @CrossOrigin
    @PostMapping("/users")
    public UserAccount create(@RequestBody UserAccount userData){
        userData.setPassword(BCrypt.hashpw(userData.getPassword(), BCrypt.gensalt(10)));
        users.save(userData);
        return userData;
    }

    @CrossOrigin
    @PostMapping("/users/login")
    public UserAccount login(@RequestBody HashMap<String,String> loginData){
        List<UserAccount> foundList = users.findUserAccountByUsername(loginData.get("username"));
        if (foundList.size() > 0) {
            UserAccount foundUser = foundList.get(0);
            if (BCrypt.checkpw(loginData.get("password"), foundUser.getPassword())){
                return foundUser;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @CrossOrigin
    @PutMapping("/users/{id}")
    public Optional<UserAccount> create(@RequestBody UserAccount fixUser, @PathVariable Integer id){
        Optional<UserAccount> fixedUser = users.findById(id).map(user -> {
            user.setUsername(fixUser.getUsername());
            user.setStreetAddress(fixUser.getStreetAddress());
            user.setZipCode(fixUser.getZipCode());
            users.save(user);
            return user;
        });

        return fixedUser;
    }

    @CrossOrigin
    @DeleteMapping("/users/{id}")
    public Iterable<UserAccount> destroy(@PathVariable Integer id){
        users.deleteById(id);
        return users.findAll();
    }
}
