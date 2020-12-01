package service;

import javax.persistence.EntityManager;

import model.Student;

public class StudentManager {
	
	/**
	 * For creating the new student record in "STUDENT" table.
	 * @param entitymanager
	 * @param studentId
	 * @param firstName
	 * @param lastName
	 * @param email
	 */
	public static void createStudent(EntityManager entitymanager, int studentId, String firstName, String lastName, String email) {
		
		entitymanager.getTransaction().begin( );
		
		Student student = new Student(); 
		student.setStudentId(studentId);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setEmail(email);
		
	    entitymanager.persist(student);
	    
	    entitymanager.getTransaction( ).commit( );
	   
	    
	}
}
