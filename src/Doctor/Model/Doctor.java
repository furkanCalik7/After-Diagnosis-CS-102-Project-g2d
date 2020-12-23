package Doctor.Model;

import Admin.model.User;
import Appointment.Appointment;
import JDBC.Message;
import JDBC.MySQLAccess;
import LabTechs.Model.TestRequest;
import Patient.Model.Code;
import Patient.Model.PatientInfoCard;

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
    }

    public Doctor(int user_id, String username, String password, String email, String name, String surname, String sex, String speciality) {
        super(user_id, username, "Doctor", password, email, name, surname, sex);
        this.speciality = speciality;
        mySQLAccess = new MySQLAccess();
        updateInbox();
        updateOutbox();
        availableTimes = mySQLAccess.getAvailableDates(this);
        approvedAppointments = mySQLAccess.getApprovedAppointmentOfDoctor(this);
        waitingAppointments = mySQLAccess.getWaitingAppointmentOfDoctor(this);
        patientSlots = mySQLAccess.getPatientsOfDoctor(this);
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

    public void prescribeDrug(String patientUsername, String name, boolean isMorning, boolean isAfternoon,
                              boolean isEvening, boolean isHungry, Date startDate, Date finalDate, int dose) {

        Drug drug = new Drug(patientUsername, name, isMorning, isAfternoon, isEvening, isHungry, startDate, finalDate,
                dose);
        mySQLAccess.addDrug(drug);
    }

    public boolean addAvailableTimes(Date date, Time time) {
        availableTimes.add(new Timestamp(date.getTime() + time.getTime()));
        return mySQLAccess.readAvailableTimes(this, date, time);
    }

    public Code createCodeForPatient() {
        Code code = Code.newCode(this.getUsername());
        mySQLAccess.addCode(code);
        return code;
    }

    public void sendBloodRequest(String bloodtype) {
        String subject = "Urgent blood necessity. " + bloodtype + " required!";
        String content = bloodtype + " required!! If you have acquaintances to give certain blood type, please notify them to donate blood";
        for (PatientSlot d : patientSlots) {
            Message message = Message.newMessage(d.getPatientInfo().getUsername(), getUsername(), subject, content);
            message.sendMessage();
        }
    }


    public void updateDoctorInformation() {
        mySQLAccess.updateDoctorInformationOnDatabase(this);
    }

    public void approveAppointment(Appointment appointment) {
        mySQLAccess.approveAppointment(appointment);
    }

    public ArrayList<PatientSlot> getPatientSlots() {
        return patientSlots;
    }

    public ArrayList<Appointment> getApprovedAppointments() {
        return approvedAppointments;
    }

    public ArrayList<Appointment> getWaitingAppointments() {
        return waitingAppointments;
    }

    public boolean sendTestRequest(String test_name, PatientInfoCard patient, String lab_tech_username) {
        TestRequest newTest = TestRequest.newTest(test_name, patient, getUsername(), lab_tech_username);
        return mySQLAccess.addTestRequest(newTest);
    }
}
