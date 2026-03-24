package SecondLabExam2;

public class FullTimeEmployee extends Employee_M implements PayrollOperations{

	public FullTimeEmployee(String id, String name, String department, double salary, double rate, double bonus,
			String status, String notes) {
		super(id, name, department, salary, rate, bonus, status, notes);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addEmployee() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployee() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double calculateNetSalary() {
		// TODO Auto-generated method stub
		return 0;
	}

}
