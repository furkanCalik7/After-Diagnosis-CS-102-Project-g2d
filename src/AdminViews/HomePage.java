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
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;

public class HomePage extends JPanel {

    private Admin admin;
    /**
     * Create the panel.
     */
    public HomePage(Admin admin) {
        this.admin = admin;

        setLayout( new BorderLayout() );

        JPanel welcomeLabelHolderPanel = new JPanel();
        welcomeLabelHolderPanel.setBackground(new Color(101, 180, 206));
        welcomeLabelHolderPanel.setBorder(new EmptyBorder(25, 0, 25, 0));
        add(welcomeLabelHolderPanel, BorderLayout.NORTH);

        JLabel welcomeLabel = new JLabel("Welcome " + admin.getName() + " " + admin.getSurname() );//+ labTechnician.getName() + " " + labTechnician.getSurname());
        welcomeLabel.setOpaque(true);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        welcomeLabelHolderPanel.add(welcomeLabel, BorderLayout.NORTH);

        JPanel actionsMainPanel = new JPanel();
        actionsMainPanel.setBackground(new Color(101, 180, 206));
        add(actionsMainPanel,BorderLayout.CENTER);
        actionsMainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel = new JLabel("You Have");
        lblNewLabel.setOpaque(true);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        actionsMainPanel.add(lblNewLabel);

        JPanel actionsPanel = new JPanel();
        actionsPanel.setBackground(new Color(101, 180, 206));
        actionsPanel.setBorder(new LineBorder(new Color(0, 255, 255), 2, true));
        actionsMainPanel.add(actionsPanel);
        actionsPanel.setLayout(new GridLayout(3, 2, 20, 20));

        JLabel doctorCountLabel = new JLabel(admin.getDoctors().size() + "");
        doctorCountLabel.setFont(new Font("Century", Font.PLAIN, 30));
        actionsPanel.add(doctorCountLabel);

        JLabel testResultsIcon = new JLabel("Doctors");
        testResultsIcon.setFont(new Font("Century", Font.PLAIN, 20));
        actionsPanel.add(testResultsIcon);

        JLabel labTechCountLabel = new JLabel(admin.getLabTechs().size() + "");
        labTechCountLabel.setFont(new Font("Century", Font.PLAIN, 30));
        actionsPanel.add(labTechCountLabel);

        JLabel waitingTestsLabel = new JLabel("Lab Technicians");
        waitingTestsLabel.setFont(new Font("Century", Font.PLAIN, 20));
        actionsPanel.add(waitingTestsLabel);

        JLabel messagesCountLabel = new JLabel("X");
        messagesCountLabel.setFont(new Font("Century", Font.PLAIN, 30));
        actionsPanel.add( messagesCountLabel );

        JLabel messageIconLabel = new JLabel("Messages");
        messageIconLabel.setFont(new Font("Century", Font.PLAIN, 20));
        actionsPanel.add(messageIconLabel);

    }

}
