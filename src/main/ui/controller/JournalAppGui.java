package ui.controller;

import model.MatchDetails;
import model.MatchStats;
import model.TennisMatch;
import model.TennisMatchJournal;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.viewer.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JournalAppGui implements ActionListener {
    private static final String JSON_STORE = "./data/journal.json";
    private TennisMatchJournal journal;
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;
    private LaunchPage launchPage;
    private AddPage addPage;
    private DeletePage deletePage;
    private ViewPage viewPage;
    private RatioPage ratioPage;

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
        launchPageHandler(e);
        addPageHandler(e);
        deletePageHandler(e);
        viewPageHandler(e);
        ratioPageHandler(e);
    }

    private void launchPageHandler(ActionEvent e) {
        if (e.getSource() == launchPage.getAddButton()) {
            handleAdd();
        }
        if (e.getSource() == launchPage.getDeleteButton()) {
            handleDelete();
        }
        if (e.getSource() == launchPage.getViewButton()) {
            handleView();
        }
        if (e.getSource() == launchPage.getRatioButton()) {
            handleRatio();
        }
        if (e.getSource() == launchPage.getLoadButton()) {
            handleLoad();
        }
        if (e.getSource() == launchPage.getSaveButton()) {
            handleSave();
        }
    }

    private void addPageHandler(ActionEvent e) {
        if (addPage != null && e.getSource() == addPage.getSubmitButton()) {
            add();
        } else if (addPage != null && e.getSource() == addPage.getBackButton()) {
            handleAddBack();
        }
    }

    private void deletePageHandler(ActionEvent e) {
        if (deletePage != null && e.getSource() == deletePage.getSubmitButton()) {
            delete();
        }
        if (deletePage != null && e.getSource() == deletePage.getBackButton()) {
            handleDeleteBack();
        }
    }

    private void viewPageHandler(ActionEvent e) {
        if (viewPage != null && e.getSource() == viewPage.getBackButton()) {
            handleViewBack();
        }
        if (viewPage != null && e.getSource() == viewPage.getSelectButton()) {
            select();
        }
    }

    private void handleViewBack() {
        viewPage.dispose();
        launchPage = new LaunchPage(this);
    }

    private void select() {

    }

    private void ratioPageHandler(ActionEvent e) {
        if (ratioPage != null && e.getSource() == ratioPage.getBackButton()) {
            handleRatioBack();
        }
    }

    private void handleAdd() {
        addPage = new AddPage(this);
    }

    private void add() {
        MatchDetails userDetails = getSubmittedDetails();
        MatchStats userStats = getSubmittedStats();

        TennisMatch tm = new TennisMatch(userDetails, userStats);

        if (!journal.containsMatch(tm)) {
            journal.addMatch(tm);
            displayAddConfirmation();
            addPage.dispose();
        } else {
            displayAddError();
        }
    }

    private MatchDetails getSubmittedDetails() {
        int selectedResult = addPage.getResultOptions().getSelectedIndex();
        int selectedSurface = addPage.getSurfaceOptions().getSelectedIndex();

        String opponent = addPage.getOpponentField().getText();
        boolean isWon = convertResult(selectedResult);
        String surface = convertSurface(selectedSurface);
        int duration = Integer.parseInt(addPage.getDurationField().getText());
        String date = addPage.getDateField().getText();

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
        String score = addPage.getScoreField().getText();
        int aces = Integer.parseInt(addPage.getAcesField().getText());
        int doubleFaults = Integer.parseInt(addPage.getDoubleFaultsField().getText());
        int winners = Integer.parseInt(addPage.getWinnersField().getText());
        int unforcedErrors = Integer.parseInt(addPage.getUnforcedErrorsField().getText());

        return new MatchStats(score, aces, doubleFaults, winners, unforcedErrors);
    }

    private void displayAddError() {
        JOptionPane.showMessageDialog(null,
                "The journal already contains this match",
                "Tennis Match Journal",
                JOptionPane.ERROR_MESSAGE);
    }

    private void displayAddConfirmation() {
        JOptionPane.showMessageDialog(null,
                "The match has been successfully added",
                "Tennis Match Journal",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleAddBack() {
        addPage.dispose();
    }

    private void handleDelete() {
        deletePage = new DeletePage(this);
    }

    private void handleDeleteBack() {
        deletePage.dispose();
    }

    private void handleView() {
        launchPage.dispose();
        viewPage = new ViewPage(this, journal);
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
        JOptionPane.showMessageDialog(null,
                "Your journal has been loaded",
                "Tennis Match Journal",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void showLoadingFailure() {
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
        JOptionPane.showMessageDialog(null,
                "You journal has been saved",
                "Tennis Match Journal",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void showSaveFailure() {
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
        JOptionPane.showMessageDialog(null,
                "The specified match has been successfully deleted",
                "Tennis Match Journal",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void showDeletionError() {
        JOptionPane.showMessageDialog(null,
                "Can't find the specified match",
                "Tennis Match Journal",
                JOptionPane.ERROR_MESSAGE);
    }
}
