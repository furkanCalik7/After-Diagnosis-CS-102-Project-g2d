import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class GreetingPanel extends JPanel {

    /**
     * Create the panel.
     */
    public GreetingPanel() {

        JLabel welcomeLabel = new JLabel("Welcome Ariana Hemsworth");
        welcomeLabel.setOpaque(true);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(welcomeLabel);

        JPanel actionsMainPanel = new JPanel();
        add(actionsMainPanel);
        actionsMainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel = new JLabel("Today You Have");
        lblNewLabel.setOpaque(true);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        actionsMainPanel.add(lblNewLabel);

        JPanel actionsPanel = new JPanel();
        actionsMainPanel.add(actionsPanel);
        actionsPanel.setLayout(new GridLayout(3, 2, 20, 20));

        JButton waitingTestsButton = new JButton("5 Ready Test Resuls");
        waitingTestsButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        actionsPanel.add(waitingTestsButton);

        JLabel testResultsIcon = new JLabel("TestResultIcon");
        actionsPanel.add(testResultsIcon);

        JButton btnNewButton_1 = new JButton("10 Waiting Tests");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        actionsPanel.add(btnNewButton_1);

        JLabel waitingTestsLabel = new JLabel("waitingTestIcon");
        actionsPanel.add(waitingTestsLabel);

        JButton messagesButton = new JButton("7 New Messages");
        messagesButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        actionsPanel.add(messagesButton);

        JLabel messageIconLabel = new JLabel("MessageIcon");
        actionsPanel.add(messageIconLabel);

    }

}
