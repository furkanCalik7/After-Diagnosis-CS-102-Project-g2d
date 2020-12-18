package Views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class HomePage extends JPanel {

	/**
	 * Create the panel.
	 */
	public HomePage() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel headerLabel = new JLabel("Main Menu");
		headerLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(headerLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 2, 50, 50));
		
		JButton addAHospitalWorkerButton = new JButton("Add A Hospital Worker");
		panel.add(addAHospitalWorkerButton);
		
		JButton seeHospitalWorkersInformationButton = new JButton("See Hospital Workers Information");
		panel.add(seeHospitalWorkersInformationButton);
		
		JButton SearchAWorkerButton = new JButton("Search A Worker");
		panel.add(SearchAWorkerButton);
		
		JButton messageButton = new JButton("Messages");
		panel.add(messageButton);

	}

}
