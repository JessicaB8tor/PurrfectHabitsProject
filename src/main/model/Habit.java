package model;

public abstract class Habit {
    public enum HabitType {
        MAKEABLE, BREAKABLE
    }

    private String title;
    private String purpose;
    private boolean isCompleted;
    private Stats habitStats; // encapsulates current streak, longest streak, start date, etc (to be updated)
    HabitType habitType;


    public Habit(String title, String purpose, HabitType habitType) {
        this.title = title;
        this.purpose = purpose;
        this.habitType = habitType;
        isCompleted = false;
        habitStats = new Stats(); // maybe pass in the date or something to this constructor
    }
}


