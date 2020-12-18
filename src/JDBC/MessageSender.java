package JDBC;

import java.util.ArrayList;

public interface MessageSender {
    void sendMessages(String username, String subject, String content);
    ArrayList<Message> getOutbox();
    ArrayList<Message> getInbox();
    void updateInbox();
    void updateOutbox();
}
