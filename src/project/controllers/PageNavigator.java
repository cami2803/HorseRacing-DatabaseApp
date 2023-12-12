package project.controllers;

import project.views.WelcomeFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PageNavigator {
    private JFrame frame;
    private JButton closeButton;
    private JButton backButton;

    public PageNavigator(JFrame frame, JButton closeButton, JButton backButton){
        this.frame = frame;
        this.closeButton = closeButton;
        this.backButton = backButton;
        this.addCloseApplicationListener(new closeListener());
        this.addGoBackListener(new backListener());
    }

    public  void addGoBackListener(ActionListener action){
        backButton.addActionListener(action);
    }
    public void addCloseApplicationListener(ActionListener action){
        closeButton.addActionListener(action);
    }

    class backListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
            frame.dispose();
            WelcomeFrame welcomeFrame = new WelcomeFrame();
        }
    }
    class closeListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    confirmationMessage();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "ERROR.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
    }

    public void confirmationMessage() {
        int response = JOptionPane.showConfirmDialog(frame, "Are you sure you want to close this application?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
}
