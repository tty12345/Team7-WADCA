package sg.edu.iss.caps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.repo.CourseRepository;

@Service
public class CourseServiceImplementation implements CourseService {
	
	@Autowired
	CourseRepository crepo;

	@Override
	public void addCourse(Course course) {
		crepo.save(course);
	}

	@Override
	public void removeCourse(Course course) {
		crepo.delete(course);
	}

	@Override
	public Course findCourseById(int id) {
		Course found = crepo.getById(id);
		return found;
	}

	@Override
	public List<Course> findCoursesByName(String name) {
		List<Course> found = crepo.findCoursesByName(name);
		return found;
	}

	@Override
	public Course findCourseByCode(String code) {
		Course found = crepo.findCourseByCode(code);
		return found;
	}

	@Override
	public int showCredits(int id) {
		Course found = crepo.getById(id);
		return found.getCredits();
	}

	@Override
	public List<Course> listAllCourses() {
		List<Course> all = crepo.findAll();
		return all;
	}

}
