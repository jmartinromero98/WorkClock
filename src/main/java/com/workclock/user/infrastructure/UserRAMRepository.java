package com.workclock.user.infrastructure;

import com.workclock.user.domain.entity.Email;
import com.workclock.user.domain.entity.User;
import com.workclock.user.domain.UserRepository;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserRAMRepository implements UserRepository {

    List<User> users = new ArrayList<>();
    private final MessageDigest messageDigest;

    public UserRAMRepository() throws NoSuchAlgorithmException {
        messageDigest = MessageDigest.getInstance("MD5");
    }

    @Override
    public Optional<User> getByEmail(Email email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findAny();
    }

    @Override
    public User save(User user) {
        users.add(user);
        System.out.println("Nuevo usuario. Email: " + user.getEmail().getValue() + ", contraseña: " + user.getPassword());
        return user;
    }

    @Override
    public String encrypt(String password) {
        return new String(messageDigest.digest(password.getBytes()));
    }
}
