package Doctor.Views;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class myPatientCreationPanelView extends JPanel {
    private JTextField surnameTextField;
    private JTextField nameTextField;
    private JTextField emailTextField;
    private JTextField complaintTextField;
    private JTextField ageTextField;
    private JTextField allergyTextField;
    private ButtonGroup buttonGroup;
    /**
     * Create the panel.
     */
    public myPatientCreationPanelView() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.GRAY));
        add(panel);
        panel.setLayout(new GridLayout(10, 1, 0, 0));

        JPanel patientInfoPanel = new JPanel();
        patientInfoPanel.setBorder(new LineBorder(new Color(128, 128, 128)));
        panel.add(patientInfoPanel);
        patientInfoPanel.setLayout(new BorderLayout(0, 0));

        JPanel holderPanel = new JPanel();
        patientInfoPanel.add(holderPanel);
        holderPanel.setLayout(new BorderLayout(20, 0));

        JButton returnButton = new JButton("Return");
        holderPanel.add(returnButton, BorderLayout.WEST);

        JLabel topGenericLabel = new JLabel("New Patient Information ");
        holderPanel.add(topGenericLabel, BorderLayout.CENTER);
        topGenericLabel.setFont(new Font("Century", Font.PLAIN, 20));

        JPanel patientNamePanel = new JPanel();
        patientNamePanel.setBorder(new LineBorder(Color.GRAY));
        panel.add(patientNamePanel);
        patientNamePanel.setLayout(new GridLayout(1, 0, 5, 0));

        JPanel patientNameLabelPanel = new JPanel();
        patientNamePanel.add(patientNameLabelPanel);

        JLabel patientNameLabel = new JLabel("Patient's Name");
        patientNameLabel.setFont(new Font("Century", Font.PLAIN, 20));
        patientNameLabelPanel.add(patientNameLabel);

        JPanel nameTextFieldPanel = new JPanel();
        patientNamePanel.add(nameTextFieldPanel);
        nameTextFieldPanel.setLayout(new BorderLayout(0, 0));


        nameTextField = new JTextField();
        nameTextFieldPanel.add(nameTextField, BorderLayout.CENTER);
        nameTextField.setColumns(10);

        JPanel patientSurnamePanel = new JPanel();
        patientSurnamePanel.setBorder(new LineBorder(Color.GRAY));
        panel.add(patientSurnamePanel);
        patientSurnamePanel.setLayout(new GridLayout(0, 2, 5, 0));

        JPanel surnamePresenterPanel = new JPanel();
        patientSurnamePanel.add(surnamePresenterPanel);

        JLabel surnamePresenterLabel = new JLabel("Patient's Surname");
        surnamePresenterLabel.setFont(new Font("Century", Font.PLAIN, 20));
        surnamePresenterPanel.add(surnamePresenterLabel);

        JPanel surnameTextFieldPanel = new JPanel();
        patientSurnamePanel.add(surnameTextFieldPanel);
        surnameTextFieldPanel.setLayout(new BorderLayout(0, 0));

        surnameTextField = new JTextField();
        surnameTextFieldPanel.add(surnameTextField, BorderLayout.CENTER);
        surnameTextField.setColumns(10);

        JPanel patientMailPanel = new JPanel();
        patientMailPanel.setBorder(new LineBorder(Color.GRAY));
        panel.add(patientMailPanel);
        patientMailPanel.setLayout(new GridLayout(0, 2, 5, 0));

        JPanel mailLabelPanel = new JPanel();
        patientMailPanel.add(mailLabelPanel);
        mailLabelPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel mailLabel = new JLabel("Patient's E-Mail");
        mailLabel.setFont(new Font("Century", Font.PLAIN, 20));
        mailLabelPanel.add(mailLabel);

        JPanel emailTextFieldPanel = new JPanel();
        emailTextFieldPanel.setForeground(Color.GRAY);
        patientMailPanel.add(emailTextFieldPanel);
        emailTextFieldPanel.setLayout(new BorderLayout(0, 0));

        emailTextField = new JTextField();
        emailTextFieldPanel.add(emailTextField, BorderLayout.CENTER);
        emailTextField.setColumns(10);

        JPanel patientDiseasePanel = new JPanel();
        patientDiseasePanel.setBorder(new LineBorder(Color.GRAY));
        panel.add(patientDiseasePanel);
        patientDiseasePanel.setLayout(new GridLayout(0, 2, 5, 0));

        JPanel panel_5 = new JPanel();
        patientDiseasePanel.add(panel_5);

        JLabel complaintPresenterLabel = new JLabel("Patient's Complaint");
        complaintPresenterLabel.setFont(new Font("Century", Font.PLAIN, 20));
        panel_5.add(complaintPresenterLabel);

        JPanel panel_6 = new JPanel();
        patientDiseasePanel.add(panel_6);
        panel_6.setLayout(new BorderLayout(0, 0));

        complaintTextField = new JTextField();
        panel_6.add(complaintTextField, BorderLayout.CENTER);
        complaintTextField.setColumns(10);

        JPanel agePanel = new JPanel();
        agePanel.setBorder(new LineBorder(Color.GRAY));
        panel.add(agePanel);
        agePanel.setLayout(new GridLayout(0, 2, 5, 0));

        JPanel agePrstntrLblPanel = new JPanel();
        agePanel.add(agePrstntrLblPanel);

        JLabel agePrsntrLbl = new JLabel("Patient's Age");
        agePrsntrLbl.setFont(new Font("Century", Font.PLAIN, 20));
        agePrstntrLblPanel.add(agePrsntrLbl);

        JPanel ageTxtPanel = new JPanel();
        agePanel.add(ageTxtPanel);
        ageTxtPanel.setLayout(new BorderLayout(0, 0));

        ageTextField = new JTextField();
        ageTxtPanel.add(ageTextField);
        ageTextField.setColumns(10);

        JPanel genderPanel = new JPanel();
        genderPanel.setBorder(new LineBorder(Color.GRAY));
        panel.add(genderPanel);
        genderPanel.setLayout(new GridLayout(0, 2, 5, 0));

        JPanel genderPrsntrPanel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) genderPrsntrPanel.getLayout();
        flowLayout.setHgap(0);
        genderPanel.add(genderPrsntrPanel);

        JLabel genderPrsntrLbl = new JLabel("Patient's Gender");
        genderPrsntrLbl.setFont(new Font("Century", Font.PLAIN, 20));
        genderPrsntrPanel.add(genderPrsntrLbl);

        //Radiobuttons
        buttonGroup = new ButtonGroup();

        JPanel radioButtonPanel = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) radioButtonPanel.getLayout();
        radioButtonPanel.setBorder(new LineBorder(Color.GRAY));
        genderPanel.add(radioButtonPanel);

        JRadioButton maleRadioButton = new JRadioButton("Male");
        radioButtonPanel.add(maleRadioButton);

        JRadioButton femaleRadioButton = new JRadioButton("Female");
        radioButtonPanel.add(femaleRadioButton);

        JRadioButton unknownRadioButton = new JRadioButton("Not Specified");
        radioButtonPanel.add(unknownRadioButton);

        buttonGroup.add(maleRadioButton);
        buttonGroup.add(femaleRadioButton);
        buttonGroup.add(unknownRadioButton);

        JPanel allergiesPanel = new JPanel();
        allergiesPanel.setBorder(new LineBorder(Color.GRAY));
        panel.add(allergiesPanel);
        allergiesPanel.setLayout(new GridLayout(0, 2, 5, 0));

        JPanel allergyLblPanel = new JPanel();
        allergiesPanel.add(allergyLblPanel);

        JLabel allergiesPrsntrLbl = new JLabel("Patient's Allergies");
        allergiesPrsntrLbl.setFont(new Font("Century", Font.PLAIN, 20));
        allergyLblPanel.add(allergiesPrsntrLbl);

        JPanel allergyTextFieldPanel = new JPanel();
        allergiesPanel.add(allergyTextFieldPanel);
        allergyTextFieldPanel.setLayout(new BorderLayout(0, 0));

        allergyTextField = new JTextField();
        allergyTextFieldPanel.add(allergyTextField);
        allergyTextField.setColumns(10);

        JPanel buttonPanel = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout) buttonPanel.getLayout();
        flowLayout_2.setAlignment(FlowLayout.RIGHT);
        panel.add(buttonPanel);

        JButton btnNewButton = new JButton("Create Patient");
        btnNewButton.setFont(new Font("Century", Font.PLAIN, 18));
        buttonPanel.add(btnNewButton);

    }

}
