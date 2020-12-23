package AdminViews;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.FlowLayout;
import javax.swing.JComboBox;

public class HospitalWorkersInfoPanel extends JPanel {
    private JTextField searchField;
    private JTable table;

    /**
     * Create the panel.
     */
    public HospitalWorkersInfoPanel() {
        setBorder(new EmptyBorder(0, 0, 0, 0));
        setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel = new JLabel("Hosptal Workers Information");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblNewLabel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_1 = new JPanel();
        panel.add(panel_1, BorderLayout.NORTH);
        panel_1.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panel_3 = new JPanel();
        panel_1.add(panel_3);
        panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel lblNewLabel_3 = new JLabel("Search");
        panel_3.add(lblNewLabel_3);

        searchField = new JTextField();
        panel_3.add(searchField);
        searchField.setColumns(10);

        JPanel panel_4 = new JPanel();
        panel_1.add(panel_4);
        panel_4.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

        JLabel lblNewLabel_1 = new JLabel("Choose From");
        panel_4.add(lblNewLabel_1);

        String[] workers = new String[] { "All Workers","Doctors","Lab Technicians" };
        JComboBox workersBox = new JComboBox( workers );
        panel_4.add(workersBox);

        JLabel lblNewLabel_2 = new JLabel("Sort By");
        panel_4.add(lblNewLabel_2);

        String[] sortingInfo = new String[] { "Name","Worker Type","Speciality" };
        JComboBox sortComboBox = new JComboBox( sortingInfo );
        panel_4.add(sortComboBox);

        //Panel including the table

        JPanel panel_2 = new JPanel();
        panel.add(panel_2, BorderLayout.CENTER);
        panel_2.setLayout(new BorderLayout(0, 0));



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
                        "Name and Surname", "Worker Type", "Speciality" , "Mail Address"
                }
        ));

        JScrollPane scrollPane = new JScrollPane( table );
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        panel_2.add(scrollPane);



    }
}
