package com.workclock.user.domain;

import com.workclock.user.domain.entity.Email;
import com.workclock.user.domain.entity.User;

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
