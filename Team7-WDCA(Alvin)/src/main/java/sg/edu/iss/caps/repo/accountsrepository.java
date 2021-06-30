package sg.edu.iss.caps.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.caps.domain.Accounts;

public interface accountsrepository extends JpaRepository<Accounts, Integer> {
	public Accounts findAccountsByUsernameAndPassword(String un, String pw);
	public Accounts findAccountsByUsername(String n);
	
	@Query("select a from Accounts a where a.studentacc	.id = :n")
	public Accounts findAccountByStudentId(@Param("n")int n);
	
	@Query("select a from Accounts a where a.lecturer.id = :n")
	public Accounts findAccountByLecturerId(@Param("n")int n);
	
}
