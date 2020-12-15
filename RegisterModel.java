import JDBC.dbConnection;

import java.sql.Connection;

public class RegisterModel {

    Connection connect;

    public RegisterModel() {
        connect = null;
    }

    public boolean isRegister(String username, String password, String email, String name, String surname, String sex) {
        MySQLAccess access = new MySQLAccess();
        try {
            access.readDataBase(new Patient(username, password, email, name, surname, sex));
            return true;
        } catch (Exception e) {
            System.out.println("Username already exists");
        }
        return false;
    }
}
