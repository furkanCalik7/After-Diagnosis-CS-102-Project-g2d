package Doctor.Views;

import Doctor.Model.Doctor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;

import Patient.Views.AppointmentPanel;
import common.MessagePanel;
import common.SettingsPanel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class DoctorMainFrameViewer extends JFrame {

    private JPanel contentPane;
    private JButton myPatientsButton;
    private JButton apptButton;
    private JLayeredPane layeredPane;
    private JPanel doctorHomepagePanelView;
    private MyPatientsLayeredPanelView myPatientsLayeredPanelView;
    private LabTestsMainPanel labTestsMainPanel;
    private SettingsPanel settingsPanel;
    private DoctorBloodDonationPanel doctorBloodDonationPanel;
    private MessagePanel messagePanel;
    private AppointmentPanel appointmentPanel;

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


    public DoctorMainFrameViewer(Doctor doctor) {

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
        labTestsMainPanel = new LabTestsMainPanel(doctor);
        myPatientsLayeredPanelView = new MyPatientsLayeredPanelView(doctor,this);
        settingsPanel = new SettingsPanel( doctor );
        doctorBloodDonationPanel = new DoctorBloodDonationPanel(doctor);
        appointmentPanel = new AppointmentPanel(doctor);


        JPanel layeredPanePanel = new JPanel();
        contentPane.add(layeredPanePanel, BorderLayout.CENTER);
        layeredPanePanel.setLayout(new BorderLayout(0, 0));

        layeredPane = new JLayeredPane();
        layeredPanePanel.add(layeredPane);
        layeredPane.setLayout(new BorderLayout(0, 0));

        //Panels need to be added in inverse order
        layeredPane.add( settingsPanel );
        layeredPane.add( labTestsMainPanel );
        layeredPane.add(appointmentPanel);
        layeredPane.add( myPatientsLayeredPanelView );
        layeredPane.add( doctorHomepagePanelView );

//        //Button initializings
        JButton homepageButton = new JButton("Homepage");
//        homepageButton.setIcon(new ImageIcon("C:\\Users\\42ber\\OneDrive\\Masa\u00FCst\u00FC\\homePage.png"));
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
                switchPanels(appointmentPanel);
            }
        });
        buttonPanel.add(apptButton);

        JButton bloodButton = new JButton("Necessary Bloods");
        bloodButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels(doctorBloodDonationPanel);
            }
        });
        buttonPanel.add(bloodButton);

        JButton messagesButton = new JButton("Messages");
        messagesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels(messagePanel);
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
        setVisible(true);

        //Colors
        contentPane.setBackground(new Color(101, 180, 206));
        buttonPanel.setBackground(new Color(69, 122, 177));
        layeredPanePanel.setBackground(new Color(101, 180, 206));
    }

    public void setDoctorHomepagePanelView(JPanel doctorHomepagePanelView) {
        this.doctorHomepagePanelView = doctorHomepagePanelView;
    }

    public void setMyPatientsLayeredPanelView(MyPatientsLayeredPanelView myPatientsLayeredPanelView) {
        this.myPatientsLayeredPanelView = myPatientsLayeredPanelView;
    }

    public void setLabTestsMainPanel(LabTestsMainPanel labTestsMainPanel) {
        this.labTestsMainPanel = labTestsMainPanel;
    }

    public void setSettingsPanel(SettingsPanel settingsPanel) {
        this.settingsPanel = settingsPanel;
    }

    public void setDoctorBloodDonationPanel(DoctorBloodDonationPanel doctorBloodDonationPanel) {
        this.doctorBloodDonationPanel = doctorBloodDonationPanel;
    }

    public MessagePanel getMessagePanel() {
        return messagePanel;
    }

    public void setMessagePanel(MessagePanel messagePanel) {
        this.messagePanel = messagePanel;
    }
}
