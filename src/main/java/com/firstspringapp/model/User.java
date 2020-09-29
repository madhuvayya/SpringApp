package com.firstspringapp.model;

import org.springframework.stereotype.Component;

@Component
public class User {

    private String id;
    private String firstName;
    private String email;

    public User() {
    }

    public User(String id,String firstName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
