package LabTechs.Model;

import JDBC.MySQLAccess;

public class TestRequest {
    private String test_name;
    private PatientInfoCard patient;
    private String doctor_username;

    public TestRequest(String test_name, PatientInfoCard patient, String doctor_username){
        this.test_name =  test_name;
        this.patient = patient;
        this.doctor_username = doctor_username;
    }
    public TestRequest newTest(String test_name, PatientInfoCard patient, String doctor_username){
        return new TestRequest(test_name, patient, doctor_username);

    }
    public boolean sendTestRequest (){
        MySQLAccess mySQLAccess = new MySQLAccess();
        return mySQLAccess.addTestRequest(this);
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
