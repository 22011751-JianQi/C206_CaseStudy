import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MaintainAdminTest 
{
	private Account admin3;
	private Account admin4;
	
	private Account teacher1;
	private Account teacher2;
	private Account teacher3;

	private ArrayList<Account> accountList;

	public MaintainAdminTest()
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
		TuitionManagement.addAdmin(accountList, admin4);
		TuitionManagement.deleteAdmin(accountList, 1234);
		assertEquals("Check that admin3 account is not deleted and arrayList size is 1", 1, accountList.size());
		
		//Test delete valid account that is not an administrator
		TuitionManagement.addTeacher(accountList, teacher3);
		TuitionManagement.deleteAdmin(accountList, teacher3.getUserID());
		assertEquals("Check that teacher3 is still in the list", teacher3.getUserID(), accountList.get(1).getUserID());
	}
	
	//JianQi
	@Test
	public void testViewAdministrator() 
	{
		// Test that output is empty when no administrator is added
		// testOutput will equals to allAdmin which is empty
		String allAdmin = TuitionManagement.retriveAllUsers(accountList);
		String testOutput = "";
		assertEquals("Test that the retrieved accountList is empty", testOutput, allAdmin);
		
		// Test that added account is displayed
		// testOutput will equals to all admin
		TuitionManagement.addAdmin(accountList, admin3);
		TuitionManagement.addAdmin(accountList, admin4);
		
		allAdmin = TuitionManagement.retriveAllUsers(accountList);
		testOutput = String.format("%-84s\n", accountList.get(0).toString());
		testOutput += String.format("%-84s\n", accountList.get(1).toString());
		
		assertEquals("Test that the retrieved accountList is not empty", testOutput, allAdmin);
		
		// Test that only administrator is displayed.
		//if teacher can be retrieve, allAdmin will be more than testOutput.
		TuitionManagement.addTeacher(accountList, teacher1);
		assertEquals("Test that the retrieved accountList is empty", testOutput, allAdmin);
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
			TuitionManagement.addTeacher(accountList, teacher2);
			Account update = new Account ("newteach", 44444444, "password3", "Teacher3@gmail.com", 14234567, "Teacher"); 
			TuitionManagement.updateAdmin(accountList, update);
			
			assertEquals("teacher1 name stays the same as Teacher1", teacher2.getName(), "Teacher2");
		
			// Test that administrator account cannot be updated if information does not meets a certain condition.
			// mobile number less than 8
			TuitionManagement.updateAdmin(accountList, new Account("newName2", 12097623, "newpassword2", "newEmail2@gmail.com", 123, "Admin"));
			assertEquals("Administrator account remains unchanged", admin3.getMobileNum(), 12345678);
	}
	
	
}
