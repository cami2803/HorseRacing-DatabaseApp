package project.controllers;


import project.DatabaseConnection;
import project.views.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterController {
    private MainFrame mainFrame;
    private DatabaseConnection databaseConnection;

    public RegisterController(MainFrame mainFrame, DatabaseConnection databaseConnection) {
        this.mainFrame = mainFrame;
        this.databaseConnection = databaseConnection;
        this.mainFrame.addCreateAccountListener(new CreateListener());
    }

    class CreateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Connection connection = databaseConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("insert into login (username, password)" + "values (?, ?)");
                preparedStatement.setString(1, mainFrame.getCreateUsernameTextField());
                preparedStatement.setString(2, mainFrame.getCreatePasswordTextField());
                preparedStatement.executeUpdate();
                connection.close();
                mainFrame.showMessage("Account created!");
                mainFrame.refreshRegister();
            } catch (Exception ex) {
                mainFrame.showErrorMessage("Account already exists!");
                mainFrame.refreshRegister();
            }
        }
    }
}
