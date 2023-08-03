import java.util.ArrayList;

public class TuitionManagement 
{
	//========System login menu options========
	private static final int Login_Option_Quit = 4;
	private static final int Login_Option_Admin = 1;
	private static final int Login_Option_Teach = 2;
	private static final int Login_Option_Stud = 3;
	
	//========Administrator menu options(Incomplete)========
	private static final int Admin_Option_Quit = 10;
	private static final int Maintain_Admin_Option = 1;
	private static final int Maintain_Teach_Option = 2;
	private static final int Maintain_Stud_Option = 3;
	
	//========Maintain menu options========
	private static final int Quit = 4;
	private static final int Add = 1;
	private static final int Update = 2;
	private static final int Delete = 3;

	public static void main(String[] args) 
	{
		ArrayList<Account> accountList = new ArrayList<Account>();
		
		accountList.add(new Account("Admin1", 11111111, "12345", "Admin1@gmail.com", 11000000, "Admin"));
		accountList.add(new Account("Teacher1", 33333333, "12345", "Teacher1@gmail.com", 12000000, "Teacher"));
		accountList.add(new Account("Student1", 55555555, "12345", "Student1@gmail.com", 13000000, "Student"));
		
		int loginOption = 0;
		
		// Login Menu
		while (loginOption != 4)
		{
			loginMenu();
			loginOption = Helper.readInt("Enter an option > ");
			
			// Administrator Login 
			if (loginOption == 1)
			{
				// Validate administrator credentials
				Account adminLoginAcct = validateAdmin(accountList);
				
				if(adminLoginAcct != null)
				{
					int adminOption = 0;
					
					//Administrator menu
					while (adminOption != 10)
					{
						adminMenu();
						adminOption = Helper.readInt("Enter an option > ");
						
						// Add new Administrator
						if (adminOption == 1)
						{
							//Maintain administrator account
							TuitionManagement.viewAdminAcc(accountList);
							
							int maintainOption = 0;
							
							while (maintainOption != Quit)
							{
								TuitionManagement.maintainMenu();
								maintainOption = Helper.readInt("Enter an Option > ");
									
								// Add administrator account
								if (maintainOption == Add)
								{
									Account acc = TuitionManagement.inputAccount();
									TuitionManagement.addAdmin(accountList, acc);
									TuitionManagement.viewAdminAcc(accountList);
								}
								
								// Update administrator account
								else if(maintainOption == Update)
								{
									TuitionManagement.updateAdmin(accountList);
									TuitionManagement.viewAdminAcc(accountList);
								}
								
								// Delete administrator account
								else if(maintainOption == Delete)
								{
									TuitionManagement.deleteAdmin(accountList);
									TuitionManagement.viewAdminAcc(accountList);
								}
								
								// Return to administrator menu
								else if (maintainOption == Quit)
								{
									System.out.println("\nReturn to menu\n");
								}
								
								else
								{
									System.out.println("\nInvalid Input!\n");
								}
									
							}
							
						}
						
						else if (adminOption == 2)
						{
							//Maintain teacher account
							//TuitionManagement.viewTeachAcc(accountList);
							
							int maintainOption = 0;
							
							while (maintainOption != Quit)
							{
								TuitionManagement.maintainMenu();
								maintainOption = Helper.readInt("Enter an Option > ");
								
								// Add teacher account
								if (maintainOption == Add)
								{
									Account acc = TuitionManagement.inputAccount();
									
								}
								
								else if(maintainOption == Update)
								{
						
								}
								
								else if(maintainOption == Delete)
								{
					
								}
								
								// Return to administrator menu
								else if (maintainOption == Quit)
								{
									System.out.println("\nReturn to menu\n");
								}
								
								else
								{
									System.out.println("\nInvalid Input!\n");
								}
							}
						}
						
						else if (adminOption == 3)
						{
							
						}
						
						else if (adminOption == 4)
						{
							
						}
						
						else if(adminOption == 7)
						{
							
						}
						
						else if(adminOption == 8)
						{
							
						}
						
						else if(adminOption == 9)
						{
							
						}
						
						else if (adminOption == 10)
						{System.out.println("\nReturn to login\n");}
						else
						{System.out.println("\nInvalid option!\n");}
					}
				}
			}
			
			// Teacher login 
			else if(loginOption == 2)
			{
				// Validate teacher credentials
				Account teachLoginAcct = validateTeacher(accountList);
				
				if (teachLoginAcct != null)
				{
					int teachOption = 0;
					
					//Teacher menu
					while (teachOption != 3)
					{
						teacherMenu();
						teachOption = Helper.readInt("Enter an option > ");
						
						if (teachOption == 1)
						{
							
						}
						
						else if (teachOption == 2)
						{
							
						}
						
						else if (teachOption == 3)
						{System.out.println("\nReturn to login\n");}
						else
						{System.out.println("\nInvalid option!\n");}
					}
				}
			}
			
			// Student login
			else if(loginOption == 3)
			{
				// Validate student credentials
				Account studLoginAcct = validateStudent(accountList);
				
				if (studLoginAcct != null)
				{
					int studOption = 0;
					
					//Administrator menu
					while (studOption != 2)
					{
						studentMenu();
						studOption = Helper.readInt("Enter an option > ");
						
						if (studOption == 1)
						{
							
						}
						
						else if (studOption == 2)
						{System.out.println("\nReturn to login\n");}
						else
						{System.out.println("\nInvalid option!\n");}
					}
				}
			}
			
			else if (loginOption == 4)
			{System.out.println("\nSee you again\n");}
			else
			{System.out.println("\nInvalid option!\n");}
			}
	}
	
	public static void setHeader(String header) 
	{
		Helper.line(80, "=");
		System.out.println(header);
		Helper.line(80, "=");
	}
	
	//========Login Menu========
	public static void loginMenu()
	{
		TuitionManagement.setHeader("System Login");
		System.out.println("1. Administrator");
		System.out.println("2. Teacher");
		System.out.println("3. Student");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}
	
	//========Administrator Menu========
	public static void adminMenu()
	{
		TuitionManagement.setHeader("Administrator Menu");
		System.out.println("1. Maintain admin account");
		System.out.println("2. Maintain teacher account");
		System.out.println("3. Maintain student account");
		System.out.println("4. Manage studet fees");
		System.out.println("5. Maintain courses");
		System.out.println("6. View enrolment statistics");
		System.out.println("7. View fees collection");
		System.out.println("8. View student performance");
		System.out.println("9. View financial statistics");
		System.out.println("10. Return");
		Helper.line(80, "-");
	}

	//========Teacher Menu========
	public static void teacherMenu()
	{
		TuitionManagement.setHeader("Teacher Menu");
		System.out.println("1. View personal information");
		System.out.println("2. View assigned course");
		System.out.println("3. Return");
		Helper.line(80, "-");
	}
	
	//========Student Menu========
	public static void studentMenu()
	{
		TuitionManagement.setHeader("Student Menu");
		System.out.println("1. View personal information");
		System.out.println("2. Return");
		Helper.line(80, "-");
	}
	
	//========Administrator login validation========
	private static Account validateAdmin(ArrayList<Account> accountList)
	{

		int inputUserID = Helper.readInt("Enter Admin user ID > ");
		String inputPassword = Helper.readString("Enter Admin password > ");
			
		for (Account acc : accountList)
		{
			if(acc.getRole().equalsIgnoreCase("Admin")      
					&& acc.validateAcc(inputUserID, inputPassword))
			{
					// Store administrator account
					System.out.println("\nLogin successful.\n");
					return acc;
			}
		}
		
		System.out.println("\nIncorrect user ID or password\n");
		return null;
	}
	
	//========Teacher login validation========
	private static Account validateTeacher(ArrayList<Account> accountList)
		{
			int inputUserID = Helper.readInt("Enter Teacher user ID > ");
			String inputPassword = Helper.readString("Enter Teacher password > ");
				
			for (Account acc : accountList)
			{
				if(acc.getRole().equalsIgnoreCase("Teacher")      
						&& acc.validateAcc(inputUserID, inputPassword))
				{
						// Store teacher account
						System.out.println("\nLogin successful.\n");
						return acc;
				}
			}
			
			System.out.println("\nIncorrect user ID or password\n");
			return null;
		}
	
	//========Student login validation========
	private static Account validateStudent(ArrayList<Account> accountList)
		{
			int inputUserID = Helper.readInt("Enter Student user ID > ");
			String inputPassword = Helper.readString("Enter Student password > ");
				
			for (Account acc : accountList)
			{
				if(acc.validateAcc(inputUserID, inputPassword))
				{
					// Store student account
					System.out.println("\nLogin successful.\n");
					return acc;
				}
			}

			System.out.println("Incorrect user ID or password\n");
			return null;
		}
	
	
	
	//========Administrator functions========
	
	
	
	//========Maintain menu========
	public static void maintainMenu()
	{
		TuitionManagement.setHeader("Maintain options");
		System.out.println("1. Add account");
		System.out.println("2. Update account");
		System.out.println("3. Delete account");
		System.out.println("4. Return to menu");
		Helper.line(80, "-");
	}

	//========Maintain account input========
	public static Account inputAccount()
	{
		String name = Helper.readString("Enter account name > ");
		int userID = Helper.readInt("Enter account user id > ");
		String email = Helper.readString("Enter account email > ");
		int mobileNum = Helper.readInt("Enter account mobile number > ");
		String password = Helper.readString("Enter account password > ");
		
		Account acc = new Account(name, userID, password, email, mobileNum, "");
		return acc;
	}
	
	
	//========Administrator option 1: Maintain user account (View)========
	private static String retriveAllUsers(ArrayList<Account> accountList)
	{
		String output = "";
		
		for (int i = 0; i < accountList.size(); i++) 
		{
			if((accountList.get(i).getRole()).equalsIgnoreCase("Admin") )
			{
				String accInfo = accountList.get(i).toString();
				
				output += String.format("%-84s\n", accInfo);
			}
		}
		return output;		
	}
	
	private static void viewAdminAcc(ArrayList<Account> accountList)
	{
		TuitionManagement.setHeader("Administrator accounts");
		
		String output = String.format("%s %s %s %s %s\n", "Name", "User ID", "Email", "Mobile Num", "Password");
		
		output += retriveAllUsers(accountList);
		System.out.println(output);
	}
	
	//======== Administrator option 1: Maintain user account(Add)========
	public static void addAdmin(ArrayList<Account> accountList, Account acc)
	{
		Account account;
		boolean duplicate = false;
		boolean empty = false;
		
		
		// Check for empty fields
		if((acc.getName()).isEmpty() 
				|| acc.getUserID() <= 0 
				|| (acc.getEmail()).isEmpty() 
				|| acc.getMobileNum() <= 0 
				|| (acc.getPassword()).isEmpty() )
		{
			empty = true;
		}
		
		
		else
		{
			for(int i = 0; i < accountList.size(); i ++)
			{
				account = accountList.get(i);
					
				if(account.getUserID() == acc.getUserID() 
						|| (account.getEmail()).equalsIgnoreCase(acc.getEmail()) 
						|| account.getMobileNum() == acc.getMobileNum())
				{
					duplicate = true;
					break;
				}
			}
		}
		
		
		
		if(empty == true)
		{
			System.out.println("\nPlease fill in all account details.\n");
		}
		else if(duplicate == true)
		{
			System.out.println("\nUser id, email or mobile number already exist.\n");
		}
		else
		{
			acc.setRole("Admin");
			accountList.add(acc);
		}

	}
	
	//========Administrator option 1: Maintain user account (Update)========
	public static void updateAdmin(ArrayList<Account> accountList)
	{
		// Check if account exist
		boolean adminAccFound = false;
		
		int userID = Helper.readInt("Enter administrator user id for update > ");
		
		for (int i = 0; i < accountList.size(); i++)
		{
			Account adminAcc = accountList.get(i);
			
			if (adminAcc.getUserID() == userID && adminAcc.getRole().equalsIgnoreCase("Admin"))
			{
				adminAccFound = true;
				
                String name = Helper.readString("Enter administrator name > ");
                String email = Helper.readString("Enter administrator email > ");
                int mobileNum = Helper.readInt("Enter administrator mobile number > ");
                String password = Helper.readString("Enter administrator password > ");
                
                // Check for empty fields
                // Check for duplicate email and mobile number
                boolean empty = false;
                boolean duplicate = false;
                
                if(name.isEmpty() 
        				|| email.isEmpty() 
        				|| mobileNum <= 0 
        				|| password.isEmpty() )
        		{
        			empty = true;
        		}
                
                else 
                {
	                for (Account existingAdmin : accountList)
	                {
	                	if (existingAdmin != adminAcc) 
	                	{
	                         if (existingAdmin.getEmail().equalsIgnoreCase(email) 
	                        		 || existingAdmin.getMobileNum() == mobileNum) 
	                         {
	                             duplicate = true;
	                             break;
	                         }
	                	}
	                }
                }
                
                if(empty == true)
                {
                	System.out.println("\nPlease fill in all account details.\n");
                }
                // Error message when email or mobile already exist
                else if (duplicate == true)
                {
                    System.out.println("\nEmail or mobile number already exists. Admin account not updated.\n");
                } 
                
                // If no duplicate exist
                else
                {
                	adminAcc.setName(name);
                	adminAcc.setEmail(email);
                	adminAcc.setMobileNum(mobileNum);
                	adminAcc.setPassword(password);
                	System.out.println("\nAdministrator account " + adminAcc.getUserID() + " updated.\n");
                }
                
                break;
			}
		}
		
		// If user id does not exist
		if(!adminAccFound)
		{
			System.out.println("\nAdministator account " + userID + " not found.\n");
		}
	}
	
	//========Administrator Option 1: Maintain user account (Delete)========
	public static void deleteAdmin(ArrayList<Account> accountList)
	{
		// Check if account exist
		boolean adminAccFound = false;
		
		
		int userID = Helper.readInt("Enter administrator user id for delete > ");
		
		for (int i = 0; i < accountList.size(); i++)
		{
			Account adminAcc = accountList.get(i);
			
			if (adminAcc.getUserID() == userID && (adminAcc.getRole()).equalsIgnoreCase("Admin")) 
			{
                adminAccFound = true;
                accountList.remove(i);
                System.out.println("\nAdmin account with userID " + userID + " has been deleted.\n");
                break;
			}
		}
		
		if(!adminAccFound)
		{
			System.out.println("\nAdministator account " + userID + " not found.\n");
		}
	}
	
	
	
	
	
}


