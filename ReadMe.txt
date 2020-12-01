CJV805 Assignment 3 ¨C Summer 2020

Assignment Submission Form
==========================================================================
I/we declare that the attached assignment is my/our own work in accordance
with Seneca Academic Policy. No part of this assignment has been copied
manually or electronically from any other source (including web sites) or
distributed to other students.

Group members: Yuhang Zhao (150467199)
		 	   	   
This application is using MySQL database.
URL: jdbc:mysql://mymysql.senecacollege.ca/db_yzhao248
MySQL user: db_yzhao248
MySQL password: Be}9B2wk%w
--------------------------------------------------------------------------

--------------------------------------------------------------------------

--------------------------------------------------------------------------
< The brief description of the assignment and Reflection > 

The sequence for this web applciation: 
1. First of all, you need to run the main function in service.CourseManager to populate the contents of "COURSE" table.
2. Run that SenecaCourseRegistration.xhtml page on the server, after entering some valid info, student ID, first name, last name and email, you need to click the "Create new student" button.
   One new student record will be stored in "STUDENT" table. If the input entered is invalid, some errors would come out.
3. Next, you can click "Enroll" button to redirect to CourseSelection.xhtml page. In this page, you can select the course and its semester and section, then click "Select" button.
4. After that, you can click "Back" button. At this time, you will go back to SenecaCourseRegistration.xhtml page.
5. Next, you can click "View/Edit student" to redirect you to the CourseTable.xhtml page. In this page, you can see all courses selected by the current student. Other than that, the user can
   also click the "Drop!" button to drop one course.									


"model" package:
This program conforms to MVC structure. In Java Resources folder, it has a model package where I create "Course", "Registration", "Student" three entity classes and also two
embeddable classes "CoursePK" and "RegistrationPK" respectively standing for the composite primary key of "Course", "Registration" tables. This is basically  a JPA model part, 
the relationship between "Course" and "Registration" is a bidirectional one-to-many relationship while the relationship between "Student" and "Registration" is also a bidirectional 
one-to-many relationship. Here "Registration" table is as a bridge table between "Course" table and "Student" table. The reason why we have this relationships is from the requirement
itself(the primary key in the registration table is the combination of Student_ID, Semester, Course_ID, and Section).  

From these models and some required annotations embedded, it will automatically create some tables in the underlining MySQL database. However, only for the relationship between 
"Course" table and "Student" table, we determine to manually configure it within MySQL workbench.(One sql statement file in this project is to establish this relationship). 
Honestly, the reason behind that is this way to do is easier and clearer, because the primary keys of "Registration" and "Course" tables are both composite primary keys, also only "Course_ID", 
"Semester" and "Section" would be as foreign keys referencing to the columns in "Course" table.


"service" package:
In service package, there are three manager classes which are responsible for providing some CRUD methods for corresponding models.

The first CourseManager class has a createCourse method. We actually use this method to pre-populate our "Course" table. There is a main function within this class, so you can run this
main function with a fixed list of all courses' info to populate "Course" table.

In the RegistrationManager class, it has a createRegistration for creating a new Registration and storing it in the "Registration" table. Another getAllRegistration method will be based on Student_Id
to return a list of Registration objects, which corresponds to "select" button in CourseSelection page. Also, deleteOneRegistrationSelection method will be based on studentId, Course_Id, Semester 
and Section to delete one record in "Registration" table, which corresponds to the "drop" button in CourseTable page.

In the StudentManager class, createStudent method is to create new student in "Student" table, which corresponds to "Create new student" button in SenecaCourseRegistration.xhtml page.


WebContent folder:
In /WebContent/resources/css, there is a style.css file for stylizing our xhtml pages. 

Then, there are three xhtml pages, "CourseSelection.xhtml", "CourseTable.xhtml" and "SenecaCourseRegistration.xhtml".


ProcessBean class:
ProcessBean class is in the default package. It is a ManagedBean for getting and setting some fields in the web pages.
saveStudent method in this ManagedBean is to call StudentManager.createStudent method to create a new Student record in the "Student" table;
saveCourseSelection method is to call RegisterationManager.createRegistration method to create a new Registration record in the "Registration" table;
getRegistrations method is to call RegisterationManager.getAllRegistration method to return a list of Registration objects for a specific student_id;
deleteOneRegistrationSelection method is to call RegisterationManager.deleteOneRegistrationSelection method to delete one record in the "Registration" table based on studentId, Course_Id, Semester, Section.

****************************************************************************
For the part of checking if the selection of course_id, semester and section, we didn't satisfy it, even though we have a method to do it in ProcessBean.
 
