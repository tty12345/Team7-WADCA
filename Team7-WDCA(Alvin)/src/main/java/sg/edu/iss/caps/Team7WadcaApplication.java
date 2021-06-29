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

import net.bytebuddy.build.ToStringPlugin.Exclude;
import sg.edu.iss.caps.domain.Accounts;
import sg.edu.iss.caps.domain.RoleType;
import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Lecturer;
import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.repo.CourseRepository;
import sg.edu.iss.caps.repo.LecturerRepository;
import sg.edu.iss.caps.repo.StudentRepository;
import sg.edu.iss.caps.repo.accountsrepository;
import sg.edu.iss.caps.service.StudentServiceImplementation;

@SpringBootApplication(exclude= {SecurityAutoConfiguration.class })
public class Team7WadcaApplication {
	
	@Autowired
	StudentRepository srepo;
	
	@Autowired
	StudentServiceImplementation sservice;
	
	@Autowired
	CourseRepository crepo;
	
	@Autowired
	accountsrepository urepo;
	
	@Autowired
	LecturerRepository lrepo;


	public static void main(String[] args) {
		SpringApplication.run(Team7WadcaApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			
//			Student s1 = new Student("Steve", "Rogers", "History");
//			srepo.save(s1);
//			
//			SCryptPasswordEncoder sCryptPasswordEncoder = new SCryptPasswordEncoder();
//			  
//			String hashedPass = sCryptPasswordEncoder.encode("steven");
//			Accounts acc = new Accounts("steven", hashedPass, RoleType.STUDENT, s1);
//			urepo.save(acc);
			
//			Student s1 = new Student("Steve", "Rogers", "History");
//			Student s2 = new Student("Tony", "Stark", "Engineering");
//			Student s3 = new Student("Natasha", "Romanov", "Global Studies");
//			Student s4 = new Student("Bruce", "Banner", "Physics");
//			Student s6 = new Student("Peter", "Parker", "Chemistry");
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
//			srepo.save(s6);
//			srepo.save(s7);
//			srepo.save(s8);
//			srepo.save(s9);
//			srepo.save(s10);
//			srepo.save(s11);
//			srepo.save(s12);
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
//			Course c1 = new Course("GE1101", "Introduction To Geography", 4, 65, s1);
//			Course c2 = new Course("PS2301", "USSR: A Retrospective", 4, 70, s1);
//			Course c3 = new Course("HS3422", "World Wars", 4, 75, s1);
//			Collection<Course> sc1 = new ArrayList<>();
//			sc1.add(c1);
//			sc1.add(c2);
//			sc1.add(c3);
//			s1.setCourses(sc1);
//			crepo.save(c1);
//			crepo.save(c2);
//			crepo.save(c3);
//			srepo.save(s1);
			
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
			
		};
	}
}
