package Doctor.Controller;

import Doctor.Model.Doctor;
import Doctor.Views.LabTestsMainPanel;
import LabTechs.Model.Test;

import javax.swing.*;

public class FileChooserForDownloadController {
    private JFileChooser chooser;

    public FileChooserForDownloadController(LabTestsMainPanel labTestsMainPanel, Test test, Doctor doctor) {
        chooser = new JFileChooser();
        chooser.setApproveButtonText("Download");
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Choose directory to download test");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(labTestsMainPanel) == JFileChooser.APPROVE_OPTION) {
            int i = JOptionPane.showConfirmDialog(labTestsMainPanel, "Are you sure to download?", "Download Confirmation", JOptionPane.YES_NO_OPTION);
            if (i == JOptionPane.YES_OPTION) {
                doctor.downloadTest(test, chooser.getSelectedFile().toPath());
                JOptionPane.showMessageDialog(labTestsMainPanel,"Test is downloaded.");
            } else {
                JOptionPane.showMessageDialog(labTestsMainPanel,"Test is not downloaded.");
            }
        }
    }

}

