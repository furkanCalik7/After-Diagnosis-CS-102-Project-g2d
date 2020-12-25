package Doctor.Controller;

import Doctor.Model.Doctor;
import Doctor.Model.Drug;
import Doctor.Model.PatientSlot;
import Doctor.Views.myPatientsDrugPanelView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

public class AddDrugController implements ActionListener {
    private myPatientsDrugPanelView drugMenu;
    private String drugName;
    private String username;
    private boolean isMorning;
    private boolean isAfternoon;
    private boolean isEvening;
    private boolean isHungry;
    private Date start_date;
    private Date end_date;
    private int dose;
    private Doctor doctor;
    private PatientSlot patientSlot;

    public AddDrugController(myPatientsDrugPanelView drugMenu, Doctor doctor, PatientSlot patientSlot){
        this.drugMenu = drugMenu;
        this.doctor = doctor;
        this.patientSlot = patientSlot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Drug drug;
        drugName = String.valueOf(drugMenu.getDrugComboBox().getSelectedItem());
        username = drugMenu.getPatient_username();
        isMorning = drugMenu.getIsMorning().isSelected();
        isAfternoon = drugMenu.getIsAfternoon().isSelected();
        isEvening = drugMenu.getIsEvening().isSelected();
        start_date = Date.valueOf(drugMenu.getDataPickerStart().getSelectedDate());
        end_date = Date.valueOf(drugMenu.getDataPickerEnd().getSelectedDate());

        if(drugMenu.getDose().getText().isEmpty()){
            dose = 0;
        }else {
            dose = Integer.parseInt(drugMenu.getDose().getText());
        }

        if(drugMenu.getHungryButtonGroup().getSelection().getActionCommand() == "Hungry"){
            isHungry = true;
        }else {
            isHungry = false;
        }
        int i = JOptionPane.showConfirmDialog(drugMenu,"Are you sure to add this drug?","Confirm Drug:",JOptionPane.YES_NO_OPTION);
        if(i == JOptionPane.YES_OPTION){
       //     doctor.prescribeDrug(username,drugName,isMorning,isAfternoon,isEvening,isHungry,start_date,end_date,dose);
            drug = new Drug(username,drugName,isMorning,isAfternoon,isEvening,isHungry,start_date,end_date,dose);
            doctor.addDrugToPatient(patientSlot,drug);
        }
    }
}
