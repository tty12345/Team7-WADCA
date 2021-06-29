package sg.edu.iss.caps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Lecturer;
import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.repo.CourseRepository;
import sg.edu.iss.caps.repo.LecturerRepository;
import sg.edu.iss.caps.repo.StudentRepository;


@Service
public class LecturerImplementation implements LecturerInterface {

	@Autowired
	LecturerRepository lrepo;
	@Autowired
	StudentRepository srepo;
	@Autowired
	CourseRepository crepo;

	
	@Override
	public void createLecturer(Lecturer lecturer) {
		// TODO Auto-generated method stub
		lrepo.save(lecturer);
	}

	@Override
	public void updateLecturer(Lecturer lecturer) {
		// TODO Auto-generated method stub
		lrepo.save(lecturer);
	}

	@Override
	public void deleteLecturer(Lecturer lecturer) {
		// TODO Auto-generated method stub
		lrepo.delete(lecturer);
	}

	@Override
	public List<Student> list() {
		// TODO Auto-generated method stub
		return srepo.findAll();
	}

	@Transactional
	public List<Lecturer> listAllLecturer() {
		// TODO Auto-generated method stub
		return lrepo.findAll();
	}

	@Override
	public List<Course> listAllCourses() {
		// TODO Auto-generated method stub
		return crepo.findAll();
	}

	@Override
	public void saveCourse(Course course) {
		// TODO Auto-generated method stub
		crepo.save(course);
	}
	
	@Override
	public void saveStudent(Student student) {
		// TODO Auto-generated method stub
		srepo.save(student);
	}

	@Override
	public Course findCourseById(Integer id) {
		Course found = crepo.findById(id).get();
		return found;
		
	}
	

}
