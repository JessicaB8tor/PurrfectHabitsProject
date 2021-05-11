package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.Objects;
// YANG WAS HERE
// Yang is so cool, and Jess is not cool.
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TennisMatch)) {
            return false;
        }
        TennisMatch that = (TennisMatch) o;
        return Objects.equals(getMatchDetails(), that.getMatchDetails())
                &&
                Objects.equals(getMatchStats(), that.getMatchStats());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMatchDetails(), getMatchStats());
    }
}
