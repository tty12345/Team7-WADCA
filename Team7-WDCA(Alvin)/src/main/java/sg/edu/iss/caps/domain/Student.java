package sg.edu.iss.caps.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@OneToOne(mappedBy = "studentacc")
	private Accounts account;
	
	public Accounts getAccount() {
		return account;
	}
	public void setAccount(Accounts account) {
		this.account = account;
	}

	@OneToMany(mappedBy = "student")
	private List<Course> coursesTaken;
	
	public Student(String firstName, String secondName, String major, double gpa, int creditsTaken, Accounts account,
			List<Course> coursesTaken) {
	@OneToMany(mappedBy="student")
	public Collection<Course> courses;
	
	public Student(String firstName, String secondName, String major, int creditsTaken) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.major = major;
		this.gpa = gpa;
		this.creditsTaken = creditsTaken;
		this.account = account;
		this.coursesTaken = coursesTaken;
	}
	public Student(String firstName, String secondName, String major, double gpa, int creditsTaken) {
		this.creditsTaken = creditsTaken;
	}
	public Student(String firstName, String secondName, String major, int creditsTaken,
			Accounts account) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.major = major;
		this.creditsTaken = creditsTaken;
	}
	public Student(String firstName, String secondName, String major) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.major = major;
	}
	public Student() {
		super();
	}
	public int Id() {
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
	public void setGpa() {
		if (courses != null) {
			double grandTotal = 0;
			int creditsTotal = 0;
			
			for (Course course : courses) {
				double capscore = 0;
				
				switch(course.getGrade()) {
				case "A+":
					capscore = 5.0;
					break;
				case "A":
					capscore = 5.0;
					break;
				case "A-":
					capscore = 4.5;
					break;
				case "B+":
					capscore = 4.0;
					break;
				case "B":
					capscore = 3.5;
					break;
				case "B-":
					capscore = 3.0;
					break;
				case "C+":
					capscore = 2.5;
					break;
				case "C":
					capscore = 2.0;
					break;
				case "D+":
					capscore = 1.5;
					break;
				case "D":
					capscore = 1.0;
					break;
				case "F":
					break;
				default:
					capscore = 0;
				}
				
				grandTotal += course.getCredits() * capscore;
				creditsTotal += course.getCredits();
			}
			this.gpa = grandTotal / creditsTotal; 
			this.creditsTaken = creditsTotal;
		} else {
			this.gpa = 0.0;
			this.creditsTaken = 0;
		}
	}
	public int getCreditsTaken() {
		return creditsTaken;
	}
	public void setCreditsTaken(int creditsTaken) {
		this.creditsTaken = creditsTaken;
	}
	public Collection<Course> getCourses() {
		return courses;
	}
	public void setCourses(Collection<Course> courses) {
		this.courses = courses;
		setGpa();
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", major=" + major
				+ ", gpa=" + gpa + ", creditsTaken=" + creditsTaken  + "]";
	}
	
}
