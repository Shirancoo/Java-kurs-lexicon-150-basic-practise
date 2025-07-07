package com.example.marketplace.service;

import com.example.marketplace.dto.AdvertisementRequest;
import com.example.marketplace.model.Advertisement;
import com.example.marketplace.model.User;
import com.example.marketplace.repository.AdRepository;
import com.example.marketplace.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AdService {

    private final AdRepository adRepository;
    private final UserRepository userRepository;

    public AdService(AdRepository adRepository, UserRepository userRepository) {
        this.adRepository = adRepository;
        this.userRepository = userRepository;
    }

    public Advertisement createAd(AdvertisementRequest request) {
        // Hämta eller skapa användare
        User user = userRepository.findByEmail(request.getEmail()).orElseGet(() -> {
            User newUser = new User(request.getEmail(), request.getPassword());
            return userRepository.save(newUser);
        });

        // Kontrollera lösenord
        if (!user.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("Fel lösenord"); // ej custom exception här
        }

        Advertisement ad = new Advertisement(
                request.getTitle(),
                request.getDescription(),
                request.getExpirationDate(),
                user
        );

        return adRepository.save(ad);
    }

    public List<Advertisement> getActiveAds() {
        return adRepository.findByExpirationDateAfter(LocalDate.now());
    }

    public List<Advertisement> getMyAds(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("Fel e-post"));

        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Fel lösenord");
        }

        return adRepository.findByCreator(user);
    }
}
