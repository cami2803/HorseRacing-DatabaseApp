package project.views;


import project.DatabaseConnection;
import project.controllers.ManageAccount;
import project.controllers.PageNavigator;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class ManageAccountFrame extends JFrame {

    private JPanel contentPane;
    private JTextField deleteAccountTextField;
    private JTextField usernameTextField;
    private JTextField newUsernameTextField;
    private JTextField newPasswordTextField;
    private JButton backButton;

    public ManageAccountFrame() {
        getContentPane().setBackground(new Color(155, 182, 137));
        getContentPane().setLayout(null);

        JLabel raceScheduleLabel = new JLabel("Manage Your Account");
        raceScheduleLabel.setBounds(693, 91, 317, 61);
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


        JTextArea txtrWelcomeToThe = new JTextArea();
        txtrWelcomeToThe.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 20));
        txtrWelcomeToThe.setWrapStyleWord(true);
        txtrWelcomeToThe.setLineWrap(true);
        txtrWelcomeToThe.setEditable(false);
        txtrWelcomeToThe.setText("Welcome to the \"Manage Your Account\" page. Here you can update your personal information, change your password, or delete your account. Keeping your account information up-to-date will ensure you with the best possible service. If you have any questions or need assistance, please contact me.\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\nE-mail: app_creator@mail.com\r\nPhone: 0712345678");
        txtrWelcomeToThe.setBackground(new Color(155, 182, 137));
        txtrWelcomeToThe.setBounds(79, 250, 404, 462);
        getContentPane().add(txtrWelcomeToThe);

        JButton btnUpdateAccount = new JButton("UPDATE ACCOUNT");
        btnUpdateAccount.setBounds(1146, 490, 191, 70);
        getContentPane().add(btnUpdateAccount);

        JButton btnDeleteAccount = new JButton("DELETE ACCOUNT");
        btnDeleteAccount.setBounds(784, 490, 191, 70);
        getContentPane().add(btnDeleteAccount);

        deleteAccountTextField = new JTextField();
        deleteAccountTextField.setBounds(843, 422, 151, 25);
        getContentPane().add(deleteAccountTextField);
        deleteAccountTextField.setColumns(10);

        JLabel lblNewLabel = new JLabel("Username:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(754, 420, 92, 25);
        getContentPane().add(lblNewLabel);

        usernameTextField = new JTextField();
        usernameTextField.setColumns(10);
        usernameTextField.setBounds(1203, 376, 151, 25);
        getContentPane().add(usernameTextField);

        JLabel lblNewLabel_1 = new JLabel("Username:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(1091, 374, 92, 25);
        getContentPane().add(lblNewLabel_1);

        newUsernameTextField = new JTextField();
        newUsernameTextField.setColumns(10);
        newUsernameTextField.setBounds(1203, 420, 151, 25);
        getContentPane().add(newUsernameTextField);

        JLabel lblNewPassword = new JLabel("New username:");
        lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewPassword.setBounds(1091, 418, 109, 25);
        getContentPane().add(lblNewPassword);

        newPasswordTextField = new JPasswordField();
        newPasswordTextField.setColumns(10);
        newPasswordTextField.setBounds(1203, 455, 151, 25);
        getContentPane().add(newPasswordTextField);

        JLabel lblNewPassword_1 = new JLabel("New password:");
        lblNewPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewPassword_1.setBounds(1091, 453, 109, 25);
        getContentPane().add(lblNewPassword_1);


        setBackground(new Color(155, 182, 137));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1410, 759);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(155, 182, 137));
        contentPane.setBorder(null);

        DatabaseConnection databaseConnection = new DatabaseConnection();
        PageNavigator pageNavigator = new PageNavigator(this, closeButton, backButton);
        ManageAccount manageAccount = new ManageAccount(btnDeleteAccount, btnUpdateAccount, databaseConnection, this);

        this.setSize(1650,1080);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setVisible(true);
    }

    public String getNewUsernameTextField() {
        return newUsernameTextField.getText();
    }

    public void setNewUsernameTextField(String newUsernameTextField) {
        this.newUsernameTextField.setText(newUsernameTextField);
    }

    public String getNewPasswordTextField() {
        return newPasswordTextField.getText();
    }

    public void setNewPasswordTextField(String newPasswordTextField) {
        this.newPasswordTextField.setText(newPasswordTextField);
    }

    public String getDeleteAccountTextField() {
        return deleteAccountTextField.getText();
    }

    public void setDeleteAccountTextField(String deleteAccountTextField) {
        this.deleteAccountTextField.setText(deleteAccountTextField);
    }
    public void showMessage(String s) {
        JOptionPane.showMessageDialog(this, s);
    }

    public String getUsernameTextField() {
        return usernameTextField.getText();
    }

    public void setUsernameTextField(String usernameTextField) {
        this.usernameTextField.setText(usernameTextField);
    }

    public void refreshRegister() {
        deleteAccountTextField.setText(null);
        usernameTextField.setText(null);
        newPasswordTextField.setText(null);
        newUsernameTextField.setText(null);
    }

}