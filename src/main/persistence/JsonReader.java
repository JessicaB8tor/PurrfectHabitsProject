package persistence;

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
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads journal from file and returns it;
    //          throws IOException if an error occurs when reading data from file
    public TennisMatchJournal read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseJournal(jsonObject);
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
    private TennisMatchJournal parseJournal(JSONObject jsonObject) {
        TennisMatchJournal journal = new TennisMatchJournal();
        addMatches(journal, jsonObject);
        return journal;
    }

    // MODIFIES: journal
    // EFFECTS: parses matches from JSON object and adds them to journal
    private void addMatches(TennisMatchJournal journal, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("matches");

        for (Object json : jsonArray) {
            JSONObject nextMatch = (JSONObject) json;
            addMatch(journal, nextMatch);
        }
    }

    // MODIFIES: journal
    // EFFECTS: parses match from JSON object and adds it to journal
    private void addMatch(TennisMatchJournal journal, JSONObject jsonObject) {
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








































