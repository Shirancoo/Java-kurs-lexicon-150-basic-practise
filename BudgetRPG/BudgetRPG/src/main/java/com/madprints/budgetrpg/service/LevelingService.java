package com.madprints.budgetrpg.service;

import com.madprints.budgetrpg.dto.ProgressDto;
import org.springframework.stereotype.Service;

/**
 * Contains logic for computing player levels and XP progress.
 */
@Service
public class LevelingService {

    /**
     * XP required to reach the next level from the given level. Level 1 requires 100 XP, then +50 XP per subsequent level.
     * @param level current level (1-indexed)
     * @return XP required for next level
     */
    public int xpForNextLevel(int level) {
        return 100 + (level - 1) * 50;
    }

    /**
     * Compute level progression based on total XP and number of completed quests.
     * @param totalXp total XP accumulated
     * @param completedQuests number of completed quests
     * @return a ProgressDto summarizing level and XP state
     */
    public ProgressDto computeFromTotalXp(int totalXp, long completedQuests) {
        int level = 1;
        int xp = totalXp;
        while (xp >= xpForNextLevel(level)) {
            xp -= xpForNextLevel(level);
            level++;
        }
        int xpIntoLevel = xp;
        int xpNext = xpForNextLevel(level);
        int progressPercent = (int) Math.round((xpIntoLevel * 100.0) / xpNext);
        ProgressDto dto = new ProgressDto();
        dto.setLevel(level);
        dto.setTotalXp(totalXp);
        dto.setXpIntoLevel(xpIntoLevel);
        dto.setXpForNextLevel(xpNext);
        dto.setXpToNext(xpNext - xpIntoLevel);
        dto.setProgressPercent(progressPercent);
        dto.setCompletedQuests(completedQuests);
        return dto;
    }
}