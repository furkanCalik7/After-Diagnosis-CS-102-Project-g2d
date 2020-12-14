package Appointment;

import Doctor.Model.Doctor;
import Patient.Model.Patient;

import java.sql.Time;
import java.sql.Date;


public class Appointment {
    final int NOT_APPROVED = 0;
    final int APPROVED =  1;

    private Doctor doctor;
    private Patient patient;
    private Date date;
    private Time start_time;
    private Time end_time;

    public Appointment(Doctor doctor, Patient patient, Date date, Time start_time, Time end_time) {
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        this.start_time = start_time;
        this.end_time = end_time;
    }

}
