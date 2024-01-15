package com.example.application;

import com.example.domain.UserRepository;
import com.example.domain.UserSearcher;
import com.example.domain.entity.Email;
import com.example.domain.entity.User;

public class RegisterService {

    /**
     * No relacionar directamente un servicio de aplicación con uno de infraestructura, solo mediante el dominio
     * para ello creamos una interfaz Repository en el dominio y la inyectamos. No es lo mismo con un servicio
     * de dominio.
      */
    private final UserRepository repository;
    private final UserSearcher searcher;

    public RegisterService(UserRepository repository) {
        this.repository = repository;
        this.searcher = new UserSearcher(repository);
    }

    public String register(String email, String password) {
        var userEmail = new Email(email);
        checkExistingUser(userEmail);
        var encryptedPassword = repository.encrypt(password);
        repository.save(new User(userEmail, encryptedPassword));
        return "Session token"; // TODO: TokenGenerator
    }

    private void checkExistingUser(Email userEmail) {
        var existingUser = searcher.searchByEmail(userEmail);
        if (existingUser.isPresent()) {
            throw new IllegalStateException("User already registered with this email");
        }
    }

}
