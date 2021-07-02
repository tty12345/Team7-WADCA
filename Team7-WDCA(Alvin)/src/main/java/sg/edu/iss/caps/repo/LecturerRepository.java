package sg.edu.iss.caps.repo;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
//import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.caps.domain.Course;

//import sg.edu.iss.caps.domain.Course;

//import org.springframework.data.jpa.repository.JpaRepository;
import sg.edu.iss.caps.domain.Lecturer;
//import org.springframework.data.jpa.repository.JpaRepository;

public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {

	void save(@Valid Course course);

	Lecturer findLecturerById(int id);
	
	@Query("select l from Lecturer l where l.account.username = :uname")
	public Lecturer findLecturerByUsername(@Param("uname") String un);
	
}


