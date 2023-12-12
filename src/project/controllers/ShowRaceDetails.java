package project.controllers;

import project.DatabaseConnection;
import project.models.Race;
import project.models.Races;
import project.views.RaceDetailsFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowRaceDetails {
    private RaceDetailsFrame frame;
    private JButton showRatingButton;
    private JButton showTypeButton;
    private JButton showClassButton;
    private DatabaseConnection databaseConnection;
    private JTable ratingTable;
    private JTable typeTable;
    private JTable classTable;
    private Races races;

    public ShowRaceDetails(Races races, RaceDetailsFrame frame, JButton showRatingButton, JButton showTypeButton, JButton showClassButton, DatabaseConnection databaseConnection, JTable ratingTable, JTable classTable, JTable typeTable) {
        this.races = races;
        this.frame = frame;
        this.showRatingButton = showRatingButton;
        this.showTypeButton = showTypeButton;
        this.showClassButton = showClassButton;
        this.databaseConnection = databaseConnection;
        this.classTable = classTable;
        this.typeTable = typeTable;
        this.ratingTable = ratingTable;

        this.addShowRatingListener(new ShowRaceDetails.showRating());
        this.addShowTypeListener(new ShowRaceDetails.showType());
        this.addShowClassListener(new ShowRaceDetails.showClass());
    }

    public void addShowRatingListener(ActionListener action) {
        showRatingButton.addActionListener(action);
    }

    public void addShowTypeListener(ActionListener action) {
        showTypeButton.addActionListener(action);
    }

    public void addShowClassListener(ActionListener action) {
        showClassButton.addActionListener(action);
    }

    class showRating implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                races.getRaces().clear();
                Connection connection = databaseConnection.getConnection();
                String sql = "SELECT * FROM ref_race_ratings";
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);

                DefaultTableModel model = new DefaultTableModel();
                model.setColumnIdentifiers(new String[]{"code", "description"});
                ratingTable.setModel(model);

                ratingTable.getColumnModel().getColumn(0).setMaxWidth(5);
                ratingTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                while (result.next()) {
                    int code = result.getInt(1);
                    String description = result.getString(2);
                    races.getRaces().add(new Race(code, description));
                    model.addRow(new Object[]{code, description});
                }
                connection.close();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    class showType implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                races.getRaces().clear();
                Connection connection = databaseConnection.getConnection();
                String sql = "SELECT * FROM ref_race_types";
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);

                DefaultTableModel model = new DefaultTableModel();
                model.setColumnIdentifiers(new String[]{"code", "description"});
                typeTable.setModel(model);

                typeTable.getColumnModel().getColumn(0).setMaxWidth(5);
                typeTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                while (result.next()) {
                    int code = result.getInt(1);
                    String description = result.getString(2);
                    races.getRaces().add(new Race(code, description));
                    model.addRow(new Object[]{code, description});
                }
                connection.close();

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    class showClass implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                races.getRaces().clear();
                Connection connection = databaseConnection.getConnection();
                String sql = "SELECT * FROM ref_race_classes";
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);

                DefaultTableModel model = new DefaultTableModel();
                model.setColumnIdentifiers(new String[]{"code", "description"});
                classTable.setModel(model);

                classTable.getColumnModel().getColumn(0).setMaxWidth(5);
                classTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                while (result.next()) {
                    int code = result.getInt(1);
                    String description = result.getString(2);
                    races.getRaces().add(new Race(code, description));
                    model.addRow(new Object[]{code, description});
                }
                connection.close();

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}
