package sg.edu.iss.caps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Enrollmenstatus;
import sg.edu.iss.caps.service.Courseservice;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	Courseservice cservice;
	
	// Accessible by everyone
	@GetMapping(value = "/list")
	public String list(Model model) {
		List<Course> listOfAllCourses = cservice.listAllCourses();
		model.addAttribute("courses", listOfAllCourses);
		return "CourseList.html";
	}
	
	
	// To view individual course
	@GetMapping(value = "/list/{code}")
	public String view(@PathVariable(value = "code") String code, Model model) {
		Course course = cservice.findCourseBycode(code);
		model.addAttribute("course", course);
		return "CourseView.html";
	}
	
	@GetMapping (value = "/save")
	public String savecourse(@ModelAttribute("course")Course course)
	{
		cservice.save(course);
		return "Enrolsuccess.html";
	}
	
	@GetMapping(value = "/enrol")
	public String enrolcourse(@PathVariable("code") String code)
	{
		Course course = cservice.findCourseBycode(code);
		Course.setStatus(Enrollmenstatus.SUBMITTED);
		if (cservice.checkcapacity(course)) {
			return "forward:/course/save";
		} else
			return "error";
	}
	

	@RequestMapping(value = "/withdraw/{code}")
	public String cancelBooking(@PathVariable("code") String code) {
		cservice.withdrawcourse(cservice.findCourseBycode(code));
		return "forward:/course/list";
	}
}
