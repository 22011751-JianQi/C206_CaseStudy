import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class TuitionManagement {
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
	private static final int View_Fees_Collection = 7;
	private static final int View_Student_Performance = 8;

	// ========Teacher menu options========

	// ========Student menu options========
	private static final int View_Personal_Information = 1;
	private static final int Student_Option_Quit = 2;

	private static final int View_Personal_Fees = 1;
	private static final int Update_Personal_Information = 2;
	private static final int View_Personal_Attendance = 3;
	private static final int Maintain_Personal_Enrollment = 4;
	private static final int Retrun_To_Menu1 = 5;

	// ========Maintain menu options========
	private static final int Quit = 4;
	private static final int Add = 1;
	private static final int Update = 2;
	private static final int Delete = 3;

	private static final String Course_Pattern = "^[A-Z]\\d{3}$";

	public static void main(String[] args) {
		ArrayList<Account> accountList = new ArrayList<Account>();

		accountList.add(new Account("Admin1", 11111111, "12345", "Admin1@gmail.com", 11000000, "Admin"));

		accountList.add(new Account("Teacher1", 33333333, "12345", "Teacher1@gmail.com", 12000000, "Teacher"));
		accountList.add(new Account("Teacher2", 44444444, "12345", "Teacher2@gmail.com", 14000000, "Teacher"));

		accountList.add(new Account("Student1", 55555555, "12345", "Student1@gmail.com", 13000000, "Student"));

		ArrayList<Course> courseList = new ArrayList<Course>();

		courseList.add(new Course(33333333,"C001", "Secondary 2 English", "Enhance student's English language.", 2.30, 230.00, 30));
		courseList.add(new Course(44444444, "C002", "Secondary 4 Geography", "Enhance student's Geography.", 4, 260.00, 20));

		ArrayList<FeeDetails> feeList = new ArrayList<FeeDetails>();

		FeeDetails s1 = new FeeDetails(55555555, "Tuition", 2000, "20/10/2023", "Pending");
		feeList.add(s1);

		int loginOption = 0;

		int adminOption = 0;

		int teachOption = 0;
		int teachOption2 = 0;

		int studOption = 0;
		int studOption2 = 0;

		int maintainOption = 0;

		// ========Login Menu========
		while (loginOption != Login_Option_Quit) {
			loginMenu();
			loginOption = Helper.readInt("Enter an option > ");

			// ========Administrator Login========
			if (loginOption == Login_Option_Admin) {
				// ========Validate administrator credentials========
				Account adminLoginAcct = validateAdmin(accountList);

				if (adminLoginAcct != null) {

					// ========Administrator menu========
					while (adminOption != Admin_Option_Quit) {
						adminMenu();
						adminOption = Helper.readInt("Enter an option > ");

						// ========Add new Administrator========
						if (adminOption == Maintain_Admin_Option) {
							// ========Maintain administrator account========
							TuitionManagement.viewAdminAcc(accountList);

							while (maintainOption != Quit) {
								TuitionManagement.maintainMenu();
								maintainOption = Helper.readInt("Enter an Option > ");

								// ========Add administrator account========
								if (maintainOption == Add) {
									Account acc = TuitionManagement.inputAccount();
									TuitionManagement.addAdmin(accountList, acc);
									TuitionManagement.viewAdminAcc(accountList);
								}

								// ========Update administrator account========
								else if (maintainOption == Update) {
									TuitionManagement.updateAdmin(accountList);
									TuitionManagement.viewAdminAcc(accountList);
								}

								// ========Delete administrator account========
								else if (maintainOption == Delete) {
									TuitionManagement.deleteAdmin(accountList);
									TuitionManagement.viewAdminAcc(accountList);
								}

								// ========Return to administrator menu========
								else if (maintainOption == Quit) {
									System.out.println("\nReturn to menu\n");
								}

								else {
									System.out.println("\nInvalid Input!\n");
								}

							}

						}

						else if (adminOption == Maintain_Teach_Option) {
							// ========Maintain teacher account========
							TuitionManagement.viewTeachAcc(accountList);

							while (maintainOption != Quit) {
								TuitionManagement.maintainMenu();
								maintainOption = Helper.readInt("Enter an Option > ");

								// ========Add teacher account========
								if (maintainOption == Add) {
									Account acc = TuitionManagement.inputAccount();
									TuitionManagement.addTeacher(accountList, acc);
									TuitionManagement.viewTeachAcc(accountList);
								}

								// ========Update teacher account========
								else if (maintainOption == Update) {
									TuitionManagement.updateTeacher(accountList);
									TuitionManagement.viewTeachAcc(accountList);
								}

								// ========Delete teacher account========
								else if (maintainOption == Delete) {
									TuitionManagement.deleteTeacher(accountList);
									TuitionManagement.viewTeachAcc(accountList);
								}

								// ========Return to administrator menu========
								else if (maintainOption == Quit) {
									System.out.println("\nReturn to menu\n");
								}

								else {
									System.out.println("\nInvalid Input!\n");
								}
							}
						}

						else if (adminOption == Maintain_Stud_Option) {
							// ========Maintain Student account========

							while (maintainOption != Quit) {
								retrieveAllCourse(courseList);
								viewAllCourse(courseList);
								TuitionManagement.maintainMenu();
								maintainOption = Helper.readInt("Enter an Option > ");

								// ========Add Student account========
								if (maintainOption == Add) {
									Account acc = TuitionManagement.inputAccount();
									TuitionManagement.addStudent(accountList, acc);
									TuitionManagement.viewStudentAcc(accountList);
								}

								// ========Update Student account========
								else if (maintainOption == Update) {
									TuitionManagement.updateStudent(accountList);
									TuitionManagement.viewStudentAcc(accountList);
								}

								// ========Delete Student account========
								else if (maintainOption == Delete) {
									TuitionManagement.deleteStudent(accountList);
									TuitionManagement.viewStudentAcc(accountList);
								}

								// ========Return to administrator menu========
								else if (maintainOption == Quit) {
									System.out.println("\nReturn to menu\n");
								}

								else {
									System.out.println("\nInvalid Input!\n");
								}
							}
						}

						else if (adminOption == Maintain_Fees_Option) {
							viewAllFee(feeList);

							while (maintainOption != Quit) {
								feeMenu();
								maintainOption = Helper.readInt("Enter an Option > ");

								// ========Add Fee========
								if (maintainOption == Add) {

								}

								// ========Update Fee========
								else if (maintainOption == Update) {

								}

								// DeleteFee
								else if (maintainOption == Delete) {

								}
							}

						}

						// ========Maintain course========
						else if (adminOption == Maintain_Course_Option) {
							// Maintain course (Option 5)
							// Kow Xing Rong

							while (maintainOption != Quit) {
								viewAllCourse(courseList);
								maintainCourseMenu();
								maintainOption = Helper.readInt("Enter an option > ");

								// ========Add course========
								if (maintainOption == Add) {
									Course newCourse = inputCourse(courseList);
									if (newCourse != null) {
										addCourse(accountList, courseList, newCourse);
										
									}
								}

								// ========Update course========
								else if (maintainOption == Update) {
									Course Ncourse = inputUpdateCourse(courseList);
									if (Ncourse != null) {
										updateCourse(accountList, courseList, Ncourse);
										System.out.println("Course updated.");
									}
								}

								// ========Delete course========
								else if (maintainOption == Delete) {
									TuitionManagement.setHeader("DELETE COURSE");
									String courseId = Helper.readString("Enter course id to delete course > ");
									deleteCourse(courseList, courseId);

								}

								else if (maintainOption == Quit) {
									System.out.println("\nReturn to menu\n");

								} else {
									System.out.println("Invalid option");
								}
							}
						}

						// ========View fees collection========
						else if (adminOption == View_Fees_Collection) {

						}

						// ========View student performance========
						else if (adminOption == View_Student_Performance) {

						}

						else if (adminOption == 9) {

						}

						else if (adminOption == Admin_Option_Quit) {
							System.out.println("\nReturn to login\n");
						} else {
							System.out.println("\nInvalid option!\n");
						}
					}
				}
			}

			// ========Teacher login========
			else if (loginOption == Login_Option_Teacher) {
				// Validate teacher credentials
				Account teachLoginAcct = validateTeacher(accountList);

				if (teachLoginAcct != null) {

					// ========Teacher menu========
					while (teachOption != 3) {
						teacherMenu();
						teachOption = Helper.readInt("Enter an option > ");

						// ========View personal info========
						if (teachOption == 1) {
							viewInfo(teachLoginAcct);

							while (teachOption2 != 2) {
								teacherMenu2();
								teachOption2 = Helper.readInt("Enter an Option > ");

								// ========Update personal information========
								if (teachOption2 == 1) {
									updatePersonal(accountList, teachLoginAcct);
									viewInfo(teachLoginAcct);
								}

								else if (teachOption2 == 2) {
									System.out.println("\nReturn to Menu\n");
								} else {
									System.out.println("\nInvalid option!\n");
								}
							}
						}

						//========View assigned course========
						else if (teachOption == 2)
						{
							viewAssignedCourse(courseList, teachLoginAcct);
						}

						else if (teachOption == 3) {
							System.out.println("\nReturn to login\n");
						} else {
							System.out.println("\nInvalid option!\n");
						}
					}
				}
			}

			// ========Student login========
			else if (loginOption == Login_Option_Student) {
				// Validate student credentials
				Account studLoginAcct = validateStudent(accountList);

				if (studLoginAcct != null) {

					// ========student menu========
					while (studOption != 2) {
						studentMenu();
						studOption = Helper.readInt("Enter an option > ");

						// ========View personal information
						if (studOption == 1) {
							TuitionManagement.viewInfo(studLoginAcct);

							while (studOption2 != Retrun_To_Menu1) {
								studentMenu2();
								studOption2 = Helper.readInt("Enter an Option > ");

								// ========View personal fees========
								if (studOption2 == View_Personal_Fees) {
									viewPersonalFees(feeList, studLoginAcct);
								}

								// ========Update personal information========
								else if (studOption2 == Update_Personal_Information) {

									updatePersonal(accountList, studLoginAcct);
									viewInfo(studLoginAcct);
								}

								else if (studOption2 == View_Personal_Attendance) {

								}

								else if (studOption2 == Maintain_Personal_Enrollment) {

								}

								else if (studOption2 == Retrun_To_Menu1) {
									System.out.println("\nReturn to Menu\n");
								}

								else {
									System.out.println("\nInvalid option!\n");
								}
							}
						}

						else if (studOption == 2) {
							System.out.println("\nReturn to login\n");
						} else {
							System.out.println("\nInvalid option!\n");
						}
					}
				}
			}

			else if (loginOption == Login_Option_Quit) {
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

	public static void teacherMenu2() {
		TuitionManagement.setHeader("Teacher Menu");
		System.out.println("1. Update personal information");
		System.out.println("2. Return");
	}

	// ========Student Menu========
	public static void studentMenu() {
		TuitionManagement.setHeader("Student Menu");
		System.out.println("1. View personal information");
		System.out.println("2. Return");
		Helper.line(80, "-");
	}

	// ========Student Menu 2========
	public static void studentMenu2() {
		TuitionManagement.setHeader("Student Menu");
		System.out.println("1. View fees");
		System.out.println("2. Update personal information");
		System.out.println("3. View attendance");
		System.out.println("4. Maintain enrollment");
		System.out.println("5. Return to menu");
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

	// ========Maintain fee menu========
	public static void feeMenu() {
		setHeader("Maintain fees");
		System.out.println("1. Add Fee");
		System.out.println("2. Update Fee");
		System.out.println("3. Delete Fee From Student");
		System.out.println("4. Quit");
	}

	public static void maintainErollmentMenu() {
		setHeader("Enrollment menu");
		System.out.println("1. Add enrollment");
		System.out.println("2. Update enrollment");
		System.out.println("3. Delete enrollment");
		System.out.println("4. Quit");
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

	// ========Display personal info (student/teacher)========
	private static void viewInfo(Account acc) {
		setHeader("Personal Information");

		String output = acc.display();
		System.out.println(output);
	}

	// ========Update personal info (student/teacher)========
	private static void updatePersonal(ArrayList<Account> accountList, Account acc) {
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
					if (existingAcc.getEmail().equalsIgnoreCase(email) || existingAcc.getMobileNum() == mobileNum) {
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

	// ========Administrator functions========

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

	// ========Administrator Option 4: Maintain Fees (View)========
	public static String retrieveAllFees(ArrayList<FeeDetails> feeList) {
		String output = "";
		for (int j = 0; j < feeList.size(); j++) {
			String feeInfo = feeList.get(j).feeString();

			output += String.format("%-15d %-69s\n", feeList.get(j).getUserID(), feeInfo);
		}
		return output;
	}

	public static void viewAllFee(ArrayList<FeeDetails> feeList) {
		setHeader("ALL FEE");
		String output = String.format("%-15s %-20s %-15s %-15s %-20s\n", "ID", "FEE TYPES", "AMOUNT", "DUE DATE",
				"PAYMENT STATUS");
		output += retrieveAllFees(feeList);
		System.out.println(output);
	}

	// ========Administrator Option 4: Maintain Fees (Add - Do after
	// enrollment)========

	// ========Administrator Option 4: Maintain Fees (Update)========

	// ========Administrator Option 4: Maintain Fees (Delete)========

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

	// ========Teacher Functions========

	// ========Teacher Option 1: View Personal information========

	//========Teacher Option 1: view assigned course========
		public static String retrieveAssignedCourse(ArrayList<Course> courseList, Account acc) 
		{
			String output = "";

			for (Course existingCourse : courseList) 
			{
				if(existingCourse.getUserID() == acc.getUserID())
				{
					output += existingCourse.courseDisplay();
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

	// ========Teacher Option 1: Maintain attendance========

	// ========Student Functions========

	// ========Student Option 1: View Student fees========
	private static String retrivePersonalFees(ArrayList<FeeDetails> feesList, Account acc) {
		setHeader("Personal Fees");
		String output = "";

		for (FeeDetails existingFees : feesList) {
			if (existingFees.getUserID() == acc.getUserID()) {
				if ((existingFees.getPaymentStatus()).equalsIgnoreCase("Pending")) {
					output += existingFees.feeString();
				}

				else {
					output = "No pending fees";
				}
			}
		}
		return output;
	}

	private static void viewPersonalFees(ArrayList<FeeDetails> feesList, Account acc) {
		setHeader("ALL FEE");
		String output = String.format("%-20s %-15s %-15s %-20s\n", "FEE TYPES", "AMOUNT", "DUE DATE", "PAYMENT STATUS");
		output += retrivePersonalFees(feesList, acc);
		System.out.println(output);
	}

	// ========Student Option 1: View student attendance========

	// ========Student Option 1: Maintain enrollment

}
