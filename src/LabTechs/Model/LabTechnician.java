package LabTechs.Model;


import Doctor.Model.Doctor;
import JDBC.Message;
import JDBC.User;

import java.io.File;
import java.util.ArrayList;

public class LabTechnician extends User {

    private ArrayList<Test> tests;
    private ArrayList<Message> inbox;
    private ArrayList<Message> outbox;

    public LabTechnician(java.lang.String username, java.lang.String password, java.lang.String email, java.lang.String name, java.lang.String surname, java.lang.String sex, java.lang.String userType) {
        super(username, password, email, name, surname, sex, "LabTechnician");
    }

    //TODO Send test results
    public void sendTestResult(Test test) {
        test.sendTest();
    }

    public Test createANewTest(String receiver_username, String test_name, String patient_username, File file) {
        return Test.newTest(receiver_username, this.getUsername(), test_name, patient_username, file);
    }
}
//TODO Take test requests

