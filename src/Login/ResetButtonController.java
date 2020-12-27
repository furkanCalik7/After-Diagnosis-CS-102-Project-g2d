package Login;

import JDBC.EmailUtil;
import JDBC.MySQLAccess;
import Login.LoginView.ForgotPasswordPanel;
import Patient.Model.Code;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButtonController extends JButton {

    private ForgotPasswordPanel panel;

    public ResetButtonController(ForgotPasswordPanel panel) {
        setText("Reset");
        this.panel = panel;
        addActionListener(new ResetButtonListener());
    }

    class ResetButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            MySQLAccess access = new MySQLAccess();
            String mail = panel.getMailTextField().getText();
            EmailUtil emailSender = new EmailUtil();
            String password = Code.newCode().getCode_id();
            access.resetPassword(mail, password);
            emailSender.sendEmail(mail, "Reset password", "Your password is reset. " +
                    "Your new password is: " + password);
            JOptionPane.showMessageDialog(panel, "Your password is reset and sent to your email.");

        }
    }


}
