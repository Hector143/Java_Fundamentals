package Projects_FileHandling;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Product_Inventory_Manager {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		File file = new File("Inventory_Report.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		inputProducts(scan);
		scan.close();

	}
	public static void inputProducts(Scanner scan) {
		System.out.print("Enter number of products: ");
		int num = scan.nextInt();
		scan.nextLine();
		
		String p[] = new String[num];
		double prices[] = new double[num];
		for (int i = 0; i < num; i++) {
			System.out.print("\nEnter product "+ (i+1) + " name: ");
			p[i] = scan.nextLine();
			System.out.print("Enter price: ");
			prices[i] = scan.nextDouble();
			scan.nextLine();
		}
		String contain = displayProducts(p, prices);
		double high = findHighest(prices);
		double low = findLowest(prices);
		double total = totalCost(prices);
		contain += "\nHighest Price: " + high + "\n";
		System.out.println("Highest Price: " + high);
		contain += "Lowest Price: " + low + "\n";
		System.out.println("Lowest Price: " + low);
		contain += "Total Cost: " + total + "\n"; 
		System.out.println("Total Cost: " + total);
		saveToFile(contain);
		
	}
	
	public static String displayProducts(String p[], double prices[]) {
		String contain = "Products and Prices\n\n";
		
		for (int i = 0; i < prices.length; i++) {
			contain += p[i] + " - " + prices[i] + "\n";
		}
		System.out.println(contain);
		return contain;
		
	}
	
	public static double findHighest(double prices[]) {
		double high = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] > high) {
				high = prices[i];
			}
		}
		return high;
	}
	
	public static double findLowest(double prices[]) {
		double low = prices[0];
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < low) {
				low = prices[i];
			}
		}
		return low;
	}
	
	public static double totalCost(double prices[]) {
		double total = 0;
		for (int i = 0; i < prices.length; i++) {
			total += prices[i];
		}
		return total;
	}
	
	public static void saveToFile(String text) {
		try {
			FileWriter writer = new FileWriter("Inventory_Report.txt", true);
			writer.write(text);
			writer.close();
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
	}

}
