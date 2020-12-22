package doctorViews;

import Doctor.Model.Doctor;
import Doctor.Model.PatientSlot;
import Patient.Model.PatientInfoCard;

import javax.swing.*;

import java.awt.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableRowSorter;

public class MyPatientsMainPanel extends JPanel {
    private JTable table;
    private JTextField txtSearchPatientBy;
    private String[] sortArray;
    private Doctor doctor;
    private TableRowSorter<MyTableModel> rowSorter;


    /**
     * Create the panel.
     */
    public MyPatientsMainPanel(Doctor doctor) {
        this.doctor = doctor;
        setLayout(new BorderLayout(0, 20));

        JPanel patientListPanel = new JPanel();
        add(patientListPanel, BorderLayout.CENTER);
        patientListPanel.setLayout(new BorderLayout(0, 0));
        table = new JTable();
        table.setEnabled(false);
        table.setBorder(new EmptyBorder(8, 0, 8, 0));
        //table.setFont(new Font("Tahoma", Font.PLAIN, 20));


        rowSorter = new TableRowSorter<>(new MyTableModel());
        MyTableModel myTableModel = new MyTableModel();
        table.setModel(myTableModel);
        table.setRowSorter(rowSorter);

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
        txtSearchPatientBy.getDocument().addDocumentListener(
                new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                        newFilter();
                    }
                    public void insertUpdate(DocumentEvent e) {
                        newFilter();
                    }
                    public void removeUpdate(DocumentEvent e) {
                        newFilter();
                    }
                });

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

//        JLabel sortLabel = new JLabel("Sort");
//        sortPanel.add(sortLabel);
//        JComboBox sortComboBox = new JComboBox( sortArray );
//        sortPanel.add(sortComboBox);

        JPanel addPatientPanel = new JPanel();
        FlowLayout fl_addPatientPanel = (FlowLayout) addPatientPanel.getLayout();
        fl_addPatientPanel.setAlignment(FlowLayout.RIGHT);
        rightPanelInteraction.add(addPatientPanel, BorderLayout.EAST);

        //ADD DRUG BUTTON
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

    class MyTableModel extends AbstractTableModel {
        private String[] columnNames = new String[] {
                "Age","Patient Name", "Email", "Description", "Status", "Start Date", "Drugs"};

        private ArrayList<PatientSlot> patients;

        public MyTableModel() {
            patients = doctor.getPatientSlots();
        }


        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return patients.size();
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }


        public Object getValueAt(int row, int col) {
            PatientSlot data = patients.get(row);

            switch (col){
                case 0:
                    return data.getPatientInfo().getAge();
                case 1:
                    return data.getPatientInfo().getName() + " " + data.getPatientInfo().getSurname();
                case 2:
                    return data.getPatientInfo().getEmail();
                case 3:
                    return data.getPatientInfo().getComplaint();
                case 4:
                    if(data.getStatus() == 1){
                        return "Current";
                    }
                    return "Expired";
                case 5:
                    return data.getStart_date();
                case 6:
                    return "null";
            }
            return "null";
        }

//        public Class getColumnClass(int c) {
//            return getValueAt(0, c).getClass();
//        }
//
//        public void setValueAt(Object value, int row, int col) {
//            data[row][col] = value;
//            fireTableCellUpdated(row, col);
//
//        }
    }
    private void newFilter() {
        RowFilter<MyTableModel, Object> rf = null;
        try {
            rf = RowFilter.regexFilter(txtSearchPatientBy.getText(), 0);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        rowSorter.setRowFilter(rf);
    }


}
