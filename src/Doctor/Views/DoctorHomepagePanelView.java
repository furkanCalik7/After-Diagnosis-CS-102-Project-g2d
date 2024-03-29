package Doctor.Views;

import Admin.model.IViewer;
import Doctor.Model.Doctor;

import javax.imageio.ImageIO;
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

public class DoctorHomepagePanelView extends JPanel implements IViewer {
    JLabel doctorPresenterLabel;
    JLabel doctorNameLabel;
    private JLabel doctorNameLabel_1;

    /**
     * Create the panel.
     */
    public DoctorHomepagePanelView( Doctor doctor ) {
        setBackground(UIManager.getColor("Button.background"));
        setLayout(new BorderLayout(0, 0));

        JPanel labelHolderPanel = new JPanel();
        labelHolderPanel.setBorder(new EmptyBorder(25, 0, 25, 0));
        add(labelHolderPanel, BorderLayout.NORTH);

        JLabel doctorGreetingLabel = new JLabel("Welcome Doctor");
        doctorGreetingLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        labelHolderPanel.add(doctorGreetingLabel);

        doctorNameLabel = new JLabel( doctor.getName() );
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

        doctorPresenterLabel = new JLabel("Doctor ");
        nameHolderPanel.add(doctorPresenterLabel);
        doctorPresenterLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

        doctorNameLabel_1 = new JLabel(doctor.getName() );
        nameHolderPanel.add(doctorNameLabel_1);
        doctorNameLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JPanel idHolderPanel = new JPanel();
        infoPanel.add(idHolderPanel);
        idHolderPanel.setLayout(new BoxLayout(idHolderPanel, BoxLayout.X_AXIS));

        JLabel idPresenterLabel = new JLabel( "Doctor ID: " );
        idHolderPanel.add(idPresenterLabel);
        idPresenterLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel doctorIDLabel = new JLabel( String.valueOf( doctor.getId() ) );
        idHolderPanel.add(doctorIDLabel);
        doctorIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JPanel mailHolderPanel = new JPanel();
        infoPanel.add(mailHolderPanel);
        mailHolderPanel.setLayout(new BoxLayout(mailHolderPanel, BoxLayout.X_AXIS));

        JLabel mailPresenterLabel = new JLabel("Mail Address: ");
        mailHolderPanel.add(mailPresenterLabel);
        mailPresenterLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel mailLabel = new JLabel(doctor.getEmail());
        mailHolderPanel.add(mailLabel);
        mailLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

        //Color
        this.setBackground(new Color(101, 180, 206));
        labelHolderPanel.setBackground(new Color(101, 180, 206));
        infoGeneralPanel.setBackground(new Color(101, 180, 206));
        placeHolderPanel.setBackground(new Color(101, 180, 206));
        infoPanel.setBackground(new Color(101, 180, 206));
        nameHolderPanel.setBackground(new Color(101, 180, 206));
        idHolderPanel.setBackground(new Color(101, 180, 206));
        mailHolderPanel.setBackground(new Color(101, 180, 206));

        //Icon
        placeHolderPanel.setLayout(new BorderLayout(0, 0));

//        JLabel iconLabel = new JLabel("" );
//        iconLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
//        iconLabel.setIcon( new ImageIcon("C:\\Users\\42ber\\OneDrive\\Masa\u00FCst\u00FC\\stet.png") );
//        iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
//        placeHolderPanel.add(iconLabel, BorderLayout.CENTER);

    }

    @Override
    public void update() {

    }
}
