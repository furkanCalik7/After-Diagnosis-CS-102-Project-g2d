package Doctor.Model;

import JDBC.MySQLAccess;
import JDBC.User;

import java.sql.Date;
import java.util.ArrayList;

public class PatientInfoCard extends User {

    private int age;
    private Date dob;
    private String bloodType;
    private String allergies;
    private String surgeries;
    private MySQLAccess access;
    private ArrayList<Drug> drugs;

    public PatientInfoCard(String username, String userType, String password, String email, String name, String surname, String sex) {
        super(username, userType, password, email, name, surname, sex);
        drugs = access.getDrugs(this.getUsername());
        updatePatientInfo();
    }

    public void updatePatientInfo() {
        access = new MySQLAccess();
        ArrayList<Object> dataList = access.getPatientInfo(getUsername());
        if(dataList.size() > 0) {
            dob = (Date) dataList.get(0);
            bloodType = (String) dataList.get(1);
            age = (Integer) dataList.get(2);
            allergies = (String) dataList.get(3);
            surgeries = (String) dataList.get(4);
        }
    }
}
