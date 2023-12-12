package project.controllers;

import project.DatabaseConnection;
import project.models.Detail;
import project.models.Details;
import project.views.HorsesFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowDetails {
    private HorsesFrame frame;
    private JTable table;
    private JButton button;
    private Details details;
    private DatabaseConnection databaseConnection;

    public ShowDetails(HorsesFrame frame, JTable table, JButton button, Details details, DatabaseConnection databaseConnection) {
        this.frame = frame;
        this.table = table;
        this.button = button;
        this.details = details;
        this.databaseConnection = databaseConnection;

        this.addShowListener(new ShowDetails.showListener());
    }

    public void addShowListener(ActionListener action){
        button.addActionListener(action);
    }

    class showListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                details.getDetails().clear();
                Connection connection = databaseConnection.getConnection();
                String sql = "SELECT * FROM horse_details";
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);

                DefaultTableModel model = new DefaultTableModel();
                model.setColumnIdentifiers(new String[]{"horse_id", "likes", "dislikes"});
                table.setModel(model);

                table.getColumnModel().getColumn(0).setPreferredWidth(80);
                table.getColumnModel().getColumn(0).setMinWidth(0);
                table.getColumnModel().getColumn(0).setMaxWidth(80);

                while (result.next()) {
                    int horse_id = result.getInt(1);
                    String likes = result.getString(2);
                    String dislikes = result.getString(3);
                    details.getDetails().add(new Detail(horse_id, likes, dislikes));
                    model.addRow(new Object[]{horse_id, likes, dislikes});
                }
                connection.close();
            }catch (Exception ex){
                throw new RuntimeException(ex);
            }
        }
    }
}
