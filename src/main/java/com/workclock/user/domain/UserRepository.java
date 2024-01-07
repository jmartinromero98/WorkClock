package com.workclock.user.domain;

import com.workclock.user.domain.entity.Email;
import com.workclock.user.domain.entity.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> getByEmail(Email email);

    User save(User user);

    String encrypt(String password);

}
