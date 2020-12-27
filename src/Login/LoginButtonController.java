package Login;

import AdminViews.AdminMainFrame;
import Doctor.DoctorRunner;
import LabTechs.LabTechnicianRunner;
import LabTechs.Model.LabTechnician;
import Login.LoginView.LoginPanelView;
import Patient.Model.Patient;
import Patient.Views.PatientMainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginButtonController extends JButton {

    private LoginPanelView panel;

    public LoginButtonController(LoginPanelView panel) {
        this.panel = panel;
        setText("LOGIN");
        addActionListener(new LoginButtonListener());
    }

    class LoginButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            LoginModel login = new LoginModel();
            String userType = panel.getUserTypeComboBox().getSelectedItem().toString();
            String username = panel.getUsernameTextField().getText();
            String password = panel.getPasswordField().getText();

            if(userType.equals("Administrator")) {
                userType = "Admin";
            }
            else if(userType.equals("Lab Technician")) {
                userType = "LabTechnician";
            }

            if(login.isLogin(username, password, userType)) {
                if(userType.equals("Doctor")) {
                    DoctorRunner doctor = new DoctorRunner(username);
                }
                else if(userType.equals("Admin")) {
                    AdminMainFrame admin = new AdminMainFrame(username);
                }
                else if(userType.equals("LabTechnician")) {
                    LabTechnicianRunner labTechnician = new LabTechnicianRunner(username);
                }
                else {
                    PatientMainFrame patient = new PatientMainFrame(username);
                }
                panel.setVisible(false);
            }

            else {
                JOptionPane.showMessageDialog(panel, "Wrong username or password!");
            }

        }
    }
}
