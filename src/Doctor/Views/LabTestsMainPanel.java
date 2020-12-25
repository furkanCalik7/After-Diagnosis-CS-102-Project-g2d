package Doctor.Views;

import Doctor.Controller.FileChooserForDownloadController;
import Doctor.Model.Doctor;
import LabTechs.Model.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

public class LabTestsMainPanel extends JPanel {
    private JTextField patientNameTextField;
    private JTextField txtTestName;
    private JLayeredPane layeredPane;
    private JTable table;
    private JPanel seeAvailableTestsPanel;
    private Doctor doctor;
    MyTableModel myTableModel;
    RowSorter<MyTableModel> rowSorter;


    public class LabTestsMainPanel1 extends JPanel {
        private JTextField searchTextField;
        private JTable table;

        /**
         * Create the panel.
         */
        public LabTestsMainPanel1() {
            setLayout(new BorderLayout(0, 0));

            JPanel northMainPanel = new JPanel();
            add(northMainPanel, BorderLayout.NORTH);
            northMainPanel.setLayout(new GridLayout(0, 2, 0, 0));

            JPanel searchPanel = new JPanel();
            FlowLayout fl_searchPanel = (FlowLayout) searchPanel.getLayout();
            fl_searchPanel.setAlignment(FlowLayout.LEFT);
            northMainPanel.add(searchPanel);

            searchTextField = new JTextField();
            searchTextField.setText("Search");
            searchPanel.add(searchTextField);
            searchTextField.setColumns(10);

            JPanel removeAllPanel = new JPanel();
            FlowLayout fl_removeAllPanel = (FlowLayout) removeAllPanel.getLayout();
            fl_removeAllPanel.setAlignment(FlowLayout.RIGHT);
            northMainPanel.add(removeAllPanel);

            JButton removeAllButton = new JButton("Remove all");
            removeAllPanel.add(removeAllButton);

            JPanel tablePanel = new JPanel();
            add(tablePanel, BorderLayout.CENTER);
            tablePanel.setLayout(new BorderLayout(0, 0));

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
            tablePanel.add(scrollPane);
        }

    }


//    @Override
//    public void update() {
//        addRow();
//    }


    private class MyTableModel extends AbstractTableModel {
        private String[] columnNames = new String[]{
                "Doctor name","Patient Name", "Test Name", "Send Time", "Sent time", "Download"};

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
                    return test.getSender_username();
                case 1:
                    return test.getPatient_username();
                case 2:
                    return test.getTest_name();
                case 3:
                    return test.getSent_date();
                case 4:
                    return test.getSent_time();
                case 5:
                    return "Download";
            }
            return "null";
        }

        public boolean isCellEditable(int row, int col) {
            return col >= 5;
        }

        public void newRowsAdded(TableModelEvent event) {
            fireTableChanged(event);
        }

    }

//    public void addRow() {
//        int rowIndex = patientSlot.getPatientInfo().getDrugs().size() - 1;
//        dataModel.newRowsAdded(new TableModelEvent(
//                dataModel, rowIndex, rowIndex, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT)
//        );
//    }

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
                new FileChooserForDownloadController(LabTestsMainPanel.this,test,doctor);
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
