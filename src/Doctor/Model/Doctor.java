package Doctor.Model;

import JDBC.Message;
import JDBC.MySQLAccess;
import JDBC.User;

import java.util.ArrayList;

public class Doctor extends User {

     private String speciality;
     //private ArrayList<PatientSlot> patientSlots;
     private MySQLAccess mySQLAccess;
   //  private ArrayList<Appointment> appointments;
    private ArrayList<Message> inbox;
    private ArrayList<Message> outBox;


    public Doctor(String username, String password, String email, String name, String surname, String sex, String speciality){
        super(username,password,email,name,surname,sex,"Doctor");
        this.speciality = speciality;
        mySQLAccess = new MySQLAccess();
        inbox = mySQLAccess.getIncomingMessage(this.getUsername());
        outBox = mySQLAccess.getOutGoingMgessage(this.getUsername());
    }


    public ArrayList<Message> getInbox() {
        return inbox;
    }

    public ArrayList<Message> getOutBox() {
        return outBox;
    }

    public void updateInbox(){
        inbox = mySQLAccess.getIncomingMessage(this.getUsername());
    }
    public void updateOutbox(){
        outBox = mySQLAccess.getOutGoingMgessage(this.getUsername());
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
