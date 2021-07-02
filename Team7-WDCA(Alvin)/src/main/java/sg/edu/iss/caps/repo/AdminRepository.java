package sg.edu.iss.caps.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.caps.domain.Admin;
import sg.edu.iss.caps.domain.Student;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	List<Admin> findAdminByName(String name);

	public Admin findAdminById(int id);
	@Query("select a from Admin a where a.account.username = :uname")
	public Admin findAdminByUsername(@Param("uname") String un);
}
