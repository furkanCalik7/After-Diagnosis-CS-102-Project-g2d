import JDBC.dbConnection;

import java.lang.ref.WeakReference;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQLAccess {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase(User u) throws Exception {
        try {
            // Setup the connection with the DB
            connect = dbConnection.getConnection();

            // Statements allow to issue SQL queries to the database
            statement = connect.createStatement();
            // Result set get the result of the SQL query
            resultSet = statement
                    .executeQuery("select * from user");

            // PreparedStatements can use variables and are more efficient
            preparedStatement = connect
                    .prepareStatement("insert into user values (default, ?, ?, ?, ?, ?, ?, ?)");
            // "myuser, webpage, datum, summary, COMMENTS from feedback.comments");
            // Parameters start with 1

            preparedStatement.setString(2, u.username);
            preparedStatement.setString(3, u.password);
            preparedStatement.setString(4, u.name);
            preparedStatement.setString(5, u.surname);
            preparedStatement.setString(6, u.email);
            preparedStatement.setString(7, u.sex);

            if(u instanceof Patient) {
                preparedStatement.setString(1, "Patient");
            }
            if(u instanceof Doctor)
                preparedStatement.setString(1, "Doctor");

            preparedStatement.executeUpdate();

            preparedStatement = connect
                    .prepareStatement("SELECT user_id, user_type, username, password, name, surname, email, sex from user");
            resultSet = preparedStatement.executeQuery();
            writeResultSet(resultSet);

            if(u instanceof Patient) {
            }
            if(u instanceof Doctor)
                addDoctor((Doctor) u);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    private void addDoctor(Doctor d) {
        try {
            int user_id = 0;
            connect = dbConnection.getConnection();
            preparedStatement = connect
                    .prepareStatement("SELECT user_id from user WHERE username = ?");
            preparedStatement.setString(1, d.getUserName());
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                user_id = resultSet.getInt("user_id");
            preparedStatement = connect.prepareStatement("insert into doctor values (?, ?)");
            preparedStatement.setInt(1, user_id);
            preparedStatement.setString(2, d.speciality);
            preparedStatement.executeUpdate();

        } catch(Exception e ) {
            System.out.println(e);
        }
    }

    public ArrayList<User> findWorkerByName(String nameSearched) {
        try {
            ArrayList<User> userList = new ArrayList<User>();
            connect = dbConnection.getConnection();
            String sql = "SELECT user_id, user_type, username, password, name, surname, email, sex FROM user WHERE name LIKE '%" + nameSearched + "%'";
            PreparedStatement pr = connect.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("user_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String sex = rs.getString("sex");
                String user_type = rs.getString("user_type");
                if(user_type.equals("Doctor")) {
                    sql = "SELECT speciality FROM doctor WHERE doctor_id = ?";
                    pr = connect.prepareStatement(sql);
                    pr.setInt(1, id);
                    ResultSet rset = pr.executeQuery();
                    String speciality = "";
                    if(rset.next()) {
                        speciality = rset.getString("speciality");
                    }
                    userList.add(new Doctor(username, password, email, name, surname, sex, speciality));
                }
            }
            return userList;
        } catch (Exception e) {
            System.out.print(e);
        }
        return null;
    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " + i + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String id = resultSet.getString("user_id");
            String usertype = resultSet.getString("user_type");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String sex = resultSet.getString("sex");
            System.out.println("ID: " + id);
            System.out.println("Usertype: " + usertype);
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            System.out.println("Email: " + email);
            System.out.println("Name: " + name);
            System.out.println("Surname: " + surname);
            System.out.println("Sex: " + sex);
        }
    }

    public void deleteUser(User u) {
        try {
            connect = dbConnection.getConnection();
            preparedStatement = connect.prepareStatement("DELETE FROM user WHERE username = ?");
            preparedStatement.setString(1, u.username);
            preparedStatement.executeUpdate();
        } catch(Exception e) {
            System.out.print(e);
        }
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}
