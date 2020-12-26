package LabTechs.Views;

import LabTechs.Model.LabTechnician;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LabTechnicianHomepagePanelView extends JPanel {

    /**
     * Create the panel.
     */
    private LabTechnicianMainFrameViewer mainFrameViewer;

    public LabTechnicianHomepagePanelView(LabTechnician labTechnician, LabTechnicianMainFrameViewer mainFrameViewer) {

        this.mainFrameViewer = mainFrameViewer;

        setLayout( new BorderLayout() );

        JPanel welcomeLabelHolderPanel = new JPanel();
        welcomeLabelHolderPanel.setBorder(new EmptyBorder(25, 0, 25, 0));
        add(welcomeLabelHolderPanel, BorderLayout.NORTH);

        JLabel welcomeLabel = new JLabel("Welcome " + labTechnician.getName() + "!");
        welcomeLabel.setOpaque(true);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        welcomeLabelHolderPanel.add(welcomeLabel, BorderLayout.NORTH);

        JPanel homePagePanel = new JPanel();
        homePagePanel.setLayout( new BorderLayout() );
        add(homePagePanel,BorderLayout.CENTER);

        /*
        JPanel actionsMainPanel = new JPanel();
        homePagePanel.add(actionsMainPanel , BorderLayout.WEST); //add Actions Main Panel
        actionsMainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));


        JLabel lblNewLabel = new JLabel("Today You Have");
        lblNewLabel.setOpaque(true);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        actionsMainPanel.add(lblNewLabel);

        JPanel actionsPanel = new JPanel();
        actionsMainPanel.add(actionsPanel);
        actionsPanel.setLayout(new GridLayout(3, 2, 20, 20));

        JButton waitingTestsButton = new JButton( "x Ready Test Resuls");
        waitingTestsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(waitingTestsButton);
        waitingTestsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JLabel testResultsIcon = new JLabel("TestResultIcon");
        actionsPanel.add(testResultsIcon);

         */


        /*
        JButton messagesButton = new JButton("x New Messages");
        messagesButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        actionsPanel.add(messagesButton);
        waitingTestsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        JLabel messageIconLabel = new JLabel("MessageIcon");
        actionsPanel.add(messageIconLabel);


         */
        JPanel infoGeneralPanel = new JPanel();
        infoGeneralPanel.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel placeHolderPanel = new JPanel();
        infoGeneralPanel.add(placeHolderPanel);

        JPanel infoPanel = new JPanel();
        infoGeneralPanel.add(infoPanel);
        infoPanel.setLayout(new GridLayout(6, 1, 0, 0));

        JPanel nameHolderPanel = new JPanel();
        infoPanel.add(nameHolderPanel);
        nameHolderPanel.setLayout(new BoxLayout(nameHolderPanel, BoxLayout.X_AXIS));

        JLabel labTechnicianPresenterLabel = new JLabel("Name: ");
        nameHolderPanel.add(labTechnicianPresenterLabel);
        labTechnicianPresenterLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel labTechnicianNameLabel = new JLabel(labTechnician.getName() + " " + labTechnician.getSurname() );
        nameHolderPanel.add(labTechnicianNameLabel);
        labTechnicianNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JPanel idHolderPanel = new JPanel();
        infoPanel.add(idHolderPanel);
        idHolderPanel.setLayout(new BoxLayout(idHolderPanel, BoxLayout.X_AXIS));

        JLabel idPresenterLabel = new JLabel( "Doctor ID: " );
        idHolderPanel.add(idPresenterLabel);
        idPresenterLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel doctorIDLabel = new JLabel( String.valueOf( labTechnician.getId() ) );
        idHolderPanel.add(doctorIDLabel);
        doctorIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JPanel dateHolderPanel = new JPanel();
        infoPanel.add(dateHolderPanel);
        dateHolderPanel.setLayout(new BoxLayout(dateHolderPanel, BoxLayout.X_AXIS));

        JLabel datePresenterLabel = new JLabel("Join Date:");
        dateHolderPanel.add(datePresenterLabel);
        datePresenterLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

        // TODO dateLabel will be labTechnician.getJoinDate()?;
        JLabel dateLabel = new JLabel("MM/DD/YYYY");
        dateHolderPanel.add(dateLabel);
        dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JPanel mailHolderPanel = new JPanel();
        infoPanel.add(mailHolderPanel);
        mailHolderPanel.setLayout(new BoxLayout(mailHolderPanel, BoxLayout.X_AXIS));

        JLabel mailPresenterLabel = new JLabel("Mail Address: ");
        mailHolderPanel.add(mailPresenterLabel);
        mailPresenterLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel mailLabel = new JLabel(labTechnician.getEmail());
        mailHolderPanel.add(mailLabel);
        mailLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

        homePagePanel.add( infoGeneralPanel, BorderLayout.CENTER );
        //homePagePanel.add(infoGeneralPanel , BorderLayout.EAST);  //add General Info Panel

        //Actions Main panel
        JPanel actionsMainPanel = new JPanel();
        homePagePanel.add(actionsMainPanel , BorderLayout.WEST); //add Actions Main Panel
        actionsMainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton waitingTestsButton = new JButton("x Waiting Tests");
        waitingTestsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));

        waitingTestsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrameViewer.jumpToWaitingTests();
            }
        });

        JLabel waitingTestsLabel = new JLabel("waitingTestIcon");

        actionsMainPanel.add( waitingTestsButton );
        actionsMainPanel.add( waitingTestsLabel );
        homePagePanel.add(actionsMainPanel , BorderLayout.SOUTH);
    }
}
