package ui.controller;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
import java.util.List;


public class Dashboard extends Application {
    BorderPane borderPane;
    VBox leftVBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Dashboard");

        borderPane = new BorderPane();
        borderPane.setPrefSize(1000, 500);
        borderPane.setStyle("-fx-background-color: #FFCB3D");
        createTopHBox();
        createBottomHBox();
        createLeftVBox();
        createCenterGridPane();


        Scene root = new Scene(borderPane);
        primaryStage.setScene(root);
        primaryStage.show();

    }

    private void createTopHBox() throws FileNotFoundException {
        HBox topHBox = new HBox();
        topHBox.setStyle("-fx-background-color: #86D0F7FF");
        topHBox.setAlignment(Pos.TOP_CENTER);

        //Image Stuff
        FileInputStream stream = new FileInputStream("data/catLogo.png");
        Image image = new Image(stream);
        ImageView logo = new ImageView(image);
        logo.setFitWidth(100);
        logo.setPreserveRatio(true);

        //Label Stuff
        Label label = new Label("PURRFECT HABITS", logo);
        label.setFont(new Font("Showcard Gothic", 24));


        topHBox.getChildren().addAll(label);
        borderPane.setTop(topHBox);
    }

    private void createBottomHBox() {
        HBox bottomHBox = new HBox();
        bottomHBox.setStyle("-fx-background-color: #86D0F7FF");
        bottomHBox.setAlignment(Pos.CENTER);

        //Label Stuff
        Label quote = new Label("Inspirational Quote");
        quote.setFont(new Font("Vivaldi Italic", 70));

        bottomHBox.getChildren().add(quote);
        borderPane.setBottom(bottomHBox);
    }

    private void createLeftVBox() throws FileNotFoundException {
        leftVBox = new VBox();
        leftVBox.setAlignment(Pos.TOP_CENTER);
        leftVBox.setSpacing(60);
        leftVBox.setPadding(new Insets(10, 50, 50, 50));

        //Label Stuff
        Label label = new Label("Jessica Bator");
        label.setFont(new Font("Showcard Gothic", 30));
        leftVBox.getChildren().add(label);

        //Button Stuff
        buttonSetup();


        borderPane.setLeft(leftVBox);
    }

    private void buttonSetup() {
        Button myHabits = new Button("MY HABITS");
        Button addHabit = new Button("ADD HABIT");
        Button deleteHabit = new Button("DELETE HABIT");
        List<Button> buttons = new ArrayList<>();
        buttons.add(myHabits);
        buttons.add(addHabit);
        buttons.add(deleteHabit);
        for (Button b: buttons) {
            b.setFont(new Font("Dosis Bold", 20));
            b.setStyle("-fx-background-color: #86D0F7FF");

        }

        leftVBox.getChildren().addAll(myHabits, addHabit, deleteHabit);
    }

    private void createCenterGridPane() {
        GridPane centerGridPane = new GridPane();
        borderPane.setCenter(centerGridPane);
        //TODO: This is where graph will go (API?, DS.js? other?)
    }
}
