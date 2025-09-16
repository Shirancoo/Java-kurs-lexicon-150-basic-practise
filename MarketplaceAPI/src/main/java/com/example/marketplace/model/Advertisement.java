package com.example.marketplace.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    private String title;
    @Getter
    private String description;
    @Getter
    private LocalDate expirationDate;

    @Getter
    @ManyToOne
    private User user;

    public Advertisement() {
    }

    public Advertisement(String title, String description, LocalDate expirationDate, User user) {
        this.title = title;
        this.description = description;
        this.expirationDate = expirationDate;
        this.user = user;
    }

}
