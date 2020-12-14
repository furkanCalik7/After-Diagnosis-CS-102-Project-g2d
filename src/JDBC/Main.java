package JDBC;


import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        MySQLAccess mySQLAccess = new MySQLAccess();
        System.out.println(mySQLAccess.getUserByName("JohnSmith"));
        System.out.println(mySQLAccess.getUserId("JohnSmith"));
        Message message = new Message(mySQLAccess.getUserByName("user123"),mySQLAccess.getUserByName("JohnSmith")
        , "TrialSubject", "Bu bir cs102 projesi deneme messagedir.", 1);
        System.out.println(message);
    }
}
