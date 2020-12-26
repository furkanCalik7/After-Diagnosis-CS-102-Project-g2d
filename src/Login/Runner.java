package Login;

import Login.LoginView.LoginMainPanelView;

import javax.swing.*;
import java.awt.*;

public class Runner {
    public static void main(String[] args) {

        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("Login Screen");
        jFrame.setSize(600,450);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jFrame.setLocation(dim.width/2-jFrame.getSize().width/2, dim.height/2-jFrame.getSize().height/2);

        LoginMainPanelView loginMainPanelView = new LoginMainPanelView();
        jFrame.setContentPane(loginMainPanelView);
        jFrame.setVisible(true);


    }
}
