package common;

import Admin.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsButtonController extends JButton {

    User user;
    SettingsPanel panel;
    public SettingsButtonController(User user, SettingsPanel panel) {
        setText("Save your changes");
        this.user = user;
        this.panel = panel;
        addActionListener(new SettingsListener());
    }

    class SettingsListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            int i = JOptionPane.showConfirmDialog(panel, "Are you sure to update information?", "Update Confirmation", JOptionPane.YES_NO_OPTION);
            if (i == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(panel,"Updated..");
                String username = panel.nameTextField.getText();
                String password = panel.passwordTextField.getText();
                String email = panel.mailTextField.getText();

                user.setUsername(username);
                user.setPassword(password);
                user.setEmail(email);
            } else {
                JOptionPane.showMessageDialog(panel,"Not updated.");
            }
        }
    }
}

