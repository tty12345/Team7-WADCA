package sg.edu.iss.caps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Coursedetail;
import sg.edu.iss.caps.domain.Enrollmenstatus;
import sg.edu.iss.caps.repo.CourseRepository;
import sg.edu.iss.caps.repo.CoursedetailRepository;

@Service
public abstract class CourseServiceImplementation implements CourseService {
	
	@Autowired
	CourseRepository crepo;
	@Autowired
	CoursedetailRepository cdrepo;

	@Override
	public void addCourse(Course course) {
		crepo.save(course);
	}

	@Override
	public void removeCourse(Course course) {
		crepo.delete(course);
	} 


	@Override
	public List<Course> findCoursesByName(String name) {
		List<Course> found = crepo.findCoursesByName(name);
		return found;
	}

	@Override
	public Course findCourseBycode(String code) {
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
	
	@Override
	public boolean checkcapacity(Course course) {
		//check capacity 
		Integer count = crepo.getCount(course.getCode());
		Coursedetail cd = course.getDetail();
		if(count < cd.getCourseCapacity())
		return true;
		else
		return false;
	}
		
	@Transactional
	public void withdrawcourse(Course Course) {
		Course.setStatus(Enrollmenstatus.WITHDRAWN);
		crepo.save(Course);

}
}
