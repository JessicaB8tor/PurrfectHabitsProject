package ui;


import javafx.application.Application;
import javafx.stage.Stage;
import ui.controller.LoginPage;


public class Main extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new LoginPage();
    }
}

