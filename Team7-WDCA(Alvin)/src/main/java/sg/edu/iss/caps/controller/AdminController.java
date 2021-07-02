package sg.edu.iss.caps.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Accounts;
import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Coursedetail;
import sg.edu.iss.caps.domain.Lecturer;
import sg.edu.iss.caps.domain.RoleType;
import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.repo.CourseRepository;
import sg.edu.iss.caps.repo.CoursedetailRepository;
import sg.edu.iss.caps.repo.LecturerRepository;
import sg.edu.iss.caps.repo.StudentRepository;
import sg.edu.iss.caps.repo.accountsrepository;
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
	@Autowired
	accountsrepository arepo;
	@Autowired
	CoursedetailRepository cdrepo;
	@Autowired
	LecturerRepository lservice;
	@Autowired
	CourseRepository cservice;

	//manage student
	
	//enroll student to the school
	@GetMapping("/addStudent")
	public String showStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "StudentForm-admin";
	}
	
	//Edit student's detail
	@GetMapping("/editStudent/{id}")
	  public String showEditStuForm(Model model, @PathVariable("id") Integer id) {
		Student student = aservice.findStudentById(id);
		model.addAttribute("student", student);
		return "StudentForm-admin";
	  }
	
	//Save student's details after editing
	@GetMapping("/saveStudent")
	public String saveStudentForm(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			return "StudentForm-admin";
		}
		aservice.save(student);
		Accounts acc = student.getAccount();
		SCryptPasswordEncoder sCryptPasswordEncoder = new SCryptPasswordEncoder();
		String password = sCryptPasswordEncoder.encode(acc.getPassword());
		acc.setStudent(student);
		acc.setPassword(password);
		acc.setRole(RoleType.STUDENT);
		arepo.save(acc);
		return "forward:/admin/listStudents";
	}
	
	//Show all student
	@GetMapping("/listStudents")
	public String listStudents(Model model) {
		model.addAttribute("students", aservice.findAllStudent());
		return "StudentList-admin.html";
	}
	//Remove students and all records from database
	@GetMapping("/deleteStudent/{id}")
	public String deleteMethod(Model model, @PathVariable("id") Integer id) {
		
		Student student =aservice.findStudentById(id);
		Accounts account = aservice.findAccountByStudentId(id);
		List<Course> courses = aservice.findCoursesByStudentId(id);
		
		aservice.deleteRelatedCourses(courses);
		aservice.deleteAcc(account);
		aservice.deleteStu(student);
		return "forward:/admin/listStudents";
	  }  
	  
	  //manage lecturer
	  
	  //adds a new lecturer
	  @GetMapping("/addLecturer")
	  public String showLecturerForm(Model model) {
			Lecturer lecturer=new Lecturer();
			model.addAttribute("lecturer", lecturer);
			return "LecturerForm-admin";
		}
	  
	  //edit lecturer information
	  @GetMapping("/editLecturer/{id}")
	  public String showEditLecForm(Model model, @PathVariable("id") Integer id) {
			model.addAttribute("lecturer", aservice.findLecturerById(id));
			return "LecturerForm-admin";
		}
	  
	  @GetMapping("/saveLecturer")
	  public String saveLecturerForm(@ModelAttribute("lecturer") @Valid Lecturer lecturer, BindingResult bindingResult, Model model) {
			
			if (bindingResult.hasErrors()) {
				return "LecturerForm-admin";
			}
			lservice.save(lecturer);
			Accounts acc = lecturer.getAccount();
			SCryptPasswordEncoder sCryptPasswordEncoder = new SCryptPasswordEncoder();
			String password = sCryptPasswordEncoder.encode(acc.getPassword());
			acc.setLecturer(lecturer);
			acc.setPassword(password);
			acc.setRole(RoleType.LECTURER);
			arepo.save(acc);
			lservice.save(lecturer);
			return "forward:/admin/listLecturers";
		}
	  	//list all lecturers
		@GetMapping("/listLecturers")
		public String listLecturers(Model model) {
			model.addAttribute("lecturers", lservice.findAll());
			return "LecturerList";
		}
		
		//delete all lecturer and relevant data from database
		  @GetMapping("/deleteLecturer/{id}")
		  public String deleteLecMethod(Model model, @PathVariable("id") Integer id) {
			Lecturer lecturer =lservice.findById(id).get();
			Accounts account = aservice.findAccountByLecturerId(id);
			List<Course> courses = aservice.findCoursesByLecturerId(id);
			
			
			for (Course course : courses) {
				course.setLecturer(null);
				cservice.save(course);
			}
			
			aservice.delete(account);
			lservice.delete(lecturer);
			return "forward:/admin/listLecturers";
		  }
		  
//		  @GetMapping("/LecViewCourses/{id}")
//		  public String viewCourses(Model model, @PathVariable("id") Integer id) {
//			  Lecturer lecturer =lrepo.findById(id).get();
//			  Collection<Course> courses=lecturer.getCourses();
//			  return "LecCourseList";
//		  }
//		  @GetMapping("/addLecCourse")
//		  public String addLecCourse(Model model) {
//				Course course=new Course();
//				model.addAttribute("course", course);
//				
//			    return "LecCourseForm";
//		  }
//			@GetMapping("/saveLecCourse")
//			public String saveLecCourseForm(@ModelAttribute("course") @Valid Course course, BindingResult bindingResult, Model model) {
//				
//				if (bindingResult.hasErrors()) {
//					return "LecCourseForm";
//				}
//				lrepo.save(course);
//				return "forward:/admin/LecViewCourse";
//			}
		  
		  
		  //manage course
		  
		  @GetMapping("/addCourse")
			public String showCourseForm(Model model) {
				Coursedetail coursedetail =new Coursedetail();
				model.addAttribute("coursedetail", coursedetail);
				return "CourseDetailForm";
			}
			
			@GetMapping("/saveCourse")
			public String saveCourseForm(@ModelAttribute("coursedetail") @Valid Coursedetail coursedetail, BindingResult bindingResult, Model model) {
				
				if (bindingResult.hasErrors()) {
					return "CourseForm";
				}
				coursedetail.setLecturer(coursedetail.getLecturer());
				cdrepo.save(coursedetail);
				return "redirect:/admin/listCourseDetails";
			}
			
			@GetMapping("/listCourseDetails")
			public String listCourses(Model model) {
				model.addAttribute("coursedetails", cdrepo.findAll());
				return "CourseList-Admin";
			}
		
			@GetMapping("/editCourse/{id}")
			  public String showEditCorForm(Model model, @PathVariable("id") Integer id) {
				model.addAttribute("course", crepo.findById(id).get());
				return "CourseDetailForm";
			  }
		  
			  @GetMapping("/deleteCourse/{id}")
			  public String deleteCorMethod(Model model, @PathVariable("id") Integer id) {
				Course course =crepo.findById(id).get();	
				crepo.delete(course);
				return "forward:/admin/listCourses";
			  }

			  
	 
}
