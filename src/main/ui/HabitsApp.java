package ui;

import javafx.stage.Stage;
import model.Dashboard;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.controller.WelcomePage;

import java.io.FileNotFoundException;

public class HabitsApp {
    private static final String habitsFolderDirectory = "./data/habits";
    private Dashboard dashboard;
    private JsonReader jsonReader;
    private JsonWriter jsonWriter;
    private WelcomePage welcomePage;

    public HabitsApp(Stage primaryStage) {
        dashboard = new Dashboard();
        jsonReader = new JsonReader(habitsFolderDirectory);
        jsonWriter = new JsonWriter(habitsFolderDirectory);
        try {
            welcomePage = new WelcomePage(primaryStage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
