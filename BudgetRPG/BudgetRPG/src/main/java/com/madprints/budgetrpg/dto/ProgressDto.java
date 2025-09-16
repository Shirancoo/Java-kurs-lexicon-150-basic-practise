package com.madprints.budgetrpg.dto;

/**
 * DTO for returning player progress and XP/level info to the frontend.
 */
public class ProgressDto {
    private int level;
    private int totalXp;
    private int xpIntoLevel;
    private int xpForNextLevel;
    private int xpToNext;
    private int progressPercent;
    private long completedQuests;

    public ProgressDto() {}

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public int getTotalXp() { return totalXp; }
    public void setTotalXp(int totalXp) { this.totalXp = totalXp; }

    public int getXpIntoLevel() { return xpIntoLevel; }
    public void setXpIntoLevel(int xpIntoLevel) { this.xpIntoLevel = xpIntoLevel; }

    public int getXpForNextLevel() { return xpForNextLevel; }
    public void setXpForNextLevel(int xpForNextLevel) { this.xpForNextLevel = xpForNextLevel; }

    public int getXpToNext() { return xpToNext; }
    public void setXpToNext(int xpToNext) { this.xpToNext = xpToNext; }

    public int getProgressPercent() { return progressPercent; }
    public void setProgressPercent(int progressPercent) { this.progressPercent = progressPercent; }

    public long getCompletedQuests() { return completedQuests; }
    public void setCompletedQuests(long completedQuests) { this.completedQuests = completedQuests; }
}