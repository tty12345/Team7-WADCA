package sg.edu.iss.caps.service;

import java.util.List;

import sg.edu.iss.caps.domain.Accounts;
import sg.edu.iss.caps.domain.Admin;
import sg.edu.iss.caps.domain.Course;
import sg.edu.iss.caps.domain.Lecturer;
import sg.edu.iss.caps.domain.Student;

public interface AdminService {
	public void addAdmin(Admin admin);
	public void removeAdmin(Admin admin);
	public Admin findAdminById(int id);
	public List<Admin> findAdminByFirstName(String name);
	public List<Admin> listAllAdmins();
	public Student findStudentById(Integer id);
	public void save( Student student);
	public List<Student> findAllStudent();
	public Accounts findAccountByStudentId(Integer id);
	public List<Course> findCoursesByStudentId(Integer id);
	public void deleteRelatedCourses(List<Course> courses);
	public void deleteAcc(Accounts account);
	public void deleteStu(Student student);
	public Lecturer findLecturerById(Integer id);
	public Accounts findAccountByLecturerId(Integer id);
	public List<Course> findCoursesByLecturerId(Integer id);
	public void delete(Accounts account);
	public Admin findAdminByUsername(String un);

	
}
