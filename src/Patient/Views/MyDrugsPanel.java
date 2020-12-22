package Patient.Views;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyDrugsPanel extends JPanel {
    private JTextField textField;
    private JTable currentTable;
    private JTable expiredTable;
    private JPanel currentTablePanel;
    private JPanel expiredTablePanel;
    private JLayeredPane layeredPane;
    private JTextField textField_1;



    /**
     * Create the panel.
     */
    public void switchPanels( JPanel panel ) {
        layeredPane.removeAll();
        layeredPane.add(panel);
        layeredPane.repaint();
        layeredPane.revalidate();
    }

    public MyDrugsPanel() {

        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        add(panel, BorderLayout.NORTH);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton currentMedicationsButton = new JButton("Current Medications");

        panel.add(currentMedicationsButton);

        JButton expiredMedicationsButton = new JButton("Your Expired Medications");

        panel.add(expiredMedicationsButton);

        layeredPane = new JLayeredPane();
        add(layeredPane, BorderLayout.CENTER);
        layeredPane.setLayout(new CardLayout(0, 0));

        JPanel currentMedicationsPanel = new JPanel();
        layeredPane.add(currentMedicationsPanel, "name_1117144943200400");
        currentMedicationsPanel.setLayout(new BorderLayout(0, 0));

        JPanel currentHeadPanel = new JPanel();
        currentMedicationsPanel.add(currentHeadPanel, BorderLayout.NORTH);
        currentHeadPanel.setLayout(new GridLayout(2, 0, 0, 0));

        JLabel lblSearchByName = new JLabel("Search By Name");
        currentHeadPanel.add(lblSearchByName);

        JPanel panel_2 = new JPanel();
        currentHeadPanel.add(panel_2);
        panel_2.setLayout(new GridLayout(0, 3, 0, 0));

        textField = new JTextField();
        panel_2.add(textField);
        textField.setColumns(10);

        JPanel currentCenterPanel = new JPanel();
        currentMedicationsPanel.add(currentCenterPanel, BorderLayout.CENTER);
        currentCenterPanel.setLayout(new BorderLayout(0, 0));

        currentTable = new JTable();
        currentTable.setEnabled(false);
        currentTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[] {
                        "Pill Name", "Until which date you take the pill", "How and when you should take it?"
                }
        ));

        JScrollPane scrollPane = new JScrollPane( currentTable );
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        currentTablePanel = new JPanel();
        currentTablePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        currentTablePanel.add(scrollPane);


        currentCenterPanel.add(currentTablePanel, BorderLayout.WEST);

        JPanel drugsPanel = new JPanel();
        currentCenterPanel.add(drugsPanel, BorderLayout.NORTH);




        JPanel expiredMedicationsPanel = new JPanel();
        layeredPane.add(expiredMedicationsPanel, "name_1117149041432400");
        expiredMedicationsPanel.setLayout(new BorderLayout(0, 0));

        JPanel expiredHeadPanel = new JPanel();
        expiredMedicationsPanel.add(expiredHeadPanel, BorderLayout.NORTH);
        expiredHeadPanel.setLayout(new GridLayout(2, 0, 0, 0));

        JLabel lblNewLabel_1 = new JLabel("Search By Name");
        expiredHeadPanel.add(lblNewLabel_1);

        JPanel panel_5 = new JPanel();
        expiredHeadPanel.add(panel_5);
        panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        textField_1 = new JTextField();
        panel_5.add(textField_1);
        textField_1.setColumns(10);

        expiredTable = new JTable();
        expiredTable.setEnabled(false);
        expiredTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                },
                new String[] {
                        "Pill Name", "When did you use this pill", "Who assigned this pill?"
                }
        ));

        JScrollPane scrollPane2 = new JScrollPane( expiredTable );
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        expiredTablePanel = new JPanel();
        expiredTablePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        expiredTablePanel.add(scrollPane2);
        expiredMedicationsPanel.add(expiredTablePanel, BorderLayout.WEST);

        currentMedicationsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels( currentMedicationsPanel );
                System.out.println("annen");
            }
        });
        expiredMedicationsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels( expiredMedicationsPanel );
            }
        });
    }

}

