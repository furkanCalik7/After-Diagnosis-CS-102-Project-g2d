import JDBC.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginModel {

    public LoginModel() {

    }
    public boolean isLogin(String username, String password) {
        try {
            Connection connect = dbConnection.getConnection();
            String sql = "SELECT username, password FROM user WHERE username = ?" +
                    "AND password = ?";
            PreparedStatement pr = connect.prepareStatement(sql);
            pr.setString(1, username);
            pr.setString(2, password);
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
