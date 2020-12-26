package common;

import Admin.model.User;
import JDBC.Message;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendButtonControl extends JButton {

    private User user;
    private MessagePanel panel;

    public SendButtonControl(User user, MessagePanel panel) {
        setText("Send the message");
        this.user = user;
        this.panel = panel;
        addActionListener(new SendButtonListener());
    }

    class SendButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String content = panel.getMessageTextArea().getText();
            String subject = panel.getTxtSubject().getText();
            String receiver = panel.getTxtEnterTheSubjects().getText();

            user.sendMessages(receiver, subject, content);
            JOptionPane.showMessageDialog(panel, "Your message sent successfully.");
        }
    }
}
