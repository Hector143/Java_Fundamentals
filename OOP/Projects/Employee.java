package Projects;

public abstract class Employee {
	private String name;
	private double hourlyRate;
	private int hoursWorked;
	
	public Employee(String name, double hourlyRate, int hoursWorked) {
		this.name = name;
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public int getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public abstract double calculateSalary();
	public abstract String getEmployeeType();
	
}

class FullTimeEmployee extends Employee {

	
	public FullTimeEmployee(String name, double hourlyRate, int hoursWorked) {
		super(name, hourlyRate, hoursWorked);
	}

	public double calculateSalary() {
		return getHourlyRate() * getHoursWorked();
	}

	@Override
	public String getEmployeeType() {
		return "Full-Time";
	}
	
}

class PartTimeEmployee extends Employee {
	
	public PartTimeEmployee(String name, double hourlyRate, int hoursWorked) {
		super(name, hourlyRate, hoursWorked);
	}

	public double calculateSalary() {
		return (getHourlyRate() * getHoursWorked()) * 0.8;
	}

	@Override
	public String getEmployeeType() {
		return "Part-Time";
	}
	
}
