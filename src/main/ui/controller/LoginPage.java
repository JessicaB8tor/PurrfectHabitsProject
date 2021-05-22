package ui.controller;


import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class LoginPage {
    Stage primaryStage;
    DashboardPage dashboardPage;
    NewAccountPage newAccountPage;
    VBox loginVbox;
    Button yes;
    Button no;

    public LoginPage() throws Exception {
        primaryStage = new Stage();

        loginVbox = new VBox();
        loginVbox.setAlignment(Pos.CENTER);
        loginVbox.setSpacing(30);
        loginVbox.setPrefSize(1000, 500);
        loginVbox.setStyle("-fx-background-color: #86D0F7");
        Scene root = new Scene(loginVbox);

        //Label Stuff
        Label label = new Label("Welcome to Purrfect Habits!");
        label.setFont(new Font("Showcard Gothic", 24));
        Label firstTime = new Label("First Time?");
        firstTime.setFont(new Font("Dosis Bold", 20));

        //Button Stuff
        buttonSetUp();


        loginVbox.getChildren().addAll(label, firstTime, yes, no);
        primaryStage.setScene(root);
        primaryStage.show();
    }

    public void buttonSetUp() {
        //TODO: Split listener stuff into seperate class -> cleaner code & pass checkstyle
        yes = new Button("YES");
        no = new Button("NO");
        List<Button> buttons = new ArrayList<>();
        buttons.add(yes);
        buttons.add(no);

        for (Button button: buttons) {
            button.setFont(new Font("Dosis Bold", 20));
            button.setStyle("-fx-background-color: #FFCB3D");
        }

        yes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                newAccountPage = new NewAccountPage(primaryStage);
                primaryStage.getScene().setRoot(newAccountPage.borderPane);
            }
        });

        no.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    dashboardPage = new DashboardPage(primaryStage);
                    primaryStage.getScene().setRoot(dashboardPage.borderPane);
                } catch (Exception e) {
                    System.out.println("ERROR loading Dashboard Page");
                }
            }
        });
    }
}
