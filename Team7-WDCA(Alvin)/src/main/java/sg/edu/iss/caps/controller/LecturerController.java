package sg.edu.iss.caps.controller;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Lecturer;
import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.service.CourseService;
import sg.edu.iss.caps.service.LecturerService;
import sg.edu.iss.caps.service.UserInterface;
//import sg.edu.iss.caps.service.StudentService;



@Controller
public class LecturerController {

	@Autowired
	private LecturerService lservice;
	@Autowired
	private CourseService cservice;
	
	@Autowired
	private UserInterface uservice;
	//@Autowired
	//private StudentService service;
	//private List<Course> courses=new List<Course>();
	public void setLecturer(LecturerService lservice) {
		this.lservice=lservice;
	}
	
	@Autowired
	public void setLecturer(LecturerInterface ls) {
		this.lservice = ls;
	}
	
	@GetMapping(value="/home/{id}")
	public String showHomePage(Model model,@PathVariable("id") Integer id) {
		model.addAttribute("lecturer",lservice.findLecturerById(id));
		return "LecturerMainPage.html";
	}
	
	
	@GetMapping(value="/ViewCourse/{id}")
	public String ViewCourse(Model model,@PathVariable("id") Integer id,HttpSession session )
	{
		/*
		 * if (!uservice.checkSession(session, "lect")) return "index";
		 */
		model.addAttribute("lecturer",lservice.findLecturerById(id));
		
		List<Course> courses= cservice.findCoursesByLecturer(lservice.findLecturerById(id));
		model.addAttribute("courses", courses);
		return "courselist.html"; 
	}
	

	@GetMapping(value="/ViewCourseEnrollment/{code}")
	public String ViewCourseEnrollment(Model model,@PathVariable("code") String code)
	{
		List<Course> courses=cservice.findCoursesByCode(code);
		//List<Course> courses= cservice.findCoursesByLecturer(lservice.findLecturerById(id));
		List<Student> slist=new ArrayList<Student>();
		for (Course course : courses) {
			Student student=course.getStudent();
			slist.add(student);
		}
		model.addAttribute("students", slist);
		
		
		return "StudentList.html"; 
	}
	
	
	
	  @GetMapping(value="/ViewCourseStudents/{id}")
	  public String ViewCourseStudents(Model model,@PathVariable("id") Integer id) {
	  
		  model.addAttribute("lecturer",lservice.findLecturerById(id));
			//Lecturer l1=lservice.findLecturerById(lecturer.getId());
			List<Course> courses= cservice.findCoursesByLecturer(lservice.findLecturerById(id));
			model.addAttribute("courses", courses);
			return "LecturerCourses.html"; 
	  }
	 
	 
	

	@RequestMapping(value="lecturer/save")
	public String saveGrade(@ModelAttribute("course") Course course, Model model) {
		lservice.saveCourse(course);
		return "forward:/lecturer/list";
	}
	
	@RequestMapping(value = "lecturer/gradeform/{id}")
	public String showForm(Model model, @PathVariable("id") Integer id) {
		
		model.addAttribute("course", lservice.findCourseById(id));
		return "gradeform";
	}

	
	@RequestMapping(value= "lecturer/add")
	public String showCourseForm(Model model) {
		Course course = new Course();
		model.addAttribute("course", course);
		return "CreateCourse";
	}
}
