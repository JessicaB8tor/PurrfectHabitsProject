package model;

import java.time.LocalDate;

public class Habit {
    public enum HabitType {
        MAKEABLE, BREAKABLE
    }

    private String title;
    private String purpose;
    private boolean isCompleted;
    private Stats habitStats;
    private HabitType habitType;
    private Gallery awardsGallery;

    public Habit(String title, String purpose, HabitType habitType) {
        this.title = title;
        this.purpose = purpose;
        this.habitType = habitType;
        isCompleted = false;
        LocalDate date = LocalDate.now();
        habitStats = new Stats(date);
        awardsGallery = new Gallery();
    }

    public Habit(String title, String purpose, boolean isCompleted, Stats habitStats, HabitType habitType, Gallery awardsGallery) {
        this.title = title;
        this.purpose = purpose;
        this.isCompleted = isCompleted;
        this.habitStats = habitStats;
        this.habitType = habitType;
        this.awardsGallery = awardsGallery;
    }

    public String getTitle() {
        return title;
    }

    public String getPurpose() {
        return purpose;
    }

    public boolean getCompletionStatus() {
        return isCompleted;
    }

    public Stats getHabitStats() {
        return habitStats;
    }

    public HabitType getHabitType() {
        return habitType;
    }

    public Gallery getAwardsGallery() {
        return awardsGallery;
    }
}


