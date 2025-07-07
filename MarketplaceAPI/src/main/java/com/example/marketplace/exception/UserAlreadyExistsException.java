package com.example.marketplace.exception;

// Kastas om användaren redan finns vid registrering
public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
