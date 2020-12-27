package Patient.Views;

import Patient.Model.Patient;

import javax.swing.JPanel;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class HomePagePanel extends JPanel {
    private final ButtonGroup feelingButtonGroup = new ButtonGroup();

    /**
     * Create the panel.
     */
    public HomePagePanel(Patient patient) {
        setLayout(new BorderLayout(0, 0));

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(101, 180, 206));
        add(headerPanel, BorderLayout.NORTH);
        headerPanel.setLayout(new GridLayout(0, 2, 0, 0));

        JLabel nameLabel = new JLabel("Welcome " + patient.getName() + " " + patient.getSurname());
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        headerPanel.add(nameLabel);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(101, 180, 206));
        headerPanel.add(panel);
        panel.setLayout(new GridLayout(2, 0, 0, 0));

        JLabel feelingLabel = new JLabel("How are you feeling today?");
        feelingLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(feelingLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(101, 180, 206));
        panel.add(panel_1);
        panel_1.setLayout(new GridLayout(0, 3, 0, 0));

        JRadioButton sickButton = new JRadioButton("Sick");
        feelingButtonGroup.add(sickButton);
        panel_1.add(sickButton);

        JRadioButton betterButton = new JRadioButton("Better");
        feelingButtonGroup.add(betterButton);
        panel_1.add(betterButton);

        JRadioButton wellButton = new JRadioButton("Well");
        feelingButtonGroup.add(wellButton);
        panel_1.add(wellButton);

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(new Color(101, 180, 206));
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel appointmentPanel = new JPanel();
        appointmentPanel.setBackground(new Color(101, 180, 206));
        centerPanel.add(appointmentPanel);
        appointmentPanel.setLayout(new BorderLayout(0, 0));

        JLabel appointmentLabel = new JLabel("Dont forget your appointment");
        appointmentLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        appointmentPanel.add(appointmentLabel, BorderLayout.NORTH);

        JPanel calenderPanel = new JPanel();
        calenderPanel.setBackground(new Color(101, 180, 206));
        appointmentPanel.add(calenderPanel, BorderLayout.CENTER);

        JPanel medicationPanel = new JPanel();
        medicationPanel.setBackground(new Color(101, 180, 206));
        centerPanel.add(medicationPanel);
        medicationPanel.setLayout(new BorderLayout(0, 0));

        JLabel lblNewLabel = new JLabel("The medications you should take today");
        medicationPanel.add(lblNewLabel, BorderLayout.NORTH);

        JPanel drugsPanel = new JPanel();
        drugsPanel.setBackground(new Color(101, 180, 206));
        medicationPanel.add(drugsPanel, BorderLayout.CENTER);

    }

}

