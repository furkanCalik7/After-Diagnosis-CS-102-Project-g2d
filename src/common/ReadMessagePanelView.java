package common;



import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class ReadMessagePanelView extends JPanel {

    private JLabel messageTxtArea;
    private JLabel subjectLabel;
    private JLabel senderLabel;

    public void setMessageTxtArea(String messageTxtArea) {
        this.messageTxtArea.setText(messageTxtArea);
    }

    public void setSubjectLabel(String subjectLabel) {
        this.subjectLabel.setText("<html>"+ subjectLabel + "</html>");
    }

    public void setSenderLabel(String senderLabel) {
        this.senderLabel.setText(senderLabel);
    }

    public ReadMessagePanelView() {
        setLayout(new BorderLayout(0, 20));

        JPanel SenderPanel = new JPanel();
        SenderPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        add(SenderPanel, BorderLayout.NORTH);
        SenderPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 5));

        JLabel senderPromptLabel = new JLabel("Sender:");
        SenderPanel.add(senderPromptLabel);
        senderPromptLabel.setFont(new Font("Centaur", Font.PLAIN, 18));

        senderLabel = new JLabel("ExampleName");
        SenderPanel.add(senderLabel);
        senderLabel.setFont(new Font("Centaur", Font.PLAIN, 18));

        JPanel centerPanel = new JPanel();
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new BorderLayout(0, 18));

        JPanel subjectLabelPanel = new JPanel();
        centerPanel.add(subjectLabelPanel, BorderLayout.NORTH);
        subjectLabelPanel.setLayout(new GridLayout(0, 1, 0, 0));

        JPanel subjectLabelsPanel = new JPanel();
        subjectLabelsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        subjectLabelPanel.add(subjectLabelsPanel);
        subjectLabelsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 5));

        JLabel subjectPromptLabel = new JLabel("Subject:");
        subjectPromptLabel.setFont(new Font("Centaur", Font.PLAIN, 18));
        subjectLabelsPanel.add(subjectPromptLabel);

        subjectLabel = new JLabel("Example Subject");
        subjectLabel.setFont(new Font("Centaur", Font.PLAIN, 18));
        subjectLabelsPanel.add(subjectLabel);

        messageTxtArea = new JLabel();
        messageTxtArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        messageTxtArea.setVerticalAlignment(JLabel.TOP);
        messageTxtArea.setBackground(Color.white);

        centerPanel.add(messageTxtArea, BorderLayout.CENTER);
        messageTxtArea.setBorder(BorderFactory.createLineBorder(Color.RED));
    }
}
