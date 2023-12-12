package project.controllers;

import project.DatabaseConnection;
import project.models.Schedule;
import project.models.Schedules;
import project.views.RaceScheduleFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ShowRaceSchedule {
    private RaceScheduleFrame frame;
    private JTable table;
    private JButton button;
    private DatabaseConnection databaseConnection;
    private Schedules schedules;

    public ShowRaceSchedule(RaceScheduleFrame frame, JTable table, JButton button, DatabaseConnection databaseConnection, Schedules schedules) {
        this.frame = frame;
        this.table = table;
        this.button = button;
        this.databaseConnection = databaseConnection;
        this.schedules = schedules;

        this.addShowListener(new showListener());
    }

    public void addShowListener(ActionListener action){
        button.addActionListener(action);
    }

    class showListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                schedules.getScheduleList().clear();
                Connection connection = databaseConnection.getConnection();
                String sql = "SELECT * FROM races";
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);

                DefaultTableModel model = new DefaultTableModel();
                model.setColumnIdentifiers(new String[]{"Race_ID", "Race_Class_Code", "Race_Course_ID", "Race_Rating_Code", "Race_Type_Code", "Distance", "Date", "Race_Time", "Other_Details"});
                table.setModel(model);

                while (result.next()) {
                    int race_id = result.getInt(1);
                    int race_class_code = result.getInt(2);
                    int race_course_id = result.getInt(3);
                    int race_rating_code = result.getInt(4);
                    int race_type_code = result.getInt(5);
                    int distance = result.getInt(6);
                    Date date = result.getDate(7);
                    Time time = result.getTime(8);
                    String other_details = result.getString(9);
                    schedules.getScheduleList().add(new Schedule(race_id, race_class_code, race_course_id, race_rating_code, race_type_code, distance, date, time, other_details));
                    model.addRow(new Object[]{race_id, race_class_code, race_course_id, race_rating_code, race_type_code, distance, date, time, other_details});
                }
            } catch (Exception ex){
                throw new RuntimeException(ex);
            }
        }
    }
}
