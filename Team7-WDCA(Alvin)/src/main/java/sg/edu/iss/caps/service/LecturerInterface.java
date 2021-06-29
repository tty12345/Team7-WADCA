package sg.edu.iss.caps.service;

import java.util.List;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Lecturer;
import sg.edu.iss.caps.domain.Student;



public interface LecturerInterface {

	public void createLecturer (Lecturer lecturer);
	public void updateLecturer (Lecturer lecturer);
	public void deleteLecturer (Lecturer lecturer);
	public List<Lecturer> listAllLecturer();
	public List<Student> list();
	public List<Course> listAllCourses();
	public void saveCourse(Course course);
	public void saveStudent(Student student);
	public Course findCourseById(Integer id);
}
