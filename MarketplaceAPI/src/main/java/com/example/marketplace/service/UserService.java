package com.example.marketplace.service;

import com.example.marketplace.exception.InvalidCredentialsException;
import com.example.marketplace.model.User;
import com.example.marketplace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Hanterar användare (typ login, hitta, skapa)
@Service
public class UserService {

    @Autowired
    private UserRepository userRepo; //

    // Hitta användare via e-post
    public Optional<User> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    // Kollar om e-post + lösenord stämmer
    public User validateUser(String email, String password) {
        return userRepo.findByEmail(email)
                .filter(user -> user.getPassword().equals(password))
                .orElseThrow(() -> new InvalidCredentialsException("Felaktig e-post eller lösenord"));
    }

    // Skapar en ny användare  om den inte redan finns
    public User registerUser(String email, String password) {
        System.out.println("Registrerar ny användare: " + email); // debug, ta bort sen kanske

        User user = new User(email, password);

        return userRepo.save(user);
    }
}
