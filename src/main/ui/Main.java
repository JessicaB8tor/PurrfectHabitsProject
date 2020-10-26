package ui;

import java.io.FileNotFoundException;

// Note: this class was based largely on the Main class
//       found in the WorkRoom application provided to
//       us on GitHub.
public class Main {
    public static void main(String[] args) {
        try {
            new JournalApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}
