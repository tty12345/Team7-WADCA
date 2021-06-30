package sg.edu.iss.caps.domain;


import java.util.Collection;
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
	private String courseName;
	private String code;
	private int courseCapacity;
	@OneToMany(mappedBy = "detail")
	private List<Course> course;
	@ManyToOne
	private Lecturer lecturer;
	

	public Coursedetail(int courseCapacity,String code, String courseName, List<Course> course, Lecturer lecturer) {
		super();
		this.courseCapacity = courseCapacity;
		this.course = course;
		this.setCourseName(courseName);
		this.lecturer = lecturer;
		this.code = code;
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
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}
