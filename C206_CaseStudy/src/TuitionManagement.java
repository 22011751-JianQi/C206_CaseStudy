import java.util.ArrayList;

public class TuitionManagement 
{

	public static void main(String[] args) 
	{
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		adminList.add(new Admin("Admin1", 11111111, "12345", "Admin1@gmail.com", 11000000));
		adminList.add(new Admin("Admin2", 22222222, "12345", "Admin2@gmail.com", 12000000));
		
		teacherList.add(new Teacher("Teacher1", 33333333, "12345", "Teacher1@gmail.com", 13000000));
		teacherList.add(new Teacher("Teacher2", 44444444, "12345", "Teacher2@gmail.com", 14000000));
		
		studentList.add(new Student("Student1", 55555555, "12345", "Student1@gmail.com", 15000000));
		studentList.add(new Student("Student2", 66666666, "12345", "Student2@gmail.com", 16000000));
	
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
				Admin adminLoginAcct = validateAdmin(adminList);
				
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
						}
						else if (adminOption == 2)
						{
							//Maintain teacher account
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
						{System.out.println("Return to login\n");}
						else
						{System.out.println("Invalid option!\n");}
					}
				}
			}
			
			// Teacher login 
			else if(loginOption == 2)
			{
				// Validate teacher credentials
				Teacher teachLoginAcct = validateTeacher(teacherList);
				
				if (teachLoginAcct != null)
				{
					int teachOption = 0;
					
					//Teacher menu
					while (teachOption != 3)
					{
						teachMenu();
						teachOption = Helper.readInt("Enter an option > ");
						
						if (teachOption == 1)
						{
							
						}
						
						else if (teachOption == 2)
						{
							
						}
						
						else if (teachOption == 3)
						{System.out.println("Return to login\n");}
						else
						{System.out.println("Invalid option!\n");}
					}
				}
			}
			
			// Student login
			else if(loginOption == 3)
			{
				// Validate student credentials
				Student studLoginAcct = validateStudent(studentList);
				
				if (studLoginAcct != null)
				{
					int studOption = 0;
					
					//Administrator menu
					while (studOption != 2)
					{
						studMenu();
						studOption = Helper.readInt("Enter an option > ");
						
						if (studOption == 1)
						{
							
						}
						
						else if (studOption == 2)
						{System.out.println("Return to login\n");}
						else
						{System.out.println("Invalid option!\n");}
					}
				}
			}
			
			else if (loginOption == 4)
			{System.out.println("See you again\n");}
			else
			{System.out.println("Invalid option!\n");}
			}
	}
	
	public static void setHeader(String header) 
	{
		Helper.line(80, "=");
		System.out.println(header);
		Helper.line(80, "=");
	}
	
	public static void loginMenu()
	{
		TuitionManagement.setHeader("System Login");
		System.out.println("1. Administrator");
		System.out.println("2. Teacher");
		System.out.println("3. Student");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}
	
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

	public static void teachMenu()
	{
		TuitionManagement.setHeader("Teacher Menu");
		System.out.println("1. View personal information");
		System.out.println("2. View assigned course");
		System.out.println("3. Return");
		Helper.line(80, "-");
	}
	
	public static void studMenu()
	{
		TuitionManagement.setHeader("Student Menu");
		System.out.println("1. View personal information");
		System.out.println("2. Return");
		Helper.line(80, "-");
	}
	
	//Administrator login validation
	private static Admin validateAdmin(ArrayList<Admin> adminList)
	{
		Admin adminLoginAcct = null;
		boolean accLock = false;
		
		while(adminLoginAcct == null && accLock == false)
		{
			int inputUserID = Helper.readInt("Enter Admin user ID > ");
			String inputPassword = Helper.readString("Enter Admin password > ");
			
			for (Admin acc : adminList)
			{
				if(acc.validateAcc(inputUserID, inputPassword) == true)
				{
					// Store administrator account
					adminLoginAcct = acc;
					break;
				}
			}
			
			if(adminLoginAcct == null)
			{
				System.out.println("Incorrect user ID or password\n");
				break;
			}
	
		}
		return adminLoginAcct;
	}

	//Teacher login validation
	private static Teacher validateTeacher(ArrayList<Teacher> teacherList)
	{
		Teacher teachLoginAcct = null;

		while(teachLoginAcct == null)
		{
			int inputUserID = Helper.readInt("Enter Teacher user ID > ");
			String inputPassword = Helper.readString("Enter Teacher password > ");
			
			for (Teacher acc : teacherList)
			{
				if(acc.validateAcc(inputUserID, inputPassword))
				{
					teachLoginAcct = acc;
					break;
				}
			}
			
			if(teachLoginAcct == null)
			{
				System.out.println("Incorrect user ID or password\n");
				break;
			}
		}
		return teachLoginAcct;
	}
	
	//Student login validation
	private static Student validateStudent(ArrayList<Student> studentList)
	{
		Student studLoginAcct = null;

		while(studLoginAcct == null)
		{
			int inputUserID = Helper.readInt("Enter Student user ID > ");
			String inputPassword = Helper.readString("Enter Student password > ");
			
			for (Student acc : studentList)
			{
				if(acc.validateAcc(inputUserID, inputPassword))
				{
					studLoginAcct = acc;
					break;
				}
			}
			
			if(studLoginAcct == null)
			{
				System.out.println("Incorrect user ID or password\n");
				break;
			}
		}
		return studLoginAcct;
	}

}


