package com.madprints.budgetrpg.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;

/**
 * Holds the XP progress for a user. Each user has a single row storing total XP.
 */
@Entity
public class PlayerProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @PositiveOrZero
    private int totalXp = 0;

    public PlayerProgress() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public int getTotalXp() { return totalXp; }
    public void setTotalXp(int totalXp) { this.totalXp = totalXp; }
}