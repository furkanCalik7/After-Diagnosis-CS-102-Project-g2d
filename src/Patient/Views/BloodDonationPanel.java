package Patient.Views;

import javax.swing.*;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import java.awt.*;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class BloodDonationPanel extends JPanel {
    private JTable table;

    /**
     * Create the panel.
     */
    public BloodDonationPanel() {
        setBorder(new EmptyBorder(30, 0, 0, 0));
        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(101, 180, 206));
        add(panel, BorderLayout.NORTH);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel lblNewLabel = new JLabel("Bloods Needed");
        lblNewLabel.setFont(new Font("Century", Font.PLAIN, 15));
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(101, 180, 206));
        add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new BorderLayout(0, 0));

        table = new JTable();
        table.setFont(new Font("Century", Font.PLAIN, 15));
        table.setEnabled(false);
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
                        "Blood Type", "Date", "Emergency"
                }
        ));

        JScrollPane scrollPane = new JScrollPane( table );
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        JPanel tablePanel = new JPanel();
        tablePanel.add(scrollPane);
        panel_1.add(tablePanel, BorderLayout.WEST);

    }

}

