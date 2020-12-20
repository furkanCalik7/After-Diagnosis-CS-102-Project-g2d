package doctorViews;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JInternalFrame;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class DoctorHomepagePanelView extends JPanel {
    JLabel doctorPresenterLabel;
    JLabel doctorNameLabel;
    private JLabel doctorNameLabel_1;

    /**
     * Create the panel.
     */
    public DoctorHomepagePanelView() {
        setBackground(UIManager.getColor("Button.background"));
        setLayout(new BorderLayout(0, 0));

        JPanel labelHolderPanel = new JPanel();
        labelHolderPanel.setBorder(new EmptyBorder(25, 0, 25, 0));
        add(labelHolderPanel, BorderLayout.NORTH);

        JLabel doctorGreetingLabel = new JLabel("Welcome Doctor");
        doctorGreetingLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelHolderPanel.add(doctorGreetingLabel);

        // TODO doctorNameLabel will be doctor.getName();
        doctorNameLabel = new JLabel("Alex Green (NameHolder)");
        doctorNameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelHolderPanel.add(doctorNameLabel);

        JPanel infoGeneralPanel = new JPanel();
        add(infoGeneralPanel, BorderLayout.CENTER);
        infoGeneralPanel.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel placeHolderPanel = new JPanel();
        infoGeneralPanel.add(placeHolderPanel);

        JPanel infoPanel = new JPanel();
        infoGeneralPanel.add(infoPanel);
        infoPanel.setLayout(new GridLayout(6, 1, 0, 0));

        JPanel nameHolderPanel = new JPanel();
        infoPanel.add(nameHolderPanel);
        nameHolderPanel.setLayout(new BoxLayout(nameHolderPanel, BoxLayout.X_AXIS));

        // TODO doctorNameLabel will be doctor.getName();
        doctorNameLabel_1 = new JLabel("Alex Green (NameHolder)");
        nameHolderPanel.add(doctorNameLabel_1);
        doctorNameLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

        doctorPresenterLabel = new JLabel("Doctor ");
        nameHolderPanel.add(doctorPresenterLabel);
        doctorPresenterLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JPanel idHolderPanel = new JPanel();
        infoPanel.add(idHolderPanel);
        idHolderPanel.setLayout(new BoxLayout(idHolderPanel, BoxLayout.X_AXIS));

        JLabel idPresenterLabel = new JLabel("ID No: ");
        idHolderPanel.add(idPresenterLabel);
        idPresenterLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel doctorIDLabel = new JLabel("12345678 (ID Holder)");
        idHolderPanel.add(doctorIDLabel);
        doctorIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JPanel dateHolderPanel = new JPanel();
        infoPanel.add(dateHolderPanel);
        dateHolderPanel.setLayout(new BoxLayout(dateHolderPanel, BoxLayout.X_AXIS));

        JLabel datePresenterLabel = new JLabel("Join Date:");
        dateHolderPanel.add(datePresenterLabel);
        datePresenterLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

        // TODO dateLabel will be doctor.getJoinDate()?;
        JLabel dateLabel = new JLabel("MM/DD/YYYY");
        dateHolderPanel.add(dateLabel);
        dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JPanel mailHolderPanel = new JPanel();
        infoPanel.add(mailHolderPanel);
        mailHolderPanel.setLayout(new BoxLayout(mailHolderPanel, BoxLayout.X_AXIS));

        JLabel mailPresenterLabel = new JLabel("Mail Address: ");
        mailHolderPanel.add(mailPresenterLabel);
        mailPresenterLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

        // TODO mailLabel will be doctor.getMail();
        JLabel mailLabel = new JLabel("alex@gmail.com");
        mailHolderPanel.add(mailLabel);
        mailLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

    }

}
