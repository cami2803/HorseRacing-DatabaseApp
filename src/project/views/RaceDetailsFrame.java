package project.views;

import project.DatabaseConnection;
import project.controllers.PageNavigator;
import project.controllers.ShowRaceDetails;
import project.models.Races;

import javax.swing.*;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class RaceDetailsFrame extends JFrame {

    private JPanel contentPane;
    private JTable ratingTable;
    private JTable typeTable;
    private JTable classTable;
    private JButton backButton;

    public RaceDetailsFrame() {
        getContentPane().setBackground(new Color(155, 182, 137));
        getContentPane().setLayout(null);

        JLabel raceDetailsLabel = new JLabel("Race Details");
        raceDetailsLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 30));
        raceDetailsLabel.setBounds(725, 88, 291, 61);
        getContentPane().add(raceDetailsLabel);

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

        PageNavigator pageNavigator = new PageNavigator(this, closeButton, backButton);

        ratingTable = new JTable();
        ratingTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                },
                new String[] {
                        "New column", "New column"
                }
        ));
        ratingTable.getColumnModel().getColumn(0).setPreferredWidth(15);
        ratingTable.getColumnModel().getColumn(0).setMaxWidth(15);
        ratingTable.setBounds(345, 190, 298, 112);
        getContentPane().add(ratingTable);

        typeTable = new JTable();
        typeTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                },
                new String[] {
                        "New column", "New column"
                }
        ));
        typeTable.getColumnModel().getColumn(0).setMaxWidth(5);
        typeTable.setBounds(345, 440, 651, 96);
        getContentPane().add(typeTable);

        classTable = new JTable();
        classTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null},
                },
                new String[] {
                        "New column", "New column"
                }
        ));
        classTable.getColumnModel().getColumn(0).setPreferredWidth(15);
        classTable.getColumnModel().getColumn(0).setMaxWidth(15);
        classTable.setBounds(707, 667, 675, 96);
        getContentPane().add(classTable);

        JLabel codeRatingLabel = new JLabel("Code");
        codeRatingLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        codeRatingLabel.setBounds(345, 166, 45, 20);
        getContentPane().add(codeRatingLabel);

        JLabel descrRatingLabel = new JLabel("Description");
        descrRatingLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        descrRatingLabel.setBounds(453, 163, 116, 27);
        getContentPane().add(descrRatingLabel);

        JTextArea ratingTextArea = new JTextArea();
        ratingTextArea.setBackground(new Color(155, 182, 137));
        ratingTextArea.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        ratingTextArea.setText("Horse racing ratings are a system used to evaluate the performance of horses in races and assign a numerical score to each horse. These ratings are typically based on the horse's past performances and are used to predict its likelihood of winning future races.");
        ratingTextArea.setWrapStyleWord(true);
        ratingTextArea.setLineWrap(true);
        ratingTextArea.setEditable(false);
        ratingTextArea.setBounds(39, 177, 281, 144);
        getContentPane().add(ratingTextArea);

        JButton showRatingsButton = new JButton("SHOW HORSE RACING RATINGS");
        showRatingsButton.setBounds(39, 331, 241, 27);
        getContentPane().add(showRatingsButton);

        JTextArea typeTextArea = new JTextArea();
        typeTextArea.setWrapStyleWord(true);
        typeTextArea.setText("There are several different types of horse racing, each with its own set of rules and regulations. There are many other types of horse racing as well, including Arabian horse racing, pony racing, and endurance racing. Each type of horse racing has its own unique characteristics and attracts a dedicated following of fans and participants. Here are some of the main types.");
        typeTextArea.setLineWrap(true);
        typeTextArea.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        typeTextArea.setEditable(false);
        typeTextArea.setBackground(new Color(155, 182, 137));
        typeTextArea.setBounds(39, 424, 281, 202);
        getContentPane().add(typeTextArea);

        JButton showTypesButton = new JButton("SHOW HORSE RACING TYPES");
        showTypesButton.setBounds(39, 636, 241, 27);
        getContentPane().add(showTypesButton);

        JLabel codeTypeLabel = new JLabel("Code");
        codeTypeLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        codeTypeLabel.setBounds(345, 424, 45, 13);
        getContentPane().add(codeTypeLabel);

        JLabel descrTypeLabel = new JLabel("Description");
        descrTypeLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        descrTypeLabel.setBounds(574, 417, 178, 20);
        getContentPane().add(descrTypeLabel);

        JLabel descrClassLabel = new JLabel("Description");
        descrClassLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        descrClassLabel.setBounds(831, 640, 123, 23);
        getContentPane().add(descrClassLabel);

        JLabel codeClassLabel = new JLabel("Code");
        codeClassLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        codeClassLabel.setBounds(707, 638, 45, 27);
        getContentPane().add(codeClassLabel);

        JTextArea classTextArea = new JTextArea();
        classTextArea.setWrapStyleWord(true);
        classTextArea.setText("In horse racing, classes refer to categories of horses based on their age, gender, and level of experience. These classes are used to group horses together for the purpose of competition, and each class has its own set of rules and restrictions. Here are some horse racing classes.");
        classTextArea.setLineWrap(true);
        classTextArea.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        classTextArea.setEditable(false);
        classTextArea.setBackground(new Color(155, 182, 137));
        classTextArea.setBounds(414, 601, 281, 162);
        getContentPane().add(classTextArea);

        JButton showClassButton = new JButton("SHOW HORSE RACING CLASSES");
        showClassButton.setBounds(414, 777, 235, 27);
        getContentPane().add(showClassButton);

        JLabel imageLabel = new JLabel("");
        imageLabel.setBounds(1006, 140, 409, 517);
        getContentPane().add(imageLabel);
        ImageIcon image = new ImageIcon(this.getClass().getResource("/details.jpeg"));
        imageLabel.setIcon(image);

        Races races = new Races();
        DatabaseConnection databaseConnection = new DatabaseConnection();
        ShowRaceDetails showRaceDetails = new ShowRaceDetails(races, this, showRatingsButton, showTypesButton, showClassButton, databaseConnection, ratingTable, classTable, typeTable);

        this.setSize(1650, 1080);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setVisible(true);
    }

}