package com.kodigo;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeBodyPart;

public class SendMail {

    public static void sendMailMethod(String emailTo, String emailMessage) {

        // Recipient's email ID needs to be mentioned.
        String to = emailTo;

        // Sender's email ID needs to be mentioned
        String from = "cparedestest@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("cparedestest@gmail.com", "}xvm-h2F.BF-vhM@");

            }

        });

        // Used to debug SMTP issues
//        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("[KODIGO] - Flights information");

            // Now set the actual message
//            message.setText(emailMessage);

            Multipart multipart = new MimeMultipart();

            MimeBodyPart attachmentPart = new MimeBodyPart();

            MimeBodyPart textPart = new MimeBodyPart();

            try {

                File f =new File("/home/carlos/Downloads/Flights1708.xlsx");

                attachmentPart.attachFile(f);
                textPart.setText("Hey! "+emailTo+" this are all the flights you enter in the shell.");
                multipart.addBodyPart(textPart);
                multipart.addBodyPart(attachmentPart);

            } catch (IOException e) {

                e.printStackTrace();

            }

            message.setContent(multipart);

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

}
