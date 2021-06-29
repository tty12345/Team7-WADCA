package sg.edu.iss.caps;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import net.bytebuddy.build.ToStringPlugin.Exclude;
import sg.edu.iss.caps.domain.Accounts;
import sg.edu.iss.caps.domain.RoleType;
import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Lecturer;


import sg.edu.iss.caps.domain.Student;
//import net.bytebuddy.build.ToStringPlugin.Exclude;
//import sg.edu.iss.caps.domain.Accounts;
//import sg.edu.iss.caps.domain.RoleType;

import sg.edu.iss.caps.domain.RoleType;
//import sg.edu.iss.caps.domain.Student;

import sg.edu.iss.caps.repo.CourseRepository;
import sg.edu.iss.caps.repo.StudentRepository;
import sg.edu.iss.caps.service.StudentServiceImplementation;
import sg.edu.iss.caps.service.UserImplementation;
import sg.edu.iss.caps.repo.accountsrepository;
import sg.edu.iss.caps.repo.accountsrepository;

//import sg.edu.iss.caps.service.StudentServiceImplementation;
import sg.edu.iss.caps.service.StudentService;

import sg.edu.iss.caps.service.AdminService;
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


	public static void main(String[] args) {
		SpringApplication.run(Team7WadcaApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			// Lecturers	
			Lecturer l1 = new Lecturer("Walter White", "Senior Lecturer");
			lrepo.save(l1);
		
			SCryptPasswordEncoder sCryptPasswordEncoder = new SCryptPasswordEncoder();
			String hashedPass = sCryptPasswordEncoder.encode("blue");
			Accounts ac1 = new Accounts("walterwhite", hashedPass, RoleType.LECTURER, l1);
			urepo.save(ac1);
			
			Course cl1 = new Course("BA3802", "Change Management", 4, l1);
			Course cl2 = new Course("CH1150", "Organic Chemistry", 4, l1);
			Course cl3 = new Course("CS1101", "Introduction To Computing", 4, l1);
			Course cl4 = new Course("MA1101", "Mathematics 1", 4, l1);
			Course cl5 = new Course("MA1102", "Mathematics 2", 4, l1);
			Course cl6 = new Course("PR1301", "Public Speaking And Presentations", 3, l1);
			Course cl7 = new Course("RB3301", "Advanced Algorithms", 4, l1);
			Course cl8 = new Course("GE1101", "Introduction To Geography", 4, l1);
			Course cl9 = new Course("GE2501", "Human Geography", 4, l1);
			Course cl10 = new Course("PS2301", "USSR: A Retrospective", 4, l1);
			List<Course> lc1 = new ArrayList<>();
			lc1.add(cl1);
			lc1.add(cl2);
			lc1.add(cl3);
			lc1.add(cl4);
			lc1.add(cl5);
			lc1.add(cl6);
			lc1.add(cl7);
			lc1.add(cl8);
			lc1.add(cl9);
			lc1.add(cl10);
			l1.setCourses(lc1);
			
			lrepo.save(l1);
			crepo.save(cl1);
			crepo.save(cl2);
			crepo.save(cl3);
			crepo.save(cl4);
			crepo.save(cl5);
			crepo.save(cl6);
			crepo.save(cl7);
			crepo.save(cl8);
			crepo.save(cl9);
			crepo.save(cl10);

			Student s1 = new Student("Steve", "Rogers", "History");
			Student s2 = new Student("Tony", "Stark", "Engineering");
			Student s3 = new Student("Natasha", "Romanov", "Global Studies");
			Student s4 = new Student("Bruce", "Banner", "Physics");
			Student s5 = new Student("Bruce", "Wayne", "Engineering");
			Student s6 = new Student("Peter", "Parker", "Chemistry");


			Lecturer l2 = new Lecturer("Jesse Pinkman", "Lecturer");
			lrepo.save(l2);
		
			String hashedPass1 = sCryptPasswordEncoder.encode("pink");
			Accounts ac2 = new Accounts("walterwhite", hashedPass1, RoleType.LECTURER, l2);
			urepo.save(ac2);
			
			Course cl11 = new Course("BA4201", "Business Intelligence", 4, l2);
			Course cl12 = new Course("PY4402", "Solid State Physics", 4, l2);
			Course cl13 = new Course("PY4676", "Quantum Physics", 4, l2);
			Course cl14 = new Course("ME2401", "Fluid Mechanics", 4, l2);
			Course cl15 = new Course("GS2303", "Southeast Asian Studies", 4, l2);
			Course cl16 = new Course("HS3422", "World Wars", 4, l2);
			Course cl17 = new Course("PR2101", "Communication In The Workplace", 3, l2);
			Course cl18 = new Course("AS3350", "Asgardian Legends", 4, l2);
			Course cl19 = new Course("AS3355", "Asgardian Folklore", 4, l2);
			Course cl20 = new Course("AC1002", "Financial Accounting", 4, l2);
			Course cl21 = new Course("MD4504", "Neurosurgery", 4, l2);
			List<Course> lc2 = new ArrayList<>();
			lc2.add(cl11);
			lc2.add(cl12);
			lc2.add(cl13);
			lc2.add(cl14);
			lc2.add(cl15);
			lc2.add(cl16);
			lc2.add(cl17);
			lc2.add(cl18);
			lc2.add(cl19);
			lc2.add(cl20);
			lc2.add(cl21);
			l2.setCourses(lc2);
			
			lrepo.save(l2);
			crepo.save(cl11);
			crepo.save(cl12);
			crepo.save(cl13);
			crepo.save(cl14);
			crepo.save(cl15);
			crepo.save(cl16);
			crepo.save(cl17);
			crepo.save(cl18);
			crepo.save(cl19);
			crepo.save(cl20);
			crepo.save(cl21);
			
			
//			Accounts acc = new Accounts("steven", hashedPass, RoleType.STUDENT, s1);
//			urepo.save(acc);
//			Student s1 = new Student("Steve", "Rogers", "History");
//			Student s2 = new Student("Tony", "Stark", "Engineering");
//			Student s3 = new Student("Natasha", "Romanov", "Global Studies");
//			Student s4 = new Student("Bruce", "Banner", "Physics");
//			Student s6 = new Student("Peter", "Parker", "Chemistry");

//
//			srepo.save(s1);
//			srepo.save(s2);
//			srepo.save(s3);
//			srepo.save(s4);
//			srepo.save(s5);
//			srepo.save(s6);


			Student s7 = new Student("Wanda", "Maximoff", "Geography");
			Student s8 = new Student("Vision", null, "Robotics");
			Student s9 = new Student("Thor", "Odinson", "Asgardian Studies");
			Student s10 = new Student("Loki", "Odinson", "Asgardian Studies");
			Student s11 = new Student("T'Challa", null, "Business Studies");
			Student s12 = new Student("Bucky", "Barnes", "Political Science");
			srepo.save(s7);
			srepo.save(s8);
			srepo.save(s9);
			srepo.save(s10);
			srepo.save(s11);
		    srepo.save(s12);
			
			Student s13 = new Student("Steven", "Strange", "Medicine");
			Student s14 = new Student("Carol", "Danvers", "Engineering");
			srepo.save(s13);
			srepo.save(s14);

//			Student s7 = new Student("Wanda", "Maximoff", "Geography");
//			Student s8 = new Student("Vision", null, "Robotics");
//			Student s9 = new Student("Thor", "Odinson", "Asgardian Studies");
//			Student s10 = new Student("Loki", "Odinson", "Asgardian Studies");
//			Student s11 = new Student("T'Challa", null, "Business Studies");
//			Student s12 = new Student("Bucky", "Barnes", "Political Science");
//			Student s13 = new Student("Steven", "Strange", "Medicine");
//			Student s14 = new Student("Carol", "Danvers", "Engineering");
//			Student s15 = new Student("Peter", "Quill", "Business Studies");
//			srepo.save(s1);
//			srepo.save(s2);
//			srepo.save(s3);
//			srepo.save(s4);

			/*
			 * srepo.save(s1); srepo.save(s2); srepo.save(s3); srepo.save(s4);
			 */
//			srepo.save(s6);
//			srepo.save(s7);
//			srepo.save(s8);
//			srepo.save(s9);
//			srepo.save(s10);
//			srepo.save(s11);
//			srepo.save(s12);
			
//			Student s13 = new Student("Steven", "Strange", "Medicine");
//			Student s14 = new Student("Carol", "Danvers", "Engineering");
//			srepo.save(s13);
//			srepo.save(s14);
//			srepo.save(s15);

			
		
//			Course c1 = new Course("CS1101", "Introduction To Computing", 4);
//			Course c2 = new Course("MA1101", "Mathematics 1", 4);
//			Course c3 = new Course("MA1102", "Mathematics 2", 4);
//			Course c4 = new Course("PR1301", "Public Speaking And Presentations", 3);
//			Course c5 = new Course("RB3301", "Advanced Algorithms", 4);
//			Course c6 = new Course("GE1101", "Introduction To Geography", 4);
//			Course c7 = new Course("GE2501", "Human Geography", 4);
//			Course c8 = new Course("PS2301", "USSR: A Retrospective", 4);
//			Course c9 = new Course("BA3802", "Change Management", 4);
//			Course c10 = new Course("BA4201", "Business Intelligence", 4);
//			Course c11 = new Course("PY4402", "Solid State Physics", 4);
//			Course c12 = new Course("PY4676", "Quantum Physics", 4);
//			Course c13 = new Course("ME2401", "Fluid Mechanics", 4);
//			Course c14 = new Course("GS2303", "Southeast Asian Studies", 4);
//			Course c15 = new Course("HS3422", "World Wars", 4);
//			Course c16 = new Course("CH1150", "Organic Chemistry", 4);
//			Course c17 = new Course("PR2101", "Communication In The Workplace", 3);
//			Course c18 = new Course("AS3350", "Asgardian Legends", 4);
//			Course c19 = new Course("AS3355", "Asgardian Folklore", 4);
//			Course c20 = new Course("AC1002", "Financial Accounting", 4);
//			Course c21 = new Course("MD4504", "Neurosurgery", 4);

			
			// Steve Rogers
			Student s1 = new Student("Steve", "Rogers", "History");
			srepo.save(s1);
			
			String hashedPass2 = sCryptPasswordEncoder.encode("steven");
			Accounts ac3 = new Accounts("steverogers", hashedPass2, RoleType.STUDENT, s1);
			urepo.save(ac3);
			
			Collection<Course> sc1 = new ArrayList<>();
			sc1.add(cl8);
			sc1.add(cl10);
			sc1.add(cl16);
			s1.setCourses(sc1);
			srepo.save(s1);
			
			// Tony Stark
//			Course c4 = new Course("CS1101", "Introduction To Computing", 4, 85, s2);
//			Course c5 = new Course("MA1101", "Mathematics 1", 4, 83, s2);
//			Course c6 = new Course("MA1102", "Mathematics 2", 4, 90, s2);
//			Course c7 = new Course("PR1301", "Public Speaking And Presentations", 3, 80, s2);
//			Course c8 = new Course("RB3301", "Advanced Algorithms", 4, 78, s2);
//			Collection<Course> sc2 = new ArrayList<>();
//			sc2.add(c4);
//			sc2.add(c5);
//			sc2.add(c6);
//			sc2.add(c7);
//			sc2.add(c8);
//			s2.setCourses(sc2);
//			crepo.save(c4);
//			crepo.save(c5);
//			crepo.save(c6);
//			crepo.save(c7);
//			crepo.save(c8);
//			srepo.save(s2);
			
			// Natasha Romanov
//			Course c9 = new Course("GE2501", "Human Geography", 4, 72, s3);
//			Course c10 = new Course("PS2301", "USSR: A Retrospective", 4, 80, s3);
//			Course c11 = new Course("GS2303", "Southeast Asian Studies", 4, 67, s3);
//			Course c12 = new Course("HS3422", "World Wars", 4, 64, s3);
//			Collection<Course> sc3 = new ArrayList<>();
//			sc3.add(c9);
//			sc3.add(c10);
//			sc3.add(c11);
//			sc3.add(c12);
//			s3.setCourses(sc3);
//			crepo.save(c9);
//			crepo.save(c10);
//			crepo.save(c11);
//			crepo.save(c12);
//			srepo.save(s3);
			
			// Bruce Banner
//			Course c13 = new Course("PY4402", "Solid State Physics", 4, 80, s4);
//			Course c14 = new Course("PY4676", "Quantum Physics", 4, 83, s4);
//			Course c15 = new Course("PR2101", "Communication In The Workplace", 3, 68, s4);
//			Course c16 = new Course("CH1150", "Organic Chemistry", 4, 76, s4);
//			Course c17 = new Course("AC1002", "Financial Accounting", 4, 62, s4);
//			Collection<Course> sc4 = new ArrayList<>();
//			sc4.add(c13);
//			sc4.add(c14);
//			sc4.add(c15);
//			sc4.add(c16);
//			sc4.add(c17);
//			s4.setCourses(sc4);
//			crepo.save(c13);
//			crepo.save(c14);
//			crepo.save(c15);
//			crepo.save(c16);
//			crepo.save(c17);
//			srepo.save(s4);
			
			
//			Student s15 = new Student("Peter", "Quill", "Business Studies");
//			srepo.save(s15);
			
//			SCryptPasswordEncoder sCryptPasswordEncoder = new SCryptPasswordEncoder();
//
//			String hashedPass = sCryptPasswordEncoder.encode("testadmin");
//			String hashedPass1 = sCryptPasswordEncoder.encode("testlect");
//
//			Accounts u = new Accounts("testadmin", hashedPass, RoleType.ADMIN); 
//			urepo.save(u); 
//			Accounts u1 = new Accounts("testlect", hashedPass1, RoleType.LECTURER); 
//			urepo.save(u1);
			
			
//			List<Course> courselist= new ArrayList<Course>();
//			courselist.add(c1);courselist.add(c2);courselist.add(c3);
//			List<Course> courselist1= new ArrayList<Course>();
//			courselist1.add(c4);courselist1.add(c5);
//			Lecturer l1=new Lecturer("Au","Pro", courselist);
//			Lecturer l2=new Lecturer("Bu", "aPro",courselist1);
//			lrepo.save(l1);lrepo.save(l2);
			
//			  SCryptPasswordEncoder sCryptPasswordEncoder = new SCryptPasswordEncoder();
//			  
//			  String hashedPass = sCryptPasswordEncoder.encode("testadmin");
//			  String hashedPass1 = sCryptPasswordEncoder.encode("testlect");
//			  
//			  Accounts u = new Accounts("testadmin", hashedPass, RoleType.ADMIN); 
//			  urepo.save(u); 
//			  Accounts u1 = new Accounts("testlect", hashedPass1, RoleType.LECTURER); 
//			  urepo.save(u1); 
			
//			Student s7 = new Student("Suria", "Rogers", "java");
//			Student s2 = new Student("Tony", "Stark", "Engineering");
//			Student s3 = new Student("Natasha", "Romanov", "Global Studies");
//			Student s4 = new Student("Bruce", "Banner", "Physics");
//			Student s5 = new Student("Bruce", "Wayne", "Engineering");
//			Student s6 = new Student("Peter", "Parker", "Chemistry");
//			Student s8 = new Student("Donald", "Trump", "Republican");
//			srepo.save(s2);
//			srepo.save(s3);
//			srepo.save(s4);
//			srepo.save(s5);
//			srepo.save(s6);
//			srepo.save(s7);
//			srepo.save(s8);
			
			Lecturer l1=new Lecturer("John","Professor");
			Lecturer l2=new Lecturer("Venkat", "Senior Professor");
			Lecturer l3=new Lecturer("Melinda", "Program Chief");
			Lecturer l4=new Lecturer("Tan", "Professor");
			Lecturer l5=new Lecturer("Emily", "Senior Professor");
			Lecturer l6=new Lecturer("Katherine", "Senior Professor");
			Lecturer l7=new Lecturer("Harry", "Professor");
			Lecturer l8=new Lecturer("Johnson", "Senior Professor");
			Lecturer l9=new Lecturer("Lily", "Assistant Professor");
			Lecturer l10=new Lecturer("Reena", "Assistant Professor");
			lrepo.save(l1);lrepo.save(l2);lrepo.save(l3);lrepo.save(l4);
			lrepo.save(l5);lrepo.save(l6);lrepo.save(l7);lrepo.save(l8);
			lrepo.save(l9);lrepo.save(l10);
			
			Accounts account1=new Accounts("John", "John", RoleType.LECTURER);
			Accounts account2=new Accounts("Venkat", "Venkat", RoleType.LECTURER);
			Accounts account3=new Accounts("Melinda", "Melinda", RoleType.LECTURER);
			Accounts account4=new Accounts("Tan","Tan", RoleType.LECTURER);
			Accounts account5=new Accounts("Emily", "Emily", RoleType.LECTURER);
			Accounts account6=new Accounts("Katherine", "Katherine", RoleType.LECTURER);
			Accounts account7=new Accounts("Harry", "Harry", RoleType.LECTURER);
			Accounts account8=new Accounts("Johnson","Johnson", RoleType.LECTURER);
			Accounts account9=new Accounts("Lily", "Lily", RoleType.LECTURER);
			Accounts account10=new Accounts("Reena","Reena", RoleType.LECTURER);
			urepo.save(account1);
			urepo.save(account2);
			urepo.save(account3);
			urepo.save(account4);
			urepo.save(account5);
			urepo.save(account6);
			urepo.save(account7);
			urepo.save(account8);
			urepo.save(account9);
			urepo.save(account10);
			/*
			 * List<Lecturer> lecturerlist=new ArrayList<Lecturer>(); lecturerlist.add(l1);
			 * lecturerlist.add(l2);
			 * 
			 * List<Lecturer> lecturerlist1=new ArrayList<Lecturer>();
			 * lecturerlist1.add(l3); lecturerlist1.add(l4);
			 * 
			 * List<Lecturer> lecturerlist2=new ArrayList<Lecturer>();
			 * lecturerlist1.add(l5); lecturerlist1.add(l6);
			 * 
			 * List<Lecturer> lecturerlist3=new ArrayList<Lecturer>();
			 * lecturerlist1.add(l7); lecturerlist1.add(l8);
			 * 
			 * List<Lecturer> lecturerlist4=new ArrayList<Lecturer>();
			 * lecturerlist1.add(l9); lecturerlist1.add(l10);
			 */
			
			
			Course c22=new Course("AB001","CPP", "A",4.2, 8, s1, l1, null);
			Course c23=new Course("AB002","Java", "B",3.5, 8, s2, l1, null);
			Course c24=new Course("AB003","C Sharp", "A",4.2, 8, s3, l2, null);
			Course c25=new Course("AB004","Python", "B",3.5, 8, s4, l2, null);
			Course c26=new Course("AB005","Python2", "B",3.5, 8, s5, l4, null);
			Course c27=new Course("AB006","Machine learning", "B",3.5, 8, s6, l4, null);
			Course c28=new Course("AB007","Machine learning 2", "A",4.5, 6, s7, l3, null);
			Course c29=new Course("AB008","ASP", "B",3.5, 8, s8, l3, null);
			Course c30=new Course("AB009","ASP 2", "A",4.5, 6, s9, l5, null);
			Course c31=new Course("AB0010","Sofware Design", "B",3.5, 8, s10, l5, null);
			Course c32=new Course("AB0011","Sofware Design 2", "A",4.5, 6, s11, l6, null);
			Course c33=new Course("AB0012","Sofware Design 3", "B",3.5, 8, s12, l6, null);
			Course c34=new Course("AB0013","FPP", "A",4.5, 6, s13, l7, null);
			Course c35=new Course("AB0014","Sofware Design 4", "A",4.5, 6, s14,l7, null);
			Course c36=new Course("AB0015","Sofware Design 5", "B",3.5, 8, s14, l8, null);
			Course c37=new Course("AB0016","FPP 2", "A",4.5, 6, s13, l8, null);
			Course c38=new Course("AB0016","FPP 2","B",3.5,6,s10,l8,null);
			Course c39=new Course("AB0016","FPP 2","B",3.5,6,s11,l8,null);
			
			crepo.save(c22);
			crepo.save(c23);
			crepo.save(c24);
			crepo.save(c25);
			crepo.save(c26);
			crepo.save(c27);
			crepo.save(c28);
			crepo.save(c29);
			crepo.save(c30);
			crepo.save(c31);
			crepo.save(c32);
			crepo.save(c33);
			crepo.save(c34);
			crepo.save(c35);
			crepo.save(c36);
			crepo.save(c37);
			crepo.save(c38);
			crepo.save(c39);
			
			
			
			

			List<Course> courselist= new ArrayList<Course>();
			courselist.add(c1);courselist.add(c2);courselist.add(c3);
			List<Course> courselist1= new ArrayList<Course>();
			courselist1.add(c4);courselist1.add(c5);
			//Lecturer l1=new Lecturer("Au","Pro", courselist);
			//Lecturer l2=new Lecturer("Bu", "aPro",courselist1);a
			
//			  SCryptPasswordEncoder sCryptPasswordEncoder = new SCryptPasswordEncoder();
//			  
//			  String hashedPass = sCryptPasswordEncoder.encode("testadmin");
//			  String hashedPass1 = sCryptPasswordEncoder.encode("testlect");
//			  
//			  Accounts u = new Accounts("testadmin", hashedPass, RoleType.ADMIN); 
//			  urepo.save(u); 
//			  Accounts u1 = new Accounts("testlect", hashedPass1, RoleType.LECTURER); 
//			  urepo.save(u1); 
		};
	}
}
