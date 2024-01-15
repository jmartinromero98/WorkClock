package com.example.domain.entity;

public class User {

    private String id;
    private Email email;
    private String password;

    public User(Email email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public Email getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isSamePassword(String password) {
        return this.password.equals(password);
    }
}
