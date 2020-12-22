package JDBC;


import Admin.model.Admin;
import Doctor.Model.Doctor;
import Doctor.Model.DoctorInfoCard;
import Doctor.Model.PatientSlot;
import Patient.Model.Patient;
import Patient.Model.PatientInfoCard;
import LabTechs.Model.TestRequest;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {

        MySQLAccess access = new MySQLAccess();
        Patient p = (Patient) access.getUser("AlanGreen");
        System.out.println(p.getDrugs());
    }
}
