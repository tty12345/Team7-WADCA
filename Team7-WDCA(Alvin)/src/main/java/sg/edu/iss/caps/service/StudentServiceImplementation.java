package sg.edu.iss.caps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.repo.StudentRepository;

@Service
public class StudentServiceImplementation implements StudentService {
	
	@Autowired
	StudentRepository srepo;
	
	@Override
	public Student findStudentByUsername(String un) { 
		return srepo.findStudentByUsername(un);
	}
	
	@Override
	public void addStudent(Student student) {
		srepo.save(student);
	}

	@Override
	public void removeStudent(Student student) {
		srepo.delete(student);
	}

	@Override
	public Student findStudentById(int id) {
		Student found = srepo.findStudentById(id);
		return found;
	}

	@Override
	public List<Student> findStudentByFirstName(String name) {
		List<Student> list = srepo.findStudentByName(name);
		return list;
	}

	@Override
	public double showGpaById(int id) {
		Student found = srepo.findStudentById(id);
		return found.getGpa();
	}

	@Override
	public int showCreditsTakenById(int id) {
		Student found = srepo.findStudentById(id);
		return found.getCreditsTaken();
	}

	@Override
	public List<Student> listAllStudents() {
		List<Student> list = srepo.findAll();
		return list;
	}
	
	@Override
	public List<Student> getAllStudents(int pageNo, int pageSize){
		Pageable paging = PageRequest.of(pageNo, pageSize);
		
		Page<Student> pageResult = srepo.findAll(paging);
		
		return pageResult.getContent();
	}
	
//	public void addCourse(Course course) {
//		srepo.saveCourse(course);
//	}

}
