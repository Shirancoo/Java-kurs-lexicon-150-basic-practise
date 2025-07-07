
package com.example.marketplace.service;

import com.example.marketplace.exception.InvalidCredentialsException;
import com.example.marketplace.model.User;
import com.example.marketplace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Denna klass hanterar logiken kring användare
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Metod som hittar användare via e-post
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Validerar användare, används vid login
    public User validateUser(String email, String password) {
        return userRepository.findByEmail(email)
                .filter(user -> user.getPassword().equals(password))
                .orElseThrow(() -> new InvalidCredentialsException("Felaktig e-post eller lösenord"));
    }

    // Skapar ny användare om e-post inte finns
    public User registerUser(String email, String password) {
        User user = new User(email, password);
        return userRepository.save(user);
    }

}
