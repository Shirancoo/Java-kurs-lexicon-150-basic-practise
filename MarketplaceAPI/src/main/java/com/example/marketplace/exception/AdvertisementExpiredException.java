package com.example.marketplace.exception;

// Denna kastas om annonsen har gått ut
public class AdvertisementExpiredException extends RuntimeException {

    public AdvertisementExpiredException(String message) {
        super(message);
    }

    public AdvertisementExpiredException() {
        super("Annonsen är inte längre aktiv");
    }

    // TODO: fundera på om vi ska logga detta också någonstans
}
