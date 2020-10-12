package model;

// Represents the statistics of a tennis match
public class TennisMatch {
    private MatchDetails matchDetails;
    private MatchStats matchStats;
    // private String notes;

    public TennisMatch(MatchDetails md, MatchStats ms) {
        matchDetails = md;
        matchStats = ms;
        // notes = "";
    }

    public MatchDetails getMatchDetails() {
        return matchDetails;
    }

    public MatchStats getMatchStats() {
        return matchStats;
    }

//    public String getNotes() {
//        return notes;
//    }

    public void setMatchDetails(MatchDetails md) {
        this.matchDetails = md;
    }

    public void setMatchStats(MatchStats ms) {
        this.matchStats = ms;
    }














}
