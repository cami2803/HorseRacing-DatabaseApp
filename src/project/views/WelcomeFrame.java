package project.views;

import project.controllers.PageNavigator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeFrame extends JFrame {

    private JPanel contentPane;
    private JTextArea welcomeTextArea;
    private JComboBox comboBox;

    public WelcomeFrame() {
        setBackground(new Color(155, 182, 137));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1410, 759);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(155, 182, 137));
        contentPane.setBorder(null);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel welcomeLabel = new JLabel("Horse Racing Cluj Napoca");
        welcomeLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 30));
        welcomeLabel.setBounds(643, 43, 473, 88);
        contentPane.add(welcomeLabel);

        welcomeTextArea = new JTextArea();
        welcomeTextArea.setFont(new Font("Cambria", Font.BOLD, 20));
        welcomeTextArea.setLineWrap(true);
        welcomeTextArea.setWrapStyleWord(true);
        welcomeTextArea.setText("Welcome to the home page of my horse racing app! Now that you have logged in to your account, you have access to all of the features of this app. Here are a few things you can do:\r\n\r\n  - View the schedule of upcoming horse races or check out the results of past races plus other information about current or future races.\r\n  - View the profiles of your favorite horses, trainers and jockeys.\r\n  - See the types of races that exist, their ratings and classes.\r\n  - See the prices to enter at each race.\r\n\r\nYou can choose whatever you want to do by selecting one of the options from the Combo Box on the right.\r\n\r\nI hope you enjoy using this app!");
        welcomeTextArea.setBackground(new Color(155, 182, 137));
        welcomeTextArea.setBounds(79, 199, 557, 482);
        contentPane.add(welcomeTextArea);

        JLabel imageLabel = new JLabel("");
        imageLabel.setBounds(993, 199, 519, 395);
        contentPane.add(imageLabel);
        ImageIcon image = new ImageIcon(this.getClass().getResource("/cal_alb.jpg"));
        imageLabel.setIcon(image);

        String[] options = {"Horse Races Schedule", "Race Courses", "Horses", "Trainers", "Jockeys", "Race Details", "Prices", "Home Page", "Manage Account"};
        comboBox = new JComboBox(options);
        comboBox.setSelectedIndex(0);
        comboBox.setBounds(740, 349, 203, 57);
        contentPane.add(comboBox);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JComboBox cb = (JComboBox) e.getSource();
                    String msg = (String) cb.getSelectedItem();
                    switch (msg) {
                        case "Horse Races Schedule" -> {
                            contentPane.setVisible(false);
                            DisposeCurrentFrame();
                            RaceScheduleFrame raceScheduleFrame = new RaceScheduleFrame();
                        }
                        case "Horses" -> {
                            contentPane.setVisible(false);
                            DisposeCurrentFrame();
                            HorsesFrame horsesFrame = new HorsesFrame();
                        }
                        case "Trainers" -> {
                            contentPane.setVisible(false);
                            DisposeCurrentFrame();
                            TrainersFrame trainersFrame = new TrainersFrame();
                        }
                        case "Jockeys" -> {
                            contentPane.setVisible(false);
                            DisposeCurrentFrame();
                            JockeysFrame jockeysFrame = new JockeysFrame();
                        }
                        case "Race Details" -> {
                            contentPane.setVisible(false);
                            DisposeCurrentFrame();
                            RaceDetailsFrame raceDetailsFrame = new RaceDetailsFrame();
                        }
                        case "Prices" -> {
                            contentPane.setVisible(false);
                            DisposeCurrentFrame();
                            PriceFrame priceFrame = new PriceFrame();
                        }
                        case "Home Page" -> {
                            contentPane.setVisible(false);
                            DisposeCurrentFrame();
                            MainFrame mainFrame = new MainFrame();
                        }
                        case "Race Courses" -> {
                            contentPane.setVisible(false);
                            DisposeCurrentFrame();
                            RaceCoursesFrame raceCoursesFrame = new RaceCoursesFrame();
                        }
                        case "Manage Account" -> {
                            contentPane.setVisible(false);
                            DisposeCurrentFrame();
                            ManageAccountFrame manageAccountFrame = new ManageAccountFrame();
                        }
                        default -> JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "ERROR.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        JButton closeButton = new JButton("Close Application");
        closeButton.setForeground(Color.BLACK);
        closeButton.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
        closeButton.setBounds(31, 20, 281, 40);
        getContentPane().add(closeButton);

        PageNavigator pageNavigator = new PageNavigator(this, closeButton, new JButton());

        this.setSize(1650,1080);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setVisible(true);
    }

    public void addComboBoxListener(ActionListener action) {
        comboBox.addActionListener(action);
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    }

    public void DisposeCurrentFrame() {
        this.dispose();
    }
}
