package LabTechs.Model;

import JDBC.MySQLAccess;
import Patient.Model.PatientInfoCard;

public class TestRequest {
    private String test_name;
    private PatientInfoCard patient;
    private String doctor_username;
    private String lab_tech_username;

    public TestRequest(String test_name, PatientInfoCard patient, String doctor_username, String lab_tech_username){
        this.test_name =  test_name;
        this.patient = patient;
        this.doctor_username = doctor_username;
        this.lab_tech_username = lab_tech_username;
    }
    public static TestRequest newTest(String test_name, PatientInfoCard patient, String doctor_username, String lab_tech_username){
        return new TestRequest(test_name, patient, doctor_username,lab_tech_username);
    }
    public boolean sendTestRequest (){
        MySQLAccess mySQLAccess = new MySQLAccess();
        return mySQLAccess.addTestRequest(this);
    }

    public String getLab_tech_username() {
        return lab_tech_username;
    }

    public String getTest_name() {
        return test_name;
    }

    public PatientInfoCard getPatient() {
        return patient;
    }

    public String getDoctor_username() {
        return doctor_username;
    }
}
