package LabTechs.Views;

import LabTechs.Model.LabTechnician;
import LabTechs.Model.Test;
import LabTechs.Model.TestRequest;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import java.util.ArrayList;


public class WaitingTestsPanel extends JPanel{

    JTable waitingTestsTable;
    private TableRowSorter<MyTableModel> rowSorter;
    private LabTechnician labTechnician;

    public WaitingTestsPanel( LabTechnician labTechnician ){

        this.labTechnician = labTechnician;

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        waitingTestsTable = new JTable();
        waitingTestsTable.setBorder(new EmptyBorder(8, 0, 8, 0));

        MyTableModel myTableModel = new MyTableModel();

        rowSorter = new TableRowSorter<>(myTableModel);
        waitingTestsTable.setModel(myTableModel);
        waitingTestsTable.setRowSorter(rowSorter);

        waitingTestsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane sentTestsScrollPane = new JScrollPane( waitingTestsTable );
        add( sentTestsScrollPane );
    }

    private class MyTableModel extends AbstractTableModel {
        private String[] columnNames = new String[]{
                "Test ID", "Test Type", "Patient", "Doctor", "Date", "Download"};

        private ArrayList<TestRequest> testRequests;

        public MyTableModel() {
            testRequests = labTechnician.getTestRequests();
        }


        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return testRequests.size();
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        @Override
        public Object getValueAt(int row, int col) {
            TestRequest data = testRequests.get(row);

            switch (col) {
                case 0:
                    return row;
                case 1:
                    return data.getTest_name();
                case 2:
                    return data.getPatient();
                case 3:
                    return data.getDoctor_username();
                case 4:
                    return "0.0.2000 00.00";//data.get() + "!!!" + data.getSent_time();
                case 5:
                    return " Upload Button ";
            }
            return "null";
        }


        public boolean isCellEditable(int row, int col) {
            if (col < 6) {
                return false;
            }
            return true;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

            fireTableCellUpdated(rowIndex, columnIndex);
        }
    }
}
