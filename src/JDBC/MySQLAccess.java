package JDBC;

import Admin.model.*;
import Doctor.Model.*;
import LabTechs.Model.*;

import Patient.Model.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Appointment.Appointment;
import Patient.Model.PatientInfoCard;

import javax.swing.*;

public class MySQLAccess {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void addUser(User u) throws Exception {
        try {
            connect = dbConnection.getConnection();
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from user");

            preparedStatement = connect.prepareStatement("insert into user values (default, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, u.getUserType());
            preparedStatement.setString(2, u.getUsername());
            preparedStatement.setString(3, u.getPassword());
            preparedStatement.setString(4, u.getEmail());
            preparedStatement.setString(5, u.getName());
            preparedStatement.setString(6, u.getSurname());
            preparedStatement.setString(7, u.getSex());


            preparedStatement.executeUpdate();

            preparedStatement = connect
                    .prepareStatement("SELECT user_id from user WHERE username = ?");
            preparedStatement.setString(1, u.getUsername());
            resultSet = preparedStatement.executeQuery();

            if (u instanceof Patient)
                addPatient((Patient) u);

            if (u instanceof Doctor)
                addDoctor((Doctor) u);

        } finally {
            close();
        }
    }

    private void addPatient(Patient p) {
        int user_id;
        try {
            user_id = getID(p.getUsername());
            preparedStatement = connect.prepareStatement("insert into patient values (?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, user_id);
            preparedStatement.setDate(2, p.getDob());
            preparedStatement.setString(3, p.getBloodType());
            preparedStatement.setInt(4, p.getAge());
            preparedStatement.setString(5, p.getAllergies());
            preparedStatement.setString(6, p.getSurgeries());
            preparedStatement.setString(7, p.getComplaint());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                int dose = resultSet.getInt("dose");
                drugList.add(new Drug(username, name, isMorning, isAfternoon, isEvening, isHungry, startDate, endDate, dose));
            }
            return drugList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addDrug(Drug d) {
        try {
            int patientID = getID(d.getPatientUsername());
            connect = dbConnection.getConnection();
            preparedStatement = connect
                    .prepareStatement("INSERT INTO drug_patient values(default, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            String patientUsername = d.getPatientUsername();
            String name = d.getName();
            boolean isMorning = d.isMorning();
            boolean isAfternoon = d.isAfternoon();
            boolean isEvening = d.isEvening();
            boolean isHungry = d.isHungry();
            Date startDate = d.getStartDate();
            Date finalDate = d.getFinalDate();
            int dose = d.getDose();
            preparedStatement.setInt(1, patientID);
            preparedStatement.setString(2, name);
            preparedStatement.setBoolean(3, isMorning);
            preparedStatement.setBoolean(4, isAfternoon);
            preparedStatement.setBoolean(5, isEvening);
            preparedStatement.setDate(6, startDate);
            preparedStatement.setDate(7, finalDate);
            preparedStatement.setBoolean(8, isHungry);
            preparedStatement.setInt(9, dose);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
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

    public ArrayList<Appointment> getAppointments(Patient p) {
        ArrayList<Appointment> appList = new ArrayList<>();
        try {
            connect = dbConnection.getConnection();
            preparedStatement = connect
                    .prepareStatement("SELECT * FROM appointment WHERE patient_username = ? AND is_approved = 1");
            preparedStatement.setString(1, p.getUsername());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String doctorUsername = resultSet.getString("doctor_username");
                Date date = resultSet.getDate("date");
                Time startTime = resultSet.getTime("start_time");
                Time endTime = resultSet.getTime("end_time");
                appList.add(new Appointment(doctorUsername, p.getUsername(), date, startTime, endTime));
            }
            return appList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public PatientInfoCard getPatientInfo(String username) {

        PatientInfoCard patientInfo;
        try {
            connect = dbConnection.getConnection();
            String sql = "SELECT * FROM user WHERE username = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet rset = preparedStatement.executeQuery();

            int user_id = 0;
            String name = "";
            String surname = "";
            String email = "";
            String sex = "";

            while (rset.next()) {
                user_id = rset.getInt("user_id");
                name = rset.getString("name");
                surname = rset.getString("surname");
                email = rset.getString("email");
                sex = rset.getString("sex");
            }

            preparedStatement = connect
                    .prepareStatement("SELECT * FROM patient WHERE patient_id = ?");
            preparedStatement.setInt(1, user_id);
            rset = preparedStatement.executeQuery();
            if (rset.next()) {
                Date birthDate = rset.getDate("birth_date");
                String bloodType = rset.getString("blood_type");
                int age = rset.getInt("age");
                String allergies = rset.getString("allergies");
                String surgeries = rset.getString("preivous_surgeries");
                String complaint = rset.getString("complaint");
                patientInfo = new PatientInfoCard(user_id, username, email, name, surname, sex, age, birthDate, bloodType, allergies, surgeries, complaint);
                patientInfo.setUser_id(user_id);
                return patientInfo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Timestamp> getAvailableDates(Doctor d) {
        ArrayList<Timestamp> availableTimes = new ArrayList<>();
        int doctor_id = d.getId();
        try {
            connect = dbConnection.getConnection();
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
        } finally {
            close();
        }
        return availableTimes;
    }

    public boolean readAvailableTimes(Doctor d, Date date, Time time) {
        try {
            int id = d.getId();
            connect = dbConnection.getConnection();
            String sql = "INSERT INTO available_times VALUES(DEFAULT, ?,?,? )";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setDate(2, date);
            preparedStatement.setTime(3, time);

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

    public boolean changeUsername(String oldUsername, String username) {
        try {
            connect = dbConnection.getConnection();
            String sql = "UPDATE user SET username = ? WHERE username = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, oldUsername);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean changePassword(String username, String password) {
        try {
            connect = dbConnection.getConnection();
            String sql = "UPDATE user SET password = ? WHERE username = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean changeEmail(String username, String email) {
        try {
            connect = dbConnection.getConnection();
            String sql = "UPDATE user SET email = ? WHERE username = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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
        } finally {
            close();
        }
        return true;
    }

    public boolean connectToDoctor(String username, String code) {
        int doctorID = 0;
        int patientID;
        String code_id;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());

            connect = dbConnection.getConnection();
            String sql = "SELECT * FROM code_of_doctor WHERE code_id = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, code);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                doctorID = resultSet.getInt("doctor_id");
                code_id = resultSet.getString("code_id");
                setCodeUsed(code_id);
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
        } finally {
            close();
        }
        return false;
    }

    public boolean addCode(Code code) {
        try {
            int doctor_id;
            doctor_id = getID(code.getDoctor_username());
            connect = dbConnection.getConnection();
            String sql = "INSERT INTO code_of_doctor VALUES(? , ?, ?)";

            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, code.getCode_id());
            preparedStatement.setInt(2, doctor_id);
            preparedStatement.setBoolean(3, false);

            int i = preparedStatement.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return false;
    }

    private void setCodeUsed(String code_id) {
        try {
            connect = dbConnection.getConnection();
            String sql = "UPDATE code_of_doctor SET is_used = ? WHERE code_id = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);
            preparedStatement.setString(2, code_id);

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
            }

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
                    userList.add(new Doctor(id, username, password, email, name, surname, sex, speciality));
                }
            }
            return userList;
        } catch (Exception e) {
            System.out.print(e);
        } finally {
            close();
        }
        return null;
    }

    private void addDoctor(Doctor d) {
        try {
            int user_id = 0;
            connect = dbConnection.getConnection();
            preparedStatement = connect
                    .prepareStatement("SELECT user_id from user WHERE username = ?");
            preparedStatement.setString(1, d.getUsername());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                user_id = resultSet.getInt("user_id");
            preparedStatement = connect.prepareStatement("insert into doctor values (?, ?)");
            preparedStatement.setInt(1, user_id);
            preparedStatement.setString(2, d.getSpeciality());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            close();
        }
    }

    public void readAppointment(String username, String doctorUsername, Date date, Time start_time, Time end_time) {
        try {
            connect = dbConnection.getConnection();
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
        } finally {
            close();
        }
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
            JOptionPane.showMessageDialog(null, "Error! Message cannot be sent");
        } finally {
            close();
        }
        return false;
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

    public ArrayList<Message> getOutGoingMessage(String sender_username) {
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

    public boolean readMessage(Message message) {
        try {
            connect = dbConnection.getConnection();
            String sql = "UPDATE message SET is_read = ? WHERE sent_time = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);
            preparedStatement.setTime(2, message.getSent_time());
            int i = preparedStatement.executeUpdate();

            if(i >0){
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return false;
    }

    public boolean removeMessage(Time time) {
        try {
            connect = dbConnection.getConnection();
            String sql = "DELETE FROM message WHERE sent_time = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setTime(1, time);
            int i = preparedStatement.executeUpdate();

            if(i >0){
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return false;
    }


    public void readPatientInfo(String username, Date dob, String bloodType, int age, String allergies, String surgeries, String complaint) {
        int user_id;
        try {
            user_id = getID(username);
            preparedStatement =
                    connect.prepareStatement("UPDATE patient SET birth_date = ?, blood_type = ?, age = ?, allergies = ?, " +
                            "preivous_surgeries = ?, complaint = ?" +
                            "WHERE patient_id = ?");
            preparedStatement.setDate(1, dob);
            preparedStatement.setString(2, bloodType);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, allergies);
            preparedStatement.setString(5, surgeries);
            preparedStatement.setString(6, complaint);
            preparedStatement.setInt(7, user_id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }


    public boolean addTest(Test test) {
        try {
            FileInputStream fileInputStream = new FileInputStream(test.getFile());

            connect = dbConnection.getConnection();
            String sql = "INSERT INTO test VALUES(DEFAULT ,?,?,?,?,?,?,?)";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, test.getReceiver_username());
            preparedStatement.setString(2, test.getSender_username());
            preparedStatement.setString(3, test.getTest_name());
            preparedStatement.setString(4, test.getPatient_username());
            preparedStatement.setDate(5, test.getSent_date());
            preparedStatement.setTime(6, test.getSent_time());
            preparedStatement.setBinaryStream(7, fileInputStream);

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

    public void removeTest(Time time) {
        try {
            connect = dbConnection.getConnection();
            String sql = "DELETE FROM test WHERE sent_time = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setTime(1, time);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }


    public ArrayList<Test> getTestOfDoctor(String doc_username) {
        try {
            ArrayList<Test> tests = new ArrayList<>();

            connect = dbConnection.getConnection();
            String sql = "SELECT receiver_username,sender_username,test_name,patient_username,sent_date,sent_time FROM test WHERE receiver_username = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, doc_username);
            resultSet = preparedStatement.executeQuery();

            String sender_username;
            String test_name;
            String patient_username;
            Date sent_date;
            Time sent_time;

            while (resultSet.next()) {
                sender_username = resultSet.getString("sender_username");
                test_name = resultSet.getString("test_name");
                patient_username = resultSet.getString("patient_username");
                sent_date = resultSet.getDate("sent_date");
                sent_time = resultSet.getTime("sent_Time");
                tests.add(new Test(doc_username, sender_username, test_name, patient_username, sent_date, sent_time));
            }
            return tests;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;

    }

    public ArrayList<Test> getTestOfLabTech(String labTechUsername) {
        try {
            ArrayList<Test> tests = new ArrayList<>();

            connect = dbConnection.getConnection();
            String sql = "SELECT receiver_username,sender_username,test_name,patient_username,sent_date,sent_time FROM test WHERE sender_username = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, labTechUsername);
            resultSet = preparedStatement.executeQuery();

            String receiver_username;
            String test_name;
            String patient_username;
            Date sent_date;
            Time sent_time;

            while (resultSet.next()) {
                receiver_username = resultSet.getString("receiver_username");
                test_name = resultSet.getString("test_name");
                patient_username = resultSet.getString("patient_username");
                sent_date = resultSet.getDate("sent_date");
                sent_time = resultSet.getTime("sent_Time");
                tests.add(new Test(receiver_username, labTechUsername, test_name, patient_username, sent_date, sent_time));
            }
            return tests;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;

    }

    public void writeTestResult(Test test, Path path) {
        try {
            int i;
            String pathWithExtension;
            File file;

            connect = dbConnection.getConnection();
            String sql = "SELECT file FROM test WHERE receiver_username = ? AND sent_time = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, test.getReceiver_username());
            preparedStatement.setTime(2, test.getSent_time());
            resultSet = preparedStatement.executeQuery();

            pathWithExtension = path.toString() + "\\" + test.getPatient_username() + "_" + test.getTest_name() + "_(" + test.getSent_date() + ")" + ".pdf";

            file = new File(pathWithExtension);
            i = 1;

            while (file.exists()) {
                pathWithExtension = path.toString() + "\\" + test.getPatient_username() + "_" + test.getTest_name() + "_(" + test.getSent_date() + ")(" + i + ")" + ".pdf";
                file = new File(pathWithExtension);
                i++;
            }

            while (resultSet.next()) {
                Blob blob = resultSet.getBlob("file");
                byte[] byteArray = blob.getBytes(1, (int) blob.length());
                FileOutputStream outputStream = new FileOutputStream(pathWithExtension);
                outputStream.write(byteArray);
                outputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public ArrayList<DoctorInfoCard> getDoctors(String pUsername) {
        try {
            int patientID = 0;
            int doctorID = 0;
            ArrayList<DoctorInfoCard> docList = new ArrayList<DoctorInfoCard>();
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
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    String username = rs.getString("username");
                    String email = rs.getString("email");
                    String name = rs.getString("name");
                    String surname = rs.getString("surname");
                    String sex = rs.getString("sex");
                    preparedStatement = connect.prepareStatement("SELECT speciality FROM doctor WHERE doctor_id = ?");
                    preparedStatement.setInt(1, doctorID);
                    rs = preparedStatement.executeQuery();
                    if (rs.next()) {
                        speciality = rs.getString("speciality");
                    }
                    docList.add(new DoctorInfoCard(doctorID, username, email, name, surname, sex, speciality));
                }
            }
            return docList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<PatientInfoCard> getPatientInfos(Doctor doctor) {
        try {
            int patientID = 0;
            String patient_username;

            ArrayList<PatientInfoCard> patientInfoCards = new ArrayList<>();

            connect = dbConnection.getConnection();
            String sql = "SELECT patient_id FROM doctor_patient WHERE doctor_id = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setInt(1, doctor.getId());
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {
                patientID = resultSet.getInt("patient_id");
                sql = "SELECT username FROM user WHERE user_id = ?";
                preparedStatement = connect.prepareStatement(sql);
                preparedStatement.setInt(1, patientID);


                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    patient_username = rs.getString("username");
                    patientInfoCards.add(getPatientInfo(patient_username));
                }
            }
            return patientInfoCards;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<PatientSlot> getPatientsOfDoctor(Doctor doctor) {
        try {
            ArrayList<PatientSlot> patientSlots = new ArrayList<>();
            ArrayList<PatientInfoCard> patientInfos = getPatientInfos(doctor);
            int doctor_id = doctor.getId();
            int patient_id;
            int status;
            Date start_date;
            String code_id;
            connect = dbConnection.getConnection();

            for (PatientInfoCard patientInfoCard : patientInfos) {
                // patient_id = getID(patientInfoCard.getUsername());
                patient_id = patientInfoCard.getUser_id();
                String sql = "SELECT * FROM doctor_patient WHERE doctor_id = ? AND patient_id = ?";
                preparedStatement = connect.prepareStatement(sql);
                preparedStatement.setInt(1, doctor_id);
                preparedStatement.setInt(2, patient_id);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    status = resultSet.getInt("status");
                    start_date = resultSet.getDate("start_date");
                    code_id = resultSet.getString("code");
                    patientSlots.add(new PatientSlot(doctor.getUsername(), patientInfoCard, status, code_id, start_date));
                }
            }

            return patientSlots;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public ArrayList<Appointment> getWaitingAppointmentOfDoctor(Doctor doctor) {
        try {
            ArrayList<Appointment> appointments = new ArrayList<>();
            connect = dbConnection.getConnection();
            String sql = "SELECT * FROM appointment WHERE doctor_username = ? AND is_approved = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, doctor.getUsername());
            preparedStatement.setBoolean(2, false);

            resultSet = preparedStatement.executeQuery();

            String patient_username;
            Date date;
            Time start_time;
            Time end_time;

            while (resultSet.next()) {
                patient_username = resultSet.getString("patient_username");
                date = resultSet.getDate("date");
                start_time = resultSet.getTime("start_time");
                end_time = resultSet.getTime("end_time");

                appointments.add(new Appointment(doctor.getUsername(), patient_username, date, start_time, end_time));
            }
            return appointments;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public ArrayList<Appointment> getApprovedAppointmentOfDoctor(Doctor doctor) {
        try {
            ArrayList<Appointment> appointments = new ArrayList<>();
            connect = dbConnection.getConnection();
            String sql = "SELECT * FROM appointment WHERE doctor_username = ? AND is_approved = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, doctor.getUsername());
            preparedStatement.setBoolean(2, true);

            resultSet = preparedStatement.executeQuery();

            String patient_username;
            Date date;
            Time start_time;
            Time end_time;

            while (resultSet.next()) {
                patient_username = resultSet.getString("patient_username");
                date = resultSet.getDate("date");
                start_time = resultSet.getTime("start_time");
                end_time = resultSet.getTime("end_time");

                appointments.add(new Appointment(doctor.getUsername(), patient_username, date, start_time, end_time));
            }
            return appointments;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public void approveAppointment(Appointment appointment) {
        try {
            ArrayList<Appointment> appointments = new ArrayList<>();
            connect = dbConnection.getConnection();
            String sql = "UPDATE appointment SET is_approved = ? WHERE start_time = ? ";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);
            preparedStatement.setTime(2, appointment.getStart_time());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public void updateDoctorInformationOnDatabase(Doctor d) {
        try {
            int doctor_id = getID(d.getUsername());
            connect = preparedStatement.getConnection();
            String sql = "UPDATE doctor SET speciality = ? WHERE doctor_id = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, d.getSpeciality());
            preparedStatement.setInt(2, doctor_id);

            preparedStatement.executeUpdate();

            sql = "UPDATE user SET username = ?, password = ?, email = ?, name = ?, surname = ?, sex = ? WHERE user_id = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, d.getUsername());
            preparedStatement.setString(3, d.getPassword());
            preparedStatement.setString(4, d.getEmail());
            preparedStatement.setString(5, d.getName());
            preparedStatement.setString(6, d.getSurname());
            preparedStatement.setString(7, d.getSex());
            preparedStatement.setInt(8, doctor_id);

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }

    public boolean addTestRequest(TestRequest testRequest) {
        try {
            connect = dbConnection.getConnection();
            String sql = "INSERT INTO test_request VALUES(DEFAULT , ?, ?, ?)";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, testRequest.getTest_name());
            preparedStatement.setString(2, testRequest.getPatient());
            preparedStatement.setString(3, testRequest.getDoctor_username());

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

    public ArrayList<TestRequest> getTestRequest() {
        try {
            connect = dbConnection.getConnection();
            String sql = "SELECT * FROM test_request";
            preparedStatement = connect.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            String test_name;
            String patientInfoCard;
            String doctor_username;
            ArrayList<TestRequest> testRequests = new ArrayList<>();

            while (resultSet.next()) {
                test_name = resultSet.getString("test_name");
                patientInfoCard = resultSet.getString("patient_username");
                doctor_username = resultSet.getString("doctor_username");
                testRequests.add(new TestRequest(test_name, patientInfoCard, doctor_username));
            }
            return testRequests;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public boolean deleteTestRequest(TestRequest testRequest) {
        try {
            connect = dbConnection.getConnection();
            String sql = "DELETE FROM test_request WHERE test_name = ? AND patient_username = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, testRequest.getTest_name());
            preparedStatement.setString(2, testRequest.getPatient());

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

    public Doctor getDoctorByUsername(String doctorUserName) {
        try {
            int user_id = 0;

            connect = dbConnection.getConnection();
            String sql = "SELECT user_id, user_type, username, password, name, surname, email, sex FROM user WHERE username = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, doctorUserName);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user_id = resultSet.getInt("user_id");
            }
            PreparedStatement pr = connect.prepareStatement("SELECT * FROM doctor WHERE doctor_id = ?");
            pr.setInt(1, user_id);
            ResultSet rs = pr.executeQuery();


            String password = resultSet.getString("password");
            String email = resultSet.getString("email");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            String sex = resultSet.getString("sex");
            String speciality = " ";
            if (rs.next()) {
                speciality = rs.getString("speciality");
            }
            return new Doctor(user_id, doctorUserName, password, email, name, surname, sex, speciality);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    public User getUser(String username) {
        try {
            connect = dbConnection.getConnection();
            String sql = "SELECT * FROM user WHERE username = ?";
            preparedStatement = connect.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();

            User u;
            int user_id = 0;
            String userType = "";
            String name = "";
            String surname = "";
            String email = "";
            String sex = "";
            String password = "";

            while (resultSet.next()) {
                password = resultSet.getString("password");
                user_id = resultSet.getInt("user_id");
                userType = resultSet.getString("user_type");
                username = resultSet.getString("username");
                name = resultSet.getString("name");
                surname = resultSet.getString("surname");
                email = resultSet.getString("email");
                sex = resultSet.getString("sex");
            }

            if (userType.equals("LabTechnician")) {
                u = new LabTechnician(user_id, username, password, email, name, surname, sex);
            } else if (userType.equals("Patient")) {
                u = new Patient(user_id, username, email, password, name, surname, sex);
            } else {
                u = new Admin(user_id, username, email, password, name, surname, sex);
            }
            return u;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<DoctorInfoCard> getAllDoctors() {
        try {
            int doctorID = 0;
            ArrayList<DoctorInfoCard> docList = new ArrayList<DoctorInfoCard>();
            String speciality = "";
            connect = dbConnection.getConnection();
            preparedStatement = connect.prepareStatement("SELECT * FROM doctor");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                doctorID = resultSet.getInt("doctor_id");
                speciality = resultSet.getString("speciality");
                preparedStatement = connect.prepareStatement("SELECT * FROM user WHERE user_id = ?");
                preparedStatement.setInt(1, doctorID);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    String username = rs.getString("username");
                    String email = rs.getString("email");
                    String name = rs.getString("name");
                    String surname = rs.getString("surname");
                    String sex = rs.getString("sex");
                    docList.add(new DoctorInfoCard(doctorID, username, email, name, surname, sex, speciality));
                }
            }
            return docList;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<LabTechnician> getAllLabTechs() {
        try {
            ArrayList<LabTechnician> lablist = new ArrayList<LabTechnician>();
            connect = dbConnection.getConnection();
            preparedStatement = connect.prepareStatement("SELECT * FROM user WHERE user_type = 'LabTechnician'");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String sex = resultSet.getString("sex");
                lablist.add(new LabTechnician(username, password, email, name, surname, sex));
            }
            return lablist;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }


    public ArrayList<UserInfoCard> getAllWorkers() {
        try {
            ArrayList<UserInfoCard> workers = new ArrayList<UserInfoCard>();
            connect = dbConnection.getConnection();
            preparedStatement = connect.prepareStatement("SELECT * FROM user WHERE user_type = 'LabTechnician' " +
                    "OR user_type = 'Doctor' ORDER BY name");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int userID = resultSet.getInt("user_id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String sex = resultSet.getString("sex");
                String userType = resultSet.getString("user_type");

                if (userType.equals("Doctor")) {
                    preparedStatement = connect.prepareStatement("SELECT speciality FROM doctor WHERE doctor_id = ?");
                    preparedStatement.setInt(1, userID);
                    ResultSet rs = preparedStatement.executeQuery();
                    if (rs.next()) {
                        String speciality = rs.getString("speciality");
                        UserInfoCard u = new DoctorInfoCard(userID, username, email, name, surname, sex, speciality);
                        workers.add(u);
                    }
                } else {
                    workers.add(new UserInfoCard(userID, userType, username, email, name, surname, sex));
                }
            }
            return workers;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }


    public void deleteUser(User u) {
        try {
            connect = dbConnection.getConnection();
            preparedStatement = connect.prepareStatement("DELETE FROM user WHERE username = ?");
            preparedStatement.setString(1, u.getUsername());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.print(e);
        } finally {
            close();
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
            e.printStackTrace();
        }
    }

}
