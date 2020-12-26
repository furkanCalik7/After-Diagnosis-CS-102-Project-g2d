package LabTechs.Controller;

import LabTechs.Model.LabTechnician;
import LabTechs.Model.Test;

import javax.swing.*;
import java.io.File;

public class FileChooserForUploadController {
    private JFileChooser chooser;
    private File selectedFile;

    public FileChooserForUploadController(JPanel panel) {
        chooser = new JFileChooser();
        chooser.setApproveButtonText("Upload");
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Choose the directory of test that is going to be uploaded");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        //filesonly

        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(panel) == JFileChooser.APPROVE_OPTION) {
            int i = JOptionPane.showConfirmDialog(panel, "Are you sure to upload??", "Upload Confirmation", JOptionPane.YES_NO_OPTION);
            if (i == JOptionPane.YES_OPTION) {
                selectedFile = new File(String.valueOf(chooser.getSelectedFile().toPath()));
                JOptionPane.showMessageDialog(panel,"Test is uploading...");
            } else {
                JOptionPane.showMessageDialog(panel,"Test is not uploaded.");
            }
        }
    }

    public File getFile(){
        return this.selectedFile;
    }

}