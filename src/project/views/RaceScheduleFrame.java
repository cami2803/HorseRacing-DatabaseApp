package project.views;

import project.DatabaseConnection;
import project.controllers.PageNavigator;
import project.controllers.ShowRaceSchedule;
import project.models.Schedules;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RaceScheduleFrame extends JFrame {

    private JPanel contentPane;
    private JTable racesTable;
    private JTextArea raceTextArea;
    private JButton backButton;

    public RaceScheduleFrame() {
        getContentPane().setBackground(new Color(155, 182, 137));
        getContentPane().setLayout(null);

        JLabel raceScheduleLabel = new JLabel("Race Schedules");
        raceScheduleLabel.setBounds(725, 88, 291, 61);
        raceScheduleLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 30));
        getContentPane().add(raceScheduleLabel);

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

        racesTable = new JTable();
        racesTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null, null, null},
                },
                new String[] {
                        "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
                }
        ));
        racesTable.setBounds(98, 562, 1388, 160);
        getContentPane().add(racesTable);

        raceTextArea = new JTextArea();
        raceTextArea.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        raceTextArea.setText("In the table below, you can see details about all races. The first column contains an ID for each race, the next 3 columns contain the ID for the class, course, rating and type of every race. These can be seen in the \"Race Details\" (class, rating, type), whereas the course in the \"Race Courses\" page. Next we have the distance which is written in km, a date and a time for each race.");
        raceTextArea.setWrapStyleWord(true);
        raceTextArea.setLineWrap(true);
        raceTextArea.setEditable(false);
        raceTextArea.setBackground(new Color(155, 182, 137));
        raceTextArea.setBounds(296, 253, 508, 202);
        getContentPane().add(raceTextArea);

        JButton btnNewButton_1 = new JButton("SHOW");
        btnNewButton_1.setBounds(1065, 330, 175, 55);
        getContentPane().add(btnNewButton_1);

        JLabel raceLabel = new JLabel("Race ID");
        raceLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        raceLabel.setBounds(98, 531, 89, 33);
        getContentPane().add(raceLabel);

        JLabel classLabel = new JLabel("Class Code");
        classLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        classLabel.setBounds(246, 531, 152, 33);
        getContentPane().add(classLabel);

        JLabel courseLabel = new JLabel("Course ID");
        courseLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        courseLabel.setBounds(403, 531, 152, 33);
        getContentPane().add(courseLabel);

        JLabel lblRaceRatingCode = new JLabel("Rating Code");
        lblRaceRatingCode.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        lblRaceRatingCode.setBounds(562, 531, 152, 33);
        getContentPane().add(lblRaceRatingCode);

        JLabel lblTypeCode = new JLabel("Type Code");
        lblTypeCode.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        lblTypeCode.setBounds(712, 531, 152, 33);
        getContentPane().add(lblTypeCode);

        JLabel lblDistance = new JLabel("Distance");
        lblDistance.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        lblDistance.setBounds(865, 531, 152, 33);
        getContentPane().add(lblDistance);

        JLabel lblDate = new JLabel("Date");
        lblDate.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        lblDate.setBounds(1027, 531, 65, 33);
        getContentPane().add(lblDate);

        JLabel lblTime = new JLabel("Time");
        lblTime.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        lblTime.setBounds(1176, 531, 65, 33);
        getContentPane().add(lblTime);

        JLabel lblOtherDetails = new JLabel("Other Details");
        lblOtherDetails.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        lblOtherDetails.setBounds(1334, 531, 152, 33);
        getContentPane().add(lblOtherDetails);

        setBackground(new Color(155, 182, 137));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1410, 759);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(155, 182, 137));
        contentPane.setBorder(null);

        Schedules schedules = new Schedules();
        DatabaseConnection databaseConnection = new DatabaseConnection();
        PageNavigator pageNavigator = new PageNavigator(this, closeButton, backButton);
        ShowRaceSchedule showRaceSchedule = new ShowRaceSchedule(this, racesTable, btnNewButton_1, databaseConnection, schedules);

        this.setSize(1650, 1080);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setVisible(true);
    }
}