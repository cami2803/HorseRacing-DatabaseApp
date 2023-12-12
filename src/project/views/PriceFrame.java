package project.views;

import project.DatabaseConnection;
import project.controllers.PageNavigator;
import project.controllers.ShowPrices;
import project.models.Associations;
import project.models.Prices;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;

public class PriceFrame extends JFrame {

    private JPanel contentPane;
    private JButton backButton;
    private JTable priceTable;
    private JTable associationTable;

    public PriceFrame() {
        getContentPane().setBackground(new Color(155, 182, 137));
        getContentPane().setLayout(null);

        JLabel priceLabel = new JLabel("Prices");
        priceLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 30));
        priceLabel.setBounds(725, 88, 291, 61);
        getContentPane().add(priceLabel);

        setBackground(new Color(155, 182, 137));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1410, 759);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(155, 182, 137));
        contentPane.setBorder(null);

        backButton = new JButton("Return to Welcome Page");
        backButton.setForeground(new Color(0, 0, 0));
        backButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        backButton.setBounds(31, 84, 281, 40);
        getContentPane().add(backButton);

        JButton closeButton = new JButton("Close Application");
        closeButton.setForeground(Color.BLACK);
        closeButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        closeButton.setBounds(31, 20, 281, 40);
        getContentPane().add(closeButton);

        priceTable = new JTable();
        priceTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[] {
                        "New column", "New column", "New column", "New column", "New column"
                }
        ));
        priceTable.setBounds(98, 338, 472, 80);
        getContentPane().add(priceTable);

        associationTable = new JTable();
        associationTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[] {
                        "New column", "New column", "New column", "New column", "New column"
                }
        ));
        associationTable.setBounds(98, 562, 654, 160);
        getContentPane().add(associationTable);

        JLabel lblNewLabel = new JLabel("Price ID        Horse ID     Race ID       Time          Price");
        lblNewLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel.setBounds(98, 317, 510, 22);
        getContentPane().add(lblNewLabel);

        JLabel lblHorseIdRace = new JLabel("Horse ID               Race ID           Jockey ID       Starting Price    Final Position");
        lblHorseIdRace.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        lblHorseIdRace.setBounds(98, 540, 791, 22);
        getContentPane().add(lblHorseIdRace);

        JButton showbutton1 = new JButton("SHOW");
        showbutton1.setBounds(622, 349, 175, 55);
        getContentPane().add(showbutton1);

        JButton showButton2 = new JButton("SHOW");
        showButton2.setBounds(803, 617, 175, 55);
        getContentPane().add(showButton2);

        JTextArea priceTextArea = new JTextArea();
        priceTextArea.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        priceTextArea.setText("The data from the first table represents the price for a ticket to enter each race stated alongside with the total duration of the race.\r\n\r\nIn the second table it is specified the betting price for each horse with its own jockey and race in which he took a part of, alongside the place he occupied in the race. ");
        priceTextArea.setEditable(false);
        priceTextArea.setWrapStyleWord(true);
        priceTextArea.setLineWrap(true);
        priceTextArea.setBackground(new Color(155, 182, 137));
        priceTextArea.setBounds(1022, 328, 404, 253);
        getContentPane().add(priceTextArea);

        Associations associations = new Associations();
        Prices prices = new Prices();
        DatabaseConnection databaseConnection = new DatabaseConnection();
        ShowPrices showPrices = new ShowPrices(this, priceTable, associationTable, showbutton1, showButton2, prices, associations, databaseConnection);
        PageNavigator pageNavigator = new PageNavigator(this, closeButton, backButton);

        this.setSize(1650,1080);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setVisible(true);
    }

}
