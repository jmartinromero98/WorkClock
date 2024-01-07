package com.workclock.user.domain;

import com.workclock.user.domain.entity.Email;
import com.workclock.user.domain.entity.User;

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
