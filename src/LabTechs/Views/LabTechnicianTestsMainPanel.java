package LabTechs.Views;

import Doctor.Model.PatientSlot;
import Doctor.Views.MyPatientsMainPanel;
import LabTechs.IColors;
import LabTechs.Model.LabTechnician;
import LabTechs.Model.Test;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LabTechnicianTestsMainPanel extends JPanel implements IColors {
    private JTable waitingTestsTable;
    private JTable sentTestsTable;
    private WaitingTestsPanel waitingTestsPanel;
    private SentTestsPanel sentTestsPanel;
    private TableRowSorter<MyTableModel> rowSorter;
    private LabTechnician labTechnician;

    /**
     * Create the panel.
     */
    JLayeredPane testsLayeredPane;

    JButton waitingtestsSwitchButton;
    JButton sentTestSwitchButton;

    public void switchPanels( JPanel panel ) {
        testsLayeredPane.removeAll();
        testsLayeredPane.add(panel);
        testsLayeredPane.repaint();
        testsLayeredPane.revalidate();
    }

    public void switchToWaitingTests() {

        sentTestSwitchButton.setBackground(new Color(240, 240, 240));
        waitingtestsSwitchButton.setBackground(new Color(38, 69, 191));

        testsLayeredPane.removeAll();
        testsLayeredPane.add(waitingTestsPanel);
        testsLayeredPane.repaint();
        testsLayeredPane.revalidate();
    }

    public LabTechnicianTestsMainPanel( LabTechnician labTechnician ) {

        this.labTechnician = labTechnician;

        setLayout(new BorderLayout(0, 0));

        JPanel switchPanel = new JPanel();
        add(switchPanel, BorderLayout.NORTH);

        sentTestSwitchButton = new JButton("Sent Tests");
        sentTestSwitchButton.setBackground(new Color(38, 69, 191));
        switchPanel.add(sentTestSwitchButton);

        waitingtestsSwitchButton = new JButton("Waiting Tests");
        waitingtestsSwitchButton.setBackground(new Color(240, 240, 240));
        switchPanel.add(waitingtestsSwitchButton);

        testsLayeredPane = new JLayeredPane();
        add(testsLayeredPane, BorderLayout.CENTER);
        testsLayeredPane.setLayout(new CardLayout(0, 0));

        waitingTestsPanel = new WaitingTestsPanel( labTechnician );
        testsLayeredPane.add(waitingTestsPanel, "name_54665235694300");

        /*
        waitingTestsPanel.setLayout(new BoxLayout(waitingTestsPanel, BoxLayout.X_AXIS));

        waitingTestsTable = new JTable();
        waitingTestsTable.setModel( new DefaultTableModel(
                new Object[][] {
                        {"Hemoglobin", "Jacob", "John"},
                        {"liver function test", "Hikmet", "Giovanni"},
                        {"liver function test", "Kim", "Jane"},
                        {null, null, null},
                        {null, null, null},
                },
                new String[] {
                        "Test Name", "Patient's Name", "Doctor's Name"
                }
        ) );
        JScrollPane waitingTestsScrollPane = new JScrollPane( waitingTestsTable );
        waitingTestsPanel.add( waitingTestsScrollPane );

         */

        sentTestsPanel = new SentTestsPanel( labTechnician );
        testsLayeredPane.setLayer(sentTestsPanel, 1);
        testsLayeredPane.add(sentTestsPanel, "name_54665244771500");

        /*
        sentTestsPanel.setLayout(new BoxLayout(sentTestsPanel, BoxLayout.X_AXIS));//new FlowLayout(FlowLayout.CENTER, 5, 5));

        sentTestsTable = new JTable();
        sentTestsTable.setBorder(new EmptyBorder(8, 0, 8, 0));

        MyTableModel myTableModel = new MyTableModel();

        rowSorter = new TableRowSorter<>(myTableModel);
        sentTestsTable.setModel(myTableModel);
        sentTestsTable.setRowSorter(rowSorter);

        sentTestsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane sentTestsScrollPane = new JScrollPane( sentTestsTable );
        sentTestsPanel.add( sentTestsScrollPane );

         */

        //Button Action Listeners.
        sentTestSwitchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels( sentTestsPanel );
                waitingtestsSwitchButton.setBackground(new Color(240, 240, 240));
                sentTestSwitchButton.setBackground(new Color(38, 69, 191));
            }
        });

        waitingtestsSwitchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels( waitingTestsPanel );
                sentTestSwitchButton.setBackground(new Color(240, 240, 240));
                waitingtestsSwitchButton.setBackground(new Color(38, 69, 191));
            }
        });

        switchPanels( sentTestsPanel );
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
