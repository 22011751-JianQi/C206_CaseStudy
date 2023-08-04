
public class Course {
	private String Cid;
	private String Cname;
	private String description;
	private String duration;
	private double cost;
	
	public Course(String id, String name, String description, String duration, double cost) {
		this.Cid = id;
		this.Cname = name;
		this.description = description;
		this.duration = duration;
		this.cost = cost;
	}
	
	public String toString() {
		String courseInfo = String.format("%-10s %-25s %-40s %-10s %-10.2f",
				Cid,
				Cname,
			    description, 
			    duration,
			    cost);
		
		return courseInfo;
	}

	public String getCid() {
		return Cid;
	}

	public String getCname() {
		return Cname;
	}

	public void setCname(String cname) {
		Cname = cname;
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

	public String getDuration() {
		return duration;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	

}
