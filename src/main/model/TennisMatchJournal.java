package model;

import java.util.ArrayList;
import java.util.List;

// Represents a journal containing tennis matches
public class TennisMatchJournal {
    private List<TennisMatch> journal;

    // EFFECTS: Instantiates a TennisMatchJournal as an empty ArrayList
    public TennisMatchJournal() {
        journal = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds the given tennis match into the journal; do nothing if it has already
    //          been added
    public void addMatch(TennisMatch match) {
        if (!journal.contains(match)) {
            journal.add(match);
        }
    }

    // EFFECTS: return true if match is in the journal; otherwise, return false
    public boolean containsMatch(TennisMatch match) {
        return journal.contains(match);
    }

    // EFFECTS: return the number of matches in the Journal
    public int journalLength() {
        return journal.size();
    }

    // MODIFIES: this
    // EFFECTS: deletes the given tennis match from the journal; does nothing if journal
    //          does not contain the given tennis match
    public void deleteMatch(TennisMatch match) {
        journal.remove(match);
    }

    // EFFECTS: prints out a list of all the tennis matches in the journal;
    //          if journal is empty, prints out a warning to the user
    public String viewJournal() {
        if (journal.isEmpty()) {
            return viewJournalEmpty();
        } else {
            return viewJournalNotEmpty();
        }
    }

    // EFFECTS: prints out a warning to the user telling them that their
    //          journal is empty
    private String viewJournalEmpty() {
        return "<YOUR JOURNAL IS EMPTY>";
    }

    // EFFECTS: prints out a list of all the tennis matches in the journal
    private String viewJournalNotEmpty() {
        StringBuilder result = new StringBuilder();

        for (TennisMatch match : journal) {
            String opponent = match.getMatchDetails().getOpponent();
            String isWon = (match.getMatchDetails().getIsWon()) ? "WIN" : "LOSS";
            String surface = match.getMatchDetails().getSurface().toUpperCase();
            String duration = match.getMatchDetails().getDuration() + " minutes";
            String date = match.getMatchDetails().getDate();
            String score = match.getMatchStats().getScore();
            int aces = match.getMatchStats().getAces();
            int doubleFaults = match.getMatchStats().getDoubleFaults();
            int winners = match.getMatchStats().getWinners();
            int unforcedErrors = match.getMatchStats().getUnforcedErrors();

            result.append("\n<DETAILS>")
                    .append("\nOpponent: ").append(opponent).append("\nOutcome: ").append(isWon)
                    .append("\nSurface: ").append(surface).append("\nDuration: ").append(duration)
                    .append("\nDate: ").append(date).append("\n<STATS>").append("\nScore: ").append(score)
                    .append("\nAces: ").append(aces).append("\nDouble Faults: ").append(doubleFaults)
                    .append("\nWinners: ").append(winners).append("\nUnforced Errors: ").append(unforcedErrors)
                    .append("\n");
        }
        return result.toString();
    }
}

































