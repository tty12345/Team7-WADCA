package sg.edu.iss.caps.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Lecturer;


public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	@Query("select c from Course c where c.name like %?1%")
	public List<Course> findCoursesByName(String name);
	
	@Query("select c from Course c where c.code = ?1")
	public Course findCourseByCode(String name);
	@Query("select c from Course c where c.lecturer=?1")
	public List<Course> findCoursesByLecturer(Lecturer lecturer);
	
	@Modifying
	@Transactional
	@Query("delete from Course c where c.code = :code")
	public void deleteCourseByCode(@Param("code") String code);

}
