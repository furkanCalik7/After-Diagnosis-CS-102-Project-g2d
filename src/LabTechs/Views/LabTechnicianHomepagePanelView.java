package LabTechs.Views;

import LabTechs.IColors;
import LabTechs.Model.LabTechnician;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LabTechnicianHomepagePanelView extends JPanel implements IColors {

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
        //welcomeLabel.setOpaque(false);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        welcomeLabelHolderPanel.add(welcomeLabel, BorderLayout.NORTH);
        welcomeLabelHolderPanel.setBackground( lblue2 );

        JPanel homePagePanel = new JPanel();
        homePagePanel.setLayout( new BorderLayout() );
        add(homePagePanel,BorderLayout.CENTER);
        homePagePanel.setBackground( lblue2);

        JPanel infoGeneralPanel = new JPanel();
        infoGeneralPanel.setBackground( lblue2 );
        infoGeneralPanel.setLayout(new GridLayout(0, 2, 0, 0));

        JPanel placeHolderPanel = new JPanel();
        infoGeneralPanel.add(placeHolderPanel);
        placeHolderPanel.setBackground( lblue2 );

        JPanel infoPanel = new JPanel();
        infoPanel.setBackground( lblue2 );
        infoGeneralPanel.add(infoPanel);
        infoPanel.setLayout(new GridLayout(5, 1, 0, 0));

        JPanel nameHolderPanel = new JPanel();
        nameHolderPanel.setBackground( lgreen );
        infoPanel.add(nameHolderPanel);
        nameHolderPanel.setLayout(new BoxLayout(nameHolderPanel, BoxLayout.X_AXIS));
        JLabel labTechnicianPresenterLabel = new JLabel("Name: ");
        nameHolderPanel.add(labTechnicianPresenterLabel);
        labTechnicianPresenterLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        JLabel labTechnicianNameLabel = new JLabel(labTechnician.getName() + " " + labTechnician.getSurname() );
        nameHolderPanel.add(labTechnicianNameLabel);
        labTechnicianNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JPanel idHolderPanel = new JPanel();
        idHolderPanel.setBackground( lgreen );
        infoPanel.add(idHolderPanel);
        idHolderPanel.setLayout(new BoxLayout(idHolderPanel, BoxLayout.X_AXIS));
        JLabel idPresenterLabel = new JLabel( "Lab Technician ID: " );
        idHolderPanel.add(idPresenterLabel);
        idPresenterLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        JLabel doctorIDLabel = new JLabel( String.valueOf( labTechnician.getId() ) );
        idHolderPanel.add(doctorIDLabel);
        doctorIDLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JPanel mailHolderPanel = new JPanel();
        mailHolderPanel.setBackground( lgreen );
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
        actionsMainPanel.setBackground( lblue2 );
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
