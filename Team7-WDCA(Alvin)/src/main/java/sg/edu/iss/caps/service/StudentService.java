package sg.edu.iss.caps.service;

import java.util.List;

import sg.edu.iss.caps.domain.Student;

public interface StudentService {
	
	public void addStudent(Student student);
	public void removeStudent(Student student);
	public Student findStudentById(int id);
	public List<Student> findStudentByFirstName(String name);
	public double showGpaById(int id);
	public int showCreditsTakenById(int id);
	public List<Student> listAllStudents();
	//public List<Module> listModuleByStudentId(int id);
	
}
