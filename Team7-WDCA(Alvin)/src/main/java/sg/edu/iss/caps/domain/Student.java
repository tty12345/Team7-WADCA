package sg.edu.iss.caps.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String firstName;
	
	private String secondName;
	
	private String major;
	
	private double gpa;
	
	private int creditsTaken;
	
	@OneToMany(mappedBy = "student")
	private List<Course> coursesTaken;
	
	@OneToOne(mappedBy = "student" ,cascade = {CascadeType.ALL}) 
	@JoinColumn(name="AccountId")
	private Accounts account;

	public Student(String firstName, String secondName, String major, double gpa, int creditsTaken) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.major = major;
		this.gpa = gpa;
		this.creditsTaken = creditsTaken;
	}
		public Student(String firstName, String secondName, String major, double gpa, int creditsTaken,
				List<Course> coursesTaken, Accounts account) {
			super();
			this.firstName = firstName;
			this.secondName = secondName;
			this.major = major;
			this.gpa = gpa;
			this.creditsTaken = creditsTaken;
			this.coursesTaken = coursesTaken;
			this.account = account;
		}
	public Student(String firstName, String secondName, String major) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.major = major;
	}
	
	public Student(String firstName, String secondName) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
	}
	public Student() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public int getCreditsTaken() {
		return creditsTaken;
	}
	public void setCreditsTaken(int creditsTaken) {
		this.creditsTaken = creditsTaken;
	}
	public List<Course> getCoursesTaken() {
		return coursesTaken;
	}
	public void setCoursesTaken(List<Course> coursesTaken) {
		this.coursesTaken = coursesTaken;
	}
	
	public Accounts getAccount() {
		return account;
	}
	public void setAccount(Accounts account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", major=" + major
				+ ", gpa=" + gpa + ", creditsTaken=" + creditsTaken  + "]";
	}
	
}
