package com.madprints.budgetrpg.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Set;

/**
 * Represents an application user. Contains login credentials and display name.
 */
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "E-post saknas")
    @Email(message = "Ogiltig e-post")
    @Size(max = 200)
    private String email;

    @NotBlank(message = "Lösenord saknas")
    private String password;

    @Size(max = 100)
    private String displayName;

    // Relations
    @OneToMany(mappedBy = "owner")
    private Set<Quest> quests;

    @OneToOne(mappedBy = "user")
    private PlayerProgress progress;

    public User() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public Set<Quest> getQuests() { return quests; }
    public void setQuests(Set<Quest> quests) { this.quests = quests; }

    public PlayerProgress getProgress() { return progress; }
    public void setProgress(PlayerProgress progress) { this.progress = progress; }
}