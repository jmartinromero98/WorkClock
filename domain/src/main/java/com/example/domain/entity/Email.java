package com.example.domain.entity;

import java.util.Objects;

public class Email {

    private final String email;

    public Email(String email) {
        validateEmail(email);
        this.email = email;
    }

    public String getValue() {
        return email;
    }

    private void validateEmail(String email) {
        if (email.isBlank() || !email.contains("@")) {
            throw new IllegalArgumentException("Malformed email"); // deberíamos soltar una excepción de nuestro dominio?
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email1 = (Email) o;
        return Objects.equals(email, email1.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
