package Patient.Views;


import JDBC.MySQLAccess;
import Patient.Model.Patient;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientMainFrame extends JFrame {

    private JPanel contentPane;
    private JLayeredPane layeredPane;
    private JPanel HomePagePanel;
    private JPanel MyDoctorsPanel;
    private JPanel MyDrugsPanel;
    private JPanel AppointmentPanel;
    private JPanel BloodDonationPanel;
    private JPanel MessagesPanel;
    private JPanel MedInfoPanel;
    private JPanel SettingsPanel;
    private Patient patient;

    private JButton medicalInfoButton;
    private JButton bloodDonationButton;

    /**
     * Internal method to change panels.
     *
     * @param panel
     */
    public void switchPanels(JPanel panel) {
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
                    PatientMainFrame frame = new PatientMainFrame();
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
    public PatientMainFrame() {

        MySQLAccess access = new MySQLAccess();
        Patient p = (Patient) access.getUser("AlanGreen");

        //Initializing frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1198, 648);

        //Creating content pane
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(30, 0));


        //Creating button panel and adding it to content panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(8, 0, 0, 0));
        buttonPanel.setBorder(new EmptyBorder(5, 5, 5, 0));
        contentPane.add(buttonPanel, BorderLayout.WEST);

        //Creating panels which will be added to main frame
        HomePagePanel = new HomePagePanel(p);
        MyDoctorsPanel = new MyDoctorsPanel(p);
        MyDrugsPanel = new MyDrugsPanel(p);
        AppointmentPanel = new AppointmentPanel();
        BloodDonationPanel = new BloodDonationPanel();
        MessagesPanel = new MessagesPanel();
        MedInfoPanel = new MedInfoPanel(p);

        //Some bugs about settingspanel

        //SettingsPanel = new SettingsPanel(p);

        //Creating layered pane containing panels to switch
        JPanel layeredPanePanel = new JPanel();
        contentPane.add(layeredPanePanel, BorderLayout.CENTER);
        layeredPanePanel.setLayout(new BorderLayout(0, 0));

        layeredPane = new JLayeredPane();
        layeredPanePanel.add(layeredPane);
        layeredPane.setLayout(new CardLayout(0, 0));

        //Adding panels to layered pane
        layeredPane.add(HomePagePanel, "name_944915029693400");
        layeredPane.add(MyDoctorsPanel, "name_944915062377900");
        layeredPane.add(MyDrugsPanel, "name_944915089517800");
        layeredPane.add(AppointmentPanel, "name_944915113895900");
        layeredPane.add(BloodDonationPanel, "name_944915165083100");
        layeredPane.add(MessagesPanel, "name_944915191691800");
        layeredPane.add(MedInfoPanel);
        //layeredPane.add(SettingsPanel);

        //Button initializings

        JButton myDoctorsButton = new JButton("My Doctors");
        myDoctorsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels(MyDoctorsPanel);
            }
        });

        JButton homepageButton = new JButton("Homepage");
        homepageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels(HomePagePanel);
            }
        });


        JButton myDrugsButton = new JButton("My Drugs");
        myDrugsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels(MyDrugsPanel);
            }
        });


        JButton messageButton = new JButton("Messages");
        messageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels(MessagesPanel);
            }
        });


        JButton appointmentButton = new JButton("Appointment");
        appointmentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels(AppointmentPanel);
            }
        });


        JButton settingsButton = new JButton("Settings");
        settingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels(SettingsPanel);
            }
        });

        medicalInfoButton = new JButton("Medical Information");
        medicalInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels(MedInfoPanel);
            }
        });
        bloodDonationButton = new JButton("Blood Donation");
        bloodDonationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels(BloodDonationPanel);
            }
        });

        //Adding Buttons to button panel


        buttonPanel.add(homepageButton);
        buttonPanel.add(myDoctorsButton);
        buttonPanel.add(settingsButton);
        buttonPanel.add(myDrugsButton);
        buttonPanel.add(messageButton);
        buttonPanel.add(appointmentButton);
        buttonPanel.add(bloodDonationButton);
        buttonPanel.add(medicalInfoButton);


    }

}
