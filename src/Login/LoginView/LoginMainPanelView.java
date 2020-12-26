package Login.LoginView;

import javax.swing.JPanel;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginMainPanelView extends JPanel {
    private JLayeredPane layeredPane;
    private SignupPanelView signupPanelView;
    private ForgotPasswordPanel forgotPasswordPanel;
    private LoginPanelView loginPanelView;

    public void switchPanels( JPanel panel ) {
        layeredPane.removeAll();
        layeredPane.add(panel);
        layeredPane.repaint();
        layeredPane.revalidate();
    }

    /**
     * Create the panel.
     */
    public LoginMainPanelView() {
        setLayout(new BorderLayout(0, 0));

        signupPanelView = new SignupPanelView();
        forgotPasswordPanel = new ForgotPasswordPanel();
        loginPanelView = new LoginPanelView();

        layeredPane = new JLayeredPane();
        layeredPane.setLayout(new CardLayout(0, 0));
        layeredPane.add( loginPanelView, "name_182432351255700" );

        layeredPane.add(signupPanelView, "name_182432387677200");

        layeredPane.add(forgotPasswordPanel, "name_182432415044900");

        add(layeredPane, BorderLayout.CENTER);

        //Signup button action listener.
        loginPanelView.getSignupButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels( signupPanelView);
            }
        });

        //Forgot your password label action listener.
        loginPanelView.getForgotLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchPanels( forgotPasswordPanel );
            }
        });

        //signupPanelView action listeners.

        //Return button action listener.
        signupPanelView.getReturnButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels( loginPanelView);
            }
        });

        //Create Button action listener.
        signupPanelView.getCreateButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //This action listener creates the patient with given info.
                String patientName = signupPanelView.getNameTxtField().getText();
                String patientSurname = signupPanelView.getSurnameTxtField().getText();
                String email = signupPanelView.getMailTxtField().getText();
                char[] password = signupPanelView.getPasswordField().getPassword();
                char[] confirmPassword = signupPanelView.getConfirmPasswordField().getPassword();

                //TODO here you will create a patient with these info.
                switchPanels( loginPanelView);
            }
        });

        //ForgotPasswordPanel action listeners.

        //ReturnButton which returns to the main panel.
        forgotPasswordPanel.getReturnButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanels( loginPanelView);
            }
        });

        //ResetButton which resets the passwords
        forgotPasswordPanel.getResetButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userMail = forgotPasswordPanel.getMailTextField().getText();
                //TODO Send an email to the patient and reset the password.

                switchPanels( loginPanelView);
            }
        });

        //loginPanelView action listeners.
        loginPanelView.getLoginButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = loginPanelView.getUsernameTextField().getText();
                char[] password = loginPanelView.getPasswordField().getPassword();

                //TODO this will be the login part
            }
        });



    }

}
