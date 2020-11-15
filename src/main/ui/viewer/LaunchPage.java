package ui.viewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LaunchPage extends JFrame {
    private JButton addButton;
    private JButton deleteButton;
    private JButton viewButton;
    private JButton ratioButton;
    private JButton loadButton;
    private JButton saveButton;
    private JLabel mainGraphic;

    public LaunchPage(ActionListener listener) {
        initializeGraphics();
        initializeButtons();
        initializeListeners(listener);
        initializeFrame();
    }

    private void initializeGraphics() {
        ImageIcon mainIcon = new ImageIcon("tennis-player.png");
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

    private void initializeButtons() {
        addButton = new JButton("ADD A TENNIS MATCH");
        addButton.setFocusable(false);
        addButton.setBounds(750, 290, 400, 50);
        deleteButton = new JButton("DELETE A TENNIS MATCH");
        deleteButton.setFocusable(false);
        deleteButton.setBounds(750, 350, 400, 50);
        viewButton = new JButton("VIEW ALL MATCHES");
        viewButton.setFocusable(false);
        viewButton.setBounds(750, 410, 400, 50);
        ratioButton = new JButton("VIEW WIN:LOSS RATIO");
        ratioButton.setFocusable(false);
        ratioButton.setBounds(750, 470, 400, 50);
        loadButton = new JButton("LOAD JOURNAL FROM FILE");
        loadButton.setFocusable(false);
        loadButton.setBounds(750, 530, 400, 50);
        saveButton = new JButton("SAVE JOURNAL TO FILE");
        saveButton.setFocusable(false);
        saveButton.setBounds(750, 590, 400, 50);
    }

    private void initializeListeners(ActionListener listener) {
        addButton.addActionListener(listener);
        deleteButton.addActionListener(listener);
        viewButton.addActionListener(listener);
        ratioButton.addActionListener(listener);
        loadButton.addActionListener(listener);
        saveButton.addActionListener(listener);
    }

    private void initializeFrame() {
        ImageIcon frameIcon = new ImageIcon("tennis_ball.png");
        this.add(addButton);
        this.add(deleteButton);
        this.add(viewButton);
        this.add(ratioButton);
        this.add(loadButton);
        this.add(saveButton);
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
}
