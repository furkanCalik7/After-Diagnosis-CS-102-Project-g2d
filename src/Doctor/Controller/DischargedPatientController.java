package Doctor.Controller;

import Doctor.Model.Doctor;
import Doctor.Views.MyPatientsMainPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DischargedPatientController implements ActionListener {

    private int selectedRow;
    private Doctor doctor;

    private MyPatientsMainPanel myPatientsMainPanel;

    public DischargedPatientController(int selectedRow, Doctor doctor, MyPatientsMainPanel patientsMainPanel){
        this.selectedRow = selectedRow;
        this.doctor = doctor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(selectedRow);
        //doctor.getPatientSlots().get(selectedRow).setStatus(0);
      //  myPatientsMainPanel.updateTable(selectedRow);
    }
}
