package doctorViews;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.Point;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class MyPatientsMainPanel extends JPanel {
    private JTable table;
    private JTextField txtSearchPatientBy;
    private String[] sortArray;

    /**
     * Create the panel.
     */
    public MyPatientsMainPanel() {
        setLayout(new BorderLayout(0, 20));

        JPanel patientListPanel = new JPanel();
        add(patientListPanel, BorderLayout.CENTER);
        patientListPanel.setLayout(new BorderLayout(0, 0));
        table = new JTable();
        table.setEnabled(false);
        table.setBorder(new EmptyBorder(8, 0, 8, 0));
        table.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
                        "Patient Name", "Description", "Status", "Add Drug", "Remove Patient"
                }
        ));

        JScrollPane scrollPane = new JScrollPane( table );
        scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        patientListPanel.add(scrollPane);

        JPanel interactionPanel = new JPanel();
        add(interactionPanel, BorderLayout.NORTH);
        interactionPanel.setLayout(new GridLayout(1, 0, 0, 0));

        JPanel searchPanel = new JPanel();
        searchPanel.setBorder(new EmptyBorder(0, 5, 0, 0));
        interactionPanel.add(searchPanel);
        searchPanel.setLayout(new BorderLayout(0, 0));

        txtSearchPatientBy = new JTextField();
        txtSearchPatientBy.setText("Search Patient By Name");
        searchPanel.add(txtSearchPatientBy, BorderLayout.WEST);
        txtSearchPatientBy.setColumns(20);

        Component verticalStrut = Box.createVerticalStrut(20);
        searchPanel.add(verticalStrut, BorderLayout.NORTH);

        Component verticalStrut_3 = Box.createVerticalStrut(8);
        searchPanel.add(verticalStrut_3, BorderLayout.SOUTH);

        JPanel rightPanelInteraction = new JPanel();
        interactionPanel.add(rightPanelInteraction);
        rightPanelInteraction.setLayout(new BorderLayout(0, 0));

        Component verticalStrut_1 = Box.createVerticalStrut(20);
        rightPanelInteraction.add(verticalStrut_1, BorderLayout.NORTH);

        Component verticalStrut_2 = Box.createVerticalStrut(8);
        rightPanelInteraction.add(verticalStrut_2, BorderLayout.SOUTH);

        sortArray = new String[]{ "By Name","By Status"};

        JPanel sortPanel = new JPanel();
        FlowLayout fl_sortPanel = (FlowLayout) sortPanel.getLayout();
        fl_sortPanel.setHgap(10);
        fl_sortPanel.setAlignment(FlowLayout.LEFT);
        rightPanelInteraction.add(sortPanel, BorderLayout.WEST);

        JLabel sortLabel = new JLabel("Sort");
        sortPanel.add(sortLabel);
        JComboBox sortComboBox = new JComboBox( sortArray );
        sortPanel.add(sortComboBox);

        JPanel addPatientPanel = new JPanel();
        FlowLayout fl_addPatientPanel = (FlowLayout) addPatientPanel.getLayout();
        fl_addPatientPanel.setAlignment(FlowLayout.RIGHT);
        rightPanelInteraction.add(addPatientPanel, BorderLayout.EAST);

        JButton addDrugButton = new JButton("Add Drug");
        addPatientPanel.add(addDrugButton);

        JButton patientAddButton = new JButton("Add Patient");
        addPatientPanel.add(patientAddButton);

        JButton removeButton = new JButton("Remove Patient");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        addPatientPanel.add(removeButton);

    }

}
