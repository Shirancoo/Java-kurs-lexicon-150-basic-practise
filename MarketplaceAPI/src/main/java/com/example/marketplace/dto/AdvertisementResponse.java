package com.example.marketplace.dto;

import java.time.LocalDate;

// DTO som skickas tillbaka till klienten när en annons hämtas
public class AdvertisementResponse {
    private String title;
    private String description;
    private LocalDate expirationDate;

    // Konstruktor
    public AdvertisementResponse(String title, String description, LocalDate expirationDate) {
        this.title = title;
        this.description = description;
        this.expirationDate = expirationDate;
    }

    // Getters
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public LocalDate getExpirationDate() { return expirationDate; }
}
