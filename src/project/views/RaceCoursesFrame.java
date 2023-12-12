package project.views;

import project.DatabaseConnection;
import project.controllers.PageNavigator;
import project.controllers.ShowRaceCourses;
import project.models.Race;
import project.models.RaceCourses;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;

public class RaceCoursesFrame extends JFrame {
    private JPanel contentPane;
    private JButton backButton;
    private JTable table;
    public RaceCoursesFrame() {
        getContentPane().setBackground(new Color(155, 182, 137));
        getContentPane().setLayout(null);

        JLabel raceLabel = new JLabel("Race Courses");
        raceLabel.setBounds(755, 86, 222, 61);
        raceLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 30));
        getContentPane().add(raceLabel);

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
        table.setModel(new DefaultTableModel(
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
        table.getColumnModel().getColumn(0).setPreferredWidth(15);
        table.getColumnModel().getColumn(0).setMaxWidth(15);
        table.getColumnModel().getColumn(3).setPreferredWidth(70);
        table.getColumnModel().getColumn(3).setMinWidth(70);
        table.getColumnModel().getColumn(3).setMaxWidth(70);
        table.setBounds(50, 414, 889, 160);
        getContentPane().add(table);

        JButton btnNewButton = new JButton("SHOW RACE COURSES");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
        btnNewButton.setBounds(50, 600, 203, 61);
        getContentPane().add(btnNewButton);

        JLabel lblNewLabel = new JLabel("ID");
        lblNewLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel.setBounds(50, 388, 45, 20);
        getContentPane().add(lblNewLabel);

        JLabel lblCourseName = new JLabel("Course Name");
        lblCourseName.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        lblCourseName.setBounds(105, 379, 135, 27);
        getContentPane().add(lblCourseName);

        JLabel lblLocation = new JLabel("Location");
        lblLocation.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        lblLocation.setBounds(395, 386, 119, 13);
        getContentPane().add(lblLocation);

        JLabel lblDistance = new JLabel("Distance");
        lblDistance.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        lblDistance.setBounds(599, 378, 100, 20);
        getContentPane().add(lblDistance);

        JLabel lblOtherDetails = new JLabel("Other Details");
        lblOtherDetails.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        lblOtherDetails.setBounds(742, 382, 119, 20);
        getContentPane().add(lblOtherDetails);

        JLabel imageLabel = new JLabel(".");
        imageLabel.setBounds(986, 389, 525, 359);
        getContentPane().add(imageLabel);
        ImageIcon image = new ImageIcon(this.getClass().getResource("/race.jpg"));
        imageLabel.setIcon(image);

        JTextArea txtrARaceCourse = new JTextArea();
        txtrARaceCourse.setLineWrap(true);
        txtrARaceCourse.setWrapStyleWord(true);
        txtrARaceCourse.setEditable(false);
        txtrARaceCourse.setText("A race course, also known as a racetrack, is a specially designed track on which races, typically between horses or automobiles, take place. These tracks vary in size and complexity, but all feature a clear and defined course for competitors to race on. Many race courses also have grandstands or other seating areas for spectators to watch the races, as well as facilities for trainers, jockeys, and other race participants.");
        txtrARaceCourse.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        txtrARaceCourse.setBackground(new Color(155, 182, 137));
        txtrARaceCourse.setBounds(384, 223, 918, 134);
        getContentPane().add(txtrARaceCourse);

        setBackground(new Color(155, 182, 137));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1410, 759);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(155, 182, 137));
        contentPane.setBorder(null);

        PageNavigator pageNavigator = new PageNavigator(this, closeButton, backButton);

        RaceCourses raceCourses = new RaceCourses();
        DatabaseConnection databaseConnection = new DatabaseConnection();

        ShowRaceCourses showRaceCourses = new ShowRaceCourses(this, btnNewButton, databaseConnection, table, raceCourses);

        this.setSize(1650,1080);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setVisible(true);
    }

}
