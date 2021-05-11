package model;

import java.util.Objects;
// YANG WAS HERE
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MatchStats)) {
            return false;
        }
        MatchStats that = (MatchStats) o;
        return getAces() == that.getAces()
                &&
                getDoubleFaults() == that.getDoubleFaults()
                &&
                getWinners() == that.getWinners()
                &&
                getUnforcedErrors() == that.getUnforcedErrors()
                &&
                Objects.equals(getScore(), that.getScore());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getScore(), getAces(), getDoubleFaults(), getWinners(), getUnforcedErrors());
    }
}
