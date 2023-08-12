import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MaintainTeacherTest 
{
	private Account admin3;
	private Account admin4;
	
	private Account teacher1;
	private Account teacher2;
	private Account teacher3;

	private ArrayList<Account> accountList;

	public MaintainTeacherTest()
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
	
		accountList = new ArrayList<Account>();
	}

	@After
	public void tearDown() throws Exception 
	{
		admin3 = null;
		admin4 = null;
		
		teacher1 = null;
		teacher2 = null;
		teacher3 = null;
	
		accountList = null;
	}

	//JianQi
	@Test
	public void testAddTeacher() 
	{
		//Test add new valid Teacher account
		TuitionManagement.addTeacher(accountList, teacher1);
		TuitionManagement.addTeacher(accountList, teacher2);
		
		assertEquals("Check that Account arrayList size is 2", 2, accountList.size());
		assertSame("Check that teacher account is added", teacher1, accountList.get(0));
		
		
		//Test add duplicate Teacher account
		Account duplicateTeacher = new Account("Teacher2", 44444444, "12345", "Teacher2@gmail.com", 14200000, "Teacher");
		TuitionManagement.addTeacher(accountList, duplicateTeacher);
		assertEquals("Check that duplciate teacher account is not added", 2, accountList.size());
		
		//Test invalid accounts (E.g. invalid email)
		Account invalidAccount = new Account("Teacher4", 66666666, "password1", "Admin5", 13456789, "Admin");
		TuitionManagement.addTeacher(accountList, invalidAccount);
		assertEquals("Check that invalid teacher account is not added", 2, accountList.size());
	}
	
	//JianQi
	@Test
	public void testDeleteTeacher() 
	{
		//Test delete valid account
		TuitionManagement.addTeacher(accountList, teacher1);
		TuitionManagement.deleteTeacher(accountList, teacher1.getUserID());
		assertEquals("Check that Account arrayList size is 0", 0, accountList.size());
		
		//Test delete invalid account user id
		TuitionManagement.addTeacher(accountList, teacher1);
		TuitionManagement.deleteTeacher(accountList, 12342314);
		assertEquals("Check that teacher account is not deleted and arrayList size is 1", 1, accountList.size());
		
		//Test delete valid account that is not an teacher
		TuitionManagement.addAdmin(accountList, admin3);
		TuitionManagement.deleteTeacher(accountList, admin3.getUserID());
		assertEquals("Check that admin3 is still in the list", admin3.getUserID(), accountList.get(1).getUserID());
	}
	
	//JianQi
	@Test
	public void testViewTeacher() 
	{
		// Test that output is empty when no administrator is added
		String allTeacher = TuitionManagement.retriveAllTeachers(accountList);
		String testOutput = "";
		assertEquals("Test that the retrieved accountList is empty?", testOutput, allTeacher);
		
		
		// Test that added account is displayed
		TuitionManagement.addTeacher(accountList, teacher3);
		TuitionManagement.addTeacher(accountList, teacher1);
		
		allTeacher = TuitionManagement.retriveAllTeachers(accountList);
		String expectedOutput = String.format("%-84s\n", teacher3); 
		expectedOutput += String.format("%-84s\n", teacher1);
			
		assertEquals("Test that the retrieved teacher account is displayed correctly", expectedOutput, allTeacher);
		
		
		// Test that only teacher is displayed (E.g. add admin account)
		TuitionManagement.addAdmin(accountList, admin3);
		
		allTeacher = TuitionManagement.retriveAllTeachers(accountList);
		expectedOutput = String.format("%-84s\n", teacher3); 
		expectedOutput += String.format("%-84s\n", teacher1);
		
		assertEquals("Test that only teacher account is retrived", expectedOutput, allTeacher);
	}
	
	//JianQi
	@Test
	public void testUpdateTeacher() 
	{
			//Test that only teacher account is updated.
			TuitionManagement.addTeacher(accountList, teacher1);
			TuitionManagement.updateTeacher(accountList, new Account("newTeach", 33333333, "12345", "newTeacher@gmail.com", 11432567, "Teacher"));
			
			for(int i = 0; i < accountList.size(); i++)
			{
				if(accountList.get(i).getUserID() == 33333333 && accountList.get(i).getRole().equalsIgnoreCase("Teacher"))
				{
					assertTrue("only teacher account teacher1 has been udpated", teacher1.getName().equals("newTeach"));
				}
			}
		
			//Test that the update function will not update an account that does not belong to teacher
			TuitionManagement.addAdmin(accountList, admin4);
			Account update = new Account ("newName", 13987654, "password2", "Admin4@gmail.com", 12340000, "Admin"); 
			TuitionManagement.updateTeacher(accountList, update);
			
			assertEquals("admin4 name stays the same as Admin4", admin4.getName(), "Admin4");
		
			// Test that administrator account cannot be updated if information does not meets a certain condition.
			// E.g. name more than 45 characters
			TuitionManagement.addTeacher(accountList,teacher3);
			TuitionManagement.updateTeacher(accountList, new Account("1234567890mdasdasdasdasdasdasdasdasdasdasdkasndkasndkasndaskd", 
					23456432, "password3", "Teacher3@gmail.com", 14234567, "Teacher"));
			
			assertEquals("Teacher account remains unchanged", teacher3.getName(), "Teacher3");
	}
	
	
	
}
