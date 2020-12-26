package Doctor.Controller;

import Doctor.Model.Doctor;
import Doctor.Views.PatientInfoPanelView;
import LabTechs.Model.TestRequest;
import Patient.Model.PatientInfoCard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SendTestRequestController implements ActionListener {
    private Doctor doctor;
    private PatientInfoPanelView patientInfoPanelView;
    private String patient;

    public SendTestRequestController(PatientInfoPanelView patientInfoPanelView ,Doctor doctor, String patientInfoCard) {
        this.patientInfoPanelView = patientInfoPanelView;
        this.doctor = doctor;
        this.patient =  patientInfoCard;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String testName = JOptionPane.showInputDialog("Enter a test name:");

        int i = JOptionPane.showConfirmDialog(patientInfoPanelView, "Are you sure to send this request?", "Sending Confirmation", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            TestRequest testRequest = new TestRequest(testName,patient,doctor.getUsername());
            doctor.sendTestRequest(testRequest);
            JOptionPane.showMessageDialog(patientInfoPanelView,"Test request is sent.");
        } else {
            JOptionPane.showMessageDialog(patientInfoPanelView,"Test request is not sent.");
        }
    }
}
