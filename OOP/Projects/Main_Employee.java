package Projects;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main_Employee {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("How many employees? ");
		int n = scan.nextInt(); scan.nextLine().trim();
		
		Employee[] employees = new Employee[n];
		
		for (int i = 0; i < n; i++) {
			System.out.println("\nEnter details for Employee " + (i+1) + ": ");
			System.out.print("Employee type (1 = Full-Time, 2 = Part-Time): ");
			int type = scan.nextInt(); scan.nextLine().trim();
			
			
			System.out.print("Name: ");
			String name = scan.nextLine();
			
			System.out.print("Hourly Rate: ");
			double rate = scan.nextDouble(); scan.nextLine().trim();
			
			System.out.print("Hours Worked: ");
			int hours = scan.nextInt(); scan.nextLine().trim();
			
			if (type == 1) {
				employees[i] = new FullTimeEmployee(name, rate, hours);
			} else {
				employees[i] = new PartTimeEmployee(name, rate, hours);
			}
			
		}
		System.out.println("\n--- Payroll Report ---");
		try {
			FileWriter fw = new FileWriter("payroll_report.txt", true);
			for (int i = 0; i < n; i++) {
				String text = "Employee " + (i+1) + ": " + employees[i].getName() + " - " + employees[i].getEmployeeType() + " - Salary: ₱" + employees[i].calculateSalary(); 
				System.out.println(text);
				fw.write(text + "\n");
			}
			System.out.println("\nSaved payroll report to payroll_report.txt");
			fw.close();
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		scan.close();
	}

}
