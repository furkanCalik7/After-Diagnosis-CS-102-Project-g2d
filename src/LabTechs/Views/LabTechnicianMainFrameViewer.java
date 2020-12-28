package LabTechs.Views;

import LabTechs.IColors;
import LabTechs.Model.LabTechnician;
import common.MessagePanel;
import common.SettingsPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LabTechnicianMainFrameViewer extends JFrame implements IColors {

    private JPanel contentPane;

    private JButton homePageButton;
    private JButton addTestsButton;
    private JButton myTestsButton;
    private JLayeredPane layeredPane;

    JPanel buttonPanel = new JPanel();


    private JPanel messagePanel;
    private LabTechnicianHomepagePanelView labTechHomepagePanelView;
    //private MyPatientsLayeredPanelView myPatientsLayeredPanelView;
    private LabTechnician labTechnician;

    private LabTechnicianTestsMainPanel labTestsMainPanel;
    private SettingsPanel settingsPanel;

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

    public void jumpToWaitingTests() {
        labTestsMainPanel.switchToWaitingTests();
        layeredPane.removeAll();
        layeredPane.add(labTestsMainPanel);
        layeredPane.repaint();
        layeredPane.revalidate();
    }
    
    public LabTechnicianMainFrameViewer(LabTechnician labTechnician) {
        //MySQLAccess mySQLAccess = new MySQLAccess();
        //labTechnician = ( LabTechnician ) mySQLAccess.getUser( "PeterJackson" );

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1198, 648);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(30, 0));
        contentPane.setBackground( lblue2 );

        buttonPanel = new JPanel();
        buttonPanel.setBackground( lblue );
        buttonPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        buttonPanel.setLayout(new GridLayout(6, 1, 15, 5));
        contentPane.add(buttonPanel, BorderLayout.WEST);

        labTechHomepagePanelView = new LabTechnicianHomepagePanelView(labTechnician, this);
        labTestsMainPanel = new LabTechnicianTestsMainPanel(labTechnician);

        settingsPanel = new SettingsPanel(labTechnician);
        messagePanel = new MessagePanel(labTechnician);

        JPanel layeredPanePanel = new JPanel();
        contentPane.add(layeredPanePanel, BorderLayout.CENTER);
        layeredPanePanel.setLayout(new BorderLayout(0, 0));
        layeredPanePanel.setBackground( Color.green );

        layeredPane = new JLayeredPane();
        layeredPanePanel.add(layeredPane);
        layeredPane.setLayout(new BorderLayout(0, 0));
        //layeredPane.setBackground( lblue2 );

        //Panels need to be added in inverse order

        //Button initializings
        JButton homepageButton = new JButton("Homepage");
        //homepageButton.setIcon();
        homepageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels(labTechHomepagePanelView);
            }
        });
        buttonPanel.add(homepageButton);

        JButton labTestsButton = new JButton("Lab Tests");
        labTestsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels(labTestsMainPanel);
            }
        });
        buttonPanel.add(labTestsButton);

        addTestsButton = new JButton("Add Tests");
        addTestsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        buttonPanel.add(addTestsButton);

        JButton messagesButton = new JButton("Messages");
        messagesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels(messagePanel);
            }
        });
        buttonPanel.add(messagesButton);

        JButton settingsPanelButton = new JButton("Settings");
        settingsPanelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels(settingsPanel);
            }
        });
        buttonPanel.add(settingsPanelButton);

        setVisible(true);
    }

    public void setLabTechHomepagePanelView(JPanel labTechHomepagePanelView) {

        //labTechHomepagePanelView.setBackground( new Color(30, 144, 255) );
        this.labTechHomepagePanelView = (LabTechnicianHomepagePanelView) labTechHomepagePanelView;
    }

    public void setLabTestsMainPanel(JPanel labTestsMainPanel) {
        //labTestsMainPanel.setBackground( new Color(30, 144, 255) );
        this.labTestsMainPanel = (LabTechnicianTestsMainPanel) labTestsMainPanel;
    }

    public void setSettingsPanel(JPanel settingsPanel) {
        //settingsPanel.setBackground( new Color(30, 144, 255) );
        this.settingsPanel = (SettingsPanel) settingsPanel;
    }

}
