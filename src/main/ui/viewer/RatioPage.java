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
        label.setBounds(550, 200, 500, 500);
    }

    private void initializeButton() {
        backButton = new JButton();
        backButton.setText("Back");
        backButton.setFocusable(false);
        backButton.setBounds(550, 700, 400, 50);
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
