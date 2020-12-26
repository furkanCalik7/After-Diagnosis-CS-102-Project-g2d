package Patient.Controllers;

import Patient.Model.Patient;
import Patient.Views.MedInfoPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MedInfoControls extends JButton {

    private Patient patient;
    private MedInfoPanel panel;

    public MedInfoControls(Patient patient, MedInfoPanel panel) {
        this.patient = patient;
        this.panel = panel;
        setText("Save your changes");
        addActionListener(new InfoSaverListener());
    }

    class InfoSaverListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String allergie = panel.getAllergieTextField().getText();
            String surgery = panel.getSurgeryTextField().getText();
            String bloodType = panel.getBloodTypecomboBox().getSelectedItem().toString();
            String rh = panel.getRhComboBox().getSelectedItem().toString();

            bloodType += rh;

            patient.setPatientInfo(null, bloodType, 0, allergie, surgery, ""); //TODO Date, age, complaint

        }
    }
}
