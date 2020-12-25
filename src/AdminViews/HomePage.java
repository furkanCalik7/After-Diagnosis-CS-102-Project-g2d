package AdminViews;

import Admin.model.Admin;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;

public class HomePage extends JPanel {

    private Admin admin;
    /**
     * Create the panel.
     */
    public HomePage(Admin admin) {
        this.admin = admin;
        setLayout(new BorderLayout(0, 0));

        JLabel header = new JLabel("HOMEPAGE");
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setFont(new Font("Century", Font.BOLD, 20));
        add(header, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        panel.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel = new JLabel("WELCOME " + admin.getName() + " " + admin.getSurname());
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(lblNewLabel, BorderLayout.NORTH);

        JPanel panel_1 = new JPanel();
        panel.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new GridLayout(4, 0, 0, 0));

        JPanel panel_3 = new JPanel();
        panel_1.add(panel_3);
        panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel lblNewLabel_1 = new JLabel("There is total:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_3.add(lblNewLabel_1);

        JPanel panel_4 = new JPanel();
        panel_1.add(panel_4);
        panel_4.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel lblNewLabel_2 = new JLabel(admin.seeDoctors().size() + " Doctors");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_4.add(lblNewLabel_2);

        JPanel panel_5 = new JPanel();
        panel_1.add(panel_5);
        panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel lblNewLabel_3 = new JLabel(admin.seeLabTechs().size() + " Lab Technicians in your hospital");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_5.add(lblNewLabel_3);

        JPanel panel_6 = new JPanel();
        panel_1.add(panel_6);
        panel_6.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel lblNewLabel_4 = new JLabel("And You have x new messages");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_6.add(lblNewLabel_4);

    }

}
