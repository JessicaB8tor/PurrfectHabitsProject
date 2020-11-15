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

    public AddPage() {
        initializeLabels();
        initializeFields();
        initializeComboBoxes();
        initializeButtons();
        configureLocations();
        initializeFrame();
    }

    private void initializeLabels() {
        opponentLabel = new JLabel("Opponent: (First Last)");
        opponentLabel.setFont(new Font("Arial", Font.BOLD, 13));
        resultLabel = new JLabel("Result:");
        surfaceLabel = new JLabel("Surface:");
        durationLabel = new JLabel("Duration:");
        dateLabel = new JLabel("Date:");
        scoreLabel = new JLabel("Score:");
        acesLabel = new JLabel("Aces:");
        doubleFaultsLabel = new JLabel("Double Faults:");
        winnersLabel = new JLabel("Winners:");
        unforcedErrorsLabel = new JLabel("Unforced Errors:");

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
        resultOptions = new JComboBox();
        surfaceOptions = new JComboBox();

    }

    private void initializeButtons() {
        submitButton = new JButton("Submit");
        submitButton.setFocusable(false);

        backButton = new JButton("Back");
        backButton.setFocusable(false);
    }

    private void configureLocations() {
        configureLabelLocations();
        configureTextFieldLocations();
        configureComboBoxLocations();
        configureButtonLocations();
    }

    private void configureLabelLocations() {
        opponentLabel.setBounds(10, 360, 100, 50);
    }

    private void configureTextFieldLocations() {

    }

    private void configureComboBoxLocations() {

    }

    private void configureButtonLocations() {

    }

    private void initializeFrame() {
        ImageIcon frameIcon = new ImageIcon("tennis_ball.png");

        addAllToFrame();

        this.setSize(700, 400);
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
}




























