package com.madprints.budgetrpg.repository;

import com.madprints.budgetrpg.entity.Quest;
import com.madprints.budgetrpg.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestRepository extends JpaRepository<Quest, Long> {
    // Find all quests by owner. If completed is null, return all quests regardless of status.
    List<Quest> findByOwner(User owner);

    // Find quests by owner and completion status.
    List<Quest> findByOwnerAndCompleted(User owner, boolean completed);

    // Count quests by owner and completion status.
    long countByOwnerAndCompleted(User owner, boolean completed);

    // Find by id and owner (used to ensure only the owner can modify).
    java.util.Optional<Quest> findByIdAndOwner(Long id, User owner);
}
