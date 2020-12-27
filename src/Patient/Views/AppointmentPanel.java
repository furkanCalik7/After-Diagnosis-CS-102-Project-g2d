package Patient.Views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class AppointmentPanel extends JPanel {

    JTable table;
    JLayeredPane layeredPane;
    JPanel takeAppointmentPanel;
    JPanel seeAppointmentPanel;

    public void switchPanels( JPanel panel ) {
        layeredPane.removeAll();
        layeredPane.add(panel);
        layeredPane.repaint();
        layeredPane.revalidate();
    }

    /**
     * Create the panel.
     */

    public AppointmentPanel() {
        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(101, 180, 206) );
        add(panel);
        panel.setLayout(new BorderLayout(0, 0));

        //Header Panel including buttons is initialized
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(101, 180, 206));
        panel.add(headerPanel, BorderLayout.NORTH);

        JButton takeAppointmentButton = new JButton("Take Appointment");
        takeAppointmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels(takeAppointmentPanel);
            }
        });
        headerPanel.add(takeAppointmentButton);

        JButton seeAppointmentButton = new JButton("See Your Appointments");
        seeAppointmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels(seeAppointmentPanel);
            }
        });
        headerPanel.add(seeAppointmentButton);

        layeredPane = new JLayeredPane();
        panel.add(layeredPane, BorderLayout.CENTER);
        layeredPane.setLayout(new CardLayout(0, 0));

        //Creating Table of Take Appointment Panel
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
                        "Doctor Name", "Reappointment Reason", "See Available Dates"
                }
        ));

        JScrollPane scrollPane = new JScrollPane( table );
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);



        //Take Appointment Panel

        takeAppointmentPanel = new JPanel();
        takeAppointmentPanel.setBackground(new Color(101, 180, 206));
        takeAppointmentPanel.setLayout(new BorderLayout(0, 0));

        JPanel appointmentNorthPanel = new JPanel();
        appointmentNorthPanel.setBackground(new Color(101, 180, 206));
        takeAppointmentPanel.add(appointmentNorthPanel, BorderLayout.NORTH);
        appointmentNorthPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel lblNewLabel = new JLabel("Table of doctors who wanted reappointment");
        lblNewLabel.setFont(new Font("Century", Font.PLAIN, 20));
        appointmentNorthPanel.add(lblNewLabel);

        JPanel appointmentWestPanel = new JPanel();
        appointmentWestPanel.setBackground(new Color(101, 180, 206));
        appointmentWestPanel.add(scrollPane);
        takeAppointmentPanel.add(appointmentWestPanel, BorderLayout.WEST);




        //See appointment panel

        seeAppointmentPanel = new JPanel();
        seeAppointmentPanel.setBackground(new Color(101, 180, 206));

        seeAppointmentPanel.setLayout(new BorderLayout(0, 0));

        JPanel seeAppointmentNorthPanel = new JPanel();
        seeAppointmentNorthPanel.setBackground(new Color(101, 180, 206));
        seeAppointmentPanel.add(seeAppointmentNorthPanel, BorderLayout.NORTH);

        JLabel lblNewLabel_1 = new JLabel("Blue boxes are your available dates");
        lblNewLabel_1.setFont(new Font("Century", Font.PLAIN, 20));
        seeAppointmentNorthPanel.add(lblNewLabel_1);


        //DATES WILL BE ADDED TO THIS PART
        JPanel seeAppointmentCenterPanel = new JPanel();
        seeAppointmentCenterPanel.setBackground(new Color(101, 180, 206));
        seeAppointmentPanel.add(seeAppointmentCenterPanel, BorderLayout.CENTER);






        //Adding Panels to layered pane
        layeredPane.add(seeAppointmentPanel, "name_106782643815700");



        layeredPane.add(takeAppointmentPanel, "name_106780883627700");

    }
}

