package sg.edu.iss.caps.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Accounts;
import sg.edu.iss.caps.domain.RoleType;
import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.service.StudentService;
import sg.edu.iss.caps.service.UserInterface;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService sservice;
	
	@Autowired
	UserInterface uservice;
	
	// For lecturer or admin to view full list of students
	@GetMapping(value = "/list")
	public String list(Model model, HttpSession session) {
		
		//Accounts user = (Accounts) session.getAttribute("usession");
		List<Student> listOfAllStudents = sservice.listAllStudents();
		model.addAttribute("students", listOfAllStudents);
		
		// if user is lecturer or admin, show all information and if student, show limited information
		if (uservice.checkSession(session, "stu")) {
			return "StudentList-stu.html";
		} else if (uservice.checkSession(session, "lecturer") || uservice.checkSession(session, "admin")) {
			return "StudentList-lecturer.html";
		} else {
			return "login.html";
		}
	}
	
	// For students to view their own information
	@GetMapping(value = "/info/{id}")
	public String info(@PathVariable(value = "id") int id, Model model, HttpSession session) {
		if (uservice.checkSession(session, "usession")) {
			return "index";
		}
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
