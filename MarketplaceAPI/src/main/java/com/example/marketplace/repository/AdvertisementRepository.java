package com.example.marketplace.repository;

import com.example.marketplace.model.Advertisement;
import com.example.marketplace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

// Här hämtar vi annonser från databasen (automatiskt med Spring?)
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    // Returnerar annonser som inte gått ut ännu
    List<Advertisement> findByExpirationDateAfter(LocalDate date);

    // Returnerar alla annonser som tillhör en viss användare
    List<Advertisement> findByUser(User user);

    // TODO: kanske lägga till sortering efter datum eller titel
}
