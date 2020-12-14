import java.sql.Date;
import java.util.ArrayList;

public class Patient extends User {

    ArrayList<Doctor> doctors;
    // ArrayList<Appointment> appointments;
    // ArrayList<Drug> drugs:
    int age;
    Date dob;
    String bloodType;
    String allergies;
    String surgeries;

    public Patient(String username, String password, String email, String name, String surname, String sex) {
        super(username, "Patient", password, email, name, surname, sex);
        updateDoctors();
        updatePatient();
    }

    public void updatePatient() {
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

    public void setBloodType(String bloodType) {
        MySQLAccess access = new MySQLAccess();
        access.readBloodType(username, bloodType);
        this.bloodType = bloodType;
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
        System.out.println(doctors);
    }

    /*public addAppointment(Doctor d, Date date, Time start_time, Time end_time) {
       // appointment yarat
       // arrayliste ekle


    }

    public seeAppointmentDates():

    sendMessages():void


    setName(name):String
    setActivity(int):void*/


    public boolean sendChangeAppointmentRequest(Doctor d) {
        return true;
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
