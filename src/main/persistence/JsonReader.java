package persistence;

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Stream;

// Represents a reader that reads journal from JSON data stored in file
// Note: The structure of this Class and all of the methods inside it are largely
//       based off the WorkRoom application that was given to us on GitHub.
//       URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public class JsonReader {
    private String source; // should be "./data/habits";

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads journal from file and returns it;
    //          throws IOException if an error occurs when reading data from file
    public Dashboard read() throws IOException {
        File habitFolder = new File(source);
        File[] habits = habitFolder.listFiles();
        Dashboard dashboard = new Dashboard();

        for (File habit : habits) {
            String habitName = habit.getName();
            String jsonFilePath = source + "/" + habitName + "/" + habitName + "_Details.json";
            String jsonData = readFile(jsonFilePath);
            JSONObject jsonObject = new JSONObject(jsonData);
            Habit parsedHabit = parseHabit(jsonObject);
            dashboard.addHabitJson(parsedHabit);
        }

        return dashboard;
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // TODO: refactor this so it's not so long
    // EFFECTS: parses habit from JSON object and returns it
    private Habit parseHabit(JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        String purpose = jsonObject.getString("purpose");
        boolean isCompleted = jsonObject.getBoolean("isCompleted");

        int currentStreak = jsonObject.getJSONObject("stats").getInt("currentStreak");
        int longestStreak = jsonObject.getJSONObject("stats").getInt("longestStreak");
        LocalDate date = LocalDate.parse(jsonObject.getJSONObject("stats").getString("dateCreated"));
        int numDaysSinceStarted = jsonObject.getJSONObject("stats").getInt("numDaysSinceStarted");
        int numSetBacks = jsonObject.getJSONObject("stats").getInt("numSetBacks");
        Stats stats = new Stats(currentStreak, longestStreak, date, numDaysSinceStarted, numSetBacks);

        Habit.HabitType habitType = Habit.HabitType.valueOf(jsonObject.getString("habitType"));

        ArrayList<Award> felineGoodAwards = new ArrayList<Award>();
        ArrayList<Award> pawsomeAchievementAwards = new ArrayList<Award>();
        ArrayList<Award> allAwards = new ArrayList<Award>();
        ArrayList<Award> bestStreakAwards = new ArrayList<Award>();
        JSONArray felineArray = jsonObject.getJSONObject("gallery").getJSONArray("felineGoodAwards");
        JSONArray pawsomeArray = jsonObject.getJSONObject("gallery").getJSONArray("pawsomeAchievementAwards");
        JSONArray allAwardsArray = jsonObject.getJSONObject("gallery").getJSONArray("allAwards");
        JSONArray bestStreakArray = jsonObject.getJSONObject("gallery").getJSONArray("bestStreakAwards");
        for (Object object : felineArray) {
            JSONObject obj = (JSONObject) object;
            Award award = new Award(LocalDate.parse(obj.getString("dateReceived")), Award.AwardType.valueOf(obj.getString("awardType")));
            felineGoodAwards.add(award);
        }
        for (Object object : pawsomeArray) {
            JSONObject obj = (JSONObject) object;
            Award award = new Award(LocalDate.parse(obj.getString("dateReceived")), Award.AwardType.valueOf(obj.getString("awardType")));
            pawsomeAchievementAwards.add(award);
        }
        for (Object object : allAwardsArray) {
            JSONObject obj = (JSONObject) object;
            Award award = new Award(LocalDate.parse(obj.getString("dateReceived")), Award.AwardType.valueOf(obj.getString("awardType")));
            allAwards.add(award);
        }
        for (Object object : bestStreakArray) {
            JSONObject obj = (JSONObject) object;
            Award award = new Award(LocalDate.parse(obj.getString("dateReceived")), Award.AwardType.valueOf(obj.getString("awardType")));
            bestStreakAwards.add(award);
        }
        Gallery gallery = new Gallery(felineGoodAwards, pawsomeAchievementAwards, allAwards, bestStreakAwards);

        return new Habit(title, purpose, isCompleted, stats, habitType, gallery);
    }
}








































