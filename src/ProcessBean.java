import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import service.RegisterationManager;
import service.StudentManager;
import model.Student;
import model.Registration;
/**
 * This ProcessBean class is a managedBean, which is to store and set the data for all xhtml pages.
 * 
 */
@ManagedBean(name="processBean")
@SessionScoped
public class ProcessBean implements Serializable{
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	
	private String selectedSemester;
	private String selectedCourseID;
	private String selectedSection;
	
	//getter methods
	public int getId() {
		return this.id;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public String getEmail() {
		return this.email;
	}
	
	public String getSelectedSemester() {
		return this.selectedSemester;
	}
	public String getSelectedCourseID() {
		return this.selectedCourseID;
	}
	public String getSelectedSection() {
		return this.selectedSection;
	}
	
	//setter methods
	public void setId(int id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSelectedSemester(String selectedSemester) {
		this.selectedSemester = selectedSemester;
	}
	public void setSelectedCourseID(String selectedCourseID) {
		this.selectedCourseID = selectedCourseID;
	}
	public void setSelectedSection(String selectedSection) {
		this.selectedSection = selectedSection;
	}
	
	/**
	 * When the user clicks "Create new student" button in SenecaCourseRegistration.xhtml page, this method would be invoked to create a new student record in "Student" table.
	 */
	public void saveStudent() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Assignment3");
		EntityManager entitymanager = emfactory.createEntityManager();
		StudentManager.createStudent(entitymanager, this.getId(), this.getFirstName(), this.getLastName(), this.getEmail());
		entitymanager.close( );
	    emfactory.close( );
	}
	
	/**
	 * When the user clicks "Select" button in CourseSelection.xhtml page, this method would be invoked to create a new registration record in "Registration" table.
	 */
	public void saveCourseSelection() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Assignment3");
		EntityManager entitymanager = emfactory.createEntityManager();
		String courseID = this.getSelectedCourseID();
		String courseName = "";
		switch(courseID) {
			case "CJV805" :
				courseName = "Java With Databases";
				break;
			case "SEC835" :
				courseName = "Security in Databases";
				break;
			case "DBD800" :
				courseName = "Big Data Introduction";
				break;
			case "WTP100" :
				courseName = "Co-op Work Preparation";
				break;
		}
		RegisterationManager.createRegistration(entitymanager, this.getId(), this.getFirstName(), this.getLastName(),this.getEmail(), this.getSelectedSemester(), this.getSelectedCourseID(), this.getSelectedSection(), courseName);
		entitymanager.close( );
	    emfactory.close( );
	}
	
	/**
	 * Based on the current student_id, return a list of this student's all Registration objects. 
	 * @return List<Registration>
	 */
	public List<Registration> getRegistrations() {	
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Assignment3");
			EntityManager entitymanager = emfactory.createEntityManager();
			return RegisterationManager.getAllRegistration(entitymanager, this.getId());
	}
	
	/**
	 * Based on studentId, Course_Id, Semester and Section£¬ delete one registration record in "Registration" table. This method is corresponding to "drop" button in CourseTable.xhtml page.
	 * @param studentId
	 * @param Course_Id
	 * @param Semester
	 * @param Section
	 */
	public void deleteOneRegistrationSelection(int studentId, String Course_Id, String Semester, String Section) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Assignment3");
		EntityManager entitymanager = emfactory.createEntityManager();
		RegisterationManager.deleteOneRegistrationSelection(entitymanager, studentId, Course_Id, Semester, Section);
		entitymanager.close( );
	    emfactory.close( );
	}
	
	/**
	 * For checking if the selection of course_id, semester and section is valid
	 * @return String
	 */
	public String getResult() {
		boolean check1 = (this.getSelectedSemester()).equals("Fall 2020") && (this.getSelectedCourseID()).equals("CJV805") && (this.getSelectedSection()).equals("NAA");
		boolean check2 = (this.getSelectedSemester()).equals("Fall 2020") && (this.getSelectedCourseID()).equals("DBD800") && (this.getSelectedSection()).equals("NBB");
		boolean check3 = (this.getSelectedSemester()).equals("Winter 2021") && (this.getSelectedCourseID()).equals("SEC835") && (this.getSelectedSection()).equals("NBB");
		boolean check4 = (this.getSelectedSemester()).equals("Winter 2021") && (this.getSelectedCourseID()).equals("WPT100") && (this.getSelectedSection()).equals("NAA");
		if( check1==true) {
			return "<p style=\"background-color:yellow;width:300px;" +
			        "padding:5px\"> Successfful</p>";
		}
		else if(check2==true) {
			return "<p style=\"background-color:yellow;width:300px;" +
			        "padding:5px\"> Successfful</p>";
		}
		else if(check3==true) {
			return "<p style=\"background-color:yellow;width:300px;" +
			        "padding:5px\"> Successfful</p>";
		}
		else if(check4==true) {
			return "<p style=\"background-color:yellow;width:300px;" +
			        "padding:5px\"> Successfful</p>";
		}
		else 
			return "<p style=\"background-color:yellow;width:300px;" +
		            "padding:5px\"> selects a course which is not\r\n" + 
		            "introduced in the semester</p>";
		}
		
	
	
}
