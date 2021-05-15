package model;

import java.time.LocalDate;

public class Stats {
    private int currentStreak;
    private int longestStreak;
    private LocalDate dateCreated;
    private int numDaysSinceStarted;
    private int numSetbacks;

    public Stats(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
        currentStreak = 0;
        longestStreak = 0;
        numDaysSinceStarted = 0;
        numSetbacks = 0;
    }

    public int getCurrentStreak() {
        return currentStreak;
    }

    public int getLongestStreak() {
        return longestStreak;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public int getNumDaysSinceStarted() {
        return numDaysSinceStarted;
    }

    public int getNumSetbacks() {
        return numSetbacks;
    }

    private void incrementCurrentStreak() {
        currentStreak++;
    }

    private void resetCurrentStreak() {
        currentStreak = 0;
    }

    private void incrementLongestStreak() {
        longestStreak++;
    }

    private void updateNumDaysSinceStarted() {
        numDaysSinceStarted++;
    }

    private void updateNumSetbacks() {
        numSetbacks++;
    }

}
