package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * 
 * CoursePK is Embeddable class, which would be regarded as a composite primary key in the "Course" table.
 *
 */
@Embeddable
public class CoursePK implements Serializable {
	@Column
	private String Course_ID;
	@Column
	private String Semester;
	@Column
	private String Section;
	
	/**
	 * Default constructor, required by JPA
	 */
	public CoursePK() {
		super();
	}
	
	public CoursePK(String Course_ID, String Semester, String Section) {
		this.Course_ID = Course_ID;
		this.Semester = Semester;
		this.Section = Section;
	}
	
	
	public String getCourse_ID() {
		return Course_ID;
	}
	public void setCourse_ID(String Course_ID) {
		this.Course_ID = Course_ID;
	}
	
	public String getSemester() {
		return Semester;
	}
	public void setSemester(String Semester) {
		this.Semester = Semester;
	}
	
	public String getSection() {
		return Section;
	}
	public void setSection(String Section) {
		this.Section = Section;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Course_ID == null) ? 0 : Course_ID.hashCode());
		result = prime * result + ((Semester == null) ? 0 : Semester.hashCode());
		result = prime * result + ((Section == null) ? 0 : Section.hashCode());
		
		
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
		CoursePK other = (CoursePK) obj;
		if (Course_ID == null) {
			if (other.Course_ID != null)
				return false;
		} else if (!Course_ID.equals(other.Course_ID))
			return false;
		
		if (Semester == null) {
			if (other.Semester != null)
				return false;
		} else if (!Semester.equals(other.Semester))
			return false;
		
		if (Section == null) {
			if (other.Section != null)
				return false;
		} else if (!Section.equals(other.Section))
			return false;	
		return true;
	}
}