package com.example.marketplace.controller;
import com.example.marketplace.dto.AdvertisementRequest;
import com.example.marketplace.dto.AdvertisementResponse;
import com.example.marketplace.dto.UserLoginRequest;
import com.example.marketplace.model.Advertisement;
import com.example.marketplace.service.AdvertisementService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Denna klass hanterar API-endpoints för annonser
@RestController
@RequestMapping("/api/ads")
@Tag(name = "Annonser", description = "Hantera annonser")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;

    // POST /api/ads → Skapa annons med login eller auto-registrering
    @PostMapping
    @Operation(summary = "Skapa en ny annons")
    public Advertisement createAd(@Valid @RequestBody AdvertisementRequest request) {
        return advertisementService.createAd(request);
    }

    // GET /api/ads → Hämta alla aktiva annonser
    @GetMapping
    @Operation(summary = "Hämta alla aktiva annonser")
    public List<AdvertisementResponse> getActiveAds() {
        return advertisementService.getAllActiveAds();
    }

    // POST /api/ads/my-ads → Hämta användarens egna annonser
    @PostMapping("/my-ads")
    @Operation(summary = "Hämta dina egna annonser")
    public List<AdvertisementResponse> getMyAds(@Valid @RequestBody UserLoginRequest request) {
        return advertisementService.getMyAds(request);
    }
}
