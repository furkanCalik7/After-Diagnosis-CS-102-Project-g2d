package Login.LoginView;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class ForgotPasswordPanel extends JPanel {
    private JTextField textField;

    /**
     * Create the panel.
     */
    public ForgotPasswordPanel() {
        setLayout(new BorderLayout(0, 0));

        JPanel northPanel = new JPanel();
        northPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        add(northPanel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        northPanel.add(panel);

        JLabel topPromp = new JLabel("AFTER DIAGNOSIS");
        topPromp.setFont(new Font("Century", Font.BOLD, 20));
        panel.add(topPromp);

        JPanel mainPanel = new JPanel();
        add(mainPanel, BorderLayout.CENTER);

        JPanel centerPanel = new JPanel();
        centerPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        mainPanel.add(centerPanel);
        centerPanel.setLayout(new GridLayout(3, 0, 0, 0));

        JPanel promptPanel = new JPanel();
        promptPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        centerPanel.add(promptPanel);

        JLabel lblNewLabel = new JLabel("Enter Your Mail Address To Reset Your Password");
        lblNewLabel.setFont(new Font("Century", Font.PLAIN, 20));
        promptPanel.add(lblNewLabel);

        JPanel mailPanel = new JPanel();
        centerPanel.add(mailPanel);

        JPanel promptHolder = new JPanel();
        mailPanel.add(promptHolder);

        JLabel mailPrompt = new JLabel("Enter Your Mail:");
        mailPrompt.setFont(new Font("Centaur", Font.PLAIN, 20));
        promptHolder.add(mailPrompt);

        JPanel mailHolder = new JPanel();
        mailPanel.add(mailHolder);

        textField = new JTextField();
        mailHolder.add(textField);
        textField.setColumns(14);

        JPanel buttonPanel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) buttonPanel.getLayout();
        flowLayout.setAlignment(FlowLayout.RIGHT);
        centerPanel.add(buttonPanel);

        JButton btnNewButton = new JButton("Reset");
        btnNewButton.setFont(new Font("Century", Font.PLAIN, 20));
        buttonPanel.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Return");
        btnNewButton_1.setFont(new Font("Century", Font.PLAIN, 20));
        buttonPanel.add(btnNewButton_1);

    }

}
