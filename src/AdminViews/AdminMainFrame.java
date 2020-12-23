package AdminViews;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.CardLayout;
import Admin.model.*;
import JDBC.MySQLAccess;
import Patient.Model.Patient;

public class AdminMainFrame extends JFrame {

    private JPanel contentPane;
    private JLayeredPane layeredPane;
    private JPanel HomePagePanel;
    private JPanel searchWorker;
    private JPanel addWorkerMainPanel;
    private JPanel hospitalWorkersPanel;
    private JPanel messagePanel;
    private JPanel settingsPanel;
    private JPanel hospitalWorkersContainer;
    private JPanel hospitalCrew;

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
                    AdminMainFrame frame = new AdminMainFrame();
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
    public AdminMainFrame() {
        // For test only
        MySQLAccess access = new MySQLAccess();
        Admin admin  = (Admin) access.getUser("root");
        //

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1198, 648);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(30, 0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(new EmptyBorder(5, 5, 5, 0));
        contentPane.add(buttonPanel,BorderLayout.WEST);

        HomePagePanel = new HomePage();
        addWorkerMainPanel = new AddWorkerMainPanel(admin);
        hospitalWorkersPanel = new HospitalWorkersInfoPanel(admin);
        messagePanel = new MessagePanel();
        settingsPanel = new SettingsPanel(admin);
        hospitalCrew = new JPanel();
        hospitalCrew.add( hospitalWorkersPanel );

        JPanel layeredPanePanel = new JPanel();
        contentPane.add(layeredPanePanel,BorderLayout.CENTER);
        layeredPanePanel.setLayout(new BorderLayout(0, 0));

        layeredPane = new JLayeredPane();
        layeredPanePanel.add(layeredPane);
        layeredPane.setLayout(new CardLayout(0, 0));

        layeredPane.add( HomePagePanel, "name_944915029693400");
        layeredPane.add( addWorkerMainPanel, "name_944915089517800");
        layeredPane.add( messagePanel, "name_944915113895900");
        layeredPane.add( settingsPanel, "name_944915165083100");
        layeredPane.add( hospitalCrew, "name_944915191691800");

        //Button initializings

        JButton homepageButton = new JButton("Homepage");
        homepageButton.setIcon(new ImageIcon("C:\\Users\\ASUS\\Desktop\\Icons\\home-page.png"));
        homepageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels(HomePagePanel);
            }
        });
        buttonPanel.setLayout(new GridLayout(5, 0, 0, 0));
        buttonPanel.add(homepageButton);

        JButton hospitalCrewButton = new JButton("Hospital Crew");
        hospitalCrewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels( hospitalCrew);
            }
        });
        buttonPanel.add(hospitalCrewButton);

        JButton btnNewButton = new JButton("Messages");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels ( messagePanel );
            }
        });
        buttonPanel.add(btnNewButton);

        JButton addAWorkerButton = new JButton("Add A Worker");
        addAWorkerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels( addWorkerMainPanel );
            }
        });
        buttonPanel.add(addAWorkerButton);

        JButton settingsButton = new JButton("Settings");
        settingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels ( settingsPanel );
            }
        });
        buttonPanel.add(settingsButton);

    }

}