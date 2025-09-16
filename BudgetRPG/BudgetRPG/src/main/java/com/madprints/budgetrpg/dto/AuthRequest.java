package com.madprints.budgetrpg.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * DTO for authentication requests (register & login).
 */
public class AuthRequest {
    @NotBlank(message = "E-post saknas")
    @Email(message = "Ogiltig e-post")
    private String email;

    @NotBlank(message = "Lösenord saknas")
    private String password;

    private String displayName;

    public AuthRequest() {}

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }
}