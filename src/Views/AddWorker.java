package Views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;
import javax.swing.JRadioButton;

public class AddWorker extends JPanel {

	/**
	 * Create the panel.
	 */
	public AddWorker() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Add A Hospital Worker");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][]", "[][][][][][][][][][]"));
		
		JLabel lblNewLabel_1 = new JLabel("Select A Hospital Worker Type");
		panel.add(lblNewLabel_1, "cell 0 0");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		panel.add(rdbtnNewRadioButton, "cell 0 1");
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		panel.add(rdbtnNewRadioButton_1, "cell 1 1");
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		panel.add(lblNewLabel_2, "cell 0 3");
		
		JLabel lblNewLabel_3 = new JLabel("Surname");
		panel.add(lblNewLabel_3, "cell 0 5");
		
		JLabel lblNewLabel_4 = new JLabel("Mail Adress");
		panel.add(lblNewLabel_4, "cell 0 7");

	}

}
