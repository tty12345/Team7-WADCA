package sg.edu.iss.caps.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.repo.StudentRepository;
import sg.edu.iss.caps.service.AdminService;

@Controller
@RequestMapping("/manageStudent")
public class AdminController {
	@Autowired 
	AdminService aservice;
	@Autowired
	StudentRepository srepo;
	
	@GetMapping("/add")
	public String showStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "StudentForm";
	}
	
	@GetMapping("/save")
	public String saveStudentForm(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			return "StudentForm";
		}
		srepo.save(student);
		return "forward:/manageStudent/liststudents";
	}
	
	@GetMapping("/liststudents")
	public String listStudents(Model model) {
		model.addAttribute("students", srepo.findAll());
		return "StudentList";
	}
	
	@GetMapping("/edit/{id}")
	  public String showEditForm(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("student", srepo.findById(id).get());
		return "StudentForm";
	  }
	  
	  @GetMapping("/delete/{id}")
	  public String deleteMethod(Model model, @PathVariable("id") Integer id) {
		Student student =srepo.findById(id).get();
		srepo.delete(student);
		return "forward:/manageStudent/liststudents";
	  }
	

}
