package common;

import Admin.model.User;
import Admin.model.UserInfoCard;
import AdminViews.HospitalWorkersInfoPanel;
import Doctor.Model.DoctorInfoCard;
import Doctor.Views.HintTextField;
import Doctor.Views.MyPatientsLayeredPanelView;
import Doctor.Views.MyPatientsMainPanel;
import JDBC.Message;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

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
    private TableRowSorter<InboxTable> rowSorter;
    private TableRowSorter<SentTable> rs;
    private User user;
    private JPanel messagePanelCenter;
    private JPanel messagePanel;
    private JPanel composePanel;
    private ReadMessagePanelView readMessagePanelView;

    public void switchPanels(JPanel panel) {
        layeredPane.removeAll();
        layeredPane.add(panel);
        layeredPane.repaint();
        layeredPane.revalidate();
    }

    public void switchMessage(String username) {
        layeredPane.removeAll();
        layeredPane.add(composePanel);
        txtEnterTheSubjects.setText(username);
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
        readMessagePanelView = new ReadMessagePanelView();
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

        sentSearchField = new HintTextField("Search");
        searchFieldPanel.add(sentSearchField);
        sentSearchField.setColumns(10);

        sentSearchField.getDocument().addDocumentListener(
                new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                        sentFilter();
                    }

                    public void insertUpdate(DocumentEvent e) {
                        sentFilter();
                    }

                    public void removeUpdate(DocumentEvent e) {
                        sentFilter();
                    }
                });

        JPanel sentMessagesPanel = new JPanel();
        sentPanel.add(sentMessagesPanel, BorderLayout.CENTER);
        sentMessagesPanel.setLayout(new BorderLayout(0, 0));

        //Initializing the table and scroll pane.
        sentJTable = new JTable();
        SentTable tableModel = new SentTable();
        sentJTable.setModel(tableModel);
        rs = new TableRowSorter<>(tableModel);
        sentJTable.setRowSorter(rs);
        sentMessagesScrollPane = new JScrollPane(sentJTable);
        sentMessagesPanel.add(sentMessagesScrollPane);

        sentJTable.getColumn("Read").setCellRenderer(new ButtonRenderer());
        sentJTable.getColumn("Read").setCellEditor(new ReadMessageButton(new JTextField()));

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

        inboxSearchField = new HintTextField("Search");
        inboxSearchField.setText("Search");
        searchFieldPanel_2.add(inboxSearchField);
        inboxSearchField.setColumns(10);

        inboxSearchField.getDocument().addDocumentListener(
                new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                        newFilter();
                    }

                    public void insertUpdate(DocumentEvent e) {
                        newFilter();
                    }

                    public void removeUpdate(DocumentEvent e) {
                        newFilter();
                    }
                });


        JPanel inboxCenterPanel = new JPanel();
        inboxPanel.add(inboxCenterPanel, BorderLayout.CENTER);
        inboxCenterPanel.setLayout(new BorderLayout(0, 0));

        //Initializing the table and scroll pane.
        inboxJTable = new JTable();
        InboxTable dataModel = new InboxTable();
        inboxJTable.setModel(dataModel);
        rowSorter = new TableRowSorter<>(dataModel);
        inboxJTable.setRowSorter(rowSorter);
        JScrollPane inboxMessagesScrollPane = new JScrollPane(inboxJTable);
        inboxCenterPanel.add(inboxMessagesScrollPane);

        inboxJTable.getColumn("Read").setCellRenderer(new ButtonRenderer());
        inboxJTable.getColumn("Read").setCellEditor(new ReadMessageButton(new JTextField()));

        //--------composePanel--------------:
        //This panel creates messages.
        composePanel = new JPanel();
        composePanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        layeredPane.add(composePanel, "name_861416546981100");
        composePanel.setLayout(new BorderLayout(0, 10));

        JPanel emailTextFieldPanel = new JPanel();
        emailTextFieldPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        composePanel.add(emailTextFieldPanel, BorderLayout.NORTH);
        emailTextFieldPanel.setLayout(new GridLayout(0, 3, 0, 5));

        txtEnterTheSubjects = new HintTextField("Enter the receiver username");
        emailTextFieldPanel.add(txtEnterTheSubjects);
        txtEnterTheSubjects.setColumns(10);

        messagePanel = new JPanel();
        composePanel.add(messagePanel, BorderLayout.CENTER);
        messagePanel.setLayout(new BorderLayout(10, 10));

        messagePanelCenter = new JPanel();
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

        txtSubject = new HintTextField("Subject");
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
                switchPanels(inboxPanel);
            }
        });
        inboxButton.setFont(new Font("Century", Font.PLAIN, 16));
        buttonPanel.add(inboxButton);

        JButton sentButton = new JButton("Sent");
        sentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels(sentPanel);
            }
        });
        sentButton.setFont(new Font("Century", Font.PLAIN, 16));
        buttonPanel.add(sentButton);

        JButton composeButton = new JButton("Create a Message");
        composeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtSubject.setText("Subject");
                txtEnterTheSubjects.setText("Enter the receiver username");
                messageTextArea.setText("Enter your message here.");
                switchPanels(composePanel);
            }

        });
        composeButton.setFont(new Font("Century", Font.PLAIN, 16));
        buttonPanel.add(composeButton);

        //GUI related
        JPanel emptyPanel = new JPanel();
        add(emptyPanel, BorderLayout.SOUTH);
    }


    //Outbox Table
    class SentTable extends AbstractTableModel {
        private String[] columnNames = new String[]{
                "Subject", "Receiver", "Date", "Status", "Read"};

        private ArrayList<Message> messages;

        public SentTable() {
            messages = user.getOutbox();
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return messages.size();
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }


        public Object getValueAt(int row, int col) {
            Message data = messages.get(row);

            switch (col) {
                case 0:
                    return data.getSubject();
                case 1:
                    return data.getReceiver_username();
                case 2:
                    return data.getSent_date();
                case 3:
                    return data.is_read();
                case 4:
                    return "Read";
            }
            return "null";
        }

        public boolean isCellEditable(int row, int col) {
            return col > 3;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

            fireTableCellUpdated(rowIndex, columnIndex);
        }

        public void newRowsAdded(TableModelEvent event) {
            fireTableChanged(event);
        }

    }

    private void sentFilter() {
        RowFilter<SentTable, Object> rf = null;
        try {
            rf = RowFilter.regexFilter(sentSearchField.getText(), 1);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        rs.setRowFilter(rf);
    }


    // Inbox Table
    class InboxTable extends AbstractTableModel {
        private String[] columnNames = new String[]{
                "Subject", "Sender", "Date", "Status", "Read"};

        private ArrayList<Message> messages;

        public InboxTable() {
            messages = user.getInbox();
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return messages.size();
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }


        public Object getValueAt(int row, int col) {
            Message data = messages.get(row);

            switch (col) {
                case 0:
                    return data.getSubject();
                case 1:
                    return data.getSender_username();
                case 2:
                    return data.getSent_date();
                case 3:
                    return data.is_read();
                case 4:
                    return "Read";
            }
            return "null";
        }

        public boolean isCellEditable(int row, int col) {
            return col > 3;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

            fireTableCellUpdated(rowIndex, columnIndex);
        }

        public void newRowsAdded(TableModelEvent event) {
            fireTableChanged(event);
        }

    }

    private void newFilter() {
        RowFilter<InboxTable, Object> rf = null;
        try {
            rf = RowFilter.regexFilter(inboxSearchField.getText(), 1);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        rowSorter.setRowFilter(rf);
    }


    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    class ReadMessageButton extends DefaultCellEditor {
        protected JButton button;
        int i = 0;
        private String label;

        private boolean isPushed;

        public ReadMessageButton(JTextField textField) {
            super(textField);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {

            label = (value == null) ? "" : value.toString();
            button.setText(label);
            i = row;
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                switchPanels(readMessagePanelView);

            }
            isPushed = false;
            return new String(label);
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }

    }


}
