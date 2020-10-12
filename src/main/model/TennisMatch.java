package model;

// Represents the details and statistics of a tennis match
public class TennisMatch {
    private MatchDetails matchDetails;
    private MatchStats matchStats;

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
}
