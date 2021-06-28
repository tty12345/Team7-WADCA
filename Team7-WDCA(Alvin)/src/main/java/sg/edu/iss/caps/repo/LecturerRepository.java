package sg.edu.iss.caps.repo;

import org.springframework.data.jpa.repository.JpaRepository;
//import java.util.Collection;



//import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Lecturer;


public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {
	public Lecturer findLecturerById(int id);
	public Lecturer findLecturerByIdAndName(int id,String name);
	//public Lecturer findLecturersByCourses(Collection<Course> courses);
	//public Collection<Lecturer> findLecturersByCourse(Course course);

}


