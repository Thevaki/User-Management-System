package com.example.usermanagement.Model;


import javax.persistence.*;

@Entity
public class UserModel {

    @Id //primary key of the current entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // to auto increment the id
    private Integer userId;

    private String username;

    private String email;

    private String address;

    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
