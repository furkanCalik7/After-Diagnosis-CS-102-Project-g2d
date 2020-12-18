package Doctor.Model;

import Appointment.Appointment;
import JDBC.Message;
import JDBC.MySQLAccess;
import JDBC.User;

import java.lang.reflect.Array;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Doctor extends User {

    private String speciality;
    private ArrayList<PatientSlot> patientSlots;
    private MySQLAccess mySQLAccess;
    private ArrayList<Appointment> appointments;
    private ArrayList<Message> inbox;
    private ArrayList<Message> outbox;
    private ArrayList<Timestamp> availableTimes;


    public Doctor(String username, String password, String email, String name, String surname, String sex, String speciality) {
        super(username, "Doctor", password, email, name, surname, sex);
        this.speciality = speciality;
        mySQLAccess = new MySQLAccess();
        updateInbox();
        updateOutbox();
        availableTimes = mySQLAccess.getAvailableDates(this);
    }


    public ArrayList<Timestamp> getAvailableTimes() {
        return availableTimes;
    }

    public void setAvailableTimes(ArrayList<Timestamp> availableTimes) {
        this.availableTimes = availableTimes;
    }
    public boolean addAvailableTimes(Date date, Time time){
        availableTimes.add(new Timestamp(date.getTime() + time.getTime()));
        return mySQLAccess.readAvailableTimes(this,date,time);
    }


    public void sendMessages(String username, String subject, String content) {
        Message message = Message.newMessage(username, getUsername(), subject, content);
        message.sendMessage();
        updateOutbox();
    }

    public ArrayList<Message> getInbox() {
        return inbox;
    }

    public ArrayList<Message> getOutbox() {
            return outbox;
        }

    public void updateInbox() {
        inbox = mySQLAccess.getIncomingMessage(this.getUsername());
    }

    public void updateOutbox() {
        outbox = mySQLAccess.getOutGoingMgessage(this.getUsername());
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                ", username = " + super.getUsername() + '\'' +
                ", password = " + super.getPassword() + '\'' +
                ", email = " + super.getEmail() + '\'' +
                ", name = " + super.getName() + '\'' +
                ", surname = " + super.getSurname() + '\'' +
                ", sex = " + super.getSex() + '\'' +
                ", speciality = '" + speciality + '\'' +
                '}';
    }
}
