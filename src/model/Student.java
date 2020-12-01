package model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * Student entity model, standing for "STUDENT" table. 
 *
 */
@Entity
@Table(name="STUDENT")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Student_ID", unique = true, nullable = false, updatable = false) 
	private int studentId;
	
	private String firstName;
	private String lastName;
	private String email;
	
	//Bidirectional one-to-many relationship between "Student" and "Registration" 
	@OneToMany(mappedBy="student")
	private List<Registration> listRegistrations = new ArrayList<Registration>();
	
	@OneToMany
	public List<Registration> getListRegistration() {
		return this.listRegistrations;
	}
	
	public void setListRegistration(List<Registration> listRegistrations) {
		this.listRegistrations = listRegistrations;
	}
	
	
	/**
	 * Default constructor, required by JPA
	 */
	public Student() {
		super();
	}
	
	/**
	 * Convenience constructor
	 */
	public Student(int studentId, String firstName, String lastName, String email) {
		
		super();
		this.studentId = studentId;
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		
		this.studentId = studentId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
