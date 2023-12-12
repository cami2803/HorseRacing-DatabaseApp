package project.controllers;

import project.DatabaseConnection;
import project.models.Associations;
import project.models.Jockey;
import project.models.Price;
import project.models.Prices;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowPrices {
    private JFrame frame;
    private JTable pricesTable;
    private JTable associationTable;
    private JButton showPrices;
    private JButton showAssociations;
    private Prices prices;
    private Associations associations;
    private DatabaseConnection databaseConnection;

    public ShowPrices(JFrame frame, JTable pricesTable, JTable associationTable, JButton showPrices, JButton showAssociations, Prices prices, Associations associations, DatabaseConnection databaseConnection) {
        this.frame = frame;
        this.pricesTable = pricesTable;
        this.associationTable = associationTable;
        this.showPrices = showPrices;
        this.showAssociations = showAssociations;
        this.prices = prices;
        this.associations = associations;
        this.databaseConnection = databaseConnection;

        this.addShowPricesListener(new showPrices());
        this.addShowAssociationsListener(new showAssociations());
    }

    public void addShowPricesListener(ActionListener action) {
        showPrices.addActionListener(action);
    }

    public void addShowAssociationsListener(ActionListener action) {
        showAssociations.addActionListener(action);
    }

    class showPrices implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                prices.getPrices().clear();
                Connection connection = databaseConnection.getConnection();
                String sql = "SELECT * FROM prices";
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);

                DefaultTableModel model = new DefaultTableModel();
                model.setColumnIdentifiers(new String[]{"price_id", "horse_id", "race_id", "time", "price"});
                pricesTable.setModel(model);

                while (result.next()) {
                    int price_id = result.getInt(1);
                    int horse_id = result.getInt(2);
                    int race_id = result.getInt(3);
                    int time = result.getInt(4);
                    int price = result.getInt(5);
                    prices.getPrices().add(new Price(price_id, horse_id, race_id, time, price));
                    model.addRow(new Object[]{price_id, horse_id, race_id, time, price});
                }
                connection.close();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    class showAssociations implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                associations.getAssociationList().clear();
                Connection connection = databaseConnection.getConnection();
                String sql = "SELECT * FROM horse_race_participation";
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);

                DefaultTableModel model = new DefaultTableModel();
                model.setColumnIdentifiers(new String[]{"horse_id", "race_id", "jockey_id", "starting_price", "final_position"});
                associationTable.setModel(model);

                while (result.next()) {
                    int horse_id = result.getInt(1);
                    int race_id = result.getInt(2);
                    int jockey_id = result.getInt(3);
                    int starting_price = result.getInt(4);
                    int final_position = result.getInt(5);
                    prices.getPrices().add(new Price(horse_id, race_id, jockey_id, starting_price, final_position));
                    model.addRow(new Object[]{horse_id, race_id, jockey_id, starting_price, final_position});
                }
                connection.close();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}
