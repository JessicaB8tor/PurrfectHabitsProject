package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import model.Dashboard;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.controller.LoginPage;
import ui.controller.WelcomePage;

import java.io.FileNotFoundException;

public class HabitsApp implements EventHandler<ActionEvent> {
    private static final String habitsFolderDirectory = "./data/habits";
    private static final String isInitialDirectory = "./data/misc/launch.json";
    private Dashboard dashboard;
    private JsonReader jsonReader;
    private JsonReader isInitialReader;
    private JsonWriter jsonWriter;
    private JsonWriter isInitialWriter;
    private WelcomePage welcomePage;
    private LoginPage loginPage;
    private boolean isInitialLaunch;

    public HabitsApp(Stage primaryStage) {
        dashboard = new Dashboard();
        jsonReader = new JsonReader(habitsFolderDirectory);
        jsonWriter = new JsonWriter(habitsFolderDirectory);

        isInitialReader = new JsonReader(isInitialDirectory);
        if (isInitialReader.readIsInitial()) {
            try {
                welcomePage = new WelcomePage(primaryStage, this);
                isInitialWriter = new JsonWriter(isInitialDirectory);
                isInitialWriter.setIsInitialLaunchFalse();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                loginPage = new LoginPage(primaryStage, this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void handle(ActionEvent event) {
        welcomePageListener(event);
        loginPageListener(event);
    }

    private void welcomePageListener(ActionEvent event) {
        if (event.getSource() == welcomePage.getGetStartedButton()) {
            // switch scenes
        }
    }

    private void loginPageListener(ActionEvent event) {

    }
}
