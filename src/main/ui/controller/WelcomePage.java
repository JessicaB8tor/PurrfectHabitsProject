package ui.controller;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class WelcomePage extends Application {
    BorderPane borderPane;
    VBox leftVBox;
    VBox rightVBox;
    HBox bottomHBox;

    @Override
    public void start(Stage primaryStage) throws Exception {
        borderPane = new BorderPane();
        borderPane.setPrefSize(1000, 500);
        borderPane.setStyle("-fx-background-color: #86D0F7");

        createLeftVBox();
        createRightVBox();
        createBottomHBox();

        Scene root = new Scene(borderPane);
        primaryStage.setScene(root);
        primaryStage.show();
    }

    public void createLeftVBox() throws FileNotFoundException {
        leftVBox = new VBox();
        leftVBox.setAlignment(Pos.CENTER);

        //Image Stuff
        FileInputStream stream = new FileInputStream("data/misc/catLogo.png");
        Image image = new Image(stream);
        ImageView logo = new ImageView(image);
        logo.setFitWidth(333);
        logo.setPreserveRatio(true);

        VBox.setMargin(logo, new Insets(70, 0, 0, 50));
        leftVBox.getChildren().add(logo);
        borderPane.setLeft(leftVBox);
    }

    public void createRightVBox() {
        rightVBox = new VBox();
        rightVBox.setAlignment(Pos.CENTER);

        //Label Stuff
        Label welcomeTo = new Label("WELCOME TO");
        Label purrfectHabits = new Label("PURRFECT HABITS");
        welcomeTo.setFont(new Font("Showcard Gothic", 50));
        purrfectHabits.setFont(new Font("Showcard Gothic", 50));

        VBox.setMargin(welcomeTo, new Insets(0, 100, 0, 0));
        VBox.setMargin(purrfectHabits, new Insets(0, 100, 0, 0));
        rightVBox.getChildren().addAll(welcomeTo, purrfectHabits);
        borderPane.setRight(rightVBox);
    }

    public void createBottomHBox() {
        bottomHBox = new HBox();
        bottomHBox.setAlignment(Pos.CENTER_RIGHT);

        //Button Stuff
        Button button = new Button("Get Started");
        button.setFont(new Font("Dosis Bold", 25));
        button.setStyle("-fx-background-color: #FFCB3D");

        HBox.setMargin(button, new Insets(0, 240,125, 0));
        bottomHBox.getChildren().add(button);
        borderPane.setBottom(bottomHBox);
    }
}
