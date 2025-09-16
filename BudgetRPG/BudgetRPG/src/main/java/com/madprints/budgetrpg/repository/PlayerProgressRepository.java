package com.madprints.budgetrpg.repository;

import com.madprints.budgetrpg.entity.PlayerProgress;
import com.madprints.budgetrpg.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * Repository for PlayerProgress entities.
 */
public interface PlayerProgressRepository extends JpaRepository<PlayerProgress, Long> {
    Optional<PlayerProgress> findByUser(User user);
}