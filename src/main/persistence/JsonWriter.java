package persistence;

import model.Dashboard;
import model.Habit;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

// Represents a writer that writes JSON representation of journal to file
// Note: The structure of this class and all of the methods inside it are
//       largely based off the WorkRoom application provided to us on GitHub.
//       URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination; // this will always be something like "./data/habits"

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of dashboard to file
    public void write(Habit habit) {
        JSONObject json = habit.toJson();
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }

    public void saveDashboard(Dashboard dashboard) {
        List<Habit> allHabits = dashboard.getAllHabits();

        for (Habit habit : allHabits) {
            String name = habit.getTitle();
            String destinationFile = destination + "/" + name + "/" + name + "_Details.json";
            try {
                writer = new PrintWriter(new File(destinationFile));
                write(habit);
                writer.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
