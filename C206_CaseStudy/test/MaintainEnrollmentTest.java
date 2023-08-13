import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MaintainEnrollmentTest 
{

	private ArrayList<Course> courseList;
	private ArrayList<CourseEnroll> enrollmentList;
	
	public MaintainEnrollmentTest()
	{
		super();
	}
	
	@Before
	public void setUp() throws Exception 
	{
		courseList= new ArrayList<>();
		enrollmentList = new ArrayList<>();
		
	}

	@After
	public void tearDown() throws Exception 
	{
		courseList = null;
		enrollmentList = null;
	}
	
	//Hamzah
	 @Test
	 public void testAddEnrollment() 
	 {
	        courseList = new ArrayList<>();
	        enrollmentList = new ArrayList<>();
	        
	        Account student1 = new Account("Student1", 55555555, "12345", "Student1@gmail.com", 13000000, "Student");
	        
	        Course mathCourse = new Course(33333333, "C003", "Math", "Math is fun.", 5, 330.00, 10);
	        Course englishCourse = new Course(33333333, "C001", "Secondary 2 English", "Enhance student's English language.", 2.30, 230.00, 30);
	        Course geographyCourse = new Course(44444444, "C002", "Secondary 4 Geography", "Enhance student's Geography.", 4, 260.00, 20);
	        
	        CourseEnroll enrolledCourse = new CourseEnroll(55555555, "C001", "Secondary 2 English", "Enhance student's English language.", 2.30, 230.00, 30);
	        
	        // Adding the data to the lists
	        courseList.add(mathCourse);
	        courseList.add(englishCourse);
	        courseList.add(geographyCourse);
	        
	        enrollmentList.add(enrolledCourse);
	        
	        // Performing the enrollment action
	        TuitionManagement.addEnrollment(courseList, enrollmentList, student1, null);
	        
	        // Check that enrollmentList size has increased
	        assertEquals("Check that CourseEnroll arraylist size increased", 2, enrollmentList.size());
	    }

	 
	 	//Hamzah
	    @Test
	    public void testUpdateEnrollment() 
	    {
	        courseList = new ArrayList<>();
	        enrollmentList = new ArrayList<>();
	        
	        Account student1 = new Account("Student1", 55555555, "12345", "Student1@gmail.com", 13000000, "Student");
	        
	        // Adding the necessary data
	        
	        CourseEnroll enrolledCourse1 = new CourseEnroll(55555555, "C001", "Secondary 2 English", "Enhance student's English language.", 2.30, 230.00, 30);
	        CourseEnroll enrolledCourse2 = new CourseEnroll(55555555, "C002", "Secondary 4 Geography", "Enhance student's Geography.", 4, 260.00, 20);
	        
	        Course englishCourse = new Course(33333333, "C001", "Secondary 2 English", "Enhance student's English language.", 2.30, 230.00, 30);
	        Course geographyCourse = new Course(44444444, "C002", "Secondary 4 Geography", "Enhance student's Geography.", 4, 260.00, 20);
	        
	        enrollmentList.add(enrolledCourse1);
	        enrollmentList.add(enrolledCourse2);
	        courseList.add(englishCourse);
	        courseList.add(geographyCourse);
	        
	        // Retrieve course codes from the list
	       String englishCourseCode = enrolledCourse1.getCid();
	        
	        // Performing the update enrollment action
	        TuitionManagement.updateEnrollment( courseList, enrollmentList, student1);
	        
	        // Check if the enrollment has been successfully updated
	        assertEquals("Check updated enrollment course ID", "C002", enrolledCourse2.getCid());
	        assertEquals("Check updated enrollment course name", "Secondary 4 Geography", enrolledCourse2.getCname());
	        assertEquals("Check updated enrollment description", "Enhance student's Geography.", enrolledCourse2.getDescription());
	        assertEquals("Check updated enrollment duration", 4, enrolledCourse2.getDuration(), 0.01);
	        assertEquals("Check updated enrollment cost", 260.00, enrolledCourse2.getCost(), 0.01);
	        assertEquals("Check updated enrollment size", 20, enrolledCourse2.getSize());
	    }
	    
	    //Hamzah
	    @Test
		public void testDeleteEnrollment() 
	    {
			enrollmentList = new ArrayList<>();
			
			Account student1 = new Account("Student1", 55555555, "12345", "Student1@gmail.com", 13000000, "Student");
			
			CourseEnroll enrolledCourse1 = new CourseEnroll(55555555, "C001", "Secondary 2 English", "Enhance student's English language.", 2.30, 230.00, 30);
			CourseEnroll enrolledCourse2 = new CourseEnroll(55555555, "C002", "Secondary 4 Geography", "Enhance student's Geography.", 4, 260.00, 20);
			
			enrollmentList.add(enrolledCourse1);
			enrollmentList.add(enrolledCourse2);
			
			// Performing the delete enrollment action
			TuitionManagement.deleteEnrollment(enrollmentList, student1);
			
			// Check that enrollmentList size has decreased
			assertEquals("Check that CourseEnroll arraylist size decreased", 1, enrollmentList.size());
		}
}
