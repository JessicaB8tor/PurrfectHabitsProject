package ui.controller;

import model.TennisMatch;
import model.TennisMatchJournal;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.viewer.DeletePage;
import ui.viewer.LaunchPage;
import ui.viewer.RatioPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JournalAppGui implements ActionListener {
    private static final String JSON_STORE = "./data/journal.json";
    private TennisMatchJournal journal;
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;
    private LaunchPage launchPage;
    private RatioPage ratioPage;
    private DeletePage deletePage;
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
        } else if (e.getSource() == deletePage.getSubmitButton()) {
            delete();
        } else if (e.getSource() == deletePage.getBackButton()) {
            handleDeleteBack();
        } else if (e.getSource() == ratioPage.getBackButton()) {
            handleRatioBack();
        }
    }

    private void handleAdd() {
        //getMatchInfo();
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
        optionPane = new JOptionPane();
        JOptionPane.showMessageDialog(null,
                "Your journal has been loaded",
                "Tennis Match Journal",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleSave() {
        optionPane = new JOptionPane();
        JOptionPane.showMessageDialog(null,
                "You journal has been saved",
                "Tennis Match Journal",
                JOptionPane.INFORMATION_MESSAGE);
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
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleDeleteBack() {
        deletePage.dispose();
    }
}
