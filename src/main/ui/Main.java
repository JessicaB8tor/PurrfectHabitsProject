package ui;

import ui.controller.JournalAppGui;
import ui.viewer.LaunchPage;

// Note: this class was based largely on the Main classes
//       found in both the WorkRoom application and the TellerApp
//       application provided to us on GitHub.
//       URLS: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
//             https://github.students.cs.ubc.ca/CPSC210/TellerApp
//public class Main {
//    public static void main(String[] args) {
//        try {
//            new JournalApp();
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to run application: file not found");
//        }
//    }
//}
public class Main {
    public static void main(String[] args) {
        new LaunchPage();
    }
}

