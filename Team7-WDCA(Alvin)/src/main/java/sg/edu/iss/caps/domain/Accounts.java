package sg.edu.iss.caps.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Accounts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String username;
	private String password;
	private RoleType role;
	@OneToOne
	private Student studentacc;
	@OneToOne
	private Lecturer lecturer;
	@OneToOne
	private Admin admin;
	public Accounts(String username, String password, RoleType role, Student student, Lecturer lecturer, Admin admin) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.studentacc = student;
		this.lecturer = lecturer;
		this.admin = admin;
	}
	
	public Accounts(String username, String password, RoleType role, Lecturer lecturer) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.lecturer = lecturer;
	}
	
	public Accounts(String username, String password, RoleType role, Student stu) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.studentacc = stu;
	}
	

	public Accounts() {
		super();
	}

	public Accounts(String username, String password, RoleType role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	@Override
	public String toString() {
		return "Accounts [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", student=" + studentacc + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accounts other = (Accounts) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RoleType getRole() {
		return role;
	}
	public void setRole(RoleType role) {
		this.role = role;
	}
	public Student getStudent() {
		return studentacc;
	}
	public void setStudent(Student student) {
		this.studentacc = student;
	}
	public Lecturer getLecturer() {
		return lecturer;
	}
	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	

	
}
