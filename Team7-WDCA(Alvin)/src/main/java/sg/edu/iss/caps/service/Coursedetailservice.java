package sg.edu.iss.caps.service;

import java.util.List;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Coursedetail;

public interface Coursedetailservice {
	
	public Coursedetail findCoursedetailbyCode(String code);
	public List<Coursedetail> findAllCoursedetail();
	public List<Coursedetail> getAllStudents(int pageNo, int pageSize);
	

}