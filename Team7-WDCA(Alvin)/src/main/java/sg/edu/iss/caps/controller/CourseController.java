	package sg.edu.iss.caps.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Coursedetail;
import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.service.CourseService;
import sg.edu.iss.caps.service.Coursedetailservice;
import sg.edu.iss.caps.service.StudentService;
import sg.edu.iss.caps.service.UserInterface;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	CourseService cservice;
	
	@Autowired
	Coursedetailservice cdservice;
	
	@Autowired
	UserInterface uservice;
	
	@Autowired
	StudentService sservice;
	
	// Accessible by everyone
	@GetMapping(value = "/list")
	public String list(Model model, HttpSession session) {
		
		if (!(uservice.checkSession(session, "stu") || uservice.checkSession(session, "lect")))
			return "index";
		
//		Student student = (Student)session.getAttribute("currentStudent");
//		List<Coursedetail> allCourses = cdservice.findAllCoursedetail();
//		List<Course> allEnrolledCourses = cservice.findCoursesByStudent(student);
//		List<Coursedetail> avaliableCourses = new ArrayList<Coursedetail>();
//		for(Coursedetail x: allCourses) {
//			
//			for(Course y:allEnrolledCourses) {
//				
//				if(x.getCode()!=y.getCode())
//					avaliableCourses.add(x);				
//			}			
//		}
//		
//		
//		
//		
//	
//		int currentpage = 0;
//		List<Coursedetail> listWithPagination = cdservice.getAllCourses(currentpage, 5);
		
		
//		model.addAttribute("coursedetails", listWithPagination);
		return "courselist";
	}
	
	@GetMapping(value = "/forward/{currentPage}")
	public String arrowlist(@PathVariable(value = "currentPage") String pageNo, Model model) {
		Integer i = Integer.parseInt(pageNo);
		if (i == 2)
			i--;
		List<Coursedetail> listWithPagination = cdservice.getAllCourses(i+1, 5);
		
		model.addAttribute("coursedetails", listWithPagination);
		
		model.addAttribute("currentPage", i+1);
		
		return "StudentList-stu.html";
	}

	@GetMapping(value = "/backward/{currentPage}")
	public String backlist(@PathVariable(value = "currentPage")String pageNo ,Model model) {
		Integer i = Integer.parseInt(pageNo);
		if (i == 0)
			i++;
		List<Coursedetail> listWithPagination = cdservice.getAllCourses(i-1, 5);
		
		model.addAttribute("coursedetails", listWithPagination);
		
		model.addAttribute("currentPage", i-1);
		
		return "StudentList-stu.html";
	}
	
	@GetMapping(value = "/list/{code}")
	public String view(@PathVariable("code") String code, Model model, HttpSession session) {
		
		if (!(uservice.checkSession(session, "stu") && uservice.checkSession(session, "lect")))
			return "index";
		
		Coursedetail cd = cdservice.findCoursedetailbyCode(code);
		model.addAttribute("courses", cd);
		return "CourseView.html";
	}
	
	@GetMapping(value = "/enrol/{code}")
	public String enrolcourse(@PathVariable("code") String code, HttpSession session, Model model) throws MessagingException
	{
		if (!uservice.checkSession(session, "stu"))
			return "index";
		Coursedetail currentCourse = cdservice.findCoursedetailbyCode(code);
		List <Course> course = cservice.findCoursesByCode(code);
		int count = course.size();
		Coursedetail cd = cdservice.findCoursedetailbyCode(code); 
		int capacity = cd.getCourseCapacity();
		
		if (count<capacity) {
			Course registered = new Course (currentCourse.getCode(), currentCourse.getDescription(), currentCourse.getCredits());
			Student student = (Student)session.getAttribute("currentStudent");
			registered.setStudent(student);
			cservice.save(registered);
			List<Course> Course123 = cservice.findCoursesByStudent(student);
			model.addAttribute("Course123", Course123);
			sendEmail(model,student.getId());
			return "forward:/student/info/"+student.getId();
			
		} else
			return "error.html";
	}
	
	@GetMapping(value = "/add")
	public String addCourse(Model model, HttpSession session) {
		if (!uservice.checkSession(session, "stu"))
			return "index";
		
		model.addAttribute("course", new Course());
		return "forward:/course/list";
}
	
	   public void sendEmail(Model model, @PathVariable("id") Integer id) throws MessagingException {
		   
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
	   }   
}
