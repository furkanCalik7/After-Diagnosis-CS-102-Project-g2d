package Patient.Views;

import Doctor.Views.DatePickerPanel;
import Patient.Controllers.MedInfoControls;
import Patient.Model.Patient;

import javax.swing.*;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.ButtonGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MedInfoPanel extends JPanel {
    private JTextField allergieTextField;
    private JTextField surgeryTextField;
    private JTextField additionalInfoTextField;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField txtSearch;
    private JTable table;
    private JPanel enterInfoPanel;
    private JPanel labResultsPanel;
    private JButton labResultsButton;
    private JButton medInfoButton;


    private JLayeredPane layeredPane;
    private JComboBox bloodTypecomboBox;
    private JComboBox rhComboBox;
    private DatePickerPanel datePickPanel;

    /**
     * Create the panel.
     */
    public void switchPanels( JPanel panel ) {
        layeredPane.removeAll();
        layeredPane.add(panel);
        layeredPane.repaint();
        layeredPane.revalidate();
    }

    public JComboBox getRhComboBox() {
        return rhComboBox;
    }

    public JComboBox getBloodTypecomboBox() {
        return bloodTypecomboBox;
    }

    public JTextField getAllergieTextField() {
        return allergieTextField;
    }

    public JTextField getSurgeryTextField() {
        return surgeryTextField;
    }

    public JTextField getAdditionalInfoTextField() {
        return additionalInfoTextField;
    }

    public DatePickerPanel getDatePickPanel() {
        return datePickPanel;
    }

    public MedInfoPanel(Patient patient) {

        setLayout(new BorderLayout(0, 0));

        JPanel topButtonsPanel = new JPanel();
        topButtonsPanel.setBackground(new Color(101, 180, 206));
        add(topButtonsPanel, BorderLayout.NORTH);

        medInfoButton = new JButton("Enter Your Medical Information");
        medInfoButton.setFont(new Font("Century", Font.PLAIN, 15));
        topButtonsPanel.add(medInfoButton);

        labResultsButton = new JButton("See Your Lab Results");
        labResultsButton.setFont(new Font("Century", Font.PLAIN, 15));
        topButtonsPanel.add(labResultsButton);

        layeredPane = new JLayeredPane();
        layeredPane.setBackground(new Color(101, 180, 206));
        add(layeredPane, BorderLayout.CENTER);
        layeredPane.setLayout(new CardLayout(0, 0));

        enterInfoPanel = new JPanel();
        enterInfoPanel.setBackground(new Color(101, 180, 206));
        layeredPane.add(enterInfoPanel, "name_1195886766063900");
        enterInfoPanel.setLayout(new GridLayout(6, 0, 20, 20));

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(101, 180, 206));
        enterInfoPanel.add(panel_1);
        panel_1.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel lblNewLabel = new JLabel("Choose your blood type");
        lblNewLabel.setFont(new Font("Century", Font.PLAIN, 15));
        panel_1.add(lblNewLabel);

        JPanel panel_9 = new JPanel();
        panel_9.setBackground(new Color(101, 180, 206));
        panel_1.add(panel_9);
        panel_9.setLayout(new GridLayout(1, 0, 0, 0));

        String[] bloodTypes = new String[]{"AB","A","B","0"};
        String[] rh = new String[]{"Rh +","Rh -"};

        bloodTypecomboBox = new JComboBox(bloodTypes);
        bloodTypecomboBox.setFont(new Font("Century", Font.PLAIN, 15));

        JPanel bloodTypecomboBoxContainer = new JPanel();
        bloodTypecomboBoxContainer.setBackground(new Color(101, 180, 206));
        bloodTypecomboBoxContainer.add(bloodTypecomboBox);
        bloodTypecomboBoxContainer.setBorder(new EmptyBorder(20,0,20,0));

        panel_9.add( bloodTypecomboBoxContainer );

        rhComboBox = new JComboBox(rh);
        rhComboBox.setFont(new Font("Century", Font.PLAIN, 15));
        JPanel rhComboBoxContainer = new JPanel();
        rhComboBoxContainer.setBackground(new Color(101, 180, 206));
        rhComboBoxContainer.add(rhComboBox);
        rhComboBoxContainer.setBorder(new EmptyBorder(20,0,20,20));

        panel_9.add(rhComboBoxContainer);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(101, 180, 206));
        enterInfoPanel.add(panel_2);
        panel_2.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel lblNewLabel_1 = new JLabel("Enter your allergies (if exists)");
        lblNewLabel_1.setFont(new Font("Century", Font.PLAIN, 15));
        panel_2.add(lblNewLabel_1);

        allergieTextField = new JTextField();
        allergieTextField.setFont(new Font("Century", Font.PLAIN, 15));
        panel_2.add(allergieTextField);
        allergieTextField.setColumns(10);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(101, 180, 206));
        enterInfoPanel.add(panel_3);
        panel_3.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel lblNewLabel_2 = new JLabel("Did you have any surgeries?");
        lblNewLabel_2.setFont(new Font("Century", Font.PLAIN, 15));
        panel_3.add(lblNewLabel_2);

        JPanel panel_6 = new JPanel();
        panel_6.setBackground(new Color(101, 180, 206));
        panel_3.add(panel_6);
        panel_6.setLayout(new GridLayout(2, 0, 0, 0));

        JPanel panel_8 = new JPanel();
        panel_8.setBackground(new Color(101, 180, 206));
        panel_6.add(panel_8);
        panel_8.setLayout(new GridLayout(0, 2, 0, 0));

        JRadioButton yesRadioButon = new JRadioButton("Yes");
        yesRadioButon.setFont(new Font("Century", Font.PLAIN, 15));
        buttonGroup.add(yesRadioButon);
        panel_8.add(yesRadioButon);

        JRadioButton noRadioButton = new JRadioButton("No");
        noRadioButton.setFont(new Font("Century", Font.PLAIN, 15));
        buttonGroup.add(noRadioButton);
        panel_8.add(noRadioButton);

        JPanel panel_7 = new JPanel();
        panel_7.setBackground(new Color(101, 180, 206));
        panel_6.add(panel_7);
        panel_7.setLayout(new GridLayout(1, 0, 0, 0));

        surgeryTextField = new JTextField();
        surgeryTextField.setFont(new Font("Century", Font.PLAIN, 15));
        panel_7.add(surgeryTextField);
        surgeryTextField.setColumns(10);

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(101, 180, 206));
        enterInfoPanel.add(panel_4);
        panel_4.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel lblNewLabel_3 = new JLabel("Please write any additional information.");
        lblNewLabel_3.setFont(new Font("Century", Font.PLAIN, 15));
        panel_4.add(lblNewLabel_3);

        additionalInfoTextField = new JTextField();
        additionalInfoTextField.setFont(new Font("Century", Font.PLAIN, 15));
        panel_4.add(additionalInfoTextField);
        additionalInfoTextField.setColumns(10);

        JPanel datePickContainer = new JPanel();
        enterInfoPanel.add(datePickContainer);
        datePickContainer.setLayout(new GridLayout(0, 2, 0, 0));
        datePickContainer.setBackground(new Color(101, 180, 206));

        JPanel dateLabelPanel = new JPanel();
        dateLabelPanel.setBackground(new Color(101, 180, 206));
        datePickContainer.add(dateLabelPanel);
        dateLabelPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel dateLabel = new JLabel("Please choose your birthday");
        dateLabel.setFont(new Font("Century", Font.PLAIN, 15));
        dateLabelPanel.add(dateLabel);

        datePickPanel = new DatePickerPanel();
        datePickPanel.setBackground(new Color(101, 180, 206));
        datePickContainer.add(datePickPanel);

        JPanel completeButtonPanel = new JPanel();
        completeButtonPanel.setBackground(new Color(101, 180, 206));
        enterInfoPanel.add(completeButtonPanel);
        completeButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton completeButton = new JButton("Complete ");
        completeButton.setFont(new Font("Century", Font.PLAIN, 15));
        completeButtonPanel.add(completeButton);

        labResultsPanel = new JPanel();
        labResultsPanel.setBackground(new Color(101, 180, 206));
        layeredPane.add(labResultsPanel, "name_1195886789861600");
        labResultsPanel.setLayout(new BorderLayout(0, 0));

        JPanel labResultsTopPanel = new JPanel();
        labResultsTopPanel.setBackground(new Color(101, 180, 206));
        labResultsPanel.add(labResultsTopPanel, BorderLayout.NORTH);
        labResultsTopPanel.setLayout(new GridLayout(2, 0, 0, 0));

        JPanel panel_11 = new JPanel();
        panel_11.setBackground(new Color(101, 180, 206));
        labResultsTopPanel.add(panel_11);
        panel_11.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel lblNewLabel_4 = new JLabel("Search By Test Name");
        lblNewLabel_4.setFont(new Font("Century", Font.PLAIN, 15));
        panel_11.add(lblNewLabel_4);

        JPanel panel_12 = new JPanel();
        panel_12.setBackground(new Color(101, 180, 206));
        labResultsTopPanel.add(panel_12);
        panel_12.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        txtSearch = new JTextField();
        txtSearch.setFont(new Font("Century", Font.PLAIN, 15));
        txtSearch.setText("Search");
        panel_12.add(txtSearch);
        txtSearch.setColumns(20);

        JPanel labResultsWestPanel = new JPanel();
        labResultsWestPanel.setBackground(new Color(101, 180, 206));
        labResultsPanel.add(labResultsWestPanel, BorderLayout.CENTER);
        labResultsWestPanel.setLayout(new BorderLayout(0, 0));

        table = new JTable();
        table.setFont(new Font("Century", Font.PLAIN, 15));
        table.setEnabled(false);
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
                        "Test Name", "Doctor who give the test", "Date"
                }
        ));

        JScrollPane scrollPane = new JScrollPane( table );
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        JPanel tablePanel = new JPanel();
        tablePanel.setBackground(new Color(101, 180, 206));
        tablePanel.add(scrollPane);
        labResultsWestPanel.add(tablePanel, BorderLayout.WEST);


        medInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanels( enterInfoPanel);
            }
        });

        labResultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchPanels( labResultsPanel);
            }
        });



    }
}

