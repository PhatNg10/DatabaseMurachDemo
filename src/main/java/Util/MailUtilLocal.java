/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

/**
 *
 * @author phatn
 */
public class MailUtilLocal {
    
    public static void sendMail(String to, String from, String subject, String body, boolean bodyIsHTML) throws MessagingException {
        
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "localhost");
        props.put("mail.smtp.port", 25);
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);
        
        Message message = new MimeMessage(session);
        message.setSubject(subject);
        if (bodyIsHTML) {
            message.setContent(body, "text/html");
        }
        else {
            message.setText(body);
        }
        
        Address fromAddress = new InternetAddress(from);
        Address toAddress = new InternetAddress(to);
        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO, toAddress);
        
        Transport.send(message);
    }
}
