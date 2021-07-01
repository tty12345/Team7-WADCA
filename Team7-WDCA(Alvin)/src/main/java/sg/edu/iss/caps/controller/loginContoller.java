package sg.edu.iss.caps.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.caps.domain.Accounts;
import sg.edu.iss.caps.domain.Lecturer;
import sg.edu.iss.caps.domain.RoleType;
import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.service.LecturerService;
import sg.edu.iss.caps.service.StudentService;
import sg.edu.iss.caps.service.UserInterface;

@Controller
public class loginContoller {
	
	@Autowired
	StudentService sservice;
	@Autowired
	LecturerService lservice;
	
	@Autowired
	UserInterface u;
	@Autowired
	public void setUserInterface(UserInterface uimpl) {
		this.u = uimpl;
	}
	
	@RequestMapping("/login")
	public String loginForm(Model model) {
		Accounts u = new Accounts();
		model.addAttribute("user", u);
		return "login";
	}
	
	@PostMapping("/authenticate")
	public String authenticate(@ModelAttribute("user")Accounts user, HttpSession session, Model model) {
		String returnPage;
		if (u.authenticateUser(user))
		{
			
			Accounts loggeduser = u.findByName(user.getUsername());
			
			if(loggeduser.getRole() == RoleType.STUDENT)
			{	
				Student login_user = sservice.findStudentByUsername(user.getUsername());
				model.addAttribute("student", login_user);
				session.setAttribute("stu",loggeduser);
				session.setAttribute("currentStudent",login_user);
				return "StudentMainPage";
			}
			else if (loggeduser.getRole() == RoleType.ADMIN)
			{
				session.setAttribute("admin", loggeduser);
				return "AdminMainPage";	
			}
			else 
			{
				Lecturer login_user=lservice.findLecturerByUsername(user.getUsername());
				model.addAttribute("lecturer", login_user);
				session.setAttribute("lect", loggeduser);
				session.setAttribute("currentLecturer", login_user);
				return  "LecturerMainPage";
			}
		}
		else
			returnPage = "login";
		
		return returnPage;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("stu");
		session.removeAttribute("currentStudent");
        session.removeAttribute("admin");
        session.removeAttribute("lect");
		return "index";
	}
}
































