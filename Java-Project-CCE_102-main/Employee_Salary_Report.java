package Projects_FileHandling;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Employee_Salary_Report {
	static String[] names;
	static int[] ids;
	static double[] salaries;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		final String filePath = "salary_report.txt";
		String report = "";
		File file = new File(filePath);
		
		try {
			file.createNewFile();
			if (file.exists()) {
				System.out.println("File Created Successfully.");
			}
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
		
		System.out.print("How many employees? ");
		int number = scan.nextInt();
		scan.nextLine();
		
		names = new String[number];
		ids = new int[number];
		salaries = new double[number];
		
		
		String employeeListing = inputEmployees(scan, number);
		double total = calculateTotalSalary(salaries);
		double avg = calculateAverageSalary(salaries);
		double high = findHighestSalary(salaries);
		double low = findLowestSalary(salaries);
		
		report += "Employee Salary Report\n";
		report += "----------------------\n";
		report += employeeListing + "\n";
		report += "Total Salary: " + total + "\n";
		report += "Average Salary: " + avg + "\n";
		report += "Highest Salary: " + high + "\n";
		report += "Lowest Salary: " + low + "\n";
		
		writeReport(report, file);
		System.out.println("Salary report successfully created.");
		
		readReport(file);
		scan.close();
	}
	
	public static String inputEmployees(Scanner scan, int number) {
		String contain = "";
		for (int i = 0; i < number; i++) {
			System.out.print("Enter name: ");
			names[i] = scan.nextLine();
			System.out.print("Enter ID: ");
			ids[i] = scan.nextInt();
			System.out.print("Enter salary: ");
			salaries[i] = scan.nextDouble();
			scan.nextLine();
			System.out.println();
			contain += names[i] + " (" + ids[i] + "): " + salaries[i] + "\n";
			System.out.println();
		}
		
		return contain;
	}
	
	public static double calculateTotalSalary(double[] salaries) {
		double sum = 0;
		for (int i = 0; i < salaries.length; i++) {
			sum += salaries[i];
			
		}
		return sum;
	}
	
	public static double calculateAverageSalary(double[] salaries) {
		double average = calculateTotalSalary(salaries) / salaries.length;
		return average;
		
		 
	}
	
	public static double findHighestSalary(double[] salaries) {
		double largest = 0;
		for (int i = 0; i < salaries.length; i++) {
			if (salaries[i] > largest) {
				largest = salaries[i];
			}
		}
		
		return largest;
	}
	
	public static double findLowestSalary(double[] salaries) {
		double lowest = salaries[0];
		for (int i = 0; i < salaries.length; i++) {
			if (salaries[i] < lowest) {
				lowest = salaries[i];
			}
		}
		return lowest;
	}
	
	public static String writeReport(String report, File file) {
		
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(report);
			writer.close();
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
		return report;
	}
	
	public static void readReport(File file) {
		try (Scanner read = new Scanner(file)){
			while (read.hasNextLine()) {
				System.out.println(read.nextLine());
			}
			System.out.println("\n\nSaved report to salary_report.txt");
			read.close();
		} catch (Exception e) {
			System.out.println("Something Went Wrong");
			e.printStackTrace();
		}
	}

}

