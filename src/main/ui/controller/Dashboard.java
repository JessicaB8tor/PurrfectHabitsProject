package ui.controller;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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
        bottomHBox.setStyle("-fx-background-color: #86D0F7");
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
            b.setStyle("-fx-background-color: #86D0F7");

        }

        leftVBox.getChildren().addAll(myHabits, addHabit, deleteHabit);
    }

    private void createCenterGridPane() {
        //TODO: Put graph into seperate class
        //TODO: Figure out some styling/CSS for graph
        //TODO: Connect real data/stats to graph

        GridPane centerGridPane = new GridPane();
        centerGridPane.setAlignment(Pos.CENTER);
        borderPane.setCenter(centerGridPane);


        //Defining the x axis
        NumberAxis theXAxis = new NumberAxis(0, 10, 1);
        theXAxis.setLabel("Days");
       // theXAxis.setStyle("-fx-background-color: #86D0F7");



        //Defining the y axis
        NumberAxis theYAxis = new NumberAxis(0, 30,  1);
        theYAxis.setLabel("No.of Cat Photos");
        theYAxis.setStyle("-fx-background-color: #86D0F7");

        //Creating the line chart
        LineChart linechart = new LineChart(theXAxis, theYAxis);


        //Prepare XYChart.Series objects by setting data
        XYChart.Series series = new XYChart.Series();
        series.setName("Cat Photos Collected");

        //Test Data -> Connect Somehow with real stats
        series.getData().add(new XYChart.Data(0, 0));
        series.getData().add(new XYChart.Data(1, 1));
        series.getData().add(new XYChart.Data(2, 4));
        series.getData().add(new XYChart.Data(3, 10));
        series.getData().add(new XYChart.Data(4, 5));
        series.getData().add(new XYChart.Data(5, 20));

//        Node line = series.getNode().lookup(".chart-series-line");
//        line.setStyle("-fx-fill: #FF0000");

        //Setting the data to Line chart
        linechart.getData().add(series);

        centerGridPane.getChildren().add(linechart);
    }
}
