package LabTechs.Model;

import JDBC.MySQLAccess;

import java.io.File;
import java.nio.file.Path;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Calendar;

public class Test {

    private String receiver_username;
    private String sender_username;
    private String test_name;
    private String patient_username;
    private Date sent_date;
    private Time sent_time;
    private File file;

    public Test(String receiver_username, String sender_username,
                String test_name, String patient_username,
                Date sent_date, Time sent_time, File file) {
        this.receiver_username = receiver_username;
        this.sender_username = sender_username;
        this.test_name = test_name;
        this.patient_username = patient_username;
        this.sent_date = sent_date;
        this.sent_time = sent_time;
        this.file = file;
    }
    public Test(String receiver_username, String sender_username,
                String test_name, String patient_username,
                Date sent_date, Time sent_time) {
        this.receiver_username = receiver_username;
        this.sender_username = sender_username;
        this.test_name = test_name;
        this.patient_username = patient_username;
        this.sent_date = sent_date;
        this.sent_time = sent_time;
        this.file = null;
    }

    public static Test newTest(String receiver_username, String sender_username, String test_name, String patient_username, File file){
        Date currentDate = new Date(Calendar.getInstance().getTime().getTime());
        Time currentTime = java.sql.Time.valueOf(LocalTime.now());

        return new Test(receiver_username,sender_username,test_name,patient_username,currentDate,currentTime,file);
    }
    public boolean sendTest (){
        MySQLAccess mySQLAccess = new MySQLAccess();
        return mySQLAccess.addTest(this);
    }
    public void downloadTest(Path download_location){
        MySQLAccess mySQLAccess = new MySQLAccess();
        mySQLAccess.writeTestResult(this,download_location);
    }

    public String getReceiver_username() {
        return receiver_username;
    }

    public String getSender_username() {
        return sender_username;
    }

    public String getTest_name() {
        return test_name;
    }

    public String getPatient_username() {
        return patient_username;
    }

    public Date getSent_date() {
        return sent_date;
    }

    public Time getSent_time() {
        return sent_time;
    }

    public File getFile() {
        return file;
    }

    @Override
    public String toString() {
        return "Test{" +
                "receiver_username='" + receiver_username + '\'' +
                ", sender_username='" + sender_username + '\'' +
                ", test_name='" + test_name + '\'' +
                ", patient_username='" + patient_username + '\'' +
                ", sent_date=" + sent_date +
                ", sent_time=" + sent_time +
                '}';
    }
}
