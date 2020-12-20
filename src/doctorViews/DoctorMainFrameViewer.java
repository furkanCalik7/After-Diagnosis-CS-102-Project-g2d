package doctorViews;

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
import java.awt.FlowLayout;

public class DoctorMainFrameViewer extends JFrame {

    private JPanel contentPane;
    private JButton myPatientsButton;
    private JButton myPrescribedDrugsButton;
    private JButton apptButton;
    private JLayeredPane layeredPane;
    private JPanel doctorHomepagePanelView;
    private MyPatientsLayeredPanelView myPatientsLayeredPanelView;


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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1198, 648);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(30, 0));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(new EmptyBorder(5, 5, 5, 0));
        contentPane.add(buttonPanel, BorderLayout.WEST);

        doctorHomepagePanelView = new DoctorHomepagePanelView();
        myPatientsLayeredPanelView = new MyPatientsLayeredPanelView();

        JPanel layeredPanePanel = new JPanel();
        contentPane.add(layeredPanePanel, BorderLayout.CENTER);
        layeredPanePanel.setLayout(new BorderLayout(0, 0));

        layeredPane = new JLayeredPane();
        layeredPanePanel.add(layeredPane);
        layeredPane.setLayout(new BorderLayout(0, 0));

        layeredPane.add(doctorHomepagePanelView);
        layeredPane.add(myPatientsLayeredPanelView);

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

        JButton settingsPanel = new JButton("Settings");
        buttonPanel.add( settingsPanel );

        myPrescribedDrugsButton = new JButton("My Prescribed Drugs");
        buttonPanel.add(myPrescribedDrugsButton);

        apptButton = new JButton("Take an Appointment");
        buttonPanel.add(apptButton);

        JButton bloodButton = new JButton("Blood Donation");
        buttonPanel.add(bloodButton);

        JButton messagesButton = new JButton("Messages");
        buttonPanel.add( messagesButton );

        JButton medicalInfoButton = new JButton("Your Medical Information");
        buttonPanel.add( medicalInfoButton );

    }

}
