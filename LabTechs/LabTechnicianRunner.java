package LabTechs;

import AdminViews.SettingsPanel;
import Doctor.Model.Doctor;
import Doctor.Views.*;
import JDBC.MySQLAccess;
import LabTechs.Model.LabTechnician;
import LabTechs.Views.LabTechnicianHomepagePanelView;
import LabTechs.Views.LabTechnicianMainFrameViewer;
import LabTechs.Views.LabTechnicianTestsMainPanel;


import java.util.ArrayList;

public class LabTechnicianRunner {

    public static void main(String[] args) {

        MySQLAccess mySQLAccess = new MySQLAccess();
        LabTechnician labTechnician = ( LabTechnician ) mySQLAccess.getUser( "PeterJackson" );

        LabTechnicianMainFrameViewer labTechnicianMainFrameViewer = new LabTechnicianMainFrameViewer(labTechnician);
        LabTechnicianTestsMainPanel labTestsMainPanel = new LabTechnicianTestsMainPanel( labTechnician );
        LabTechnicianHomepagePanelView labTechnicianHomepagePanelView = new LabTechnicianHomepagePanelView( labTechnician , labTechnicianMainFrameViewer);
        SettingsPanel settingsPanel = new SettingsPanel(labTechnician);


        labTechnicianMainFrameViewer.setLabTestsMainPanel(labTestsMainPanel);
        labTechnicianMainFrameViewer.setLabTechHomepagePanelView(labTechnicianHomepagePanelView);
        labTechnicianMainFrameViewer.setSettingsPanel(settingsPanel);


        //MyPatientsMainPanel myPatientsMainPanel = new MyPatientsMainPanel(labTechnician,myPatientsLayeredPanelView);
        //myPatientsLayeredPanelView.setMyPatientsMainPanel(myPatientsMainPanel);
        //ArrayList<myPatientsDrugPanelView> myPatientsDrugPanelViewArrayList = myPatientsLayeredPanelView.getPatientsDrugPanelViews();
        //ArrayList<PatientInfoPanelView> patientInfoPanelViews = myPatientsLayeredPanelView.getPatientInfoPanelViews();

    }
}
