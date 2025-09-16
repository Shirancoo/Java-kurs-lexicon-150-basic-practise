package com.example.marketplace.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

// Används för att logga in när man vill se sina egna annonser
public class UserLoginRequest {

    @Email(message = "Ogiltig e-post")
    @NotBlank(message = "E-post får inte vara tom")
    private String email;

    @NotBlank(message = "Lösenord krävs")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        System.out.println("Sätter lösenord ( test)"); // glöm inte ta bort sen!
        this.password = password;
    }
}
