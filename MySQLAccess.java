import JDBC.dbConnection;

import java.lang.ref.WeakReference;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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
            preparedStatement.setString(4, u.email);
            preparedStatement.setString(5, u.name);
            preparedStatement.setString(6, u.surname);
            preparedStatement.setString(7, u.sex);

            if (u instanceof Patient) {
                preparedStatement.setString(1, "Patient");
            }
            if (u instanceof Doctor)
                preparedStatement.setString(1, "Doctor");

            preparedStatement.executeUpdate();

            preparedStatement = connect
                    .prepareStatement("SELECT user_id, user_type, username, password, name, surname, email, sex from user");
            resultSet = preparedStatement.executeQuery();
            writeResultSet(resultSet);

            if (u instanceof Patient)
                addPatient((Patient) u);

            if (u instanceof Doctor)
                addDoctor((Doctor) u);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    private int getID(String username) {
        try {
            int userID = 0;
            connect = dbConnection.getConnection();
            preparedStatement = connect
                    .prepareStatement("SELECT user_id from user WHERE username = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                userID = resultSet.getInt("user_id");
            }
            return userID;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void readPatientInfo(String username, Date dob, String bloodType, int age, String allergies, String surgeries) {
        int user_id;
        try {
            user_id = getID(username);
            preparedStatement =
                    connect.prepareStatement("UPDATE patient SET dob = ?, bloodType = ?, age = ?, allergies = ?, surgeries = ?, " +
                            "WHERE patient_id = ?");
            preparedStatement.setDate(1, dob);
            preparedStatement.setString(2, bloodType);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, allergies);
            preparedStatement.setString(5, surgeries);
            preparedStatement.setInt(6, user_id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PatientInfoCard getPatientInfo(String username) {
        int user_id;
        try {
            user_id = getID(username);
            preparedStatement = connect
                    .prepareStatement("SELECT birth_date, blood_type, age, allergies, preivous_surgeries FROM patient WHERE patient_id = ?");
            preparedStatement.setInt(1, user_id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Date birthDate = resultSet.getDate("birth_date");
                String bloodType = resultSet.getString("blood_type");
                int age = resultSet.getInt("age");
                String allergies = resultSet.getString("allergies");
                String surgeries = resultSet.getString("preivous_surgeries");
                PatientInfoCard infoCard = new PatientInfoCard(age, birthDate, bloodType, allergies, surgeries);
                return infoCard;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    private void addDoctor(Doctor d) {
        try {
            int user_id = 0;
            connect = dbConnection.getConnection();
            preparedStatement = connect
                    .prepareStatement("SELECT user_id from user WHERE username = ?");
            preparedStatement.setString(1, d.getUserName());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                user_id = resultSet.getInt("user_id");
            preparedStatement = connect.prepareStatement("insert into doctor values (?, ?)");
            preparedStatement.setInt(1, user_id);
            preparedStatement.setString(2, d.getSpeciality());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void addPatient(Patient p) {
        int user_id;
        try {
            user_id = getID(p.getUserName());
            preparedStatement = connect.prepareStatement("insert into patient values (?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, user_id);
            preparedStatement.setDate(2, p.getDob());
            preparedStatement.setString(3, p.getBloodType());
            preparedStatement.setInt(4, p.getAge());
            preparedStatement.setString(5, p.getAllergies());
            preparedStatement.setString(6, p.getSurgeries());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
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
                if (user_type.equals("Doctor")) {
                    sql = "SELECT speciality FROM doctor WHERE doctor_id = ?";
                    pr = connect.prepareStatement(sql);
                    pr.setInt(1, id);
                    ResultSet rset = pr.executeQuery();
                    String speciality = "";
                    if (rset.next()) {
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

    public void readAppointment(String username, String doctorUsername, Date date, Time start_time, Time end_time) {
        try {
            preparedStatement = connect
                    .prepareStatement("INSERT INTO appointment values(default, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, doctorUsername);
            preparedStatement.setString(2, username);
            preparedStatement.setDate(3, date);
            preparedStatement.setTime(4, start_time);
            preparedStatement.setTime(5, end_time);
            preparedStatement.setBoolean(6, false);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Message> getIncomingMessage(String receiver_username) {
        try {
            ArrayList<Message> messages = new ArrayList<>();
            connect = dbConnection.getConnection();
            String sql = "SELECT * FROM message WHERE receiver_username = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, receiver_username);
            resultSet = preparedStatement.executeQuery();
            String sender_username;
            String subject;
            String content;
            Date sent_date;
            Time sent_time;
            Boolean is_read;

            while (resultSet.next()) {
                sender_username = resultSet.getString("sender_username");
                subject = resultSet.getString("subject");
                content = resultSet.getString("content");
                sent_date = resultSet.getDate("sent_date");
                sent_time = resultSet.getTime("sent_time");
                is_read = resultSet.getBoolean("is_read");
                messages.add(new Message(receiver_username, sender_username, subject, content,
                        sent_date, sent_time, is_read));
            }
            return messages;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public ArrayList<Message> getOutGoingMgessage(String sender_username) {
        try {
            ArrayList<Message> messages = new ArrayList<>();
            connect = dbConnection.getConnection();
            String sql = "SELECT * FROM message WHERE sender_username = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, sender_username);
            resultSet = preparedStatement.executeQuery();
            String receiver_username;
            String subject;
            String content;
            Date sent_date;
            Time sent_time;
            Boolean is_read;

            while (resultSet.next()) {
                receiver_username = resultSet.getString("receiver_username");
                subject = resultSet.getString("subject");
                content = resultSet.getString("content");
                sent_date = resultSet.getDate("sent_date");
                sent_time = resultSet.getTime("sent_time");
                is_read = resultSet.getBoolean("is_read");
                messages.add(new Message(receiver_username, sender_username, subject, content,
                        sent_date, sent_time, is_read));
            }
            return messages;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public ArrayList<Drug> getDrugs(String username) {
        int patientID;
        ArrayList<Drug> drugList = new ArrayList<Drug>();
        try {
            patientID = getID(username);
            connect = dbConnection.getConnection();
            String sql = "SELECT * FROM drug_patient WHERE patient_id = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setInt(1, patientID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                boolean isMorning = resultSet.getBoolean("is_morning");
                boolean isAfternoon = resultSet.getBoolean("is_afternoon");
                boolean isEvening = resultSet.getBoolean("is_evening");
                Date startDate = resultSet.getDate("start_date");
                Date endDate = resultSet.getDate("final_date");
                boolean isHungry = resultSet.getBoolean("is_hungry");
                drugList.add(new Drug(username, name, isMorning, isAfternoon, isEvening, isHungry, startDate, endDate));
            }
            return drugList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Appointment> getAppointments(Patient p) {
        ArrayList<Appointment> appList = new ArrayList<>();
        try {
            connect = dbConnection.getConnection();
            preparedStatement = connect
                    .prepareStatement("SELECT * FROM appointment WHERE patient_username = ?");
            preparedStatement.setString(1, p.getUserName());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String doctorUsername = resultSet.getString("doctor_username");
                Date date = resultSet.getDate("date");
                Time startTime = resultSet.getTime("start_time");
                Time endTime = resultSet.getTime("end_time");
                appList.add(new Appointment(doctorUsername, p.getUserName(), date, startTime, endTime));
            }
            return appList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addMessage(Message message) {
        try {

            connect = dbConnection.getConnection();
            String sql = "INSERT INTO message values (Default, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, message.getReceiver_username());
            preparedStatement.setString(2, message.getSender_username());
            preparedStatement.setString(3, message.getSubject());
            preparedStatement.setString(4, message.getContent());
            preparedStatement.setDate(5, message.getSent_date());
            preparedStatement.setTime(6, message.getSent_time());
            preparedStatement.setBoolean(7, false);

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return false;
    }

    public ArrayList<Timestamp> getAvailableDates(Doctor d) {
        ArrayList<Timestamp> availableTimes = new ArrayList<>();
        int doctor_id = getID(d.getUserName());
        try {
            preparedStatement = connect.prepareStatement("SELECT * FROM available_times WHERE doctor_id = ?");
            preparedStatement.setInt(1, doctor_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Date date = resultSet.getDate("available_day");
                Time time = resultSet.getTime("available_time");
                availableTimes.add(new Timestamp(date.getTime() + time.getTime()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return availableTimes;
    }


    public boolean isCodeUsed(String code) {
        try {
            connect = dbConnection.getConnection();
            String sql = "SELECT is_used FROM code_of_doctor WHERE code_id = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, code);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                if (resultSet.getByte("is_used") == 0) {
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.print(e);
        }
        return true;
    }

    public boolean connectToDoctor(String username, String code) {
        int doctorID = 0;
        int patientID = 0;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());

            connect = dbConnection.getConnection();
            String sql = "SELECT doctor_id FROM code_of_doctor WHERE code_id = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, code);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                doctorID = resultSet.getInt("doctor_id");
            }
            patientID = getID(username);
            sql = "INSERT INTO doctor_patient values(?, ?, ?, ?, ?)";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setInt(1, doctorID);
            preparedStatement.setInt(2, patientID);
            preparedStatement.setBoolean(3, true);
            preparedStatement.setDate(4, date);
            preparedStatement.setString(5, code);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
            System.out.println("Column " + i + " " + resultSet.getMetaData().getColumnName(i));
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
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public ArrayList<Doctor> getDoctors(String pUsername) {
        try {
            int patientID = 0;
            int doctorID = 0;
            ArrayList<Doctor> docList = new ArrayList<Doctor>();
            ArrayList<Integer> doctorIDs = new ArrayList<Integer>();
            String speciality = "";
            connect = dbConnection.getConnection();
            patientID = getID(pUsername);
            preparedStatement = connect.prepareStatement("SELECT doctor_id FROM doctor_patient WHERE patient_id = ?");
            preparedStatement.setInt(1, patientID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                doctorID = resultSet.getInt("doctor_id");
                preparedStatement = connect.prepareStatement("SELECT * FROM user WHERE user_id = ?");
                preparedStatement.setInt(1, doctorID);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    String email = resultSet.getString("email");
                    String name = resultSet.getString("name");
                    String surname = resultSet.getString("surname");
                    String sex = resultSet.getString("sex");
                    preparedStatement = connect.prepareStatement("SELECT speciality FROM doctor WHERE doctor_id = ?");
                    preparedStatement.setInt(1, doctorID);
                    if (resultSet.next()) {
                        speciality = resultSet.getString("speciality");
                    }
                    docList.add(new Doctor(username, password, email, name, surname, sex, speciality));
                }
            }
            return docList;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

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
