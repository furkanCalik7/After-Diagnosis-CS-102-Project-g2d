package LabTechs.Model;

import AdminViews.MessagePanel;
import JDBC.MySQLAccess;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LabTechnicianMainFrameViewer extends JFrame {

    MessagePanel messagePanel;

    private JPanel contentPane;
    private JButton homePageButton;
    private JButton addTestsButton;
    private JButton myTestsButton;
    private JLayeredPane layeredPane;
    private JPanel labTechHomepagePanelView;
    //private MyPatientsLayeredPanelView myPatientsLayeredPanelView;
    private LabTechnician labTechnician;
    private TestsPanel labTestsMainPanel;

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
        //EventQueue.invokeLater(new Runnable() {
          //  public void run() {
                try {
                    LabTechnicianMainFrameViewer frame = new LabTechnicianMainFrameViewer();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
          //  }
        //});
    }

    /**
     * Create the frame.
     */
    public LabTechnicianMainFrameViewer() {
        MySQLAccess mySQLAccess = new MySQLAccess();
        //labTech = mySQLAccess.getAllLabTechs( );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1198, 648);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(30, 0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(new EmptyBorder(5, 5, 5, 0));
        contentPane.add(buttonPanel, BorderLayout.WEST);

        labTechHomepagePanelView = new GreetingPanel( labTechnician );
        labTestsMainPanel = new TestsPanel();
        //myPatientsLayeredPanelView = new MyPatientsLayeredPanelView(doctor);

        messagePanel = new MessagePanel();

        JPanel layeredPanePanel = new JPanel();
        contentPane.add(layeredPanePanel, BorderLayout.CENTER);
        layeredPanePanel.setLayout(new BorderLayout(0, 0));

        layeredPane = new JLayeredPane();
        layeredPanePanel.add(layeredPane);
        layeredPane.setLayout(new BorderLayout(0, 0));

        //Panels need to be added in inverse order
        layeredPane.add(labTestsMainPanel);
        layeredPane.add(messagePanel);
        layeredPane.add(labTechHomepagePanelView);


        //Button initializings
        JButton homepageButton = new JButton("Homepage");
        homepageButton.setIcon(new ImageIcon("C:\\Users\\42ber\\OneDrive\\Masa\u00FCst\u00FC\\homePage.png"));
        homepageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels( labTechHomepagePanelView );
            }
        });
        buttonPanel.setLayout(new GridLayout(0, 1, 15, 5));

        buttonPanel.add(homepageButton);

        addTestsButton = new JButton("Add Tests");
        addTestsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        buttonPanel.add(addTestsButton);

        JButton messagesButton = new JButton("Messages");
        messagesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels( messagePanel );
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

        JButton settingsPanel = new JButton("Settings");
        settingsPanel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        buttonPanel.add( settingsPanel );
        //
    }

}
