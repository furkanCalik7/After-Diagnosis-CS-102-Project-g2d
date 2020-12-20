package LabTechs.Model;


import JDBC.Message;
import Admin.model.User;
import JDBC.MySQLAccess;

import java.io.File;
import java.util.ArrayList;

public class LabTechnician extends User {

    private ArrayList<Test> tests;
    private ArrayList<TestRequest> testRequests;
    private MySQLAccess mySQLAccess;

    public LabTechnician(String username,String password, String email,String name, String surname, String sex) {
        super(username, password, email, name, surname, sex, "LabTechnician");
        testRequests = mySQLAccess.getTestRequest(getUsername());
    }


    public void sendTestResult(Test test) {
        test.sendTest();
    }

    public Test createNewTest(String receiver_username, String test_name, String patient_username, File file) {
        return Test.newTest(receiver_username, this.getUsername(), test_name, patient_username, file);
    }

    public ArrayList<Test> getTests() {
        return tests;
    }

    public ArrayList<TestRequest> getTestRequests() {
        return testRequests;
    }
}


