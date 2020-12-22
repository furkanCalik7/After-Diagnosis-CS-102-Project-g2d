package Patient.Views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import javax.swing.JButton;

public class MyDoctorsPanel extends JPanel {
    private JTextField searchTextField;
    private JTable table;
    private JTextField codeField;

    /**
     * Create the panel.
     */
    public MyDoctorsPanel() {
        setBorder(new EmptyBorder(0, 100, 0, 100));
        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(30, 0, 0, 0));
        add(panel, BorderLayout.NORTH);
        panel.setLayout(new GridLayout(2, 0, 0, 0));

        JLabel lblNewLabel = new JLabel("Search");
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel.add(panel_1);
        panel_1.setLayout(new GridLayout(0, 3, 0, 0));

        searchTextField = new JTextField();
        panel_1.add(searchTextField);
        searchTextField.setColumns(10);

        table = new JTable();
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
                        "Doctor name", "Reappointment", "Doctor's Field"
                }
        ));

        JScrollPane scrollPane = new JScrollPane( table );
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        tablePanel.add(scrollPane);

        add(tablePanel, BorderLayout.CENTER);

        JPanel panel_3 = new JPanel();
        tablePanel.add(panel_3);
        panel_3.setLayout(new GridLayout(3, 0, 0, 0));

        JPanel panel_4 = new JPanel();
        panel_3.add(panel_4);

        JLabel lblNewLabel_1 = new JLabel("Do you need to add a doctor?");
        panel_4.add(lblNewLabel_1);

        JPanel panel_5 = new JPanel();
        panel_3.add(panel_5);
        panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel lblNewLabel_2 = new JLabel("Enter your code below");
        panel_5.add(lblNewLabel_2);

        JPanel codePanel = new JPanel();
        panel_3.add(codePanel);
        codePanel.setLayout(new GridLayout(0, 2, 0, 0));

        codeField = new JTextField();
        codeField.setColumns(10);
        codePanel.add(codeField);

        JButton codeButton = new JButton("DONE");
        codePanel.add(codeButton);

    }

}

