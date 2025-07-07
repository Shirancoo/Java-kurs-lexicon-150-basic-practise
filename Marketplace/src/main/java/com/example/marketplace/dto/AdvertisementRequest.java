package com.example.marketplace.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class AdvertisementRequest {

    @Email(message = "Ogiltig e-post")
    public String email; // slarvigt: public istället för private

    @NotBlank(message = "Lösenord krävs")
    public String password; // samma sak här

    @NotBlank(message = "Titel får inte vara tom")
    public String title;

    private String description;

    @Future(message = "Datumet måste vara i framtiden")
    public LocalDate expirationDate;

    // Getters & Setters (slarv: vissa saknas med flit)
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getExpirationDate() { return expirationDate; }
    public void setExpirationDate(LocalDate expirationDate) { this.expirationDate = expirationDate; }
}
