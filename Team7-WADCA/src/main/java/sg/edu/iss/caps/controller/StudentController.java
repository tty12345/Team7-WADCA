package sg.edu.iss.caps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.service.StudentServiceImplementation;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentServiceImplementation sservice;
	
	// For lecturer to view list of students
	@RequestMapping(value = "/list")
	public String list(Model model) {
		model.addAttribute("students", sservice.listAllStudents());
		return "students";
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
	
	@RequestMapping(value = "/edit")
	public String editForm(Model model) {
		//testing
		//testing2
	}
	
	@RequestMapping(value = "/delete/{id}")
	public String deleteStudent(@PathVariable("id") Integer id) {
		sservice.removeStudent(sservice.findStudentById(id));
		return "forward:/student/list";
	}
}
