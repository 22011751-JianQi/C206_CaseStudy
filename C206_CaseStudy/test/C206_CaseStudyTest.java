import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest 
{
	private Account admin3;
	private Account admin4;
	
	private Account teacher3;

	private ArrayList<Account> accountList;
	
	
	public C206_CaseStudyTest()
	{
		super();
	}
	
	@Before
	public void setUp() throws Exception 
	{
		admin3 = new Account("Admin3", 12097623, "password1", "Admin3@gmail.com", 12098765, "Admin");
		admin4 = new Account("Admin4", 13987654, "password2", "Admin4@gmail.com", 12340000, "Admin");
		
		teacher3 = new Account("Teacher3", 23456432, "password3", "Teacher3@gmail.com", 14234567, "Teacher");
	
		accountList = new ArrayList<Account>();
	}

	@After
	public void tearDown() throws Exception 
	{
		admin3 = null;
		admin4 = null;
		
		teacher3 = null;
		
		accountList = null;
	}

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
		
		//Test delete with empty field
		
		
	}
	
	@Test
	public void testViewAdministrator() 
	{
		// Test that output is empty when no administrator is added
		String allAdmin = TuitionManagement.retriveAllUsers(accountList);
		String testOutput = "";
		assertEquals("Test that the retrieved accountList is empty?", testOutput, allAdmin);
		
	}
	
	

}
