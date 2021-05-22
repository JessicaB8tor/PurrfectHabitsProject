package ui.controller;

import javafx.geometry.Pos;
import javafx.scene.Scene;
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
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        //Set Dimensions
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(25);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(25);
        gridPane.getColumnConstraints().addAll(col1, col2);


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

        gridPane.add(name, 0, 0);
        gridPane.add(nameField, 1, 0);
        gridPane.add(emailAddress, 2, 1);
        gridPane.add(emailField, 1, 1);
        borderPane.setCenter(gridPane);
    }

    public void createBottomVBox() {
        VBox bottomVBox = new VBox();

        borderPane.setBottom(bottomVBox);

    }
}
