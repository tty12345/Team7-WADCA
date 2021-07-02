package sg.edu.iss.caps;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import sg.edu.iss.caps.domain.Accounts;
import sg.edu.iss.caps.domain.Admin;
import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Coursedetail;
import sg.edu.iss.caps.domain.Lecturer;
import sg.edu.iss.caps.domain.RoleType;
import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.repo.AdminRepository;
//import net.bytebuddy.build.ToStringPlugin.Exclude;
//import sg.edu.iss.caps.domain.Accounts;
//import sg.edu.iss.caps.domain.RoleType;
import sg.edu.iss.caps.repo.CourseRepository;
import sg.edu.iss.caps.repo.CoursedetailRepository;
import sg.edu.iss.caps.repo.LecturerRepository;
import sg.edu.iss.caps.repo.StudentRepository;
import sg.edu.iss.caps.repo.accountsrepository;
import sg.edu.iss.caps.service.AdminService;
//import sg.edu.iss.caps.service.StudentServiceImplementation;
import sg.edu.iss.caps.service.StudentService;
import sg.edu.iss.caps.service.UserImplementation;
//import sg.edu.iss.caps.service.StudentServiceImplementation;a

@SpringBootApplication(exclude= {SecurityAutoConfiguration.class })
public class Team7WadcaApplication {
	
	@Autowired
	StudentRepository srepo;
	
	@Autowired
	StudentService sservice;
	
	@Autowired
	CourseRepository crepo;
	
	@Autowired
	accountsrepository urepo;

	@Autowired 
	AdminService aservice;
	
	@Autowired
	UserImplementation uservice;
	
	@Autowired
	CoursedetailRepository cdrepo;
	
	@Autowired
	LecturerRepository lrepo;
	
	@Autowired
	AdminRepository adminrepo;


	public static void main(String[] args) {
		SpringApplication.run(Team7WadcaApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			
			//Create Lecturers and linking them their respective log in accounts
			
			Lecturer l1=new Lecturer("John","Professor");
			Lecturer l2=new Lecturer("Venkat", "Senior Professor");

			lrepo.save(l1);lrepo.save(l2);
			
			SCryptPasswordEncoder sCryptPasswordEncoder = new SCryptPasswordEncoder();
			String hashedPass9 = sCryptPasswordEncoder.encode("john");
			Accounts ac9 = new Accounts("john@gmail.com", hashedPass9, RoleType.LECTURER, l1);
			urepo.save(ac9);
			
			String hashedPass10 = sCryptPasswordEncoder.encode("venkat");
			Accounts ac10 = new Accounts("venkat@gmail.com", hashedPass10, RoleType.LECTURER, l2);
			urepo.save(ac10);
			
			//Create Students and linking them to the courses(grades) and their respective log in accounts
			
			// Steve Rogers
			Course cl1 = new Course("BA3802", "Change Management", 4, l1, 70);
			Course cl2 = new Course("CH1150", "Organic Chemistry", 4, l1, 60);
			Course cl3 = new Course("CS1101", "Introduction To Computing", 4, l1, 60);
			List<Course> sc1 = new ArrayList<>();
			sc1.add(cl1);
			sc1.add(cl2);
			sc1.add(cl3);
			
			Student s1 = new Student("Steve", "Rogers", "History", sc1);
			srepo.save(s1);
			
			String hashedPass2 = sCryptPasswordEncoder.encode("steve");
			Accounts ac3 = new Accounts("steverogers", hashedPass2, RoleType.STUDENT, s1);
			urepo.save(ac3);
			
			cl1.setStudent(s1);
			cl2.setStudent(s1);
			cl3.setStudent(s1);
			crepo.save(cl1);
			crepo.save(cl2);
			crepo.save(cl3);
			
			// Tony Stark
			Course cl4 = new Course("MA1101", "Mathematics 1", 4, l1, 80);
			Course cl5 = new Course("MA1102", "Mathematics 2", 4, l1, 88);
			Course cl6 = new Course("PR1301", "Public Speaking And Presentations", 3, l1, 82);
			Course cl7 = new Course("RB3301", "Advanced Algorithms", 4, l1, 77);
			Course cl8 = new Course("CS1101","Introduction To Computing",4, l1, 75);
			List<Course> sc2 = new ArrayList<>();
			sc2.add(cl4);
			sc2.add(cl5);
			sc2.add(cl6);
			sc2.add(cl7);
			sc2.add(cl8);

			Student s2 = new Student("Tony", "Stark", "Mechanical Engineering", sc2);
			srepo.save(s2);
			
			String hashedPass3 = sCryptPasswordEncoder.encode("tony");
			Accounts ac4 = new Accounts("tonystark", hashedPass3, RoleType.STUDENT, s2);
			urepo.save(ac4);
			
			cl4.setStudent(s2);
			cl5.setStudent(s2);
			cl6.setStudent(s2);
			cl7.setStudent(s2);
			cl8.setStudent(s2);
			crepo.save(cl4);
			crepo.save(cl5);
			crepo.save(cl6);
			crepo.save(cl7);
			crepo.save(cl8);
		
			
			
			// Natasha Romanov
			Course cl9 = new Course("GE1101", "Introduction To Geography", 4, l1, 70);
			Course cl10 = new Course("GE2501", "Human Geography", 4, l1, 75);
			Course cl11 = new Course("PS2301", "USSR: A Retrospective", 4, l1, 85);
			Course cl12=new Course("CS1101","Introduction To Computing",3,l1,99);
			List<Course> sc3 = new ArrayList<>();
			sc3.add(cl9);
			sc3.add(cl10);
			sc3.add(cl11);
			sc3.add(cl12);
			
			Student s3 = new Student("Natasha", "Romanov", "Global Studies", sc3);
			srepo.save(s3);
			
			String hashedPass4 = sCryptPasswordEncoder.encode("ussr");
			Accounts ac5 = new Accounts("natasha", hashedPass4, RoleType.STUDENT, s3);
			urepo.save(ac5);
			
			cl9.setStudent(s3);
			cl10.setStudent(s3);
			cl11.setStudent(s3);
			cl12.setStudent(s3);
			crepo.save(cl9);
			crepo.save(cl10);
			crepo.save(cl11);
			crepo.save(cl12);
			
			
			// Bruce Banner
			Course cl13 = new Course("BA4201", "Business Intelligence", 4, l2, 67);
			Course cl14 = new Course("PY4402", "Solid State Physics", 4, l2, 81);
			Course cl15 = new Course("PY4676", "Quantum Physics", 4, l2, 87);
			Course cl16 = new Course("ME2401", "Fluid Mechanics", 4, l2, 79);
			List<Course> sc4 = new ArrayList<>();
			sc4.add(cl13);
			sc4.add(cl14);
			sc4.add(cl15);
			sc4.add(cl16);
			
			Student s4 = new Student("Bruce", "Banner", "Physics", sc4);
			srepo.save(s4);
			
			String hashedPass5 = sCryptPasswordEncoder.encode("hulk");
			Accounts ac6 = new Accounts("brucebanner", hashedPass5, RoleType.STUDENT, s4);
			urepo.save(ac6);
			
			cl13.setStudent(s4);
			cl14.setStudent(s4);
			cl15.setStudent(s4);
			cl16.setStudent(s4);
			crepo.save(cl13);
			crepo.save(cl14);
			crepo.save(cl15);
			crepo.save(cl16);
			
			
			// Peter Parker
			Course cl17 = new Course("GS2303", "Southeast Asian Studies", 4, l2, 72);
			Course cl18 = new Course("HS3422", "World Wars", 4, l2, 77);
			Course cl19 = new Course("PR2101", "Communication In The Workplace", 3, l2, 76);
			List<Course> sc5 = new ArrayList<>();
			sc5.add(cl17);
			sc5.add(cl18);
			sc5.add(cl19);
			
			Student s5 = new Student("Peter", "Parker", "Chemistry", sc5);
			srepo.save(s5);
			
			String hashedPass6 = sCryptPasswordEncoder.encode("spider");
			Accounts ac7 = new Accounts("peterparker", hashedPass6, RoleType.STUDENT, s5);
			urepo.save(ac7);
			
			cl17.setStudent(s5);
			cl18.setStudent(s5);
			cl19.setStudent(s5);
			crepo.save(cl17);
			crepo.save(cl18);
			crepo.save(cl19);
			
			// Wanda Maximoff
			Course cl20 = new Course("AS3350", "Asgardian Legends", 4, l2, 70);
			Course cl21 = new Course("AS3355", "Asgardian Folklore", 4, l2, 78);
			Course cl22 = new Course("AC1002", "Financial Accounting", 4, l2, 63);
			Course cl23 = new Course("HI3203", "Sokovian History", 4, l2, 81);
			List<Course> sc6 = new ArrayList<>();
			sc6.add(cl20);
			sc6.add(cl21);
			sc6.add(cl22);
			sc6.add(cl23);
			
			Student s6 = new Student("Wanda", "Maximoff", "History", sc6);
			srepo.save(s6);
			
			String hashedPass7 = sCryptPasswordEncoder.encode("vision");
			Accounts ac8 = new Accounts("wandamaximoff", hashedPass7, RoleType.STUDENT, s6);
			urepo.save(ac8);
			
			cl20.setStudent(s6);
			cl21.setStudent(s6);
			cl22.setStudent(s6);
			cl23.setStudent(s6);
			crepo.save(cl20);
			crepo.save(cl21);
			crepo.save(cl22);
			crepo.save(cl23);
			
			//making a list of courses(grades) that below to the same course detail
			
			//CS1101 - Steve, Tony and Natasha
			List<Course> courselist1 = new ArrayList<>();
			courselist1.add(cl3);
			courselist1.add(cl8);
			courselist1.add(cl12);
			
			//MA1101 Tony
			List<Course> courselist2 = new ArrayList<>();
			courselist2.add(cl4);
			
			//MA1102 Tony
			List<Course> courselist3 = new ArrayList<>();
			courselist3.add(cl5);
			
			
			
			//Creating Course details and linking them to their lectureres
			Coursedetail cd1 = new Coursedetail (10, "CS1101", "Introduction To Computing", courselist1, "Learn Computer",l1 );
			Coursedetail cd2 = new Coursedetail(1, "MA1101", "Mathematics 1", courselist2, "learn math" ,l1);
			Coursedetail cd3 = new Coursedetail(10,"MA1102", "Mathematics 2", courselist3,"learn more math", l2);

			
			// Course details
			Coursedetail cd1 = new Coursedetail (1,10, "CS1101", "Introduction To Computing", "2021","This course is suitable for students who wish to use the computer as a tool for problem solving", 4, l1);
			Coursedetail cd2 = new Coursedetail(2,1, "MA1101", "Mathematics 1", "2021","Develops algebraic concepts and skills needed to graph and solve linear equations and inequalities" , 4, l1);
//			Coursedetail cd3 = new Coursedetail(3,10,"MA1102", "Mathematics 2", "01/08/2021","Intensive course in intermediate algebra and trigonometry", 4, l1);
//			Coursedetail cd4 = new Coursedetail(4, 15, "PR1301", "Public Speaking And Presentations", "01/08/2021","The course will prepare you for public speaking and presentation", 3, l1);
//			Coursedetail cd5 = new Coursedetail(5, 20,"RB3301", "Advanced Algorithms", "01/09/2021", "This course emphasis is placed on fundamental algorithms and advanced algorithmic design", 4, l1);
//			Coursedetail cd6 = new Coursedetail(6, 15, "GE1101", "Introduction To Geography", "10/09/2021","This course is an introduction to the global perspectives, basic concepts and fundamental questions of geography", 4, l1);
//			Coursedetail cd7 = new Coursedetail(7, 20, "GE2501", "Human Geography", "05/08/2021", "This course is concerned with the study of human societies and challenges", 4, l1);
//			Coursedetail cd8 = new Coursedetail(8,15,"PS2301", "USSR: A Retrospective", "04/07/2021", "This course talk about after overthrowing the centuries-old Romanov monarchy", 4, l1);
//			Coursedetail cd9 = new Coursedetail(9,10, "BA3802", "Change Management", "05/07/2021", "The training focuses on developing the critical skills needed in workplace",4, l1);
//			Coursedetail cd10 = new Coursedetail(10,15,"BA4201", "Business Intelligence", "08/09/2021", "This course provides an overview of the technology of BI and application", 4, l2);
//			Coursedetail cd11 = new Coursedetail(11,10,"PY4402", "Solid State Physics", "06/09/2021","The course will provide a valuable theoretical introduction and overview", 4, l2);
//			Coursedetail cd12 = new Coursedetail(12,20,"PY4676", "Quantum Physics", "01/07/2021", "This course covers the experimental basis of quantum physics", 4, l2);
//			Coursedetail cd13 = new Coursedetail(13,15,"ME2401", "Fluid Mechanics", "01/09/2021", "This course is on fluid motion and the forces that are exerted on them", 4, l2);					
//			Coursedetail cd14 = new Coursedetail(14,10,"GS2303", "Southeast Asian Studies", "03/08/2021", "This course promotes the study of Southeast Asia Countries.", 4, l2);
//			Coursedetail cd15 = new Coursedetail(15,15,"HS3422", "World Wars", "01/10/2021", "This course understand the basic history of the war", 4, l2);
//			Coursedetail cd16 = new Coursedetail(16,20,"CH1150", "Organic Chemistry", "02/10/2021", "Organic chemistry give necessary background to understand organic chemistry", 4, l2);
//			Coursedetail cd17 = new Coursedetail(17,15,"PR2101", "Communication In The Workplace", "02/09/2021","This course explores the importance of communication as a skill in the workplace", 3, l2);
//			Coursedetail cd18 = new Coursedetail(18,10,"AS3350", "Asgardian Legends", "10/09/2021", "This course discuss about Asgardian Legends" , 4, l2);
//			Coursedetail cd19 = new Coursedetail(19,15,"AS3355", "Asgardian Folklore", "01/09/2021", "This course discuss about Asgardian Folklore", 4, l2);
//			Coursedetail cd20 = new Coursedetail(20,10,"AC1002", "Financial Accounting","02/11/2021","This course focuses on profit-oriented business organizations", 4, l2);
//			Coursedetail cd21 = new Coursedetail(21,5,"MD4504", "Neurosurgery", "01/11/2021","The course relate to other clinical scientists and to understand the scientific principles underlying this field", 4, l2);

			cdrepo.save(cd1);
			cdrepo.save(cd2);			
//			cdrepo.save(cd3);
//			cdrepo.save(cd4);
//			cdrepo.save(cd5);			
//			cdrepo.save(cd6);
//			cdrepo.save(cd7);
//			cdrepo.save(cd8);			
//			cdrepo.save(cd9);
//			cdrepo.save(cd10);
//			cdrepo.save(cd11);			
//			cdrepo.save(cd12);
//			cdrepo.save(cd13);
//			cdrepo.save(cd14);
//			cdrepo.save(cd15);			
//			cdrepo.save(cd16);
//			cdrepo.save(cd17);
//			cdrepo.save(cd18);			
//			cdrepo.save(cd19);
//			cdrepo.save(cd20);
//			cdrepo.save(cd21);	
			
			
			// Create Admin
			Admin admin = new Admin("Admin", null);
			String hashedPass99 = sCryptPasswordEncoder.encode("admin");
			Accounts ac99 = new Accounts("admin", hashedPass99, RoleType.ADMIN, admin);
			adminrepo.save(admin);
			urepo.save(ac99);

			
		};
	}
}
