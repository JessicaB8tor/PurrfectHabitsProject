package ui.controller;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VerticalDirection;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DashboardPage  {
    private static final String yellow = "-fx-background-color: #FFCB3D";
    private static final String blue = "-fx-background-color: #86D0F7";
    private static final String grey = "-fx-background-color: #BEC2C4";
    private BorderPane borderPane;
    private BorderPane centerBorderPane;
    private VBox leftPane;
    private HBox topPane;
    private Quote quoteOfTheDay;
    private Button settingsButton;
    private Button profileButton;
    private Button friendsButton;
    private Button logoutButton;
    private Button leaderboardButton;

    public DashboardPage(Stage primaryStage, EventHandler eventHandler, Dashboard dashboard) throws Exception {
        borderPane = new BorderPane();
        borderPane.setPrefSize(1000, 500);
        createLeftPane();
        createTopPane();
        createCenterPane(dashboard);
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
            settingsButton.setFocusTraversable(false);
            profileButton = new Button("", profileImage);
            profileButton.setFocusTraversable(false);
            logoutButton = new Button("", logoutImage);
            logoutButton.setFocusTraversable(false);
            friendsButton = new Button("", friendsImage);
            friendsButton.setFocusTraversable(false);
            leaderboardButton = new Button("", leaderboardImage);
            leaderboardButton.setFocusTraversable(false);

            leftPane.getChildren().addAll(profileButton, friendsButton, leaderboardButton, settingsButton, logoutButton);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createTopPane() {
        topPane = new HBox(10);
        topPane.setStyle(blue);
        topPane.setPadding(new Insets(10, 10, 10, 10));
        borderPane.setTop(topPane);

        try {
            FileInputStream inputStream = new FileInputStream("data/misc/anonCat.png");
            ImageView imageView = new ImageView(new Image(inputStream));
            imageView.setFitWidth(70);
            imageView.setFitHeight(70);
            topPane.getChildren().add(imageView);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        QuoteOfTheDay generator = new QuoteOfTheDay();
        quoteOfTheDay = generator.getQuoteOfTheDay();

        Label dashboardLabel = new Label("Dashboard");
        dashboardLabel.setFont(new Font("Century Gothic Bold", 55));
        topPane.getChildren().add(dashboardLabel);

        Separator separator = new Separator(Orientation.VERTICAL);
        topPane.getChildren().add(separator);

        Label sayingLabel = new Label("\"" + quoteOfTheDay.getSaying() + "\"" + "\n" + "- " + quoteOfTheDay.getAuthor());
        sayingLabel.setFont(new Font("Century Gothic", 20));
        sayingLabel.setWrapText(true);
        sayingLabel.setMaxWidth(575);
        topPane.getChildren().add(sayingLabel);
    }

    public void createCenterPane(Dashboard dashboard) {
        centerBorderPane = new BorderPane();

        createCenterTopPane();
        createCenterCenterPane(dashboard);
        createCenterBotPane(dashboard);

        borderPane.setCenter(centerBorderPane);
    }

    public void createCenterTopPane() {
        HBox hBox = new HBox(10);
        hBox.setPadding(new Insets(10));

        Button add = new Button("Add");;
        Button remove = new Button("Remove");
        List<Button> buttons = Arrays.asList(add, remove);
        for (Button b: buttons) {
            b.setStyle(grey);
            b.setFont(new Font("Dosis", 20));
            b.setPrefSize(100, 20);
        }
        hBox.getChildren().addAll(buttons);
        centerBorderPane.setTop(hBox);
    }

    public void createCenterCenterPane(Dashboard dashboard) {
        GridPane gridPane = new GridPane();

        for (Habit habit : dashboard.getAllHabits()) {
            List<Award> allAwards = habit.getAwardsGallery().getAllAwards();

            if (allAwards.size() == 0) {
                try {
                    FileInputStream inputStream = new FileInputStream("data/misc/catLogo.png");
                    ImageView imageView = new ImageView(new Image(inputStream));
                    Button button = new Button(habit.getTitle(), imageView);
                    gridPane.getChildren().add(button);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                Award lastAwardReceived = allAwards.get(allAwards.size() - 1);
                String lastAwardReceivedDate = lastAwardReceived.getDateReceived().toString();
                String extension = (lastAwardReceived.getAwardType() == Award.AwardType.PAWSOME_ACHIEVEMENT) ? ".gif" : ".png";
                try {
                    FileInputStream inputStream = new FileInputStream("data/habits/" + habit.getTitle() + "/" + habit.getTitle() + "_Gallery/" + lastAwardReceivedDate + extension);
                    ImageView imageView = new ImageView(new Image(inputStream));
                    Button button = new Button(habit.getTitle(), imageView);
                    gridPane.add(button, 0, 0);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        centerBorderPane.setCenter(gridPane);
    }

    public void createCenterBotPane(Dashboard dashboard) {


    }
}



