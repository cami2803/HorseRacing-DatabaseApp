package project.views;

import project.DatabaseConnection;
import project.controllers.PageNavigator;
import project.controllers.ShowJockeys;
import project.models.Jockeys;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;

public class JockeysFrame extends JFrame {

    private JPanel contentPane;
    private JButton backButton;
    private JTable table;

    public JockeysFrame() {
        getContentPane().setBackground(new Color(155, 182, 137));
        getContentPane().setLayout(null);

        JLabel jockeysLabel = new JLabel(" Jockeys");
        jockeysLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 30));
        jockeysLabel.setBounds(725, 88, 291, 61);
        getContentPane().add(jockeysLabel);

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

        JButton btnNewButton = new JButton("SHOW");
        btnNewButton.setBounds(47, 657, 175, 55);
        getContentPane().add(btnNewButton);

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
        table.setToolTipText("");
        table.setFont(new Font("Cambria", Font.ITALIC, 15));
        table.setBounds(232, 588, 1181, 160);
        getContentPane().add(table);

        JLabel lblId = new JLabel("ID");
        lblId.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        lblId.setBounds(232, 562, 66, 30);
        getContentPane().add(lblId);

        JLabel lblName_1 = new JLabel("Name");
        lblName_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        lblName_1.setBounds(469, 562, 128, 30);
        getContentPane().add(lblName_1);

        JLabel lblOtherDetails_1 = new JLabel("Other Details");
        lblOtherDetails_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        lblOtherDetails_1.setBounds(1179, 562, 141, 30);
        getContentPane().add(lblOtherDetails_1);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        lblGender.setBounds(704, 562, 128, 30);
        getContentPane().add(lblGender);

        JLabel lblWeightkg = new JLabel("Weight(kg)");
        lblWeightkg.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        lblWeightkg.setBounds(940, 562, 128, 30);
        getContentPane().add(lblWeightkg);

        JTextArea txtrAJockeyIs = new JTextArea();
        txtrAJockeyIs.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        txtrAJockeyIs.setText("A jockey is a professional horse racing rider who competes in horse races. They are typically small in stature, as the weight of the jockey and their equipment must not exceed a certain limit set by the race track or governing body. Jockeys must possess a high level of skill, as they must control a powerful and fast animal while navigating a crowded track and other riders. They also must have knowledge of horse racing strategies and be able to make split-second decisions during a race");
        txtrAJockeyIs.setBackground(new Color(155, 182, 137));
        txtrAJockeyIs.setWrapStyleWord(true);
        txtrAJockeyIs.setLineWrap(true);
        txtrAJockeyIs.setEditable(false);
        txtrAJockeyIs.setBounds(209, 200, 528, 238);
        getContentPane().add(txtrAJockeyIs);

        JLabel imageLabel = new JLabel(".");
        imageLabel.setBounds(880, 157, 516, 359);
        getContentPane().add(imageLabel);
        ImageIcon image = new ImageIcon(this.getClass().getResource("/jocheu.jpeg"));
        imageLabel.setIcon(image);

        PageNavigator pageNavigator = new PageNavigator(this, closeButton, backButton);
        Jockeys jockeys = new Jockeys();
        DatabaseConnection databaseConnection = new DatabaseConnection();

        ShowJockeys showJockeys = new ShowJockeys(this, table, btnNewButton,jockeys, databaseConnection);

        this.setSize(1650,1080);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setVisible(true);
    }

}
