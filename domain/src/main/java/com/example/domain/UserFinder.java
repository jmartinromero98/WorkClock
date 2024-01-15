package com.example.domain;

import com.example.domain.entity.Email;
import com.example.domain.entity.User;

public class UserFinder {

    private final UserRepository repository;

    public UserFinder(UserRepository repository) {
        this.repository = repository;
    }

    public User findUserByEmail(Email email) {
        var optUser = repository.getByEmail(email);
        if (optUser.isEmpty()) {
            throw new IllegalStateException("Non existing user");
        }
        return optUser.get();
    }
}
