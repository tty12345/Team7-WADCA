package sg.edu.iss.caps.service;

import java.util.List;

import sg.edu.iss.caps.domain.Course;

public interface CourseService {
	
	public void addCourse(Course course);
	public void removeCourse(Course student);
	public Course findCourseById(int id);
	public List<Course> findCoursesByName(String name);
	public Course findCourseByCode(String code);
	public int showCredits(int id);
	public List<Course> listAllCourses();
}
