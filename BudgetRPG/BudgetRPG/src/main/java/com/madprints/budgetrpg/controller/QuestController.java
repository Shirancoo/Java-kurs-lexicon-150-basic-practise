package com.madprints.budgetrpg.controller;

import com.madprints.budgetrpg.entity.Quest;
import com.madprints.budgetrpg.repository.QuestRepository;
import com.madprints.budgetrpg.repository.UserRepository;
import com.madprints.budgetrpg.repository.PlayerProgressRepository;
import com.madprints.budgetrpg.entity.User;
import com.madprints.budgetrpg.entity.PlayerProgress;
import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/quests")
public class QuestController {
    private final QuestRepository repo;
    private final UserRepository userRepo;
    private final PlayerProgressRepository progressRepo;

    public QuestController(QuestRepository repo, UserRepository userRepo, PlayerProgressRepository progressRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
        this.progressRepo = progressRepo;
    }

    @GetMapping
    public ResponseEntity<List<Quest>> list(HttpSession session, @RequestParam(required = false) Boolean completed) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        User user = userRepo.findById(userId).orElse(null);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        List<Quest> list;
        if (completed == null) {
            list = repo.findByOwner(user);
        } else {
            list = repo.findByOwnerAndCompleted(user, completed);
        }
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<Quest> create(HttpSession session, @Valid @RequestBody Quest quest) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        User user = userRepo.findById(userId).orElse(null);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        quest.setId(null);
        quest.setOwner(user);
        quest.setCompleted(false);
        quest.setCompletedAt(null);
        Quest saved = repo.save(quest);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quest> update(HttpSession session, @PathVariable Long id, @Valid @RequestBody Quest updated) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        User user = userRepo.findById(userId).orElse(null);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Optional<Quest> opt = repo.findByIdAndOwner(id, user);
        if (opt.isEmpty()) return ResponseEntity.notFound().build();
        Quest existing = opt.get();
        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        existing.setDueDate(updated.getDueDate());
        // Do not allow direct modification of completed/owner via PUT; use toggle endpoint for completion.
        Quest saved = repo.save(existing);
        return ResponseEntity.ok(saved);
    }

    @PatchMapping("/{id}/toggle-complete")
    public ResponseEntity<Quest> toggle(HttpSession session, @PathVariable Long id) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        User user = userRepo.findById(userId).orElse(null);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Optional<Quest> opt = repo.findByIdAndOwner(id, user);
        if (opt.isEmpty()) return ResponseEntity.notFound().build();
        Quest quest = opt.get();
        boolean willComplete = !quest.isCompleted();
        quest.setCompleted(willComplete);
        if (willComplete) {
            quest.setCompletedAt(LocalDateTime.now());
        } else {
            quest.setCompletedAt(null);
        }
        // Award or remove XP
        PlayerProgress prog = progressRepo.findByUser(user).orElse(null);
        if (prog == null) {
            prog = new PlayerProgress();
            prog.setUser(user);
            prog.setTotalXp(0);
        }
        int xpAward = 50;
        if (willComplete && quest.getDueDate() != null) {
            // Bonus if dueDate is today or in future
            LocalDate today = LocalDate.now();
            if (!today.isAfter(quest.getDueDate())) {
                xpAward += 25;
            }
        }
        if (willComplete) {
            prog.setTotalXp(prog.getTotalXp() + xpAward);
        } else {
            prog.setTotalXp(Math.max(0, prog.getTotalXp() - xpAward));
        }
        progressRepo.save(prog);
        Quest saved = repo.save(quest);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(HttpSession session, @PathVariable Long id) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        User user = userRepo.findById(userId).orElse(null);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Optional<Quest> opt = repo.findByIdAndOwner(id, user);
        if (opt.isEmpty()) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
