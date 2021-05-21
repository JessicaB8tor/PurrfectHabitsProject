package model;

import model.exceptions.HabitAlreadyExistsException;

import java.io.File;

public class FolderManager {
    private String destination;

    public FolderManager(String destination) {
        this.destination = destination;
    }

    public String getPath() {
        return destination;
    }

    public void createHabitFolder(String folderName) throws HabitAlreadyExistsException {
        String path = destination + "\\" + folderName;
        File folder = new File(path);
        if (!folder.exists()) {
            if (folder.mkdir()) {
                System.out.println("Habit folder has been created successfully");
            } else {
                System.out.println("Habit folder has failed to be created");
            }
        } else {
            System.out.println("Habit folder already exists");
        }


    }

    private void createGalleryFolder(String folderName) {
        String path = destination + "\\" + folderName
    }

    private void createJsonFile(String folderName) {

    }

    public void deleteFolder(String folderName) {
        String path = destination + "\\" + folderName;
        File folder = new File(path);

        deleteFolderHelper(folder);
    }

    private void deleteFolderHelper(File source) {
        File[] files = source.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                deleteFolderHelper(file);
            }

            file.delete();
        }

        source.delete();
    }
}
