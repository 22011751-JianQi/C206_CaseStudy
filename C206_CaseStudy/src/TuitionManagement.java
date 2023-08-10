import java.util.ArrayList;
import java.util.regex.Pattern;

public class TuitionManagement 
{
	// ========System login menu options========
	private static final int Login_Option_Quit = 4;
	private static final int Login_Option_Admin = 1;
	private static final int Login_Option_Teacher = 2;
	private static final int Login_Option_Student = 3;

	// ========Administrator menu options(Incomplete)========
	private static final int Admin_Option_Quit = 10;
	private static final int Maintain_Admin_Option = 1;
	private static final int Maintain_Teach_Option = 2;
	private static final int Maintain_Stud_Option = 3;
	private static final int Maintain_Fees_Option = 4;
	private static final int Maintain_Course_Option = 5;
	private static final int View_Enrollment_Statitic = 6;
	private static final int View_Fees_Collection =7;
	private static final int View_Student_Performance = 8;
	private static final int View_Financial_Statitic = 9;
	
	//========Teacher menu options========
	
	
	
	
	//========Student menu options========
	private static final int View_Personal_Information = 1;
	private static final int Maintain_Enrollment = 2;
	private static final int Student_Option_Quit = 3;
	
	private static final int View_Personal_Fees = 1;
	private static final int Update_Personal_Information = 2;
	private static final int View_Personal_Attendance = 3;
	private static final int Retrun_To_Menu1 = 4;
	
	// ========Maintain menu options========
	private static final int Quit = 4;
	private static final int Add = 1;
	private static final int Update = 2;
	private static final int Delete = 3;

	private static final String Course_Pattern = "^[A-Z]\\d{3}$";
	private static final String UserID_Pattern = "";
	
	private static final String Cid_Pattern = "[Cc]\\d{3}";
	private static final String des_Pattern = ".{1,40}";
	private static final String Size_Pattern= "[1-2][0-9]|30";
	
	
	
	
	

	public static void main(String[] args) 
	{
		ArrayList<Account> accountList = new ArrayList<Account>();
	    ArrayList<Course> courseList = new ArrayList<Course>();
	    ArrayList<FeeDetails> feeList = new ArrayList<FeeDetails>();
	    ArrayList<CourseEnroll> enrollmentList = new ArrayList<CourseEnroll>();

	    initializeData(accountList, courseList, feeList, enrollmentList);
	    loginLoop(accountList, courseList, feeList, enrollmentList);
	    System.out.println("\nSee you again\n");
	}
	
	// Method to initialize initial data
	private static void initializeData(
	    ArrayList<Account> accountList,
	    ArrayList<Course> courseList,
	    ArrayList<FeeDetails> feeList,
	    ArrayList<CourseEnroll> enrollmentList
	) 
	{
		accountList.add(new Account("Admin1", 11111111, "12345", "Admin1@gmail.com", 11000000, "Admin"));
		
		accountList.add(new Account("Teacher1", 33333333, "12345", "Teacher1@gmail.com", 12000000, "Teacher"));
		accountList.add(new Account("Teacher2", 44444444, "12345", "Teacher2@gmail.com", 14000000, "Teacher"));
		
		accountList.add(new Account("Student1", 55555555, "12345", "Student1@gmail.com", 13000000, "Student"));
		accountList.add(new Account("Student2", 66666666, "12345", "Student2@gmail.com", 15000000, "Student"));
		
		
		courseList.add(new Course(33333333,"C003", "Math", "Math is fun.", 5, 330.00, 10));
		courseList.add(new Course(33333333,"C001", "Secondary 2 English", "Enhance student's English language.", 2.30, 230.00, 30));
		courseList.add(new Course(44444444, "C002", "Secondary 4 Geography", "Enhance student's Geography.", 4, 260.00, 20));
		
		
		enrollmentList.add(new CourseEnroll(55555555,"C001", "Secondary 2 English", "Enhance student's English language.", 2.30, 230.00, 30));
		
		
		
		FeeDetails s1 = new FeeDetails(55555555,"Tuition",2000,"20/10/2023", "Pending");
		feeList.add(s1);
	}
	
	// Method to handle the main login loop
	private static void loginLoop(
	    ArrayList<Account> accountList,
	    ArrayList<Course> courseList,
	    ArrayList<FeeDetails> feeList,
	    ArrayList<CourseEnroll> enrollmentList
	) {
	    int loginOption = 0;

	    while (loginOption != Login_Option_Quit) 
	    {
	        loginMenu();
	        loginOption = Helper.readInt("Enter an option > ");
	        
	        //Login as Administrator
	        if (loginOption == Login_Option_Admin) 
	        {
	            handleAdminLogin(accountList, courseList, feeList, enrollmentList);
	        } 
	        
	        //Login as Teacher
	        else if (loginOption == Login_Option_Teacher) 
	        {
	            handleTeacherLogin(accountList, courseList);
	        } 
	        
	        //Login as Student
	        else if (loginOption == Login_Option_Student) 
	        {
	            handleStudentLogin(accountList, courseList, feeList, enrollmentList);
	        } 
	        
	        else if (loginOption == Login_Option_Quit) 
	        {
	            // No need to do anything, the loop will exit
	        } else {
	            System.out.println("\nInvalid option!\n");
	        }
	    }
	}

	//========Method to handle administrator login========
	private static void handleAdminLogin
	(
	    ArrayList<Account> accountList,
	    ArrayList<Course> courseList,
	    ArrayList<FeeDetails> feeList,
	    ArrayList<CourseEnroll> enrollmentList
	) 
	{
		Account adminLoginAcct = validateAdmin(accountList);

	    if (adminLoginAcct != null) 
	    {
	        // Administrator menu loop
	        int adminOption = 0;

	        while (adminOption != Admin_Option_Quit) {
	            adminMenu();
	            adminOption = Helper.readInt("Enter an option > ");

	            switch (adminOption) 
	            {
	            	//Option 1
	                case Maintain_Admin_Option:
	                    handleAdminMaintenance(accountList);
	                    break;
	                   
	                //Option 2
	                case Maintain_Teach_Option:
	                    handleTeacherMaintenance(accountList);
	                    break;
	                
	                //Option 3
	                case Maintain_Stud_Option:
	                    handleStudentMaintenance(accountList);
	                    break;
	                
	                //Option 4
	                case Maintain_Fees_Option:
	                    handleFeesMaintenance(feeList);
	                    break;
	                
	                //Option 5    
	                case Maintain_Course_Option:
	                    handleCourseMaintenance(accountList, courseList);
	                    break;
	                   
	                case View_Enrollment_Statitic:
	                	//
	                	break;
	                 
	                //Option 7    
	                case View_Fees_Collection:
	                   // viewFeesCollection(feeList);
	                    break;
	                 
	                //Option 8   
	                case View_Student_Performance:
	                   // viewStudentPerformance(enrollmentList);
	                    break;
	                
	                //Option 9
	                case View_Financial_Statitic:
	                	//
	                	break;
	                
	                //Option 10	
	                case Admin_Option_Quit:
	                    System.out.println("\nReturn to login\n");
	                    break;
	                default:
	                    System.out.println("\nInvalid option!\n");
	            }
	        }
	    }
	    
	    else {
            System.out.println("\nInvalid administrator credentials.\n");
        }
	    
	    
	}
	
	// ========Handle administrator functions========
	//Option 1
	public static void handleAdminMaintenance(ArrayList<Account> accountList)
	{
		boolean isRunning = true;
		
		while(isRunning)
		{
			viewAdminAcc(accountList);
			maintainMenu();
			int maintainOption = Helper.readInt("Enter an Option > ");
			
			switch (maintainOption) 
			{
            case 1:
                Account newAdmin = inputAccount();
                addAdmin(accountList, newAdmin);
                break;
            case 2:
                updateAdmin(accountList);
                break;
            case 3:
            	int deleteUserID = Helper.readInt("Enter administrator user id for delete > ");
                deleteAdmin(accountList, deleteUserID);
                break;
            case 4:
                isRunning = false;
                System.out.println("\nReturn to login menu.\n");
                break;
            default:
                System.out.println("\nInvalid choice. Please choose a valid option.\n");
                break;
			}
		}
	}
	
	//Option 2
	public static void handleTeacherMaintenance(ArrayList<Account> accountList) 
	{
	    boolean isRunning = true;

	    while (isRunning) {
	        viewTeachAcc(accountList);
	        maintainMenu();
	        int maintainOption = Helper.readInt("Enter an Option > ");

	        switch (maintainOption) 
	        {
	            case 1:
	                Account newTeacher = inputAccount();
	                addTeacher(accountList, newTeacher);
	                break;
	            case 2:
	                updateTeacher(accountList);
	                break;
	            case 3:
	                deleteTeacher(accountList);
	                break;
	            case 4:
	                isRunning = false;
	                System.out.println("\nReturn to login menu.\n");
	                break;
	            default:
	                System.out.println("\nInvalid choice. Please choose a valid option.\n");
	                break;
	        }
	    }
	}

	//Option 3
	public static void handleStudentMaintenance(ArrayList<Account> accountList) 
	{
	    boolean isRunning = true;

	    while (isRunning) 
	    {
	        viewStudentAcc(accountList);
	        int maintainOption = Helper.readInt("Enter your choice: ");

	        switch (maintainOption) 
	        {
	            case 1:
	                Account newStudent = inputAccount();
	                addStudent(accountList, newStudent);
	                break;
	            case 2:
	                updateStudent(accountList);
	                break;
	            case 3:
	                deleteStudent(accountList);
	                break;
	            case 4:
	                isRunning = false;
	                System.out.println("\nReturn to login menu.\n");
	                break;
	            default:
	                System.out.println("Invalid choice. Please choose a valid option.");
	                break;
	        }
	    }
	  }

	//Option 4
	public static void handleFeesMaintenance(ArrayList<FeeDetails> feeList) 
	{
	    boolean isRunning = true;

	    while (isRunning) 
	    {
	    	viewAllFee(feeList);
	    	feeMenu();
	        int maintainOption = Helper.readInt("Enter your choice > ");

	        switch (maintainOption) 
	        {
	            case 1:
	                FeeDetails newFee = inputFee();
	                createFee(feeList, newFee);
	                break;
	            case 2:
	                updateFees(feeList);
	                break;
	            case 3:
	                deleteFee(feeList);
	                break;
	            case 4:
	                isRunning = false;
	                System.out.println("\nReturn to login menu.\n");
	                break;
	            default:
	                System.out.println("\nInvalid choice. Please choose a valid option.\n");
	                break;
	        }
	    }
	}
	
	//Option 5
	public static void handleCourseMaintenance(ArrayList<Account> accountList, ArrayList<Course> courseList) 
	{
	    boolean isRunning = true;

	    while (isRunning) 
	    {
	    	viewAllCourse(courseList);
	    	maintainCourseMenu();
	    	int maintainOption = Helper.readInt("Enter your choice > ");

	        switch (maintainOption) 
	        {
	            case 1:
	                Course newCourse = inputCourse(courseList);
	                if (newCourse != null) 
	                {
	                    addCourse(accountList, courseList, newCourse);
	                }
	                break;
	            case 2:
	                Course updatedCourse = inputUpdateCourse(courseList);
	                if (updatedCourse != null) {
	                    updateCourse(accountList, courseList, updatedCourse);
	                }
	                break;
	            case 3:
	                String courseIdToDelete = Helper.readString("Enter course ID to delete >  ");
	                deleteCourse(courseList, courseIdToDelete);
	                break;
	            case 4:
	                isRunning = false;
	                System.out.println("\nReturn to login menu.\n");
	                break;
	            default:
	                System.out.println("\nInvalid choice. Please choose a valid option.\n");
	                break;
	        }
	    }
	}	
	
	//Option 6
	
	//Option 7
	
	//Option 8
	
	//Option 9
	
	//========Method to handle teacher login========
	private static void handleTeacherLogin(ArrayList<Account> accountList, ArrayList<Course> courseList) {
	    int teachOption = 0;
	    Account teacherLoginAcct = validateTeacher(accountList);

	        if (teacherLoginAcct != null) 
	        {
	            teachOption = 0; // Reset teachOption for the teacher menu
	            while (teachOption != 3) {
	                teacherMenu();
	                teachOption = Helper.readInt("Enter an option > ");

	                switch (teachOption) 
	                {
	                	//Option 1
	                	//Go to handleTeacherUpdate method
	                    case 1:
	                        handleTeacherUpdate(accountList, teacherLoginAcct); // Call a separate method to handle teacher info
	                        break;
	                        
	                    //Option 2
	                    case 2:
	                        viewAssignedCourse(courseList, teacherLoginAcct);
	                        //Maintain attendance method
	                        break;
	                    case 3:
	                        System.out.println("\nReturn to login\n");
	                        break;
	                    default:
	                        System.out.println("\nInvalid option!\n");
	                        break;
	                }
	            }
	        } else {
	            System.out.println("\nInvalid teacher credentials.\n");
	        }
	    
	}
	
	//========Handle teacher functions========
	//Under option 1: view personal information
	//Update teacher information
	private static void handleTeacherUpdate(ArrayList<Account> accountList, Account teacherLoginAcct) 
	{
		boolean isRunning = true;
		
		while(isRunning)
		{
			int teachOption2 = 0;
		    while (teachOption2 != 2) 
		    {
		        teacherMenu2();
		        teachOption2 = Helper.readInt("Enter an Option > ");
	
		        switch (teachOption2) 
		        {
		            case 1:
		                updatePersonal(accountList, teacherLoginAcct);
		                viewInfo(teacherLoginAcct);
		                break;
		            case 2:
		            	isRunning = false;
		                System.out.println("\nReturn to Menu\n");
		                break;
		            default:
		                System.out.println("\nInvalid option!\n");
		                break;
		        }
		    }
		}
	}


	//========Method to handle student login========
	private static void handleStudentLogin(ArrayList<Account> accountList, ArrayList<Course> courseList, ArrayList<FeeDetails> feeList, ArrayList<CourseEnroll> enrollmentList) {
	    int studentOption = 0;

	     Account studentLoginAcct = validateStudent(accountList);

	        if (studentLoginAcct != null) 
	        {
	            while (studentOption != 3) 
	            {
	                studentMenu();
	                studentOption = Helper.readInt("Enter an option > ");

	                switch (studentOption)
	                {
	                	// Option 1
	                	// View personal Info
	                	// Student menu 2
	                    case 1:
	                        viewInfo(studentLoginAcct);
	                        handleStudentInfo(accountList, feeList, studentLoginAcct);
	                        break;
	                        
	                    //Option 2
	                    // View enrollment
	                    case 2:
	                        handleStudentEnrollment(courseList, enrollmentList, studentLoginAcct);
	                        break;
	                    case 3:
	                        System.out.println("\nReturn to login\n");
	                        break;
	                    default:
	                        System.out.println("\nInvalid option!\n");
	                        break;
	                }
	            }
	        } else {
	            System.out.println("\nInvalid student credentials.\n");
	        }
	    
	}
	
	//========Handle student functions========
	//Under Option 1
	//
	public static void handleStudentInfo(ArrayList<Account> accountList, ArrayList<FeeDetails> feesList, Account studentLoginAcct) {
		boolean isRunning = true;
		
		while(isRunning)
		{
			int infoUpdateOption = 0;
		    while (infoUpdateOption != 4) 
		    {
		        studentMenu2();
		        infoUpdateOption = Helper.readInt("Enter an Option > ");
	
		        switch (infoUpdateOption) 
		        {
		        	// Option 1
		        	// View personal fees
		            case 1:
		                viewPersonalFees(feesList, studentLoginAcct);
		                break;
		            
		            //Option 2
		            // Update personal info
		            case 2:
		                updatePersonal(accountList, studentLoginAcct);
		                viewInfo(studentLoginAcct);
		                break;
		            
		            //Option 3
		            //View attendance
		            case 3:
		                // Implement viewing attendance if needed
		                break;
		                
		            case 4:
		            	isRunning = false;
		                System.out.println("\nReturn to student menu\n");
		                break;
		            default:
		                System.out.println("\nInvalid option!\n");
		                break;
		        }
		    }
		}
	}
	
	//Option 2
	public static void handleStudentEnrollment(ArrayList<Course> courseList, ArrayList<CourseEnroll> enrollmentList, Account studentLoginAcct) {
		boolean isRunning = true;
		
		while(isRunning)
		{
			int enrollmentOption = 0;
		    while (enrollmentOption != 4) {
		        maintainEnrollmentMenu();
		        enrollmentOption = Helper.readInt("Enter an option > ");
	
		        switch (enrollmentOption) 
		        {
		        	//Option 1
		        	// Add enrollment
		            case 1:
		                addEnrollment(courseList, enrollmentList, studentLoginAcct);
		                break;
		            
		            //Option 2
		            // Update enrollment
		            case 2:
		                updateEnrollment(courseList, enrollmentList, studentLoginAcct);
		                break;
		            
		            //Option 3
		            // Delete enrollment
		            case 3:
		                deleteEnrollment(enrollmentList, studentLoginAcct);
		                break;
		              
		            case 4:
		            	isRunning = false;
		                System.out.println("\nReturn to student menu\n");
		                break;
		            default:
		                System.out.println("\nInvalid option!\n");
		                break;
		        }
		    }
		}
	}
	
	
	
	public static void setHeader(String header) 
	{
		Helper.line(80, "=");
		System.out.println(header);
		Helper.line(80, "=");
	}

	// ========Login Menu========
	public static void loginMenu() {
		TuitionManagement.setHeader("System Login");
		System.out.println("1. Administrator");
		System.out.println("2. Teacher");
		System.out.println("3. Student");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}

	// ========Administrator Menu========
	public static void adminMenu() {
		TuitionManagement.setHeader("Administrator Menu");
		System.out.println("1. View admin account");
		System.out.println("2. View teacher account");
		System.out.println("3. View student account");
		System.out.println("4. View student fees");
		System.out.println("5. View courses");
		System.out.println("6. View enrolment statistics (Not done)");
		System.out.println("7. View fees collection (Not done)");
		System.out.println("8. View student performance (Not done)");
		System.out.println("9. View financial statistics (Not doen)");
		System.out.println("10. Return");
		Helper.line(80, "-");
	}

	
	 
	//========Teacher Menu========
	public static void teacherMenu() {
		TuitionManagement.setHeader("Teacher Menu");
		System.out.println("1. View personal information");
		System.out.println("2. View assigned course");
		System.out.println("3. Return");
		Helper.line(80, "-");
	}

	//========Teacher Menu 2: Under option 1========
	public static void teacherMenu2()
	{
		TuitionManagement.setHeader("Teacher Menu");
		System.out.println("1. Update personal information");
		System.out.println("2. Return");
	}
	
	
	
	// ========Student Menu========
	public static void studentMenu() {
		TuitionManagement.setHeader("Student Menu");
		System.out.println("1. View personal information");
		System.out.println("2. Maintain enrollment");
		System.out.println("3. Return");
		Helper.line(80, "-");
	}

	//========Student Menu 2: under option 1========
	public static void studentMenu2() 
	{
		TuitionManagement.setHeader("Student Menu");
		System.out.println("1. View fees");
		System.out.println("2. Update personal information");
		System.out.println("3. View attendance");
		System.out.println("4. Return to menu");
		Helper.line(80, "-");
	}
	
	
	
	// ========Maintain account menu========
	public static void maintainMenu() {
		TuitionManagement.setHeader("Maintain options");
		System.out.println("1. Add account");
		System.out.println("2. Update account");
		System.out.println("3. Delete account");
		System.out.println("4. Return to menu");
		Helper.line(80, "-");
	}
	
	// ========Maintain course menu========
	public static void maintainCourseMenu() {
		TuitionManagement.setHeader("Maintain courses");
		System.out.println("1. Add a new course");
		System.out.println("2. Update a course");
		System.out.println("3. Delete an existing course");
		System.out.println("4. Return to menu");
	}

	//========Maintain fee menu========
	public static void feeMenu() 
	{
		setHeader("Maintain fees");
		System.out.println("1. Add Fee");
		System.out.println("2. Update Fee");
		System.out.println("3. Delete Fee From Student");
		System.out.println("4. Quit");
	}
	
	//========Maintain enrollment========
	public static void maintainEnrollmentMenu() 
	{
		setHeader("Enrollment menu");
		System.out.println("1. Add enrollment");
		System.out.println("2. Update enrollment");
		System.out.println("3. Delete enrollment");
		System.out.println("4. Quit");
	}
	
	
	
	// ========Administrator login validation========
	public static Account validateAdmin(ArrayList<Account> accountList) {

		int inputUserID = Helper.readInt("Enter Admin user ID > ");
		String inputPassword = Helper.readString("Enter Admin password > ");

		for (Account acc : accountList) {
			if (acc.getRole().equalsIgnoreCase("Admin") && acc.validateAcc(inputUserID, inputPassword)) {
				// Store administrator account
				System.out.println("\nLogin successful.\n");
				return acc;
			}
		}
		return null;
	}

	// ========Teacher login validation========
	public static Account validateTeacher(ArrayList<Account> accountList) {
		int inputUserID = Helper.readInt("Enter Teacher user ID > ");
		String inputPassword = Helper.readString("Enter Teacher password > ");

		for (Account acc : accountList) {
			if (acc.getRole().equalsIgnoreCase("Teacher") && acc.validateAcc(inputUserID, inputPassword)) {
				// Store teacher account
				System.out.println("\nLogin successful.\n");
				return acc;
			}
		}
		return null;
	}

	// ========Student login validation========
	public static Account validateStudent(ArrayList<Account> accountList) {
		int inputUserID = Helper.readInt("Enter Student user ID > ");
		String inputPassword = Helper.readString("Enter Student password > ");

		for (Account acc : accountList) {
			if (acc.getRole().equalsIgnoreCase("Student") && acc.validateAcc(inputUserID, inputPassword)) {
				// Store student account
				System.out.println("\nLogin successful.\n");
				return acc;
			}
		}
		return null;
	}

	
	
	//========Display personal info (student/teacher)========
	public static void viewInfo(Account acc)
	{
		setHeader("Personal Information");
		
		String output = acc.display();
		System.out.println(output);
	}
	
	//========Update personal info (student/teacher)========
	public static void updatePersonal(ArrayList<Account> accountList, Account acc)
	{
		setHeader("Update Personal Information");
		
		String name = Helper.readString("Enter new name > ");
		String email = Helper.readString("Enter new email > ");
		int mobileNum = Helper.readInt("Enter new mobile number > ");
		String password = Helper.readString("Enter new password > ");
		
		// Check for empty fields
		// Check for duplicate email and mobile number
		boolean empty = false;
		boolean duplicate = false;

		if (name.isEmpty() || email.isEmpty() || mobileNum <= 0 || password.isEmpty()) {
			empty = true;
		}

		else {
			for (Account existingAcc : accountList) {
				if (existingAcc != acc) {
					if (existingAcc.getEmail().equalsIgnoreCase(email)
							|| existingAcc.getMobileNum() == mobileNum) {
						duplicate = true;
						break;
					}
				}
			}
		}

		if (empty == true) {
			System.out.println("\nPlease fill in all account details.\n");
		}
		// Error message when email or mobile already exist
		else if (duplicate == true) {
			System.out.println("\nEmail or mobile number already exists. Admin account not updated.\n");
		}

		// If no duplicate exist
		else {
			acc.setName(name);
			acc.setEmail(email);
			acc.setMobileNum(mobileNum);
			acc.setPassword(password);
			System.out.println("\nAccount " + acc.getUserID() + " updated.\n");
		}
	}
	



	
	
	
	
	
	
	// ========Maintain account input========
	public static Account inputAccount() {
		String name = Helper.readString("Enter account name > ");
		int userID = Helper.readInt("Enter account user id > ");
		String email = Helper.readString("Enter account email > ");
		int mobileNum = Helper.readInt("Enter account mobile number > ");
		String password = Helper.readString("Enter account password > ");

		Account acc = new Account(name, userID, password, email, mobileNum, "");
		return acc;
	}

	// ========Administrator option 1: Maintain user account (View)========
	public static String retriveAllUsers(ArrayList<Account> accountList) {
		String output = "";

		for (int i = 0; i < accountList.size(); i++) {
			if ((accountList.get(i).getRole()).equalsIgnoreCase("Admin")) {
				String accInfo = accountList.get(i).toString();

				output += String.format("%-84s\n", accInfo);
			}
		}
		return output;
	}

	public static void viewAdminAcc(ArrayList<Account> accountList) {
		TuitionManagement.setHeader("Administrator accounts");

		String output = String.format("%s %s %s %s %s\n", "Name", "User ID", "Email", "Mobile Num", "Password");

		output += retriveAllUsers(accountList);
		System.out.println(output);
	}

	// ======== Administrator option 1: Maintain user account(Add)========
	public static void addAdmin(ArrayList<Account> accountList, Account acc) {
		Account account;
		boolean duplicate = false;
		boolean empty = false;

		// Check for empty fields
		if ((acc.getName()).isEmpty() || acc.getUserID() <= 0 || (acc.getEmail()).isEmpty() || acc.getMobileNum() <= 0
				|| (acc.getPassword()).isEmpty()) {
			empty = true;
		}

		else {
			for (int i = 0; i < accountList.size(); i++) {
				account = accountList.get(i);

				if (account.getUserID() == acc.getUserID() || (account.getEmail()).equalsIgnoreCase(acc.getEmail())
						|| account.getMobileNum() == acc.getMobileNum()) {
					duplicate = true;
					break;
				}
			}
		}

		if (empty == true) {
			System.out.println("\nPlease fill in all account details.\n");
		} else if (duplicate == true) {
			System.out.println("\nUser id, email or mobile number already exist.\n");
		} else {
			acc.setRole("Admin");
			accountList.add(acc);
			System.out.println("\nUser account " + acc.getUserID() + " successfully created.");
		}

	}

	// ========Administrator option 1: Maintain user account (Update)========
	public static void updateAdmin(ArrayList<Account> accountList) {
		// Check if account exist
		boolean adminAccFound = false;

		int userID = Helper.readInt("Enter administrator user id for update > ");

		for (int i = 0; i < accountList.size(); i++) {
			Account adminAcc = accountList.get(i);

			if (adminAcc.getUserID() == userID && adminAcc.getRole().equalsIgnoreCase("Admin")) {
				adminAccFound = true;

				String name = Helper.readString("Enter administrator name > ");
				String email = Helper.readString("Enter administrator email > ");
				int mobileNum = Helper.readInt("Enter administrator mobile number > ");
				String password = Helper.readString("Enter administrator password > ");

				// Check for empty fields
				// Check for duplicate email and mobile number
				boolean empty = false;
				boolean duplicate = false;

				if (name.isEmpty() || email.isEmpty() || mobileNum <= 0 || password.isEmpty()) {
					empty = true;
				}

				else {
					for (Account existingAdmin : accountList) {
						if (existingAdmin != adminAcc) {
							if (existingAdmin.getEmail().equalsIgnoreCase(email)
									|| existingAdmin.getMobileNum() == mobileNum) {
								duplicate = true;
								break;
							}
						}
					}
				}

				if (empty == true) {
					System.out.println("\nPlease fill in all account details.\n");
				}
				// Error message when email or mobile already exist
				else if (duplicate == true) {
					System.out.println("\nEmail or mobile number already exists. Admin account not updated.\n");
				}

				// If no duplicate exist
				else {
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
		if (!adminAccFound) {
			System.out.println("\nAdministator account " + userID + " not found.\n");
		}
	}

	// ========Administrator Option 1: Maintain user account (Delete)========
	public static void deleteAdmin(ArrayList<Account> accountList, int userID) 
	{
		// Check if account exist
		boolean adminAccFound = false;
		
		for (int i = 0; i < accountList.size(); i++) {
			Account adminAcc = accountList.get(i);

			if (adminAcc.getUserID() == userID && (adminAcc.getRole()).equalsIgnoreCase("Admin")) {
				adminAccFound = true;
				accountList.remove(i);
				System.out.println("\nAdmin account with userID " + userID + " has been deleted.\n");
				break;
			}
		}

		if (!adminAccFound) {
			System.out.println("\nAdministator account " + userID + " not found.\n");
		}
	}

	
	
	// ========Administrator Option 2: Maintain teacher account (View)========
	public static String retriveAllTeachers(ArrayList<Account> accountList) {
		String output = "";

		for (int i = 0; i < accountList.size(); i++) {
			if ((accountList.get(i).getRole()).equalsIgnoreCase("Teacher")) {
				String accInfo = accountList.get(i).toString();

				output += String.format("%-84s\n", accInfo);
			}
		}
		return output;
	}

	public static void viewTeachAcc(ArrayList<Account> accountList) {
		TuitionManagement.setHeader("Teacher accounts");

		String output = String.format("%s %s %s %s %s\n", "Name", "User ID", "Email", "Mobile Num", "Password");

		output += retriveAllTeachers(accountList);
		System.out.println(output);
	}

	// ========Administrator Option 2: Maintain teacher account (Add)========
	public static void addTeacher(ArrayList<Account> accountList, Account acc) {
		Account account;
		boolean duplicate = false;
		boolean empty = false;

		// Check for empty fields
		if ((acc.getName()).isEmpty() || acc.getUserID() <= 0 || (acc.getEmail()).isEmpty() || acc.getMobileNum() <= 0
				|| (acc.getPassword()).isEmpty()) {
			empty = true;
		}

		else {
			for (int i = 0; i < accountList.size(); i++) {
				account = accountList.get(i);

				if (account.getUserID() == acc.getUserID() || (account.getEmail()).equalsIgnoreCase(acc.getEmail())
						|| account.getMobileNum() == acc.getMobileNum()) {
					duplicate = true;
					break;
				}
			}
		}

		if (empty == true) {
			System.out.println("\nPlease fill in all account details.\n");
		} else if (duplicate == true) {
			System.out.println("\nUser id, email or mobile number already exist.\n");
		} else {
			acc.setRole("Teacher");
			accountList.add(acc);
		}
	}

	// ========Administrator Option 2: Maintain teacher account (Update)========
	public static void updateTeacher(ArrayList<Account> accountList) {
		// Check if account exist
		boolean teacherAccFound = false;

		int userID = Helper.readInt("Enter teacher user id for update > ");

		for (int i = 0; i < accountList.size(); i++) {
			Account teacherAcc = accountList.get(i);

			if (teacherAcc.getUserID() == userID && teacherAcc.getRole().equalsIgnoreCase("Teacher")) {
				teacherAccFound = true;

				String name = Helper.readString("Enter teacher name > ");
				String email = Helper.readString("Enter teacher email > ");
				int mobileNum = Helper.readInt("Enter teacher mobile number > ");
				String password = Helper.readString("Enter teacher password > ");

				// Check for empty fields
				// Check for duplicate email and mobile number
				boolean empty = false;
				boolean duplicate = false;

				if (name.isEmpty() || email.isEmpty() || mobileNum <= 0 || password.isEmpty()) {
					empty = true;
				}

				else {
					for (Account existingTeacher : accountList) {
						if (existingTeacher != teacherAcc) {
							if (existingTeacher.getEmail().equalsIgnoreCase(email)
									|| existingTeacher.getMobileNum() == mobileNum) {
								duplicate = true;
								break;
							}
						}
					}
				}

				if (empty == true) {
					System.out.println("\nPlease fill in all account details.\n");
				}
				// Error message when email or mobile already exist
				else if (duplicate == true) {
					System.out.println("\nEmail or mobile number already exists. Teacher account not updated.\n");
				}

				// If no duplicate exist
				else {
					teacherAcc.setName(name);
					teacherAcc.setEmail(email);
					teacherAcc.setMobileNum(mobileNum);
					teacherAcc.setPassword(password);
					System.out.println("\nTeacher account " + teacherAcc.getUserID() + " updated.\n");
				}

				break;
			}
		}

		// If user id does not exist
		if (!teacherAccFound) {
			System.out.println("\nTeacher account " + userID + " not found.\n");
		}
	}

	// ========Administrator Option 2: Maintain teacher account (Delete)========
	public static void deleteTeacher(ArrayList<Account> accountList) {
		// Check if account exist
		boolean teacherAccFound = false;

		int userID = Helper.readInt("Enter teacher user id for delete > ");

		for (int i = 0; i < accountList.size(); i++) {
			Account teacherAcc = accountList.get(i);

			if (teacherAcc.getUserID() == userID && (teacherAcc.getRole()).equalsIgnoreCase("Teacher")) {
				teacherAccFound = true;
				accountList.remove(i);
				System.out.println("\nTeacher account with userID " + userID + " has been deleted.\n");
				break;
			}
		}

		if (!teacherAccFound) {
			System.out.println("\nTeacher account " + userID + " not found.\n");
		}
	}

	
	
	// =========Administrator Option 3: Maintain Student Account (View)
	public static String retriveAllStudents(ArrayList<Account> accountList) {
		String output = "";
		for (int i = 0; i < accountList.size(); i++) {
			if ((accountList.get(i).getRole()).equalsIgnoreCase("Student")) {
				String accInfo = accountList.get(i).toString();

				output += String.format("%-84s\n", accInfo);
			}
		}
		return output;
	}

	public static void viewStudentAcc(ArrayList<Account> accountList) {
		TuitionManagement.setHeader("Student accounts");

		String output = String.format("%s %s %s %s %s\n", "Name", "User ID", "Email", "Mobile Num", "Password");

		output += retriveAllStudents(accountList);
		System.out.println(output);
	}

	// ========Administrator Option 3: Maintain Student Account (Add)============
	public static void addStudent(ArrayList<Account> accountList, Account acc) {
		Account account;
		boolean duplicate = false;
		boolean empty = false;

		// Check for empty fields
		if ((acc.getName()).isEmpty() || acc.getUserID() <= 0 || (acc.getEmail()).isEmpty() || acc.getMobileNum() <= 0
				|| (acc.getPassword()).isEmpty()) {
			empty = true;
		}

		else {
			for (int i = 0; i < accountList.size(); i++) {
				account = accountList.get(i);

				if (account.getUserID() == acc.getUserID() || (account.getEmail()).equalsIgnoreCase(acc.getEmail())
						|| account.getMobileNum() == acc.getMobileNum()) {
					duplicate = true;
					break;
				}
			}
		}

		if (empty == true) {
			System.out.println("\nPlease fill in all account details.\n");
		} else if (duplicate == true) {
			System.out.println("\nUser id, email or mobile number already exist.\n");
		} else {
			acc.setRole("Student");
			accountList.add(acc);
		}
	}

	// =========Administrator Option 3: Maintain Student account (Update)==========
	public static void updateStudent(ArrayList<Account> accountList) {
		// Check if account exist
		boolean studentAccFound = false;

		int userID = Helper.readInt("Enter student user id for update > ");

		for (int i = 0; i < accountList.size(); i++) {
			Account studentAcc = accountList.get(i);

			if (studentAcc.getUserID() == userID && studentAcc.getRole().equalsIgnoreCase("Student")) {
				studentAccFound = true;

				String name = Helper.readString("Enter student name > ");
				String email = Helper.readString("Enter student email > ");
				int mobileNum = Helper.readInt("Enter student mobile number > ");
				String password = Helper.readString("Enter student password > ");

				// Check for empty fields
				// Check for duplicate email and mobile number
				boolean empty = false;
				boolean duplicate = false;

				if (name.isEmpty() || email.isEmpty() || mobileNum <= 0 || password.isEmpty()) {
					empty = true;
				}

				else {
					for (Account existingStudent : accountList) {
						if (existingStudent != studentAcc) {
							if (existingStudent.getEmail().equalsIgnoreCase(email)
									|| existingStudent.getMobileNum() == mobileNum) {
								duplicate = true;
								break;
							}
						}
					}
				}

				if (empty == true) {
					System.out.println("\nPlease fill in all account details.\n");
				}
				// Error message when email or mobile already exist
				else if (duplicate == true) {
					System.out.println("\nEmail or mobile number already exists. Student account not updated.\n");
				}

				// If no duplicate exist
				else {
					studentAcc.setName(name);
					studentAcc.setEmail(email);
					studentAcc.setMobileNum(mobileNum);
					studentAcc.setPassword(password);
					System.out.println("\nStudent account " + studentAcc.getUserID() + " updated.\n");
				}

				break;
			}
		}

		// If user id does not exist
		if (!studentAccFound) {
			System.out.println("\nStudent account " + userID + " not found.\n");
		}

	}

	// ========Administrator Option 3: Maintain Student account (Delete)========
	public static void deleteStudent(ArrayList<Account> accountList) {
		// Check if account exist
		boolean studentAccFound = false;

		int userID = Helper.readInt("Enter student user id for delete > ");

		for (int i = 0; i < accountList.size(); i++) {
			Account studentAcc = accountList.get(i);

			if (studentAcc.getUserID() == userID && (studentAcc.getRole()).equalsIgnoreCase("Student")) {
				studentAccFound = true;
				accountList.remove(i);
				System.out.println("\nStudent account with userID " + userID + " has been deleted.\n");
				break;
			}
		}

		if (!studentAccFound) {
			System.out.println("\nStudent account " + userID + " not found.\n");
		}
	}

	
	
	//========Administrator Option 4: Maintain Fees (View)========
	public static String retrieveAllFees(ArrayList<FeeDetails> feeList) 
	{
		String output = "";
		for(int j=0; j < feeList.size();j++) 
		{
			String feeInfo = feeList.get(j).feeString();
			
			output += String.format("%-15d %-69s\n", feeList.get(j).getUserID(), feeInfo);			
		}
		return output;
	}

	public static void viewAllFee(ArrayList<FeeDetails> feeList) {
		setHeader("ALL FEE");
		String output = String.format("%-15s %-20s %-15s %-15s %-20s\n","ID","FEE TYPES","AMOUNT","DUE DATE","PAYMENT STATUS");
		output += retrieveAllFees(feeList);
		System.out.println(output);
	}
	
	//========Administrator Option 4: Maintain Fees (Add - Do after enrollment)========
	public static FeeDetails inputFee() {
		int id = Helper.readInt("Enter the student ID: ");
		String type = Helper.readString("Enter the fee type (Tuition/Exam/Others) : ");
		double price = Helper.readDouble("Enter the fee amount: ");
		String duedate = Helper.readString("Enter the fee due date (dd/mm/yyyy): ");
		String status = Helper.readString("Enter the payment status (Pending/Paid): ");
		FeeDetails newfee = new FeeDetails(id,type,price,duedate,status);
		return newfee;
		
	}
	
	public static void createFee(ArrayList<FeeDetails> feeList, FeeDetails newfee) {
		
		for(int i = 0; i < feeList.size(); i++) {
			if (feeList.get(i).getUserID()==newfee.getUserID() &&
					feeList.get(i).getDueDate().equalsIgnoreCase(newfee.getDueDate())&&
					feeList.get(i).getType().equalsIgnoreCase(newfee.getType()))
				return;
		}

		if(newfee.getType().isEmpty()) {
			return;
		}
		feeList.add(newfee);
	}

	//========Administrator Option 4: Maintain Fees (Update)========
	public static boolean doUpdateFees(ArrayList<FeeDetails> feeList, int id, String type, double price, String dueDate, String paymentStatus) {
		boolean isUpdated = false;
		
		if(type.isEmpty()||dueDate.isEmpty()||paymentStatus.isEmpty()) 
			return false;
		
		for (int i = 0; i < feeList.size();i++) {
			if(id == feeList.get(i).getUserID() && type.equalsIgnoreCase(feeList.get(i).getType()) && dueDate.equalsIgnoreCase(dueDate)) {
				feeList.get(i).setType(type);
				feeList.get(i).setPrice(price);
				feeList.get(i).setDueDate(dueDate);
				feeList.get(i).setPaymentStatus(paymentStatus);
				isUpdated = true;
			}
		}
		return isUpdated;
	}
	
	public static void updateFees(ArrayList<FeeDetails> feeList) {
		int id = Helper.readInt("Enter the student ID: ");
		String type = Helper.readString("Enter the fee type (Tuition/Exam/Others) : ");
		double price = Helper.readDouble("Enter the fee amount: ");
		String duedate = Helper.readString("Enter the fee due date (dd/mm/yyyy): ");
		String status = Helper.readString("Enter the payment status (Pending/Paid): ");
		Boolean isUpdated = doUpdateFees(feeList,id,type,price,duedate,status);
		if (!isUpdated) {
			System.out.println("Invalid input");
		} else {
			System.out.println("Updated Successfully");
		}
	}

	//========Administrator Option 4: Maintain Fees (Delete)========
	public static boolean doDeleteFee(ArrayList<FeeDetails> feeList,FeeDetails newFee) {
		boolean isDeleted = false;
		for (int i = 0 ; i < feeList.size(); i++) {
			if(feeList.get(i).getUserID()== newFee.getUserID() && feeList.get(i).getType().equalsIgnoreCase(newFee.getType())) {
				feeList.remove(i);
				isDeleted = true;
				break;
			}
		}
		return isDeleted;
	}
	
	public static void deleteFee(ArrayList<FeeDetails> feeList) {
		int id = Helper.readInt("Enter the student ID: ");
		String type = Helper.readString("Enter the fee type (Tuition/Exam/Others) : ");
		double price = Helper.readDouble("Enter the fee amount: ");
		String duedate = Helper.readString("Enter the fee due date (dd/mm/yyyy): ");
		String status = Helper.readString("Enter the payment status (Pending/Paid): ");
		FeeDetails newFee = new FeeDetails(id,type,price,duedate,status);
		Boolean isDeleted = doDeleteFee(feeList,newFee);
		if (!isDeleted) {
			System.out.println("Invalid input");
		} else {
			System.out.println("Deleted Successfully");
		}
	}

	
	
	// ========Administrator Option 5: Maintain course (View)========
	public static String retrieveAllCourse(ArrayList<Course> courseList) {
		String output = "";

		for (int i = 0; i < courseList.size(); i++) {

			String description = courseList.get(i).courseDisplay();

			output += String.format("%-20d %-99s\n", courseList.get(i).getUserID(), description);

		}
		return output;
	}

	public static void viewAllCourse(ArrayList<Course> courseList) 
	{
		TuitionManagement.setHeader("COURSE LIST");
		
		String output = String.format("%-20s %-10s %-25s %-40s %-10s %-10s %-10s\n", "TEACHER ASSIGNED", "COURSE ID", "COURSE NAME", "DESCRIPTION",
				"DURATION", "COST", "SIZE");
		output += retrieveAllCourse(courseList);
		
		System.out.println(output);
	}

	// ========Administrator Option 5: Maintain courses (Add)========
	public static Course inputCourse(ArrayList<Course> courseList) {
		TuitionManagement.setHeader("ADD COURSE");
		
		String Cid = Helper.readString("Enter course id > ");

		for (Course c : courseList) {
			if (c.getCid().equalsIgnoreCase(Cid)) {
				System.out.println("Course ID " + Cid + " already exists.");
				return null;
			}
		}

		int userID = Helper.readInt("Enter teacher user id > ");
		String name = Helper.readString("Enter course name > ");
		String description = Helper.readString("Enter description > ");
		double duration = Helper.readDouble("Enter duration > ");
		double cost = Helper.readInt("Enter price > ");
		int size = Helper.readInt("Enter class size > ");

		Course course = new Course(userID, Cid, name, description, duration, cost, size);
		return course;

	}

	public static void addCourse(ArrayList<Account> accountList, ArrayList<Course> courseList, Course course) {
		//checks duplicate
		Course item;
		for (int i = 0; i < courseList.size(); i++) {
			item = courseList.get(i);
			String id = item.getCid();
			if (id.equalsIgnoreCase(course.getCid()))
				return;
		}
		//checks teacher id valid
		boolean isValidTeacher = false; 
	    for (Account acc : accountList) {
	        if (acc.getUserID() == course.getUserID() && acc.getRole().equals("Teacher")) {
	            isValidTeacher = true;
	            break;
	        }
	    }

	    if (!isValidTeacher) {
	        System.out.println("Invalid teacher ID.");
	        return;
	    }

	    //check if empty
		if (course.getCid().isEmpty()
				|| course.getDescription().isEmpty()
				|| course.getCname().isEmpty()
				|| course.getDuration()==0
				|| course.getCost()==0
				|| course.getSize()==0) {
			return;
		}
		
		//Input check
		boolean toFormatCid = Pattern.matches(Cid_Pattern, course.getCid());
		boolean toFormatDes = Pattern.matches(des_Pattern, course.getDescription());
		String size = Integer.toString(course.getSize());
		boolean toFormatSize = Pattern.matches(Size_Pattern,size);
		
		if(!toFormatCid) {
			System.out.println("ID must start with C with 3 integers");
			return;
		}
		if(!toFormatDes) {
			System.out.println("Description maximum 40 characters");
			return;
		}
		if(!toFormatSize) {
			System.out.println("Size must be 10-30");
			return;
		}
	

		courseList.add(course);
		System.out.println("Course added.");

	}

	// ========Administrator Option 5: Maintain courses (Update)========
	public static Course inputUpdateCourse(ArrayList<Course> courseList) {
		String courseId = Helper.readString("Enter course id to update course > ");

		for (Course course : courseList) {
			if (course.getCid().equalsIgnoreCase(courseId)) {
				int userID = Helper.readInt("Enter teacher user id > ");
				String Nname = Helper.readString("Enter updated course name > ");
				String Ndescription = Helper.readString("Enter updated description > ");
				double Nduration = Helper.readDouble("Enter duration > ");
				double Ncost = Helper.readInt("Enter price > ");
				int Nsize = Helper.readInt("Enter class size > ");

				Course Ncourse = new Course(userID, courseId, Nname, Ndescription, Nduration, Ncost, Nsize);
				return Ncourse;
			}
		}

		System.out.println("Course ID " + courseId + " not found.");
		return null;
	}

	public static void updateCourse(ArrayList<Account> accountList, ArrayList<Course> courseList, Course Ncourse) {

		//checks teacher id
		boolean isValidTeacher = false; 
	    for (Account acc : accountList) {
	        if (acc.getUserID() == Ncourse.getUserID() && acc.getRole().equals("Teacher")) {
	            isValidTeacher = true;
	            break;
	        }
	    }

	    if (isValidTeacher==false) {
	        System.out.println("Invalid teacher ID.");
	        return;
	    }
	    
	    //checks if empty
	    if (Ncourse.getCid().isEmpty()
				|| Ncourse.getDescription().isEmpty()
				|| Ncourse.getCname().isEmpty()
				|| Ncourse.getDuration()==0
				|| Ncourse.getCost()==0
				|| Ncourse.getSize()==0) {
			return;
		}
	    
	    
	    //input check
	    boolean toFormatDes = Pattern.matches(des_Pattern, Ncourse.getDescription());
		String size = Integer.toString(Ncourse.getSize());
		boolean toFormatSize = Pattern.matches(Size_Pattern,size);
		
		if(!toFormatDes) {
			System.out.println("Description maximum 40 characters");
			return;
		}		
		if(!toFormatSize) {
			System.out.println("Size must be 10-30");
			return;
		}
	    
	    //update
		for (Course course : courseList) {

			if (course.getCid().equalsIgnoreCase(Ncourse.getCid())) {
				course.setUserID(Ncourse.getUserID());
				course.setCname(Ncourse.getCname());
				course.setDescription(Ncourse.getDescription());
				course.setDuration(Ncourse.getDuration());
				course.setCost(Ncourse.getCost());

				return;
			}
		}

	}

	// ========Administrator Option 5: Maintain courses (Delete)========
	public static void deleteCourse(ArrayList<Course> courseList, String courseId) {
		for (int i = 0; i < courseList.size(); i++) {
			Course course = courseList.get(i);
			if (course.getCid().equalsIgnoreCase(courseId)) {
				courseList.remove(i);

				System.out.println("Course deleted.");
				return;
			}
		}
		System.out.println("Course ID " + courseId + " not found.");
	}

	
	
	//========Teacher Functions========
	
	
	
	//========Teacher Option 1: view assigned course========
	public static String retrieveAssignedCourse(ArrayList<Course> courseList, Account acc) 
	{
		String output = "";

		for (Course existingCourse : courseList) 
		{
			if(existingCourse.getUserID() == acc.getUserID())
			{
				output += existingCourse.courseDisplay() + "\n";
			}
		}
		return output;
	}
	
	public static void viewAssignedCourse(ArrayList<Course> courseList, Account acc) 
	{
		setHeader("Assigned Course");
		
		String output = String.format("%-10s %-25s %-40s %-10s %-10s %-10s\n", "COURSE ID", "COURSE NAME", "DESCRIPTION", "DURATION", "COST", "SIZE");
		output += retrieveAssignedCourse(courseList, acc);
		
		System.out.println(output);
	}
	
	//========Teacher Option 1: Maintain attendance========
	
	
	
	//========Student Functions========
	
	
		
	//========Student Option 1: View Student fees========
	public static String retrivePersonalFees(ArrayList<FeeDetails> feesList, Account acc)
	{
		String output = "";
		
		for(FeeDetails existingFees : feesList)
		{
			if(existingFees.getUserID() == acc.getUserID())
			{
				if((existingFees.getPaymentStatus()).equalsIgnoreCase("Pending"))
				{
					output += existingFees.feeString();
				}
				
				else
				{
					output = "No pending fees";
				}
			}
		}
		return output;
	}
	
	public static void viewPersonalFees(ArrayList<FeeDetails> feesList, Account acc)
	{
		setHeader("Personal Fees");
		
		String output = String.format("%-20s %-15s %-15s %-20s\n","FEE TYPES","AMOUNT","DUE DATE","PAYMENT STATUS");
		output += retrivePersonalFees(feesList, acc);
		System.out.println(output);
	}
	
	//========Student Option 1: View student attendance========

	
	
	//========Student Option 2: Maintain enrollment (View)========
	public static String retriveEnrollment(ArrayList<CourseEnroll> enrollmentList, Account acc)
	{	
		String output = "";
		
		for (CourseEnroll course : enrollmentList)
		{
			if(course.getUserID() == acc.getUserID())
			{
				output += course.courseDisplay() + "\n";
			}
		}
		
		return output;
	}
	
	public static void viewEnrollment(ArrayList<CourseEnroll> enrollmentList, Account acc) 
	{
		setHeader("Assigned Course");
		
		String output = String.format("%-10s %-25s %-40s %-10s %-10s %-10s\n", "COURSE ID", "COURSE NAME", "DESCRIPTION", "DURATION", "COST", "SIZE");
		output += retriveEnrollment(enrollmentList, acc);
		
		System.out.println(output);
	}
	
	//========Student Option 2: Maintain enrollment (Add)======== 
	public static void addEnrollment(ArrayList<Course> courseList, ArrayList<CourseEnroll> enrollmentList, Account acc)
	{
		boolean empty = false;
		boolean courseFound = false;
		boolean courseEnrolled = false;
		boolean courseAdded = false;
		
		setHeader("Add Enrollment");
		String cid = Helper.readString("Enter course id to enroll > ");
		
		//Check if String is empty
		if(cid.isEmpty())
		{
			empty=true;
		}
		
		
		
		//if cid is not empty
		else
		{
			for(int i = 0; i < courseList.size(); i++)
			{
				Course existingCourse = courseList.get(i);
				
				//Check if course id is valid 
				if(existingCourse.getCid().equals(cid))
				{
					courseFound = true;
					
					for(int j = 0; j < enrollmentList.size(); j++)
					{
						CourseEnroll enrollment = enrollmentList.get(j);
						
						//Check if student has already enrolled
						if(enrollment.getCid().equals(cid) && acc.getUserID() == enrollment.getUserID())
						{
							courseEnrolled = true;
							break;
						}	 
					}
					
					if(!courseEnrolled)
					{
						enrollmentList.add(new CourseEnroll(acc.getUserID(),cid, existingCourse.getCname(), 
								existingCourse.getDescription(), existingCourse.getDuration(), 
								existingCourse.getCost(), existingCourse.getSize()));
						courseAdded = true;
					}
				}
			}
		}
		
		if(empty == true)
		{
			System.out.println("\nPlease fill in the blank");
		}
		else if(courseFound == false)
		{
			System.out.println("\nCourse " + cid + " not found.\n");
		}
		else if(courseEnrolled == true)
		{
			System.out.println("\nAlready enrolled in course " + cid);
		}
		else if(courseAdded == true)
		{
			System.out.println("\nEnrolled in course " + cid);
		}
	}

	//========Student Option 2: Maintain enrollment (update)========
	public static void updateEnrollment(ArrayList<Course> courseList, ArrayList<CourseEnroll> enrollmentList, Account acc)
	{
		boolean empty = false;
		boolean courseFound = false;
		boolean courseEnrolled = false;
		boolean courseUpdated = false;
		
		setHeader("Update Enrollment");
	    String cidToUpdate = Helper.readString("Enter course id to update enrollment > ");
	    
	    // Check if String is empty
	    if (cidToUpdate.isEmpty()) 
	    {
	        empty = true;
	    } 
	    
	    else 
	    {
	    	CourseEnroll existingEnrollment = null;
	    	
	    	//Check if student is enrolled in cid to update
	    	for(CourseEnroll enrollment : enrollmentList)
	    	{
	    		if (enrollment.getCid().equals(cidToUpdate) && acc.getUserID() == enrollment.getUserID()) 
	    		{
	               existingEnrollment = enrollment;
	               break;     
	            }
	    	}
	    	
	    	if (existingEnrollment != null) 
	    	{
	            // Student is already enrolled in the specified course
	            courseEnrolled = true;
	            
	            String newCid = Helper.readString("Enter new course id to enroll > ");
	    	
	            for (Course newCourse : courseList) 
	            {
	            	// if new cid is valid
	                if (newCourse.getCid().equals(newCid)) 
	                {
	                    courseFound = true;
	                    
	                    //update enrollment to new course information
	                    existingEnrollment.setCid(newCid);
	                    existingEnrollment.setCname(newCourse.getCname());
	                    existingEnrollment.setDescription(newCourse.getDescription());
	                    existingEnrollment.setDuration(newCourse.getDuration());
	                    existingEnrollment.setCost(newCourse.getCost());
	                    existingEnrollment.setSize(newCourse.getSize());

	                    courseUpdated = true;
	                    break;
	                }
	            }
	    	}
	    }

	    if (empty) 
	    {
	        System.out.println("\nPlease fill in the blank");
	    } 
	    else if (!courseFound) 
	    {
	        System.out.println("\nCourse not found or new course id is invalid.\n");
	    } 
	    else if (courseEnrolled && courseUpdated) 
	    {
	        System.out.println("\nEnrollment updated for course " + cidToUpdate + "\n");
	    }
	}
	
	//========Student Option 2: Maintain enrollment (delete)========
	public static void deleteEnrollment(ArrayList<CourseEnroll> enrollmentList, Account acc)
	{
		boolean enrollmentFound = false;
		
		setHeader("Remove Enrollment");
	    String cidToRemove = Helper.readString("Enter course id to remove enrollment > ");
	    
	    for (int i = 0; i < enrollmentList.size(); i++)
	    {
	    	CourseEnroll enrollment = enrollmentList.get(i);
	    	
	    	if(enrollment.getCid().equals(cidToRemove) && acc.getUserID() == enrollment.getUserID())
	    	{
	    		enrollmentFound = true;
	    		enrollmentList.remove(i); 
	    		System.out.println("\nEnrollment for course " + cidToRemove + " has been removed.");
	    		break;
	    	}
	    }
	    
	    if(!enrollmentFound)
	    {
	        System.out.println("\nYou are not enrolled in the course " + cidToRemove);
	    }
	    
	    
	}	

}
