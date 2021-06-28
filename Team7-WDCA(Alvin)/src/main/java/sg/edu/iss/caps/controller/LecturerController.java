package sg.edu.iss.caps.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Lecturer;
import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.service.CourseService;
import sg.edu.iss.caps.service.LecturerService;
//import sg.edu.iss.caps.service.StudentService;





@Controller
@RequestMapping("/lecturer")
public class LecturerController {
	@Autowired
	private LecturerService lservice;
	@Autowired
	private CourseService cservice;
	//@Autowired
	//private StudentService sservice;
	//private List<Course> courses=new List<Course>();
	public void setLecturer(LecturerService lservice) {
		this.lservice=lservice;
	}
	
	@GetMapping(value = "/list")
	public String list(Model model) {
		List<Lecturer> lecturerList = lservice.listAllLecturer();
		model.addAttribute("lecturers",lecturerList);
		return "LecturerList.html";
	}
	
	@GetMapping(value="/home/{id}")
	public String showHomePage(Model model,@PathVariable("id") Integer id) {
		model.addAttribute("lecturer",lservice.findLecturerById(id));
		return "LecturerMainPage.html";
	}
	
	/*
	 * @RequestMapping("/ViewCourse") public String viewCourses(Model model,Lecturer
	 * lecturer) { //Lecturer lecturer=new Lecturer(); Lecturer
	 * l1=lservice.findLecturerById(lecturer.getId()); List<Course> courses=
	 * cservice.findCoursesByLecturer(l1); model.addAttribute("courses",courses);
	 * return "LecturerCourses.html"; }
	 */
	
	@GetMapping(value="/ViewCourse/{id}")
	public String ViewCourse(Model model,@PathVariable("id") Integer id)
	{
		model.addAttribute("lecturer",lservice.findLecturerById(id));
		//Lecturer l1=lservice.findLecturerById(lecturer.getId());
		List<Course> courses= cservice.findCoursesByLecturer(lservice.findLecturerById(id));
		model.addAttribute("courses", courses);
		return "CourseList.html"; 
	}
	
	@GetMapping(value="/ViewCourseEnrollment/{id}")
	public String ViewCourseEnrollment(Model model,@PathVariable("id") Integer id)
	{
		Course course=cservice.findCourseById(id);
		//List<Course> courses= cservice.findCoursesByLecturer(lservice.findLecturerById(id));
		List<Student> slist=new ArrayList<Student>();
		//for (Course course : courses) {
			Student student=course.getStudent();
			slist.add(student);
		//}
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
	 
	 
	
	

}
