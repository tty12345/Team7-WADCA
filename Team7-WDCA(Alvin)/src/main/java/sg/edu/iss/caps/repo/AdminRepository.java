package sg.edu.iss.caps.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.iss.caps.domain.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
