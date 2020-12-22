package doctorViews;


import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class PatientInfoPanelView extends JPanel {

    /**
     * Create the panel.
     */
    public PatientInfoPanelView() {
        setLayout(new BorderLayout(0, 15));

        JPanel northPanel = new JPanel();
        northPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        add(northPanel, BorderLayout.NORTH);

        JLabel headerLabel = new JLabel("Patient Information");
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setFont(new Font("Century", Font.PLAIN, 20));
        northPanel.add(headerLabel);

        JPanel centerPanel = new JPanel();
        centerPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new BorderLayout(0, 0));

        JPanel centerSouthButtonsPanel = new JPanel();
        centerPanel.add(centerSouthButtonsPanel, BorderLayout.SOUTH);

        JPanel centerInfoPanel = new JPanel();
        centerPanel.add(centerInfoPanel, BorderLayout.WEST);
        centerInfoPanel.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel patientNamePanel = new JPanel();
        patientNamePanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        centerInfoPanel.add(patientNamePanel);

        JLabel patientNamePrsntrLbl = new JLabel("Patient Name:");
        patientNamePrsntrLbl.setFont(new Font("Century", Font.PLAIN, 20));
        patientNamePanel.add(patientNamePrsntrLbl);

        //TODO this label will use patient.getName()
        JLabel patientNameLbl = new JLabel("Names Are Here");
        patientNameLbl.setFont(new Font("Century", Font.PLAIN, 20));
        patientNamePanel.add(patientNameLbl);

        JPanel bloodTypePnl = new JPanel();
        bloodTypePnl.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        centerInfoPanel.add(bloodTypePnl);

        JLabel bloodTypePrsntrLbl = new JLabel("Blood Type:");
        bloodTypePrsntrLbl.setFont(new Font("Century", Font.PLAIN, 20));
        bloodTypePnl.add(bloodTypePrsntrLbl);

        //TODO this label will be patient.getBloodType()
        JLabel bloodTypeLbl = new JLabel("Ex ARh-");
        bloodTypeLbl.setFont(new Font("Century", Font.PLAIN, 20));
        bloodTypePnl.add(bloodTypeLbl);

        JPanel patientAgePnl = new JPanel();
        patientAgePnl.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        centerInfoPanel.add(patientAgePnl);

        JLabel patientAgePrsntrLbl = new JLabel("Patient Age:");
        patientAgePnl.add(patientAgePrsntrLbl);
        patientAgePrsntrLbl.setFont(new Font("Century", Font.PLAIN, 20));

        //TODO this will be patient.getAge
        JLabel patientAgeLbl = new JLabel("Example 18");
        patientAgePnl.add(patientAgeLbl);
        patientAgeLbl.setFont(new Font("Century", Font.PLAIN, 20));

        JPanel patientNumberPanel = new JPanel();
        patientNumberPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        centerInfoPanel.add(patientNumberPanel);

        JLabel patientNumPrsntrLbl = new JLabel("Patient Number:");
        patientNumPrsntrLbl.setFont(new Font("Century", Font.PLAIN, 20));
        patientNumberPanel.add(patientNumPrsntrLbl);

        //TODO this label will use patient.num()
        JLabel patientNumLbl = new JLabel("0000000");
        patientNumLbl.setFont(new Font("Century", Font.PLAIN, 20));
        patientNumberPanel.add(patientNumLbl);

        JPanel datePanel = new JPanel();
        datePanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        centerInfoPanel.add(datePanel);

        JLabel lblNewLabel = new JLabel("Date Of The First Appt.");
        datePanel.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Century", Font.PLAIN, 20));

        JLabel lblNewLabel_1 = new JLabel("MM/DD/YYYY");
        datePanel.add(lblNewLabel_1);
        lblNewLabel_1.setFont(new Font("Century", Font.PLAIN, 20));

        JPanel patientMailPnl = new JPanel();
        patientMailPnl.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        centerInfoPanel.add(patientMailPnl);

        JLabel patientMailPrsntrLbl = new JLabel("Patient Email:");
        patientMailPnl.add(patientMailPrsntrLbl);
        patientMailPrsntrLbl.setFont(new Font("Century", Font.PLAIN, 20));

        //This will be patient.getMail() ?
        JLabel patientMailLbl = new JLabel("example@gmail.com");
        patientMailPnl.add(patientMailLbl);
        patientMailLbl.setFont(new Font("Century", Font.PLAIN, 20));

        JPanel southPanel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) southPanel.getLayout();
        flowLayout.setAlignment(FlowLayout.TRAILING);
        centerPanel.add(southPanel, BorderLayout.SOUTH);

        JButton editButton = new JButton("Edit Patient Information");
        editButton.setFont(new Font("Century", Font.PLAIN, 15));
        southPanel.add(editButton);

        JButton drugButton = new JButton("Go to Drug Page of The Patient");
        drugButton.setFont(new Font("Century", Font.PLAIN, 15));
        southPanel.add(drugButton);

        JPanel allergiesPanel = new JPanel();
        centerPanel.add(allergiesPanel, BorderLayout.CENTER);
        allergiesPanel.setLayout(new GridLayout(2, 2, 0, 5));

        JPanel allergiesLblPanel = new JPanel();
        allergiesLblPanel.setBorder(new EmptyBorder(2, 0, 0, 0));
        allergiesPanel.add(allergiesLblPanel);
        allergiesLblPanel.setLayout(new BorderLayout(0, 0));

        JPanel allergiesTopPanel = new JPanel();
        allergiesTopPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        allergiesLblPanel.add(allergiesTopPanel, BorderLayout.NORTH);

        JLabel allergiesPrsntLbl = new JLabel("Allergies:");
        allergiesTopPanel.add(allergiesPrsntLbl);
        allergiesPrsntLbl.setFont(new Font("Century", Font.PLAIN, 20));
        allergiesPrsntLbl.setHorizontalAlignment(SwingConstants.CENTER);

        //TODO This label will take allergies.
        JLabel allergiesLabel = new JLabel("Bee Allergy");
        allergiesTopPanel.add(allergiesLabel);
        allergiesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        allergiesLabel.setFont(new Font("Century", Font.PLAIN, 20));

        JPanel emptyPanel = new JPanel();
        allergiesPanel.add(emptyPanel);

        JPanel emptySouthPanel = new JPanel();
        add(emptySouthPanel, BorderLayout.SOUTH);

        Component verticalStrut = Box.createVerticalStrut(20);
        emptySouthPanel.add(verticalStrut);

    }

}
