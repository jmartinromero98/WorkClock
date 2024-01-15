package com.example.domain;

import com.example.domain.entity.Email;
import com.example.domain.entity.User;

import java.util.Optional;

public class UserSearcher {

    private final UserRepository repository;

    public UserSearcher(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<User> searchByEmail(Email email) {
        return repository.getByEmail(email);
    }

}
