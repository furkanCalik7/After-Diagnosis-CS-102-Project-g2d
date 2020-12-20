package Admin.model;

import JDBC.Message;
import JDBC.MessageSender;
import JDBC.MySQLAccess;

import java.util.ArrayList;

public abstract class User implements MessageSender {

     private String username;
     private String password;
     private String email;
     private String name;
     private String surname;
     private String sex;
     private String userType;
    private ArrayList<Message> inbox;
    private ArrayList<Message> outbox;

    public User(String username, String userType, String password, String email, String name, String surname, String sex){
        this.username = username;
        this.password = password;
        this.email  = email;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void sendMessages(String username, String subject, String content) {
        Message message = Message.newMessage(username, getUsername(), subject, content);
        message.sendMessage();
        updateOutbox();
    }
    public void updateInbox(){
        MySQLAccess access = new MySQLAccess();
        inbox = access.getIncomingMessage(getUsername());
    }

    public void updateOutbox(){
        MySQLAccess access = new MySQLAccess();
        outbox = access.getOutGoingMessage(getUsername());
    }

    public ArrayList<Message> getInbox() {
        return inbox;
    }

    public ArrayList<Message> getOutbox() {
        return outbox;
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex='" + sex + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
