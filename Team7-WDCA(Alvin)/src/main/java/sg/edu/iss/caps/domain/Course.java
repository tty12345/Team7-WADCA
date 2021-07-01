package sg.edu.iss.caps.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String code;
	private String name;
	private String grade;
	private double score;
	private int credits;
	@ManyToOne
	private Student student;
	@ManyToOne
	private Lecturer lecturer;
	@ManyToOne
	private Coursedetail detail;
	
	public Course(String code, String name, String grade, double score, int credits, Student student,
			Lecturer lecturer, Coursedetail detail) {

		super();
		this.code = code;
		this.name = name;
		this.score = score;
		setScore(score);
		this.credits = credits;
		this.student = student;
		this.lecturer = lecturer;
		this.detail = detail;
	}
	
	public Course(String code, String name, double score, Student student) {
		super();
		this.code = code;
		this.name = name;
		this.score = score;
		setScore(score);
		this.student = student;
	}
	
	public Course(String code, String name, int credits) {
		super();
		this.code = code;
		this.name = name;
		this.credits = credits;
	}

	public Course(String code, String name, int credits, double score, Student student) {
		super();
		this.code = code;
		this.name = name;
		this.credits = credits;
		this.score = score;
		setScore(score);
		this.student = student;
	}

	public Course(String code, String name, int credits, Lecturer lecturer, double score) {
		super();
		this.code = code;
		this.name = name;
		this.credits = credits;
		this.lecturer = lecturer;
		this.score = score;
		setScore(this.score);
	}

	public Course(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public Course() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getGrade() {
		return this.grade;
	}

	private void setGrade(String grade) {
		this.grade = grade;
	}

	public Coursedetail getDetail() {
		return detail;
	}

	public void setDetail(Coursedetail detail) {
		this.detail = detail;
	}

	public double getScore() {
		return score;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}

	public void setScore(double score) {
		this.score = score;
		
		if (score >= 85) {
			setGrade("A+");
		} else if (score >= 80 && score <= 84){
			setGrade("A");
		} else if (score >= 75 && score <= 79){
			setGrade("A-");
		} else if (score >= 70 && score <= 74){
			setGrade("B+");
		} else if (score >= 65 && score <= 69){
			setGrade("B");
		} else if (score >= 60 && score <= 64){
			setGrade("B-");
		} else if (score >= 55 && score <= 59){
			setGrade("C+");
		} else if (score >= 50 && score <= 54){
			setGrade("C");
		} else if (score >= 45 && score <= 49){
			setGrade("D+");
		} else if (score >= 40 && score <= 44){
			setGrade("D");
		} else if (score >= 0 && score <= 39){
			setGrade("F");
		} else {
			setGrade(null);
		}
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", code=" + code + ", name=" + name + ", grade="
				+ grade + ", score=" + score + "]";
	}
}
