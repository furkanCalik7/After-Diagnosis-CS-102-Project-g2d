package Doctor.Views;

import Admin.model.IViewer;
import Doctor.Controller.FileChooserForDownloadController;
import Doctor.Controller.RemoveTestController;
import Doctor.Model.Doctor;
import Doctor.Model.PatientSlot;
import LabTechs.Model.Test;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;


public class LabTestsMainPanel extends JPanel implements IViewer {
    private JTable table;
    private MyTableModel myTableModel;
    private TableRowSorter<MyTableModel> rowSorter;
    protected Doctor doctor;
    private HintTextField searchByName;



    public LabTestsMainPanel(Doctor doctor) {
        this.doctor = doctor;
        setLayout(new BorderLayout(0, 0));

        JPanel northMainPanel = new JPanel();
        add(northMainPanel, BorderLayout.NORTH);
        northMainPanel.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel searchPanel = new JPanel();
        FlowLayout fl_searchPanel = (FlowLayout) searchPanel.getLayout();
        fl_searchPanel.setAlignment(FlowLayout.LEFT);
        northMainPanel.add(searchPanel);


        searchByName = new HintTextField("Search by patient name");
        searchPanel.add(searchByName);
        searchByName.setColumns(20);

        searchByName.getDocument().addDocumentListener(
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

        JPanel removeAllPanel = new JPanel();
        FlowLayout fl_removeAllPanel = (FlowLayout) removeAllPanel.getLayout();
        fl_removeAllPanel.setAlignment(FlowLayout.RIGHT);
        northMainPanel.add(removeAllPanel);

        JButton removeAllButton = new JButton("Remove all");
        removeAllPanel.add(removeAllButton);

        JPanel tablePanel = new JPanel();
        add(tablePanel, BorderLayout.CENTER);
        tablePanel.setLayout(new BorderLayout(0, 0));

        myTableModel = new MyTableModel();
        table = new JTable();
        table.setModel(myTableModel);
        rowSorter = new TableRowSorter<>(myTableModel);
        table.setRowSorter(rowSorter);


        table.getColumn("Download").setCellEditor(new DownloadButtonEditor(new JTextField()));
        table.getColumn("Download").setCellRenderer(new DownloadButtonRenderer());

        table.getColumn("Remove").setCellEditor(new RemoveButtonEditor(new JTextField()));
        table.getColumn("Remove").setCellRenderer(new DownloadButtonRenderer());

        JScrollPane scrollPane = new JScrollPane(table);
        tablePanel.add(scrollPane);

        //Colors
//        centerInfoPanel.setBackground(new Color(101, 180, 206));
//        buttonsPanel.setBackground(new Color(101, 180, 206));
//        layeredPane.setBackground(new Color(101, 180, 206));
//        createRequestPanel.setBackground(new Color(101, 180, 206));
//        seeAvailableTestsPanel.setBackground(new Color(101, 180, 206));
//        scrollPane.setBackground(new Color(101, 180, 206));
//        panel.setBackground(new Color(101, 180, 206));
    }

    @Override
    public void update() {
        myTableModel.updateTable();
    }


    private class MyTableModel extends AbstractTableModel {
        private String[] columnNames = new String[]{
               "Patient Name", "Test Name", "Send Time", "Sent time", "Download","Remove"};

        private ArrayList<Test> tests;

        public MyTableModel() {
            tests = doctor.getTests();
        }


        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return tests.size();
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }


        public Object getValueAt(int row, int col) {
            Test test = tests.get(row);
            switch (col) {
                case 0:
                    for(PatientSlot patientSlot:doctor.getPatientSlots()){
                        if(test.getPatient_username().equals(patientSlot.getPatientInfo().getUsername())){
                            return patientSlot.getPatientInfo().getName() + " " + patientSlot.getPatientInfo().getSurname();
                        }
                    }
                case 1:
                    return test.getTest_name();
                case 2:
                    return test.getSent_date();
                case 3:
                    return test.getSent_time();
                case 4:
                    return "Download";
                case 5:
                    return "Remove";
            }
            return "null";
        }

        public boolean isCellEditable(int row, int col) {
            return col >=4 ;
        }

        public void newRowsAdded(TableModelEvent event) {
            fireTableChanged(event);
        }
        public void updateTable(){
            this.fireTableDataChanged();
        }

    }


    class DownloadButtonRenderer extends JButton implements TableCellRenderer {

        public DownloadButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    class DownloadButtonEditor extends DefaultCellEditor {
        protected JButton button;
        int i = 0;
        private String label;

        private boolean isPushed;

        public DownloadButtonEditor(JTextField textField) {
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
                Test test = doctor.getTests().get(table.convertRowIndexToModel(i));
                new FileChooserForDownloadController(LabTestsMainPanel.this, test, doctor);
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

    private void newFilter() {
        RowFilter<MyTableModel, Object> rf = null;
        try {
            if (!this.searchByName.getText().equals("Search by patient name")) {
                rf = RowFilter.regexFilter(searchByName.getText(), 0);
            }
        } catch (PatternSyntaxException e) {
            return;
        }
        rowSorter.setRowFilter(rf);
    }

    private class RemoveButtonEditor extends DefaultCellEditor {
        protected JButton button;
        int i = 0;
        private String label;

        private boolean isPushed;

        public RemoveButtonEditor(JTextField textField) {
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
                new RemoveTestController(table.convertRowIndexToModel(i),LabTestsMainPanel.this,doctor);
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
