package sg.edu.iss.caps.service;

import java.util.List;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Lecturer;
import sg.edu.iss.caps.domain.Student;

public interface CourseService {
	
	public void addCourse(Course course);
	public void removeCourse(Course student);
	public Course findCourseById(int id);
	public List<Course> findCoursesByName(String name);
	public Course findCourseByCode(String code);
	public int showCredits(int id);
	public List<Course> listAllCourses();
	public List<Course> findCoursesByLecturer(Lecturer lecturer);
	public void withdrawCourse(Course course);
	public boolean checkCapacity(Course course);
	public List<Course> findCoursesByStudent(Student student);
	public List<Course> findCoursesByCode(String code);

}
