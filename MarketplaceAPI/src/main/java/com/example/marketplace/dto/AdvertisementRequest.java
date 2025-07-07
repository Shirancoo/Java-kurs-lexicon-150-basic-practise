package com.example.marketplace.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

// DTO som används när man skapar en ny annons
public class AdvertisementRequest {

    @Email(message = "Ogiltig e-postadress")
    @NotBlank(message = "E-post får inte vara tom")
    private String email;

    @NotBlank(message = "Lösenord krävs")
    private String password;

    @NotBlank(message = "Titel får inte vara tom")
    private String title;

    @NotBlank(message = "Beskrivning krävs")
    private String description;

    @Future(message = "Utgångsdatum måste vara i framtiden")
    private LocalDate expirationDate;

    // Getters & setters
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
