//package ui.controller;
//
//import model.MatchDetails;
//import model.MatchStats;
//import model.TennisMatch;
//import model.TennisMatchJournal;
//import model.exceptions.InvalidIndexException;
//import persistence.JsonReader;
//import persistence.JsonWriter;
//import ui.viewer.*;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//// Tennis match journal application
//public class JournalAppGui implements ActionListener {
//    private static final String JSON_STORE = "./data/habits.json";
//    private TennisMatchJournal journal;
//    private JsonReader jsonReader;
//    private JsonWriter jsonWriter;
//    private LaunchPage launchPage;
//    private AddPage addPage;
//    private DeletePage deletePage;
//    private ViewPage viewPage;
//    private StatsPage statsPage;
//    private RatioPage ratioPage;
//
//    // EFFECTS: runs the journal application
//    public JournalAppGui() {
//        initialize();
//    }
//
//    // MODIFIES: this
//    // EFFECTS: initializes the journal
//    private void initialize() {
//        journal = new TennisMatchJournal();
//        jsonReader = new JsonReader(JSON_STORE);
//        jsonWriter = new JsonWriter(JSON_STORE);
//        launchPage = new LaunchPage(this);
//    }
//
//    // MODIFIES: this
//    // EFFECTS: listens for all events that occur as the application
//    //          is running
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        launchPageListener(e);
//        addPageListener(e);
//        deletePageListener(e);
//        viewPageListener(e);
//        ratioPageListener(e);
//        statsPageListener(e);
//    }
//
//    // =============================== LISTENERS ===============================
//
//    // MODIFIES: this
//    // EFFECTS: listens for events in the LaunchPage
//    private void launchPageListener(ActionEvent e) {
//        if (e.getSource() == launchPage.getAddButton()) {
//            handleLaunchAdd();
//        }
//        if (e.getSource() == launchPage.getDeleteButton()) {
//            handleLaunchDelete();
//        }
//        if (e.getSource() == launchPage.getViewButton()) {
//            handleLaunchView();
//        }
//        if (e.getSource() == launchPage.getRatioButton()) {
//            handleLaunchRatio();
//        }
//        if (e.getSource() == launchPage.getLoadButton()) {
//            handleLaunchLoad();
//        }
//        if (e.getSource() == launchPage.getSaveButton()) {
//            handleLaunchSave();
//        }
//        if (e.getSource() == launchPage.getQuitButton()) {
//            handleLaunchQuit();
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: listens for events in the add page
//    private void addPageListener(ActionEvent e) {
//        if (addPage != null && e.getSource() == addPage.getSubmitButton()) {
//            handleAddAdd();
//        } else if (addPage != null && e.getSource() == addPage.getBackButton()) {
//            handleAddBack();
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: listens for events in the delete page
//    private void deletePageListener(ActionEvent e) {
//        if (deletePage != null && e.getSource() == deletePage.getSubmitButton()) {
//            handleDeleteDelete();
//        }
//        if (deletePage != null && e.getSource() == deletePage.getBackButton()) {
//            handleDeleteBack();
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: listens for events in the view page
//    private void viewPageListener(ActionEvent e) {
//        if (viewPage != null && e.getSource() == viewPage.getBackButton()) {
//            handleViewBack();
//        }
//        if (viewPage != null && e.getSource() == viewPage.getSelectButton()) {
//            handleViewSelect();
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: listens for events in the ratio page
//    private void ratioPageListener(ActionEvent e) {
//        if (ratioPage != null && e.getSource() == ratioPage.getBackButton()) {
//            handleRatioBack();
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: listens for events in the stats page
//    private void statsPageListener(ActionEvent e) {
//        if (statsPage != null && e.getSource() == statsPage.getBackButton()) {
//            handleStatsBack();
//        }
//    }
//
//    // =============================== LAUNCH PAGE HANDLERS ===============================
//
//    // MODIFIES: this
//    // EFFECTS: creates an add page
//    private void handleLaunchAdd() {
//        addPage = new AddPage(this);
//    }
//
//    // MODIFIES: this
//    // EFFECTS: creates a new delete page
//    private void handleLaunchDelete() {
//        deletePage = new DeletePage(this);
//    }
//
//    // MODIFIES: this
//    // EFFECTS: closes the launch page and creates the view page
//    private void handleLaunchView() {
//        launchPage.dispose();
//        viewPage = new ViewPage(this, journal);
//    }
//
//    // MODIFIES: this
//    // EFFECTS: closes the launch page and creates the ratio page
//    private void handleLaunchRatio() {
//        launchPage.dispose();
//        ratioPage = new RatioPage(this, journal.viewWinLossRatio());
//    }
//
//    // MODIFIES: this
//    // EFFECTS: loads journal from file
//    private void handleLaunchLoad() {
//        try {
//            journal = jsonReader.read();
//            showLoadingConfirmation();
//        } catch (IOException e) {
//            showLoadingFailure();
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: saves the journal to file
//    private void handleLaunchSave() {
//        try {
//            jsonWriter.open();
//            jsonWriter.write(journal);
//            jsonWriter.close();
//            showSaveConfirmation();
//        } catch (FileNotFoundException e) {
//            showSaveFailure();
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: closes the launch page (quits the program)
//    private void handleLaunchQuit() {
//        launchPage.dispose();
//    }
//
//    // =============================== ADD PAGE HANDLERS ===============================
//
//    // MODIFIES: this
//    // EFFECTS: creates a match from the user's input and adds it into the journal
//    //          if the journal does not already contain the match
//    //          (doesn't add if the journal already contains the match)
//    private void handleAddAdd() {
//        MatchDetails userDetails = getSubmittedDetails();
//        MatchStats userStats = getSubmittedStats();
//
//        TennisMatch tm = new TennisMatch(userDetails, userStats);
//
//        if (!journal.containsMatch(tm)) {
//            journal.addMatch(tm);
//            displayAddConfirmation();
//            addPage.dispose();
//        } else {
//            displayAddError();
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: closes the add page and returns the user to the launch page
//    private void handleAddBack() {
//        addPage.dispose();
//    }
//
//    // =============================== DELETE PAGE HANDLERS ===============================
//
//    // MODIFIES: this
//    // EFFECTS: deleted the specified match from the journal
//    //          (does nothing if journal does not contain the match)
//    private void handleDeleteDelete() {
//        String opponent = deletePage.getOpponentField().getText();
//        String date = deletePage.getDateField().getText();
//
//        boolean isFound = false;
//
//        for (TennisMatch tm : journal.getJournal()) {
//            String d = tm.getMatchDetails().getDate();
//            String o = tm.getMatchDetails().getOpponent();
//
//            if (d.equals(date) && o.equals(opponent)) {
//                journal.deleteMatch(tm);
//                showDeletionConfirmation();
//                deletePage.dispose();
//                isFound = true;
//                break;
//            }
//        }
//
//        if (!isFound) {
//            showDeletionError();
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: closes the delete page and returns the user to the launch page
//    private void handleDeleteBack() {
//        deletePage.dispose();
//    }
//
//    // =============================== VIEW PAGE HANDLERS ===============================
//
//    // MODIFIES: this
//    // EFFECTS: creates a stats page displaying the stats of the selected match
//    private void handleViewSelect() {
//        TennisMatch match;
//
//        JList<String> list = viewPage.getViewPanel();
//        int index = list.getSelectedIndex();
//
//        try {
//            match = journal.getMatchAt(index);
//            statsPage = new StatsPage(this, match);
//        } catch (InvalidIndexException e) {
//            JOptionPane.showMessageDialog(null,
//                    "Please select a valid match",
//                    "Tennis Match Journal",
//                    JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: closes the view page and returns the user to the launch page
//    private void handleViewBack() {
//        viewPage.dispose();
//        launchPage = new LaunchPage(this);
//    }
//
//    // =============================== STATS PAGE HANDLERS ===============================
//
//    private void handleStatsBack() {
//        statsPage.dispose();
//    }
//
//    // =============================== RATIO PAGE HANDLERS ===============================
//
//    // MODIFIES: this
//    // EFFECTS: closes the ratio page and returns the user to the launch page
//    private void handleRatioBack() {
//        ratioPage.dispose();
//        launchPage = new LaunchPage(this);
//    }
//
//    // =============================== MISCELLANEOUS HELPERS ===============================
//
//    // EFFECTS: gets submitted match details from add page and returns
//    //          a match details object consisting of those details
//    private MatchDetails getSubmittedDetails() {
//        int selectedResult = addPage.getResultOptions().getSelectedIndex();
//        int selectedSurface = addPage.getSurfaceOptions().getSelectedIndex();
//
//        String opponent = addPage.getOpponentField().getText();
//        boolean isWon = convertResult(selectedResult);
//        String surface = convertSurface(selectedSurface);
//        int duration = Integer.parseInt(addPage.getDurationField().getText());
//        String date = addPage.getDateField().getText();
//
//        return new MatchDetails(opponent, isWon, surface, duration, date);
//    }
//
//    // EFFECTS: converts the selected result into a boolean that represents
//    //          the outcome of the match
//    private boolean convertResult(int selectedResult) {
//        return selectedResult == 1;
//    }
//
//    // EFFECTS: converts the selected surface into a string that represents
//    //          the surface that the match was played on
//    private String convertSurface(int selectedSurface) {
//        if (selectedSurface == 1) {
//            return "Hard";
//        } else if (selectedSurface == 2) {
//            return "Grass";
//        } else {
//            return "Clay";
//        }
//    }
//
//    // EFFECTS: gets the submitted match stats from the add page and returns
//    //          a match stats object consisting of those stats
//    private MatchStats getSubmittedStats() {
//        String score = addPage.getScoreField().getText();
//        int aces = Integer.parseInt(addPage.getAcesField().getText());
//        int doubleFaults = Integer.parseInt(addPage.getDoubleFaultsField().getText());
//        int winners = Integer.parseInt(addPage.getWinnersField().getText());
//        int unforcedErrors = Integer.parseInt(addPage.getUnforcedErrorsField().getText());
//
//        return new MatchStats(score, aces, doubleFaults, winners, unforcedErrors);
//    }
//
//    // EFFECTS: displays an adding error message to user
//    private void displayAddError() {
//        JOptionPane.showMessageDialog(null,
//                "The journal already contains this match",
//                "Tennis Match Journal",
//                JOptionPane.ERROR_MESSAGE);
//    }
//
//    // EFFECTS: displays an adding confirmation message to user
//    private void displayAddConfirmation() {
//        JOptionPane.showMessageDialog(null,
//                "The match has been successfully added",
//                "Tennis Match Journal",
//                JOptionPane.INFORMATION_MESSAGE);
//    }
//
//    // EFFECTS: displays a loading confirmation message
//    private void showLoadingConfirmation() {
//        JOptionPane.showMessageDialog(null,
//                "Your journal has been loaded",
//                "Tennis Match Journal",
//                JOptionPane.INFORMATION_MESSAGE);
//    }
//
//    // EFFECTS: displays a loading failure message
//    private void showLoadingFailure() {
//        JOptionPane.showMessageDialog(null,
//                "An error occurred - the journal was not loaded",
//                "Tennis Match Journal",
//                JOptionPane.INFORMATION_MESSAGE);
//    }
//
//    // EFFECTS: displays a saving confirmation message
//    private void showSaveConfirmation() {
//        JOptionPane.showMessageDialog(null,
//                "You journal has been saved",
//                "Tennis Match Journal",
//                JOptionPane.INFORMATION_MESSAGE);
//    }
//
//    // EFFECTS: displays a saving failure message
//    private void showSaveFailure() {
//        JOptionPane.showMessageDialog(null,
//                "An error occurred - the journal was not saved",
//                "Tennis Match Journal",
//                JOptionPane.ERROR_MESSAGE);
//    }
//
//    // EFFECTS: displays a deleting confirmation message
//    private void showDeletionConfirmation() {
//        JOptionPane.showMessageDialog(null,
//                "The specified match has been successfully deleted",
//                "Tennis Match Journal",
//                JOptionPane.INFORMATION_MESSAGE);
//    }
//
//    // EFFECTS: displays a deleting error message
//    private void showDeletionError() {
//        JOptionPane.showMessageDialog(null,
//                "Can't find the specified match",
//                "Tennis Match Journal",
//                JOptionPane.ERROR_MESSAGE);
//    }
//}
