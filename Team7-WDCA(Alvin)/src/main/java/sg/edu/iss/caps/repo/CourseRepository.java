package sg.edu.iss.caps.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sg.edu.iss.caps.domain.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	@Query("select c from Course c where c.name like %?1%")
	public List<Course> findCoursesByName(String name);
	
	@Query("select c from Course c where c.code = ?1")
	public Course findCourseByCode(String name);
}
