import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MaintainFeesTest 
{
	private ArrayList<FeeDetails> feeList;
	
	private FeeDetails fd1;
	private FeeDetails fd2;
	private FeeDetails fd3;
	private FeeDetails fd4;
	private FeeDetails fd5;
	private FeeDetails fd6;
	
	
	public MaintainFeesTest()
	{
		super();
	}
	
	@Before
	public void setUp() throws Exception 
	{
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
		fd1=null;
		fd2=null;
		fd3=null;
		fd4=null;
		fd5=null;
		feeList=null;
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

	

}
