package LabTechs.Controller;

import LabTechs.Model.LabTechnician;
import LabTechs.Model.Test;

import javax.swing.*;

public class FileChooserForDownloadController {
    private JFileChooser chooser;

    public FileChooserForDownloadController(JPanel panel, Test test, LabTechnician labTechnician) {
        chooser = new JFileChooser();
        chooser.setApproveButtonText("Download");
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Choose directory to download test");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //filesonly

        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(panel) == JFileChooser.APPROVE_OPTION) {
            int i = JOptionPane.showConfirmDialog(panel, "Are you sure to download?", "Download Confirmation", JOptionPane.YES_NO_OPTION);
            if (i == JOptionPane.YES_OPTION) {
                labTechnician.downloadTest(test, chooser.getSelectedFile().toPath());
                JOptionPane.showMessageDialog(panel,"Test is downloaded.");
            } else {
                JOptionPane.showMessageDialog(panel,"Test is not downloaded.");
            }
        }
    }

}