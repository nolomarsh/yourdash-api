package com.generalassembly.yourdash.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;

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
    public Iterable<UserAccount> create(@RequestBody UserAccount userData){
        users.save(userData);
        return users.findAll();
    }

    @CrossOrigin
    @PutMapping("/users/{id}")
    public Iterable<UserAccount> create(@RequestBody UserAccount fixUser, @PathVariable Integer id){
        users.findById(id).map(user -> {
            user.setSubject(fixUser.getSubject());
            user.setDetails(fixUser.getDetails());
            users.save(user);
            return user;
        });
    }

    @CrossOrigin
    @DeleteMapping("/users/{id}")
    public Iterable<UserAccount> destroy(@PathVariable Integer id){
        users.deleteById(id);
        return users.findeAll();
    }
}
