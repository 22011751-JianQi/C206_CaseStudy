

public class FeeDetails extends Account{
	private String paymentStatus; 
	private double price;
	private String dueDate;
	private String type;
	
	public FeeDetails(int userID, String type, double price, String dueDate, String paymentStatus) 
	{
		super(userID);
		this.type = type;
		this.price = price;
		this.dueDate = dueDate;
		this.paymentStatus = paymentStatus;
	}

	public FeeDetails(int userID, String type, double price, String dueDate) 
	{
		super(userID);
		this.type = type;
		this.price = price;
		this.dueDate = dueDate;
		this.paymentStatus = "Pending";
	}

	public String getType() 
	{
		return type;
	}

	public void setType(String type) 
	{
		this.type = type;
	}

	public double getPrice() 
	{
		return price;
	}

	public void setPrice(double price) 
	{
		this.price = price;
	}

	public String getDueDate() 
	{
		return dueDate;
	}

	public void setDueDate(String dueDate) 
	{
		this.dueDate = dueDate;
	}
	
	public String getPaymentStatus()
	{
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) 
	{
		this.paymentStatus = paymentStatus;
	}
	
	public String feeString()
	{
		String feeInfo = String.format("%-20s $%-14.2f %-15s %-20s\n", type, price, dueDate, paymentStatus);
		return feeInfo;
	}
}
