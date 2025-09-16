package com.example.marketplace.exception;

// Slängs om man försöker registrera en användare som redan finns
public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String message) {
        super(message);
    }

    public UserAlreadyExistsException() {
        super("Användaren finns redan i systemet");
    }
}
