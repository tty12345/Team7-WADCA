package sg.edu.iss.caps.domain;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import sg.edu.iss.caps.Team7WadcaApplication;
import sg.edu.iss.caps.repo.StudentRepository;
import sg.edu.iss.caps.repo.CourseRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Team7WadcaApplication.class)
@TestMethodOrder(OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class StudentTest {
	
	@Autowired
	private StudentRepository srepo;
	
	@Autowired
	private CourseRepository crepo;
	
	@Test
	@Order(1)
	public void testAddStudent() {
		List<Course> courses = new ArrayList<>();
		Course test = new Course("TT1502", "Test Module 2");
		courses.add(test);
		crepo.save(test);
		Student testStudent = new Student("testing", "test", "Test Studies", courses);
		Student saved = srepo.save(testStudent);
		assertNotNull(saved);
	}
	
	@Test
	@Order(2)
	public void testDeleteStudent() {
		// test delete student by all columns
		String test = "test";
		
		Student toDelete = srepo.findStudentByKeyword(test).get(0);
		srepo.delete(toDelete);
		assertTrue(srepo.findStudentByKeyword(test).size() == 0);
	}
}
