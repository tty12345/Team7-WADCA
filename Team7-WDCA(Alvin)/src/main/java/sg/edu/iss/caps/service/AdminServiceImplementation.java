package sg.edu.iss.caps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.iss.caps.domain.Admin;
import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.repo.AdminRepository;

@Service
public class AdminServiceImplementation implements AdminService {
	@Autowired 
	AdminRepository arepo;
	
	@Override
	public void addAdmin(Admin admin) {
		arepo.save(admin);
	}
	@Override
	public void removeAdmin(Admin admin) {
		arepo.delete(admin);
	}

	@Override
	public Admin findAdminById(int id) {
		Admin foundAdmin = arepo.findAdminById(id);
		return foundAdmin;
	}

	@Override
	public List<Admin> findAdminByFirstName(String name) {
		List<Admin> list = arepo.findAdminByName(name);
		return list;
	}
	@Override
    public List<Admin> listAllAdmins() {
		List<Admin> listAll=arepo.findAll();
		return listAll;
		
	}
				
		



   
	
	}
