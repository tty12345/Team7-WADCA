package sg.edu.iss.caps.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class emailController {
   @RequestMapping(value = "/sendemail")
   public String sendEmail() throws MessagingException {
	   
	   Properties props = new Properties();
	   props.put("mail.smtp.auth", "true");
	   props.put("mail.smtp.starttls.enable", "true");
	   props.put("mail.smtp.host", "smtp.gmail.com");
	   props.put("mail.smtp.port", "587");
	   
	   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
	      protected PasswordAuthentication getPasswordAuthentication() {
	         return new PasswordAuthentication("a0124939w@gmail.com", "P@ssw0rd666");
	      }
	   });
	   
	   Message msg = new MimeMessage(session);
	   msg.setFrom(new InternetAddress("a0124939w@gmail.com", false));

	   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("a0124939w@gmail.com"));
	   msg.setSubject("Testing");
	   msg.setContent("Registration Confirmed", "text/html");
	   msg.setSentDate(new Date());

	   MimeBodyPart messageBodyPart = new MimeBodyPart();
	   messageBodyPart.setContent("Tutorials point email", "text/html");

	   Transport.send(msg);   
	   
      return "Email sent successfully";
   }   
}