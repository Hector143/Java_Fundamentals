package Projects_FileHandling;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Restaurant_Order_Analyzer {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		File file = new File("order_report.txt");
		initFile(file);
		
		String report = "";
		double[] inputOrder = inputOrders(scan);

		for (int i = 0; i < inputOrder.length; i++) {
			String classify = classify(inputOrder[i]);
			report += String.format("Order %d: ₱%.2f – %s%n", (i+1), inputOrder[i], classify);
		}
		System.out.println(report);
		saveToFile(file,report);
		scan.close();
	}
	
	public static void initFile(File file) {
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			System.err.println("Something went wrong!");
		}
	}
	
	public static double[] inputOrders(Scanner scan) {
		System.out.print("How many orders today? ");
		int num = scan.nextInt();
		scan.nextLine();
		
		System.out.println();
		double[] amount = new double[num];
		for (int i = 0; i < amount.length; i++) {
			System.out.print("Enter amount for Order "+ (i+1) + ": ");
			amount[i] = scan.nextDouble();
			scan.nextLine();
		}
		System.out.println();
		return amount;
	}
	
	public static String classify(double amount) {
		if (amount >= 1000) {
			return "Premium Order";
		} else if (amount >= 300) {
			return "Standard Order";
		} else {
			return "Light Order";
		}
	}
	
	public static void saveToFile(File file, String report) {
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.write(report);
			writer.close();
			System.out.println("\nSaved to order_report.txt");
		} catch (Exception e) {
			System.err.println("Something went wrong!");
		}
	}
}
