package ui.controller;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class NewAccountPage {
    BorderPane borderPane;

    public NewAccountPage(Stage primaryStage) {
        borderPane = new BorderPane();
        borderPane.setPrefSize(1000, 500);
        borderPane.setStyle("-fx-background-color: #FFCB3D");

        createTopHBox();
        createCenterGridPane();
        createBottomVBox();

        Scene root = new Scene(borderPane);

        primaryStage.setScene(root);
        primaryStage.show();
    }

    public void createTopHBox() {
        HBox topHBox = new HBox();
        topHBox.setAlignment(Pos.CENTER);

        //Label Stuff
        Label label = new Label("Create an Account");
        label.setFont(new Font("Showcard Gothic", 24));

        topHBox.getChildren().addAll(label);
        borderPane.setTop(topHBox);
    }

    public void createCenterGridPane() {
        //TODO: Make method smaller for checkstyle & readability
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);


        //Label Stuff
        Label name = new Label("Name");
        Label emailAddress = new Label("Email Address");
        Label password = new Label("Password");
        Label confirmPassword = new Label("Confirm Password");
        List<Label> labels = Arrays.asList(name, emailAddress, password, confirmPassword);
        for (Label label: labels) {
            label.setFont(new Font("Dosis Bold", 20));
        }


        //TextField Stuff
        TextField nameField = new TextField();
        nameField.setPromptText("ex. Jessica");
        TextField emailField = new TextField();
        emailField.setPromptText("ex. meow@gmail.com");
        TextField passwordField = new TextField();
        TextField confirmPasswordField = new TextField();

        gridPane.add(name, 0, 0);
        gridPane.add(nameField, 1, 0);
        gridPane.add(emailAddress, 0, 1);
        gridPane.add(emailField, 1, 1);
        gridPane.add(password, 0, 2);
        gridPane.add(passwordField, 1, 2);
        gridPane.add(confirmPassword, 0, 3);
        gridPane.add(confirmPasswordField, 1, 3);

        borderPane.setCenter(gridPane);
    }

    public void createBottomVBox() {
        VBox bottomVBox = new VBox();
        bottomVBox.setAlignment(Pos.CENTER);


        //Button Stuff
        Button button = new Button("Submit");
        button.setFont(new Font("Dosis Bold", 20));
        button.setStyle("-fx-background-color: #86D0F7");
        VBox.setMargin(button, new Insets(10, 10, 80, 10));

        bottomVBox.getChildren().add(button);
        borderPane.setBottom(bottomVBox);
    }
}
