package sg.edu.iss.caps.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
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
	public String list(Model model) {
//		List<Student> listOfAllStudents = sservice.listAllStudents();
		
//		model.addAttribute("students", listOfAllStudents);
		int currentpage = 0;
		
		List<Student> listWithPagination = sservice.getAllStudents(currentpage, 5);
		
		model.addAttribute("students", listWithPagination);
		
		model.addAttribute("currentPage", currentpage);
		
		return "StudentList.html";
	}
	
	@GetMapping(value = "/navigate")
	public String customlist(@RequestParam(value = "pageNo")Integer pageNo ,Model model) {
		
		List<Student> listWithPagination = sservice.getAllStudents(pageNo-1, 5);
		model.addAttribute("students", listWithPagination);
		return "StudentList.html";
	}
	
	@GetMapping(value = "/forward/{currentPage}")
	public String arrowlist(@PathVariable(value = "currentPage")String pageNo ,Model model) {
		Integer i = Integer.parseInt(pageNo);
		
		List<Student> listWithPagination = sservice.getAllStudents(i+1, 5);
		
		model.addAttribute("students", listWithPagination);
		
		model.addAttribute("currentPage", i+1);
		
		return "StudentList.html";
	}
	
	@GetMapping(value = "/backward/{currentPage}")
	public String backlist(@PathVariable(value = "currentPage")String pageNo ,Model model) {
		Integer i = Integer.parseInt(pageNo);
		
		List<Student> listWithPagination = sservice.getAllStudents(i-1, 5);
		
		model.addAttribute("students", listWithPagination);
		
		model.addAttribute("currentPage", i-1);
		
		return "StudentList.html";
	}
	
	// For students to view their own information
	@GetMapping(value = "/info/{id}")
	public String info(@PathVariable(value = "id") int id, Model model,HttpSession session) {
		
		if (!uservice.checkSession(session, "stu"))
			return "index";
		
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
