package model;



import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * 
 * Registration class is an entity model, standing for "REGISTRATION" table.
 *
 */
@Entity
@Table(name="REGISTRATION")
public class Registration {
	@EmbeddedId
	private RegistrationPK registration_PK;

	private String First_Name;
	private String Last_Name;
	private String Email;
	
	
	private String Course_Name;
	
	//Bidirectional many-to-one relationship between "Student" and "Registration" 
	@ManyToOne
	@MapsId("Student_ID")
	@JoinColumn(name= "Student_ID")
	private Student student;
	
	
	public Student getStudent() {
		return this.student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	/**
	 * Default constructor, required by JPA
	 */
	public Registration() {
		super();
	}
	
	
	public RegistrationPK getRegistrationPK() {
		return this.registration_PK;
	}
	public void setRegistrationPK(RegistrationPK registration_PK) {
		this.registration_PK = registration_PK;
	}
	
	public String getFirstName() {
		return First_Name;
	}
	public void setFirstName(String firstName) {
		this.First_Name = firstName;
	}
	
	public String getLastName() {
		return Last_Name;
	}
	public void setLastName(String lastName) {
		this.Last_Name = lastName;
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	
	
	
	public String getCourseName() {
		return Course_Name;
	}
	public void setCourseName(String Course_Name) {
		this.Course_Name = Course_Name;
	}
}
