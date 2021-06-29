package sg.edu.iss.caps.service;

import java.util.List;

import sg.edu.iss.caps.domain.Admin;

public interface AdminService {
	public void addAdmin(Admin admin);
	public void removeAdmin(Admin admin);
	public Admin findAdminById(int id);
	public List<Admin> findAdminByFirstName(String name);
	
	public List<Admin> listAllAdmins();
	
}
