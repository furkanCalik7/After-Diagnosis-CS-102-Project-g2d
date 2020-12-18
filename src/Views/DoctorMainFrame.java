package Views;

import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.CardLayout;

public class DoctorMainFrame extends JFrame {

	private JPanel contentPane;
	private JButton myDoctorsButton;
	private JButton myPrescribedDrugsButton;
	private JButton apptButton;
	private JLayeredPane layeredPane;
	private JPanel doctorHomepagePanelView;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorMainFrame frame = new DoctorMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
	 * Create the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public DoctorMainFrame() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 640);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][][][][][grow]", "[grow]"));
		
		doctorHomepagePanelView = new DoctorHomepagePanelView();
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel, "cell 1 0 8 1,grow");
		panel.setLayout(new GridLayout(8, 1, 0, 4));
		
		layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, "cell 9 0,grow");
		layeredPane.setLayout(new CardLayout(0, 0));
		
		layeredPane.add( doctorHomepagePanelView, "name_484583030622300" );
		
		JPanel panel_1 = new JPanel();
		layeredPane.add(panel_1, "name_484583047031200");
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_1.add(lblNewLabel);
		
		JButton homepageButton = new JButton("Homepage");
		homepageButton.setIcon(new ImageIcon("C:\\Users\\42ber\\OneDrive\\Masa\u00FCst\u00FC\\homePage.png"));
		homepageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels( doctorHomepagePanelView );
			}
		});
		
		panel.add(homepageButton);
		
		myDoctorsButton = new JButton("My Doctors");
		myDoctorsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels( panel_1 );
			}
		});
		panel.add(myDoctorsButton);
		
		JButton settingsPanel = new JButton("Settings");
		panel.add( settingsPanel );
		
		myPrescribedDrugsButton = new JButton("My Prescribed Drugs");
		panel.add(myPrescribedDrugsButton);
		
		apptButton = new JButton("Take an Appointment");
		panel.add(apptButton);
		
		JButton bloodButton = new JButton("Blood Donation");
		panel.add(bloodButton);
		
		JButton messagesButton = new JButton("Messages");
		panel.add( messagesButton );
		
		JButton medicalInfoButton = new JButton("Your Medical Information");
		panel.add( medicalInfoButton );
	}
}
