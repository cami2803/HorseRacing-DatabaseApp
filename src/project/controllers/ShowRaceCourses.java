package project.controllers;

import project.DatabaseConnection;
import project.models.RaceCourse;
import project.models.RaceCourses;
import project.views.RaceCoursesFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowRaceCourses {
    private RaceCoursesFrame frame;
    private JButton button;
    private DatabaseConnection databaseConnection;
    private JTable table;
    private RaceCourses raceCourses;

    public ShowRaceCourses(RaceCoursesFrame frame, JButton button, DatabaseConnection databaseConnection, JTable table, RaceCourses raceCourses) {
        this.frame = frame;
        this.button = button;
        this.databaseConnection = databaseConnection;
        this.table = table;
        this.raceCourses = raceCourses;

        this.addShowRatingListener(new showListener());
    }

    public void addShowRatingListener(ActionListener action) {
        button.addActionListener(action);
    }

    class showListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                raceCourses.getRaceCourseList().clear();
                Connection connection = databaseConnection.getConnection();
                String sql = "SELECT * FROM race_courses";
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);

                DefaultTableModel model = new DefaultTableModel();
                model.setColumnIdentifiers(new String[]{"code", "name", "location", "distance", "other_details"});
                table.setModel(model);

                table.getColumnModel().getColumn(0).setPreferredWidth(20);
                table.getColumnModel().getColumn(0).setMaxWidth(20);
                table.getColumnModel().getColumn(3).setPreferredWidth(70);
                table.getColumnModel().getColumn(3).setMinWidth(70);
                table.getColumnModel().getColumn(3).setMaxWidth(70);
                table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                while (result.next()) {
                    int code = result.getInt(1);
                    String name = result.getString(2);
                    String location = result.getString(3);
                    int distance = result.getInt(4);
                    String other_details = result.getString(5);
                    raceCourses.getRaceCourseList().add(new RaceCourse(code, name, location, distance, other_details));
                    model.addRow(new Object[]{code, name, location, distance, other_details});
                }
                connection.close();

            }catch (Exception ex){
                throw new RuntimeException(ex);
            }
        }
    }
}
