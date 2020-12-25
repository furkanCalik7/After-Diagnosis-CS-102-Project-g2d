package Admin.model;

import AdminViews.AddWorkerMainPanel;
import Doctor.Model.*;
import JDBC.*;
import LabTechs.Model.LabTechnician;
import LabTechs.Model.Test;
import LabTechs.Model.*;
import Patient.Model.Code;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Admin extends User {

    private AddWorkerMainPanel addWorkerPanel;

    public Admin(String username, String password, String email, String name, String surname, String sex) {
        super(username, "Admin", password, email, name, surname, sex);
    }

    public Admin(int user_id, String username, String password, String email, String name, String surname, String sex) {
        super(user_id, username, "Admin", password, email, name, surname, sex);
    }

    public boolean addDoctor(String name, String surname, String email, String sex, String speciality) {
        Code code = Code.newCode();
        String password = code.getCode_id();
        Doctor d = new Doctor(name + surname, password, email, name, surname, sex, speciality);
        MySQLAccess access = new MySQLAccess();
        try {
            access.addUser(d);
            JOptionPane.showMessageDialog(addWorkerPanel, "New worker is added with password: " + password);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addLabTech(String name, String surname, String email, String sex) {
        Code code = Code.newCode();
        String password = code.getCode_id();
        LabTechnician l = new LabTechnician(name + surname, password, email, name, surname, sex);
        MySQLAccess access = new MySQLAccess();
        try {
            access.addUser(l);
            JOptionPane.showMessageDialog(addWorkerPanel, "New worker is added with password: " + password);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<User> searchWorker(String name) {
        MySQLAccess access = new MySQLAccess();
        return access.findWorkerByName(getUsername());
    }

    public ArrayList<DoctorInfoCard> seeDoctors() {
        MySQLAccess access = new MySQLAccess();
        return access.getAllDoctors();
    }

    public ArrayList<LabTechnician> seeLabTechs() {
        MySQLAccess access = new MySQLAccess();
        return access.getAllLabTechs();
    }

    public ArrayList<UserInfoCard> seeAllWorkers() {
        MySQLAccess access = new MySQLAccess();
        return access.getAllWorkers();
    }


}
