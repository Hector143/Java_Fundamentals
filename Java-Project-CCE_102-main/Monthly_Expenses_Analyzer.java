package wayinternet;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

public class Monthly_Expenses_Analyzer{

	public static void main(String[] args) {
		String data = "";
		Scanner scan = new Scanner(System.in);
		File file = new File("monthly_expenses.txt");
		System.out.print("How many expenses entries? ");
		int num = scan.nextInt();
		scan.nextLine();
		System.out.print("What is your target monthly budget: ");
		double budget = scan.nextDouble();
		scan.nextLine();
		initFile(file);
		
		double[] read = readExpenses(scan, budget, num);
		for (int i = 0; i < read.length; i++) {
			data += "Expense " + (i+1) + ": " + String.format("%.1f%n", read[i]);
		}
		
		double total = computeTotal(read);
		double average = computeAverage(read);
		
		data += "\n" + buildSummaryLine(total, average, budget);
		System.out.println("\n" + buildSummaryLine(total, average, budget));
		saveExpenseReport(file, data);
		scan.close();
	}
	
	public static void initFile(File file) {
		try {
			file.createNewFile();
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
	}
	
	public static double[] readExpenses(Scanner scan, double budget, int n) {
		double[] expenses = new double[n]; 
		for (int i = 0; i < expenses.length; i++) {
			System.out.print("Expenses " + (i+1) + ": ");
			expenses[i] = scan.nextDouble();
			scan.nextLine();
		}
		return expenses;
	}
	
	public static double computeTotal(double[] expenses) {
		double total = 0;
		for(int i = 0; i < expenses.length; i++) {
			total += expenses[i];
		}
		return total;
	}
	
	public static double computeAverage(double[] expenses) {
		double avg = 0;
		for(int i = 0; i < expenses.length; i++) {
			avg += expenses[i];
		}
		return avg / expenses.length;
	}
	
	public static String buildSummaryLine(double total, double average, double budget) {
		String data = "";
		double percentUsed = (total / budget) * 100;
		if (percentUsed > 100) {
			data += String.format("Total = %.1f, Average = %.1f, %.1f%% of budget, Status = Over Budget%n", total, average, percentUsed);
		} else {
			data += String.format("Total = %.1f, Average = %.1f, %.1f%% of budget, Status = Within Budget%n", total, average, percentUsed);
		}
		return data;
	}
	public static void saveExpenseReport(File file, String report) {
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.write(report);
			writer.close();
			System.out.println("\nSaved report to monthly_expenses.txt");
		} catch (IOException e) {
			System.out.println("Something went wrong!");
		} 
	}
	
	

}