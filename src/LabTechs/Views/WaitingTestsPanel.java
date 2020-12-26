package LabTechs.Views;

import LabTechs.Controller.*;
import LabTechs.Model.LabTechnician;
import LabTechs.Model.Test;
import LabTechs.Model.TestRequest;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.sql.Date;

public class WaitingTestsPanel extends JPanel{

    JTable waitingTestsTable;
    private TableRowSorter<MyTableModel> rowSorter;
    private LabTechnician labTechnician;

    public WaitingTestsPanel( LabTechnician labTechnician ){

        this.labTechnician = labTechnician;

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        waitingTestsTable = new JTable();
        waitingTestsTable.setBorder(new EmptyBorder(8, 0, 8, 0));
        waitingTestsTable.setRowHeight( 20 );

        MyTableModel myTableModel = new MyTableModel();

        rowSorter = new TableRowSorter<>(myTableModel);
        waitingTestsTable.setModel(myTableModel);
        waitingTestsTable.setRowSorter(rowSorter);

        waitingTestsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        waitingTestsTable.getColumn("Upload").setCellRenderer(new ButtonRenderer());
        waitingTestsTable.getColumn("Upload").setCellEditor(new AddUploadButtonEditor(new JTextField()));

        JScrollPane sentTestsScrollPane = new JScrollPane( waitingTestsTable );
        add( sentTestsScrollPane );
    }

    private class MyTableModel extends AbstractTableModel {
        private String[] columnNames = new String[]{
                "Test ID", "Test Type", "Patient", "Doctor", "Date", "Upload"};

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
                    return "Upload";
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

    class AddUploadButtonEditor extends DefaultCellEditor {
        protected JButton button;
        int i = 0;
        private String label;

        private boolean isPushed;

        public AddUploadButtonEditor(JTextField textField) {
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
                //Todo Implement Download
                System.out.println( "The button at row: " + this.label );


                TestRequest testRequest = labTechnician.getTestRequests().get(waitingTestsTable.convertRowIndexToModel(i));

                System.out.println( "The Testrequest: |" + testRequest.getTest_name() + "|" );

                FileChooserForUploadController fileUploadController = new FileChooserForUploadController(WaitingTestsPanel.this);

                File testFile = fileUploadController.getFile();

                System.out.println( "The filepath: |" + testFile.getAbsolutePath() + "|" );

                Test test = Test.newTest( testRequest.getDoctor_username(), labTechnician.getUsername(), testRequest.getTest_name() ,
                        testRequest.getPatient() , testFile );

                 boolean isUploadSuccesfull = test.sendTest();

                 if( isUploadSuccesfull )
                     System.out.println( "UPLOADED THE FİLE" );
                 else
                     System.out.println( "COULD NOT UPLOADED THE FİLE" );
                //Uploads

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
