package LabTechs.Model;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GreetingPanel extends JPanel {

    /**
     * Create the panel.
     */
    public GreetingPanel(LabTechnician labTechnician) {

        setLayout( new BorderLayout() );

        JPanel welcomeLabelHolderPanel = new JPanel();
        welcomeLabelHolderPanel.setBorder(new EmptyBorder(25, 0, 25, 0));
        add(welcomeLabelHolderPanel, BorderLayout.NORTH);

        JLabel welcomeLabel = new JLabel("Welcome _name _surname" );//+ labTechnician.getName() + " " + labTechnician.getSurname());
        welcomeLabel.setOpaque(true);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        welcomeLabelHolderPanel.add(welcomeLabel, BorderLayout.NORTH);

        JPanel actionsMainPanel = new JPanel();
        add(actionsMainPanel,BorderLayout.CENTER);
        actionsMainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel = new JLabel("Today You Have");
        lblNewLabel.setOpaque(true);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        actionsMainPanel.add(lblNewLabel);

        JPanel actionsPanel = new JPanel();
        actionsMainPanel.add(actionsPanel);
        actionsPanel.setLayout(new GridLayout(3, 2, 20, 20));

        JButton waitingTestsButton = new JButton("x Ready Test Resuls");
        waitingTestsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        actionsPanel.add(waitingTestsButton);

        JLabel testResultsIcon = new JLabel("TestResultIcon");
        actionsPanel.add(testResultsIcon);

        JButton btnNewButton_1 = new JButton("x Waiting Tests");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        actionsPanel.add(btnNewButton_1);

        JLabel waitingTestsLabel = new JLabel("waitingTestIcon");
        actionsPanel.add(waitingTestsLabel);

        JButton messagesButton = new JButton("x New Messages");
        messagesButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        actionsPanel.add(messagesButton);

        JLabel messageIconLabel = new JLabel("MessageIcon");
        actionsPanel.add(messageIconLabel);

    }

}
