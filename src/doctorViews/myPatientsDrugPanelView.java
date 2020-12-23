package doctorViews;

import Doctor.Model.Doctor;
import Doctor.Model.PatientSlot;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.border.MatteBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class myPatientsDrugPanelView extends JPanel {
    private String[] drugNameArray;
    private JTextField dose;

    private JTextField startingDateTextField;
    private JTextField endingDateTextField;
    private JTable table;
    private JScrollPane scrollPane;
    private ButtonGroup hungryButtonGroup;

    private JComboBox drugComboBox;
    private JCheckBox isEvening;
    private JCheckBox isAfternoon;
    private JCheckBox isMorning;
    private String patient_username;


    public JTextField getDose() {
        return dose;
    }

    public ButtonGroup getHungryButtonGroup() {
        return hungryButtonGroup;
    }

    public JTextField getStartingDateTextField() {
        return startingDateTextField;
    }

    public JTextField getEndingDateTextField() {
        return endingDateTextField;
    }

    public JComboBox getDrugComboBox() {
        return drugComboBox;
    }

    public JCheckBox getIsEvening() {
        return isEvening;
    }

    public JCheckBox getIsAfternoon() {
        return isAfternoon;
    }

    public JCheckBox getIsMorning() {
        return isMorning;
    }

    public String getPatient_username() {
        return patient_username;
    }

    /**
     * Create the panel.
     */
    public myPatientsDrugPanelView(PatientSlot patientSlot, Doctor doctor) {
        patient_username = patientSlot.getPatientInfo().getUsername();
        BorderLayout borderLayout = new BorderLayout();
        borderLayout.setVgap(5);
        setLayout(borderLayout );


        JPanel centerPanel = new JPanel();
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new GridLayout(2, 1, 0, 5));


        JPanel inputPanel = new JPanel();
        centerPanel.add(inputPanel);
        inputPanel.setLayout(new GridLayout(0, 3, 5, 0));


        JPanel drugInputPanel = new JPanel();
        inputPanel.add(drugInputPanel);
        drugInputPanel.setLayout(new GridLayout(3, 0, 0, 5));

        JPanel drugNamePanel = new JPanel();
        drugNamePanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        drugInputPanel.add(drugNamePanel);

        JLabel drugLabel = new JLabel("Drug Name:");
        drugLabel.setFont(new Font("Century", Font.PLAIN, 15));
        drugNamePanel.add(drugLabel);

        //Most common prescriptions. Will be added to the drug choices.
        drugNameArray = new String[]{ "Vicodin", "Amoxil", "Lipitor", "Motrin", "Synthroid", "Delasone" };

        drugComboBox = new JComboBox( drugNameArray );
        drugComboBox.setFont(new Font("Century", Font.PLAIN, 13));
        drugNamePanel.add(drugComboBox);

        JPanel dosePanel = new JPanel();
        dosePanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        drugInputPanel.add(dosePanel);

        JLabel enterDoseLabel = new JLabel("Enter Doses:");
        enterDoseLabel.setFont(new Font("Century", Font.PLAIN, 15));
        dosePanel.add(enterDoseLabel);

        dose = new JTextField();
        dosePanel.add(dose);
        dose.setColumns(10);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        drugInputPanel.add(panel);
        panel.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel statusPanel = new JPanel();
        panel.add(statusPanel);

        JLabel lblNewLabel = new JLabel("Hungry/Full");
        lblNewLabel.setFont(new Font("Century", Font.PLAIN, 15));
        statusPanel.add(lblNewLabel);

        JPanel choicePanel = new JPanel();
        panel.add(choicePanel);
        choicePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        //Hungry Full radiobuttons.
        JRadioButton hungryButton = new JRadioButton("Hungry");
        choicePanel.add(hungryButton);
        hungryButton.setActionCommand("Hungry");

        JRadioButton fullButton = new JRadioButton("Full");
        choicePanel.add(fullButton);
        fullButton.setActionCommand("Full");

        hungryButtonGroup = new ButtonGroup();
        hungryButtonGroup.add(fullButton);
        hungryButtonGroup.add(hungryButton);
        hungryButton.setSelected(true);

        JPanel schedulePanel = new JPanel();
        schedulePanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        inputPanel.add(schedulePanel);
        schedulePanel.setLayout(new BorderLayout(12, 0));

        JPanel scheduleLabelHolderPanel = new JPanel();
        schedulePanel.add(scheduleLabelHolderPanel, BorderLayout.NORTH);

        JLabel scheduleLabel = new JLabel("Daily Schedule:");
        scheduleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        scheduleLabelHolderPanel.add(scheduleLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.CYAN));
        schedulePanel.add(panel_1);
        panel_1.setLayout(new GridLayout(3, 2, 0, 0));

        JPanel morningHolderPanel = new JPanel();
        morningHolderPanel.setBorder(new EmptyBorder(0, 5, 0, 5));
        panel_1.add(morningHolderPanel);

        isMorning = new JCheckBox("Morning");
        morningHolderPanel.add(isMorning);

        JPanel anoonHolderPanel = new JPanel();
        panel_1.add(anoonHolderPanel);

        isAfternoon = new JCheckBox("Afternoon");
        anoonHolderPanel.add(isAfternoon);

        JPanel eveningHolderPanel = new JPanel();
        panel_1.add(eveningHolderPanel);

        isEvening = new JCheckBox("Evening");
        eveningHolderPanel.add(isEvening);

        JPanel datePanel = new JPanel();
        inputPanel.add(datePanel);
        datePanel.setLayout(new GridLayout(3, 0, 0, 0));

        JPanel startingDatePanel = new JPanel();
        datePanel.add(startingDatePanel);

        JLabel dateStartPromptLabel = new JLabel("Enter Starting Date:");
        dateStartPromptLabel.setFont(new Font("Century", Font.PLAIN, 15));
        startingDatePanel.add(dateStartPromptLabel);

        //TODO this text field takes starting field of the drug.
        startingDateTextField = new JTextField();
        startingDatePanel.add(startingDateTextField);
        startingDateTextField.setColumns(10);

        JPanel panel_4 = new JPanel();
        datePanel.add(panel_4);

        JLabel lblNewLabel_1 = new JLabel("Enter Ending Date:");
        lblNewLabel_1.setFont(new Font("Century", Font.PLAIN, 15));
        panel_4.add(lblNewLabel_1);

        //TODO this text field takes ending field of the drug.
        endingDateTextField = new JTextField();
        panel_4.add(endingDateTextField);
        endingDateTextField.setColumns(10);

        JPanel panel_3 = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
        flowLayout_1.setAlignment(FlowLayout.TRAILING);
        datePanel.add(panel_3);

        //TODO this button creates the drug..
        JButton btnNewButton = new JButton("Create New Drug");
        btnNewButton.setFont(new Font("Century", Font.PLAIN, 16));
        panel_3.add(btnNewButton);
        btnNewButton.addActionListener(new AddDrugController(this,doctor));

        JPanel tablePanel = new JPanel();
        centerPanel.add(tablePanel);
        tablePanel.setLayout(new BorderLayout(0, 0));

        //Table and scrollpane initializations.
        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[] {
                        "Drug Name", "Daily Schedule", "Doses", "Time Period", "Remove Drug"
                }
        ));
        scrollPane = new JScrollPane( table );
        tablePanel.add( scrollPane);

        JPanel welcomePanel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) welcomePanel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        add(welcomePanel, BorderLayout.NORTH);

        JLabel welcomeLabel = new JLabel("Patient Information: Drug List");
        welcomeLabel.setFont(new Font("Century", Font.PLAIN, 20));
        welcomePanel.add(welcomeLabel);

        JPanel nextButtonPanel = new JPanel();
        FlowLayout fl_nextButtonPanel = (FlowLayout) nextButtonPanel.getLayout();
        fl_nextButtonPanel.setAlignment(FlowLayout.RIGHT);
        add(nextButtonPanel, BorderLayout.SOUTH);

        //TODO this button is at the bottom-right. May be changed?
        JButton nextButton = new JButton("NEXT");
        nextButton.setFont(new Font("Century", Font.PLAIN, 20));
        nextButtonPanel.add(nextButton);


    }

}
