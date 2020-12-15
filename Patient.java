import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Patient extends User {

    private ArrayList<Doctor> doctors;
    private ArrayList<Appointment> appointments;
    private ArrayList<Message> inbox;
    private ArrayList<Message> outBox;
    //ArrayList<Drug> drugs:
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
    }

    public void updatePatientInfo() {
        //TODO PatientInfoCard oluştur
        MySQLAccess access = new MySQLAccess();
        ArrayList<Object> dataList = access.getPatientInfo(username);
        if(dataList.size() > 0) {
            dob = (Date) dataList.get(0);
            bloodType = (String) dataList.get(1);
            age = (Integer) dataList.get(2);
            allergies = (String) dataList.get(3);
            surgeries = (String) dataList.get(4);
        }
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
        access.readAppointment(username, d.username, date, start_time, end_time);

    }

    public ArrayList<Appointment> getAppointmentDates() {
        return appointments;
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

    public void sendMessages(Doctor d, String subject, String content) {
        Message message = Message.newMessage(d.username, username, subject, content);
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
