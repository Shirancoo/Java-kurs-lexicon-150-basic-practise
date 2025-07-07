package com.example.marketplace.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String title;
    private String description;
    private LocalDate expirationDate;

    @ManyToOne
    private User creator; // Vem har lagt upp annonsen?

    public Advertisement() {}

    public Advertisement(String title, String description, LocalDate expirationDate, User creator) {
        this.title = title;
        this.description = description;
        this.expirationDate = expirationDate;
        this.creator = creator;
    }

    // Getters & Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getExpirationDate() { return expirationDate; }
    public void setExpirationDate(LocalDate expirationDate) { this.expirationDate = expirationDate; }

    public User getCreator() { return creator; }
    public void setCreator(User creator) { this.creator = creator; }
}
