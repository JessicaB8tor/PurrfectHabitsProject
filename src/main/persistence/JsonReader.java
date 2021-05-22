package persistence;

import model.Dashboard;
import model.MatchDetails;
import model.MatchStats;
import model.TennisMatch;
import model.TennisMatchJournal;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads journal from JSON data stored in file
// Note: The structure of this Class and all of the methods inside it are largely
//       based off the WorkRoom application that was given to us on GitHub.
//       URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
public class JsonReader {
    private String source; // this should be given the path to the habits folder

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads journal from file and returns it;
    //          throws IOException if an error occurs when reading data from file
    public Dashboard read() throws IOException {
        // loop through all the habit folders in the habits folder
        // for each habit folder, go to the





        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseDashboard(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses journal from JSON object and returns it
    private Dashboard parseDashboard(JSONObject jsonObject) {
        Dashboard dashboard = new Dashboard();
        addHabits(dashboard, jsonObject);
        return dashboard;
    }

    // MODIFIES: dashboard
    // EFFECTS: parses habits from JSON object and adds them to dashboard
    private void addHabits(Dashboard dashboard, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("matches");

        for (Object json : jsonArray) {
            JSONObject nextMatch = (JSONObject) json;
            addHabit(dashboard, nextMatch);
        }
    }

    // MODIFIES: journal
    // EFFECTS: parses habit from JSON object and adds it to dashboard
    private void addHabit(Dashboard dashboard, JSONObject jsonObject) {
        MatchDetails matchDetails = getMatchDetails(jsonObject);
        MatchStats matchStats = getMatchStats(jsonObject);
        TennisMatch tennisMatch = new TennisMatch(matchDetails, matchStats);

        journal.addMatch(tennisMatch);
    }

    // EFFECTS: gets the match details from JSON object
    private MatchDetails getMatchDetails(JSONObject jsonObject) {
        String opponent = jsonObject.getString("opponent");
        boolean isWon = jsonObject.getBoolean("isWon");
        String surface = jsonObject.getString("surface");
        int duration = jsonObject.getInt("duration");
        String date = jsonObject.getString("date");

        return new MatchDetails(opponent, isWon, surface, duration, date);
    }

    // EFFECTS: gets the match stats from JSON object
    private MatchStats getMatchStats(JSONObject jsonObject) {
        String score = jsonObject.getString("score");
        int aces = jsonObject.getInt("aces");
        int doubleFaults = jsonObject.getInt("doubleFaults");
        int winners = jsonObject.getInt("winners");
        int unforcedErrors = jsonObject.getInt("unforcedErrors");

        return new MatchStats(score, aces, doubleFaults, winners, unforcedErrors);
    }
}








































