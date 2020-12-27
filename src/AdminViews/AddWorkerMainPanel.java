package AdminViews;

import Admin.model.Admin;


import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWorkerMainPanel extends JPanel {

    JTextField nameTextField;
    JTextField surnameTextField;
    JTextField textField_2;
    JComboBox comboBox;
    JRadioButton doctorButton;
    JRadioButton labTechButton;
    JRadioButton maleButton;
    JRadioButton femaleButton;
    Admin admin;
    ButtonGroup genderButtonGroup = new ButtonGroup();


    /**
     * Create the panel.
     */
    public AddWorkerMainPanel(Admin admin) {
        setBackground(new Color(101, 180, 206));
        setBorder(new EmptyBorder(30, 30, 30, 30));
        setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel = new JLabel("ADD A HOSPITAL WORKER");
        lblNewLabel.setFont(new Font("Century", Font.BOLD, 20));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblNewLabel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(101, 180, 206));
        add(panel, BorderLayout.WEST);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(101, 180, 206));
        add(panel_1, BorderLayout.SOUTH);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(101, 180, 206));
        add(panel_2, BorderLayout.EAST);

        JPanel centerPanel = new JPanel();
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new GridLayout(8, 0, 5, 10));

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(101, 180, 206));
        centerPanel.add(headerPanel);
        headerPanel.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel_1 = new JLabel("Select A Hospital Worker Type");
        lblNewLabel_1.setFont(new Font("Century", Font.BOLD, 15));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        headerPanel.add(lblNewLabel_1);

        JPanel radioButtonPanel = new JPanel();
        centerPanel.add(radioButtonPanel);
        radioButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        doctorButton = new JRadioButton("Doctor");
        doctorButton.setFont(new Font("Century", Font.PLAIN, 15));
        doctorButton.setHorizontalAlignment(SwingConstants.LEFT);
        radioButtonPanel.add(doctorButton);

        JRadioButton labTechButton = new JRadioButton("Lab Technician");
        labTechButton.setFont(new Font("Century", Font.PLAIN, 15));
        radioButtonPanel.add(labTechButton);

        JPanel panel_6 = new JPanel();
        centerPanel.add(panel_6);
        panel_6.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel lblNewLabel_2 = new JLabel("Name");
        lblNewLabel_2.setFont(new Font("Century", Font.PLAIN, 15));
        panel_6.add(lblNewLabel_2);

        nameTextField = new JTextField();
        panel_6.add(nameTextField);
        nameTextField.setColumns(10);

        JPanel panel_7 = new JPanel();
        centerPanel.add(panel_7);
        panel_7.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel lblNewLabel_3 = new JLabel("Surname");
        lblNewLabel_3.setFont(new Font("Century", Font.PLAIN, 15));
        panel_7.add(lblNewLabel_3);

        surnameTextField = new JTextField();
        panel_7.add(surnameTextField);
        surnameTextField.setColumns(10);

        JPanel panel_8 = new JPanel();
        centerPanel.add(panel_8);
        panel_8.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel lblNewLabel_3_1 = new JLabel("Mail Address");
        lblNewLabel_3_1.setFont(new Font("Century", Font.PLAIN, 15));
        panel_8.add(lblNewLabel_3_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        panel_8.add(textField_2);

        JPanel panel_15 = new JPanel();
        centerPanel.add(panel_15);
        panel_15.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setFont(new Font("Century", Font.PLAIN, 15));
        panel_15.add(genderLabel);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
        genderButtonGroup.add(rdbtnNewRadioButton);
        panel_15.add(rdbtnNewRadioButton);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
        genderButtonGroup.add(rdbtnNewRadioButton_1);
        panel_15.add(rdbtnNewRadioButton_1);

        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Unknown");
        genderButtonGroup.add(rdbtnNewRadioButton_2);
        panel_15.add(rdbtnNewRadioButton_2);


        JPanel panel_9 = new JPanel();
        centerPanel.add(panel_9);
        panel_9.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel lblNewLabel_3_2 = new JLabel("Medical Speciality");
        lblNewLabel_3_2.setFont(new Font("Century", Font.PLAIN, 15));
        panel_9.add(lblNewLabel_3_2);

        String[] words = new String[]{"Cardiology", "Neurology", "Immunology", "Dermatology", "Radiology", "Pathology",
                "Pediatrics", "Microbiology"};
        comboBox = new JComboBox( words  );
        comboBox.setFont(new Font("Century", Font.PLAIN, 15));
        //ACTION LISTENER
        comboBox.setMaximumRowCount(20);
        panel_9.add(comboBox);

        Panel panel_10 = new Panel();
        centerPanel.add(panel_10);
        panel_10.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JButton btnNewButton = new JButton("FINISH");
        btnNewButton.setFont(new Font("Century", Font.PLAIN, 15));

        ActionListener listener = new AddWorkerController(admin, this);
        btnNewButton.addActionListener(listener);
        panel_10.add(btnNewButton);


    }

}
