package doctorViews;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class DoctorBloodDonationPanel extends JPanel {

    /**
     * Create the panel.
     */
    public DoctorBloodDonationPanel() {
        setLayout(new BorderLayout(0, 0));

        JPanel centerPanel = new JPanel();
        centerPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel lblHolderPanel = new JPanel();
        centerPanel.add(lblHolderPanel);
        lblHolderPanel.setLayout(new GridLayout(5, 1, 0, 0));

        JPanel panel = new JPanel();
        lblHolderPanel.add(panel);

        JPanel panel_1 = new JPanel();
        lblHolderPanel.add(panel_1);

        JPanel panel_2 = new JPanel();
        lblHolderPanel.add(panel_2);

        JLabel prsntrLbl = new JLabel("Select Necessary Blood Types: ");
        panel_2.add(prsntrLbl);
        prsntrLbl.setFont(new Font("Century", Font.PLAIN, 20));

        JPanel panel_3 = new JPanel();
        lblHolderPanel.add(panel_3);

        JPanel selectionPanel = new JPanel();
        centerPanel.add(selectionPanel);
        selectionPanel.setLayout(new BorderLayout(0, 0));

        JPanel bloodChoicePanel = new JPanel();
        bloodChoicePanel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 255), 3), new LineBorder(new Color(0, 0, 0), 1, true)));
        selectionPanel.add(bloodChoicePanel, BorderLayout.CENTER);
        bloodChoicePanel.setLayout(new GridLayout(0, 2, 0, 0));

        JCheckBox ANegCheckBox = new JCheckBox("A RH-");
        ANegCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
        bloodChoicePanel.add(ANegCheckBox);

        JCheckBox APosCheckBox = new JCheckBox("A Rh+");
        APosCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
        bloodChoicePanel.add(APosCheckBox);

        JCheckBox BNegCheckBox = new JCheckBox("B Rh-");
        BNegCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
        bloodChoicePanel.add(BNegCheckBox);

        JCheckBox BPosCheckBox = new JCheckBox("B Rh+");
        BPosCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
        bloodChoicePanel.add(BPosCheckBox);

        JCheckBox ABNegCheckBox = new JCheckBox("AB Rh+");
        ABNegCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
        bloodChoicePanel.add(ABNegCheckBox);

        JCheckBox ABPosCheckBox = new JCheckBox("AB Rh+");
        ABPosCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
        bloodChoicePanel.add(ABPosCheckBox);

        JCheckBox zeroNegCheckBox = new JCheckBox("0 Rh-");
        zeroNegCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
        bloodChoicePanel.add(zeroNegCheckBox);

        JCheckBox zeroPosCheckBox = new JCheckBox("0 Rh+");
        zeroPosCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 11));
        bloodChoicePanel.add(zeroPosCheckBox);

        JPanel buttonPanel = new JPanel();
        selectionPanel.add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setLayout(new BorderLayout(0, 0));

        JButton sendMessageButton = new JButton("Send Messages To All Patients");
        sendMessageButton.setFont(new Font("Century", Font.PLAIN, 20));
        buttonPanel.add(sendMessageButton, BorderLayout.EAST);

        Component verticalStrut_3 = Box.createVerticalStrut(20);
        buttonPanel.add(verticalStrut_3, BorderLayout.NORTH);

        Component verticalStrut_2 = Box.createVerticalStrut(60);
        selectionPanel.add(verticalStrut_2, BorderLayout.NORTH);

        Component verticalStrut = Box.createVerticalStrut(40);
        add(verticalStrut, BorderLayout.NORTH);

        Component verticalStrut_1 = Box.createVerticalStrut(40);
        add(verticalStrut_1, BorderLayout.SOUTH);

        Component horizontalStrut = Box.createHorizontalStrut(20);
        add(horizontalStrut, BorderLayout.WEST);

        Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        add(horizontalStrut_1, BorderLayout.EAST);

    }

}
