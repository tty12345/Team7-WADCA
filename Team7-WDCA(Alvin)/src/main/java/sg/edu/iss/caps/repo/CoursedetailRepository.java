package sg.edu.iss.caps.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Coursedetail;
import sg.edu.iss.caps.domain.Lecturer;

public interface CoursedetailRepository extends JpaRepository<Coursedetail, Integer> {

	@Query("select cd from Coursedetail cd where cd.code = ?1")
	public Coursedetail findCourseByCode(String code);

	public List<Coursedetail> findCoursesByLecturer(Lecturer lecturer);
	
}


