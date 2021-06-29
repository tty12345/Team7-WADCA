package sg.edu.iss.caps.repo;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Lecturer;

public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {

<<<<<<< HEAD
=======
	void save(@Valid Course course);
>>>>>>> refs/remotes/origin/wjx

}
