package JDBC;

import java.sql.*;

public class dbConnection {


    public static Connection getConnection() throws SQLException {
        String uname = "qqkbztev_furkan";
        String password = "Cs102_";
        String url = "jdbc:mysql://88.211.101.188:3306/qqkbztev_Hospital?serverTimezone=UTC";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, uname, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
}
