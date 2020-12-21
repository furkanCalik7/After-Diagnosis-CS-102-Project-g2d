package doctorViews;

import Doctor.Model.Doctor;
import Doctor.Model.PatientSlot;

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
        setLayout(new BorderLayout(0, 20));

        JPanel patientListPanel = new JPanel();
        add(patientListPanel, BorderLayout.CENTER);
        patientListPanel.setLayout(new BorderLayout(0, 0));
        table = new JTable();
        table.setEnabled(false);
        table.setBorder(new EmptyBorder(8, 0, 8, 0));
        //table.setFont(new Font("Tahoma", Font.PLAIN, 20));


        ArrayList<PatientSlot> patientSlots = doctor.getPatientSlots();
        String fullName;
        String complaint;
        int status;
  //      DefaultTableModel dtm = new DefaultTableModel();
        rowSorter = new TableRowSorter<>(new MyTableModel());
        MyTableModel myTableModel = new MyTableModel();
        table.setModel(myTableModel);
        table.setRowSorter(rowSorter);



//        dtm.setColumnIdentifiers(headers);
//        for(int i  = 0; i <patientSlots.size(); i++){
//            fullName = patientSlots.get(i).getPatientInfo().getName() + " " + patientSlots.get(i).getPatientInfo().getSurname();
//            complaint = patientSlots.get(i).getPatientInfo().getComplaint();
//            status = patientSlots.get(i).getStatus();
//            System.out.println("reached.");
//            dtm.addRow(new Object[]{fullName,complaint,status,"data","data","data"});
//        }
//        table.setModel(dtm);
    //  table.setAutoCreateRowSorter(true);


//        table.setModel(new DefaultTableModel(
//                new Object[][] {
//                        {null, null, null, null, null},
//                        {null, null, null, null, null},
//                        {null, "Furkan", null, null, null},
//                        {null, null, null, null, null},
//                        {null, null, null, null, null},
//                        {null, null, null, null, null},
//                },
//                new String[] {
//                        "Patient Name", "Description", "Status", "Add Drug", "Remove Patient"
//                }
//        ));

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

    class MyTableModel extends AbstractTableModel {
        private String[] columnNames = new String[] {
                "Patient Name", "Description", "Status", "Add Drug", "Remove Patient"};

        private Object[][] data = {
                {"Kathy", "Smith",
                        "Snowboarding", new Integer(5), new Boolean(false)},
                {"John", "Doe",
                        "Rowing", new Integer(3), new Boolean(true)},
                {"Sue", "Black",
                        "Knitting", new Integer(2), new Boolean(false)},
                {"Jane", "White",
                        "Speed reading", new Integer(20), new Boolean(true)},
                {"Joe", "Brown",
                        "Pool", new Integer(10), new Boolean(false)}
        };

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        /*
         * JTable uses this method to determine the default renderer/
         * editor for each cell.  If we didn't implement this method,
         * then the last column would contain text ("true"/"false"),
         * rather than a check box.
         */
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        /*
         * Don't need to implement this method unless your table's
         * editable.
         */

        /*
         * Don't need to implement this method unless your table's
         * data can change.
         */
        public void setValueAt(Object value, int row, int col) {
            data[row][col] = value;
            fireTableCellUpdated(row, col);

        }
    }
    private void newFilter() {
        RowFilter<MyTableModel, Object> rf = null;
        //If current expression doesn't parse, don't update.
        try {
            rf = RowFilter.regexFilter(txtSearchPatientBy.getText(), 0);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        rowSorter.setRowFilter(rf);
    }


}
