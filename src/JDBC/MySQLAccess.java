package JDBC;

import java.sql.*;
import java.util.ArrayList;

import Appointment.Appointment;
import Doctor.Model.*;
import Patient.Model.Patient;

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

//            if(u instanceof Patient) {
//                preparedStatement.setString(1, "Patient");
//            }
            if(u instanceof Doctor)
                preparedStatement.setString(1, "Doctor");

            preparedStatement.executeUpdate();

            preparedStatement = connect
                    .prepareStatement("SELECT user_id, user_type, username, password, name, surname, email, sex from user");
            resultSet = preparedStatement.executeQuery();
            writeResultSet(resultSet);

//            if(u instanceof Patient) {
//            }
            if(u instanceof Doctor)
                addDoctor((Doctor) u);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }



    // TODO If doctor username is not on the system, return null.
    public Doctor getDoctorByUsername(String doctorUserName){
        try{
            int user_id = 0;

            connect = dbConnection.getConnection();
            String sql ="SELECT user_id, user_type, username, password, name, surname, email, sex FROM user WHERE username = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, doctorUserName);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user_id = resultSet.getInt("user_id");
            }
            PreparedStatement pr = connect.prepareStatement("SELECT * FROM doctor WHERE doctor_id = ?");
            pr.setInt(1, user_id);
            ResultSet rs = pr.executeQuery();


            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String email = resultSet.getString("email");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String sex = resultSet.getString("sex");
            String speciality = " ";
            if(rs.next()){
                speciality = rs.getString("speciality");
            }
            return new Doctor(username,password,email,name,surname,sex,speciality);

        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public int getUserId(String username){
        try{
            connect = dbConnection.getConnection();
            String sql = "SELECT user_id FROM user WHERE username = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                return resultSet.getInt("user_id");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    public User getUserByName(String username){
        try{
            connect = dbConnection.getConnection();
            String sql ="SELECT user_id, user_type, username, password, name, surname, email, sex FROM user WHERE username = ?";
            preparedStatement = connect.prepareStatement(sql);

            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            String user_type;
            String password;
            String email;
            String name ;
            String surname;
            String sex;

            if(resultSet.next()){
                user_type = resultSet.getString("user_type");
                password = resultSet.getString("password");
                email = resultSet.getString("email");
                name = resultSet.getString("name");
                surname = resultSet.getString("surname");
                sex = resultSet.getString("sex");
                return new User(username,password,email,name,surname,sex,user_type);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
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
    //TODO user_id yi eklemenin bir yolunu bul
    //TODO patient in olusturulmasini bekle

//    public ArrayList<Patient> getPatientsOfDoctor(Doctor doctor) throws SQLException {
//        connect = dbConnection.getConnection();
//        int doctor_id = getUserId(doctor.getUsername());
//        String sql = "SELECT * FROM doctor_patient WHERE doctor_id = ?";
//        preparedStatement = connect.prepareStatement(sql);
//        preparedStatement.setInt(1, doctor_id);
//        resultSet = preparedStatement.executeQuery();
//
//
//
//    }



    private void addDoctor(Doctor d) {
        try {
            int user_id = 0;
            connect = dbConnection.getConnection();
            preparedStatement = connect
                    .prepareStatement("SELECT user_id from user WHERE username = ?");
            preparedStatement.setString(1, d.getUsername());
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
                user_id = resultSet.getInt("user_id");
            preparedStatement = connect.prepareStatement("insert into doctor values (?, ?)");
            preparedStatement.setInt(1, user_id);
            preparedStatement.setString(2, d.getSpeciality());
            preparedStatement.executeUpdate();

        } catch(Exception e ) {
            System.out.println(e);
        }
    }


    //TODO complete the method to add message to database
    //TODO add user_id to user class
    public void addMessage(Message message){
        try{
            connect = dbConnection.getConnection();
            String sql = "INSERT INTO message values (?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connect.prepareStatement(sql);



        }catch(Exception e){
            e.printStackTrace();
        }
    }

//    public ArrayList<Appointment> getAppointmentOfDoctor(Doctor doctor){
//        try{
//            int doctor_id = getUserId(doctor.getUsername());
//            ArrayList<Appointment> appointments = new ArrayList<>();
//
//
//            connect = dbConnection.getConnection();
//            String sql = "SELECT patient_id, date, start_time, end_time, is_approved " +
//                    "FROM appointment WHERE doctor_id = ?";
//            preparedStatement = connect.prepareStatement(sql);
//            preparedStatement.setInt(1, doctor_id);
//            resultSet = preparedStatement.executeQuery();
//
//            Patient patient;
//            Date date;
//            Time start_time;
//            Time end_time;
//            int is_approved;
//
//            while(resultSet.next()){
//
//                //Todo wait the patient class
//            }
//
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }


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
