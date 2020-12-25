package LabTechs.Model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestsPanel extends JPanel {
    private JTable waitingTestsTable;
    private JTable sentTestsTable;

    /**
     * Create the panel.
     */
    JLayeredPane testsLayeredPane;

    public void switchPanels( JPanel panel ) {
        testsLayeredPane.removeAll();
        testsLayeredPane.add(panel);
        testsLayeredPane.repaint();
        testsLayeredPane.revalidate();
    }

    public TestsPanel() {
        setLayout(new BorderLayout(0, 0));

        JPanel switchPanel = new JPanel();
        add(switchPanel, BorderLayout.NORTH);


        JButton sentTestSwitchButton = new JButton("Sent Tests");
        switchPanel.add(sentTestSwitchButton);

        JButton waitingtestsSwitchButton = new JButton("Waiting Tests");
        switchPanel.add(waitingtestsSwitchButton);

        testsLayeredPane = new JLayeredPane();
        add(testsLayeredPane, BorderLayout.CENTER);
        testsLayeredPane.setLayout(new CardLayout(0, 0));

        JPanel waitingTestsPanel = new JPanel();
        testsLayeredPane.add(waitingTestsPanel, "name_54665235694300");
        waitingTestsPanel.setLayout(new BoxLayout(waitingTestsPanel, BoxLayout.X_AXIS));

        JTable waitingTestsTable = new JTable();
        waitingTestsTable.setModel( new DefaultTableModel(
                new Object[][] {
                        {"Hemoglobin", "Jacob", "John"},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                },
                new String[] {
                        "Test Name", "Patient's Name", "Doctor's Name"
                }
        ) );

        JScrollPane scrollPane_1 = new JScrollPane( waitingTestsTable );
        waitingTestsPanel.add(scrollPane_1);

        JPanel sentTestsPanel = new JPanel();
        testsLayeredPane.setLayer(sentTestsPanel, 1);
        testsLayeredPane.add(sentTestsPanel, "name_54665244771500");
        sentTestsPanel.setLayout(new BoxLayout(sentTestsPanel, BoxLayout.X_AXIS));//new FlowLayout(FlowLayout.CENTER, 5, 5));

        sentTestsTable = new JTable();
        sentTestsTable.setModel( new DefaultTableModel(
                new Object[][] {
                        {"MVC", "Hannah", "Morgana"},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                },
                new String[] {
                        "Test Name", "Patient's Name", "Doctor's Name"
                }
        ));

        JScrollPane scrollPane = new JScrollPane( sentTestsTable );
        sentTestsPanel.add(scrollPane);

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

    }

}
