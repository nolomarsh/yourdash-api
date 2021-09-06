package com.generalassembly.yourdash.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class UserAccount {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column(unique=true, nullable=false)
    private String username;
    @Column(nullable=false)
    private String password;
    @Column(nullable=false)
    private String streetAddress;
    // private String zipCode;

    public Integer getId() {
        return this.id;
    }
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public String getStreetAddress(){
        return this.streetAddress;
    }
    // public String getZipCode(){
    //     return this.zipCode;
    // }

    public void setId(Integer id){
        this.id = id;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setStreetAddress(String streetAddress){
        this.streetAddress = streetAddress;
    }
    // public void setZipCode(String zipCode){
    //     this.zipCode = zipCode;
    // }
}
