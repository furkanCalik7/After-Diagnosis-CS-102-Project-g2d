package Doctor.Model;

import Appointment.Appointment;
import JDBC.MySQLAccess;
import Admin.model.User;
import Patient.Model.Code;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Doctor extends User {

    private String speciality;
    private ArrayList<PatientSlot> patientSlots;
    private MySQLAccess mySQLAccess;
    private ArrayList<Appointment> approvedAppointments;
    private ArrayList<Appointment> waitingAppointments;
    private ArrayList<Timestamp> availableTimes;


    public Doctor(String username, String password, String email, String name, String surname, String sex, String speciality) {
        super(username, "Doctor", password, email, name, surname, sex);
        this.speciality = speciality;
        mySQLAccess = new MySQLAccess();
        updateInbox();
        updateOutbox();
        availableTimes = mySQLAccess.getAvailableDates(this);
        approvedAppointments = mySQLAccess.getApprovedAppointmentOfDoctor(this);
        waitingAppointments = mySQLAccess.getWaitingAppointmentOfDoctor(this);
    }

    public ArrayList<Timestamp> getAvailableTimes() {
        return availableTimes;
    }
    public void setAvailableTimes(ArrayList<Timestamp> availableTimes) {
        this.availableTimes = availableTimes;
    }
    public String getSpeciality() {
        return speciality;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }


    public boolean addAvailableTimes(Date date, Time time){
        availableTimes.add(new Timestamp(date.getTime() + time.getTime()));
        return mySQLAccess.readAvailableTimes(this,date,time);
    }

    public Code createCodeForPatient(){
        Code code = Code.newCode(this.getUsername());
        mySQLAccess.addCode(code);
        return code;
    }

    public void updateDoctorInformation(){
        mySQLAccess.updateDoctorInformationOnDatabase(this);
    }
    public void approveAppointment(Appointment appointment){
        mySQLAccess.approveAppointment(appointment);
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        return "Doctor{" +
                "speciality='" + speciality + '\'' +
                ", patientSlots=" + patientSlots +
                ", mySQLAccess=" + mySQLAccess +
                ", approvedAppointments=" + approvedAppointments +
                ", waitingAppointments=" + waitingAppointments +
                ", availableTimes=" + availableTimes +
                '}';
    }
}
