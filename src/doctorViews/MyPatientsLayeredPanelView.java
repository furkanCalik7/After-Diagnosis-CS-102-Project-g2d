package doctorViews;

import Doctor.Model.Doctor;

import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.util.ArrayList;

public class MyPatientsLayeredPanelView extends JPanel {
    public static final int DRUG_MENU = 0;
    public static final int INFORMATION_MENU = 1;
    MyPatientsMainPanel myPatientsMainPanel;
    JLayeredPane layeredPane;
    myPatientCreationPanelView patientCreationPanelView;
    ArrayList<PatientInfoPanelView> patientInfoPanelViews;
    ArrayList<myPatientsDrugPanelView> patientsDrugPanelViews;

    public MyPatientsLayeredPanelView(Doctor doctor) {
        setLayout(new BorderLayout(0, 0));
        patientCreationPanelView = new myPatientCreationPanelView();
        myPatientsMainPanel = new MyPatientsMainPanel(doctor,this);
        patientsDrugPanelViews = new ArrayList<>();
        patientInfoPanelViews = new ArrayList<>();

        for(int i = 0; i < doctor.getPatientSlots().size(); i++){
            patientsDrugPanelViews.add(new myPatientsDrugPanelView(doctor.getPatientSlots().get(i),doctor));
        }
        for(int i = 0; i < doctor.getPatientSlots().size(); i++){
            patientInfoPanelViews.add(new PatientInfoPanelView(doctor.getPatientSlots().get(i),this));
        }

        layeredPane = new JLayeredPane();
        add(layeredPane);
        layeredPane.setLayout(new CardLayout(0, 0));

        layeredPane.add(myPatientsMainPanel);
        layeredPane.add(patientCreationPanelView);
    }
    public void switchPanels(int index, int kind) {
        layeredPane.removeAll();
        if(kind == DRUG_MENU){
            layeredPane.add(patientsDrugPanelViews.get(index));
        }
        if(kind == INFORMATION_MENU){
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
}
