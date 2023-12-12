package project.controllers;

import project.DatabaseConnection;
import project.views.ManageAccountFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ManageAccount {
    private JButton deleteButton;
    private JButton updateButton;
    private DatabaseConnection databaseConnection;
    private ManageAccountFrame frame;

    public ManageAccount(JButton deleteButton, JButton updateButton, DatabaseConnection databaseConnection, ManageAccountFrame frame) {
        this.deleteButton = deleteButton;
        this.updateButton = updateButton;
        this.databaseConnection = databaseConnection;
        this.frame = frame;

        this.addDeleteListener(new deleteListener());
        this.addUpdateListener(new updateListener());
    }

    public void addDeleteListener(ActionListener action){
        deleteButton.addActionListener(action);
    }

    public void addUpdateListener(ActionListener action){
        updateButton.addActionListener(action);
    }

    class deleteListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                Connection connection = databaseConnection.getConnection();
                String deleteUsername = frame.getDeleteAccountTextField();

                PreparedStatement statement = connection.prepareStatement("DELETE from login WHERE username=?");
                statement.setString(1, deleteUsername);

                statement.executeUpdate();

                connection.close();
                frame.showMessage("Account deleted!");
                frame.refreshRegister();

            } catch (Exception ex){
                throw new RuntimeException(ex);
                //JOptionPane.showMessageDialog(null, "Can't find an account with this username.", "ERROR", JOptionPane.ERROR_MESSAGE);
                //frame.refreshRegister();
            }
        }
    }

    class updateListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                Connection connection = databaseConnection.getConnection();

                String updateUsername = frame.getUsernameTextField();
                String newUsername = frame.getNewUsernameTextField();
                String newPassword = frame.getNewPasswordTextField();

                PreparedStatement statement = connection.prepareStatement("UPDATE login" + " SET username=?, password=?" + " WHERE username=?");
                statement.setString(1, newUsername);
                statement.setString(2, newPassword);
                statement.setString(3, updateUsername);

                frame.showMessage("Account updated!");
                frame.refreshRegister();

                statement.executeUpdate();
                connection.close();
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Can't find an account with this username.", "ERROR", JOptionPane.ERROR_MESSAGE);

            }
        }
    }
}
