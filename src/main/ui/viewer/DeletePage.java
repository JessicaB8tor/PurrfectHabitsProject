package ui.viewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class DeletePage extends JFrame {
    private JTextField opponentField;
    private JTextField dateField;
    private JLabel opponentLabel;
    private JLabel dateLabel;
    private JButton submitButton;
    private JButton backButton;

    public DeletePage(ActionListener listener) {
        initializeTextFields();
        initializeLabels();
        initializeButtons(listener);
        initializeFrame();
    }

    private void initializeTextFields() {
        opponentField = new JTextField();
        opponentField.setBounds(230, 20, 350, 25);

        dateField = new JTextField();
        dateField.setBounds(230, 65, 350, 25);

    }

    private void initializeLabels() {
        opponentLabel = new JLabel();
        opponentLabel.setText("Opponent: (First Last)");
        opponentLabel.setFont(new Font("Arial", Font.BOLD, 13));
        opponentLabel.setBounds(10, 20, 200, 25);

        dateLabel = new JLabel();
        dateLabel.setText("Date: (D/M/YYYY)");
        dateLabel.setBounds(10, 65, 200, 25);
        dateLabel.setFont(new Font("Arial", Font.BOLD, 13));
    }

    private void initializeButtons(ActionListener listener) {
        submitButton = new JButton("Submit");
        submitButton.setBounds(10, 100, 100, 50);
        submitButton.setFocusable(false);
        submitButton.addActionListener(listener);

        backButton = new JButton("Back");
        backButton.setBounds(120, 100, 100, 50);
        backButton.setFocusable(false);
        backButton.addActionListener(listener);
    }

    private void initializeFrame() {
        ImageIcon frameIcon = new ImageIcon("tennis_ball.png");
        this.add(opponentField);
        this.add(dateField);
        this.add(opponentLabel);
        this.add(dateLabel);
        this.add(submitButton);
        this.add(backButton);
        this.setSize(600, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("Delete a match");
        this.setIconImage(frameIcon.getImage());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    public JTextField getOpponentField() {
        return opponentField;
    }

    public JTextField getDateField() {
        return dateField;
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JButton getBackButton() {
        return backButton;
    }
}
