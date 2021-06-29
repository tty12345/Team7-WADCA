package sg.edu.iss.caps.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sg.edu.iss.caps.domain.Coursedetail;
import sg.edu.iss.caps.domain.Student;

public interface CoursedetailRepository extends JpaRepository<Coursedetail, Integer> {
	
}
