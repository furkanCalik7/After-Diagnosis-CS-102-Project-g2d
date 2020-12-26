package common;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ReadMessagePanelView extends JPanel {

    /**
     * Create the panel.
     */
    public ReadMessagePanelView() {
        setLayout(new BorderLayout(0, 20));

        JPanel SenderPanel = new JPanel();
        SenderPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        add(SenderPanel, BorderLayout.NORTH);
        SenderPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 5));

        JLabel senderPromptLabel = new JLabel("Sender:");
        SenderPanel.add(senderPromptLabel);
        senderPromptLabel.setFont(new Font("Centaur", Font.PLAIN, 20));

        JLabel senderLabel = new JLabel("ExampleName");
        SenderPanel.add(senderLabel);
        senderLabel.setFont(new Font("Centaur", Font.PLAIN, 20));

        JPanel centerPanel = new JPanel();
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new BorderLayout(0, 10));

        JPanel subjectLabelPanel = new JPanel();
        centerPanel.add(subjectLabelPanel, BorderLayout.NORTH);
        subjectLabelPanel.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel subjectLabelsPanel = new JPanel();
        subjectLabelsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        subjectLabelPanel.add(subjectLabelsPanel);
        subjectLabelsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 5));

        JLabel subjectPromptLabel = new JLabel("Subject:");
        subjectPromptLabel.setFont(new Font("Centaur", Font.PLAIN, 20));
        subjectLabelsPanel.add(subjectPromptLabel);

        JLabel subjectLabel = new JLabel("Example Subject");
        subjectLabel.setFont(new Font("Centaur", Font.PLAIN, 20));
        subjectLabelsPanel.add(subjectLabel);

        JPanel textAreaPanel = new JPanel();
        centerPanel.add(textAreaPanel, BorderLayout.CENTER);
        textAreaPanel.setLayout(new BorderLayout(0, 0));

        JTextArea messageTxtArea = new JTextArea();
        messageTxtArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        messageTxtArea.setText("Message.");
        textAreaPanel.add(messageTxtArea);

    }

}
