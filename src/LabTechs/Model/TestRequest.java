package LabTechs.Model;

import JDBC.MySQLAccess;
import Patient.Model.PatientInfoCard;

public class TestRequest {
    private String test_name;
    //private PatientInfoCard patient;
    private String patient_username;
    private String doctor_username;
    private String lab_tech_username;

    public TestRequest(String test_name, String patient_username, String doctor_username){
        this.test_name =  test_name;
        this.patient_username = patient_username;
        this.doctor_username = doctor_username;
    }
    public static TestRequest newTest(String test_name, String patient_username, String doctor_username){
        return new TestRequest(test_name, patient_username, doctor_username);
    }
    public boolean sendTestRequest (){
        MySQLAccess mySQLAccess = new MySQLAccess();
        return mySQLAccess.addTestRequest(this);
    }

    public String getTest_name() {
        return test_name;
    }

    public String getPatient() {
        return patient_username;
    }

    public String getDoctor_username() {
        return doctor_username;
    }
}
