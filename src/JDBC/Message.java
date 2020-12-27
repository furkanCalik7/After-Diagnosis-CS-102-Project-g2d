package JDBC;


import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Calendar;

public class Message {
    private String receiver_username;
    private String sender_username;
    private String subject;
    private String content;
    private Date sent_date;
    private Time sent_time;
    private boolean is_read;


    public Message(String receiver_username, String sender_username, String subject, String content, Date sent_date, Time sent_time,  boolean is_read) {
        this.receiver_username = receiver_username;
        this.sender_username = sender_username;
        this.subject = subject;
        this.content = content;
        this.sent_date = sent_date;
        this.sent_time = sent_time;
        this.is_read = is_read;
    }

    public static Message newMessage(String receiver_username, String sender_username, String subject, String content){
        Date currentDate = new Date(Calendar.getInstance().getTime().getTime());
        Time currentTime = java.sql.Time.valueOf(LocalTime.now());
        return new Message(receiver_username,sender_username,subject,content,currentDate, currentTime,false);
    }

    public boolean sendMessage(){
        MySQLAccess mySQLAccess = new MySQLAccess();
        return mySQLAccess.addMessage(this);
    }

    public boolean removeMessage(){
        MySQLAccess mySQLAccess = new MySQLAccess();
        return mySQLAccess.removeMessage(sent_time);
    }
    public boolean readMessage(){
        MySQLAccess mySQLAccess = new MySQLAccess();
        is_read = true;
        return mySQLAccess.readMessage(this);
    }




    public String getReceiver_username() {
        return receiver_username;
    }
    public String getSender_username() {
        return sender_username;
    }
    public String getSubject() {
        return subject;
    }
    public String getContent() {
        return content;
    }
    public Date getSent_date() {
        return sent_date;
    }
    public Time getSent_time() {
        return sent_time;
    }
    public boolean is_read() {
        return is_read;
    }


}
