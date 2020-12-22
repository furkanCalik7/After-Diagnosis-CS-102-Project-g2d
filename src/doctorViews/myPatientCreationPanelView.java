package doctorViews;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;


public class myPatientCreationPanelView extends JPanel {
    private JTextField nameTextField;
    private JTextField surnameTextField;
    private JTextField emailTextField;
    private JTextField complaintTextField;

    /**
     * Create the panel.
     */
    public myPatientCreationPanelView() {
        setLayout(new GridLayout(7, 1, 0, 6));

        JPanel emptyPanel1 = new JPanel();
        add(emptyPanel1);

        JPanel patientInfoPanel = new JPanel();
        patientInfoPanel.setBorder(new LineBorder(new Color(0, 0, 255), 2));
        add(patientInfoPanel);
        patientInfoPanel.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel holderPanel = new JPanel();
        patientInfoPanel.add(holderPanel);

        JLabel lblNewLabel = new JLabel("New Patient Information ");
        lblNewLabel.setFont(new Font("Century", Font.PLAIN, 20));
        holderPanel.add(lblNewLabel);

        JPanel patientNamePanel = new JPanel();
        patientNamePanel.setBorder(new LineBorder(Color.BLUE));
        add(patientNamePanel);
        patientNamePanel.setLayout(new GridLayout(1, 0, 5, 0));

        JPanel patientNameLabelPanel = new JPanel();
        patientNameLabelPanel.setBorder(new LineBorder(Color.BLUE));
        FlowLayout fl_patientNameLabelPanel = (FlowLayout) patientNameLabelPanel.getLayout();
        patientNamePanel.add(patientNameLabelPanel);

        JLabel patientNameLabel = new JLabel("Patient Name");
        patientNameLabel.setFont(new Font("Century", Font.PLAIN, 20));
        patientNameLabelPanel.add(patientNameLabel);

        JPanel nameTextFieldPanel = new JPanel();
        nameTextFieldPanel.setBorder(new LineBorder(Color.BLUE));
        patientNamePanel.add(nameTextFieldPanel);
        nameTextFieldPanel.setLayout(new BorderLayout(0, 0));

        nameTextField = new JTextField();
        nameTextFieldPanel.add(nameTextField);
        nameTextField.setColumns(20);

        JPanel patientSurnamePanel = new JPanel();
        patientSurnamePanel.setBorder(new LineBorder(Color.BLUE));
        add(patientSurnamePanel);
        patientSurnamePanel.setLayout(new GridLayout(0, 2, 5, 0));

        JPanel surnamePresenterPanel = new JPanel();
        surnamePresenterPanel.setBorder(new LineBorder(Color.BLUE));
        patientSurnamePanel.add(surnamePresenterPanel);

        JLabel surnamePresenterLabel = new JLabel("Patient Surname");
        surnamePresenterLabel.setFont(new Font("Century", Font.PLAIN, 20));
        surnamePresenterPanel.add(surnamePresenterLabel);

        JPanel surnameTextFieldPanel = new JPanel();
        surnameTextFieldPanel.setBorder(new LineBorder(Color.BLUE));
        patientSurnamePanel.add(surnameTextFieldPanel);
        surnameTextFieldPanel.setLayout(new BorderLayout(0, 0));

        surnameTextField = new JTextField();
        surnameTextFieldPanel.add(surnameTextField, BorderLayout.CENTER);
        surnameTextField.setColumns(10);

        JPanel patientMailPanel = new JPanel();
        patientMailPanel.setBorder(new LineBorder(Color.BLUE));
        add(patientMailPanel);
        patientMailPanel.setLayout(new GridLayout(0, 2, 5, 0));

        JPanel mailLabelPanel = new JPanel();
        mailLabelPanel.setBorder(new LineBorder(Color.BLUE));
        patientMailPanel.add(mailLabelPanel);
        mailLabelPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel mailLabel = new JLabel("Patient E-Mail");
        mailLabel.setFont(new Font("Century", Font.PLAIN, 20));
        mailLabelPanel.add(mailLabel);

        JPanel emailTextFieldPanel = new JPanel();
        emailTextFieldPanel.setBorder(new LineBorder(Color.BLUE));
        patientMailPanel.add(emailTextFieldPanel);
        emailTextFieldPanel.setLayout(new BorderLayout(0, 0));

        emailTextField = new JTextField();
        emailTextFieldPanel.add(emailTextField, BorderLayout.CENTER);
        emailTextField.setColumns(10);

        JPanel patientDiseasePanel = new JPanel();
        patientDiseasePanel.setBorder(new LineBorder(Color.BLUE));
        add(patientDiseasePanel);
        patientDiseasePanel.setLayout(new GridLayout(0, 2, 5, 0));

        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new LineBorder(Color.BLUE));
        patientDiseasePanel.add(panel_5);

        JLabel complaintPresenterLabel = new JLabel("Complaint");
        complaintPresenterLabel.setFont(new Font("Century", Font.PLAIN, 20));
        panel_5.add(complaintPresenterLabel);

        JPanel panel_6 = new JPanel();
        panel_6.setBorder(new LineBorder(Color.BLUE));
        patientDiseasePanel.add(panel_6);
        panel_6.setLayout(new BorderLayout(0, 0));

        complaintTextField = new JTextField();
        panel_6.add(complaintTextField);
        complaintTextField.setColumns(10);

        JPanel createPanel = new JPanel();
        add(createPanel);
        createPanel.setLayout(new GridLayout(0, 3, 0, 0));

        Component horizontalStrut = Box.createHorizontalStrut(20);
        createPanel.add(horizontalStrut);

        Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        createPanel.add(horizontalStrut_1);

        JPanel nextButtonPanel = new JPanel();
        nextButtonPanel.setBorder(new LineBorder(Color.BLUE, 2, true));
        createPanel.add(nextButtonPanel);
        nextButtonPanel.setLayout(new BorderLayout(0, 0));

        JButton nextButton = new JButton("Next");
        nextButton.setFont(new Font("Century", Font.PLAIN, 20));
        nextButtonPanel.add(nextButton);

    }

}
