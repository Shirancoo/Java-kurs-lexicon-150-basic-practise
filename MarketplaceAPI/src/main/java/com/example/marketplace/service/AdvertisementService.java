package com.example.marketplace.service;

import com.example.marketplace.dto.AdvertisementRequest;
import com.example.marketplace.dto.AdvertisementResponse;
import com.example.marketplace.dto.UserLoginRequest;
import com.example.marketplace.exception.InvalidCredentialsException;
import com.example.marketplace.model.Advertisement;
import com.example.marketplace.model.User;
import com.example.marketplace.repository.AdvertisementRepository;
import com.example.marketplace.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdvertisementService {

    private final AdvertisementRepository advertisementRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    // Konstruktor-injektion
    public AdvertisementService(AdvertisementRepository advertisementRepository,
                                UserService userService,
                                UserRepository userRepository) {
        this.advertisementRepository = advertisementRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    // Skapar ny annons med login eller auto-registrering
    public Advertisement createAd(AdvertisementRequest request) {
        User user = userService.findByEmail(request.getEmail())
                .map(u -> userService.validateUser(request.getEmail(), request.getPassword()))
                .orElseGet(() -> userService.registerUser(request.getEmail(), request.getPassword()));

        Advertisement ad = new Advertisement(
                request.getTitle(),
                request.getDescription(),
                request.getExpirationDate(),
                user
        );

        return advertisementRepository.save(ad);
    }

    // Hämtar alla annonser som inte har gått ut
    public List<AdvertisementResponse> getAllActiveAds() {
        return advertisementRepository.findByExpirationDateAfter(LocalDate.now())
                .stream()
                .map(ad -> new AdvertisementResponse(
                        ad.getTitle(),
                        ad.getDescription(),
                        ad.getExpirationDate()
                ))
                .collect(Collectors.toList());
    }

    // Hämtar annonser för en viss användare
    public List<AdvertisementResponse> getMyAds(UserLoginRequest request) {
        User user = userService.findByEmail(request.getEmail())
                .filter(u -> u.getPassword().equals(request.getPassword()))
                .orElseThrow(() -> new InvalidCredentialsException("Felaktig e-post eller lösenord"));

        return advertisementRepository.findByUser(user)
                .stream()
                .map(ad -> new AdvertisementResponse(
                        ad.getTitle(),
                        ad.getDescription(),
                        ad.getExpirationDate()
                ))
                .collect(Collectors.toList());
    }
}
