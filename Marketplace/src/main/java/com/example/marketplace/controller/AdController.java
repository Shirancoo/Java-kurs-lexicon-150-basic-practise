package com.example.marketplace.controller;

import com.example.marketplace.dto.AdvertisementRequest;
import com.example.marketplace.model.Advertisement;
import com.example.marketplace.service.AdService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ads")
public class AdController {

    private final AdService adService;

    public AdController(AdService adService) {
        this.adService = adService;
    }

    // Skapa annons, loggar in eller registrerar beroende på e-post
    @PostMapping
    public ResponseEntity<Advertisement> create(@RequestBody AdvertisementRequest request) {
        // Slarvfel: saknar @Valid → valideringsregler körs ej
        Advertisement savedAd = adService.createAd(request);
        return new ResponseEntity<>(savedAd, HttpStatus.CREATED);
    }

    // Hämtar alla aktiva annonser (dvs. ej utgångna)
    @GetMapping
    public List<Advertisement> getAll() {
        return adService.getActiveAds();
    }

    // Hämtar användarens egna annonser
    @PostMapping("/my-ads")
    public List<Advertisement> getMyAds(@RequestBody AdvertisementRequest request) {
        // Slarv: ingen validering här heller
        return adService.getMyAds(request.getEmail(), request.getPassword());
    }
}
