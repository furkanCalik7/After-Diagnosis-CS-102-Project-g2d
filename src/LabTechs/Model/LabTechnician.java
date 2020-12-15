package LabTechs.Model;


import JDBC.Message;
import JDBC.User;

import java.util.ArrayList;

public class LabTechnician extends User {

    private ArrayList<Test> tests;
    private ArrayList<Message> inbox;
    private ArrayList<Message> outbox;

    public LabTechnician(java.lang.String username, java.lang.String password, java.lang.String email, java.lang.String name, java.lang.String surname, java.lang.String sex, java.lang.String userType) {
        super(username, password, email, name, surname, sex, "LabTechnician");
    }

    //TODO Send test results
    //TODO Take test requests
}
