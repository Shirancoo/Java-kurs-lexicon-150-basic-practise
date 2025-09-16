package com.madprints.budgetrpg.config;

import com.madprints.budgetrpg.entity.User;
import com.madprints.budgetrpg.entity.PlayerProgress;
import com.madprints.budgetrpg.repository.UserRepository;
import com.madprints.budgetrpg.repository.PlayerProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Seeds a demo user and associated progress record on application startup if no users exist.
 */
@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PlayerProgressRepository progressRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Create demo user on startup if absent
        if (userRepo.findByEmail("demo@demo.se").isEmpty()) {
            User u = new User();
            u.setEmail("demo@demo.se");
            u.setPassword(passwordEncoder.encode("demo"));
            u.setDisplayName("Demo");
            userRepo.save(u);
            PlayerProgress p = new PlayerProgress();
            p.setUser(u);
            p.setTotalXp(0);
            progressRepo.save(p);
        }
    }
}