package common;

import Admin.model.IViewer;
import Admin.model.User;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class SettingsPanel extends JPanel implements IViewer {

    JTextField nameTextField;
    JTextField mailTextField;
    JTextField passwordTextField;
    final ButtonGroup buttonGroup = new ButtonGroup();
    User user;

    /**
     * Create the panel.
     */
    public SettingsPanel(User user) {
        this.user = user;
        setLayout(new GridLayout(7, 1, 0, 6));
        setBorder(BorderFactory.createEmptyBorder(30,30,30,30));

        JPanel topHeaderPanel = new JPanel();
        add(topHeaderPanel);

        JLabel header = new JLabel("SETTINGS");
        header.setFont(new Font("Century", Font.BOLD, 25));
        topHeaderPanel.add(header);

        JPanel infoPanel = new JPanel();
        infoPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        add(infoPanel);
        infoPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel infoLabel = new JLabel("Update your information");
        infoLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        infoPanel.add(infoLabel);

        JPanel patientNamePanel = new JPanel();
        patientNamePanel.setBorder(new LineBorder(Color.BLUE));
        add(patientNamePanel);
        patientNamePanel.setLayout(new GridLayout(1, 0, 5, 0));

        JPanel panel_8 = new JPanel();
        panel_8.setBorder(new LineBorder(Color.BLUE));
        FlowLayout flowLayout = (FlowLayout) panel_8.getLayout();
        patientNamePanel.add(panel_8);

        JLabel patientNameLabel = new JLabel("Your Username:");
        patientNameLabel.setFont(new Font("Century", Font.PLAIN, 20));
        panel_8.add(patientNameLabel);

        JPanel panel_9 = new JPanel();
        panel_9.setBorder(new LineBorder(Color.BLUE));
        patientNamePanel.add(panel_9);
        panel_9.setLayout(new BorderLayout(0, 0));

        nameTextField = new JTextField(user.getUsername());
        panel_9.add(nameTextField);
        nameTextField.setColumns(20);

        JPanel patientSurnamePanel = new JPanel();
        patientSurnamePanel.setBorder(new LineBorder(Color.black));
        add(patientSurnamePanel);
        patientSurnamePanel.setLayout(new GridLayout(0, 2, 5, 0));

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(Color.BLUE));
        patientSurnamePanel.add(panel);

        JLabel lblNewLabel_1 = new JLabel("Your Mail");
        lblNewLabel_1.setFont(new Font("Century", Font.PLAIN, 20));
        panel.add(lblNewLabel_1);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new LineBorder(Color.BLACK));
        patientSurnamePanel.add(panel_1);
        panel_1.setLayout(new BorderLayout(0, 0));

        mailTextField = new JTextField(user.getEmail());
        panel_1.add(mailTextField, BorderLayout.CENTER);
        mailTextField.setColumns(10);

        JPanel patientMailPanel = new JPanel();
        patientMailPanel.setBorder(new LineBorder(Color.BLACK));
        add(patientMailPanel);
        patientMailPanel.setLayout(new GridLayout(0, 2, 5, 0));

        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new LineBorder(Color.BLUE));
        patientMailPanel.add(panel_3);
        panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel mailLabel = new JLabel("Your Password");
        mailLabel.setFont(new Font("Century", Font.PLAIN, 20));
        panel_3.add(mailLabel);

        JPanel panel_4 = new JPanel();
        panel_4.setBorder(new LineBorder(Color.BLACK));
        patientMailPanel.add(panel_4);
        panel_4.setLayout(new BorderLayout(0, 0));

        passwordTextField = new JTextField(user.getPassword());
        panel_4.add(passwordTextField, BorderLayout.CENTER);
        passwordTextField.setColumns(10);

        JPanel patientDiseasePanel = new JPanel();
        patientDiseasePanel.setBorder(new LineBorder(Color.BLACK));
        add(patientDiseasePanel);
        patientDiseasePanel.setLayout(new GridLayout(0, 2, 5, 0));

        JPanel panel_5 = new JPanel();
        panel_5.setBorder(new LineBorder(Color.BLACK));
        patientDiseasePanel.add(panel_5);

        JLabel lblNewLabel_3 = new JLabel("Choose Text Size");
        lblNewLabel_3.setFont(new Font("Century", Font.PLAIN, 20));
        panel_5.add(lblNewLabel_3);

        JPanel panel_6 = new JPanel();
        panel_6.setBorder(new LineBorder(Color.BLACK));
        patientDiseasePanel.add(panel_6);
        panel_6.setLayout(new GridLayout(0, 2, 0, 0));

        JRadioButton normalSizeButton = new JRadioButton("Normal");
        buttonGroup.add(normalSizeButton);
        panel_6.add(normalSizeButton);

        JRadioButton bigSizeButton = new JRadioButton("Big");
        buttonGroup.add(bigSizeButton);
        bigSizeButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_6.add(bigSizeButton);

        JPanel createPanel = new JPanel();
        createPanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        add(createPanel);
        createPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton saveYourChangesButton = new SettingsButtonController(user, this);
        saveYourChangesButton.setFont(new Font("Century", Font.PLAIN, 20));
        createPanel.add(saveYourChangesButton);

    }

    @Override
    public void update() {

    }
}