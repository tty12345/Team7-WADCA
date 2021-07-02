package sg.edu.iss.caps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sg.edu.iss.caps.domain.Coursedetail;
import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.domain.TempCourses;
import sg.edu.iss.caps.repo.CoursedetailRepository;
import sg.edu.iss.caps.repo.temprepo;

@Service
public class Coursedetailserviceimplementation implements Coursedetailservice {
	
	@Autowired
	CoursedetailRepository cdrepo;
	@Autowired
	temprepo trepo;
	
	@Override
	public List<TempCourses> getavailableCourses(int pageNo, int pageSize){
		Pageable paging = PageRequest.of(pageNo, pageSize);
		
		Page<TempCourses> pageResult = trepo.findAll(paging);
		
		List<TempCourses> list = pageResult.getContent();
		
		return list;
	}
	
	
	
	@Override
	public Coursedetail findCoursedetailbyCode(String code) {
		Coursedetail cd1 = cdrepo.findCourseByCode(code);
		return cd1;
	}
	
	@Override
	public List<Coursedetail> findAllCoursedetail() {
		List<Coursedetail> cd = cdrepo.findAll();
		return cd;
	}

	@Override
	public List<Coursedetail> getAllCourses(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		
		Page<Coursedetail> pageResult = cdrepo.findAll(paging);
		
		List<Coursedetail> list = pageResult.getContent();
		
		return list;
	}


	@Override
	public void saveTempCourses(List<Coursedetail> list) {
		for(Coursedetail cd: list)
		{
			TempCourses temp = new TempCourses();
			temp.setCoursedetail(cd);
			trepo.save(temp);
			cdrepo.save(cd);
		}
	}
	
	
	
}
