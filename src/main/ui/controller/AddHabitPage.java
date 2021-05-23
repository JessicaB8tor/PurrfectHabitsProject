package ui.controller;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Dashboard;

import java.util.Arrays;
import java.util.List;

public class AddHabitPage extends Application {
    private static final String yellow = "-fx-background-color: #FFCB3D";
    private static final String yellowHex = "FFCB3D";
    private static final String blue = "-fx-background-color: #86D0F7";
    VBox vBox;
    StackPane topStackPane;
    GridPane topGridPane;
    StackPane bottomStackPane;
    GridPane bottomGridPane;
    GridPane middleGridPane;
    GridPane bottomBottomGridPane;
    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage addStage = new Stage();


        //public AddPage(EventHandler eventHandler) {
        vBox = new VBox(10);
        vBox.setPrefSize(1000, 500);
        vBox.setPadding(new Insets(20));
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle(blue);

        createTopStackPane();
        createFirstGridPane();
        createMiddleGridPane();
        createBottomStackPane();
        createSecondGridPane();
        createBottomBottomGridPane();

        vBox.getChildren().addAll(topStackPane, topGridPane, middleGridPane,bottomStackPane, bottomGridPane, bottomBottomGridPane);

        Scene scene = new Scene(vBox);
        addStage.setScene(scene);
        addStage.show();
    }

    public void createTopStackPane() {
        topStackPane = new StackPane();
        Rectangle rectangle = new Rectangle(500, 100);
        rectangle.setFill(Color.valueOf(yellowHex));

        Label prompt = new Label("Do you want to make or break a habit?");
        prompt.setFont(new Font("Century Gothic Bold", 20));

        topStackPane.getChildren().addAll(rectangle, prompt);
    }

    public void createFirstGridPane() {
        topGridPane = new GridPane();
        topGridPane.setAlignment(Pos.CENTER);

        RadioButton makeHabit = new RadioButton("Make");
        RadioButton breakHabit = new RadioButton("Break");
        makeHabit.setFont(new Font("Dosis Bold", 20));
        breakHabit.setFont(new Font("Dosis Bold", 20));
        ToggleGroup toggleGroup = new ToggleGroup();
        makeHabit.setToggleGroup(toggleGroup);
        breakHabit.setToggleGroup(toggleGroup);
        // makeHabit.setOnAction(eventHandler);


        topGridPane.add(makeHabit, 1, 0);
        topGridPane.add(breakHabit, 1, 1);
    }

    public void createMiddleGridPane() {
        middleGridPane = new GridPane();
        middleGridPane.setAlignment(Pos.CENTER);

        TextField textField = new TextField();
        textField.setPromptText("Name of Habit");
        textField.setFocusTraversable(false);
        textField.setMinSize(500, 50);

        middleGridPane.add(textField, 0, 0);

    }

    public void createBottomStackPane() {
        bottomStackPane = new StackPane();
        Rectangle rectangle = new Rectangle(500, 100);
        rectangle.setFill(Color.valueOf(yellowHex));

        Label prompt = new Label("What is your motivation?");
        prompt.setFont(new Font("Century Gothic Bold", 20));

        bottomStackPane.getChildren().addAll(rectangle, prompt);
    }

    public void createSecondGridPane() {
        bottomGridPane = new GridPane();
        bottomGridPane.setAlignment(Pos.CENTER);

        TextField textField = new TextField();
        textField.setMinSize(500, 100);
        textField.setFocusTraversable(false);
        bottomGridPane.add(textField, 0, 0);
    }

    public void createBottomBottomGridPane() {
        bottomBottomGridPane = new GridPane();
        bottomBottomGridPane.setAlignment(Pos.CENTER);

        button = new Button("Submit");
        button.setFont(new Font("Dosis Bold", 20));
        button.setStyle(yellow);
      //  button.setOnAction(eventHandler);

        bottomBottomGridPane.add(button, 0, 0);
    }

    public Button getButton() {
        return button;
    }
}


