package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Dashboard;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.controller.*;

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
    private AboutUsPage aboutUsPage;
    private Stage primaryStage;

    public HabitsApp(Stage primaryStage) {
        this.primaryStage = primaryStage;
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
        aboutUsPageListener(event);
        loginPageListener(event);
    }

    private void welcomePageListener(ActionEvent event) {
        if (welcomePage != null && event.getSource() == welcomePage.getGetStartedButton()) {
            try {
                aboutUsPage = new AboutUsPage(primaryStage, this);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void aboutUsPageListener(ActionEvent event) {
        if (aboutUsPage != null && event.getSource() == aboutUsPage.)
    }

    private void loginPageListener(ActionEvent event) {
        if (loginPage != null && event.getSource() == loginPage.getSignInButton()) {
            CheckBox rememberMe = loginPage.getRememberMe();
            TextField email = loginPage.getEmail();
            TextField password = loginPage.getPassword();

            accountReader = new JsonReader(accountDirectory);
            if (email.getText().equals(accountReader.readEmail()) && password.getText().equals(accountReader.readPassword())) {
                if (rememberMe.isSelected()) {
                    rememberMeWriter = new JsonWriter(signInDirectory);
                    rememberMeWriter.setRememberMeTrue();
                }
                // switch scenes to dashboard page
            } else {
                AlertBox.display("PurrfectHabits", "Email or password is incorrect.");
            }

        }
    }
}
