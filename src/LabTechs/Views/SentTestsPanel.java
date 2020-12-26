package LabTechs.Views;

import LabTechs.Model.LabTechnician;
import LabTechs.Model.Test;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import java.util.ArrayList;


public class SentTestsPanel extends JPanel{

    JTable sentTestsTable;
    private TableRowSorter<MyTableModel> rowSorter;
    private LabTechnician labTechnician;

    public SentTestsPanel( LabTechnician labTechnician ){

        this.labTechnician = labTechnician;

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        sentTestsTable = new JTable();
        sentTestsTable.setBorder(new EmptyBorder(8, 0, 8, 0));

        MyTableModel myTableModel = new MyTableModel();

        rowSorter = new TableRowSorter<>(myTableModel);
        sentTestsTable.setModel(myTableModel);
        sentTestsTable.setRowSorter(rowSorter);

        sentTestsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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
                    return data.getSent_date() + "!!!" + data.getSent_time();
                case 5:
                    return " Download Button ";
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
