package model;



import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * 
 * Course entity model.
 *
 */
@Entity
@Table(name="COURSE")
public class Course {
	@EmbeddedId
	private CoursePK Course_PK;
	
	private String Course_Name;
	
	
	/**
	 * Default constructor, required by JPA
	 */
	public Course() {
		super();
	}
	
	
	//getter and setter methods
	public CoursePK getCoursePK() {
		return this.Course_PK;
	}
	public void setCoursePK(CoursePK Course_PK) {
		this.Course_PK = Course_PK;
	}
	
	public String getCourse_Name() {
		return Course_Name;
	}
	public void setCourse_Name(String Course_Name) {
		this.Course_Name = Course_Name;
	}
	
	
}
