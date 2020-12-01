package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.CoursePK;
import model.Course;

public class CourseManager {
	
	/**
	 * This main function should be run first to populate the content of "COURSE" table.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Assignment3");
		EntityManager entitymanager = emfactory.createEntityManager();
		CourseManager.createCourse(entitymanager, "CJV805", "Fall 2020", "NAA", "Java With Database");
		CourseManager.createCourse(entitymanager, "DBD800", "Fall 2020", "NBB", "Big Data Introduction");
		CourseManager.createCourse(entitymanager, "SEC835", "Winter 2021", "NZB", "Security With Database");
		CourseManager.createCourse(entitymanager, "WPT100", "Winter 2021", "NAA", "Co-op Work Preparation ");
		entitymanager.close( );
	    emfactory.close( );
		
	}
	
	/**
	 * For creating the new course record in the "COURSE" table.
	 * @param entitymanager
	 * @param Course_ID
	 * @param Semester
	 * @param Section
	 * @param Course_Name
	 */
	public static void createCourse(EntityManager entitymanager, String Course_ID, String Semester, String Section, String Course_Name) {
		entitymanager.getTransaction().begin( );
		
		CoursePK coursePK = new CoursePK();
		coursePK.setCourse_ID(Course_ID);
		coursePK.setSemester(Semester);
		coursePK.setSection(Section);
		
		Course course = new Course(); 
		course.setCoursePK(coursePK);
		course.setCourse_Name(Course_Name);
		
	    entitymanager.persist(course);
	    
	    entitymanager.getTransaction( ).commit( );
	}
}
