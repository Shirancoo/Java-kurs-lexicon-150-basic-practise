package com.example.marketplace.exception;

// Kastas om annonsen är utgången
public class AdvertisementExpiredException extends RuntimeException {
    public AdvertisementExpiredException(String message) {
        super(message);
    }
}
