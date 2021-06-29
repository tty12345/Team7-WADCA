package sg.edu.iss.caps.repo;

import org.springframework.data.jpa.repository.JpaRepository;
//import java.util.Collection;



//import sg.edu.iss.caps.domain.Course;

//import org.springframework.data.jpa.repository.JpaRepository;
import sg.edu.iss.caps.domain.Lecturer;
//import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Lecturer;

public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {

	void save(@Valid Course course);

}


