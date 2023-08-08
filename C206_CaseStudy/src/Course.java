
public class Course extends Account{
	private String cid;
	private String cname;
	private String description;
	private double duration;
	private double cost;
	private int size;
	
	public Course(int userID, String cid, String cname, String description, double duration, double cost, int size) {
		super(userID);
		this.cid = cid;
		this.cname = cname;
		this.description = description;
		this.duration = duration;
		this.cost = cost;
		this.size = size;
	}

	public String getCid() {
		return cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public double getDuration() {
		return duration;
	}
	
	public void setDuration(double duration) {
		this.duration = duration;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public String courseDisplay()
	{
		String courseInfo = String.format("%-20s %-25s %-40s %-10s %-10.2f",
				cid,
				cname,
			    description, 
			    duration,
			    cost);
		
		return courseInfo;
	}
}
