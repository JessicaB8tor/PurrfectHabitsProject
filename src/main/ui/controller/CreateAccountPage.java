package ui.controller;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class CreateAccountPage extends Application {
    BorderPane borderPane;

    @Override
    public void start(Stage primaryStage) throws Exception {



   // public CreateAccountPage(Stage primaryStage) {
        borderPane = new BorderPane();
        borderPane.setPrefSize(1000, 500);
        borderPane.setStyle("-fx-background-color: #FFCB3D");

        createLeftVBox();
       // createTopHBox();
        createCenterGridPane();
       // createBottomVBox();

        Scene root = new Scene(borderPane);

        primaryStage.setScene(root);
        primaryStage.show();
    }

    public void  createLeftVBox() throws FileNotFoundException {
        VBox leftVBox = new VBox();
        leftVBox.setAlignment(Pos.CENTER);
        leftVBox.setStyle("-fx-background-color: #FFCB3D");

        //Image Stuff
        FileInputStream stream = new FileInputStream("data/misc/createAccCat.png");
        Image image = new Image(stream);
        ImageView logo = new ImageView(image);
        logo.setFitWidth(400);
        logo.setPreserveRatio(true);

        VBox.setMargin(logo, new Insets(100, 0, 100, 0));
        leftVBox.getChildren().add(logo);
        borderPane.setLeft(logo);
    }

    public void createCenterGridPane() {
        //TODO: Make method smaller for checkstyle & readability
        VBox centerVBox = new VBox();
        centerVBox.setAlignment(Pos.CENTER);
        centerVBox.setStyle("-fx-background-color: #86D0F7");
        centerVBox.setSpacing(100);

        GridPane gridPane = new GridPane();
        //gridPane.setStyle("-fx-background-color: #86D0F7");

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(15);
        gridPane.setHgap(20);

        //Name Label
        Label createAcc = new Label("Create Your Account");
        createAcc.setFont(new Font("Century Gothic Bold", 30));


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

        //Button Stuff
        Button button = new Button("Create");
        button.setFont(new Font("Dosis Bold", 20));
        button.setStyle("-fx-background-color: #FFCB3D");

        gridPane.add(name, 0, 0);
        gridPane.add(nameField, 1, 0);
        gridPane.add(emailAddress, 0, 1);
        gridPane.add(emailField, 1, 1);
        gridPane.add(password, 0, 2);
        gridPane.add(passwordField, 1, 2);
        gridPane.add(confirmPassword, 0, 3);
        gridPane.add(confirmPasswordField, 1, 3);
        gridPane.add(button, 0, 4, 2, 1);

        centerVBox.getChildren().addAll(createAcc, gridPane);
        borderPane.setCenter(centerVBox);
    }
}
