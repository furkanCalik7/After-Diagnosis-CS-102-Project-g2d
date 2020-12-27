package Login;

import JDBC.RegisterModel;
import Login.LoginView.SignupPanelView;
import Patient.Model.Patient;
import Patient.Views.PatientMainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterButtonController extends JButton {

    private SignupPanelView panel;

    public RegisterButtonController(SignupPanelView panel) {
        setText("Create");
        this.panel = panel;
        addActionListener(new RegisterButtonListener());
    }

    class RegisterButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            RegisterModel registerModel = new RegisterModel();
            String name = panel.getNameTxtField().getText();
            String surname = panel.getSurnameTxtField().getText();
            String email = panel.getMailTxtField().getText();
            String password = panel.getPasswordField().getText();
            String confirm = panel.getConfirmPasswordField().getText();
            String username = name + surname;

            if(password.equals(confirm)) {
                if(registerModel.register(username, password, email, name, surname, "M")) { //TODO username, gender
                    PatientMainFrame patient = new PatientMainFrame(username);
                }
            }
            else
                JOptionPane.showMessageDialog(panel, "Passwords don't match!");

        }
    }

}
