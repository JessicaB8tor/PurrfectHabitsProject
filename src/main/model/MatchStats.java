package model;

// Represents common stats for a tennis match
public class MatchStats {
    private String score;
    private int aces;
    private int doubleFaults;
    private int winners;
    private int unforcedErrors;

    // EFFECTS: Initializes the stats of a tennis match.
    public MatchStats(String score, int aces, int doubleFaults, int winners, int unforcedErrors) {
        this.score = score;
        this.aces = aces;
        this.doubleFaults = doubleFaults;
        this.winners = winners;
        this.unforcedErrors = unforcedErrors;
    }

    public String getScore() {
        return score;
    }

    public int getAces() {
        return aces;
    }

    public int getDoubleFaults() {
        return doubleFaults;
    }

    public int getWinners() {
        return winners;
    }

    public int getUnforcedErrors() {
        return unforcedErrors;
    }
}
