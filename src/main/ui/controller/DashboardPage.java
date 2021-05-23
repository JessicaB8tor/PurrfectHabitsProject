package ui.controller;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DashboardPage  {
    private static final String yellow = "-fx-background-color: #FFCB3D";
    private static final String blue = "-fx-background-color: #86D0F7";
    private BorderPane borderPane;
    private VBox leftPane;
    private HBox topPane;
    private String quoteOfTheDay;
    private Button settingsButton;
    private Button profileButton;
    private Button friendsButton;
    private Button logoutButton;
    private Button leaderboardButton;

    public DashboardPage(Stage primaryStage, EventHandler eventHandler) throws Exception {
        borderPane = new BorderPane();
        borderPane.setPrefSize(1000, 500);
        createLeftPane();
        createTopPane();
        createBigPane();
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void createLeftPane() {
        leftPane = new VBox(45);
        leftPane.setStyle(yellow);
        leftPane.setPadding(new Insets(10, 10, 10, 10));
        borderPane.setLeft(leftPane);
        try {
            FileInputStream profileStream = new FileInputStream("data/misc/profile.png");
            FileInputStream logoutStream = new FileInputStream("data/misc/logout.png");
            FileInputStream leaderboardStream = new FileInputStream("data/misc/leaderboard.png");
            FileInputStream friendsStream = new FileInputStream("data/misc/friends.png");
            FileInputStream settingsStream = new FileInputStream("data/misc/settings.png");
            ImageView settingsImage = new ImageView(new Image(settingsStream));
            ImageView friendsImage = new ImageView(new Image(friendsStream));
            ImageView leaderboardImage = new ImageView(new Image(leaderboardStream));
            ImageView logoutImage = new ImageView(new Image(logoutStream));
            ImageView profileImage = new ImageView(new Image(profileStream));

            List<ImageView> images = Arrays.asList(profileImage, friendsImage, leaderboardImage, settingsImage, logoutImage);
            for (ImageView im : images) {
                im.setFitWidth(50);
                im.setFitHeight(50);
            }

            settingsButton = new Button("", settingsImage);
            profileButton = new Button("", profileImage);
            logoutButton = new Button("", logoutImage);
            friendsButton = new Button("", friendsImage);
            leaderboardButton = new Button("", leaderboardImage);

            leftPane.getChildren().addAll(profileButton, friendsButton, leaderboardButton, settingsButton, logoutButton);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createTopPane() {

    }

    public void createBigPane() {

    }
}



