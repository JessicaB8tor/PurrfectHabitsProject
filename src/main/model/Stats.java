package model;

// TODO: figure out date stuff later

public class Stats {
    int currentStreak;
    int longestStreak;
    Date startDate;

    public Stats(Date startDate) {
        this.startDate = startDate;
        currentStreak = 0;
        longestStreak = 0;
    }
}
