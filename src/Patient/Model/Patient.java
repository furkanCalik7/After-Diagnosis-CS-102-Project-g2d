package Patient.Model;

import Appointment.Appointment;
import Doctor.Model.Doctor;
import Doctor.Model.DoctorInfoCard;
import Doctor.Model.Drug;
import JDBC.Message;
import JDBC.MySQLAccess;
import Admin.model.User;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Patient extends User {

    private final int STATUS_GOOD = 1;
    private final int STATUS_OK = 2;
    private final int STATUS_SICK = 3;
    private ArrayList<DoctorInfoCard> doctors;
    private ArrayList<Appointment> appointments;
    ArrayList<Drug> drugs;
    private int age;
    private Date dob;
    private String bloodType;
    private String allergies;
    private String surgeries;


    public Patient(String username, String password, String email, String name, String surname, String sex) {
        super(username, "Patient", password, email, name, surname, sex);
        updateDoctors();
     //   updatePatientInfo();
        updateAppointments();
        updateInbox();
        updateOutbox();
        updateDrugs();
    }

    public int getAge() {
        return age;
    }

    public Date getDob() {
        return dob;
    }

    public String getAllergies() {
        return allergies;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String getSurgeries() {
        return surgeries;
    }

    public ArrayList<Appointment> getAppointmentDates() {
        return appointments;
    }

    public ArrayList<Drug> getDrugs() {
        return drugs;
    }

    public ArrayList<DoctorInfoCard> getDoctors() {
        return doctors;
    }

//    public void updatePatientInfo() {
//        MySQLAccess access = new MySQLAccess();
//        PatientInfoCard infoCard = access.getPatientInfo(getUsername());
//        if(infoCard != null) {
//            dob = infoCard.getDob();
//            bloodType = infoCard.getBloodType();
//            age = infoCard.getAge();
//            allergies = infoCard.getAllergies();
//            surgeries = infoCard.getSurgeries();
//        }
//    }

    public void setPatientInfo(Date dob, String bloodType, int age, String allergies, String surgeries) {
        MySQLAccess access = new MySQLAccess();
        access.readPatientInfo(getUsername(), dob, bloodType, age, allergies, surgeries);
        this.dob = dob;
        this.bloodType = bloodType;
        this.age = age;
        this.allergies = allergies;
        this.surgeries = surgeries;
    }

    public boolean addDoctor(Code c) {
        String code = c.getCode_id();
        MySQLAccess access = new MySQLAccess();
        if(!access.isCodeUsed(code)) {
            if(access.connectToDoctor(getUsername(), code)) {
                updateDoctors();
                return true;
            }
        }
        return false;
    }


    public void updateDoctors() {
        MySQLAccess access = new MySQLAccess();
        doctors = access.getDoctors(getUsername());
    }

    public void addAppointment(DoctorInfoCard d, Date date, Time start_time, Time end_time) {
        MySQLAccess access = new MySQLAccess();
        Appointment app = new Appointment(d.getDoctorUsername(), getUsername(), date, start_time, end_time);
        appointments.add(app);
        access.readAppointment(getUsername(), d.getDoctorUsername(), date, start_time, end_time);
    }

    public void updateAppointments() {
        MySQLAccess access = new MySQLAccess();
        appointments = access.getAppointments(this);
    }

    public ArrayList<Timestamp> seeAvailableDates(Doctor d) {
        MySQLAccess access = new MySQLAccess();
        return access.getAvailableDates(d);
    }

    public void updateDrugs() {
        MySQLAccess access = new MySQLAccess();
        drugs = access.getDrugs(getUsername());
    }

    //feedback
    public void giveFeedback(int status) {
        if(status == STATUS_SICK) {
            String subject = "Important: Health issue of a patient";
            String content = "Your patient, " + getName() + " " + getSurname() + " is feeling sick today.";
            for(DoctorInfoCard d: doctors) {
                Message message = Message.newMessage(d.getDoctorUsername(), getUsername(), subject, content);
                message.sendMessage();
            }
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Patient{" +
                "doctors=" + doctors +
                ", age=" + age +
                ", dob=" + dob +
                ", bloodType='" + bloodType + '\'' +
                ", allergies='" + allergies + '\'' +
                ", surgeries='" + surgeries + '\'' +
                '}';
    }
}
