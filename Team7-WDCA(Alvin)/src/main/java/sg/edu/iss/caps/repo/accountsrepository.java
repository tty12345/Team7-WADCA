package sg.edu.iss.caps.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.edu.iss.caps.domain.Accounts;

public interface accountsrepository extends JpaRepository<Accounts, Integer> {
	public Accounts findAccountsByUsernameAndPassword(String un, String pw);
	public Accounts findAccountsByUsername(String n);
	
	
}
