package com.madprints.budgetrpg.controller;

import com.madprints.budgetrpg.dto.ProgressDto;
import com.madprints.budgetrpg.entity.PlayerProgress;
import com.madprints.budgetrpg.entity.User;
import com.madprints.budgetrpg.repository.PlayerProgressRepository;
import com.madprints.budgetrpg.repository.QuestRepository;
import com.madprints.budgetrpg.repository.UserRepository;
import com.madprints.budgetrpg.service.LevelingService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Returns XP/level progress for current user.
 */
@RestController
@RequestMapping("/api/progress")
public class ProgressController {
    private final PlayerProgressRepository progressRepo;
    private final QuestRepository questRepo;
    private final UserRepository userRepo;
    private final LevelingService levelingService;

    @Autowired
    public ProgressController(PlayerProgressRepository progressRepo, QuestRepository questRepo, UserRepository userRepo, LevelingService levelingService) {
        this.progressRepo = progressRepo;
        this.questRepo = questRepo;
        this.userRepo = userRepo;
        this.levelingService = levelingService;
    }

    @GetMapping
    public ResponseEntity<ProgressDto> getProgress(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        User user = userRepo.findById(userId).orElse(null);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        PlayerProgress pp = progressRepo.findByUser(user).orElse(null);
        if (pp == null) {
            pp = new PlayerProgress();
            pp.setUser(user);
            pp.setTotalXp(0);
            progressRepo.save(pp);
        }
        long done = questRepo.countByOwnerAndCompleted(user, true);
        ProgressDto dto = levelingService.computeFromTotalXp(pp.getTotalXp(), done);
        return ResponseEntity.ok(dto);
    }
}