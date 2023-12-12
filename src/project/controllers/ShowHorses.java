package project.controllers;

import project.DatabaseConnection;
import project.models.Horse;
import project.models.Horses;
import project.views.HorsesFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowHorses {
    private HorsesFrame frame;
    private JTable table;
    private JButton button;
    private Horses horses;
    private DatabaseConnection databaseConnection;

    public ShowHorses(HorsesFrame frame, JTable table, JButton button, Horses horses, DatabaseConnection databaseConnection) {
        this.frame = frame;
        this.table = table;
        this.button = button;
        this.horses = horses;
        this.databaseConnection = databaseConnection;

        this.addShowListener(new showListener());
    }

    public void addShowListener(ActionListener action){
        button.addActionListener(action);
    }

    class showListener  implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                horses.getHorseList().clear();
                Connection connection = databaseConnection.getConnection();
                String sql = "SELECT * FROM horses";
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);

                DefaultTableModel model = new DefaultTableModel();
                model.setColumnIdentifiers(new String[]{"horse_id", "trainer_id", "name", "age", "other details"});
                table.setModel(model);

                table.getColumnModel().getColumn(0).setPreferredWidth(80);
                table.getColumnModel().getColumn(0).setMinWidth(80);
                table.getColumnModel().getColumn(0).setMaxWidth(80);
                table.getColumnModel().getColumn(1).setPreferredWidth(100);
                table.getColumnModel().getColumn(1).setMinWidth(100);
                table.getColumnModel().getColumn(1).setMaxWidth(100);
                table.getColumnModel().getColumn(2).setPreferredWidth(100);
                table.getColumnModel().getColumn(2).setMinWidth(200);
                table.getColumnModel().getColumn(2).setMaxWidth(200);
                table.getColumnModel().getColumn(3).setPreferredWidth(70);
                table.getColumnModel().getColumn(3).setMinWidth(70);
                table.getColumnModel().getColumn(3).setMaxWidth(70);

                while (result.next()) {
                    int horse_id = result.getInt(1);
                    int trainer_id = result.getInt(2);
                    String name = result.getString(3);
                    int age = result.getInt(4);
                    String other_details = result.getString(5);
                    horses.getHorseList().add(new Horse(horse_id, trainer_id, name, age, other_details));
                    model.addRow(new Object[]{horse_id, trainer_id, name, age, other_details});
                }
                connection.close();
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }
        }
    }

}
