package com.example.domain;

import com.example.domain.entity.Email;
import com.example.domain.entity.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> getByEmail(Email email);

    User save(User user);

    String encrypt(String password);

}
