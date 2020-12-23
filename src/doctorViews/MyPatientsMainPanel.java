package doctorViews;

import Doctor.Model.Doctor;
import Doctor.Model.PatientSlot;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyPatientsMainPanel extends JPanel {
    private JTable table;
    private JTextField txtSearchPatientBy;
    private Doctor doctor;
    private TableRowSorter<MyTableModel> rowSorter;
    private MyPatientsLayeredPanelView layeredPane;


    /**
     * Create the panel.
     */
    public MyPatientsMainPanel(Doctor doctor, MyPatientsLayeredPanelView layeredPanel) {
        this.doctor = doctor;
        this.layeredPane = layeredPanel;
        setLayout(new BorderLayout(0, 20));

        JPanel patientListPanel = new JPanel();
        add(patientListPanel, BorderLayout.CENTER);
        patientListPanel.setLayout(new BorderLayout(0, 0));
        table = new JTable();
        table.setBorder(new EmptyBorder(8, 0, 8, 0));
        //table.setFont(new Font("Tahoma", Font.PLAIN, 20));

        MyTableModel myTableModel = new MyTableModel();
        rowSorter = new TableRowSorter<>(myTableModel);
        table.setModel(myTableModel);
        table.setRowSorter(rowSorter);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getColumn("Drugs").setCellRenderer(new ButtonRenderer());
        table.getColumn("Drugs").setCellEditor(new AddDrugButtonEditor(new JTextField()));


        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        patientListPanel.add(scrollPane);

        JPanel interactionPanel = new JPanel();
        add(interactionPanel, BorderLayout.NORTH);
        interactionPanel.setLayout(new GridLayout(1, 0, 0, 0));

        JPanel searchPanel = new JPanel();
        searchPanel.setBorder(new EmptyBorder(0, 5, 0, 0));
        interactionPanel.add(searchPanel);
        searchPanel.setLayout(new BorderLayout(0, 0));

        txtSearchPatientBy = new HintTextField("Search Patient By Name");
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


        JPanel sortPanel = new JPanel();
        FlowLayout fl_sortPanel = (FlowLayout) sortPanel.getLayout();
        fl_sortPanel.setHgap(10);
        fl_sortPanel.setAlignment(FlowLayout.LEFT);
        rightPanelInteraction.add(sortPanel, BorderLayout.WEST);

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
        private String[] columnNames = new String[]{
                "Age", "Patient Name", "Email", "Description", "Status", "Start Date", "Drugs"};

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

            switch (col) {
                case 0:
                    return data.getPatientInfo().getAge();
                case 1:
                    return data.getPatientInfo().getName() + " " + data.getPatientInfo().getSurname();
                case 2:
                    return data.getPatientInfo().getEmail();
                case 3:
                    return data.getPatientInfo().getComplaint();
                case 4:
                    if (data.getStatus() == 1) {
                        return "Current";
                    }
                    return "Expired";
                case 5:
                    return data.getStart_date();
                case 6:
                    return "Drugs";
            }
            return "null";
        }


        public boolean isCellEditable(int row, int col) {
            if(col < 6){
                return false;
            }
            return true;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

            fireTableCellUpdated(rowIndex, columnIndex);
        }
    }

    private void newFilter() {
        RowFilter<MyTableModel, Object> rf = null;
        try {
            rf = RowFilter.regexFilter(txtSearchPatientBy.getText(), 1);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        rowSorter.setRowFilter(rf);
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    class AddDrugButtonEditor extends DefaultCellEditor {
        protected JButton button;
        int i = 0;
        private String label;

        private boolean isPushed;

        public AddDrugButtonEditor(JTextField textField) {
            super(textField);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {

            label = (value == null) ? "" : value.toString();
            button.setText(label);
            i = row;
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                layeredPane.switchPanels(table.convertRowIndexToModel(i), 1);
                System.out.println(i);
            }
            isPushed = false;
            return new String(label);
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }

    }
}
