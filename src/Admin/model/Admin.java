package Admin.model;

import Doctor.Model.*;
import JDBC.*;
import LabTechs.*;
import LabTechs.Model.LabTechnician;

import java.sql.SQLException;
import java.util.ArrayList;

public class Admin extends User {

    public Admin(String username, String password, String email, String name, String surname, String sex) throws SQLException {
        super(username, "Admin", password, email, name, surname, sex);
    }

    public boolean addDoctor(String name, String surname, String email, String sex, String speciality) throws SQLException {
        //generate code
        String password = "123";
        Doctor d = new Doctor(name + surname, password, email, name, surname, sex, speciality);
        MySQLAccess access = new MySQLAccess();
        try {
            access.addUser(d);
            return true;
        } catch (Exception e) {
            System.out.print(e);
        }
        return false;
    }

    public boolean addLabTech(String name, String surname, String email, String sex) {
        //generate code
        String password = "12345";
        LabTechnician l = new LabTechnician(name + surname, password, email, name, surname, sex);
        MySQLAccess access = new MySQLAccess();
        try {
            access.addUser(l);
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
