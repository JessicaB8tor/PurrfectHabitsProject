package model;

// Represents the statistics of a tennis match
public class TennisMatch {
    private MatchDetails matchDetails;
    private MatchStats matchStats;
    private String notes;

    public TennisMatch(MatchDetails md, MatchStats ms) {
        matchDetails = md;
        matchStats = ms;
        notes = "";
    }

    public MatchDetails getMatchDetails() {
        return matchDetails;
    }

    public MatchStats getMatchStats() {
        return matchStats;
    }














}
