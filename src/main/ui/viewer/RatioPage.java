package ui.viewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RatioPage extends JFrame {
    private JButton backButton;
    private JLabel label;
    private String ratio;

    public RatioPage(ActionListener listener, String ratio) {
        this.ratio = ratio;
        initializeGraphics();
        initializeButton();
        initializeListeners(listener);
        initializeFrame();
    }

    private void initializeGraphics() {
        label = new JLabel();
        label.setText(ratio);
        label.setFont(new Font("Arial", Font.BOLD, 200));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
    }

    private void initializeButton() {
        backButton = new JButton();
        backButton.setText("BACK TO HOME SCREEN");
        backButton.setFocusable(false);
        backButton.setSize(400, 50);
    }

    private void initializeListeners(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    private void initializeFrame() {
        ImageIcon frameIcon = new ImageIcon("tennis_ball.png");
        this.add(backButton);
        this.add(label);
        this.setSize(1500, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Tennis Match Journal");
        this.setIconImage(frameIcon.getImage());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JButton getBackButton() {
        return backButton;
    }
}
