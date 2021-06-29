package sg.edu.iss.caps;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
//import org.springframework.data.querydsl.QuerydslRepositoryInvokerAdapter;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Lecturer;
import sg.edu.iss.caps.domain.Student;
//import net.bytebuddy.build.ToStringPlugin.Exclude;
//import sg.edu.iss.caps.domain.Accounts;
//import sg.edu.iss.caps.domain.RoleType;
import sg.edu.iss.caps.repo.CourseRepository;
import sg.edu.iss.caps.repo.LecturerRepository;
import sg.edu.iss.caps.repo.StudentRepository;
import sg.edu.iss.caps.repo.accountsrepository;
//import sg.edu.iss.caps.service.StudentServiceImplementation;
import sg.edu.iss.caps.service.StudentService;

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
	LecturerRepository lrepo;


	public static void main(String[] args) {
		SpringApplication.run(Team7WadcaApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
			Student s1 = new Student("Steve", "Rogers", "History");
			Student s2 = new Student("Tony", "Stark", "Engineering");
			Student s3 = new Student("Natasha", "Romanov", "Global Studies");
			Student s4 = new Student("Bruce", "Banner", "Physics");
			Student s5 = new Student("Bruce", "Wayne", "Engineering");
			Student s6 = new Student("Peter", "Parker", "Chemistry");

			srepo.save(s1);
			srepo.save(s2);
			srepo.save(s3);
			srepo.save(s4);
			srepo.save(s5);
			srepo.save(s6);

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
			
			Course c1 = new Course("CS1101", "Introduction To Computing", null, 4);
			Course c2 = new Course("MA1101", "Mathematics 1", null, 4);
			Course c3 = new Course("MA1102", "Mathematics 2", null, 4);
			Course c4 = new Course("PR1301", "Public Speaking And Presentations", null, 3);
			Course c5 = new Course("RB3301", "Advanced Algorithms", null, 4);
//			Course c6 = new Course("GE1101", "Introduction To Geography", null, 4);
//			Course c7 = new Course("GE2501", "Human Geography", null, 4);
//			Course c8 = new Course("PS2301", "USSR: A Retrospective", null, 4);
//			Course c9 = new Course("BA3802", "Change Management", null, 4);
//			Course c10 = new Course("BA4201", "Business Intelligence", null, 4);
//			Course c11 = new Course("PY4402", "Solid State Physics", null, 4);
//			Course c12 = new Course("PY4676", "Quantum Physics", null, 4);
//			Course c13 = new Course("ME2401", "Fluid Mechanics", null, 4);
//			Course c14 = new Course("GS2303", "Southeast Asian Studies", null, 4);
//			Course c15 = new Course("HS3422", "World Wars", null, 4);
//			Course c16 = new Course("CH1150", "Organic Chemistry", null, 4);
//			Course c17 = new Course("PR2101", "Communication In The Workplace", null, 3);
//			Course c18 = new Course("AS3350", "Asgardian Legends", null, 4);
//			Course c19 = new Course("AS3355", "Asgardian Folklore", null, 4);
//			Course c20 = new Course("AC1002", "Financial Accounting", null, 4);
//			Course c21 = new Course("MD4504", "Neurosurgery", null, 4);
			crepo.save(c1);
			crepo.save(c2);
			crepo.save(c3);
			crepo.save(c4);
			crepo.save(c5);
//			crepo.save(c6);
//			crepo.save(c7);
//			crepo.save(c8);
//			crepo.save(c9);
//			crepo.save(c10);
//			crepo.save(c11);
//			crepo.save(c12);
//			crepo.save(c13);
//			crepo.save(c14);
//			crepo.save(c15);
//			crepo.save(c16);
//			crepo.save(c17);
//			crepo.save(c18);
//			crepo.save(c19);
//			crepo.save(c20);
//			crepo.save(c21);
			
//			List<Course> m1 = new ArrayList<Course>();
//			m1.add(c15);
//			m1.add(c4);
//			m1.add(c8);
			//Student test = srepo.findStudentById(1);
			
			
//			Student s15 = new Student("Peter", "Quill", "Business Studies");
//			srepo.save(s15);
			
			
//			  SCryptPasswordEncoder sCryptPasswordEncoder = new SCryptPasswordEncoder();
//			  
//			  String hashedPass = sCryptPasswordEncoder.encode("testadmin");
//			  String hashedPass1 = sCryptPasswordEncoder.encode("testlect");
//			  
//			  Accounts u = new Accounts("testadmin", hashedPass, RoleType.ADMIN); 
//			  urepo.save(u); 
//			  Accounts u1 = new Accounts("testlect", hashedPass1, RoleType.LECTURER); 
//			  urepo.save(u1); 
			
			
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
			Course c22=new Course("AB001","CPP", "A",4.2, 8, s1, l7, null);
			Course c23=new Course("AB002","Java", "B",3.5, 8, s2, l1, null);
			Course c24=new Course("AB003","C Sharp", "A",4.2, 8, s3, l1, null);
			Course c25=new Course("AB004","Python", "B",3.5, 8, s4, l2, null);
			Course c26=new Course("AB005","Python2", "B",3.5, 8, s5, l2, null);
			Course c27=new Course("AB006","Machine learning", "B",3.5, 8, s6, l3, null);
			Course c28=new Course("AB007","Machine learning 2", "A",4.5, 6, s7, l4, null);
			Course c29=new Course("AB008","ASP", "B",3.5, 8, s8, l3, null);
			Course c30=new Course("AB009","ASP 2", "A",4.5, 6, s9, l4, null);
			Course c31=new Course("AB0010","Sofware Design", "B",3.5, 8, s10, l5, null);
			Course c32=new Course("AB0011","Sofware Design 2", "A",4.5, 6, s11, l6, null);
			Course c33=new Course("AB0012","Sofware Design 3", "B",3.5, 8, s12, l5, null);
			Course c34=new Course("AB0013","FPP", "A",4.5, 6, s13, l6, null);
			Course c35=new Course("AB0014","Sofware Design 4", "A",4.5, 6, s14, l8, null);
			Course c36=new Course("AB0015","Sofware Design 5", "B",3.5, 8, s14, l9, null);
			Course c37=new Course("AB0016","FPP 2", "A",4.5, 6, s13, l10, null);
			Course c38=new Course("AB0016","FPP 2","B",3.5,6,s10,l10,null);
			Course c39=new Course("AB0016","FPP 2","B",3.5,6,s11,l10,null);
			
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
			crepo.save(c37);
			
			
			
		};
	}
}
