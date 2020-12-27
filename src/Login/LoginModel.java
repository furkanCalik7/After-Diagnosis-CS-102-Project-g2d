package Login;

import JDBC.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginModel {

    private Connection connect;

    public LoginModel() {
        connect = null;
    }
    public boolean isLogin(String username, String password, String usertype) {
        try {
            connect = dbConnection.getConnection();
            String sql = "SELECT user_id, username, password, email, name, surname FROM user WHERE username = ?" +
                    "AND password = ? AND user_type = ?";
            PreparedStatement pr = connect.prepareStatement(sql);
            pr.setString(1, username);
            pr.setString(2, password);
            pr.setString(3, usertype);
            ResultSet rs = pr.executeQuery();
            if(rs.next()) {
                return true;
            }
        } catch(Exception e) {
            System.out.print(e);
        }
        return false;
    }
}
