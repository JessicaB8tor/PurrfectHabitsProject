package ui.viewer;

import model.TennisMatch;
import model.TennisMatchJournal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// Represents the view page where the user can view a list of all the matches in the journal
public class ViewPage extends JFrame {
    private JButton backButton;
    private JButton selectButton;
    private JList<String> viewPanel;
    private JScrollPane scrollPane;

    // MODIFIES: this
    // EFFECTS: initializes the view page
    public ViewPage(ActionListener listener, TennisMatchJournal journal) {
        initializeViewPanel(journal);
        initializeScrollPane();
        initializeButtons(listener);
        initializeFrame();
    }

    // MODIFIES: this
    // EFFECTS: initializes the view panel
    private void initializeViewPanel(TennisMatchJournal journal) {
        DefaultListModel<String> listModel = new DefaultListModel();

        for (TennisMatch match : journal.getJournal()) {
            String opponent = match.getMatchDetails().getOpponent();
            String date = match.getMatchDetails().getDate();

            String toAdd = "vs. " + opponent + " on " + date;
            listModel.addElement(toAdd);
        }

        viewPanel = new JList(listModel);
        viewPanel.setLayoutOrientation(JList.VERTICAL);
        viewPanel.setFont(new Font("Arial", Font.PLAIN, 25));
    }

    // MODIFIES: this
    // EFFECTS: initializes the scroll pane
    private void initializeScrollPane() {
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(viewPanel);
        scrollPane.setBounds(500, 100, 500, 700);
    }

    // MODIFIES: this
    // EFFECTS: initializes the buttons
    private void initializeButtons(ActionListener listener) {
        backButton = new JButton("Back");
        backButton.setFocusable(false);
        backButton.setBounds(530, 850, 200, 50);
        backButton.addActionListener(listener);

        selectButton = new JButton("Select");
        selectButton.setFocusable(false);
        selectButton.setBounds(770, 850, 200, 50);
        selectButton.addActionListener(listener);
    }

    // MODIFIES: this
    // EFFECTS: initializes the frame
    private void initializeFrame() {
        ImageIcon frameIcon = new ImageIcon("./data/tennis_ball.png");
        this.add(backButton);
        this.add(selectButton);
        this.add(scrollPane);
        this.setSize(1500, 1000);
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

    public JButton getSelectButton() {
        return selectButton;
    }

    public JList<String> getViewPanel() {
        return viewPanel;
    }
}
