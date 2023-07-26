
public class Account 
{
	private String name;
	private int userID;
	private String password;
	private String email;
	private int mobileNum;
	
	public Account(String name, int userID, String password, String email, int mobileNum) 
	{
		this.name = name;
		this.userID = userID;
		this.password = password;
		this.email = email;
		this.mobileNum = mobileNum;
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

	public boolean validateAcc(int inputUserID, String inputPassword) 
	{
		if (inputUserID == userID && inputPassword.equals(password))
		{
			return true;
		}
		
		return false;
	}
}
