package Doctor.Controller;

import Doctor.Model.Doctor;
import Doctor.Views.MyPatientCreationPanelView;
import Patient.Model.Code;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreatePatientCodeController {
    private Doctor doctor;
    private MyPatientCreationPanelView myPatientCreationPanelView;
    private String complaint;

    public CreatePatientCodeController(MyPatientCreationPanelView myPatientCreationPanelView, Doctor doctor, String complaint) {
        this.myPatientCreationPanelView = myPatientCreationPanelView;
        this.doctor = doctor;
        this.complaint = complaint;
    }
    public void controller() {
        int i = JOptionPane.showConfirmDialog(myPatientCreationPanelView, "Are you sure to create code?", "Code Creation Confirmation", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            System.out.println(complaint);
            doctor.createCodeForPatient(complaint);
            JOptionPane.showMessageDialog(myPatientCreationPanelView,"Code is created.");
        }
    }
}

