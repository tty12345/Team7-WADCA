package sg.edu.iss.caps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sg.edu.iss.caps.domain.Course;

import sg.edu.iss.caps.domain.Coursedetail;
import sg.edu.iss.caps.domain.Enrollmenstatus;
import sg.edu.iss.caps.domain.Lecturer;

import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.repo.CourseRepository;

@Service
public class CourseServiceImplementation implements CourseService {
	
	@Autowired
	CourseRepository crepo;

	@Override
	public List<Course> getAllStudents(int pageNo, int pageSize){
		Pageable paging = PageRequest.of(pageNo, pageSize);
		
		Page<Course> pageResult = crepo.findAll(paging);
		
		List<Course> list = pageResult.getContent();
		
		return list;
	}
	@Override
	public void addCourse(Course course) {
		crepo.save(course);
	}

	@Override
	public void removeCourse(Course course) {
		crepo.delete(course);
	}

	@Override
	public Course findCourseById(int id) {
		Course found = crepo.getById(id);
		return found;
	}

	@Override
	public List<Course> findCoursesByName(String name) {
		List<Course> found = crepo.findCoursesByName(name);
		return found;
	}

	@Override
	public Course findCourseByCode(String code) {
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
	public void withdrawCourse(Course course) {
		course.setStatus(Enrollmenstatus.WITHDRAWN);
		crepo.save(course);
	}

	@Override
	public boolean checkCapacity(Course course) {
		//check capacity 
		Integer count = crepo.getCount(course.getCode());
		Coursedetail cd = course.getDetail();
		if(count < cd.getCourseCapacity())
			return true;
		else
			return false;
	}
	
	public List<Course> findCoursesByStudent(Student student){
		List<Course> courses=crepo.findCoursesByStudent(student);
		return courses;
	}
	
	public List<Course> findCoursesByCode(String code){
		List<Course> courses=crepo.findCoursesByCode(code);
		return courses;
	}

	@Override
	public List<Course> findCoursesByLecturer(Lecturer lecturer) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void save(Course course) {
	crepo.save(course);
		
	}

}
