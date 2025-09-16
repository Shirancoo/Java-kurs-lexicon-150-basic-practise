package com.example.marketplace.repository;

import com.example.marketplace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Hämtar användare från databasen, Spring sköter resten?
public interface UserRepository extends JpaRepository<User, Long> {

    // Hitta användare via e-post (för inloggning typ)
    Optional<User> findByEmail(String email);

    // TODO: kanske lägga till metod för att ta bort användare via e-post?
}
