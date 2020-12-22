package AdminViews;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.Color;

public class AddWorkerMainPanel extends JPanel {

    private JTextField nameTextField;
    private JTextField surnameTextField;
    private JTextField textField_2;

    /**
     * Create the panel.
     */
    public AddWorkerMainPanel() {
        setBackground(Color.MAGENTA);
        setBorder(new EmptyBorder(30, 30, 30, 30));
        setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel = new JLabel("ADD A HOSPITAL WORKER");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblNewLabel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setBackground(Color.MAGENTA);
        add(panel, BorderLayout.WEST);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.MAGENTA);
        add(panel_1, BorderLayout.SOUTH);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.MAGENTA);
        add(panel_2, BorderLayout.EAST);

        JPanel centerPanel = new JPanel();
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new GridLayout(7, 0, 0, 0));

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.MAGENTA);
        centerPanel.add(headerPanel);
        headerPanel.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel_1 = new JLabel("Select A Hospital Worker Type");
        lblNewLabel_1.setBackground(Color.MAGENTA);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        headerPanel.add(lblNewLabel_1);

        JPanel radioButtonPanel = new JPanel();
        radioButtonPanel.setBackground(Color.MAGENTA);
        centerPanel.add(radioButtonPanel);
        radioButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JRadioButton doctorButton = new JRadioButton("Doctor");
        doctorButton.setHorizontalAlignment(SwingConstants.LEFT);
        radioButtonPanel.add(doctorButton);

        JRadioButton labTechButton = new JRadioButton("Lab Technician");
        radioButtonPanel.add(labTechButton);

        JPanel panel_6 = new JPanel();
        panel_6.setBackground(Color.MAGENTA);
        centerPanel.add(panel_6);
        panel_6.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel lblNewLabel_2 = new JLabel("Name");
        panel_6.add(lblNewLabel_2);

        nameTextField = new JTextField();
        panel_6.add(nameTextField);
        nameTextField.setColumns(10);

        JPanel panel_7 = new JPanel();
        panel_7.setBackground(Color.MAGENTA);
        centerPanel.add(panel_7);
        panel_7.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel lblNewLabel_3 = new JLabel("Surname");
        panel_7.add(lblNewLabel_3);

        surnameTextField = new JTextField();
        panel_7.add(surnameTextField);
        surnameTextField.setColumns(10);

        JPanel panel_8 = new JPanel();
        panel_8.setBackground(Color.MAGENTA);
        centerPanel.add(panel_8);
        panel_8.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel lblNewLabel_3_1 = new JLabel("Mail Address");
        panel_8.add(lblNewLabel_3_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        panel_8.add(textField_2);

        JPanel panel_9 = new JPanel();
        panel_9.setBackground(Color.MAGENTA);
        centerPanel.add(panel_9);
        panel_9.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JLabel lblNewLabel_3_2 = new JLabel("Medical Speciality");
        panel_9.add(lblNewLabel_3_2);

        String[] words = new String[] { "sp1","sp2" };
        JComboBox comboBox = new JComboBox( words  );
        //ACTION LISTENER
        comboBox.setMaximumRowCount(20);
        panel_9.add(comboBox);

        Panel panel_10 = new Panel();
        panel_10.setBackground(Color.MAGENTA);
        centerPanel.add(panel_10);
        panel_10.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

        JButton btnNewButton = new JButton("FINISH");
        //ACTION LISTENER WILL BE ADDED
        panel_10.add(btnNewButton);


    }

}