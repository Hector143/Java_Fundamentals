package Second_Lab_Exam_Preparation.Model;

public class Asset {
	private String id;
	private String name;
	private String category;
	private String purchaseDate;
	private String status;
	private String loc;
	private double cost;
	private String descript;
	
	public Asset(String id,
	String name,
	String category,
	String purchaseDate,
	String status,
	String loc,
	double cost,
	String descript) {
		setId(id);
		setName(name);
		setCategory(category);
		setPurchaseDate(purchaseDate);
		setStatus(status);
		setLoc(loc);
		setCost(cost);
		setDescript(descript);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String inUse) { 
		this.status = inUse; 
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}
	
	public String toFileString() {
		return id + "|" + name + "|" + category + "|" + purchaseDate + "|" +  status + "|" + loc + "|" + cost + "|" + descript;
	}
	
	public double calculateDepreciation() {
	    return cost * 0.10; 
	}
	
}
