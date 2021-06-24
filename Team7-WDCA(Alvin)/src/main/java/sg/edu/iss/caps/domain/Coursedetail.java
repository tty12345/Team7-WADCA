package sg.edu.iss.caps.domain;

<<<<<<< HEAD
import java.util.Collection;
=======
import java.util.List;
>>>>>>> stash

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Coursedetail {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int courseCapacity;
<<<<<<< HEAD
	
	@OneToMany(mappedBy = "detail")
	private Collection<Course> course;
=======
	@OneToMany
	private List<Course> course;
>>>>>>> stash
	
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
<<<<<<< HEAD
	public Collection<Course> getCourse() {
=======
	public List<Course> getCourse() {
>>>>>>> stash
		return course;
	}
<<<<<<< HEAD
	public void setCourse(Collection<Course> course) {
		this.course = course;
=======
	public void setCourse(Course course) {
		this.course = (List<Course>) course;
>>>>>>> stash
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
<<<<<<< HEAD
	public Coursedetail(int courseCapacity, Collection<Course> course) {
=======
	public Coursedetail(int courseCapacity, List<Course> course) {
>>>>>>> stash
		super();
		this.courseCapacity = courseCapacity;
		this.course = course;
	}
	public Coursedetail() {
		super();
	}
	
	
	
}
