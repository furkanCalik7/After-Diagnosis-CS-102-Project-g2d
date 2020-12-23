package doctorViews;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LabTestsMainPanel extends JPanel {
    private JTextField patientNameTextField;
    private JTextField txtTestName;
    private JLayeredPane layeredPane;
    private JTable table;
    private JPanel seeAvailableTestsPanel;

    public void switchPanels( JPanel panel ) {
        layeredPane.removeAll();
        layeredPane.add(panel);
        layeredPane.repaint();
        layeredPane.revalidate();
    }
    
    public LabTestsMainPanel() {

        setLayout(new BorderLayout(0, 0));


        layeredPane = new JLayeredPane();
        layeredPane.setLayout(new CardLayout(0, 0));

        //Create Request Panel
        JPanel centerInfoPanel = new JPanel();
        add(centerInfoPanel, BorderLayout.CENTER);
        centerInfoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 50));

        JPanel createRequestPanel = new JPanel();
        layeredPane.add(createRequestPanel, "name_911052869684500");
        createRequestPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JPanel createRequest = new JPanel();
        createRequest.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        createRequestPanel.add(createRequest);
        createRequest.setLayout(new BorderLayout(0, 0));

        JPanel buttonPanel = new JPanel();
        FlowLayout fl_buttonPanel = (FlowLayout) buttonPanel.getLayout();
        fl_buttonPanel.setAlignment(FlowLayout.RIGHT);
        createRequest.add(buttonPanel, BorderLayout.SOUTH);

        JButton sendRequestButton = new JButton("Send Requests");
        sendRequestButton.setFont(new Font("Century", Font.PLAIN, 20));
        buttonPanel.add(sendRequestButton);

        JPanel centerPanel = new JPanel();
        createRequest.add(centerPanel);
        centerPanel.setLayout(new GridLayout(2, 2, 0, 0));

        JPanel patientNamePanel = new JPanel();
        centerPanel.add(patientNamePanel);

        JLabel patientNameLbl = new JLabel("Patient Name:");
        patientNameLbl.setFont(new Font("Century", Font.PLAIN, 20));
        patientNamePanel.add(patientNameLbl);

        JPanel patientNameTxtFPanel = new JPanel();
        centerPanel.add(patientNameTxtFPanel);

        patientNameTextField = new JTextField();
        patientNameTextField.setFont(new Font("Century", Font.PLAIN, 20));
        //TODO Tıklayınca yazının yok olmasını sağla textfielddan.
        patientNameTextField.setText("Patient Name");
        patientNameTxtFPanel.add(patientNameTextField);
        patientNameTextField.setColumns(10);

        JPanel testNamePanel = new JPanel();
        centerPanel.add(testNamePanel);

        JLabel lblNewLabel = new JLabel("Enter Wanted Test Name");
        lblNewLabel.setFont(new Font("Century", Font.PLAIN, 20));
        testNamePanel.add(lblNewLabel);

        JPanel testNameTxtFPanel = new JPanel();
        centerPanel.add(testNameTxtFPanel);

        txtTestName = new JTextField();
        txtTestName.setText("Test Name");
        txtTestName.setFont(new Font("Century", Font.PLAIN, 20));
        testNameTxtFPanel.add(txtTestName);
        txtTestName.setColumns(10);

        centerInfoPanel.add(layeredPane);

        //See available Tests Panel
        seeAvailableTestsPanel = new JPanel();
        layeredPane.add(seeAvailableTestsPanel, "name_911055903035000");


        //Building the table.
        table = new JTable();
        table.setFont(new Font("Century", Font.PLAIN, 15));
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
                        "Patient Name", "Test Type", "Date", "Status", "Remove Patient"
                }
        ));
        JScrollPane scrollPane = new JScrollPane( table );

        seeAvailableTestsPanel.add(scrollPane);

        //Buttons and more
        JPanel buttonsPanel = new JPanel();
        add(buttonsPanel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setHgap(0);
        buttonsPanel.add(panel);

        JButton labReqButton = new JButton("Create a Lab Request");
        labReqButton.setFont(new Font("Century", Font.PLAIN, 20));
        labReqButton.setBackground(new Color(38, 69, 191));
        panel.add(labReqButton);

        JButton availableTestsButton = new JButton("See Available Tests");
        availableTestsButton.setFont(new Font("Century", Font.PLAIN, 20));
        availableTestsButton.setBackground(new Color(240, 240, 240));
        panel.add(availableTestsButton);

        //Button Action Listeners.
        labReqButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels( createRequestPanel );
                availableTestsButton.setBackground(new Color(240, 240, 240));
                labReqButton.setBackground(new Color(38, 69, 191));
            }
        });

        availableTestsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels( seeAvailableTestsPanel );
                labReqButton.setBackground(new Color(240, 240, 240));
                availableTestsButton.setBackground(new Color(38, 69, 191));
            }
        });
    }
}
