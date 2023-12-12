package project.views;

import project.DatabaseConnection;
import project.controllers.PageNavigator;
import project.controllers.ShowElements;
import project.models.Trainers;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;

public class TrainersFrame extends JFrame {

    private JButton backButton;
    private JPanel contentPane;
    private JTextArea textArea;
    private JTable table;
    private JTextField updateIDLabelTextField;
    private JTextField updateNameLabelTextField;
    private JTextField updateOtherDetailsLabeltextField;
    private JTextField deleteIDTextField;

    public TrainersFrame() {
        getContentPane().setBackground(new Color(155, 182, 137));
        getContentPane().setLayout(null);

        JLabel trainersLabel = new JLabel("Trainers\r\n");
        trainersLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 30));
        trainersLabel.setBounds(755, 86, 222, 61);
        getContentPane().add(trainersLabel);

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

        JButton btnNewButton = new JButton("SHOW TRAINERS");
        btnNewButton.setBounds(10, 704, 175, 55);
        getContentPane().add(btnNewButton);

        JTextArea txtrWelcomeToThe = new JTextArea();
        txtrWelcomeToThe.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        txtrWelcomeToThe.setLineWrap(true);
        txtrWelcomeToThe.setWrapStyleWord(true);
        txtrWelcomeToThe.setText("Welcome to the page featuring a list of horse trainers specializing in horse racing! These trainers are some of the best in the business and have a wealth of experience preparing horses for the track. Whether you are a seasoned owner or new to horse racing, we have a trainer who can help you and your horse succeed. These trainers have a proven track record of getting horses race ready and have the knowledge and expertise to guide you through the exciting world of horse racing. Browse through our list of trainers below to learn more about their experience and specialties.\r\n\r\nYou can use the button in the bottom right corner to edit one of the trainers info using its id and the button in the bottom left corner to delete a trainer with a specific ID.");
        txtrWelcomeToThe.setBackground(new Color(155, 182, 137));
        txtrWelcomeToThe.setEditable(false);
        txtrWelcomeToThe.setBounds(104, 197, 598, 310);
        getContentPane().add(txtrWelcomeToThe);

        DatabaseConnection databaseConnection = new DatabaseConnection();

        table = new JTable();
        table.setFont(new Font("Cambria", Font.ITALIC, 15));
        table.setToolTipText("");
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {"", null, null},
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
        ) {
            boolean[] columnEditables = new boolean[] {
                    false, true, true
            };
            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        });
        table.setBounds(195, 599, 1037, 160);
        getContentPane().add(table);

        JLabel lblNewLabel = new JLabel("ID");
        lblNewLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        lblNewLabel.setBounds(195, 573, 268, 30);
        getContentPane().add(lblNewLabel);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        lblName.setBounds(540, 573, 268, 30);
        getContentPane().add(lblName);

        JLabel lblOtherDetails = new JLabel("Other details");
        lblOtherDetails.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        lblOtherDetails.setBounds(888, 573, 268, 30);
        getContentPane().add(lblOtherDetails);

        JLabel trainer_pic = new JLabel("");
        trainer_pic.setBounds(900, 180, 526, 376);
        getContentPane().add(trainer_pic);
        ImageIcon image = new ImageIcon(this.getClass().getResource("/trainer.jpeg"));
        trainer_pic.setIcon(image);

        this.setSize(1650,1080);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setVisible(true);

        JButton btnUpdateTable = new JButton("UPDATE TABLE");
        btnUpdateTable.setBounds(1255, 603, 175, 55);
        getContentPane().add(btnUpdateTable);

        JLabel updateIDLabel = new JLabel("ID:");
        updateIDLabel.setBounds(1242, 665, 122, 23);
        getContentPane().add(updateIDLabel);

        JLabel updateNameLabel = new JLabel("New name:");
        updateNameLabel.setBounds(1242, 698, 122, 23);
        getContentPane().add(updateNameLabel);

        JLabel updateOtherDetailsLabel= new JLabel("New other details:");
        updateOtherDetailsLabel.setBounds(1242, 727, 122, 32);
        getContentPane().add(updateOtherDetailsLabel);

        updateIDLabelTextField = new JTextField();
        updateIDLabelTextField.setBounds(1354, 665, 96, 19);
        getContentPane().add(updateIDLabelTextField);
        updateIDLabelTextField.setColumns(10);

        updateNameLabelTextField = new JTextField();
        updateNameLabelTextField.setColumns(10);
        updateNameLabelTextField.setBounds(1354, 700, 96, 19);
        getContentPane().add(updateNameLabelTextField);

        updateOtherDetailsLabeltextField = new JTextField();
        updateOtherDetailsLabeltextField.setColumns(10);
        updateOtherDetailsLabeltextField.setBounds(1354, 734, 96, 19);
        getContentPane().add(updateOtherDetailsLabeltextField);

        JButton btnDelete = new JButton("DELETE ID");
        btnDelete.setBounds(10, 600, 175, 55);
        getContentPane().add(btnDelete);

        deleteIDTextField = new JTextField();
        deleteIDTextField.setBounds(10, 665, 96, 19);
        getContentPane().add(deleteIDTextField);
        deleteIDTextField.setColumns(10);

        Trainers trainers = new Trainers();
        ShowElements showElements = new ShowElements(this, btnNewButton, databaseConnection, trainers, table, btnUpdateTable, btnDelete);

    }

    public int getUpdateIDLabelTextField() {
        return Integer.parseInt(updateIDLabelTextField.getText());
    }

    public void setUpdateIDLabelTextField(int updateIDLabelTextField) {
        this.updateIDLabelTextField.setText(String.valueOf(updateIDLabelTextField));
    }

    public String getUpdateNameLabelTextField() {
        return updateNameLabelTextField.getText();
    }

    public void setUpdateNameLabelTextField(String updateNameLabelTextField) {
        this.updateNameLabelTextField.setText(updateNameLabelTextField);
    }

    public String getUpdateOtherDetailsLabeltextField() {
        return updateOtherDetailsLabeltextField.getText();
    }

    public void setUpdateOtherDetailsLabeltextField(String updateOtherDetailsLabeltextField) {
        this.updateOtherDetailsLabeltextField.setText(updateOtherDetailsLabeltextField);
    }

    public int getDeleteIDTextField() {
        return Integer.parseInt(deleteIDTextField.getText());
    }

    public void setDeleteIDTextField(int deleteIDTextField) {
        this.deleteIDTextField.setText(String.valueOf(deleteIDTextField));
    }
}