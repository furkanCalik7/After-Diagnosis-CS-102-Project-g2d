package JDBC;

import Admin.model.Admin;

import java.util.Properties;


public class Main {

    public static void main(String[] args) {
        /**
         Outgoing Mail (SMTP) Server
         requires TLS or SSL: smtp.gmail.com (use authentication)
         Use Authentication: Yes
         Port for TLS/STARTTLS: 587
         */
        final String fromEmail = "furkanguzelant@gmail.com"; //requires valid gmail id
        final String password = "Guzelant_2001"; // correct password for gmail id
        final String toEmail = "fguzelant@hotmail.com"; // can be any email id

        System.out.println("TLSEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        MySQLAccess access = new MySQLAccess();
        Admin a = (Admin) access.getUser("ahmet");
        System.out.println(a.getDoctors());

        //create Authenticator object to pass in Session.getInstance argument
//        Authenticator auth = new Authenticator() {
//            //override the getPasswordAuthentication method
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(fromEmail, password);
//            }
//        };
//        Session session = Session.getInstance(props, auth);
//
//        EmailUtil.sendEmail(session, toEmail, "TLSEmail Testing Subject", "TLSEmail Testing Body");

    }


}



