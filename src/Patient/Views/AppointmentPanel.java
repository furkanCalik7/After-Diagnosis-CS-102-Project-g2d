package Patient.Views;

import Appointment.Appointment;
import Doctor.Views.DatePickerPanel;
import Patient.Model.Patient;
import com.github.lgooddatepicker.components.CalendarPanel;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.optionalusertools.DateHighlightPolicy;
import com.github.lgooddatepicker.zinternaltools.HighlightInformation;
import common.HasAppointment;


import javax.swing.*;
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
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class AppointmentPanel extends JPanel {

    JTable table;
    JLayeredPane layeredPane;
    JPanel takeAppointmentPanel;
    JPanel seeAppointmentPanel;
    JTextField doctorUsernameTextField;
    JTextField startDateTextfield;
    JTextField endDateTextField;
    private HasAppointment user;
    private DatePickerPanel datePickPanel;

    public void switchPanels( JPanel panel ) {
        layeredPane.removeAll();
        layeredPane.add(panel);
        layeredPane.repaint();
        layeredPane.revalidate();
    }

    /**
     * Create the panel.
     */

    public AppointmentPanel(HasAppointment user) {
        this.user = user;
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
        //headerPanel.add(takeAppointmentButton);

        JButton seeAppointmentButton = new JButton("See Your Appointments");
        seeAppointmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels(seeAppointmentPanel);
            }
        });
        //headerPanel.add(seeAppointmentButton);

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

        DatePickerSettings settings = new DatePickerSettings();
        CalendarPanel calendarPanel = new CalendarPanel(settings);
        ArrayList<Appointment> appointments = user.getAppointmentDates();

        DateHighlightPolicy highlightInformation = new DateHighlightPolicy() {
            @Override
            public HighlightInformation getHighlightInformationOrNull(LocalDate localDate) {
                for(int i = 0; i < appointments.size(); i++) {
                    if(localDate.compareTo(appointments.get(i).getDate().toLocalDate()) == 0) {
                        return new HighlightInformation(Color.BLUE, null, appointments.get(i).getStart_time()
                                + " " + appointments.get(i).getEnd_time());
                    }
                }
                return null;
            }
        };

        settings.setHighlightPolicy(highlightInformation);

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

        JLabel lblNewLabel_1 = new JLabel("Appointment Panel");
        lblNewLabel_1.setFont(new Font("Century", Font.BOLD, 30));
        seeAppointmentNorthPanel.add(lblNewLabel_1);


        //DATES WILL BE ADDED TO THIS PART
        JPanel seeAppointmentCenterPanel = new JPanel();
        seeAppointmentCenterPanel.setBackground(new Color(101, 180, 206));
        seeAppointmentCenterPanel.setLayout( new GridLayout(0,2,0,0) );
        seeAppointmentCenterPanel.add( calendarPanel );



        JPanel takeAppointmentPanell = new JPanel();
        seeAppointmentCenterPanel.add(takeAppointmentPanell);
        takeAppointmentPanell.setBackground(new Color(101, 180, 206));
        takeAppointmentPanell.setLayout(new GridLayout(5, 0, 0, 0));

        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(101, 180, 206));
        takeAppointmentPanell.add(panel_4);
        panel_4.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panel_7 = new JPanel();
        panel_7.setBackground(new Color(101, 180, 206));
        panel_4.add(panel_7);
        panel_7.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel lblNewLabel_2 = new JLabel("Enter Username of doctor");
        lblNewLabel_2.setFont(new Font("Century", Font.PLAIN, 15) );
        panel_7.add(lblNewLabel_2);

        JPanel panel_8 = new JPanel();
        panel_8.setBackground(new Color(101, 180, 206));
        panel_4.add(panel_8);

        doctorUsernameTextField = new JTextField();
        doctorUsernameTextField.setFont(new Font("Century", Font.PLAIN, 15));
        panel_8.add(doctorUsernameTextField);
        doctorUsernameTextField.setColumns(10);

        datePickPanel = new DatePickerPanel();
        datePickPanel.setBackground(new Color(101, 180, 206));
        takeAppointmentPanell.add(datePickPanel);

        JPanel panel_6 = new JPanel();
        panel_6.setBackground(new Color(101, 180, 206));
        takeAppointmentPanell.add(panel_6);
        panel_6.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panel_5 = new JPanel();
        panel_5.setBackground(new Color(101, 180, 206));
        panel_6.add(panel_5);
        panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel lblNewLabel_3 = new JLabel("Enter start date with a  : (example 9:30)");
        lblNewLabel_3.setFont(new Font("Century", Font.PLAIN, 15));
        panel_5.add(lblNewLabel_3);

        JPanel panel_9 = new JPanel();
        panel_9.setBackground(new Color(101, 180, 206));
        panel_6.add(panel_9);

        startDateTextfield = new JTextField();
        startDateTextfield.setFont(new Font("Century", Font.PLAIN, 15));
        panel_9.add(startDateTextfield);
        startDateTextfield.setColumns(10);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(101, 180, 206));
        takeAppointmentPanell.add(panel_3);
        panel_3.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panel_10 = new JPanel();
        panel_10.setBackground( new Color(101, 180, 206) );
        panel_3.add(panel_10);
        panel_10.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel lblNewLabel_4 = new JLabel("Enter end date of appointment");
        lblNewLabel_4.setFont(new Font("Century", Font.PLAIN, 15));
        panel_10.add(lblNewLabel_4);

        JPanel panel_11 = new JPanel();
        panel_11.setBackground(new Color(101, 180, 206));
        panel_3.add(panel_11);

        endDateTextField = new JTextField();
        endDateTextField.setFont(new Font("Century", Font.PLAIN, 15));
        panel_11.add(endDateTextField);
        endDateTextField.setColumns(10);

        JPanel endButtonPanel = new JPanel();
        endButtonPanel.setBackground(new Color(101, 180, 206));
        endButtonPanel.setLayout( new FlowLayout( FlowLayout.CENTER) );

        JButton completeButton = new JButton("Complete");
        endButtonPanel.add(completeButton);

        takeAppointmentPanell.add(endButtonPanel);
        takeAppointmentPanell.setBackground(new Color(101, 180, 206));

        seeAppointmentCenterPanel.add( takeAppointmentPanell );


        seeAppointmentPanel.add(seeAppointmentCenterPanel, BorderLayout.CENTER);


        //Adding Panels to layered pane
        layeredPane.add(seeAppointmentPanel, "name_106782643815700");






        //layeredPane.add(takeAppointmentPanel, "name_106780883627700");
    }


    public JTextField getStartDateTextfield() {
        return startDateTextfield;
    }

    public JTextField getDoctorUsernameTextField() {
        return doctorUsernameTextField;
    }


    public JTextField getEndDateTextField() {
        return endDateTextField;
    }

    public DatePickerPanel getDatePickPanel() {
        return datePickPanel;
    }
}

