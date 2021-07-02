package sg.edu.iss.caps.service;

import java.util.List;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Coursedetail;
import sg.edu.iss.caps.domain.Lecturer;
import sg.edu.iss.caps.domain.TempCourses;

public interface Coursedetailservice {
	
	public Coursedetail findCoursedetailbyCode(String code);
	public List<Coursedetail> findAllCoursedetail();
	public List<Coursedetail> getAllCourses(int pageNo, int pageSize);
	public List<TempCourses> getavailableCourses(int pageNo, int pageSize);
	public void saveTempCourses(List<Coursedetail> list);
	public List<Coursedetail> findCoursesByLecturer(Lecturer lecturer);

}