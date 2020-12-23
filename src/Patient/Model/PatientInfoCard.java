package Patient.Model;
import Admin.model.UserInfoCard;
import Doctor.Model.Drug;
import JDBC.MySQLAccess;

import java.sql.Date;
import java.util.ArrayList;

public class PatientInfoCard extends UserInfoCard {

    private int age;
    private Date dob;
    private String bloodType;
    private String allergies;
    private String surgeries;
    private String complaint;
    private ArrayList<Drug> drugs;
    MySQLAccess mySQLAccess;

    public PatientInfoCard(int user_id,String username, String email, String name, String surname, String sex, int age,
                           Date dob, String bloodType, String allergies, String surgeries, String complaint) {
        super(user_id,username, email, name, surname, sex);
        this.age = age;
        this.dob = dob;
        this.bloodType = bloodType;
        this.allergies = allergies;
        this.surgeries = surgeries;
        this.complaint = complaint;
        mySQLAccess = new MySQLAccess();
        this.drugs = mySQLAccess.getDrugs(getUsername());
    }

    public PatientInfoCard(int age, Date dob, String bloodType, String allergies, String surgeries) {
        super(0,"", "", "", "", "");
        this.age = age;
        this.dob = dob;
        this.bloodType = bloodType;
        this.allergies = allergies;
        this.surgeries = surgeries;
        mySQLAccess = new MySQLAccess();
        this.drugs = mySQLAccess.getDrugs(getUsername());
    }

    public String getComplaint() {
        return complaint;
    }

    public String getSurgeries() {
        return surgeries;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String getAllergies() {
        return allergies;
    }

    public Date getDob() {
        return dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setSurgeries(String surgeries) {
        this.surgeries = surgeries;
    }

    public ArrayList<Drug> getDrugs() {
        return drugs;
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        return "PatientInfoCard{" +
                "age=" + age +
                ", dob=" + dob +
                ", bloodType='" + bloodType + '\'' +
                ", allergies='" + allergies + '\'' +
                ", surgeries='" + surgeries + '\'' +
                '}';
    }
}
