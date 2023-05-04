package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendMail {
    void sendAttachment(){

        //host : gmail is smtp :
        String host = "smtp.gmail.com";
        Properties props = System.getProperties();
        System.out.println(props);

        props.put("mail.smtp.host",host);
        props.put("mail.smtp.port","465");
        props.put("mail.smtp.ssl.enable","true");
        props.put("mail.smtp.auth","true");


        //session
        Session mailSession = Session.getInstance(props,new MailAuthenticator());

        // Create the message object
        MimeMessage mimeMessage = new MimeMessage(mailSession);

        try {
            //sender
            mimeMessage.setFrom(MailConstants.SENDER);

            //receiver
            mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(MailConstants.RECEIVER));

            //subject
            mimeMessage.setSubject(MailConstants.SUBJECT);

            //message
            mimeMessage.setText(MailConstants.MESSAGE);

            Transport.send(mimeMessage);

        } catch (MessagingException e) {
            throw new  RuntimeException(e);
        }


    }
}
