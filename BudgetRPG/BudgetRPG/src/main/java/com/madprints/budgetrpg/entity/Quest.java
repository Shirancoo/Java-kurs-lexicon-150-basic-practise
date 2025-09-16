package com.madprints.budgetrpg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.madprints.budgetrpg.entity.User;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
public class Quest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message="Titel saknas")
    @Size(max = 100, message="Titel får vara max 100 tecken")
    private String title;

    @Size(max = 1000, message="Beskrivning får vara max 1000 tecken")
    private String description;

    private boolean completed = false;

    private LocalDate dueDate;

    /**
     * Den användare som äger detta quest. Krävs för per-användardata.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id")
    @JsonIgnore
    private User owner;

    /**
     * Tidpunkt när questet markerades som klart. Null om inte klart.
     */
    private LocalDateTime completedAt;

    public Quest() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    public User getOwner() { return owner; }
    public void setOwner(User owner) { this.owner = owner; }

    public LocalDateTime getCompletedAt() { return completedAt; }
    public void setCompletedAt(LocalDateTime completedAt) { this.completedAt = completedAt; }

    /**
     * Sätt förfallodatum från JSON-sträng. Tom sträng behandlas som null.
     */
    @JsonSetter("dueDate")
    public void parseDueDate(String dueDate) {
        if (dueDate == null || dueDate.isBlank()) {
            this.dueDate = null;
        } else {
            this.dueDate = LocalDate.parse(dueDate);
        }
    }
}
