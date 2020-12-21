package JDBC;


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
        MySQLAccess mySQLAccess = new MySQLAccess();
//        Patient patient = (Patient) mySQLAccess.getUser("crazyaslan5");
//        Date date = Date.valueOf("1976-01-05");
//        patient.setPatientInfo(date, "0RH+", 44, "polen", "bypass", "Stomach ache");
//        System.out.println(patient);
//        System.out.println(patient.getAppointmentDates());
        Doctor doctor = mySQLAccess.getDoctorByUsername("MichealJackson");
        System.out.println("size" + doctor.getPatientSlots().size());
        System.out.println(doctor.getId());
    }
}
