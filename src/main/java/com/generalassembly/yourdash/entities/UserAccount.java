package com.generalassembly.yourdash.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserAccount {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String username;
    private String password;
    private String homeAddress;

    public Integer getId() {
        return this.id;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public String getHomeAddress(){
        return this.homeAddress;
    }

    public void setId(Integer id){
        this.id = id;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setHomeAddress(String homeAddress){
        this.homeAddress = homeAddress;
    }
}
