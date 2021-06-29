package sg.edu.iss.caps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.iss.caps.domain.Course;
//import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Lecturer;
import sg.edu.iss.caps.repo.CourseRepository;
import sg.edu.iss.caps.repo.LecturerRepository;

@Service
public class LecturerServiceImplementation implements LecturerService {
	@Autowired
	LecturerRepository lrepo;
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
	public List<Lecturer> listAllLecturer() {
		// TODO Auto-generated method stub
		return lrepo.findAll();
	}

	@Override
	public void deleteLecturer(Lecturer Lecturer) {
		// TODO Auto-generated method stub
		lrepo.delete(Lecturer);

	}
	@Override
	public Lecturer findLecturerById(int id) {
		return lrepo.findLecturerById(id);
	}
	
	@Override
	public void saveCourse(Course course) {
		// TODO Auto-generated method stub
		crepo.save(course);
	}
	
	@Override
	public Course findCourseById(Integer id) {
		Course found = crepo.findById(id).get();
		return found;
		
	}

}
