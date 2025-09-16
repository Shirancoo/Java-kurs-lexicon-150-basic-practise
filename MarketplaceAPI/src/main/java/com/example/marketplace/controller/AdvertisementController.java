package com.example.marketplace.controller;

import com.example.marketplace.dto.AdvertisementRequest;
import com.example.marketplace.dto.AdvertisementResponse;
import com.example.marketplace.dto.UserLoginRequest;
import com.example.marketplace.model.Advertisement;
import com.example.marketplace.service.AdvertisementService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Den här klassen hanterar annonsrelaterade ends
@RestController
@RequestMapping("/api/ads")
public class AdvertisementController {

    // Skapar upp en instans av tjänsten
    @Autowired
    private AdvertisementService advertisementService;

    // POST /api/ads → här kan man skapa en ny annons (kräver login-info)
    @PostMapping
    public AdvertisementResponse skapaAnnons(@Valid @RequestBody AdvertisementRequest request) {
        System.out.println("Skapar annons...");
        return advertisementService.createAd(request)
                ;
    }

    // GET /api/ads → hämta alla annonser som inte är gamla
    @GetMapping
    public List<AdvertisementResponse> hamtaAllaAktivaAnnonser() {
        return advertisementService.getAllActiveAds();
    }

    // POST /api/ads/my-ads → hämta sina egna annonser om man loggar in
    @PostMapping("/my-ads")
    public List<AdvertisementResponse> hamtaMinaAnnonser(@Valid @RequestBody UserLoginRequest request) {
        // TODO: kanske lägga till paginering senare om det blir för många annonser
        return advertisementService.getMyAds(request);
    }
}
