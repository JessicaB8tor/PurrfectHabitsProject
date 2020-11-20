package ui.viewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// Represents the launch page (home screen) of the application
public class LaunchPage extends JFrame {
    private JButton addButton;
    private JButton deleteButton;
    private JButton viewButton;
    private JButton ratioButton;
    private JButton loadButton;
    private JButton saveButton;
    private JButton quitButton;
    private JLabel mainGraphic;

    // MODIFIES: this
    // EFFECTS: initializes the launch page
    public LaunchPage(ActionListener listener) {
        initializeGraphic();
        initializeButtons();
        initializeListeners(listener);
        initializeFrame();
    }

    // MODIFIES: this
    // EFFECTS: initializes the graphic
    private void initializeGraphic() {
        ImageIcon mainIcon = new ImageIcon("./data/tennis-player.png");
        Image image = mainIcon.getImage();
        Image scaledImage = image.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
        mainIcon = new ImageIcon(scaledImage);
        mainGraphic = new JLabel();
        mainGraphic.setText("Tennis Match Journal");
        mainGraphic.setFont(new Font("Arial", Font.BOLD, 40));
        mainGraphic.setIcon(mainIcon);
        mainGraphic.setHorizontalTextPosition(JLabel.CENTER);
        mainGraphic.setVerticalTextPosition(JLabel.TOP);
        mainGraphic.setBounds(275, 200, 500, 500);
    }

    // MODIFIES: this
    // EFFECTS: initializes the buttons
    private void initializeButtons() {
        addButton = new JButton("ADD A TENNIS MATCH");
        addButton.setFocusable(false);
        addButton.setBounds(750, 270, 400, 50);
        deleteButton = new JButton("DELETE A TENNIS MATCH");
        deleteButton.setFocusable(false);
        deleteButton.setBounds(750, 330, 400, 50);
        viewButton = new JButton("VIEW ALL MATCHES");
        viewButton.setFocusable(false);
        viewButton.setBounds(750, 390, 400, 50);
        ratioButton = new JButton("VIEW WIN:LOSS RATIO");
        ratioButton.setFocusable(false);
        ratioButton.setBounds(750, 450, 400, 50);
        loadButton = new JButton("LOAD JOURNAL FROM FILE");
        loadButton.setFocusable(false);
        loadButton.setBounds(750, 510, 400, 50);
        saveButton = new JButton("SAVE JOURNAL TO FILE");
        saveButton.setFocusable(false);
        saveButton.setBounds(750, 570, 400, 50);
        quitButton = new JButton("QUIT");
        quitButton.setFocusable(false);
        quitButton.setBounds(750, 630, 400, 50);
    }

    // MODIFIES: this
    // EFFECTS: adds the same action listener to all the buttons
    private void initializeListeners(ActionListener listener) {
        addButton.addActionListener(listener);
        deleteButton.addActionListener(listener);
        viewButton.addActionListener(listener);
        ratioButton.addActionListener(listener);
        loadButton.addActionListener(listener);
        saveButton.addActionListener(listener);
        quitButton.addActionListener(listener);
    }

    // MODIFIES: this
    // EFFECTS: initializes the frame
    private void initializeFrame() {
        ImageIcon frameIcon = new ImageIcon("./data/tennis_ball.png");
        this.add(addButton);
        this.add(deleteButton);
        this.add(viewButton);
        this.add(ratioButton);
        this.add(loadButton);
        this.add(saveButton);
        this.add(quitButton);
        this.add(mainGraphic);
        this.setSize(1500, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("Tennis Match Journal");
        this.setIconImage(frameIcon.getImage());
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getViewButton() {
        return viewButton;
    }

    public JButton getRatioButton() {
        return ratioButton;
    }

    public JButton getLoadButton() {
        return loadButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JButton getQuitButton() {
        return quitButton;
    }
}
