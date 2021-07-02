package sg.edu.iss.caps.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.iss.caps.domain.TempCourses;

public interface temprepo extends JpaRepository<TempCourses, Integer> {

}
