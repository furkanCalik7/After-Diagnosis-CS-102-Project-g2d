package Doctor;

import common.MessagePanel;
import common.SettingsPanel;
import Doctor.Model.Doctor;
import Doctor.Views.*;
import JDBC.MySQLAccess;

import java.util.ArrayList;

public class DoctorRunner {
    public static void main(String[] args) {



        MySQLAccess mySQLAccess = new MySQLAccess();
        Doctor doctor = mySQLAccess.getDoctorByUsername( "JuliaRoberts" );

        DoctorMainFrameViewer doctorMainFrameViewer = new DoctorMainFrameViewer(doctor);
        MyPatientsLayeredPanelView myPatientsLayeredPanelView = new MyPatientsLayeredPanelView(doctor);
        LabTestsMainPanel labTestsMainPanel = new LabTestsMainPanel(doctor);
        SettingsPanel settingsPanel = new SettingsPanel(doctor);
        DoctorBloodDonationPanel donationPanel = new DoctorBloodDonationPanel(doctor);
        DoctorHomepagePanelView homepagePanelView = new DoctorHomepagePanelView(doctor);
        MessagePanel messagePanel = new MessagePanel(doctor);

        doctorMainFrameViewer.setMyPatientsLayeredPanelView(myPatientsLayeredPanelView);
        doctorMainFrameViewer.setDoctorBloodDonationPanel(donationPanel);
        doctorMainFrameViewer.setLabTestsMainPanel(labTestsMainPanel);
        doctorMainFrameViewer.setDoctorHomepagePanelView(homepagePanelView);
        doctorMainFrameViewer.setSettingsPanel(settingsPanel);
        doctorMainFrameViewer.setMessagePanel(messagePanel);


        MyPatientsMainPanel myPatientsMainPanel = new MyPatientsMainPanel(doctor,myPatientsLayeredPanelView);
        myPatientsLayeredPanelView.setMyPatientsMainPanel(myPatientsMainPanel);
        ArrayList<myPatientsDrugPanelView> myPatientsDrugPanelViewArrayList = myPatientsLayeredPanelView.getPatientsDrugPanelViews();
        ArrayList<PatientInfoPanelView> patientInfoPanelViews = myPatientsLayeredPanelView.getPatientInfoPanelViews();

        for(myPatientsDrugPanelView myPatientsDrugPanelView: myPatientsLayeredPanelView.getPatientsDrugPanelViews()){
            doctor.addViewer(myPatientsDrugPanelView);
        }
        for(PatientInfoPanelView patientInfoCard: myPatientsLayeredPanelView.getPatientInfoPanelViews()){
            doctor.addViewer(patientInfoCard);
        }
        doctor.addViewer(labTestsMainPanel);
    }
}
