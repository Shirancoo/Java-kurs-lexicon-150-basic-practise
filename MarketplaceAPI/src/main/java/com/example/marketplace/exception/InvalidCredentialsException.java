package com.example.marketplace.exception;

// Kastas vid felaktig e-post eller lösenord
public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(String message) {
        super(message);
    }
}
