package LabTechs.Model;


import JDBC.User;

public class LabTechnician extends User {

    public LabTechnician(String username, String password, String email, String name, String surname, String sex, String userType) {
        super(username, password, email, name, surname, sex, "LabTechnician");
    }

    //TODO Send test results
    //TODO Take test requests
}
