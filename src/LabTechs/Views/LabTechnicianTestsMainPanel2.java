package LabTechs.Views;

import Doctor.Model.Drug;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LabTechnicianTestsMainPanel2 extends JPanel {
    private JTable waitingTestsTable;
    private JTable sentTestsTable;
    private JPanel waitingTestsPanel;

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

    public LabTechnicianTestsMainPanel2() {
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


        waitingTestsPanel = new JPanel();
        testsLayeredPane.add(waitingTestsPanel, "name_54665235694300");
        waitingTestsPanel.setLayout(new BoxLayout(waitingTestsPanel, BoxLayout.X_AXIS));

        waitingTestsTable = new JTable();
        waitingTestsTable.setModel( new DefaultTableModel(
                new Object[][] {
                        {"0", "Hemoglobin", "Jacob", "John"},
                        {"1", "liver function test", "Hikmet", "Giovanni"},
                        {"2", "liver function test", "Kim", "Jane"},
                        {null, null, null},
                        {null, null, null},
                },
                new String[] {
                        "Test ID", "Test Name", "Patient's Name", "Doctor's Name"
                }
        ) );
        JScrollPane waitingTestsScrollPane = new JScrollPane( waitingTestsTable );
        waitingTestsPanel.add( waitingTestsScrollPane );

        /*
        waitingTestsTable = new JTable();
        MyTableModel myTableModel = new MyTableModel();
        rowSorter = new TableRowSorter<>(myTableModel);
        waitingTestsTable.setModel(myTableModel);
        waitingTestsTable.setRowSorter(rowSorter);
        waitingTestsTable.setEnabled(false);

        JScrollPane waitingTestsScrollPane = new JScrollPane( waitingTestsTable) ;
        waitingTestsScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        waitingTestsPanel.add( waitingTestsScrollPane );

         */
         
        JPanel sentTestsPanel = new JPanel();
        testsLayeredPane.setLayer(sentTestsPanel, 1);
        testsLayeredPane.add(sentTestsPanel, "name_54665244771500");
        sentTestsPanel.setLayout(new BoxLayout(sentTestsPanel, BoxLayout.X_AXIS));//new FlowLayout(FlowLayout.CENTER, 5, 5));

        sentTestsTable = new JTable();
        sentTestsTable.setModel( new DefaultTableModel(
                new Object[][] {
                        {"MVC", "Hannah", "Morgana"},
                        {"Hormone", "Alex", "Robert"},
                        {"Robotic", "XAE-12", "Hakan"},
                        {null, null, null},
                        {null, null, null},
                },
                new String[] {
                        "Test Name", "Patient's Name", "Doctor's Name"
                }
        ));

        JScrollPane sentTestsScrollPane = new JScrollPane( sentTestsTable );
        sentTestsPanel.add( sentTestsScrollPane );

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
}
