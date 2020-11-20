package ui.viewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// Represents the ratio page that displays the user's current win:loss ratio
public class RatioPage extends JFrame {
    private JButton backButton;
    private JLabel label;
    private String ratio;

    // MODIFIES: this
    // EFFECTS: initializes the ratio page
    public RatioPage(ActionListener listener, String ratio) {
        this.ratio = ratio;
        initializeRatio();
        initializeButton();
        initializeListeners(listener);
        initializeFrame();
    }

    // MODIFIES: this
    // EFFECTS: initializes the ratio to be displayed
    private void initializeRatio() {
        label = new JLabel();
        label.setText(ratio);
        label.setFont(new Font("Arial", Font.BOLD, 200));
        label.setBounds(550, 200, 500, 500);
    }

    // MODIFIES: this
    // EFFECTS: initializes the back button
    private void initializeButton() {
        backButton = new JButton();
        backButton.setText("Back");
        backButton.setFocusable(false);
        backButton.setBounds(550, 700, 400, 50);
    }

    // MODIFIES: this
    // EFFECTS: adds an action listener to the back button
    private void initializeListeners(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    // MODIFIES: this
    // EFFECTS: initializes the frame
    private void initializeFrame() {
        ImageIcon frameIcon = new ImageIcon("./data/tennis_ball.png");
        this.add(backButton);
        this.add(label);
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
}
