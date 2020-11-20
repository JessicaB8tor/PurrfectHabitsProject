package ui.viewer;

import model.TennisMatch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// Represents the stats page where the user can view detailed statistics about a single match
public class StatsPage extends JFrame {
    JTable table;
    JButton backButton;

    // MODIFIES: this
    // EFFECTS: initializes the stats page
    public StatsPage(ActionListener listener, TennisMatch match) {
        initializeTable(match);
        initializeButton(listener);
        initializeFrame();
    }

    // MODIFIES: this
    // EFFECTS: initializes the table
    private void initializeTable(TennisMatch match) {
        String[][] rowData = {
                {"Opponent", match.getMatchDetails().getOpponent()},
                {"Result", (match.getMatchDetails().getIsWon()) ? "Win" : "Loss"},
                {"Surface", match.getMatchDetails().getSurface()},
                {"Duration", Integer.toString(match.getMatchDetails().getDuration())},
                {"Date", match.getMatchDetails().getDate()},
                {"Score", match.getMatchStats().getScore()},
                {"Aces", Integer.toString(match.getMatchStats().getAces())},
                {"Double Faults", Integer.toString(match.getMatchStats().getDoubleFaults())},
                {"Winners", Integer.toString(match.getMatchStats().getWinners())},
                {"Unforced Errors", Integer.toString(match.getMatchStats().getUnforcedErrors())}
        };

        String[] columnData = {"1","1"};

        table = new JTable(rowData, columnData);
        table.setBounds(0, 0, 500, 700);
        table.setFont(new Font("Arial", Font.PLAIN, 30));
        table.setRowHeight(table.getRowHeight() + 30);
    }

    // MODIFIES: this
    // EFFECTS: initializes the back button
    private void initializeButton(ActionListener listener) {
        backButton = new JButton("Back");
        backButton.setFocusable(false);
        backButton.setBounds(140, 480, 200, 50);
        backButton.addActionListener(listener);
    }

    // MODIFIES: this
    // EFFECTS: initializes the frame
    private void initializeFrame() {
        ImageIcon frameIcon = new ImageIcon("./data/tennis_ball.png");
        this.add(backButton);
        this.add(table);
        this.setSize(500, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("Tennis Match Journal");
        this.setIconImage(frameIcon.getImage());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JButton getBackButton() {
        return backButton;
    }
}
