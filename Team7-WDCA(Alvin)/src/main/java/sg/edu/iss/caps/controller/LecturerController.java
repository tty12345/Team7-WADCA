package sg.edu.iss.caps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Lecturer;

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
	
	@GetMapping(value="/home")
	public String showHomePage() {
		return "LecturerMainPage";
	}
	
	/*
	 * @RequestMapping("/ViewCourse") public String viewCourses(Model model,Lecturer
	 * lecturer) { //Lecturer lecturer=new Lecturer(); Lecturer
	 * l1=lservice.findLecturerById(lecturer.getId()); List<Course> courses=
	 * cservice.findCoursesByLecturer(l1); model.addAttribute("courses",courses);
	 * return "LecturerCourses.html"; }
	 */
	
	@RequestMapping(value="ViewCourse")
	public String ViewCourse(@ModelAttribute("lecturer") Lecturer lecturer,Model model)
	{
		Lecturer l1=lservice.findLecturerById(lecturer.getId());
		List<Course> courses= cservice.findCoursesByLecturer(l1);
		model.addAttribute("courses", courses);
		return "CourseList.html"; 
	}
	
	

}
