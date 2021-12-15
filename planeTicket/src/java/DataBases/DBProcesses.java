/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBases;

import javax.mail.Authenticator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ahmet
 */
public class DBProcesses {
    public Connection DBConnection(){
        String driver = "com.mysql.jdbc.Driver";
        String dbUrl = "jdbc:mysql://localhost:3306/ucakbileti?useUnicode=true&characterEncoding=utf8";
        Connection con = null;
        String dbUser = "root";
        String dbPass = "0000";
        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            System.out.println("Veri tabanı bağlantısı başarılı..");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Bağlantı başarısız !!");
            System.exit(0);
        }
        return con;
    }
    
    public void sendMail(String to, String body){
        String sender = "atmairline@gmail.com";
        String host = "localhost";
        
        //properties object is defined..
        Properties prp = new Properties();
        prp.put("mail.smtp.host", "smtp.gmail.com");
        prp.put("mail.smtp.port", "587");
        prp.put("mail.smtp.auth", "true");
        prp.put("mail.smtp.starttls.enable", "true");
        
        //Authentication structure is created..
        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("atmairline@gmail.com", "ahmetturan");
            }
        };
        
        //session object is created..
        Session mailSession = Session.getDefaultInstance(prp,auth);
        mailSession.setDebug(false);
        
        try {
            MimeMessage message = new MimeMessage(mailSession);
            
            message.setFrom(new InternetAddress(host));
            
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            
            message.setSubject("ATM Airlines");
            
            message.setText(body,"utf-8", "html");
            
            Transport.send(message);
            System.out.println("mail gönderildi");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("mail gönderilemedi !!");
        }
    }
    
    public static void main(String[] args){
        DBProcesses dbp = new DBProcesses();
    }
}
