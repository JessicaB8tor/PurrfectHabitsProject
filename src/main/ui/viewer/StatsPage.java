package ui.viewer;

import model.TennisMatch;

import javax.swing.*;
import java.awt.event.ActionListener;

public class StatsPage extends JFrame {
    JTable table;
    JButton backButton;
    JScrollPane scrollPane;

    public StatsPage(ActionListener listener, TennisMatch match) {
        initializeTable(match);
        initializeButton(listener);
        initializeFrame();
    }

    private void initializeTable(TennisMatch match) {
        String result = (match.getMatchDetails().getIsWon()) ? "Win" : "Loss";

        Object[][] rowData = new Object[][]{
                {"Opponent", match.getMatchDetails().getOpponent()},
                {"Result", result},
                {"Surface", match.getMatchDetails().getSurface()},
                {"Duration", Integer.toString(match.getMatchDetails().getDuration())},
                {"Date", match.getMatchDetails().getDate()}
        };

        Object[] columnNames = new Object[]{"1", "2", "3"};

        table = new JTable(rowData, columnNames);
        table.setTableHeader(null);
        scrollPane = new JScrollPane(table);
        scrollPane.setColumnHeaderView(null);
    }

    private void initializeButton(ActionListener listener) {
        backButton = new JButton("Back");
        backButton.setFocusable(false);
        backButton.setBounds(250, 700, 200, 50);
        backButton.addActionListener(listener);
    }

    private void initializeFrame() {
        ImageIcon frameIcon = new ImageIcon("tennis_ball.png");
        this.add(backButton);
        this.add(table);
        this.setSize(500, 700);
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
