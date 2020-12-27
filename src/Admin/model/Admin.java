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

    private ArrayList<DoctorInfoCard> doctors;
    private ArrayList<LabTechnician> labTechs;
    private ArrayList<UserInfoCard> workers;


    private AddWorkerMainPanel addWorkerPanel;

    public Admin(String username, String password, String email, String name, String surname, String sex) {
        super(username, "Admin", password, email, name, surname, sex);
        updateDoctors();
        updateLabTechs();
        updateWorkers();
    }

    public Admin(int user_id, String username, String password, String email, String name, String surname, String sex) {
        super(user_id, username, "Admin", password, email, name, surname, sex);
        updateDoctors();
        updateLabTechs();
        updateWorkers();
    }


    public ArrayList<DoctorInfoCard> getDoctors() {
        return doctors;
    }

    public ArrayList<UserInfoCard> getWorkers() {
        return workers;
    }

    public ArrayList<LabTechnician> getLabTechs() {
        return labTechs;
    }

    public boolean addDoctor(String name, String surname, String email, String sex, String speciality) {
        Code code = Code.newCode();
        String password = code.getCode_id();
        Doctor d = new Doctor(name + surname, password, email, name, surname, sex, speciality);
        MySQLAccess access = new MySQLAccess();
        EmailUtil emailUtil = new EmailUtil();
        emailUtil.sendEmail(email, "Account created", "Your After Diagnosis account has been created." +
                " Your password is " + password);
        try {
            access.addUser(d);
            updateViewers();
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
        EmailUtil emailUtil = new EmailUtil();
        emailUtil.sendEmail(email, "Account created", "Your After Diagnosis account has been created." +
                " Your password is " + password);
        try {
            access.addUser(l);
            updateViewers();
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

    public void updateLabTechs() {
        MySQLAccess access = new MySQLAccess();
        labTechs =  access.getAllLabTechs();
    }

    public void updateWorkers() {
        MySQLAccess access = new MySQLAccess();
        workers = access.getAllWorkers();
    }

    public void updateDoctors() {
        MySQLAccess access = new MySQLAccess();
        doctors = access.getAllDoctors();
    }

}
