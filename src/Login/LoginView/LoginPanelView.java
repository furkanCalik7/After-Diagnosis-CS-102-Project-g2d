package Login.LoginView;

import Login.LoginButtonController;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanelView extends JPanel {
    String[] userTypes;
    private JPasswordField passwordField;
    private JTextField usernameTextField;
    private JLabel forgotLabel;
    private JButton loginButton;
    private JButton createAccButton;
    private JComboBox userTypeComboBox;


    public LoginPanelView() {
        setLayout(new BorderLayout(0, 15));

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
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));


        JPanel centerPanel = new JPanel();
        centerPanel.setBorder(new LineBorder(Color.GRAY, 1, true));
        mainPanel.add(centerPanel);
        centerPanel.setLayout(new GridLayout(6, 0, 0, 0));

        JPanel userTypePanel = new JPanel();
        centerPanel.add(userTypePanel);

        userTypes = new String[] { "Doctor", "Patient", "Lab Technician", "Administrator"};
        userTypePanel.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel promptHolder = new JPanel();
        FlowLayout flowLayout_3 = (FlowLayout) promptHolder.getLayout();
        flowLayout_3.setVgap(10);
        userTypePanel.add(promptHolder);

        JLabel loginPromptLbl = new JLabel("Choose Your Login Type:");
        loginPromptLbl.setFont(new Font("Centaur", Font.PLAIN, 20));
        promptHolder.add(loginPromptLbl);

        JPanel comboHolder = new JPanel();
        FlowLayout flowLayout_4 = (FlowLayout) comboHolder.getLayout();
        flowLayout_4.setVgap(10);
        userTypePanel.add(comboHolder);

        userTypeComboBox = new JComboBox( userTypes );
        comboHolder.add(userTypeComboBox);

        JPanel usernamePanel = new JPanel();
        centerPanel.add(usernamePanel);
        usernamePanel.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel lblHolderPanel = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) lblHolderPanel.getLayout();
        usernamePanel.add(lblHolderPanel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Centaur", Font.PLAIN, 25));
        lblHolderPanel.add(usernameLabel);

        JPanel passwordHolderPanel = new JPanel();
        usernamePanel.add(passwordHolderPanel);
        passwordHolderPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 11));

        usernameTextField = new JTextField();
        passwordHolderPanel.add(usernameTextField);
        usernameTextField.setColumns(15);

        JPanel passwordPanel = new JPanel();
        centerPanel.add(passwordPanel);
        passwordPanel.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel passwordLeftPanel = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout) passwordLeftPanel.getLayout();
        passwordPanel.add(passwordLeftPanel);

        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setFont(new Font("Centaur", Font.PLAIN, 25));
        passwordLeftPanel.add(passwordLabel);

        JPanel passwordRightPanel = new JPanel();
        passwordPanel.add(passwordRightPanel);
        passwordRightPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 11));

        passwordField = new JPasswordField();
        passwordField.setColumns(15);
        passwordRightPanel.add(passwordField);

        JPanel forgotPanel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) forgotPanel.getLayout();
        centerPanel.add(forgotPanel);

        loginButton = new LoginButtonController(this);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        forgotPanel.add(loginButton);
        loginButton.setFont(new Font("Century", Font.PLAIN, 20));

        JPanel forgotLabelPanel = new JPanel();
        forgotLabelPanel.setBorder(new TitledBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)), "OR", TitledBorder.CENTER, TitledBorder.BOTTOM, null, new Color(0, 0, 0)));
        FlowLayout fl_forgotLabelPanel = (FlowLayout) forgotLabelPanel.getLayout();
        fl_forgotLabelPanel.setAlignment(FlowLayout.LEFT);
        centerPanel.add(forgotLabelPanel);

        forgotLabel = new JLabel("Forgot your password?");
        forgotLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
        forgotLabelPanel.add(forgotLabel);

        JPanel createPanel = new JPanel();
        centerPanel.add(createPanel);

        createAccButton = new JButton("Create a New Account");
        createAccButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        createPanel.add(createAccButton);

    }

    /**
     * Use this getter to add action listener which will open the forgot password panel.
     * @return returns the forgotPassword label.
     */
    public JLabel getForgotLabel() {
        return forgotLabel;
    }

    /**
     * Returns the loginButton.
     * @return
     */
    public JButton getLoginButton() {
        return loginButton;
    }

    /**
     * @return Returns the signupButton.
     */
    public JButton getSignupButton() {
        return createAccButton;
    }

    public JComboBox getUserTypeComboBox() {
        return userTypeComboBox;
    }

    public JTextField getUsernameTextField() {
        return usernameTextField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

}
