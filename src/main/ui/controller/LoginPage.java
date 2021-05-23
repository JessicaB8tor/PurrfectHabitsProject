package ui.controller;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class LoginPage {
//    Stage primaryStage;
    VBox loginVBox;

    public LoginPage(Stage primaryStage, EventHandler eventHandler) throws Exception {
        loginVBox = new VBox(10);
        loginVBox.setAlignment(Pos.CENTER);
        loginVBox.setPrefSize(1000, 500);
        loginVBox.setStyle("-fx-background-color: #86D0F7");

        //Image Stuff
        FileInputStream stream = new FileInputStream("data/misc/anonCat.png");
        Image image = new Image(stream);
        ImageView logo = new ImageView(image);
        logo.setFitWidth(200);
        logo.setPreserveRatio(true);

        //TextField stuff
        TextField email = new TextField();
        TextField password = new TextField();
        email.setPromptText("Email");
        password.setPromptText("Password");
        email.setMaxSize(200, 200);
        password.setMaxSize(200, 200);

        //Button Stuff
        Button button = new Button("Submit");
        button.setFont(new Font("Dosis Bold", 20));
        button.setStyle("-fx-background-color: #FFCB3D");

        //CheckBox Stuff
        CheckBox checkBox = new CheckBox("Remember Me?");

        Scene root = new Scene(loginVBox);
        loginVBox.getChildren().addAll(logo, email, password, button, checkBox);
        primaryStage.setScene(root);
        primaryStage.show();
    }
}


