package com.kodigo;

import javax.mail.*;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail {

    public static void sendMail(String recepient) {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");

        String myAccountEmail = "mejia.martinez2012@gmail.com";
        String password = "Realmadrid4321";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = prepareMessage(session, myAccountEmail,recepient);
        try {
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println("Message sent succesfully");
    }
    private  static  Message prepareMessage(Session session, String myAccountEmail, String recepient){
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Email test");

            //se crea el cuerpo del mensaje
            Multipart multipart = new MimeMultipart();//instancia del cuerpo del mensaje
            MimeBodyPart attachmentPart = new MimeBodyPart();// recibe cualquier archivo
            MimeBodyPart textPart = new MimeBodyPart();// texto del mensaje
            try {
                /**
                 * Puedes modificar la ruta del archivo que se almacenara en "f" a cualquier otro archivo,
                 * pero recomiendo que utilicemos el directorio del proyecto como prueba es decir
                 * que se coloquen los archivos en Kodigo-Solid-Flights/archivo.extencion
                 * para propositos de prueba he dejado una imagen Ghosts.jpg que es un excelente wallpaper
                 * para los que conocen linux. Espero que les guste este wallpaper
                 */
                File f =new File("/home/hector/IdeaProjects/Kodigo-Solid-Flights/Ghosts.jpg");
                attachmentPart.attachFile(f);
                textPart.setText("Hey! "+recepient+" this are all the flights you enter in the shell.");
                multipart.addBodyPart(textPart);
                multipart.addBodyPart(attachmentPart);
            } catch (IOException e) {
                e.printStackTrace();
            }
            message.setContent(multipart);
            return message;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }
}