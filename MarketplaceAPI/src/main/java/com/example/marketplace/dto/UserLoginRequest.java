package com.example.marketplace.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

// DTO för att logga in och hämta sina annonser
public class UserLoginRequest {

    @Email(message = "Ogiltig e-post")
    @NotBlank(message = "E-post får inte vara tom")
    private String email;

    @NotBlank(message = "Lösenord krävs")
    private String password;

    // Getters & setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
