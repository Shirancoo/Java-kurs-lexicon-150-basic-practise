package com.example.marketplace.repository;

import com.example.marketplace.model.Advertisement;
import com.example.marketplace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

// Repository för att hämta annonser
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

    // Hämta alla annonser som inte har gått ut
    List<Advertisement> findByExpirationDateAfter(LocalDate date);

    // Hämta alla annonser för en viss användare
    List<Advertisement> findByUser(User user);
}
