package JDBC;


import Doctor.Model.Doctor;
import Doctor.Model.DoctorInfoCard;
import Doctor.Model.PatientSlot;
import Patient.Model.Patient;
import Patient.Model.PatientInfoCard;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        MySQLAccess mySQLAccess = new MySQLAccess();
        Patient patient = (Patient) mySQLAccess.getUser("crazyaslan5");
        System.out.println(patient);
        Doctor doctor = mySQLAccess.getDoctorByUsername("MichealJackson");
        System.out.println(patient.getAppointmentDates());
    }
}
