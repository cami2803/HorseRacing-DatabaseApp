package project.views;

import project.controllers.PageNavigator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainFrame extends JFrame {

    private JPanel contentPane;
    private JTextField createPasswordTextField;
    private JTextField createUsernameTextField;
    private JTextField signInPassTextField;
    private JTextField signInUserTextField;
    private JButton createAccountButton;
    private JButton closeButton;

    public String getCreatePasswordTextField() {
        return createPasswordTextField.getText();
    }

    public void setCreatePasswordTextField(String createPasswordTextField) {
        this.createPasswordTextField.setText(createPasswordTextField);
    }

    public String getCreateUsernameTextField() {
        return createUsernameTextField.getText();
    }

    public void setCreateUsernameTextField(String createUsernameTextField) {
        this.createUsernameTextField.setText(createUsernameTextField);
    }

    public String getSignInPassTextField() {
        return signInPassTextField.getText();
    }

    public void setSignInPassTextField(String signInPassTextField) {
        this.signInPassTextField.setText(signInPassTextField);
    }

    public String getSignInUserTextField() {
        return signInUserTextField.getText();
    }

    public void setSignInUserTextField(String signInUserTextField) {
        this.signInUserTextField.setText(signInUserTextField);
    }

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1410, 759);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(155, 182, 137));
        contentPane.setBorder(null);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel titleTextField = new JLabel("Welcome to Horse Racing Competition Cluj-Napoca!");
        titleTextField.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 30));
        titleTextField.setBackground(new Color(155, 182, 137));
        titleTextField.setBounds(427, 56, 785, 54);
        contentPane.add(titleTextField);

        JTextArea welcomeTextArea = new JTextArea();
        welcomeTextArea.setLineWrap(true);
        welcomeTextArea.setEditable(false);
        welcomeTextArea.setWrapStyleWord(true);
        welcomeTextArea.setText("   Welcome to my horse racing app, the ultimate destination for all things equestrian! With my comprehensive database of horses, jockeys, trainers, and races, you'll have all the information you need to stay up-to-date on the latest happenings in the horse racing world.\r\n     This app offers a range of features to enhance your experience, including the ability to view race schedules, find results, and access horse profiles. You can do all this only if you create an account and log in! \r\n     Thank you for choosing this application. I hope you will enjoy it!");
        welcomeTextArea.setFont(new Font("Cambria", Font.PLAIN, 20));
        welcomeTextArea.setBackground(new Color(155, 182, 137));
        welcomeTextArea.setBounds(550, 221, 393, 466);
        contentPane.add(welcomeTextArea);

        createAccountButton = new JButton("Create account");
        createAccountButton.setFont(new Font("Cambria", Font.BOLD, 20));
        createAccountButton.setBounds(1137, 538, 187, 60);
        contentPane.add(createAccountButton);

        JLabel createUsernameLabel = new JLabel("Username:");
        createUsernameLabel.setFont(new Font("Candara Light", Font.BOLD, 20));
        createUsernameLabel.setBounds(1137, 429, 115, 46);
        contentPane.add(createUsernameLabel);

        JLabel createPasswordLabel = new JLabel("Password:");
        createPasswordLabel.setFont(new Font("Candara Light", Font.BOLD, 20));
        createPasswordLabel.setBounds(1137, 485, 96, 46);
        contentPane.add(createPasswordLabel);

        createPasswordTextField = new JPasswordField();
        createPasswordTextField.setBounds(1258, 490, 112, 33);
        contentPane.add(createPasswordTextField);
        createPasswordTextField.setColumns(10);

        createUsernameTextField = new JTextField();
        createUsernameTextField.setColumns(10);
        createUsernameTextField.setBounds(1258, 435, 112, 33);
        contentPane.add(createUsernameTextField);

        JLabel signInUserLabel = new JLabel("Username:");
        signInUserLabel.setFont(new Font("Candara Light", Font.BOLD, 20));
        signInUserLabel.setBounds(1135, 216, 115, 46);
        contentPane.add(signInUserLabel);

        JLabel signInPassLabel = new JLabel("Password:");
        signInPassLabel.setFont(new Font("Candara Light", Font.BOLD, 20));
        signInPassLabel.setBounds(1135, 272, 96, 46);
        contentPane.add(signInPassLabel);

        signInPassTextField = new JPasswordField();
        signInPassTextField.setColumns(10);
        signInPassTextField.setBounds(1256, 277, 112, 33);
        contentPane.add(signInPassTextField);

        signInUserTextField = new JTextField();
        signInUserTextField.setColumns(10);
        signInUserTextField.setBounds(1256, 222, 112, 33);
        contentPane.add(signInUserTextField);

        JButton signInButton = new JButton("Sign in\r\n");
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tabele?autoReconnect=true&useSSL=false", "root", "uncacat");
                    Statement stmt = con.createStatement();
                    String sql = "Select * from login where username = '" + signInUserTextField.getText() + "' and password ='" + signInPassTextField.getText() + "'";
                    ResultSet rs = stmt.executeQuery(sql);
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "Login Successfully!");
                        contentPane.setVisible(false);
                        refreshCorrectLogin();
                        WelcomeFrame welcomeFrame = new WelcomeFrame();
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect credentials.", "ERROR", JOptionPane.ERROR_MESSAGE);
                        refreshIncorrectLogin();
                    }
                    con.close();
                } catch (Exception e) {
                    System.out.print(e);
                }
            }
        });

        signInButton.setFont(new Font("Cambria", Font.BOLD, 20));
        signInButton.setBounds(1135, 328, 187, 60);
        contentPane.add(signInButton);

        JLabel labelImage = new JLabel("");
        labelImage.setBounds(-128, -25, 696, 962);
        contentPane.add(labelImage);
        ImageIcon img = new ImageIcon(this.getClass().getResource("/cal.jpg"));
        labelImage.setIcon(img);

        closeButton = new JButton("Close Application\r\n");
        closeButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        closeButton.setBounds(10, 10, 208, 36);
        contentPane.add(closeButton);

        PageNavigator pageNavigator = new PageNavigator(this, closeButton, new JButton());

        this.setSize(1650, 1080);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setVisible(true);
    }

    public void addCreateAccountListener(ActionListener action) {
        createAccountButton.addActionListener(action);
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
        refreshRegister();
    }

    public void refreshRegister() {
        createPasswordTextField.setText(null);
        createUsernameTextField.setText(null);
    }

    public void refreshCorrectLogin() {
        signInPassTextField.setText(null);
        signInUserTextField.setText(null);
        this.dispose();
    }

    public void refreshIncorrectLogin() {
        signInPassTextField.setText(null);
        signInUserTextField.setText(null);
    }

    public void showMessage(String s) {
        JOptionPane.showMessageDialog(this, s);
    }

}