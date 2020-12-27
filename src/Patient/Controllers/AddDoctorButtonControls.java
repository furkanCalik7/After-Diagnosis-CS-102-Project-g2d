package Patient.Controllers;

import Patient.Model.Patient;
import Patient.Views.MyDoctorsPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDoctorButtonControls extends JButton {

    private Patient patient;
    private MyDoctorsPanel panel;

    public AddDoctorButtonControls(Patient patient, MyDoctorsPanel panel) {
        this.patient = patient;
        this.panel = panel;
        setText("DONE");
        addActionListener(new ButtonListener());
    }

    class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
           String code = panel.codeField.getText();
           System.out.println(panel.codeField.getText());
           patient.addDoctor(code);
           panel.codeField.setText("");
        }
    }
}
