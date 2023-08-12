import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MaintainStudentTest 
{

	private Account admin3;

	private Account student2;
	private Account student3;
	
	private Account teacher1;
	
	private ArrayList<Account> accountList;

	
	
	public MaintainStudentTest()
	{
		super();
	}
	
	@Before
	public void setUp() throws Exception 
	{
		admin3 = new Account("Admin3", 12097623, "password1", "Admin3@gmail.com", 12098765, "Admin");
	
		student2 = new Account("Student2", 12343567, "12345", "Student2@gmail.com", 14000000, "Student");
        student3 = new Account("Student3", 77777777, "12345", "Student3@gmail.com", 15000000, "Student");

        teacher1 = new Account("Teacher1", 33333333, "12345", "Teacher1@gmail.com", 11230000, "Teacher");
        
		accountList = new ArrayList<Account>();
	}
	
	@After
	public void tearDown() throws Exception 
	{
		admin3 = null;
		
		student2 = null;
		student3 = null;
		
		teacher1 = null;
		
		accountList = null;
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
   public void testDeleteStudent() 
   { //Saiful

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
       TuitionManagement.addAdmin(accountList, admin3);
       TuitionManagement.deleteStudent(accountList, admin3.getUserID());
       assertEquals("Check that student account is not deleted and arrayList size is 1", 2, accountList.size());

       //Check if all the students are deleted from the list
       TuitionManagement.deleteStudent(accountList, student3.getUserID());
       assertEquals("Check that all student accounts is deleted and arrayList size is 0", 1, accountList.size());


       // Display the contents of the account list
       System.out.println("The account list is:");
       for (Account account : accountList) 
       {
           System.out.println(account);
       }
   }
   
   @Test
   public void testUpdateStudent() { //Saiful



     // Add a student to the list
     accountList.add(student2);
     accountList.add(teacher1);
     accountList.add(student3);



     // Update the student account with the new name, password, and email address
     TuitionManagement.updateStudent(accountList, new Account("newStudent2", 12343567, "123456789", "newEmail@gmail.com", 22221111, "Student"));



     // Check if the student account has been updated
     for (Account account : accountList) {
       if (account.getUserID() == 12345678) {
         assertTrue("student account has been updated", account.getName().equals("newStudent2"));
       }
     }



     // Test that the student account cannot be updated because the user ID does not exist
     TuitionManagement.updateStudent(accountList, new Account("newStudent2", 98765432, "123456789", "newEmail@gmail.com", 22221111, "Student"));
     assertFalse("student account cannot be updated because the user ID does not exist", accountList.contains(new Account("newStudent2", 98765432, "123456789", "newEmail@gmail.com", 22221111, "Student")));



     // Test that the student account cannot be updated because the new name is too long
     TuitionManagement.updateStudent(accountList, new Account("this is a very long name that is more than 30 characters long",12343567, "123456789", "newEmail@gmail.com", 22221111, "Student"));
     assertFalse("student account cannot be updated because the new name is too long", accountList.contains(new Account("this is a very long name that is more than 30 characters long", 12345678, "123456789", "newEmail@gmail.com", 22221111, "Student")));



     // Test that the student account cannot be updated because the new password is too short
     TuitionManagement.updateStudent(accountList, new Account("newStudent2", 12343567, "new", "newEmail@gmail.com", 22221111, "Student"));
     assertFalse("student account cannot be updated because the new password is too short", accountList.contains(new Account("newName", 12343567, "new", "newEmail@gmail.com", 22221111, "Student")));



     // Test that the student account cannot be updated because the new email address is invalid
     TuitionManagement.updateStudent(accountList, new Account("newStudent2", 12343567, "123456789", "invalidEmailAddress", 22221111, "Student"));
     assertFalse("student account cannot be updated because the new email address is invalid", accountList.contains(new Account("newStudent2", 12343567, "123456789", "invalidEmailAddress", 22221111, "Student")));



     // Test that the student account is updated with the minimum length name
     TuitionManagement.updateStudent(accountList, new Account("a", 12343567, "123456789", "newEmail@gmail.com", 22221111, "Student"));
     for (Account account : accountList) {
       if (account.getUserID() == 12345678) {
         assertTrue("student account has been updated with the minimum length name", account.getName().equals("a"));
       }
     }



     // Test that the student account is updated with the minimum length password
     TuitionManagement.updateStudent(accountList, new Account("newStudent2", 12343567, "123", "newEmail@gmail.com", 22221111, "Student"));

     System.out.println("The account list is:");
       for (Account account : accountList) 
       {
           System.out.println(account);
       }
   }
}

