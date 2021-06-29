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

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Lecturer;
import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.repo.CourseRepository;
import sg.edu.iss.caps.repo.LecturerRepository;
import sg.edu.iss.caps.repo.StudentRepository;
import sg.edu.iss.caps.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired 
	AdminService aservice;
	@Autowired
	StudentRepository srepo;
	@Autowired
	LecturerRepository lrepo;
	@Autowired
	CourseRepository crepo;
	
	
	//manage student
	@GetMapping("/addStudent")
	public String showStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "StudentForm";
	}
	
	@GetMapping("/saveStudent")
	public String saveStudentForm(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			return "StudentForm";
		}
		srepo.save(student);
		return "forward:/admin/listStudents";
	}
	
	@GetMapping("/listStudents")
	public String listStudents(Model model) {
		model.addAttribute("students", srepo.findAll());
		return "StudentList";
	}
	
	@GetMapping("/editStudent/{id}")
	  public String showEditStuForm(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("student", srepo.findById(id).get());
		return "StudentForm";
	  }
	  
	  @GetMapping("/deleteStudent/{id}")
	  public String deleteMethod(Model model, @PathVariable("id") Integer id) {
		Student student =srepo.findById(id).get();
		srepo.delete(student);
		return "forward:/admin/listStudents";
	  }
	  
	  
	  //manage lecturer
	  @GetMapping("/addLecturer")
		public String showLecturerForm(Model model) {
			Lecturer lecturer=new Lecturer();
			model.addAttribute("lecturer", lecturer);
			return "LecturerForm";
		}
		
		@GetMapping("/saveLecturer")
		public String saveLecturerForm(@ModelAttribute("lecturer") @Valid Lecturer lecturer, BindingResult bindingResult, Model model) {
			
			if (bindingResult.hasErrors()) {
				return "LecturerForm";
			}
			lrepo.save(lecturer);
			return "forward:/admin/listLecturers";
		}
		
		@GetMapping("listLecturers")
		public String listLecturers(Model model) {
			model.addAttribute("lecturers", lrepo.findAll());
			return "LecturerList";
		}
	
		@GetMapping("/editLecturer/{id}")
		  public String showEditLecForm(Model model, @PathVariable("id") Integer id) {
			model.addAttribute("lecturer", lrepo.findById(id).get());
			return "LecturerForm";
		  }
	  
		  @GetMapping("/deleteLecturer/{id}")
		  public String deleteLecMethod(Model model, @PathVariable("id") Integer id) {
			Lecturer lecturer =lrepo.findById(id).get();
			lrepo.delete(lecturer);
			return "forward:/admin/listLecturers";
		  }
		  
		  //manage course
		  
		  @GetMapping("/addCourse")
			public String showCourseForm(Model model) {
				Course course =new Course();
				model.addAttribute("course", course);
				return "CourseForm";
			}
			
			@GetMapping("/saveCourse")
			public String saveCourseForm(@ModelAttribute("course") @Valid Course course, BindingResult bindingResult, Model model) {
				
				if (bindingResult.hasErrors()) {
					return "CourseForm";
				}
				crepo.save(course);
				return "forward:/admin/listCourses";
			}
			
			@GetMapping("listCourses")
			public String listCourses(Model model) {
				model.addAttribute("courses", crepo.findAll());
				return "AdCourseList";
			}
		
			@GetMapping("/editCourse/{id}")
			  public String showEditCorForm(Model model, @PathVariable("id") Integer id) {
				model.addAttribute("course", crepo.findById(id).get());
				return "CourseForm";
			  }
		  
			  @GetMapping("/deleteCourse/{id}")
			  public String deleteCorMethod(Model model, @PathVariable("id") Integer id) {
				Course course =crepo.findById(id).get();
				crepo.delete(course);
				return "forward:/admin/listCourses";
			  }

	 
}
