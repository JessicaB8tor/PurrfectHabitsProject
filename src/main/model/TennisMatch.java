package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents the details and statistics of a tennis match
// Note: The toJson() method in this class is largely based on the
//       method with the same name found in the Thingy class in the
//       WorkRoom application provided to us on GitHub.
public class TennisMatch implements Writable {
    private MatchDetails matchDetails;
    private MatchStats matchStats;

    // EFFECTS: initializes a tennis match; sets up its details and stats
    public TennisMatch(MatchDetails md, MatchStats ms) {
        matchDetails = md;
        matchStats = ms;
    }

    public MatchDetails getMatchDetails() {
        return matchDetails;
    }

    public MatchStats getMatchStats() {
        return matchStats;
    }

    @Override
    // EFFECTS: returns tennis match as a JSON object
    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        json.put("opponent", matchDetails.getOpponent());
        json.put("isWon", matchDetails.getIsWon());
        json.put("surface", matchDetails.getSurface());
        json.put("duration", matchDetails.getDuration());
        json.put("date", matchDetails.getDate());

        json.put("score", matchStats.getScore());
        json.put("aces", matchStats.getAces());
        json.put("doubleFaults", matchStats.getDoubleFaults());
        json.put("winners", matchStats.getWinners());
        json.put("unforcedErrors", matchStats.getUnforcedErrors());

        return json;
    }
}
