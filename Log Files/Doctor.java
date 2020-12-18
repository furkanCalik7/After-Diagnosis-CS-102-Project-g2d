import java.util.ArrayList;

//This is the Doctor class that implements User class
//@author Bilgehan Sandikci
//@Date 17.12.2020

public class Doctor extends User {

    private ArrayList<Patient> patients;
    private ArrayList<Session> schedule;
    private ArrayList<Appointment> appointments;
    private ArrayList<String> activeCodes;


    public Doctor(String userName, String password, String email, String name, String surName) {
        super(userName, password, email, name, surName);
    }

    public void createCodesForPatients(){
        //Todo
    }

    public boolean addPatient( Patient patient ){

        if( patient == null )
            return false;

        patients.add( patient );
        return true;

    }

    public void createAppointment( Date interval ){
        //ToDo
    }
}
