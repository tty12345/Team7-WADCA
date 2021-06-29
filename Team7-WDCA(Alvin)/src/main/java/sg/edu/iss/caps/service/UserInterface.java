package sg.edu.iss.caps.service;

import java.util.List;

import sg.edu.iss.caps.domain.Accounts;

public interface UserInterface {
	public void createUser(Accounts user);
	public void updateUser(Accounts user);
	public void deleteUser(Accounts user);
	public boolean authenticateUser(Accounts user);
	public Accounts findByName(String name);
	public List<Accounts> listAllUsers();
}
