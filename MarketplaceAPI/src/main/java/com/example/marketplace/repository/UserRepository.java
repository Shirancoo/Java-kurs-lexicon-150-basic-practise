package com.example.marketplace.repository;

import com.example.marketplace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Repository för att hämta användare från databasen
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
