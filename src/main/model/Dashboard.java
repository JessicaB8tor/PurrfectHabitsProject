package model;

import java.util.ArrayList;
import java.util.List;

// represents a dashboard where the user can look at all their current habits
public class Dashboard {
    private List<HabitToBreak> habitsToBreak;
    private List<HabitToMake> habitsToMake;
    private List<Habit> allHabits;

    public Dashboard() {
        habitsToBreak = new ArrayList<HabitToBreak>();
        habitsToMake = new ArrayList<HabitToMake>();
        allHabits = new ArrayList<Habit>();
    }

    public List<HabitToBreak> getHabitsToBreak() {
        return habitsToBreak;
    }

    public List<HabitToMake> getHabitsToMake() {
        return habitsToMake;
    }

    public List<Habit> getAllHabits() {
        return allHabits;
    }

    public void addHabit(Habit habit, String habitType) {

    }
}
