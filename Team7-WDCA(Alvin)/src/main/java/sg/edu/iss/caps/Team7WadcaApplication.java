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
			cdrepo.save(cd1);
			cdrepo.save(cd2);			
			cdrepo.save(cd3);
			
			
			// Create Admin
			Admin admin = new Admin("Admin", null);
			String hashedPass99 = sCryptPasswordEncoder.encode("admin");
			Accounts ac99 = new Accounts("admin", hashedPass99, RoleType.ADMIN, admin);
			adminrepo.save(admin);
			urepo.save(ac99);

			
		};
	}
}
