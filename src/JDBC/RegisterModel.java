package JDBC;

import JDBC.MySQLAccess;
import Login.LoginView.SignupPanelView;
import Patient.Model.Patient;

import javax.swing.*;
import java.sql.Connection;

public class RegisterModel {

    Connection connect;
    private SignupPanelView panel;

    public RegisterModel() {
        connect = null;
    }

    public boolean register(String username, String password, String email, String name, String surname, String sex) {
        MySQLAccess access = new MySQLAccess();
        try {
            access.addUser(new Patient(username, password, email, name, surname, sex));
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(panel, "This username already exits.");
        }
        return false;
    }
}
