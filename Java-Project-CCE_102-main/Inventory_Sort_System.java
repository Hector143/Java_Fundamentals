package hey;

import java.util.Scanner;
import java.io.FileWriter;

public class Inventory_Sort_System {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		readInventory(scan);
		scan.close();
	}
	
	public static double[] readInventory(Scanner scan) {
		String contain = "";
		System.out.print("How many products are there? ");
		int num = scan.nextInt();
		scan.nextLine();
		
		String names[] = new String[num];
		double[] prices = new double[num];
		int[] quantities = new int[num];
		
		for (int i = 0; i < names.length; i++) {
			System.out.print("Enter product " + (i+1) + " name: ");
			names[i] = scan.nextLine();
			System.out.print("Enter product " + (i+1) + " price: ");
			prices[i] = scan.nextDouble();
			scan.nextLine();
			System.out.print("Enter product " + (i+1) + " quantity: ");
			quantities[i] = scan.nextInt();
			scan.nextLine();
			contain += String.format("Product %d: %s, Price = %.1f, Quantity = %d%n", (i+1),names[i],prices[i],quantities[i]);
		}
		
		double total = computeTotalValue(prices, quantities);
		double avg = computeAveragePrice(prices);
		int countLow = countLowStock(quantities);
		String text = buildSummaryLine(total,avg,countLow);
		contain += "\n" + text;
		System.out.println("\n"+ contain);
		saveToFile(contain);
		System.out.println("\nSaved report to inventory_report.txt");
		return prices;
	}
	
	public static double computeTotalValue(double[] prices, int[] quantities) {
		double sum = 0;
		for (int i = 0; i < prices.length; i++) {
			double compute = prices[i] * quantities[i];
			sum += compute;
		}
		return sum;
	}
	public static double computeAveragePrice(double[] prices) {
		double avg = 0;
		for (int i = 0; i < prices.length; i++) {
			avg += prices[i];
		}
		return avg / prices.length;
	}
	public static int countLowStock(int[] quantities) {
		int countLow = 0;
		for (int i = 0; i < quantities.length; i++) {
			if (quantities[i] <= 5) {
				countLow++;
			}
		}
		return countLow;
	}
	public static String buildSummaryLine(double totalValue, double averagePrice, int lowStockCount) {
		if (totalValue > 1000) {
			return String.format("Total inventory value = %.1f, Average price = %.3f, Low stock products = %d Status = Sufficient%n",totalValue,averagePrice,lowStockCount);
		} else {
			return String.format("Total inventory value = %.1f, Average price = %.3f, Low stock products = %d Status = Low Value%n",totalValue,averagePrice,lowStockCount);
		}
	}
	
	public static void saveToFile(String text) {
		try {
			FileWriter fw = new FileWriter("inventory_report.txt", true);
			fw.write(text);
			fw.close();
		} catch (Exception e) {
			System.err.println("Something went wrong!");
		}
	}
}