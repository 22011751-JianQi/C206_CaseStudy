import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MaintainCourseTest 
{
	
	private Account teacher1;
	private Account teacher2;
	
	private Course course1;
	private Course course2;
	
	private ArrayList<Account> accountList;
	private ArrayList<Course> courseList;
	
	
	public MaintainCourseTest()
	{
		super();
	}
	
	@Before
	public void setUp() throws Exception 
	{
		teacher1 = new Account("Teacher1", 33333333, "12345", "Teacher1@gmail.com", 11230000, "Teacher");
		teacher2 = new Account("Teacher2", 44444444, "12345", "Teacher2@gmail.com", 14200000, "Teacher");
		
        course1 = new Course(33333333,"C001", "Secondary 2 English", "Enhance student's English language.", 2.30, 230.00, 30);
		course2 = new Course(44444444, "C002", "Secondary 4 Geography", "Enhance student's Geography.", 4.0, 260.00, 20);
        
		courseList = new ArrayList<Course>();
		accountList = new ArrayList<Account>();
		
	}

	@After
	public void tearDown() throws Exception 
	{
		teacher1 = null;
		teacher2 = null;
		
		course1 = null;
		course2 = null;
		
		accountList = null;
		courseList = null;
	}

	//Xing Rong 
	@Test
	public void testAddCourse() {
		//Add teacher accounts
		TuitionManagement.addTeacher(accountList, teacher1);
		TuitionManagement.addTeacher(accountList, teacher2);
		// courseList is not null and it is empty
		assertNotNull("Test if there is valid Course arraylist to add to", courseList);
		assertEquals("Test that the Course arraylist is empty.", 0, courseList.size());
		// Given an empty list, after adding 1 item, the size of the list is 1
		TuitionManagement.addCourse(accountList, courseList, course1);
		assertEquals("Test that the Course arraylist size is 1.", 1, courseList.size());

		// Add a course
		TuitionManagement.addCourse(accountList, courseList, course2);
		assertEquals("Test that the Course arraylist size is now 2.", 2, courseList.size());
		// The item just added is as same as the last item in the list
		assertSame("Test that Course is added to the end of the list.", course2, courseList.get(1));

		// Add a course that already exists in the list
		TuitionManagement.addCourse(accountList, courseList, course2);
		assertEquals("Test that the Course arraylist size is unchange.", 2, courseList.size());

		// Add a course that has missing detail
		Course c_missing = new Course(33333333, "C015", "Primary 1 English", "", 3 , 300.00, 20);
		TuitionManagement.addCourse(accountList, courseList, c_missing);
		assertEquals("Test that the Course arraylist size is unchange.", 2, courseList.size());
	}

	//Xing Rong
	@Test
	public void testDeleteCourse() {
		//Add teacher accounts
		TuitionManagement.addTeacher(accountList, teacher1);
		TuitionManagement.addTeacher(accountList, teacher2);
		// add some courses into courseList
		TuitionManagement.addCourse(accountList, courseList, course1);
		TuitionManagement.addCourse(accountList, courseList, course2);
		// courseList is not empty
		assertEquals("Test that the Course arraylist is not empty.", 2, courseList.size());
		
		// Test case 1
		// Delete a course not in courseList
		TuitionManagement.deleteCourse(courseList, "C012");
		// Test that courseList remain unchanged when delete non-existing course
		assertEquals("Test that the Course arraylist size is unchange.", 2, courseList.size());
		
		// Test case 2
		// Delete a course in courseList
		TuitionManagement.deleteCourse(courseList, "C001");
		// Test that course is successfully deleted
		assertEquals("Test that the Course arraylist size is now 1.", 1, courseList.size());
		// C001 not in course list
		assertFalse("Test that course C00l is no longer in the list", courseList.contains(course1));
		
		// Test case 3
		// Delete all the course in courseList
		TuitionManagement.deleteCourse(courseList, "C002");
		// Check that size is 0
		assertEquals("Test that the Course arraylist size is now 0.", 0, courseList.size());

	}

	//Xing Rong
	@Test
	public void testRetrieveAllCourse() {
		// Test Case 1
		// Test if Item list is not null and empty
		assertNotNull("Test if there is valid Course arraylist to add to", courseList);
		assertEquals("Test that the Course arraylist is empty.", 0, courseList.size());
		// Attempt to retrieve the Courses
		String allCourse = TuitionManagement.retrieveAllCourse(courseList);
		String testOutput = "";
		// Test if the output is empty
		assertEquals("Test that nothing is displayed", testOutput, allCourse);

		// Test Case 2
		//Add teacher accounts
		TuitionManagement.addTeacher(accountList, teacher1);
		TuitionManagement.addTeacher(accountList, teacher2);
		//Add some courses
		TuitionManagement.addCourse(accountList, courseList, course1);
		TuitionManagement.addCourse(accountList, courseList, course2);
		// Test that the list is not empty
		assertEquals("Test that Course arraylist size is 2.", 2, courseList.size());
		
		// Attempt to retrieve the Courses
		allCourse = TuitionManagement.retrieveAllCourse(courseList);
		testOutput = String.format("%-20d %-10s %-25s %-40s %-10.1f %-10.2f %-10d\n",
				33333333,"C001", "Secondary 2 English", "Enhance student's English language.", 2.30, 230.00, 30);
		testOutput += String.format("%-20d %-10s %-25s %-40s %-10.1f %-10.2f %-10d\n",
				44444444, "C002", "Secondary 4 Geography", "Enhance student's Geography.", 4.0, 260.00, 20);
		// Test that the details are displayed correctly
		assertEquals("Test that the display is correct.", testOutput, allCourse);

	}

	//Xing Rong
	@Test
	public void testUpdateCourse() {
		// Test if Item list is not null and empty
		//Add teacher accounts
		TuitionManagement.addTeacher(accountList, teacher1);
		TuitionManagement.addTeacher(accountList, teacher2);
		// add some courses into courseList
		TuitionManagement.addCourse(accountList, courseList, course1);
		TuitionManagement.addCourse(accountList, courseList, course2);
		// courseList is not empty
		assertEquals("Test that the Course arraylist is not empty.", 2, courseList.size());
		
		// Test Case 1
		// Update course name of "C001"
		TuitionManagement.updateCourse(accountList, courseList,
				new Course(33333333,"C001", "Primary 4 English", "Enhance student's English language.", 2.30, 230.00, 30));
		
		for (Course course : courseList) {
			if (course.getCid() == "C001") {
				assertTrue("Test that course name of C001 has been changed.", course.getCname().equals("Primary 4 English"));
			}
		}
		// Test Case 2
		// Update course with a invalid course id
		TuitionManagement.updateCourse(accountList, courseList, 
				new Course(33333333,"C013", "Secondary 1 Science", "Enhance student's Science.", 3.30, 250.00, 20));

	    // Check that no course was updated
	    for (Course course : courseList) {
	        assertNotEquals("Test that course name is not updated", "Secondary 4 Science", course.getCname());
	    }
	}	

	
}
