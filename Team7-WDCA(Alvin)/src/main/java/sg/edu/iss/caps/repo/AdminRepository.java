package sg.edu.iss.caps.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.iss.caps.domain.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	List<Admin> findAdminByName(String name);

	Admin findAdminById(int id);

}
