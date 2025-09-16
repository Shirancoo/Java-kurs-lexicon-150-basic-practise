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

    private final AdvertisementRepository advertisementRepo;
    private final UserService userService;
    private final UserRepository userRepo;

    // Constructor injection – Spring handles this
    public AdvertisementService(AdvertisementRepository advertisementRepo,
                                UserService userService,
                                UserRepository userRepo) {
        this.advertisementRepo = advertisementRepo;
        this.userService = userService;
        this.userRepo = userRepo;
    }

    // Skapar en annons – om användaren inte finns så skapas den automatiskt
    public AdvertisementResponse createAd(AdvertisementRequest request) {
        User user = userService.findByEmail(request.getEmail())
                .map(u -> userService.validateUser(request.getEmail(), request.getPassword()))
                .orElseGet(() -> userService.registerUser(request.getEmail(), request.getPassword()));

        Advertisement ad = new Advertisement(
                request.getTitle(),
                request.getDescription(),
                request.getExpirationDate(),
                user
        );

        System.out.println("Saving ad: " + ad.getTitle());
        Advertisement savedAd = advertisementRepo.save(ad);
        AdvertisementResponse NewAd = new AdvertisementResponse(savedAd.getTitle(),savedAd.getDescription(),savedAd.getExpirationDate(),savedAd.getId()) ;
        return NewAd;
    }

    // Get all non-expired ads
    public List<AdvertisementResponse> getAllActiveAds() {
        return advertisementRepo.findByExpirationDateAfter(LocalDate.now())
                .stream()
                .map(ad -> new AdvertisementResponse(
                        ad.getTitle(),
                        ad.getDescription(),
                        ad.getExpirationDate()
                        ,ad.getId()
                ))
                .collect(Collectors.toList());
    }

    // få alla annonser från inloggade
    public List<AdvertisementResponse> getMyAds(UserLoginRequest request) {
        User user = userService.findByEmail(request.getEmail())
                .filter(u -> u.getPassword().equals(request.getPassword()))
                .orElseThrow(() -> new InvalidCredentialsException("Incorrect email or password"));

        return advertisementRepo.findByUser(user)
                .stream()
                .map(ad -> new AdvertisementResponse(
                        ad.getTitle(),
                        ad.getDescription(),
                        ad.getExpirationDate()
                        ,ad.getId()
                ))
                .collect(Collectors.toList());
    }
}
