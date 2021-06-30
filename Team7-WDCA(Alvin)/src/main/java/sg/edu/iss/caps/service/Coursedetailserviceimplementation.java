package sg.edu.iss.caps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.iss.caps.domain.Coursedetail;
import sg.edu.iss.caps.repo.CoursedetailRepository;

@Service
public class Coursedetailserviceimplementation implements Coursedetailservice {
	
	@Autowired
	CoursedetailRepository cdrepo;

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
}
