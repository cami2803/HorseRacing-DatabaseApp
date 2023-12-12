package project.controllers;

import project.DatabaseConnection;
import project.models.Jockey;
import project.models.Jockeys;
import project.views.JockeysFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowJockeys {
    private JockeysFrame frame;
    private JTable table;
    private JButton button;
    private Jockeys jockeys;
    private DatabaseConnection databaseConnection;

    public ShowJockeys(JockeysFrame frame, JTable table, JButton button, Jockeys jockeys, DatabaseConnection databaseConnection) {
        this.frame = frame;
        this.table = table;
        this.button = button;
        this.jockeys = jockeys;
        this.databaseConnection = databaseConnection;

        this.addShowListener(new showListener());
    }

    public void addShowListener(ActionListener action) {
        button.addActionListener(action);
    }

    class showListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                jockeys.getJockeys().clear();
                Connection connection = databaseConnection.getConnection();
                String sql = "SELECT * FROM jockeys";
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);

                DefaultTableModel model = new DefaultTableModel();
                model.setColumnIdentifiers(new String[]{"id", "name", "gender", "weight(kg)", "other details"});
                table.setModel(model);

                while (result.next()) {
                    int id = result.getInt(1);
                    String name = result.getString(2);
                    String gender = result.getString(3);
                    int weight = result.getInt(4);
                    String other_details = result.getString(5);
                    jockeys.getJockeys().add(new Jockey(id, name, gender, weight, other_details));
                    model.addRow(new Object[]{id, name, gender, weight, other_details});
                }
                connection.close();
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }
        }
    }
}
