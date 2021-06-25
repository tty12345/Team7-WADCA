package sg.edu.iss.caps.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.caps.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	public Student findStudentById(int id);
	
	@Query("select s from Student s where s.firstName like %?1%")
	public List<Student> findStudentByName(String firstName);
	
	@Query("select s from Student s where s.account.username = :uname")
	public Student findStudentByUsername(@Param("uname")String un);
}
