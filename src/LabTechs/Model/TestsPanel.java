import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import java.awt.CardLayout;
import javax.swing.JScrollBar;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;

public class TestsPanel extends JPanel {
    private JTable waitingTestsTable;
    private JTable sentTextTable;
    private JTable sentTestsTable;

    /**
     * Create the panel.
     */
    public TestsPanel() {
        setLayout(new BorderLayout(0, 0));

        JPanel switchPanel = new JPanel();
        add(switchPanel, BorderLayout.NORTH);

        JButton sentTestSwitchButton = new JButton("Sent Tests");
        switchPanel.add(sentTestSwitchButton);

        JButton waitingtestsSwitchButton = new JButton("Waiting Tests");
        switchPanel.add(waitingtestsSwitchButton);

        JLayeredPane testsLayeredPane = new JLayeredPane();
        add(testsLayeredPane, BorderLayout.CENTER);
        testsLayeredPane.setLayout(new CardLayout(0, 0));

        JPanel waitingTestsPanel = new JPanel();
        testsLayeredPane.add(waitingTestsPanel, "name_54665235694300");
        waitingTestsPanel.setLayout(new BoxLayout(waitingTestsPanel, BoxLayout.X_AXIS));

        JTable waitingTestsTable = new JTable();
        waitingTestsTable.setModel( new DefaultTableModel(
                new Object[][] {
                        {null, null, null},
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
        sentTestsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        sentTestsTable = new JTable();
        sentTestsTable.setModel( new DefaultTableModel(
                new Object[][] {
                        {null, null, null},
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


    }

}
