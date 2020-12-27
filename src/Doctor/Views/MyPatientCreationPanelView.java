package Doctor.Views;

import Admin.model.IViewer;
import Doctor.Controller.CreatePatientCodeController;
import Doctor.Model.Doctor;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPatientCreationPanelView extends JPanel implements IViewer {
    private JTextField complaintTextField;
    private JLabel allergyTextField;
    private Doctor doctor;



    public MyPatientCreationPanelView(MyPatientsLayeredPanelView layeredPanelView, Doctor doctor) {
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        this.doctor = doctor;

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.GRAY));
        add(panel);
        panel.setLayout(new GridLayout(10, 1, 0, 0));

        JPanel patientInfoPanel = new JPanel();
        patientInfoPanel.setBorder(new LineBorder(new Color(128, 128, 128)));
        panel.add(patientInfoPanel);
        patientInfoPanel.setLayout(new BorderLayout(0, 0));

        JPanel holderPanel = new JPanel();
        patientInfoPanel.add(holderPanel);
        holderPanel.setLayout(new BorderLayout(20, 0));

        JButton returnButton = new JButton("Return");
        holderPanel.add(returnButton, BorderLayout.WEST);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layeredPanelView.switchMainPanel();
            }
        });

        JLabel topGenericLabel = new JLabel("Patient Code");
        holderPanel.add(topGenericLabel, BorderLayout.CENTER);
        topGenericLabel.setFont(new Font("Century", Font.PLAIN, 20));


        JPanel patientDiseasePanel = new JPanel();
        patientDiseasePanel.setBorder(new LineBorder(Color.GRAY));
        panel.add(patientDiseasePanel);
        patientDiseasePanel.setLayout(new GridLayout(0, 2, 5, 0));

        JPanel panel_5 = new JPanel();
        patientDiseasePanel.add(panel_5);

        JLabel complaintPresenterLabel = new JLabel("Patient's Complaint");
        complaintPresenterLabel.setFont(new Font("Century", Font.PLAIN, 20));
        panel_5.add(complaintPresenterLabel);

        JPanel panel_6 = new JPanel();
        patientDiseasePanel.add(panel_6);
        panel_6.setLayout(new BorderLayout(0, 0));

        complaintTextField = new JTextField();
        panel_6.add(complaintTextField, BorderLayout.CENTER);
        complaintTextField.setColumns(10);
        complaintTextField.setText("123");


        JPanel allergiesPanel = new JPanel();
        allergiesPanel.setBorder(new LineBorder(Color.GRAY));
        panel.add(allergiesPanel);
        allergiesPanel.setLayout(new GridLayout(0, 2, 5, 0));

        JPanel allergyLblPanel = new JPanel();
        allergiesPanel.add(allergyLblPanel);

        JLabel allergiesPrsntrLbl = new JLabel("Created Code:");
        allergiesPrsntrLbl.setFont(new Font("Century", Font.PLAIN, 20));
        allergyLblPanel.add(allergiesPrsntrLbl);

        JPanel allergyTextFieldPanel = new JPanel();
        allergiesPanel.add(allergyTextFieldPanel);
        allergyTextFieldPanel.setLayout(new BorderLayout(0, 0));

        allergyTextField = new JLabel();
        allergyTextFieldPanel.add(allergyTextField);
        allergyTextFieldPanel.setBackground(Color.white);

        JPanel buttonPanel = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout) buttonPanel.getLayout();
        flowLayout_2.setAlignment(FlowLayout.RIGHT);
        panel.add(buttonPanel);

        JButton btnNewButton = new JButton("Create Patient");
        btnNewButton.setFont(new Font("Century", Font.PLAIN, 18));
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreatePatientCodeController createPatientCodeController = new CreatePatientCodeController(MyPatientCreationPanelView.this,doctor,complaintTextField.getText());
                createPatientCodeController.controller();
            }
        });
        // new CreatePatientCodeController(this,doctor,complaintTextField.getText())
        buttonPanel.add(btnNewButton);
    }

    public void setAllergyTextField(JLabel allergyTextField) {
        this.allergyTextField = allergyTextField;
    }

    @Override
    public void update() {
        allergyTextField.setText(doctor.getCreatedLastCode().getCode_id());
    }
}

