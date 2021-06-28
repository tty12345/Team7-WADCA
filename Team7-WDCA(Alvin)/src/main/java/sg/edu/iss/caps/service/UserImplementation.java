package sg.edu.iss.caps.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;

//import sg.edu.iss.caps.service.UserInterface;
import sg.edu.iss.caps.domain.Accounts;
import sg.edu.iss.caps.repo.accountsrepository;
@Service
public class UserImplementation implements UserInterface {

	@Autowired
	accountsrepository urepo;
	@Override
	public void createUser(Accounts user) {
		// TODO Auto-generated method stub
		urepo.save(user);
	}
	
	@Override
	public boolean checkSession(HttpSession session, String s_name) {
		if (session.getAttribute(s_name) != null )
			return true;
		else 
			return false;
	}

	@Override
	public void updateUser(Accounts user) {
		// TODO Auto-generated method stub
		urepo.save(user);
	}

	@Override
	public void deleteUser(Accounts user) {
		// TODO Auto-generated method stub
		urepo.delete(user);
	}

	@Override
	public boolean authenticateUser(Accounts user) {
		// TODO Auto-generated method stub
		Accounts username_object = urepo.findAccountsByUsername(user.getUsername());
		
		SCryptPasswordEncoder sCryptPasswordEncoder = new SCryptPasswordEncoder();
		
		
		if(sCryptPasswordEncoder.matches(user.getPassword(),username_object.getPassword()))
			return true;
		else
			return false;
	}

	@Override
	public Accounts findByName(String name) {
		// TODO Auto-generated method stub
		return urepo.findAccountsByUsername(name);
	}

	@Override
	public List<Accounts> listAllUsers() {
		// TODO Auto-generated method stub
		return urepo.findAll();
	}

}













