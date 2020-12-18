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

public class PatientFrame extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	
	private JPanel HomePagePanel = new HomePage();
	private JPanel searchWorker = new SearchWorker();
	private JPanel addWorker = new AddWorker();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientFrame frame = new PatientFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	
	/**
	 * method to change panels when clicked to buttons
	 * @param panel: panel to switch
	 */
	public void switchPanels( JPanel panel ) {
        layeredPane.removeAll();
        layeredPane.add(panel);
        layeredPane.repaint();
        layeredPane.revalidate();
    }
	public PatientFrame() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 640);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][][][][][][][grow]", "[grow]"));
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel, "cell 1 0 8 1,grow");
		panel.setLayout(new GridLayout(6, 1, 0, 10));
		
		JButton homepageButton = new JButton("Homepage");
		homepageButton.setIcon(new ImageIcon("C:\\Users\\ASUS\\Desktop\\Icons\\home-page.png"));
		homepageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(homepageButton);
		
		JButton searchButton = new JButton("Search");
		searchButton.setIcon(new ImageIcon("C:\\Users\\ASUS\\Desktop\\Icons\\search.png"));
		panel.add(searchButton);
		
		JButton hospitalCrewButton = new JButton("Hospital Crew");
		panel.add(hospitalCrewButton);
		
		JButton btnNewButton = new JButton("Messages");
		panel.add(btnNewButton);
		
		JButton addAWorkerButton = new JButton("Add A Worker");
		panel.add(addAWorkerButton);
		
		JButton settingsButton = new JButton("Settings");
		panel.add(settingsButton);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, "cell 9 0,grow");
		layeredPane.setLayout(new BoxLayout(layeredPane, BoxLayout.X_AXIS));
		
		layeredPane.add( HomePagePanel);
		layeredPane.add(searchWorker);
		layeredPane.add(addWorker);
	}
}
