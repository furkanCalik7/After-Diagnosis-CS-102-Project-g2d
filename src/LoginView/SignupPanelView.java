package LoginView;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;

public class SignupPanelView extends JPanel {
    private JTextField nameTxtField;
    private JTextField surnameTxtField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JTextField textField;

    /**
     * Create the panel.
     */
    public SignupPanelView() {
        setLayout(new BorderLayout(0, 0));

        JPanel northPanel = new JPanel();
        northPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        add(northPanel, BorderLayout.NORTH);

        JPanel topLabelPanel = new JPanel();
        northPanel.add(topLabelPanel);

        JLabel topLabel = new JLabel("AFTER DIAGNOSIS");
        topLabel.setFont(new Font("Century", Font.BOLD, 20));
        topLabelPanel.add(topLabel);

        JPanel mainPanel = new JPanel();
        add(mainPanel, BorderLayout.CENTER);

        JPanel centerPanel = new JPanel();
        centerPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        mainPanel.add(centerPanel);
        centerPanel.setLayout(new GridLayout(7, 0, 0, 2));

        JPanel createPromptPanel = new JPanel();
        createPromptPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        centerPanel.add(createPromptPanel);

        JLabel createPromptLbl = new JLabel("Create Your Account");
        createPromptLbl.setFont(new Font("Century", Font.PLAIN, 15));
        createPromptPanel.add(createPromptLbl);

        JPanel nameGeneralPanel = new JPanel();
        centerPanel.add(nameGeneralPanel);
        nameGeneralPanel.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel nameHolderPanel = new JPanel();
        nameGeneralPanel.add(nameHolderPanel);

        JLabel namePromptLbl = new JLabel("Enter Your Name:");
        namePromptLbl.setFont(new Font("Centaur", Font.PLAIN, 25));
        nameHolderPanel.add(namePromptLbl);

        JPanel txtFieldPanel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) txtFieldPanel.getLayout();
        flowLayout.setVgap(8);
        nameGeneralPanel.add(txtFieldPanel);

        nameTxtField = new JTextField();
        txtFieldPanel.add(nameTxtField);
        nameTxtField.setColumns(14);

        JPanel surnameGeneralPane = new JPanel();
        centerPanel.add(surnameGeneralPane);
        surnameGeneralPane.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel surnameHolderPanel = new JPanel();
        surnameGeneralPane.add(surnameHolderPanel);

        JLabel surnamePromptLbl = new JLabel("Enter Your Surname:");
        surnamePromptLbl.setFont(new Font("Centaur", Font.PLAIN, 25));
        surnameHolderPanel.add(surnamePromptLbl);

        JPanel surnameTFieldPanel = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) surnameTFieldPanel.getLayout();
        flowLayout_1.setVgap(8);
        surnameGeneralPane.add(surnameTFieldPanel);

        surnameTxtField = new JTextField();
        surnameTFieldPanel.add(surnameTxtField);
        surnameTxtField.setColumns(14);

        JPanel passwordGeneralPanel = new JPanel();
        centerPanel.add(passwordGeneralPanel);
        passwordGeneralPanel.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel panel = new JPanel();
        passwordGeneralPanel.add(panel);

        JLabel passwordPromptLbl = new JLabel("Enter Your Password:");
        passwordPromptLbl.setFont(new Font("Centaur", Font.PLAIN, 25));
        panel.add(passwordPromptLbl);

        JPanel passwordFieldHolder = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout) passwordFieldHolder.getLayout();
        flowLayout_2.setVgap(8);
        passwordGeneralPanel.add(passwordFieldHolder);

        passwordField = new JPasswordField();
        passwordField.setColumns(14);
        passwordFieldHolder.add(passwordField);

        JPanel passwordConfPanel = new JPanel();
        centerPanel.add(passwordConfPanel);
        passwordConfPanel.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel confirmHolderPanel = new JPanel();
        passwordConfPanel.add(confirmHolderPanel);

        JLabel confirmPromptLbl = new JLabel("Confirm Your Password:");
        confirmPromptLbl.setFont(new Font("Centaur", Font.PLAIN, 25));
        confirmHolderPanel.add(confirmPromptLbl);

        JPanel confirmPassHolderPanel = new JPanel();
        passwordConfPanel.add(confirmPassHolderPanel);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setColumns(14);
        confirmPassHolderPanel.add(confirmPasswordField);

        JPanel emailPanel = new JPanel();
        emailPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        centerPanel.add(emailPanel);
        emailPanel.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel emailPromptPanel = new JPanel();
        emailPanel.add(emailPromptPanel);

        JLabel mailLabel = new JLabel("Enter Your Mail:");
        mailLabel.setFont(new Font("Centaur", Font.PLAIN, 25));
        emailPromptPanel.add(mailLabel);

        JPanel mailHolderPanel = new JPanel();
        emailPanel.add(mailHolderPanel);

        textField = new JTextField();
        mailHolderPanel.add(textField);
        textField.setColumns(14);

        JPanel createButtonHolderPanel = new JPanel();
        centerPanel.add(createButtonHolderPanel);

        JButton createButton = new JButton("Create");
        createButton.setFont(new Font("Century", Font.PLAIN, 20));
        createButtonHolderPanel.add(createButton);

    }

}
