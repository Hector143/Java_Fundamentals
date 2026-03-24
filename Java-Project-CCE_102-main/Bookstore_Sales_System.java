package Projects_FileHandling;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Bookstore_Sales_System {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		File file = new File("sales.txt");
		String data = "";
		initFile(file);
		System.out.print("Enter number of books sold: ");
		int num = scan.nextInt();
		scan.nextLine();
		double[] prices = new double[num];
		for (int i = 0; i < prices.length; i++) {
			prices[i] = scan.nextDouble();
			scan.next();
		}
		scan.nextLine();
		data += "--- BOOKSTORE DAILY SALES REPORT ---\n";
		data += "Total Books Processed: " + num + "\n";
		data += "Total Revenue: " + String.format("₱%.2f",totalRevenue(prices)) + "\n";
		data += "Highest Price: " + String.format("₱%.2f",mostExpensiveBook(prices)) + "\n";
		data += "Lowest Price: " + String.format("₱%.2f",cheapestBook(prices)) + "\n";
		data += "Premium Books (>1000): " + cheapestBook(prices) + "\n";
		data += "-------------------------------------\n";
		System.out.println(data);
		saveLog(file,data);
		scan.close();
	}
	
	public static void initFile(File file) {
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
	}
	
	public static double totalRevenue(double[] prices) {
		double total = 0;
		for (int i = 0; i < prices.length; i++) {
			total += prices[i];
		}
		return total;
	}
	
	public static double mostExpensiveBook(double[] prices) {
		double high = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] > high) {
				high = prices[i];
			}
		}
		return high;
	}
	
	public static double cheapestBook(double[] prices) {
		double low = prices[0];
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < low) {
				low = prices[i];
			}
		}
		return low;
	}
	
	public static int premiumBooksSold(double[] prices) {
		int count = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] >= 1000) {
				count++;
			}
		}
		return count;
	}
	
	public static void saveLog(File file, String data) {
		try {
			FileWriter writer = new FileWriter(file ,true);
			writer.write(data);
			writer.close();
		} catch (IOException e) {
			System.out.println("Something went wrong!");
		}
	}

}
