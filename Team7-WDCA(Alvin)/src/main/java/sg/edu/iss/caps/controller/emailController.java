package sg.edu.iss.caps.controller;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.service.StudentService;

@RestController
public class emailController {
	
	@Autowired
	private StudentService sservice;
	
   @RequestMapping(value = "/sendemail/{id}")
   public String sendEmail(Model model, @PathVariable("id") Integer id) throws MessagingException {
	   
	   Student StudentToEmail = sservice.findStudentById(id);
	   	   
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
	   msg.setContent(StudentToEmail.getFirstName(), "text/html");
	   msg.setSentDate(new Date());

	   Transport.send(msg);   
	   
      return "Email sent successfully";
   }   
}