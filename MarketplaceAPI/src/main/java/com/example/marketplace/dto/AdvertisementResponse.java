package com.example.marketplace.dto;

import java.time.LocalDate;

// skickas tillbaka när vi hämtar annonser
public class AdvertisementResponse {
    private long id;
    private String description;
    private String title; // egentligen kanske borde ligga överst, men det funkar så här med :)
    private LocalDate expirationDate;

    // Konstruktor
    public AdvertisementResponse(String title, String description, LocalDate expirationDate, long id) {
        this.title = title;
        this.description = description;
        this.expirationDate = expirationDate;
        this.id = id;
    }
    // Getters

    public long getId() {
        return id;}
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public LocalDate getExpirationDate() { return expirationDate; }

}
