package LabTechs;



import JDBC.MySQLAccess;
import LabTechs.Model.LabTechnician;
import LabTechs.Views.LabTechnicianHomepagePanelView;
import LabTechs.Views.LabTechnicianMainFrameViewer;
import LabTechs.Views.LabTechnicianTestsMainPanel;
import common.SettingsPanel;

public class LabTechnicianRunner {

    public LabTechnicianRunner(String username) {

        MySQLAccess mySQLAccess = new MySQLAccess();
        LabTechnician labTechnician = (LabTechnician) mySQLAccess.getUser(username);

        LabTechnicianMainFrameViewer labTechnicianMainFrameViewer = new LabTechnicianMainFrameViewer(labTechnician);
        LabTechnicianTestsMainPanel labTestsMainPanel = new LabTechnicianTestsMainPanel(labTechnician);
        LabTechnicianHomepagePanelView labTechnicianHomepagePanelView = new LabTechnicianHomepagePanelView(labTechnician, labTechnicianMainFrameViewer);
        SettingsPanel settingsPanel = new SettingsPanel(labTechnician);


        labTechnicianMainFrameViewer.setLabTestsMainPanel(labTestsMainPanel);
        labTechnicianMainFrameViewer.setLabTechHomepagePanelView(labTechnicianHomepagePanelView);
        labTechnicianMainFrameViewer.setSettingsPanel(settingsPanel);
    }
}
