package project;

import project.controllers.RegisterController;
import project.views.MainFrame;

public class Main {
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();

        DatabaseConnection databaseConnection = new DatabaseConnection();
        RegisterController registerController = new RegisterController(mainFrame, databaseConnection);

    }
}