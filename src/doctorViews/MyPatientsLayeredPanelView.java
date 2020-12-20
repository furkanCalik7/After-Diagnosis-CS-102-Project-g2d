package doctorViews;

import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.BorderLayout;

public class MyPatientsLayeredPanelView extends JPanel {
    MyPatientsMainPanel myPatientsMainPanel;
    JLayeredPane layeredPane;
    myPatientCreationPanelView patientCreationPanelView;
    /**
     * Create the panel.
     */
    public MyPatientsLayeredPanelView() {
        setLayout(new BorderLayout(0, 0));
        patientCreationPanelView = new myPatientCreationPanelView();
        myPatientsMainPanel = new MyPatientsMainPanel();

        layeredPane = new JLayeredPane();
        add(layeredPane);
        layeredPane.setLayout(new CardLayout(0, 0));

        layeredPane.add(myPatientsMainPanel);
        layeredPane.add(patientCreationPanelView);
    }

}
