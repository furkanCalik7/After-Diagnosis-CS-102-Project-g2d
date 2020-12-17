import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Patient extends User {

    private ArrayList<Doctor> doctors;
    private ArrayList<Appointment> appointments;
    private ArrayList<Message> inbox;
    private ArrayList<Message> outBox;
    ArrayList<Drug> drugs;
    private int age;
    private Date dob;
    private String bloodType;
    private String allergies;
    private String surgeries;


    public Patient(String username, String password, String email, String name, String surname, String sex) {
        super(username, "Patient", password, email, name, surname, sex);
        updateDoctors();
        updatePatientInfo();
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

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public ArrayList<Message> getInbox() {
        return inbox;
    }

    public ArrayList<Message> getOutBox() {
        return outBox;
    }

    public void updatePatientInfo() {
        MySQLAccess access = new MySQLAccess();
        PatientInfoCard infoCard = access.getPatientInfo(username);
        dob = infoCard.getDob();
        bloodType = infoCard.getBloodType();
        age = infoCard.getAge();
        allergies = infoCard.getAllergies();
        surgeries = infoCard.getSurgeries();
    }

    public void setPatientInfo(Date dob, String bloodType, int age, String allergies, String surgeries) {
        MySQLAccess access = new MySQLAccess();
        access.readPatientInfo(username, dob, bloodType, age, allergies, surgeries);
        this.dob = dob;
        this.bloodType = bloodType;
        this.age = age;
        this.allergies = allergies;
        this.surgeries = surgeries;
    }

    public boolean addDoctor() {
        //Code will be passed
        String code = "ASDFGH";
        //
        MySQLAccess access = new MySQLAccess();
        if(!access.isCodeUsed(code)) {
            if(access.connectToDoctor(username, code)) {
                updateDoctors();
                return true;
            }
        }
        return false;
    }


    public void updateDoctors() {
        MySQLAccess access = new MySQLAccess();
        doctors = access.getDoctors(username);
    }

    public void addAppointment(Doctor d, Date date, Time start_time, Time end_time) {
        MySQLAccess access = new MySQLAccess();
        Appointment app = new Appointment(d.username, username, date, start_time, end_time);
        appointments.add(app);
        access.readAppointment(username, d.getUserName(), date, start_time, end_time);

    }

    public void updateAppointments() {
        MySQLAccess access = new MySQLAccess();
        appointments = access.getAppointments(this);
    }

    public ArrayList<Timestamp> seeAvailableDates(Doctor d) {
        MySQLAccess access = new MySQLAccess();
        return access.getAvailableDates(d);
    }

    public void updateInbox(){
        MySQLAccess access = new MySQLAccess();
        inbox = access.getIncomingMessage(username);
    }

    public void updateOutbox(){
        MySQLAccess access = new MySQLAccess();
        outBox = access.getOutGoingMgessage(username);
    }

    public void updateDrugs() {
        MySQLAccess access = new MySQLAccess();
        drugs = access.getDrugs(username);
    }



    public void sendMessages(Doctor d, String subject, String content) {
        Message message = Message.newMessage(d.getUserName(), username, subject, content);
        message.sendMessage();
        updateOutbox();
    }

   /* public boolean sendChangeAppointmentRequest(Doctor d) {
        return true;
    }
*/

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