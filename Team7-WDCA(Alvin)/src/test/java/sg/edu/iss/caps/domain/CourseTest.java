package sg.edu.iss.caps.domain;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import sg.edu.iss.caps.Team7WadcaApplication;
import sg.edu.iss.caps.repo.CourseRepository;
import sg.edu.iss.caps.repo.StudentRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Team7WadcaApplication.class)
@TestMethodOrder(OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class CourseTest {
	
	@Autowired
	private CourseRepository crepo;
	
	@Test
	@Order(1)
	public void testAddCourse() {
		Course testCourse = new Course("TT1501", "Testing Module");
		Course saved = crepo.save(testCourse);
		assertNotNull(saved);
	}
	
	@Test
	@Order(2)
	public void deleteCourse() {
		// test delete course by module code
		crepo.deleteCourseByCode("TT1501");
		assertNull(crepo.findCourseByCode("TT1501"));
	}
}
