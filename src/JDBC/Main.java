package JDBC;


import Doctor.Model.Doctor;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        MySQLAccess mySQLAccess = new MySQLAccess();

        Doctor doctor = mySQLAccess.getDoctorByUsername("JamesQueen");
        System.out.println(doctor.toString());

        for(Message message:doctor.getInbox()){
            System.out.println(message.toString());
        }
    }
}
