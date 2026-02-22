package OOP_Exercise_Problems;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Analyzer {
	
	public double[] inputPurchases() {
		Scanner scan = new Scanner(System.in);
		System.out.print("How many customers? ");
		int customers = scan.nextInt(); scan.nextLine().trim();
		
		double[] amounts = new double[customers];
		System.out.println("Enter purchase amounts for " + customers + " customers:");
		for (int i = 0;  i < amounts.length; i++) {
			System.out.print("Customer " + (i+1) + ": ");
			amounts[i] = scan.nextDouble(); scan.nextLine().trim();
		}
		scan.close();
		return amounts;
	}
	
	public String getCategory(double amount) {
		if (amount >= 5000) {
			return "VIP Customer";
		} else if (amount >= 1000) {
			return "Regular Customer";
		} else {
			return "Occasional Customer";
		}
	}
	
	public void saveToFile(String text) {
		try {
			FileWriter fw = new FileWriter("customer_report.txt", true);
			fw.write(text);
			fw.close();
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}
