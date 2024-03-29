package Admin.model;

import JDBC.*;
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
     private ArrayList<IViewer> viewers;
     private int id;

    public User(String username, String userType, String password, String email, String name, String surname, String sex){
        this.username = username;
        this.password = password;
        this.email  = email;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.userType = userType;
        viewers = new ArrayList<IViewer>();
        updateInbox();
        updateOutbox();
    }
    public User(int user_id, String username, String userType, String password, String email, String name, String surname, String sex){
        this.username = username;
        this.password = password;
        this.email  = email;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.userType = userType;
        id = user_id;
        viewers = new ArrayList<IViewer>();
        updateInbox();
        updateOutbox();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        MySQLAccess access = new MySQLAccess();
        access.changeUsername(getUsername(), username);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        MySQLAccess access = new MySQLAccess();
        access.changePassword(getUsername(), password);
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        MySQLAccess access = new MySQLAccess();
        access.changeEmail(getUsername(), email);
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

    public boolean removeMessage(Message message){
        updateViewers();
        return message.removeMessage();
    }
    public boolean readMessage(Message message){
        updateViewers();
       return message.readMessage();
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

    public void addViewer(IViewer view ) {
        viewers.add(view);
    }

    public void updateViewers() {
        for(IViewer view: viewers) {
            view.update();
        }
    }

    public int getUnreadMessageCount() {
        int count = 0;
        for(Message message: getInbox()) {
            if(!message.is_read()) {
                count++;
            }
        }
        return count;
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
