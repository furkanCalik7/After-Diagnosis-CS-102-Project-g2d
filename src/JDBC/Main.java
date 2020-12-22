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
        Doctor d = access.getDoctorByUsername("JuliaRoberts");
        Date d1 = Date.valueOf("2020-12-22");
        Date d2 = Date.valueOf("2021-12-22");
        d.prescribeDrug("AlanGreen", "Apranax", true, false, false, false, d1, d2, 2);


    }
}
