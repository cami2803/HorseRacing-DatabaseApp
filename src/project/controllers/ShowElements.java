package project.controllers;

import project.models.Trainer;
import project.models.Trainers;
import project.DatabaseConnection;
import project.views.TrainersFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ShowElements {
    private TrainersFrame frame;
    private JButton button;
    private JButton updateButton;
    private JButton deleteButton;
    private Trainers trainers;
    private JTable table;
    private DatabaseConnection databaseConnection;
    public ShowElements(TrainersFrame frame, JButton button, DatabaseConnection databaseConnection, Trainers trainers, JTable table, JButton updateButton, JButton deleteButton) {
        this.frame = frame;
        this.trainers = trainers;
        this.button = button;
        this.updateButton = updateButton;
        this.deleteButton = deleteButton;
        this.table = table;
        this.databaseConnection = databaseConnection;

        this.addShowListener(new showListener());
        this.addUpdateListener(new updateListener());
        this.addDeleteListener(new deleteListener());
    }

    public void addShowListener(ActionListener action) {
        button.addActionListener(action);
    }
    public void addUpdateListener(ActionListener action) {
        updateButton.addActionListener(action);
    }

    public void addDeleteListener(ActionListener action){
        deleteButton.addActionListener(action);
    }

    class showListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                trainers.getTrainers().clear();
                Connection connection = databaseConnection.getConnection();
                String sql = "SELECT * FROM trainers";
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);

                DefaultTableModel model = new DefaultTableModel();
                model.setColumnIdentifiers(new String[]{"id", "name", "other details"});
                table.setModel(model);

                while (result.next()) {
                    int id = result.getInt(1);
                    String name = result.getString(2);
                    String other_details = result.getString(3);
                    trainers.getTrainers().add(new Trainer(id, name, other_details));
                    model.addRow(new Object[]{id, name, other_details});
                }
                connection.close();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        }
    }

    class updateListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                Connection connection = databaseConnection.getConnection();

                int id = frame.getUpdateIDLabelTextField();
                String name = frame.getUpdateNameLabelTextField();
                String other_details = frame.getUpdateOtherDetailsLabeltextField();

                PreparedStatement statement = connection.prepareStatement("UPDATE trainers" + " SET Name=?, Other_Details=?" + " WHERE Trainer_ID=?");
                statement.setString(1, name);
                statement.setString(2, other_details);
                statement.setInt(3, id);

                statement.executeUpdate();
                connection.close();
            }catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    class deleteListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                Connection connection = databaseConnection.getConnection();
                Statement statement = connection.createStatement();

                int id = frame.getDeleteIDTextField();

                String q1 = "DELETE from trainers WHERE Trainer_ID= " + id;

                statement.executeUpdate(q1);

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}