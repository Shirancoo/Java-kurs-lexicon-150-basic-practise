package com.example.marketplace.exception;

// Slängs om man skriver in fel lösenord eller e-post
public class InvalidCredentialsException extends RuntimeException {

    public InvalidCredentialsException(String message) {
        super(message);
    }

    public InvalidCredentialsException() {
        super("Fel e-post eller lösenord");
    }
}
