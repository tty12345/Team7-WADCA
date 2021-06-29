package sg.edu.iss.caps.service;

import java.util.List;

import sg.edu.iss.caps.domain.Course;


public interface Courseservice {
	
	public void addCourse(Course course);
	public void removeCourse(Course student);
	public Course findCourseBycode(int id);
	public List<Course> findCoursesByName(String name);
	public Course findCourseBycode(String code);
	public int showCredits(int id);
	public List<Course> listAllCourses();
	public void save(Course course);
	public void withdrawcourse(Course course);
	public boolean checkcapacity(Course course);
	
}
