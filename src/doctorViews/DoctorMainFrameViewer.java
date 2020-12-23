package doctorViews;

import Doctor.Model.Doctor;
import JDBC.MySQLAccess;

import Doctor.Model.Doctor;
import JDBC.MySQLAccess;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import AdminViews.SettingsPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class DoctorMainFrameViewer extends JFrame {

    private JPanel contentPane;
    private JButton myPatientsButton;
    private JButton apptButton;
    private JLayeredPane layeredPane;
    private JPanel doctorHomepagePanelView;
    private MyPatientsLayeredPanelView myPatientsLayeredPanelView;
    private Doctor doctor;
    private LabTestsMainPanel labTestsMainPanel;
    private SettingsPanel settingsPanel;

    /**
     * Internal method to change panels.
     * @param panel
     */
    public void switchPanels( JPanel panel ) {
        layeredPane.removeAll();
        layeredPane.add(panel);
        layeredPane.repaint();
        layeredPane.revalidate();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DoctorMainFrameViewer frame = new DoctorMainFrameViewer();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public DoctorMainFrameViewer() {
        MySQLAccess mySQLAccess = new MySQLAccess();
        doctor = mySQLAccess.getDoctorByUsername( "JuliaRoberts" );

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1198, 648);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(30, 0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(new EmptyBorder(5, 5, 5, 0));
        contentPane.add( buttonPanel, BorderLayout.WEST );

        doctorHomepagePanelView = new DoctorHomepagePanelView( doctor );
        labTestsMainPanel = new LabTestsMainPanel();
        myPatientsLayeredPanelView = new MyPatientsLayeredPanelView(doctor);
        settingsPanel = new SettingsPanel();

        JPanel layeredPanePanel = new JPanel();
        contentPane.add(layeredPanePanel, BorderLayout.CENTER);
        layeredPanePanel.setLayout(new BorderLayout(0, 0));

        layeredPane = new JLayeredPane();
        layeredPanePanel.add(layeredPane);
        layeredPane.setLayout(new BorderLayout(0, 0));

        //Panels need to be added in inverse order
        layeredPane.add( myPatientsLayeredPanelView );
        layeredPane.add( doctorHomepagePanelView );
        layeredPane.add( labTestsMainPanel );
        layeredPane.add( settingsPanel );

        //Button initializings
        JButton homepageButton = new JButton("Homepage");
        homepageButton.setIcon(new ImageIcon("C:\\Users\\42ber\\OneDrive\\Masa\u00FCst\u00FC\\homePage.png"));
        homepageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels( doctorHomepagePanelView );
            }
        });
        buttonPanel.setLayout(new GridLayout(0, 1, 15, 5));

        buttonPanel.add(homepageButton);

        myPatientsButton = new JButton("My Patients");
        myPatientsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels( myPatientsLayeredPanelView );
            }
        });
        buttonPanel.add(myPatientsButton);

        apptButton = new JButton("Appointment");
        apptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        buttonPanel.add(apptButton);

        JButton bloodButton = new JButton("Necessary Bloods");
        bloodButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        buttonPanel.add(bloodButton);

        JButton messagesButton = new JButton("Messages");
        messagesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        buttonPanel.add( messagesButton );

        JButton labTestsButton = new JButton("Lab Tests");
        labTestsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels(labTestsMainPanel);
            }
        });
        buttonPanel.add( labTestsButton );

        JButton settingsPanelButton = new JButton("Settings");
        settingsPanelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels( settingsPanel );
            }
        });
        buttonPanel.add( settingsPanelButton );
        //
    }

}
