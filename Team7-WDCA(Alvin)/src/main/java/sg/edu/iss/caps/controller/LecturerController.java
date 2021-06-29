package sg.edu.iss.caps.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.service.LecturerInterface;



@Controller
public class LecturerController {

	@Autowired
	LecturerInterface lservice;
	
	@Autowired
	public void setLecturer(LecturerInterface ls) {
		this.lservice = ls;
	}
	
	@RequestMapping(value="lecturer")
	public String home() {
		return "lecturer";
	}
	
	@RequestMapping(value="lecturer/list")
	public String listLecturer(Model model) {
		ArrayList<Course> clist = (ArrayList<Course>)lservice.listAllCourses();
		model.addAttribute("courses",clist);
		return "courselist";
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
