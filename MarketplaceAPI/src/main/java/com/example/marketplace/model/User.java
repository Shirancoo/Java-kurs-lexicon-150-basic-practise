package com.example.marketplace.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Setter;

import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String password;

    @Setter
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Advertisement> minaAnnonser;

    // Tom konstruktor krävs av JPA
    public User() {}

    // Används när man skapar användare
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        System.out.println("Sätter nytt lösenord för: " + email); // debug
        this.password = password;
    }

    public List<Advertisement> getMinaAnnonser() {
        return minaAnnonser;
    }

}
