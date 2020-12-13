package JDBC;


import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Calendar;

public class Message {
    public final int ABSTRACT_MESSAGE = 0;
    public final int INCOMING_MESSAGE = 1;
    public final int OUTGOING_MESSAGE = 2;

    private User receiver_user;
    private User sender_user;
    private String subject;
    private String content;
    private Date sent_date;
    private Time sent_time;
    private int message_type;
    private boolean is_read;

    public Message(User receiver_user, User sender_user, String subject, String content, int message_type) {
        this.receiver_user = receiver_user;
        this.sender_user = sender_user;
        this.subject = subject;
        this.content = content;
        this.sent_date = new Date(Calendar.getInstance().getTime().getTime());
        this.sent_time = java.sql.Time.valueOf(LocalTime.now());
        this.message_type = message_type;
    }
    public Message sendMessage(User receiver_user, User sender_user, String subject, String content){
        Message message = new Message(receiver_user,sender_user,subject,content,OUTGOING_MESSAGE);

        return new Message(receiver_user,sender_user,subject,content,OUTGOING_MESSAGE);
    }

    public User getReceiver_user() {
        return receiver_user;
    }

    public void setReceiver_user(User receiver_user) {
        this.receiver_user = receiver_user;
    }

    public User getSender_user() {
        return sender_user;
    }

    public void setSender_user(User sender_user) {
        this.sender_user = sender_user;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSent_date() {
        return sent_date;
    }

    public void setSent_date(Date sent_date) {
        this.sent_date = sent_date;
    }

    public Time getSent_time() {
        return sent_time;
    }

    public void setSent_time(Time sent_time) {
        this.sent_time = sent_time;
    }

    public int getMessage_type() {
        return message_type;
    }

    public void setMessage_type(int message_type) {
        this.message_type = message_type;
    }

    public boolean isIs_read() {
        return is_read;
    }

    public void setIs_read(boolean is_read) {
        this.is_read = is_read;
    }

    @Override
    public String toString() {
        return "JDBC.Message{" +
                ", receiver_user=" + receiver_user.getUsername() +
                ", sender_user=" + sender_user.getUsername() +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", sent_date=" + sent_date +
                ", sent_time=" + sent_time +
                ", message_type=" + message_type +
                ", is_read=" + is_read +
                '}';
    }
}
