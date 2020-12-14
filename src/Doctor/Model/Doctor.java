package Doctor.Model;

import JDBC.MySQLAccess;
import JDBC.User;
import Patient.Model.Patient;

import java.util.ArrayList;

public class Doctor extends User{

     private String speciality;
//     private ArrayList<PatientSlot> patientSlots;
     private MySQLAccess mySQLAccess;
     // private ArrayList<Appointment> appointments;

    public Doctor(String username, String password, String email, String name, String surname, String sex, String speciality){
        super(username,password,email,name,surname,sex,"Doctor");
        this.speciality = speciality;

        //TODO Complete the getPatientsOfDoctor
//        mySQLAccess = new MySQLAccess();
//        patients = mySQLAccess.getPatientsOfDoctor(this);
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
