package sg.edu.iss.caps.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Coursedetail;
import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.service.CourseService;
import sg.edu.iss.caps.service.Coursedetailservice;
import sg.edu.iss.caps.service.LecturerService;
//import sg.edu.iss.caps.service.StudentService;
import sg.edu.iss.caps.service.UserInterface;



@Controller
public class LecturerController {

	@Autowired
	private LecturerService lservice;
	@Autowired
	private Coursedetailservice cdservice;
	@Autowired
	private CourseService cservice;
	@Autowired
	UserInterface uservice;
	//@Autowired
	//private StudentService service;
	//private List<Course> courses=new List<Course>();
	public void setLecturer(LecturerService lservice) {
		this.lservice=lservice;
	}
	
//	@GetMapping(value="/home/{id}")
//	public String showHomePage(Model model,@PathVariable("id") Integer id,HttpSession session) {
//		if (!uservice.checkSession(session, "lect")) 
//			  return "index";
//		
//		model.addAttribute("lecturer",lservice.findLecturerById(id));
//		return "LecturerMainPage.html";
//	}
	
	
	@RequestMapping(value="lecturer/ViewCourse/{id}")
	public String ViewCourse(Model model,@PathVariable("id") Integer id,HttpSession session ){
		if (!uservice.checkSession(session, "lect")) 
			  return "index";
		
		//model.addAttribute("lecturer",lservice.findLecturerById(id));
		
		List<Course> courses= cservice.findCoursesByLecturer(lservice.findLecturerById(id));
		model.addAttribute("courses", courses);
		return "LecCourseList.html"; 
	}
	
	@RequestMapping(value="lecturer/ViewCourseDetails/{code}")
	public String ViewCourseDetails(Model model,@PathVariable("code") String code, HttpSession session){
		if (!uservice.checkSession(session, "lect")) 
			  return "index";
		
		Coursedetail course=cdservice.findCoursedetailbyCode(code);
		
		model.addAttribute("course", course);
		
		
		return "LecCourseView.html"; 
	}
	
	

	@RequestMapping(value="lecturer/ViewCourseEnrollment/{code}")
	public String ViewCourseEnrollment(Model model,@PathVariable("code") String code, HttpSession session){
		if (!uservice.checkSession(session, "lect")) 
			  return "index";
		
		List<Course> courses=cservice.findCoursesByCode(code);
		//List<Course> courses= cservice.findCoursesByLecturer(lservice.findLecturerById(id));
		List<Student> slist=new ArrayList<Student>();
		for (Course course : courses) {
			Student student=course.getStudent();
			slist.add(student);
		}
		model.addAttribute("students", slist);
		
		
		return "StudentList-lecturer.html"; 
	}
	
	
	
	  @RequestMapping(value="lecturer/ViewCourseStudents/{id}")
	  public String ViewCourseStudents(Model model,@PathVariable("id") Integer id, HttpSession session) {
		  
			if (!uservice.checkSession(session, "lect")) 
				  return "index";
	  
		    model.addAttribute("lecturer",lservice.findLecturerById(id));
			//Lecturer l1=lservice.findLecturerById(lecturer.getId());
			List<Course> courses= cservice.findCoursesByLecturer(lservice.findLecturerById(id));
			model.addAttribute("courses", courses);
			return "LecturerCourses.html"; 
	  }
	 
	 
	

	@RequestMapping(value="lecturer/save")
	public String saveGrade(@ModelAttribute("course") Course course, Model model, HttpSession session) {
		
		if (!uservice.checkSession(session, "lect")) 
			  return "index";
		
		lservice.saveCourse(course);
		return "forward:/lecturer/list";
	}
	
	@RequestMapping(value = "lecturer/gradeform/{id}")
	public String showForm(Model model, @PathVariable("id") Integer id, HttpSession session) {
		
		if (!uservice.checkSession(session, "lect")) 
			  return "index";
		
		model.addAttribute("course", lservice.findCourseById(id));
		return "gradeform";
	}

	
	@RequestMapping(value= "lecturer/add")
	public String showCourseForm(Model model, HttpSession session) {
		
		if (!uservice.checkSession(session, "lect")) 
			  return "index";
		
		Course course = new Course();
		model.addAttribute("course", course);
		return "CreateCourse";
	}
}
