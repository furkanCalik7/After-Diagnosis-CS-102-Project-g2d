package Doctor.Controller;

import Doctor.Model.Doctor;
import Doctor.Views.DoctorBloodDonationPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BloodMessageSendController implements ActionListener {
    private DoctorBloodDonationPanel doctorBloodDonationPanel;
    private Doctor doctor;

    public BloodMessageSendController(DoctorBloodDonationPanel doctorBloodDonationPanel, Doctor doctor) {
        this.doctorBloodDonationPanel = doctorBloodDonationPanel;
        this.doctor = doctor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int i = JOptionPane.showConfirmDialog(doctorBloodDonationPanel,"Are you sure to send messages?","Confirm Message Request:",JOptionPane.YES_NO_OPTION);
        if(i == JOptionPane.YES_OPTION){
            if(doctorBloodDonationPanel.getAbNegCheckBox().isSelected()){
                doctor.sendBloodRequest(doctorBloodDonationPanel.getAbNegCheckBox().getText());
            }
            if(doctorBloodDonationPanel.getAbPosCheckBox().isSelected()){
                doctor.sendBloodRequest(doctorBloodDonationPanel.getAbPosCheckBox().getText());
            }
            if(doctorBloodDonationPanel.getaNegCheckBox().isSelected()){
                doctor.sendBloodRequest(doctorBloodDonationPanel.getaNegCheckBox().getText());
            }
            if(doctorBloodDonationPanel.getaPosCheckBox().isSelected()){
                doctor.sendBloodRequest(doctorBloodDonationPanel.getaPosCheckBox().getText());
            }
            if(doctorBloodDonationPanel.getbNegCheckBox().isSelected()){
                doctor.sendBloodRequest(doctorBloodDonationPanel.getbNegCheckBox().getText());
            }
            if(doctorBloodDonationPanel.getbPosCheckBox().isSelected()){
                doctor.sendBloodRequest(doctorBloodDonationPanel.getbPosCheckBox().getText());
            }
            if(doctorBloodDonationPanel.getZeroNegCheckBox().isSelected()){
                doctor.sendBloodRequest(doctorBloodDonationPanel.getZeroNegCheckBox().getText());
            }
            if(doctorBloodDonationPanel.getZeroPosCheckBox().isSelected()){
                doctor.sendBloodRequest(doctorBloodDonationPanel.getZeroPosCheckBox().getText());
            }
        }
        if(i == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(doctorBloodDonationPanel,"Messages are sent.");
        }else if(i == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(doctorBloodDonationPanel,"Messages are not send.");
        }

    }
}
