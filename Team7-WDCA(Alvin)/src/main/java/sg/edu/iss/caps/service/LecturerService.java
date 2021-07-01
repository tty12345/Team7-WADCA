package sg.edu.iss.caps.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import sg.edu.iss.caps.domain.Course;
//import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Lecturer;



public interface LecturerService {
	public void createLecturer(Lecturer lecturer);
	public void updateLecturer(Lecturer lecturer);
	public List<Lecturer> listAllLecturer();
	public void deleteLecturer(Lecturer Lecturer);
	public Lecturer findLecturerById(int id);
	//public List<Student> findStudentsByCourseTaken()
	public Course findCourseById(Integer id);
	public void saveCourse(Course course);
	public Lecturer findLecturerByUsername(@Param("uname") String un);

}
