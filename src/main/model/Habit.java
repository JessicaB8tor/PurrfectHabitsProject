package model;

public abstract class Habit {
    String name;
    Note purpose;
    Stats habitStats; // encapsulates current streak, longest streak, start date, etc (more to come later perhaps)
}
