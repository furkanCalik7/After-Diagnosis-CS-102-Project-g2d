package LabTechs.Views;

import Admin.model.IViewer;
import LabTechs.Controller.FileChooserForDownloadController;
import LabTechs.Model.LabTechnician;
import LabTechs.Model.Test;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class SentTestsPanel extends JPanel implements IViewer {

    JTable sentTestsTable;
    private TableRowSorter<MyTableModel> rowSorter;
    private LabTechnician labTechnician;

    @Override
    public void update() {

    }

    public SentTestsPanel( LabTechnician labTechnician ){

        this.labTechnician = labTechnician;

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        sentTestsTable = new JTable();
        sentTestsTable.setBorder(new EmptyBorder(8, 0, 8, 0));
        sentTestsTable.setRowHeight( 20 );

        MyTableModel myTableModel = new MyTableModel();

        rowSorter = new TableRowSorter<>(myTableModel);
        sentTestsTable.setModel(myTableModel);
        sentTestsTable.setRowSorter(rowSorter);

        sentTestsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        sentTestsTable.getColumn("Download").setCellRenderer(new ButtonRenderer());
        sentTestsTable.getColumn("Download").setCellEditor(new AddDownloadButtonEditor(new JTextField()));

        JScrollPane sentTestsScrollPane = new JScrollPane( sentTestsTable );
        add( sentTestsScrollPane );
    }

    private class MyTableModel extends AbstractTableModel {
        private String[] columnNames = new String[]{
                "Test ID", "Test Type", "Patient", "Doctor", "Date", "Download"};

        private ArrayList<Test> tests;

        public MyTableModel() {
            tests = labTechnician.getTests();
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

        @Override
        public Object getValueAt(int row, int col) {
            Test data = tests.get(row);

            switch (col) {
                case 0:
                    return row;
                case 1:
                    return data.getTest_name();
                case 2:
                    return data.getPatient_username();
                case 3:
                    return data.getSender_username();
                case 4:
                    return data.getSent_time() + "  " + data.getSent_date();
                case 5:
                    return "Download";
            }
            return "null";
        }


        public boolean isCellEditable(int row, int col) {
            if (col < 5) {
                return false;
            }
            return true;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

            fireTableCellUpdated(rowIndex, columnIndex);
        }
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

    class AddDownloadButtonEditor extends DefaultCellEditor {
        protected JButton button;
        int i = 0;
        private String label;

        private boolean isPushed;

        public AddDownloadButtonEditor(JTextField textField) {
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
                Test test = labTechnician.getTests().get(sentTestsTable.convertRowIndexToModel(i));
                new FileChooserForDownloadController(SentTestsPanel.this, test, labTechnician);
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
