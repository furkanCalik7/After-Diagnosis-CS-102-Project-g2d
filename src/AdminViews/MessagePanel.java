package AdminViews;

import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class MessagePanel extends JPanel {
    private JTextField searchField;

    /**
     * Create the panel.
     */
    public MessagePanel() {
        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        add(panel, BorderLayout.NORTH);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton sentButton = new JButton("Sent");
        panel.add(sentButton);

        JButton inboxButton = new JButton("Inbox");
        panel.add(inboxButton);

        JButton composeButton = new JButton("Compose");
        panel.add(composeButton);

        JLayeredPane layeredPane = new JLayeredPane();
        add(layeredPane, BorderLayout.CENTER);
        layeredPane.setLayout(new CardLayout(0, 0));

        JPanel sentPanel = new JPanel();
        layeredPane.add(sentPanel, "name_861411644361400");
        sentPanel.setLayout(new BorderLayout(0, 0));

        JPanel textfieldPanel = new JPanel();
        sentPanel.add(textfieldPanel, BorderLayout.NORTH);
        textfieldPanel.setLayout(new GridLayout(0, 2, 0, 0));

        searchField = new JTextField();
        searchField.setText("Search");
        textfieldPanel.add(searchField);
        searchField.setColumns(10);

        JPanel inboxPanel = new JPanel();
        layeredPane.add(inboxPanel, "name_861414322704500");

        JPanel composePanel = new JPanel();
        layeredPane.add(composePanel, "name_861416546981100");

    }
}
