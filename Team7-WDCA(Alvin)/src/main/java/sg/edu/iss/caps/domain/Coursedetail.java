package sg.edu.iss.caps.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Coursedetail {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String code;
	private String description;
	private int courseCapacity;
	private String startdate;
	private int credits;
	@OneToMany(mappedBy = "detail")
	private List<Course> course;
	@ManyToOne
	private Lecturer lecturer;
	

	public Coursedetail(int courseCapacity,String code, String courseName, List<Course> course, Lecturer lecturer) {
		super();
		this.courseCapacity = courseCapacity;
		this.course = course;
		this.lecturer = lecturer;
		this.code = code;
		this.course = course;
		this.name = courseName;
	}
	
	public Coursedetail(int courseCapacity,String code, String name, List<Course> course, String description, Lecturer lecturer) {
		super();
		this.courseCapacity = courseCapacity;
		this.course = course;
		this.name= name;
		this.lecturer = lecturer;
		this.code = code;
		this.description=description;

	}
	
	public Coursedetail(int id, int courseCapacity, String code, String name, String description, int credits) {
		super();
		this.id = id;
		this.courseCapacity = courseCapacity;
		this.description = description;
		this.code = code;
		this.name = name;
		this.credits = credits;
	}
	public Coursedetail(int id, int courseCapacity,  String code, String name, String startdate,
			 String description, int credits, Lecturer lecturer) {
		super();
		this.id = id;
		this.courseCapacity = courseCapacity;
		this.description = description;
		this.code = code;
		this.name = name;
		this.startdate = startdate;
		this.credits = credits;
		this.lecturer = lecturer;
	}
	
	@Override
	public String toString() {
		return "Coursedetail [courseCapacity=" + courseCapacity + ", course=" + course + "]";
	}
	public int getCourseCapacity() {
		return courseCapacity;
	}
	public void setCourseCapacity(int courseCapacity) {
		this.courseCapacity = courseCapacity;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + courseCapacity;
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
		Coursedetail other = (Coursedetail) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (courseCapacity != other.courseCapacity)
			return false;
		return true;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Coursedetail(int courseCapacity, List<Course> course) {
		super();
		this.courseCapacity = courseCapacity;
		this.course = course;
	}
	public Coursedetail() {
		super();
	}

	public String getCourseName() {
		return name;
	}

	public void setCourseName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	
}
