package ui;

import model.MatchDetails;
import model.MatchStats;
import model.TennisMatch;
import model.TennisMatchJournal;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Tennis match journal application
// NOTE: The structure of this Class and many of the methods inside it including JournalApp,
//       runJournal, initialize, displayMenu, and processCommand are largely based off of
//       code in the TellerApp Class in the TellerApp application provided to us on GitHub.
//       URL: https://github.students.cs.ubc.ca/CPSC210/TellerApp
public class JournalApp {
    private static final String JSON_STORE = "./data/journal.json";
    private TennisMatchJournal journal;
    private Scanner input;
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;

    // EFFECTS: runs the journal application
    public JournalApp() throws FileNotFoundException {
        runJournal();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runJournal() {
        boolean keepGoing = true;
        String command = null;

        initialize();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("quit")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("\n<CLOSING THE JOURNAL>");
    }

    // MODIFIES: this
    // EFFECTS: initializes the journal
    private void initialize() {
        journal = new TennisMatchJournal();
        input = new Scanner(System.in);
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\n[TENNIS MATCH JOURNAL]");
        System.out.println("\nChoose from the following commands:\n");
        System.out.println("\tadd --> add a new tennis match to your journal");
        System.out.println("\tdelete --> delete an existing tennis match from your journal");
        System.out.println("\tview --> view all the tennis matches currently in your journal");
        System.out.println("\tratio --> view your current win : loss ratio");
        System.out.println("\tload --> load journal from file");
        System.out.println("\tsave --> save the current journal to file");
        System.out.println("\tquit --> close the application\n\n");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("add")) {
            add();
        } else if (command.equals("delete")) {
            delete();
        } else if (command.equals("view")) {
            viewMatches();
        } else if (command.equals("ratio")) {
            viewRatio();
        } else if (command.equals("load")) {
            loadJournal();
        } else if (command.equals("save")) {
            saveJournal();
        } else {
            System.out.println("<PLEASE ENTER IN A VALID COMMAND>");
        }
    }

    // MODIFIES: this
    // EFFECTS: processes the add command
    private void add() {
        MatchDetails userDetails = getUserDetails();
        MatchStats userStats = getUserStats();

        TennisMatch tm = new TennisMatch(userDetails, userStats);

        journal.addMatch(tm);

        System.out.println("<THE MATCH HAS BEEN ADDED>");
    }

    // EFFECTS: gets the details of the match
    private MatchDetails getUserDetails() {
        System.out.println("<GETTING MATCH DETAILS>");
        System.out.println("\nWho was your opponent? - (First Last)");
        String opponent = input.next() + input.nextLine();
        System.out.println("\nWhat was the outcome of the match? - true = win, false = lose");
        boolean isWon = input.nextBoolean();
        System.out.println("\nWhat surface did you play on? - HARD/CLAY/GRASS");
        String surface = input.next().toLowerCase();
        System.out.println("\nHow long was the match (in minutes)?");
        int duration = input.nextInt();
        System.out.println("\nWhat is the date of this match? - (D/M/YYYY)");
        String date = input.next();

        return new MatchDetails(opponent, isWon, surface, duration, date);
    }

    // EFFECTS: gets the stats of the match
    private MatchStats getUserStats() {
        System.out.println("<GETTING MATCH STATS>");
        System.out.println("\nWhat was the score? - (a-b c-d ...)");
        String score = input.next() + input.nextLine();
        System.out.println("\nHow many aces did you hit?");
        int aces = input.nextInt();
        System.out.println("\nHow many double faults did you hit?");
        int doubleFaults = input.nextInt();
        System.out.println("\nHow many winners did you hit?");
        int winners = input.nextInt();
        System.out.println("\nHow many unforced errors did you hit?");
        int unforcedErrors = input.nextInt();

        return new MatchStats(score, aces, doubleFaults, winners, unforcedErrors);
    }

    // MODIFIES: this
    // EFFECTS: processes the delete command
    private void delete() {
        System.out.println("When did you play this match? (D/M/YYYY)");
        String date = input.next();
        System.out.println("\nWho was your opponent? (First Last)");
        String opponent = input.next();
        opponent += input.nextLine();
        boolean isFound = false;

        for (TennisMatch tm : journal.getJournal()) {
            String d = tm.getMatchDetails().getDate();
            String o = tm.getMatchDetails().getOpponent();

            if (d.equals(date) && o.equals(opponent)) {
                journal.deleteMatch(tm);
                System.out.println("<THE MATCH HAS BEEN DELETED>");
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("<COULDN'T FIND ANY MATCH ON " + date + " AGAINST " + opponent + ">");
        }
    }

    // EFFECTS: processes the view command
    private void viewMatches() {
        System.out.println("<VIEWING ALL MATCHES>");
        String matches = journal.viewJournal();
        System.out.println(matches);
    }

    // EFFECTS: processes the ratio command
    private void viewRatio() {
        System.out.println("<VIEWING CURRENT WIN : LOSS RATIO>\n");
        String ratio = journal.viewWinLossRatio();
        System.out.println(ratio);
    }

    // MODIFIES: this
    // EFFECTS: loads journal from file
    private void loadJournal() {
        try {
            journal = jsonReader.read();
            System.out.println("<LOADED JOURNAL FROM FILE: " + JSON_STORE + ">");
        } catch (IOException e) {
            System.out.println("<UNABLE TO READ FROM FILE: " + JSON_STORE + ">");
        }
    }

    // EFFECTS: saves current journal to file
    private void saveJournal() {
        try {
            jsonWriter.open();
            jsonWriter.write(journal);
            jsonWriter.close();
            System.out.println("<SAVED JOURNAL TO FILE: " + JSON_STORE + ">");
        } catch (FileNotFoundException e) {
            System.out.println("<UNABLE TO WRITE TO FILE: " + JSON_STORE + ">");
        }
    }
}






























