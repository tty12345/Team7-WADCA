package sg.edu.iss.caps.domain;


import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Lecturer {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String position;
	@OneToOne(mappedBy = "lecturer", cascade = CascadeType.ALL)
	private Accounts account;
	
	@OneToMany
	private List<Course> courses;
	
	@OneToMany
	private List<Coursedetail> Coursedetail;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Accounts getAccount() {
		return account;
	}

	public void setAccount(Accounts account) {
		this.account = account;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Lecturer(String name, String position, Accounts account, List<Course> courses) {
		super();
		this.name = name;
		this.position = position;
		this.account = account;
		this.courses = courses;
	}

	
	public Lecturer(String name, String position, Accounts account) {
		super();
		this.name = name;
		this.position = position;
		this.account = account;
	}

	public Lecturer() {
		super();
	}

	public Lecturer(String name, String position) {
		super();
		this.name = name;
		this.position = position;
	}

	@Override
	public String toString() {
		return "Lecturer [id=" + id + ", name=" + name + ", position=" + position + ", account=" + account + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
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
		Lecturer other = (Lecturer) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

}
