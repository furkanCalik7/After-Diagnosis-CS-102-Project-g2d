package Patient.Model;
import Admin.model.UserInfoCard;

import java.sql.Date;

public class PatientInfoCard extends UserInfoCard {

    private int age;
    private Date dob;
    private String bloodType;
    private String allergies;
    private String surgeries;

    public PatientInfoCard(String username, String email, String name, String surname, String sex, int age,
                           Date dob, String bloodType, String allergies, String surgeries) {
        super(username, email, name, surname, sex);
        this.age = age;
        this.dob = dob;
        this.bloodType = bloodType;
        this.allergies = allergies;
        this.surgeries = surgeries;
    }

    public PatientInfoCard(int age, Date dob, String bloodType, String allergies, String surgeries) {
        super("", "", "", "", "");
        this.age = age;
        this.dob = dob;
        this.bloodType = bloodType;
        this.allergies = allergies;
        this.surgeries = surgeries;
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

    @Override
    public String toString() {
        return "PatientInfoCard{" +
                "age=" + age +
                ", dob=" + dob +
                ", bloodType='" + bloodType + '\'' +
                ", allergies='" + allergies + '\'' +
                ", surgeries='" + surgeries + '\'' +
                '}';
    }
}
