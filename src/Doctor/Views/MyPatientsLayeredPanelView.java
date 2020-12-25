package Doctor.Views;

import Doctor.Model.Doctor;

import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.util.ArrayList;

public class MyPatientsLayeredPanelView extends JPanel {
    public static final int DRUG_MENU = 0;
    public static final int INFORMATION_MENU = 1;

    private MyPatientsMainPanel myPatientsMainPanel;
    private JLayeredPane layeredPane;
    private myPatientCreationPanelView patientCreationPanelView;
    private ArrayList<PatientInfoPanelView> patientInfoPanelViews;
    private ArrayList<myPatientsDrugPanelView> patientsDrugPanelViews;
    private Doctor doctor;

    public MyPatientsLayeredPanelView(Doctor doctor) {

        setLayout(new BorderLayout(0, 0));
        patientCreationPanelView = new myPatientCreationPanelView(this);
        patientsDrugPanelViews = new ArrayList<>();
        patientInfoPanelViews = new ArrayList<>();
        this.doctor = doctor;

        createDrugAndInfoPanels();

        layeredPane = new JLayeredPane();
        add(layeredPane);
        layeredPane.setLayout(new CardLayout(0, 0));


    }

    public void switchPanels(int index, int kind) {
        layeredPane.removeAll();
        if (kind == DRUG_MENU) {
            layeredPane.add(patientsDrugPanelViews.get(index));
        }
        if (kind == INFORMATION_MENU) {
            layeredPane.add(patientInfoPanelViews.get(index));
        }
        layeredPane.repaint();
        layeredPane.revalidate();
    }

    public void switchMainPanel() {
        layeredPane.removeAll();
        layeredPane.add(myPatientsMainPanel);
        layeredPane.repaint();
        layeredPane.revalidate();
    }

    public void switchCreationMenu() {
        layeredPane.removeAll();
        layeredPane.add(patientCreationPanelView);
        layeredPane.repaint();
        layeredPane.revalidate();
    }

    public void setPatientCreationPanelView(myPatientCreationPanelView patientCreationPanelView) {
        this.patientCreationPanelView = patientCreationPanelView;
    }

    public void setPatientInfoPanelViews(ArrayList<PatientInfoPanelView> patientInfoPanelViews) {
        this.patientInfoPanelViews = patientInfoPanelViews;
    }

    public void setPatientsDrugPanelViews(ArrayList<myPatientsDrugPanelView> patientsDrugPanelViews) {
        this.patientsDrugPanelViews = patientsDrugPanelViews;
    }

    public void setMyPatientsMainPanel(MyPatientsMainPanel myPatientsMainPanel) {
        this.myPatientsMainPanel = myPatientsMainPanel;
        layeredPane.add(myPatientsMainPanel);
        layeredPane.add(patientCreationPanelView);
    }

    public ArrayList<PatientInfoPanelView> getPatientInfoPanelViews() {
        return patientInfoPanelViews;
    }

    public ArrayList<myPatientsDrugPanelView> getPatientsDrugPanelViews() {
        return patientsDrugPanelViews;
    }

    public void createDrugAndInfoPanels() {
        for (int i = 0; i < doctor.getPatientSlots().size(); i++) {
            patientsDrugPanelViews.add(new myPatientsDrugPanelView(doctor.getPatientSlots().get(i), doctor, this));
        }
        for (int i = 0; i < doctor.getPatientSlots().size(); i++) {
            patientInfoPanelViews.add(new PatientInfoPanelView(doctor.getPatientSlots().get(i), this, i));
        }
    }
}
