package JDBC;


import Doctor.Model.Doctor;
import LabTechs.Model.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        MySQLAccess mySQLAccess = new MySQLAccess();


       // Message message = Message.newMessage("JamesQueen","JohnSmith","TrialSubject", "2.mesaj");
       // Message.sendMessage(message);


        ArrayList<Test> tests = mySQLAccess.getTestOfDoctor("user123");

        for(Test test:tests){
            System.out.println(test);
        }
        Path path = Paths.get("C:\\Users\\mpmcs\\Desktop");
        tests.get(0).downloadTest(path);



//        File file = new File("C:\\Users\\mpmcs\\Desktop\\a.pdf");
//        System.out.println(file.getTotalSpace());
//        Test test = Test.newTest("user123","JamesQueen","Deneme",
//               "user123",file);
//        System.out.println(Test.sendTest(test));
    }
}
