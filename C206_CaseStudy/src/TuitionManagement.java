import java.util.ArrayList;

public class TuitionManagement {
	// ========System login menu options========
	private static final int Login_Option_Quit = 4;
	private static final int Login_Option_Admin = 1;
	private static final int Login_Option_Teach = 2;
	private static final int Login_Option_Stud = 3;

	// ========Administrator menu options(Incomplete)========
	private static final int Admin_Option_Quit = 10;
	private static final int Maintain_Admin_Option = 1;
	private static final int Maintain_Teach_Option = 2;
	private static final int Maintain_Stud_Option = 3;
	private static final int MAINTAIN_COURSE = 5;

	// ========Maintain menu options========
	private static final int Quit = 4;
	private static final int Add = 1;
	private static final int Update = 2;
	private static final int Delete = 3;

	public static void main(String[] args) {
		ArrayList<Account> accountList = new ArrayList<Account>();

		accountList.add(new Account("Admin1", 11111111, "12345", "Admin1@gmail.com", 11000000, "Admin"));
		accountList.add(new Account("Teacher1", 33333333, "12345", "Teacher1@gmail.com", 12000000, "Teacher"));
		accountList.add(new Account("Student1", 55555555, "12345", "Student1@gmail.com", 13000000, "Student"));

		ArrayList<Course> courseList = new ArrayList<Course>();

		courseList.add(
				new Course("C001", "Secondary 2 English", "Enhance student's English language.", "2 hours", 230.00));
		courseList.add(new Course("C002", "Secondary 4 Geography", "Enhance student's Geography.", "2 hours", 260.00));

		int loginOption = 0;

		// Login Menu
		while (loginOption != 4) {
			loginMenu();
			loginOption = Helper.readInt("Enter an option > ");

			// Administrator Login
			if (loginOption == 1) {
				// Validate administrator credentials
				Account adminLoginAcct = validateAdmin(accountList);

				if (adminLoginAcct != null) {
					int adminOption = 0;

					// Administrator menu
					while (adminOption != 10) {
						adminMenu();
						adminOption = Helper.readInt("Enter an option > ");

						// Add new Administrator
						if (adminOption == 1) {
							// Maintain administrator account
							TuitionManagement.viewAdminAcc(accountList);

							int maintainOption = 0;

							while (maintainOption != Quit) {
								TuitionManagement.maintainMenu();
								maintainOption = Helper.readInt("Enter an Option > ");

								// Add administrator account
								if (maintainOption == Add) {
									Account acc = TuitionManagement.inputAccount();
									TuitionManagement.addAdmin(accountList, acc);
									TuitionManagement.viewAdminAcc(accountList);
								}

								// Update administrator account
								else if (maintainOption == Update) {
									TuitionManagement.updateAdmin(accountList);
									TuitionManagement.viewAdminAcc(accountList);
								}

								// Delete administrator account
								else if (maintainOption == Delete) {
									TuitionManagement.deleteAdmin(accountList);
									TuitionManagement.viewAdminAcc(accountList);
								}

								// Return to administrator menu
								else if (maintainOption == Quit) {
									System.out.println("\nReturn to menu\n");
								}

								else {
									System.out.println("\nInvalid Input!\n");
								}

							}

						}

						else if (adminOption == 2) {
							// Maintain teacher account
							TuitionManagement.viewTeachAcc(accountList);

							int maintainOption = 0;

							while (maintainOption != Quit) {
								TuitionManagement.maintainMenu();
								maintainOption = Helper.readInt("Enter an Option > ");

								// Add teacher account
								if (maintainOption == Add) {
									Account acc = TuitionManagement.inputAccount();
									TuitionManagement.addTeacher(accountList, acc);
									TuitionManagement.viewTeachAcc(accountList);
								}

								else if (maintainOption == Update) {
									TuitionManagement.updateTeacher(accountList);
									TuitionManagement.viewTeachAcc(accountList);
								}

								else if (maintainOption == Delete) {
									TuitionManagement.deleteTeacher(accountList);
									TuitionManagement.viewTeachAcc(accountList);
								}

								// Return to administrator menu
								else if (maintainOption == Quit) {
									System.out.println("\nReturn to menu\n");
								}

								else {
									System.out.println("\nInvalid Input!\n");
								}
							}
						}

						else if (adminOption == 3) {
							// Maintain Student account
							TuitionManagement.viewStudentAcc(accountList);

							int maintainOption = 0;

							while (maintainOption != Quit) {
								TuitionManagement.maintainMenu();
								maintainOption = Helper.readInt("Enter an Option > ");

								// Add Student account
								if (maintainOption == Add) {
									Account acc = TuitionManagement.inputAccount();
									TuitionManagement.addStudent(accountList, acc);
									TuitionManagement.viewStudentAcc(accountList);
								}

								// Update Student account
								else if (maintainOption == Update) {
									TuitionManagement.updateStudent(accountList);
									TuitionManagement.viewStudentAcc(accountList);
								}

								// Delete Student account
								else if (maintainOption == Delete) {
									TuitionManagement.deleteStudent(accountList);
									TuitionManagement.viewStudentAcc(accountList);
								}

								// Return to administrator menu
								else if (maintainOption == Quit) {
									System.out.println("\nReturn to menu\n");
								}

								else {
									System.out.println("\nInvalid Input!\n");
								}
							}
						}

						else if (adminOption == 4) {

						}

						else if (adminOption == MAINTAIN_COURSE) {
							// Maintain course (Option 5)
							// Kow Xing Rong
							int manageCourse = 0;

							while (manageCourse != Quit) {
								retrieveAllCourse(courseList);
								viewAllCourse(courseList);
								manageCourseMenu();
								manageCourse = Helper.readInt("Enter an option > ");
								if (manageCourse == Add) {
									Course course = inputCourse(courseList);
									if (course != null) {
										TuitionManagement.addCourse(courseList, course);
										System.out.println("Course added.");
									}
								} else if (manageCourse == Update) {
									Course Ncourse = inputUpdateCourse(courseList);
									if (Ncourse != null) {
										updateCourse(courseList, Ncourse);
										System.out.println("Course updated.");
									}
								} else if (manageCourse == Delete) {
									TuitionManagement.setHeader("DELETE COURSE");
									String courseId = Helper.readString("Enter course id to delete course > ");
									deleteCourse(courseList, courseId);

								} else if (manageCourse == Quit) {
									System.out.println("\nReturn to menu\n");

								} else {
									System.out.println("Invalid option");
								}
							}
						}

						else if (adminOption == 7) {

						}

						else if (adminOption == 8) {

						}

						else if (adminOption == 9) {

						}

						else if (adminOption == 10) {
							System.out.println("\nReturn to login\n");
						} else {
							System.out.println("\nInvalid option!\n");
						}
					}
				}
			}

			// Teacher login
			else if (loginOption == 2) {
				// Validate teacher credentials
				Account teachLoginAcct = validateTeacher(accountList);

				if (teachLoginAcct != null) {
					int teachOption = 0;

					// Teacher menu
					while (teachOption != 3) {
						teacherMenu();
						teachOption = Helper.readInt("Enter an option > ");

						if (teachOption == 1) {

						}

						else if (teachOption == 2) {

						}

						else if (teachOption == 3) {
							System.out.println("\nReturn to login\n");
						} else {
							System.out.println("\nInvalid option!\n");
						}
					}
				}
			}

			// Student login
			else if (loginOption == 3) {
				// Validate student credentials
				Account studLoginAcct = validateStudent(accountList);

				if (studLoginAcct != null) {
					int studOption = 0;

					// Administrator menu
					while (studOption != 2) {
						studentMenu();
						studOption = Helper.readInt("Enter an option > ");

						if (studOption == 1) {

						}

						else if (studOption == 2) {
							System.out.println("\nReturn to login\n");
						} else {
							System.out.println("\nInvalid option!\n");
						}
					}
				}
			}

			else if (loginOption == 4) {
				System.out.println("\nSee you again\n");
			} else {
				System.out.println("\nInvalid option!\n");
			}
		}
	}

	public static void setHeader(String header) {
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

	// ========Teacher Menu========
	public static void teacherMenu() {
		TuitionManagement.setHeader("Teacher Menu");
		System.out.println("1. View personal information");
		System.out.println("2. View assigned course");
		System.out.println("3. Return");
		Helper.line(80, "-");
	}

	// ========Student Menu========
	public static void studentMenu() {
		TuitionManagement.setHeader("Student Menu");
		System.out.println("1. View personal information");
		System.out.println("2. Return");
		Helper.line(80, "-");
	}

	// ========Maintain course menu========
	public static void manageCourseMenu() {
		TuitionManagement.setHeader("MAINTAIN COURSE");
		System.out.println("1. Add a new course");
		System.out.println("2. Update a course");
		System.out.println("3. Delete an existing course");
		System.out.println("4. Return to menu");
	}

	// ========Administrator login validation========
	private static Account validateAdmin(ArrayList<Account> accountList) {

		int inputUserID = Helper.readInt("Enter Admin user ID > ");
		String inputPassword = Helper.readString("Enter Admin password > ");

		for (Account acc : accountList) {
			if (acc.getRole().equalsIgnoreCase("Admin") && acc.validateAcc(inputUserID, inputPassword)) {
				// Store administrator account
				System.out.println("\nLogin successful.\n");
				return acc;
			}
		}

		System.out.println("\nIncorrect user ID or password\n");
		return null;
	}

	// ========Teacher login validation========
	private static Account validateTeacher(ArrayList<Account> accountList) {
		int inputUserID = Helper.readInt("Enter Teacher user ID > ");
		String inputPassword = Helper.readString("Enter Teacher password > ");

		for (Account acc : accountList) {
			if (acc.getRole().equalsIgnoreCase("Teacher") && acc.validateAcc(inputUserID, inputPassword)) {
				// Store teacher account
				System.out.println("\nLogin successful.\n");
				return acc;
			}
		}

		System.out.println("\nIncorrect user ID or password\n");
		return null;
	}

	// ========Student login validation========
	private static Account validateStudent(ArrayList<Account> accountList) {
		int inputUserID = Helper.readInt("Enter Student user ID > ");
		String inputPassword = Helper.readString("Enter Student password > ");

		for (Account acc : accountList) {
			if (acc.validateAcc(inputUserID, inputPassword)) {
				// Store student account
				System.out.println("\nLogin successful.\n");
				return acc;
			}
		}

		System.out.println("Incorrect user ID or password\n");
		return null;
	}

	// ========Administrator functions========

	// ========Maintain menu========
	public static void maintainMenu() {
		TuitionManagement.setHeader("Maintain options");
		System.out.println("1. Add account");
		System.out.println("2. Update account");
		System.out.println("3. Delete account");
		System.out.println("4. Return to menu");
		Helper.line(80, "-");
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
	private static String retriveAllUsers(ArrayList<Account> accountList) {
		String output = "";

		for (int i = 0; i < accountList.size(); i++) {
			if ((accountList.get(i).getRole()).equalsIgnoreCase("Admin")) {
				String accInfo = accountList.get(i).toString();

				output += String.format("%-84s\n", accInfo);
			}
		}
		return output;
	}

	private static void viewAdminAcc(ArrayList<Account> accountList) {
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
	public static void deleteAdmin(ArrayList<Account> accountList) {
		// Check if account exist
		boolean adminAccFound = false;

		int userID = Helper.readInt("Enter administrator user id for delete > ");

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
	private static String retriveAllTeachers(ArrayList<Account> accountList) {
		String output = "";

		for (int i = 0; i < accountList.size(); i++) {
			if ((accountList.get(i).getRole()).equalsIgnoreCase("Teacher")) {
				String accInfo = accountList.get(i).toString();

				output += String.format("%-84s\n", accInfo);
			}
		}
		return output;
	}

	private static void viewTeachAcc(ArrayList<Account> accountList) {
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
	private static String retriveAllStudents(ArrayList<Account> accountList) {
		String output = "";
		for (int i = 0; i < accountList.size(); i++) {
			if ((accountList.get(i).getRole()).equalsIgnoreCase("Student")) {
				String accInfo = accountList.get(i).toString();

				output += String.format("%-84s\n", accInfo);
			}
		}
		return output;
	}

	private static void viewStudentAcc(ArrayList<Account> accountList) {
		TuitionManagement.setHeader("Student accounts");

		String output = String.format("%s %s %s %s %s\n", "Name", "User ID", "Email", "Mobile Num", "Password");

		output += retriveAllStudents(accountList);
		System.out.println(output);
	}

	// ========Administrator Option 3: Maintain Student Account (Add)============
	// add student account (Admin)
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

	// ========Administrator Option 5: Maintain courses (View)========
	public static String retrieveAllCourse(ArrayList<Course> courseList) {
		String output = "";

		for (int i = 0; i < courseList.size(); i++) {

			String description = courseList.get(i).toString();

			output += String.format("%-99s\n", description);

		}
		return output;
	}

	public static void viewAllCourse(ArrayList<Course> courseList) {
		TuitionManagement.setHeader("COURSE LIST");
		String output = String.format("%-10s %-25s %-40s %-10s %-10s\n", "COURSE ID", "COURSE NAME", "DESCRIPTION",
				"DURATION", "MONTHLY COST");
		output += retrieveAllCourse(courseList);
		System.out.println(output);
	}

	// ========Administrator Option 5: Maintain courses (Add)========
	public static Course inputCourse(ArrayList<Course> courseList) {
		TuitionManagement.setHeader("ADD COURSE");
		String id = Helper.readString("Enter course id > ");

		for (Course c : courseList) {
			if (c.getCid().equalsIgnoreCase(id)) {
				System.out.println("Course ID " + id + " already exists.");
				return null;
			}
		}

		String name = Helper.readString("Enter course name > ");
		String description = Helper.readString("Enter description > ");
		String duration = Helper.readString("Enter duration > ");
		double cost = Helper.readInt("Enter price > ");

		Course course = new Course(id, name, description, duration, cost);
		return course;

	}

	public static void addCourse(ArrayList<Course> courseList, Course course) {
		Course item;
		for (int i = 0; i < courseList.size(); i++) {
			item = courseList.get(i);
			String id = item.getCid();
			if (id.equalsIgnoreCase(course.getCid()))
				return;
		}
		if ((course.getCid().isEmpty()) || (course.getDescription().isEmpty())) {
			return;
		}

		courseList.add(course);

	}

	// ========Administrator Option 5: Maintain courses (Update)========
	public static Course inputUpdateCourse(ArrayList<Course> courseList) {
		String courseId = Helper.readString("Enter course id to update course > ");

		for (Course course : courseList) {
			if (course.getCid().equalsIgnoreCase(courseId)) {
				String Nname = Helper.readString("Enter updated course name > ");
				String Ndescription = Helper.readString("Enter updated description > ");
				String Nduration = Helper.readString("Enter updated duration > ");
				double Ncost = Helper.readDouble("Enter updated cost > ");

				Course Ncourse = new Course(courseId, Nname, Ndescription, Nduration, Ncost);
				return Ncourse;
			}
		}

		System.out.println("Course ID " + courseId + " not found.");
		return null;
	}

	public static void updateCourse(ArrayList<Course> courseList, Course Ncourse) {
		for (Course course : courseList) {

			if (course.getCid().equalsIgnoreCase(Ncourse.getCid())) {
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
}
