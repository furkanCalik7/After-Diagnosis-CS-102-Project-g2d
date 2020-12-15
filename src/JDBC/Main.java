package JDBC;


import Doctor.Model.Doctor;
import LabTechs.Model.Test;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        MySQLAccess mySQLAccess = new MySQLAccess();


       // Message message = Message.newMessage("JamesQueen","JohnSmith","TrialSubject", "2.mesaj");
       // Message.sendMessage(message);

        ArrayList<Message> messageArraylist = mySQLAccess.getIncomingMessage("JamesQueen");
        ArrayList<Message> messages = mySQLAccess.getOutGoingMgessage("JohnSmith");


        Doctor doctor = mySQLAccess.getDoctorByUsername("JamesQueen");
        for(Message message1: doctor.getInbox()){
            System.out.println(message1.toString());
        }


//        File file = new File("C:\\Users\\mpmcs\\Desktop\\a.pdf");
//        System.out.println(file.getTotalSpace());
//        Test test = Test.newTest("user123","JamesQueen","Deneme",
//               "user123",file);
//        System.out.println(Test.sendTest(test));
    }
}
