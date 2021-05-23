package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Dashboard;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.controller.AlertBox;
import ui.controller.DashboardPage;
import ui.controller.LoginPage;
import ui.controller.WelcomePage;

import java.io.FileNotFoundException;

public class HabitsApp implements EventHandler<ActionEvent> {
    private static final String habitsFolderDirectory = "./data/habits";
    private static final String isInitialDirectory = "./data/misc/launch.json";
    private static final String signInDirectory = "./data/misc/signIn.json";
    private static final String accountDirectory = "./data/misc/account.json";
    private Dashboard dashboard;
    private JsonReader jsonReader;
    private JsonReader isInitialReader;
    private JsonReader rememberMeReader;
    private JsonReader accountReader;
    private JsonWriter jsonWriter;
    private JsonWriter isInitialWriter;
    private JsonWriter rememberMeWriter;
    private JsonWriter accountWriter;
    private WelcomePage welcomePage;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private boolean isInitialLaunch;

    public HabitsApp(Stage primaryStage) {
        dashboard = new Dashboard();
        jsonReader = new JsonReader(habitsFolderDirectory);
        jsonWriter = new JsonWriter(habitsFolderDirectory);
        isInitialReader = new JsonReader(isInitialDirectory);
        rememberMeReader = new JsonReader(signInDirectory);
        if (isInitialReader.readIsInitial()) {
            try {
                welcomePage = new WelcomePage(primaryStage, this);
                isInitialWriter = new JsonWriter(isInitialDirectory);
                isInitialWriter.setIsInitialLaunchFalse();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            if (!rememberMeReader.readShouldRemember()) {
                try {
                    loginPage = new LoginPage(primaryStage, this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    dashboardPage = new DashboardPage(primaryStage, this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
            // switch scenes to about us page
        }
    }

    private void loginPageListener(ActionEvent event) {
        if (event.getSource() == loginPage.getSignInButton()) {
            CheckBox rememberMe = loginPage.getRememberMe();
            TextField email = loginPage.getEmail();
            TextField password = loginPage.getPassword();

            if (rememberMe.isSelected()) {
                rememberMeWriter.setRememberMeTrue();
            }

            accountReader = new JsonReader(accountDirectory);
            if (email.getText() == accountReader.readEmail() && password.getText() == accountReader.readPassword()) {
                // switch scenes to dashboard page
            } else {
                AlertBox.display("PurrfectHabits", "Email or password is incorrect.");
            }

        }
    }
}
