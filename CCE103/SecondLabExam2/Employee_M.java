package SecondLabExam2;

public class Employee_M {
	private String id;
	private String name;
	private String department;
	private double salary;
	private double rate;
	private double bonus;
	private String status;
	private String notes;
	
	public Employee_M(String id, String name, String department, double salary, double rate, double bonus,
			String status, String notes) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.rate = rate;
		this.bonus = bonus;
		this.status = status;
		this.notes = notes;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String toFileString() {
		return id + "|" + name + "|" +
				department + "|" + salary + "|" +
				rate + "|" + bonus + "|" +
				status + "|" + notes;
	}
	
	
}
