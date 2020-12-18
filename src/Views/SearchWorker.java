package Views;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;

public class SearchWorker extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public SearchWorker() {
		setBackground(new Color(30, 144, 255));
		setLayout(new BorderLayout(0, 0));
		
		JLabel headerLabel = new JLabel("Search A Worker");
		headerLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(headerLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBorder(new EmptyBorder(0, 0, 0, 100));
		add(panel, BorderLayout.WEST);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		panel_1.setBorder(new EmptyBorder(0, 100, 0, 0));
		add(panel_1, BorderLayout.EAST);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(30, 144, 255));
		panel_2.setBorder(new EmptyBorder(70, 0, 0, 0));
		add(panel_2, BorderLayout.SOUTH);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(30, 144, 255));
		add(panel_3, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Search By Name");
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(40)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(103, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);

	}
}
