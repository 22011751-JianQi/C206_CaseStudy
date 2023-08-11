import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest 
{
	private Account admin3;
	private Account admin4;
	
	private Account teacher1;
	private Account teacher2;
	private Account teacher3;

	private Account student2;
	private Account student3;
	
	private Course course1;
	private Course course2;
	
	private ArrayList<Account> accountList;
	private ArrayList<Course> courseList;
	private ArrayList<FeeDetails> feeList;
	
	private FeeDetails fd1;
	private FeeDetails fd2;
	private FeeDetails fd3;
	private FeeDetails fd4;
	private FeeDetails fd5;
	private FeeDetails fd6;
	
	public C206_CaseStudyTest()
	{
		super();
	}
	
	@Before
	public void setUp() throws Exception 
	{
		admin3 = new Account("Admin3", 12097623, "password1", "Admin3@gmail.com", 12098765, "Admin");
		admin4 = new Account("Admin4", 13987654, "password2", "Admin4@gmail.com", 12340000, "Admin");
		
		teacher1 = new Account("Teacher1", 33333333, "12345", "Teacher1@gmail.com", 11230000, "Teacher");
		teacher2 = new Account("Teacher2", 44444444, "12345", "Teacher2@gmail.com", 14200000, "Teacher");
		teacher3 = new Account("Teacher3", 23456432, "password3", "Teacher3@gmail.com", 14234567, "Teacher");
	
		student2 = new Account("Student2", 12343567, "12345", "Student2@gmail.com", 14000000, "Student");
        student3 = new Account("Student3", 77777777, "12345", "Student3@gmail.com", 15000000, "Student");
		
        course1 = new Course(33333333,"C001", "Secondary 2 English", "Enhance student's English language.", 2.30, 230.00, 30);
		course2 = new Course(44444444, "C002", "Secondary 4 Geography", "Enhance student's Geography.", 4.0, 260.00, 20);
        
		courseList = new ArrayList<Course>();
		accountList = new ArrayList<Account>();
		feeList = new ArrayList<FeeDetails>();
		
		fd1 = new FeeDetails(22010079,"Tuition",2000,"14/2/2023","Pending");
		fd2 = new FeeDetails(22010079,"Exam",200,"25/1/2023", "Pending");
		fd3 = new FeeDetails(22010079,"Others",300,"23/2/2023","Paid");
		fd4 = new FeeDetails(22000079,"Exam",300,"14/2/2022","Pending");
		fd5 = new FeeDetails(12345678,"Others",400,"25/2/2002","Paid");
		fd6 = new FeeDetails(12345678,"",2000.00,"14/2/2023","Pending");
		
		
	}

	@After
	public void tearDown() throws Exception 
	{
		admin3 = null;
		admin4 = null;
		
		teacher1 = null;
		teacher2 = null;
		teacher3 = null;
		
		course1 = null;
		course2 = null;
		
		accountList = null;
		courseList = null;
		
		fd1=null;
		fd2=null;
		fd3=null;
		fd4=null;
		fd5=null;
		feeList=null;
	}
	
	//JianQi
	@Test
	public void testAddAdministrator() 
	{
		//Test add new valid Administrator account
		TuitionManagement.addAdmin(accountList, admin3);
		assertEquals("Check that Account arrayList size is 1", 1, accountList.size());
		assertSame("Check that Admin account is added", admin3, accountList.get(0));
		
		
		//Test add duplicate Administrator account
		Account duplicateAdmin = new Account("Admin3", 12097623, "password1", "Admin3@gmail.com", 12098765, "Admin");
		TuitionManagement.addAdmin(accountList, duplicateAdmin);
		assertEquals("Check that duplciate admin account is not added", 1, accountList.size());
		
		//Test invalid accounts
		Account invalidAccount = new Account("Admin5", 120, "password1", "Admin5@gmail.com", 13456789, "Admin");
		TuitionManagement.addAdmin(accountList, invalidAccount);
		assertEquals("Check that invalid admin account is not added", 1, accountList.size());
	}
	
	//JianQi
	@Test
	public void testDeleteAdministrator() 
	{
		//Test delete valid account
		TuitionManagement.addAdmin(accountList, admin4);
		TuitionManagement.deleteAdmin(accountList, admin4.getUserID());
		assertEquals("Check that Account arrayList size is 0", 0, accountList.size());
		
		//Test delete invalid account user id
		TuitionManagement.addTeacher(accountList, teacher3);
		TuitionManagement.deleteAdmin(accountList, teacher3.getUserID());
		assertEquals("Check that teacher account is not deleted and arrayList size is 1", 1, accountList.size());
		
		//Test delete valid account that is not an administrator
		TuitionManagement.addTeacher(accountList, teacher3);
		TuitionManagement.deleteAdmin(accountList, teacher3.getUserID());
		assertEquals("Check that teacher3 is still in the list", teacher3.getUserID(), accountList.get(0).getUserID());
		
	}
	
	//JianQi
	@Test
	public void testViewAdministrator() 
	{
		// Test that output is empty when no administrator is added
		String allAdmin = TuitionManagement.retriveAllUsers(accountList);
		String testOutput = "";
		assertEquals("Test that the retrieved accountList is empty?", testOutput, allAdmin);
		
		// Test that added account is displayed
		TuitionManagement.addAdmin(accountList, admin3);
		TuitionManagement.addAdmin(accountList, admin4);
		
		allAdmin = TuitionManagement.retriveAllUsers(accountList);
		testOutput = String.format("%-84s\n", accountList.get(0).toString());
		testOutput += String.format("%-84s\n", accountList.get(1).toString());
		
		assertEquals("Test that the retrieved accountList is empty?", testOutput, allAdmin);
		
		// Test that only administrator is displayed
		TuitionManagement.addTeacher(accountList, teacher3);
		assertEquals("Test that the retrieved accountList is empty?", testOutput, allAdmin);
	}
	
	//JianQi
	@Test
	public void testUpdateAdministrator() 
	{
			//Test that only administrator account is updated.
			TuitionManagement.addAdmin(accountList, admin3);
			TuitionManagement.updateAdmin(accountList, new Account("newName", 12097623, "newpassword", "newEmail@gmail.com", 12345678, "Admin"));
			
			for(int i = 0; i < accountList.size(); i++)
			{
				if(accountList.get(i).getUserID() == 12097623 && accountList.get(i).getRole().equalsIgnoreCase("Admin"))
				{
					assertTrue("only administrator account admin3 has been udpated", admin3.getName().equals("newName"));
				}
			}
		
			//Test that the update function will not update an account that does not belong to admin
			TuitionManagement.addTeacher(accountList, teacher1);
			Account update = new Account ("newteach", 33333333, "password3", "Teacher3@gmail.com", 14234567, "Teacher"); 
			TuitionManagement.updateAdmin(accountList, update);
			
			assertEquals("teacher1 name stays the same as Teacher1", teacher1.getName(), "Teacher1");
		
			// Test that administrator account cannot be updated if information does not meets a certain condition.
			// mobile number less than 8
			TuitionManagement.updateAdmin(accountList, new Account("newName2", 12097623, "newpassword2", "newEmail2@gmail.com", 123, "Admin"));
			assertEquals("Administrator account remains unchanged", admin3.getMobileNum(), 12345678);
	}
	
	   @Test
	    public void testAddStudent() //Saiful
	    {
	    	// accountlist is not null, so that can add a new item - boundary
	        assertNotNull("Check if there is valid Student arraylist to add to", accountList);
//	        Given an empty list, after adding 1 item, the size of the list is 1 - normal
//	        The Student just added is as same as the first user, of the list
	        TuitionManagement.addStudent(accountList, student2);
	        assertEquals("Check that Student arraylist size is 1", 1, accountList.size());
	        assertSame("Check that student is added", student2, accountList.get(0));

	        
	        //Add another student. test The size of the list is 2? -normal
	        //The item just added is as same as the second item of the list
	        TuitionManagement.addStudent(accountList, student3);
	        assertEquals("Check that student arraylist size is 2", 2, accountList.size());
	        assertSame("Check that student is added", student3, accountList.get(1));

	        //Testing for duplicate student
	        Account duplicateStudent = new Account("Student2", 22222222, "12345", "Student2@gmail.com", 22000000, "Student");
	        TuitionManagement.addStudent(accountList, duplicateStudent);
	        assertEquals("Check that the duplicate student is not added", 2, accountList.size());
	      
	        System.out.println("The account list is:");
	        for (Account account : accountList) {
	            System.out.println(account);
	        }

	    }
	    
	   @Test
	    public void testViewStudent() { //Saiful
	    	// Create an empty AccountList object.

//	    	
			// Test that output is empty when no student is added
			String allStudent = TuitionManagement.retriveAllStudents(accountList);
			String testOutput = "";
			assertEquals("Test that the retrieved accountList is empty?", testOutput, allStudent);

			// Test that added account is displayed
			TuitionManagement.addStudent(accountList, student2);
			TuitionManagement.addStudent(accountList, student3);

			allStudent = TuitionManagement.retriveAllStudents(accountList);
			testOutput = String.format("%-84s\n", accountList.get(0).toString());
			testOutput += String.format("%-84s\n", accountList.get(1).toString());

			assertEquals("Test that the retrieved accountList is empty?", testOutput, allStudent);
//			
			// Test only the students in the list can only be displayed
			TuitionManagement.addAdmin(accountList, admin3);
			assertEquals("Test that the retrieved accountList is empty?", testOutput, allStudent);



//			
//	        System.out.println("The account list is:");
//	        for (Account account : accountList) {
//	            System.out.println(account);
//	        }
	    }
	    
	    @Test
	    public void testDeleteStudent() { //Saiful
	    	
	    	// Check if there are two students in the account list
	        assertEquals("Check that there are two students in the account list", 0, accountList.size());

	        // Delete the first student from the account list
	    	TuitionManagement.addStudent(accountList, student2);
	        TuitionManagement.addStudent(accountList, student3);
	        TuitionManagement.deleteStudent(accountList, 12343567);

	        // Check if the first student has been deleted
	        assertEquals("Check that the first student has been deleted", 1, accountList.size());
	        //assertFalse("Check that the first student is not in the account list", accountList.contains(student2));

	        // Check if the second student is still in the account list
	        assertTrue("Check that the second student is still in the account list", accountList.contains(student3));

	        // Check if you can't delete the student with a invalid ID
	        assertFalse("Check that the student ID is invalid and cannot be deleted", accountList.equals(student3));
	        
	        // Display the contents of the account list
	        System.out.println("The account list is:");
	        for (Account account : accountList) {
	            System.out.println(account);
	        }
	    }
	
	//Adrian
	@Test
	public void testRetrieveFeesCollection() {
		        //Test Case 1
				//Test if Fee List is not null and empty
				assertNotNull("Test if there is a valid FeeDetails arraylist to add to",feeList);
				assertEquals("Test that the FeeDetails arraylist is empty.", 0, feeList.size());
				//Retrieve all fees
				String allFee = TuitionManagement.retrieveFeesCollection(feeList);
				String testoutput = "";
				//Test if the output is empty
				assertEquals("Test that nothing is displayed",testoutput,allFee);
				
				//Test Case 2
				//Test that the Added fee is displayed
				TuitionManagement.createFee(feeList, fd1);
				TuitionManagement.createFee(feeList, fd2);
				TuitionManagement.createFee(feeList, fd4);
				//Test if the list is not empty
				assertEquals("Test that the FeeDetails arraylist size is 3.",3,feeList.size());
				//Attempt to retrieve all fees
				allFee = TuitionManagement.retrieveFeesCollection(feeList);
				testoutput = String.format("%-15d %-69s\n", fd1.getUserID(), fd1.feeString());
				testoutput += String.format("%-15d %-69s\n", fd2.getUserID(), fd2.feeString());
				testoutput += String.format("%-15d %-69s\n", fd4.getUserID(), fd4.feeString());
				
				//Test that the details are displayed correctly
				assertEquals("Test that the display is correct",testoutput,allFee);
				
				//Test Case 3 
				//Test that the fee with paid payment status is added into the arraylist
				TuitionManagement.createFee(feeList, fd3);
				TuitionManagement.createFee(feeList, fd5);
				//Test if the list is not empty
				assertEquals("Test that the FeeDetails arraylist size is .",5,feeList.size());
				//Attempt to retrieve all fees
				allFee = TuitionManagement.retrieveFeesCollection(feeList);
				testoutput = String.format("%-15d %-69s\n", fd1.getUserID(), fd1.feeString());
				testoutput += String.format("%-15d %-69s\n", fd2.getUserID(), fd2.feeString());
				testoutput += String.format("%-15d %-69s\n", fd4.getUserID(), fd4.feeString());
				//Test that the details are displayed correctly
				assertEquals("Test that the display is correct",testoutput,allFee);
				
	}
	
	//Adrian
	@Test
	public void testRetrieveAllFees() {
		//Test Case 1
		//Test if Fee List is not null and empty
		assertNotNull("Test if there is a valid FeeDetails arraylist to add to",feeList);
		assertEquals("Test that the FeeDetails arraylist is empty.", 0, feeList.size());
		//Retrieve all fees
		String allFee = TuitionManagement.retrieveAllFees(feeList);
		String testoutput = "";
		//Test if the output is empty
		assertEquals("Test that nothing is displayed",testoutput,allFee);
		
		//Test Case 2
		//Test that the Added fee is displayed
		TuitionManagement.createFee(feeList, fd1);
		TuitionManagement.createFee(feeList, fd2);
		TuitionManagement.createFee(feeList, fd3);
		TuitionManagement.createFee(feeList, fd4);
		TuitionManagement.createFee(feeList, fd5);
		//Test if the list is not empty
		assertEquals("Test that the FeeDetails arraylist size is 5.",5,feeList.size());
		//Attempt to retrieve all fees
		allFee = TuitionManagement.retrieveAllFees(feeList);
		testoutput = String.format("%-15d %-69s\n", fd1.getUserID(), fd1.feeString());
		testoutput += String.format("%-15d %-69s\n", fd2.getUserID(), fd2.feeString());
		testoutput += String.format("%-15d %-69s\n", fd3.getUserID(), fd3.feeString());
		testoutput += String.format("%-15d %-69s\n", fd4.getUserID(), fd4.feeString());
		testoutput += String.format("%-15d %-69s\n", fd5.getUserID(), fd5.feeString());
		
		//Test that the details are displayed correctly
		assertEquals("Test that the display is correct",testoutput,allFee);
		
		//Test Case 3 
		//Test that the fee with a field left blank is not shown
		TuitionManagement.createFee(feeList, fd6);
		//Test if the list is not empty
		assertEquals("Test that the FeeDetails arraylist size is 5.",5,feeList.size());
		//Attempt to retrieve all fees
		allFee = TuitionManagement.retrieveAllFees(feeList);
		testoutput = String.format("%-15d %-69s\n", fd1.getUserID(), fd1.feeString());
		testoutput += String.format("%-15d %-69s\n", fd2.getUserID(), fd2.feeString());
		testoutput += String.format("%-15d %-69s\n", fd3.getUserID(), fd3.feeString());
		testoutput += String.format("%-15d %-69s\n", fd4.getUserID(), fd4.feeString());
		testoutput += String.format("%-15d %-69s\n", fd5.getUserID(), fd5.feeString());
		//Test that the details are displayed correctly
		assertEquals("Test that the display is correct",testoutput,allFee);
		
	}
	
	//Adrian
	@Test
	public void testcreateFee() {
		//Test Case 1
		//Test if Fee List is not null and empty
		assertNotNull("Test if there is a valid FeeDetails arraylist to add to",feeList);
		assertEquals("Test that the FeeDetails arraylist is empty.", 0, feeList.size());
		//Given an empty list, after adding 1 item, the size of the list is 1
		TuitionManagement.createFee(feeList, fd1);	
		assertEquals("Test that the FeeDetails arraylist size is 1.", 1, feeList.size());
		
		//Add an feeDetails
		TuitionManagement.createFee(feeList, fd2);	
		assertEquals("Test that the FeeDetails arraylist size is now 2.", 2, feeList.size());
		//The fee just added is as same as the last fee in the list
		assertEquals("Test that the fee is added to the end of the list.",fd2,feeList.get(1));
		
		//Add an fee that already exists in the list
		TuitionManagement.createFee(feeList, fd2);
		assertEquals("Test that the FeeDetails arraylist size is unchanged.", 2, feeList.size());
		
		//Add an item that has missing detail
		FeeDetails fd_missing = new FeeDetails(12345678,"",2000.00,"14/2/2023","Pending");
		TuitionManagement.createFee(feeList, fd_missing);
		assertEquals("Test that the FeeDetails arraylist size is unchanged.", 2, feeList.size());
	}
	
	
	//Adrian
	@Test
	public void testUpdateFee() {
		//Test Case 1
		//Update Fee
		assertNotNull("Test if there is a valid FeeDetails arraylist to add to",feeList);
		TuitionManagement.createFee(feeList, fd1);
		Boolean ok = TuitionManagement.doUpdateFees(feeList,22010079,"Tuition",2000,"14/2/2023","Pending");
		assertTrue("Test if the Fee Status is now Updated",ok);
		
		//Test Case 2
		//Update Fee with missing details
		ok = TuitionManagement.doUpdateFees(feeList,22010079,"",2000,"14/2/2023","Pending");
		assertFalse("Test that the return fails.", ok);
		
		//Test Case 3
		//Update Fee with non-existing details
		ok = TuitionManagement.doUpdateFees(feeList,11111111,"",2000,"14/2/2023","Pending");
		assertFalse("Test the return of 11111111 fails", ok);
	}
	
	//Adrian
	@Test
	public void testdeleteFee() {
		//Test Case 1
		//Test if Fee List is not null and not empty
		TuitionManagement.createFee(feeList, fd1);	
		assertNotNull("Test if there is a valid FeeDetails arraylist to add to",feeList);
		assertEquals("Test that the FeeDetails arraylist is 1.", 1, feeList.size());
		//Given an list, after deleting 1 item, the size of the list is 0
		TuitionManagement.doDeleteFee(feeList,fd1);
		assertEquals("Test that the FeeDetails arraylist is empty.", 0, feeList.size());
		
		//Test Case 2 
		//Deleting item that is not in the list
		TuitionManagement.createFee(feeList, fd1);
		TuitionManagement.doDeleteFee(feeList, fd2);
		//Given an list, after deleting 1 item, the size of the list is 1
		assertNotNull("Test if there is a valid FeeDetails arraylist to add to",feeList);
		assertEquals("Test that the FeeDetails arraylist is 1.", 1, feeList.size());
		
		//Test Case 3
		//Delete item with missing details
		FeeDetails fd_missing = new FeeDetails(12345678,"",2000.00,"14/2/2023","Pending");
		TuitionManagement.doDeleteFee(feeList, fd_missing);
		//Given an list, after deleting 1 item, the size of the list is 1
		assertNotNull("Test if there is a valid FeeDetails arraylist to add to",feeList);
		assertEquals("Test that the FeeDetails arraylist is 1.", 1, feeList.size());
				
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
