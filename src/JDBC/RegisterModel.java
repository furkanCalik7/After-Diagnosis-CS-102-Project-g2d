package JDBC;

import JDBC.MySQLAccess;
import Patient.Model.Patient;

import javax.swing.*;
import java.sql.Connection;

public class RegisterModel {

    Connection connect;

    public RegisterModel() {
        connect = null;
    }

    public boolean isRegister(String username, String password, String email, String name, String surname, String sex) {
        MySQLAccess access = new MySQLAccess();
        try {
            access.addUser(new Patient(username, password, email, name, surname, sex));
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "This username already exits.");
        }
        return false;
    }
}
