package sg.edu.iss.caps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.service.CourseService;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	CourseService cservice;
	
	// Accessible by everyone
	@GetMapping(value = "/list")
	public String list(Model model) {
		List<Course> listOfAllCourses = cservice.listAllCourses();
		model.addAttribute("courses", listOfAllCourses);
		return "CourseList.html";
	}
	
	// To view individual course
	@GetMapping(value = "/list/{id}")
	public String view(@PathVariable(value = "id") int id, Model model) {
		Course course = cservice.findCourseById(id);
		model.addAttribute("course", course);
		return "CourseView.html";
	}
	
	@PostMapping
	public void enrol(String code) {
		
	}
}
