package Doctor.Views;


import Admin.model.IViewer;
import Doctor.Controller.SendTestRequestController;
import Doctor.Model.Doctor;
import Doctor.Model.PatientSlot;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientInfoPanelView extends JPanel implements ActionListener, IViewer {


    private MyPatientsLayeredPanelView panel;
    private final JButton drugButton;
    private final JButton backButton;
    private int index;

    public PatientInfoPanelView(PatientSlot patientSlot, MyPatientsLayeredPanelView panel, int i, Doctor doctor) {
        this.panel = panel;
        this.index = i;
        setLayout(new BorderLayout(0, 15));

        FlowLayout informationFlowLayout = new FlowLayout();
        informationFlowLayout.setAlignment(FlowLayout.LEFT);
        JPanel northPanel = new JPanel(informationFlowLayout);
        northPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        add(northPanel, BorderLayout.NORTH);

        backButton = new JButton("<--");
        northPanel.add(backButton);
        backButton.addActionListener(this);

        JLabel headerLabel = new JLabel("Patient Information");
        headerLabel.setFont(new Font("Century", Font.PLAIN, 20));
        northPanel.add(headerLabel);

        JPanel centerPanel = new JPanel();
        centerPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new BorderLayout(0, 0));

        JPanel centerSouthButtonsPanel = new JPanel();
        centerPanel.add(centerSouthButtonsPanel, BorderLayout.SOUTH);

        JPanel centerInfoPanel = new JPanel();
        centerPanel.add(centerInfoPanel, BorderLayout.WEST);
        centerInfoPanel.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel patientNamePanel = new JPanel();
        patientNamePanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        centerInfoPanel.add(patientNamePanel);

        JLabel patientNamePrsntrLbl = new JLabel("Patient Name:");
        patientNamePrsntrLbl.setFont(new Font("Century", Font.PLAIN, 20));
        patientNamePanel.add(patientNamePrsntrLbl);


        JLabel patientNameLbl = new JLabel(patientSlot.getPatientInfo().getName() + " " + patientSlot.getPatientInfo().getSurname());
        patientNameLbl.setFont(new Font("Century", Font.PLAIN, 20));
        patientNamePanel.add(patientNameLbl);

        JPanel bloodTypePnl = new JPanel();
        bloodTypePnl.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        centerInfoPanel.add(bloodTypePnl);

        JLabel bloodTypePrsntrLbl = new JLabel("Blood Type:");
        bloodTypePrsntrLbl.setFont(new Font("Century", Font.PLAIN, 20));
        bloodTypePnl.add(bloodTypePrsntrLbl);

        JLabel bloodTypeLbl = new JLabel(patientSlot.getPatientInfo().getBloodType());
        bloodTypeLbl.setFont(new Font("Century", Font.PLAIN, 20));
        bloodTypePnl.add(bloodTypeLbl);

        JPanel patientAgePnl = new JPanel();
        patientAgePnl.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        centerInfoPanel.add(patientAgePnl);

        JLabel patientAgePrsntrLbl = new JLabel("Patient Age:");
        patientAgePnl.add(patientAgePrsntrLbl);
        patientAgePrsntrLbl.setFont(new Font("Century", Font.PLAIN, 20));

        JLabel patientAgeLbl = new JLabel(String.valueOf(patientSlot.getPatientInfo().getAge()));
        patientAgePnl.add(patientAgeLbl);
        patientAgeLbl.setFont(new Font("Century", Font.PLAIN, 20));

        JPanel patientNumberPanel = new JPanel();
        patientNumberPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        centerInfoPanel.add(patientNumberPanel);

        JLabel patientNumPrsntrLbl = new JLabel("Patient Number:");
        patientNumPrsntrLbl.setFont(new Font("Century", Font.PLAIN, 20));
        patientNumberPanel.add(patientNumPrsntrLbl);

        JLabel patientNumLbl = new JLabel(String.valueOf(patientSlot.getPatientInfo().getUser_id()));
        patientNumLbl.setFont(new Font("Century", Font.PLAIN, 20));
        patientNumberPanel.add(patientNumLbl);

        JPanel datePanel = new JPanel();
        datePanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        centerInfoPanel.add(datePanel);

        JLabel lblNewLabel = new JLabel("Date Of The First Appt.");
        datePanel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Century", Font.PLAIN, 20));

        JLabel lblNewLabel_1 = new JLabel(String.valueOf(patientSlot.getStart_date()));
        datePanel.add(lblNewLabel_1);
        lblNewLabel_1.setFont(new Font("Century", Font.PLAIN, 20));

        JPanel patientMailPnl = new JPanel();
        patientMailPnl.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        centerInfoPanel.add(patientMailPnl);

        JLabel patientMailPrsntrLbl = new JLabel("Patient Email:");
        patientMailPnl.add(patientMailPrsntrLbl);
        patientMailPrsntrLbl.setFont(new Font("Century", Font.PLAIN, 20));

        //This will be patient.getMail() ?
        JLabel patientMailLbl = new JLabel(patientSlot.getPatientInfo().getEmail());
        patientMailPnl.add(patientMailLbl);
        patientMailLbl.setFont(new Font("Century", Font.PLAIN, 20));

        JPanel southPanel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) southPanel.getLayout();
        flowLayout.setAlignment(FlowLayout.TRAILING);
        centerPanel.add(southPanel, BorderLayout.SOUTH);

        JButton requestButton = new JButton("Send Test Request");
        requestButton.addActionListener(new SendTestRequestController(this,doctor,patientSlot.getPatientInfo().getUsername()));
        requestButton.setFont(new Font("Century", Font.PLAIN, 15));
        southPanel.add(requestButton);

//        JButton editButton = new JButton("Edit Patient Information");
//        editButton.setFont(new Font("Century", Font.PLAIN, 15));
//        southPanel.add(editButton);

        drugButton = new JButton("Go to Drug Page of The Patient");
        drugButton.setFont(new Font("Century", Font.PLAIN, 15));
        drugButton.addActionListener(this);
        southPanel.add(drugButton);

        JPanel allergiesPanel = new JPanel();
        centerPanel.add(allergiesPanel, BorderLayout.CENTER);
        allergiesPanel.setLayout(new GridLayout(2, 2, 0, 5));

        JPanel allergiesLblPanel = new JPanel();
        allergiesLblPanel.setBorder(new EmptyBorder(2, 0, 0, 0));
        allergiesPanel.add(allergiesLblPanel);
        allergiesLblPanel.setLayout(new BorderLayout(0, 0));

        JPanel allergiesTopPanel = new JPanel();
        allergiesTopPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        allergiesLblPanel.add(allergiesTopPanel, BorderLayout.NORTH);

        JLabel allergiesPrsntLbl = new JLabel("Allergies:");
        allergiesTopPanel.add(allergiesPrsntLbl);
        allergiesPrsntLbl.setFont(new Font("Century", Font.PLAIN, 20));
        allergiesPrsntLbl.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel allergiesLabel = new JLabel(patientSlot.getPatientInfo().getAllergies());
        allergiesTopPanel.add(allergiesLabel);
        allergiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        allergiesLabel.setFont(new Font("Century", Font.PLAIN, 20));

        JPanel emptyPanel = new JPanel();
        allergiesPanel.add(emptyPanel);

        JPanel emptySouthPanel = new JPanel();
        add(emptySouthPanel, BorderLayout.SOUTH);

        Component verticalStrut = Box.createVerticalStrut(20);
        emptySouthPanel.add(verticalStrut);


        //Color
        northPanel.setBackground(new Color(101, 180, 206));
        centerPanel.setBackground(new Color(101, 180, 206));
        emptySouthPanel.setBackground(new Color(101, 180, 206));
        this.setBackground(new Color(101, 180, 206));
        centerInfoPanel.setBackground(new Color(101, 180, 206));
        allergiesPanel.setBackground(new Color(101, 180, 206));
        emptyPanel.setBackground(new Color(101, 180, 206));
        allergiesLblPanel.setBackground(new Color(101, 180, 206));
        southPanel.setBackground(SystemColor.activeCaption);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.backButton){
            panel.switchMainPanel();
        }else if(e.getSource() == this.drugButton){
            panel.switchPanels(index,MyPatientsLayeredPanelView.DRUG_MENU);
        }
    }


    @Override
    public void update() {

    }
}
