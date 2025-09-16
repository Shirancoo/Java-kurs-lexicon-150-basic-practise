package com.example.marketplace.dto;

import java.time.LocalDate;

public class AdvertisementRequest {
    private String email;
    private String password;
    private String title;
    private String description;
    private LocalDate expirationDate;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    // Tom konstruktor?
    public AdvertisementRequest() {
    }

    public AdvertisementRequest(String email, String password, String title, String description, LocalDate expirationDate) {
        this.email = email;
        this.password = password;
        this.title = title;
        this.description = description;
        this.expirationDate = expirationDate;
    }
}
