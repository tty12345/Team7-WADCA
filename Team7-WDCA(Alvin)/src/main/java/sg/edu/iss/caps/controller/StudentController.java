package sg.edu.iss.caps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService sservice;
	
	// For lecturer or admin to view full list of students
	@GetMapping(value = "/list")
	public String list(Model model) {
		List<Student> listOfAllStudents = sservice.listAllStudents();
		model.addAttribute("students", listOfAllStudents);
		return "StudentList.html";
	}
	
	// For students to view their own information
	@GetMapping(value = "/info/{id}")
	public String info(@PathVariable(value = "id") int id, Model model) {
		Student current = sservice.findStudentById(id);
		model.addAttribute("studentinfo", current);
		return "StudentView.html";
	}
	
	// For admin to add students (extra feature)
//	@RequestMapping(value = "/add")
//	public String addForm(Model model) {
//
//	}
	
	// For admin or lecturer to search students (extra feature)
//	@RequestMapping(value = "/search")
//	public List<Student> searchStudents() {
//		
//	}
	
//	@RequestMapping(value = "/edit")
//	public String editForm(Model model) {
//		//testing
//		//testing2
//	}
	
	@GetMapping(value = "/delete/{id}")
	public String deleteStudent(@PathVariable("id") Integer id) {
		sservice.removeStudent(sservice.findStudentById(id));
		return "forward:/student/list";
	}
}
