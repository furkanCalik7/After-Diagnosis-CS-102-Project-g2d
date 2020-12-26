package common;

import Admin.model.User;

import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MessagePanel extends JPanel {
    private JTextField sentSearchField;
    private JLayeredPane layeredPane;
    private JScrollPane sentMessagesScrollPane;
    private JTable sentJTable;
    private JTable inboxJTable;
    private JTextField inboxSearchField;
    private JTextField txtEnterTheSubjects;
    private JTextField txtSubject;
    private JTextArea messageTextArea;
    private User user;

    public void switchPanels( JPanel panel ) {
        layeredPane.removeAll();
        layeredPane.add(panel);
        layeredPane.repaint();
        layeredPane.revalidate();
    }


    public JTextArea getMessageTextArea() {
        return messageTextArea;
    }

    public JTextField getTxtSubject() {
        return txtSubject;
    }

    public JTextField getInboxSearchField() {
        return inboxSearchField;
    }

    public JTextField getTxtEnterTheSubjects() {
        return txtEnterTheSubjects;
    }

    /**
     * Create the panel.
     */
    public MessagePanel(User user) {
        this.user = user;
        setLayout(new BorderLayout(0, 5));

        layeredPane = new JLayeredPane();
        add(layeredPane, BorderLayout.CENTER);
        layeredPane.setLayout(new CardLayout(10, 0));

        //--------sentPanel code--------:
        //This panel shows the sent messages.
        JPanel sentPanel = new JPanel();
        sentPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        layeredPane.add(sentPanel, "name_861411644361400");
        sentPanel.setLayout(new BorderLayout(0, 10));

        JPanel searchFieldPanel = new JPanel();
        searchFieldPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        sentPanel.add(searchFieldPanel, BorderLayout.NORTH);
        searchFieldPanel.setLayout(new GridLayout(0, 3, 0, 0));

        sentSearchField = new JTextField();
        sentSearchField.setText("Search");
        searchFieldPanel.add(sentSearchField);
        sentSearchField.setColumns(10);

        JPanel sentMessagesPanel = new JPanel();
        sentPanel.add(sentMessagesPanel, BorderLayout.CENTER);
        sentMessagesPanel.setLayout(new BorderLayout(0, 0));

        //Initializing the table and scroll pane.
        sentJTable = new JTable();
        sentJTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                },
                new String[] {
                        "Subject", "Receiver", "Date", "Status"
                }
        ));
        sentMessagesScrollPane = new JScrollPane(sentJTable);
        sentMessagesPanel.add( sentMessagesScrollPane );

        //--------inboxPanel--------------:
        //This panel shows the received messages.
        JPanel inboxPanel = new JPanel();
        inboxPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        layeredPane.add(inboxPanel, "name_861414322704500");
        inboxPanel.setLayout(new BorderLayout(0, 10));

        JPanel searchFieldPanel_2 = new JPanel();
        searchFieldPanel_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        inboxPanel.add(searchFieldPanel_2, BorderLayout.NORTH);
        searchFieldPanel_2.setLayout(new GridLayout(0, 3, 0, 0));

        inboxSearchField = new JTextField();
        inboxSearchField.setText("Search");
        searchFieldPanel_2.add(inboxSearchField);
        inboxSearchField.setColumns(10);

        JPanel inboxCenterPanel = new JPanel();
        inboxPanel.add(inboxCenterPanel, BorderLayout.CENTER);
        inboxCenterPanel.setLayout(new BorderLayout(0, 0));

        //Initializing the table and scroll pane.
        inboxJTable = new JTable();
        inboxJTable.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                },
                new String[] {
                        "Subject", "Sender", "Date", "Status"
                }
        ));
        JScrollPane inboxMessagesScrollPane = new JScrollPane( inboxJTable );
        inboxCenterPanel.add(inboxMessagesScrollPane);


        //--------composePanel--------------:
        //This panel creates messages.
        JPanel composePanel = new JPanel();
        composePanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        layeredPane.add(composePanel, "name_861416546981100");
        composePanel.setLayout(new BorderLayout(0, 10));

        JPanel emailTextFieldPanel = new JPanel();
        emailTextFieldPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        composePanel.add(emailTextFieldPanel, BorderLayout.NORTH);
        emailTextFieldPanel.setLayout(new GridLayout(0, 3, 0, 5));

        txtEnterTheSubjects = new JTextField();
        txtEnterTheSubjects.setText("Enter the receiver username");
        emailTextFieldPanel.add(txtEnterTheSubjects);
        txtEnterTheSubjects.setColumns(10);

        JPanel messagePanel = new JPanel();
        composePanel.add(messagePanel, BorderLayout.CENTER);
        messagePanel.setLayout(new BorderLayout(10, 10));

        JPanel messagePanelCenter = new JPanel();
        messagePanel.add(messagePanelCenter, BorderLayout.CENTER);
        messagePanelCenter.setLayout(new BorderLayout(0, 0));

        messageTextArea = new JTextArea();
        messageTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        messageTextArea.setText("Enter your message here.");
        messagePanelCenter.add(messageTextArea, BorderLayout.CENTER);

        JPanel subjectPanel = new JPanel();
        subjectPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        messagePanel.add(subjectPanel, BorderLayout.NORTH);
        subjectPanel.setLayout(new GridLayout(0, 3, 0, 0));

        txtSubject = new JTextField();
        txtSubject.setText("Subject");
        subjectPanel.add(txtSubject);
        txtSubject.setColumns(10);

        JPanel createButtonPanel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) createButtonPanel.getLayout();
        flowLayout.setAlignment(FlowLayout.RIGHT);
        composePanel.add(createButtonPanel, BorderLayout.SOUTH);

        JButton sendButton = new SendButtonControl(user, this);
        sendButton.setFont(new Font("Century", Font.PLAIN, 15));
        createButtonPanel.add(sendButton);

        //Main buttons are here.

        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.NORTH);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));

        JButton inboxButton = new JButton("Inbox");
        inboxButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels( inboxPanel );
            }
        });
        inboxButton.setFont(new Font("Century", Font.PLAIN, 16));
        buttonPanel.add(inboxButton);

        JButton sentButton = new JButton("Sent");
        sentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels( sentPanel );
            }
        });
        sentButton.setFont(new Font("Century", Font.PLAIN, 16));
        buttonPanel.add(sentButton);

        JButton composeButton = new JButton("Create a Message");
        composeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels( composePanel);
            }
        });
        composeButton.setFont(new Font("Century", Font.PLAIN, 16));
        buttonPanel.add(composeButton);

        //GUI related
        JPanel emptyPanel = new JPanel();
        add(emptyPanel, BorderLayout.SOUTH);


    }
}
