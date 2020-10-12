package model;

// Represents the details of a tennis match
public class MatchDetails {
    private String opponent;
    private boolean isWon;
    private String surface;
    private int duration;
    private String date;

    // EFFECTS: Initializes the details of a tennis match.
    public MatchDetails(String opponent, boolean isWon, String surface, int duration, String date) {
        this.opponent = opponent;
        this.isWon = isWon;
        this.surface = surface;
        this.duration = duration;
        this.date = date;
    }

    public String getOpponent() {
        return opponent;
    }

    public boolean getIsWon() {
        return isWon;
    }

    public String getSurface() {
        return surface;
    }

    public int getDuration() {
        return duration;
    }

    public String getDate() {
        return date;
    }


}
