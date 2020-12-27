package Doctor.Views;
import Admin.model.IViewer;
import Doctor.Controller.BloodMessageSendController;
import Doctor.Model.Doctor;

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

public class DoctorBloodDonationPanel extends JPanel implements IViewer {

    private final JCheckBox zeroPosCheckBox;
    private final JCheckBox zeroNegCheckBox;
    private final JCheckBox abPosCheckBox;
    private final JCheckBox abNegCheckBox;
    private final JCheckBox bPosCheckBox;
    private final JCheckBox bNegCheckBox;
    private final JCheckBox aPosCheckBox;
    private final JCheckBox aNegCheckBox;

    public JCheckBox getZeroPosCheckBox() {
        return zeroPosCheckBox;
    }

    public JCheckBox getZeroNegCheckBox() {
        return zeroNegCheckBox;
    }

    public JCheckBox getAbPosCheckBox() {
        return abPosCheckBox;
    }

    public JCheckBox getAbNegCheckBox() {
        return abNegCheckBox;
    }

    public JCheckBox getbPosCheckBox() {
        return bPosCheckBox;
    }

    public JCheckBox getbNegCheckBox() {
        return bNegCheckBox;
    }

    public JCheckBox getaPosCheckBox() {
        return aPosCheckBox;
    }

    public JCheckBox getaNegCheckBox() {
        return aNegCheckBox;
    }

    public DoctorBloodDonationPanel(Doctor doctor) {
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

        aNegCheckBox = new JCheckBox("A RH-");
        aNegCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
        bloodChoicePanel.add(aNegCheckBox);

        aPosCheckBox = new JCheckBox("A Rh+");
        aPosCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
        bloodChoicePanel.add(aPosCheckBox);

        bNegCheckBox = new JCheckBox("B Rh-");
        bNegCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
        bloodChoicePanel.add(bNegCheckBox);

        bPosCheckBox = new JCheckBox("B Rh+");
        bPosCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
        bloodChoicePanel.add(bPosCheckBox);

        abNegCheckBox = new JCheckBox("AB Rh+");
        abNegCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
        bloodChoicePanel.add(abNegCheckBox);

        abPosCheckBox = new JCheckBox("AB Rh+");
        abPosCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
        bloodChoicePanel.add(abPosCheckBox);

        zeroNegCheckBox = new JCheckBox("0 Rh-");
        zeroNegCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
        bloodChoicePanel.add(zeroNegCheckBox);

        zeroPosCheckBox = new JCheckBox("0 Rh+");
        zeroPosCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
        bloodChoicePanel.add(zeroPosCheckBox);

        JPanel buttonPanel = new JPanel();
        selectionPanel.add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setLayout(new BorderLayout(0, 0));


        BloodMessageSendController bloodMessageSendController = new BloodMessageSendController(this,doctor);
        JButton sendMessageButton = new JButton("Send Messages To All Patients");
        sendMessageButton.setFont(new Font("Century", Font.PLAIN, 20));
        buttonPanel.add(sendMessageButton, BorderLayout.EAST);
        sendMessageButton.addActionListener(bloodMessageSendController);

        //Struts
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

        //Colors


    }

    @Override
    public void update() {

    }
}
