package ui.controller;

import model.MatchDetails;
import model.MatchStats;
import model.TennisMatch;
import model.TennisMatchJournal;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.viewer.AddPage;
import ui.viewer.DeletePage;
import ui.viewer.LaunchPage;
import ui.viewer.RatioPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class JournalAppGui implements ActionListener {
    private static final String JSON_STORE = "./data/journal.json";
    private TennisMatchJournal journal;
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;
    private LaunchPage launchPage;
    private AddPage addPage;
    private DeletePage deletePage;
    private RatioPage ratioPage;
    private JOptionPane optionPane;

    // EFFECTS: runs the journal application
    public JournalAppGui() {
        initialize();
    }

    private void initialize() {
        journal = new TennisMatchJournal();
        jsonReader = new JsonReader(JSON_STORE);
        jsonWriter = new JsonWriter(JSON_STORE);
        launchPage = new LaunchPage(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == launchPage.getAddButton()) {
            handleAdd();
        } else if (e.getSource() == launchPage.getDeleteButton()) {
            handleDelete();
        } else if (e.getSource() == launchPage.getViewButton()) {
            handleView();
        } else if (e.getSource() == launchPage.getRatioButton()) {
            handleRatio();
        } else if (e.getSource() == launchPage.getLoadButton()) {
            handleLoad();
        } else if (e.getSource() == launchPage.getSaveButton()) {
            handleSave();
        } else if (addPage != null && e.getSource() == addPage.getSubmitButton()) {
            add();
        } else if (addPage != null && e.getSource() == addPage.getBackButton()) {
            handleAddBack();
        } else if (deletePage != null && e.getSource() == deletePage.getSubmitButton()) {
            delete();
        } else if (deletePage != null && e.getSource() == deletePage.getBackButton()) {
            handleDeleteBack();
        } else if (ratioPage != null && e.getSource() == ratioPage.getBackButton()) {
            handleRatioBack();
        }
    }

    private void handleAdd() {
        launchPage.dispose();
        addPage = new AddPage(this);
    }

    private void add() {
        MatchDetails userDetails = getSubmittedDetails();
        MatchStats userStats = getSubmittedStats();

        TennisMatch tm = new TennisMatch(userDetails, userStats);

        if (!journal.containsMatch(tm)) {
            journal.addMatch(tm);
            displayAddError();
        } else {
            displayAddConfirmation();
        }
    }

    private MatchDetails getSubmittedDetails() {
        int selectedResult = addPage.getResultOptions().getSelectedIndex();
        int selectedSurface = addPage.getSurfaceOptions().getSelectedIndex();

        String opponent = addPage.getOpponentField().toString();
        boolean isWon = convertResult(selectedResult);
        String surface = convertSurface(selectedSurface);
        int duration = Integer.parseInt(addPage.getDurationField().toString());
        String date = addPage.getDateField().toString();

        return new MatchDetails(opponent, isWon, surface, duration, date);
    }

    private boolean convertResult(int selectedResult) {
        return selectedResult == 1;
    }

    private String convertSurface(int selectedSurface) {
        if (selectedSurface == 1) {
            return "Hard";
        } else if (selectedSurface == 2) {
            return "Grass";
        } else {
            return "Clay";
        }
    }

    private MatchStats getSubmittedStats() {
        String score = addPage.getScoreField().toString();
        int aces = Integer.parseInt(addPage.getAcesField().toString());
        int doubleFaults = Integer.parseInt(addPage.getDoubleFaultsField().toString());
        int winners = Integer.parseInt(addPage.getWinnersField().toString());
        int unforcedErrors = Integer.parseInt(addPage.getUnforcedErrorsField().toString());

        return new MatchStats(score, aces, doubleFaults, winners, unforcedErrors);
    }

    private void displayAddError() {
        optionPane = new JOptionPane();
        JOptionPane.showMessageDialog(null,
                "The journal already contains this match",
                "Tennis Match Journal",
                JOptionPane.ERROR_MESSAGE);
    }

    private void displayAddConfirmation() {
        optionPane = new JOptionPane();
        JOptionPane.showMessageDialog(null,
                "The match has been successfully added",
                "Tennis Match Journal",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleAddBack() {
        addPage.dispose();
        launchPage = new LaunchPage(this);
    }

    private void handleDelete() {
        deletePage = new DeletePage(this);
    }

    private void handleView() {
        System.out.println("VIEW!");
    }

    private void handleRatio() {
        launchPage.dispose();
        ratioPage = new RatioPage(this, journal.viewWinLossRatio());
    }

    private void handleLoad() {
        try {
            journal = jsonReader.read();
            showLoadingConfirmation();
        } catch (IOException e) {
            showLoadingFailure();
        }
    }

    private void showLoadingConfirmation() {
        optionPane = new JOptionPane();
        JOptionPane.showMessageDialog(null,
                "Your journal has been loaded",
                "Tennis Match Journal",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void showLoadingFailure() {
        optionPane = new JOptionPane();
        JOptionPane.showMessageDialog(null,
                "An error occurred - the journal was not loaded",
                "Tennis Match Journal",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleSave() {
        try {
            jsonWriter.open();
            jsonWriter.write(journal);
            jsonWriter.close();
            showSaveConfirmation();
        } catch (FileNotFoundException e) {
            showSaveFailure();
        }
    }

    private void showSaveConfirmation() {
        optionPane = new JOptionPane();
        JOptionPane.showMessageDialog(null,
                "You journal has been saved",
                "Tennis Match Journal",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void showSaveFailure() {
        optionPane = new JOptionPane();
        JOptionPane.showMessageDialog(null,
                "An error occurred - the journal was not saved",
                "Tennis Match Journal",
                JOptionPane.ERROR_MESSAGE);
    }

    private void handleRatioBack() {
        ratioPage.dispose();
        launchPage = new LaunchPage(this);
    }

    private void delete() {
        String opponent = deletePage.getOpponentField().toString();
        String date = deletePage.getDateField().toString();

        boolean isFound = false;

        for (TennisMatch tm : journal.getJournal()) {
            String d = tm.getMatchDetails().getDate();
            String o = tm.getMatchDetails().getOpponent();

            if (d.equals(date) && o.equals(opponent)) {
                journal.deleteMatch(tm);
                showDeletionConfirmation();
                isFound = true;
                break;
            }
        }

        if (!isFound) {
            showDeletionError();
        }
    }

    private void showDeletionConfirmation() {
        optionPane = new JOptionPane();
        JOptionPane.showMessageDialog(null,
                "The specified match has been successfully deleted",
                "Tennis Match Journal",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void showDeletionError() {
        optionPane = new JOptionPane();
        JOptionPane.showMessageDialog(null,
                "Can't find the specified match",
                "Tennis Match Journal",
                JOptionPane.ERROR_MESSAGE);
    }

    private void handleDeleteBack() {
        deletePage.dispose();
    }
}
