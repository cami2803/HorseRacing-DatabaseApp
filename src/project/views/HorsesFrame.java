package project.views;

import project.DatabaseConnection;
import project.controllers.PageNavigator;
import project.controllers.ShowDetails;
import project.controllers.ShowHorses;
import project.models.Details;
import project.models.Horses;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;

public class HorsesFrame extends JFrame {

    private JPanel contentPane;
    private JButton backButton;
    private JTable table;
    private JTable detailTable;

    public HorsesFrame() {
        getContentPane().setBackground(new Color(155, 182, 137));
        getContentPane().setLayout(null);

        JLabel horseLabel = new JLabel("Horses");
        horseLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 30));
        horseLabel.setBounds(755, 86, 222, 61);
        getContentPane().add(horseLabel);

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


        table = new JTable();
        table.setBounds(47, 241, 895, 160);
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {"", null, null, null, null},
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
        getContentPane().add(table);

        JLabel lblHorseId = new JLabel("Horse ID");
        lblHorseId.setBounds(47, 219, 109, 20);
        lblHorseId.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        getContentPane().add(lblHorseId);

        JLabel lblTrainerId = new JLabel("Trainer ID");
        lblTrainerId.setBounds(135, 216, 135, 27);
        lblTrainerId.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        getContentPane().add(lblTrainerId);

        JLabel lblHorseName = new JLabel("Horse Name");
        lblHorseName.setBounds(251, 221, 119, 17);
        lblHorseName.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        getContentPane().add(lblHorseName);

        JLabel lblAge = new JLabel("Age\r\n");
        lblAge.setBounds(432, 209, 100, 40);
        lblAge.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        getContentPane().add(lblAge);

        JLabel lblOtherDetails = new JLabel("Other Details");
        lblOtherDetails.setBounds(515, 219, 119, 20);
        lblOtherDetails.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        getContentPane().add(lblOtherDetails);

        JButton btnShowHorses = new JButton("SHOW HORSES");
        btnShowHorses.setBounds(47, 405, 203, 61);
        btnShowHorses.setFont(new Font("Tahoma", Font.PLAIN, 10));
        getContentPane().add(btnShowHorses);

        detailTable = new JTable();
        detailTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                },
                new String[] {
                        "New column", "New column", "New column"
                }
        ));
        detailTable.getColumnModel().getColumn(0).setPreferredWidth(80);
        detailTable.getColumnModel().getColumn(0).setMinWidth(0);
        detailTable.getColumnModel().getColumn(0).setMaxWidth(80);
        detailTable.setBounds(47, 501, 550, 160);
        getContentPane().add(detailTable);

        JLabel lblHorseId_1 = new JLabel("Horse ID");
        lblHorseId_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        lblHorseId_1.setBounds(49, 482, 109, 20);
        getContentPane().add(lblHorseId_1);

        JLabel lblLikes = new JLabel("Likes");
        lblLikes.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        lblLikes.setBounds(150, 482, 109, 20);
        getContentPane().add(lblLikes);

        JLabel lblDislikes = new JLabel("Dislikes");
        lblDislikes.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        lblDislikes.setBounds(377, 482, 109, 20);
        getContentPane().add(lblDislikes);

        JButton btnShowDetailsAbout = new JButton("SHOW DETAILS ABOUT EACH HORSE");
        btnShowDetailsAbout.setFont(new Font("Tahoma", Font.PLAIN, 10));
        btnShowDetailsAbout.setBounds(47, 671, 253, 61);
        getContentPane().add(btnShowDetailsAbout);

        JLabel imageLabel = new JLabel(".");
        imageLabel.setBounds(655, 437, 300, 364);
        getContentPane().add(imageLabel);
        ImageIcon image = new ImageIcon(this.getClass().getResource("/cute.jpg"));
        imageLabel.setIcon(image);

        JTextArea txtrHorsesAreMajestic = new JTextArea();
        txtrHorsesAreMajestic.setText("Horses are majestic and powerful animals that have been used by humans for a variety of purposes for thousands of years. They are known for their beauty, speed, and strength, and have played important roles in human history as transportation, in agriculture, in warfare and in sports. Domesticated horses are trained to be ridden and used in a variety of disciplines such as dressage, show jumping, and racing. They are also used for therapeutic purposes, and as companions. They come in a wide range of breeds, each with their own unique characteristics and traits.");
        txtrHorsesAreMajestic.setEditable(false);
        txtrHorsesAreMajestic.setWrapStyleWord(true);
        txtrHorsesAreMajestic.setLineWrap(true);
        txtrHorsesAreMajestic.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        txtrHorsesAreMajestic.setBackground(new Color(155, 182, 137));
        txtrHorsesAreMajestic.setBounds(1056, 270, 407, 442);
        getContentPane().add(txtrHorsesAreMajestic);

        Horses horses = new Horses();
        Details details = new Details();
        DatabaseConnection databaseConnection = new DatabaseConnection();

        ShowDetails showDetails = new ShowDetails( this, detailTable, btnShowDetailsAbout, details, databaseConnection);
        ShowHorses showHorses = new ShowHorses(this, table, btnShowHorses, horses, databaseConnection);
        PageNavigator pageNavigator = new PageNavigator(this, closeButton, backButton);

        this.setSize(1650,1080);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setVisible(true);
    }

}
