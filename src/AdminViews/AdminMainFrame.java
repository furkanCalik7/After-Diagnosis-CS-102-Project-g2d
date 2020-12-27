package AdminViews;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Admin.model.*;
import JDBC.MySQLAccess;
import common.MessagePanel;
import common.SettingsPanel;

public class AdminMainFrame extends JFrame {

    private JPanel contentPane;
    private JLayeredPane layeredPane;
    private JPanel HomePagePanel;
    private JPanel searchWorker;
    private JPanel addWorkerMainPanel;
    private HospitalWorkersInfoPanel hospitalWorkersPanel;
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

    public void setSettingsPanel(JPanel settingsPanel) {
        this.settingsPanel = settingsPanel;
    }

    public void setAddWorkerMainPanel(JPanel addWorkerMainPanel) {
        this.addWorkerMainPanel = addWorkerMainPanel;
    }

    public void setMessagePanel(JPanel messagePanel) {
        this.messagePanel = messagePanel;
    }

    public void setHospitalWorkersPanel(HospitalWorkersInfoPanel hospitalWorkersPanel) {
        this.hospitalWorkersPanel = hospitalWorkersPanel;
    }

    public void setHomePagePanel(JPanel homePagePanel) {
        HomePagePanel = homePagePanel;
    }


    /**
     * Create the frame.
     */

    public AdminMainFrame(String username) {
        MySQLAccess mySQLAccess = new MySQLAccess();
        Admin admin = (Admin) mySQLAccess.getUser( username );

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1198, 648);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(101, 180, 206));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(30, 0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(101, 180, 206));
        buttonPanel.setBorder(new EmptyBorder(40, 5, 40, 0));
        contentPane.add(buttonPanel,BorderLayout.WEST);

        HomePagePanel = new HomePage(admin);
        HomePagePanel.setBackground(new Color(101, 180, 206));
        addWorkerMainPanel = new AddWorkerMainPanel(admin);
        addWorkerMainPanel.setBackground(new Color(101, 180, 206));
        hospitalWorkersPanel = new HospitalWorkersInfoPanel(admin);
        hospitalWorkersPanel.setBackground(new Color(101, 180, 206));
        admin.addViewer(hospitalWorkersPanel);
        messagePanel = new MessagePanel(admin);
        messagePanel.setBackground(new Color(101, 180, 206));
        settingsPanel = new SettingsPanel(admin);
        settingsPanel.setBackground(new Color(101, 180, 206));
        hospitalCrew = new JPanel();
        hospitalCrew.setBackground(new Color(101, 180, 206));
        hospitalCrew.add( hospitalWorkersPanel );


        JPanel layeredPanePanel = new JPanel();
        layeredPanePanel.setBackground(new Color(101, 180, 206));
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
        buttonPanel.setLayout(new GridLayout(5, 0, 20, 10));
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
        setVisible(true);

    }

}