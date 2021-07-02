package sg.edu.iss.caps.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TempCourses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(mappedBy = "tempcourses")
	private Coursedetail coursedetail;

	
	public TempCourses(Coursedetail coursedetail) {
		super();
		this.coursedetail = coursedetail;
	}

	public TempCourses(int id, Coursedetail coursedetail) {
		super();
		this.id = id;
		this.coursedetail = coursedetail;
	}

	public TempCourses() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Coursedetail getCoursedetail() {
		return coursedetail;
	}

	
	public void setCoursedetail(Coursedetail coursedetail) {
		this.coursedetail = coursedetail;
	}

	@Override
	public String toString() {
		return "TempCourses [id=" + id + ", coursedetail=" + coursedetail + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coursedetail == null) ? 0 : coursedetail.hashCode());
		result = prime * result + id;
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
		TempCourses other = (TempCourses) obj;
		if (coursedetail == null) {
			if (other.coursedetail != null)
				return false;
		} else if (!coursedetail.equals(other.coursedetail))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
