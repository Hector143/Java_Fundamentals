package Projects_FileHandling;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;


public class Employee_Salary_Sorter {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		File file = new File("salary_report.txt");
		
		
		double[] salary = inputSalary(scan);
		String text = classifySalary(salary);
		try {
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("\nFile salary_report.txt Created.");
			}
				System.out.println("\nFile already exists.");
		} catch (Exception e) {
			System.out.println("\nSomething went wrong!");
		}
		System.out.println("\nReading and saving the report...\n");
		saveToFile(file,text);
		readFile(file);
		System.out.println("\n\nSaved report to salary_report.txt");
		
		scan.close();
	}
	
	public static double[] inputSalary(Scanner scan) {
		System.out.print("How many employees? ");
		int num = scan.nextInt();
		scan.nextLine();
		double[] salary = new double[num];
		System.out.println("Enter salary for " + num + " employees: ");
		for (int i = 0; i < salary.length; i++) {
			System.out.print("Employee " + (i+1) + " salary: ");
			salary[i] = scan.nextDouble();
			scan.nextLine();
		}
		
		return salary;
		
	}
	public static String classifySalary(double[] salary) {
		String cat = "";
		for (int i = 0; i < salary.length; i++) {
			if (salary[i] > 30000) {
				cat += "Employee " + (i+1) +": " + String.format("₱%.1f", salary[i])+" - High Income" + "\n";	
			} else if (salary[i] >= 15000) {
				cat += "Employee " + (i+1) +": " + String.format("₱%.1f", salary[i])+" - Middle Income" + "\n";
			} else {
				cat += "Employee " + (i+1) +": " + String.format("₱%.1f", salary[i])+" - Low Income" + "\n";
			}
		}
		return cat;
	}
	
	public static void saveToFile(File file, String text) {
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.write(text);
			writer.close();
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
	}
	
	public static void readFile(File file) {
		try {
			Scanner read = new Scanner(file);
			while(read.hasNextLine()) {
				System.out.println(read.nextLine());
			}
			read.close();
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
	}
}
