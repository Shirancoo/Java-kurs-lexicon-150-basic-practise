package com.madprints.budgetrpg.controller;

import com.madprints.budgetrpg.dto.AuthRequest;
import com.madprints.budgetrpg.entity.PlayerProgress;
import com.madprints.budgetrpg.entity.User;
import com.madprints.budgetrpg.repository.PlayerProgressRepository;
import com.madprints.budgetrpg.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Handles registration, login and logout. Uses HTTP session to persist login state.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserRepository userRepo;
    private final PlayerProgressRepository progressRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UserRepository userRepo, PlayerProgressRepository progressRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.progressRepo = progressRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody AuthRequest req) {
        if (userRepo.findByEmail(req.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("error", "Användare finns redan"));
        }
        User u = new User();
        u.setEmail(req.getEmail());
        u.setPassword(passwordEncoder.encode(req.getPassword()));
        u.setDisplayName(req.getDisplayName());
        userRepo.save(u);
        // create progress
        PlayerProgress p = new PlayerProgress();
        p.setUser(u);
        p.setTotalXp(0);
        progressRepo.save(p);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody AuthRequest req, HttpSession session) {
        User u = userRepo.findByEmail(req.getEmail()).orElse(null);
        if (u == null || !passwordEncoder.matches(req.getPassword(), u.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Ogiltiga uppgifter"));
        }
        session.setAttribute("userId", u.getId());
        return ResponseEntity.ok(Map.of(
            "id", u.getId(),
            "email", u.getEmail(),
            "displayName", u.getDisplayName()
        ));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok().build();
    }
}