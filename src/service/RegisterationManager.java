package service;

import model.Registration;
import model.RegistrationPK;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Student;


public class RegisterationManager {
	
	/**
	 * For creating the new registration record in the "REGISTRATION" table.
	 * @param entitymanager
	 * @param studentId
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param Semester
	 * @param Course_ID
	 * @param Section
	 * @param Course_Name
	 */
	public static void createRegistration(EntityManager entitymanager, int studentId, String firstName, String lastName, String email, String Semester, String Course_ID, String Section, String Course_Name) {
			
		
			
			entitymanager.getTransaction().begin( );
			
			
			Student student = new Student();
			student.setStudentId(studentId);
			student.setEmail(email);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			
			RegistrationPK registration_PK = new RegistrationPK();
			registration_PK.setStudentID(studentId);
			registration_PK.setCourseID(Course_ID);
			registration_PK.setSection(Section);
			registration_PK.setSemester(Semester);
			
			Registration registration = new Registration(); 
			registration.setRegistrationPK(registration_PK);
			registration.setFirstName(firstName);
			registration.setLastName(lastName);
			registration.setEmail(email);
			registration.setCourseName(Course_Name);
			
			registration.setStudent(student);
			
		    entitymanager.persist(registration);
		    
		    entitymanager.getTransaction( ).commit( );
		   
		    
		}
	
	
	
	/**
	 * Return a list of Registration objects, based on one specific unique studentId.
	 * @param entitymanager
	 * @param studentId
	 * @return List<Registration>
	 */
	public static List<Registration> getAllRegistration(EntityManager entitymanager, int studentId) {
		final String jpqlQuery = "SELECT * FROM REGISTRATION WHERE Student_ID=?1";
		// create a dynamic query
		@SuppressWarnings("unchecked")
		TypedQuery<Registration> query = (TypedQuery<Registration>)entitymanager.createNativeQuery(jpqlQuery, Registration.class);
		
		// set parameter
		query.setParameter(1, studentId);
		// Query and get result
		List<Registration> l =  query.getResultList();
		if(l!=null && l.size()>0) {
			return l;
		}else {
			return null;
		}
	}
	
	/**
	 * Delete one registration record in "REGISTRATION" table, based on the combonation of studentId, Course_Id, Semester and Section
	 * @param entitymanager
	 * @param studentId
	 * @param Course_Id
	 * @param Semester
	 * @param Section
	 */
	public static void deleteOneRegistrationSelection(EntityManager entitymanager, int studentId, String Course_Id, String Semester, String Section) {
	
		entitymanager.getTransaction().begin( );
		
		final String jpqlQuery = "DELETE FROM Registration r WHERE r.registration_PK.Student_ID=?1 AND r.registration_PK.Course_ID=?2 AND r.registration_PK.Semester=?3 AND r.registration_PK.Section=?4";
		Query query = entitymanager.createQuery(jpqlQuery, Registration.class);
		
		query.setParameter(1, studentId);
		query.setParameter(2, Course_Id);
		query.setParameter(3, Semester);
		query.setParameter(4, Section);
		
		query.executeUpdate();
		entitymanager.getTransaction( ).commit( );
	}

	
}
