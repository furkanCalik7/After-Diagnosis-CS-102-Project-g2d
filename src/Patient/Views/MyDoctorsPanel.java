package Patient.Views;

import Doctor.Model.DoctorInfoCard;
import Doctor.Model.Drug;
import Patient.Controllers.AddDoctorButtonControls;
import Patient.Model.Patient;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.FlowLayout;
import java.util.ArrayList;

public class MyDoctorsPanel extends JPanel {
    private JTextField searchTextField;
    private JTable table;
    public JTextField codeField;
    public Patient patient;
    private TableRowSorter<MyTableModel> rowSorter;


    /**
     * Create the panel.
     */
    public MyDoctorsPanel(Patient patient) {
        this.patient = patient;
        setBorder(new EmptyBorder(0, 100, 0, 100));
        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(30, 0, 0, 0));
        add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(2, 0, 0, 0));

        JLabel lblNewLabel = new JLabel("Search");
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel.add(panel_1);
        panel_1.setLayout(new GridLayout(0, 3, 0, 0));

        searchTextField = new JTextField();
        panel_1.add(searchTextField);
        searchTextField.setColumns(10);

        searchTextField.getDocument().addDocumentListener(
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

        table = new JTable();
        table.setEnabled(false);
        MyTableModel myTableModel = new MyTableModel();
        table.setModel(myTableModel);
        rowSorter = new TableRowSorter<>(myTableModel);
        table.setRowSorter(rowSorter);



        JScrollPane scrollPane = new JScrollPane( table );
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        tablePanel.add(scrollPane);

        add(tablePanel, BorderLayout.CENTER);

        JPanel panel_3 = new JPanel();
        tablePanel.add(panel_3);
        panel_3.setLayout(new GridLayout(3, 0, 0, 0));

        JPanel panel_4 = new JPanel();
        panel_3.add(panel_4);

        JLabel lblNewLabel_1 = new JLabel("Do you need to add a doctor?");
        panel_4.add(lblNewLabel_1);

        JPanel panel_5 = new JPanel();
        panel_3.add(panel_5);
        panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel lblNewLabel_2 = new JLabel("Enter your code below");
        panel_5.add(lblNewLabel_2);

        JPanel codePanel = new JPanel();
        panel_3.add(codePanel);
        codePanel.setLayout(new GridLayout(0, 2, 0, 0));

        codeField = new JTextField();
        codeField.setColumns(10);
        codePanel.add(codeField);

        JButton codeButton = new AddDoctorButtonControls(patient, this);
        codePanel.add(codeButton);

    }

    class MyTableModel extends AbstractTableModel {
        protected String[] columnNames = new String[]{
                "Doctor name", "Doctor Speciality", "Doctor Email", "Reappointment"};

        protected ArrayList<DoctorInfoCard> doctors;

        public MyTableModel() {
            doctors = patient.getDoctors();
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return doctors.size();
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }


        public Object getValueAt(int row, int col) {
            DoctorInfoCard data  = doctors.get(row);
            String times = "";

            switch (col) {
                case 0:
                    return data.getName() + " " + data.getSurname();
                case 1:
                    return data.getDoctorSpeciality();
                case 2:
                    return data.getEmail();
            }
            return "null";
        }

        public boolean isCellEditable(int row, int col) {
            return false;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

            fireTableCellUpdated(rowIndex, columnIndex);
        }

        public void newRowsAdded(TableModelEvent event) {
            fireTableChanged(event);
        }

    }

    private void newFilter() {
        RowFilter<MyTableModel, Object> rf = null;
        try {
            rf = RowFilter.regexFilter(searchTextField.getText(), 0);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        rowSorter.setRowFilter(rf);
    }



}

