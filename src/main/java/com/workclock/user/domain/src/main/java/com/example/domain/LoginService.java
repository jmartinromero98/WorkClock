package com.workclock.user;

import com.workclock.user.domain.*;
import com.workclock.user.domain.entity.Email;
import com.workclock.user.domain.entity.User;

public class LoginService {

    private final UserFinder finder;
    private final UserRepository repository;

    public LoginService(UserRepository repository) {
        this.finder = new UserFinder(repository);
        this.repository = repository;
    }

    public String login(String email, String password) {
        var userEmail = new Email(email);
        User user = finder.findUserByEmail(userEmail);
        checkSamePassword(password, user);
        return "session token"; // TODO: TokenGenerator
    }

    private void checkSamePassword(String password, User user) {
        var encryptedPassword = repository.encrypt(password);
        if (!user.isSamePassword(encryptedPassword)) {
            throw new IllegalArgumentException("Wrong password");
        }
    }
}
