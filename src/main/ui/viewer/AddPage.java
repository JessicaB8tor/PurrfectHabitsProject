package ui.viewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddPage extends JFrame {
    JTextField opponentField;
    JComboBox resultOptions;
    JComboBox surfaceOptions;
    JTextField durationField;
    JTextField dateField;
    JTextField scoreField;
    JTextField acesField;
    JTextField doubleFaultsField;
    JTextField winnersField;
    JTextField unforcedErrorsField;
    JButton submitButton;
    JButton backButton;
    JLabel opponentLabel;
    JLabel resultLabel;
    JLabel surfaceLabel;
    JLabel durationLabel;
    JLabel dateLabel;
    JLabel scoreLabel;
    JLabel acesLabel;
    JLabel doubleFaultsLabel;
    JLabel winnersLabel;
    JLabel unforcedErrorsLabel;
    String[] results;
    String[] surfaces;

    public AddPage(ActionListener listener) {
        initializeLabels();
        initializeFields();
        initializeComboBoxes();
        initializeButtons(listener);
        configureAll();
        initializeFrame();
    }

    private void initializeLabels() {
        opponentLabel = new JLabel("Opponent: (First Last)");
        opponentLabel.setFont(new Font("Arial", Font.BOLD, 16));

        resultLabel = new JLabel("Result:");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));

        surfaceLabel = new JLabel("Surface:");
        surfaceLabel.setFont(new Font("Arial", Font.BOLD, 16));

        durationLabel = new JLabel("Duration: (in minutes)");
        durationLabel.setFont(new Font("Arial", Font.BOLD, 16));

        dateLabel = new JLabel("Date: (D/M/YYYY)");
        dateLabel.setFont(new Font("Arial", Font.BOLD, 16));

        scoreLabel = new JLabel("Score: (A-B C-D ...)");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 16));

        acesLabel = new JLabel("Aces:");
        acesLabel.setFont(new Font("Arial", Font.BOLD, 16));

        doubleFaultsLabel = new JLabel("Double Faults:");
        doubleFaultsLabel.setFont(new Font("Arial", Font.BOLD, 16));

        winnersLabel = new JLabel("Winners:");
        winnersLabel.setFont(new Font("Arial", Font.BOLD, 16));

        unforcedErrorsLabel = new JLabel("Unforced Errors:");
        unforcedErrorsLabel.setFont(new Font("Arial", Font.BOLD, 16));
    }

    private void initializeFields() {
        opponentField = new JTextField();
        durationField = new JTextField();
        dateField = new JTextField();
        scoreField = new JTextField();
        acesField = new JTextField();
        doubleFaultsField = new JTextField();
        winnersField = new JTextField();
        unforcedErrorsField = new JTextField();
    }

    private void initializeComboBoxes() {
        results = new String[]{"Please select an option", "Win", "Loss"};
        resultOptions = new JComboBox(results);

        surfaces = new String[]{"Please select an option", "Hard", "Grass", "Clay"};
        surfaceOptions = new JComboBox(surfaces);
    }

    private void initializeButtons(ActionListener listener) {
        submitButton = new JButton("Submit");
        submitButton.setFocusable(false);
        submitButton.addActionListener(listener);

        backButton = new JButton("Back");
        backButton.setFocusable(false);
        backButton.addActionListener(listener);
    }

    private void configureAll() {
        configureLabels();
        configureTextFields();
        configureComboBoxes();
        configureButtons();
    }

    private void configureLabels() {
        opponentLabel.setBounds(10, 0, 200, 50);
        resultLabel.setBounds(10, 40, 200, 50);
        surfaceLabel.setBounds(10, 80, 200, 50);
        durationLabel.setBounds(10, 120, 200, 50);
        dateLabel.setBounds(10, 160, 200, 50);
        scoreLabel.setBounds(10, 200, 200, 50);
        acesLabel.setBounds(10, 240, 200, 50);
        doubleFaultsLabel.setBounds(10, 280, 200, 50);
        winnersLabel.setBounds(10, 320, 200, 50);
        unforcedErrorsLabel.setBounds(10, 360, 200, 50);
    }

    private void configureTextFields() {
        opponentField.setBounds(200, 12, 350, 25);
        durationField.setBounds(200, 132, 350, 25);
        dateField.setBounds(200, 172, 350, 25);
        scoreField.setBounds(200, 212, 350, 25);
        acesField.setBounds(200, 252, 350, 25);
        doubleFaultsField.setBounds(200, 292, 350, 25);
        winnersField.setBounds(200, 332, 350, 25);
        unforcedErrorsField.setBounds(200, 372, 350, 25);
    }

    private void configureComboBoxes() {
        resultOptions.setBounds(200, 52, 350, 25);
        surfaceOptions.setBounds(200, 92, 350, 25);
    }

    private void configureButtons() {
        submitButton.setBounds(10, 425, 265, 50);
        backButton.setBounds(285, 425, 265, 50);
    }

    private void initializeFrame() {
        ImageIcon frameIcon = new ImageIcon("tennis_ball.png");

        addAllToFrame();

        this.setSize(570, 530);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("Add a match");
        this.setIconImage(frameIcon.getImage());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    private void addAllToFrame() {
        addLabels();
        addFields();
        addComboBoxes();
        addButtons();
    }

    private void addLabels() {
        this.add(opponentLabel);
        this.add(resultLabel);
        this.add(surfaceLabel);
        this.add(durationLabel);
        this.add(dateLabel);
        this.add(scoreLabel);
        this.add(acesLabel);
        this.add(doubleFaultsLabel);
        this.add(winnersLabel);
        this.add(unforcedErrorsLabel);
    }

    private void addFields() {
        this.add(opponentField);
        this.add(durationField);
        this.add(dateField);
        this.add(scoreField);
        this.add(acesField);
        this.add(doubleFaultsField);
        this.add(winnersField);
        this.add(unforcedErrorsField);
    }

    private void addComboBoxes() {
        this.add(resultOptions);
        this.add(surfaceOptions);
    }

    private void addButtons() {
        this.add(submitButton);
        this.add(backButton);
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JComboBox getResultOptions() {
        return resultOptions;
    }

    public JComboBox getSurfaceOptions() {
        return surfaceOptions;
    }

    public JTextField getOpponentField() {
        return opponentField;
    }

    public JTextField getDurationField() {
        return durationField;
    }

    public JTextField getDateField() {
        return dateField;
    }

    public JTextField getScoreField() {
        return scoreField;
    }

    public JTextField getAcesField() {
        return acesField;
    }

    public JTextField getDoubleFaultsField() {
        return doubleFaultsField;
    }

    public JTextField getWinnersField() {
        return winnersField;
    }

    public JTextField getUnforcedErrorsField() {
        return unforcedErrorsField;
    }
}




























