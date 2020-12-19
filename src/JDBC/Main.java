package JDBC;


import Doctor.Model.Doctor;
import Doctor.Model.PatientSlot;
import Patient.Model.PatientInfoCard;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        MySQLAccess mySQLAccess = new MySQLAccess();

        Doctor doctor = mySQLAccess.getDoctorByUsername("MichealJackson");

        ArrayList<PatientSlot> patientInfoCards = doctor.getPatientSlots();

        for(PatientSlot patientInfoCard:patientInfoCards){
            System.out.println(patientInfoCard.toString());
        }
    }
}
