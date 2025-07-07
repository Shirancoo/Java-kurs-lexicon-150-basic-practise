package com.example.marketplace.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Advertisement> advertisements;

    // Konstruktörer
    public User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters och Setters
    public Long getId() { return id; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public List<Advertisement> getAdvertisements() { return advertisements; }

    public void setAdvertisements(List<Advertisement> advertisements) { this.advertisements = advertisements; }
}
