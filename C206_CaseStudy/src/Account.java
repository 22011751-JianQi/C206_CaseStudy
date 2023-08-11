
public class Account 
{
	private String name;
	private int userID;
	private String password;
	private String email;
	private int mobileNum;
	private String role;
	
	public Account(String name, int userID, String password, String email, int mobileNum, String role) 
	{
		this.name = name;
		this.userID = userID;
		this.password = password;
		this.email = email;
		this.mobileNum = mobileNum;
		this.role = role;
	}
	
	public Account(int userID) {
		this.userID = userID;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getUserID() 
	{
		return userID;
	}

	public void setUserID(int userID) 
	{
		this.userID = userID;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public int getMobileNum() 
	{
		return mobileNum;
	}

	public void setMobileNum(int mobileNum) 
	{
		this.mobileNum = mobileNum;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	public boolean validateAcc(int inputUserID, String inputPassword) 
	{
		if (inputUserID == userID && inputPassword.equals(password))
		{
			return true;
		}
		
		return false;
	}
	
	public String toString() 
	{
		String accInfo = String.format("%-10s %-15d %-25s %-12d %-10s", name, userID, email, mobileNum, password);	
		return accInfo;
	}
	
	public String display()
	{
		String personalInfo = String.format("UserID: %d\nName: %s\nEmail address: %s\nMobile number: %d\nPassword: %s\n", userID, name, email, mobileNum, password);
		return personalInfo;
	}
}
