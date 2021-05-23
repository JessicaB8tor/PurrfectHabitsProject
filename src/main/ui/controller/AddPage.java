package ui.controller;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Dashboard;

import java.util.Arrays;
import java.util.List;

public class AddPage extends Application {
    private static final String yellow = "-fx-background-color: #FFCB3D";
    private static final String blue = "-fx-background-color: #86D0F7";

    @Override
    public void start(Stage primaryStage) throws Exception {


        //public AddPage(Stage primaryStage, EventHandler eventHandler) {
        VBox vBox = new VBox(10);
        vBox.setPrefSize(1000, 500);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(100));
        vBox.setStyle(blue);

        //Label Stuff
        Label prompt = new Label("Do you want to make or break a habit?");
        Label reasoning = new Label("What is your motivation?");
        List<Label> labels = Arrays.asList(prompt, reasoning);
        for (Label label : labels) {
            label.setFont(new Font("Century Gothic Bold", 40));
        }

        //RadioButton Stuff
        RadioButton makeHabit = new RadioButton("Make");
        makeHabit.setFont(new Font("Dosis Bold", 20));
        RadioButton breakHabit = new RadioButton("Break");
        breakHabit.setFont(new Font("Dosis Bold", 20));
        ToggleGroup toggleGroup = new ToggleGroup();
        makeHabit.setToggleGroup(toggleGroup);
        breakHabit.setToggleGroup(toggleGroup);

        //TextField Stuff
        TextField name = new TextField();
        name.setFocusTraversable(false);
        name.setPromptText("Name of Habit");
        name.s

        TextField reasoningField = new TextField();
        reasoningField.setFocusTraversable(false);
        reasoningField.setMinSize(200, 100);

        vBox.getChildren().addAll(prompt, makeHabit, breakHabit, name, reasoning, reasoningField);


        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


