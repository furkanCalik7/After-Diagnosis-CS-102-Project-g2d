package Doctor.Controller;

import Doctor.Model.Doctor;
import LabTechs.Model.Test;

import javax.swing.*;

public class RemoveTestController {
    public RemoveTestController(int index, JPanel jpanel, Doctor doctor){
        int i = JOptionPane.showConfirmDialog(jpanel, "Are you sure to remove?", "Remove Confirmation", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            doctor.removeTest(index);
            JOptionPane.showMessageDialog(jpanel,"Test is removed.");
        } else {
            JOptionPane.showMessageDialog(jpanel,"Test is not removed.");
        }
    }
}
