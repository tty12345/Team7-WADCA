package sg.edu.iss.caps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.iss.caps.domain.Accounts;
import sg.edu.iss.caps.domain.Admin;
import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Lecturer;
import sg.edu.iss.caps.domain.Student;
import sg.edu.iss.caps.repo.AdminRepository;
import sg.edu.iss.caps.repo.CourseRepository;
import sg.edu.iss.caps.repo.LecturerRepository;
import sg.edu.iss.caps.repo.StudentRepository;
import sg.edu.iss.caps.repo.accountsrepository;


@Service
public class AdminServiceImplementation implements AdminService {
	@Autowired 
	AdminRepository arepo;
	@Autowired
	StudentRepository srepo;
	@Autowired
	accountsrepository accrepo;
	@Autowired
	CourseRepository crepo;
	@Autowired
	LecturerRepository lrepo;
	
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
	
	public Student findStudentById(Integer id) {
		Student student = srepo.findStudentById(id);
		return student;
	}

	public void save(Student student) {
		srepo.save(student);
	}
	
	public List<Student> findAllStudent(){
		List<Student> students = srepo.findAll();
		return students;
	}
	
	public Accounts findAccountByStudentId(Integer id) {
		Accounts account = accrepo.findAccountByStudentId(id);
		return account;
	}
		
	public List<Course> findCoursesByStudentId(Integer id){
		List<Course> courses = crepo.findCoursesByStudentId(id);
		return courses;
	}

	public void deleteRelatedCourses(List<Course> courses) {
		crepo.deleteAll(courses);
	}
   
	public void deleteAcc(Accounts account) {
		accrepo.delete(account);
	}
	
	public void deleteStu(Student student) {
		srepo.delete(student);
	}
	
	public Lecturer findLecturerById(Integer id) {
		Lecturer lecturer = lrepo.findLecturerById(id);
		return lecturer;
	}

	public Accounts findAccountByLecturerId(Integer id) {
		return accrepo.findAccountByLecturerId(id);
	}
	
	public List<Course> findCoursesByLecturerId(Integer id){
		return crepo.findCoursesByLecturerId(id);
	}
	public void delete(Accounts account) {
		accrepo.delete(account);
	}
}
