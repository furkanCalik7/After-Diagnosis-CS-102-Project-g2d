package LabTechs.Controller;

import LabTechs.Model.LabTechnician;
import LabTechs.Model.Test;
import LabTechs.Model.TestRequest;
import LabTechs.Views.WaitingTestsPanel;

import javax.swing.*;
import java.io.File;

public class FileChooserForUploadController {
    private JFileChooser chooser;

    public FileChooserForUploadController(JPanel panel , TestRequest testRequest , LabTechnician labTechnician) {
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
                try {
                    File selectedFile = new File(String.valueOf(chooser.getSelectedFile().toPath()));
                    System.out.println( "The filepath: |" + selectedFile.getAbsolutePath() + "|" );
                    Test test = Test.newTest( testRequest.getDoctor_username(), labTechnician.getUsername(), testRequest.getTest_name() , testRequest.getPatient() , selectedFile );
                    boolean isUploadSuccesfull = test.sendTest();

                    if( isUploadSuccesfull ){
                        labTechnician.deleteTestRequest( testRequest );
                        JOptionPane.showMessageDialog( panel , "The Test has been successfully Uploaded!" );
                    }

                    else{ JOptionPane.showMessageDialog( panel , "The test could not have been Uploaded!" ); }

                } catch (NullPointerException e) {
                    //JOptionPane.showMessageDialog( panel , "No file has selected!" );
                }catch ( Exception e ){
                    e.printStackTrace();
                }

            } else {
                JOptionPane.showMessageDialog(panel,"Test is not uploaded.");
            }
        }
    }

}
