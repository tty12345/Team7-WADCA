package sg.edu.iss.caps.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.iss.caps.domain.Course;

@Service
public interface CourseService {
	
	public void addCourse(Course course);
	public void removeCourse(Course student);
	public Course findCourseBycode(int id);
	public List<Course> findCoursesByName(String name);
	public Course findCourseByCode(String code);
	public int showCredits(int id);
	public List<Course> listAllCourses();
	public void save(Course course);
	public void withdrawcourse(Course findCourseById);
	
}
