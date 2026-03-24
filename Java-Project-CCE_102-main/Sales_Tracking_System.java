package Projects_FileHandling;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Sales_Tracking_System {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of agents: ");
		int num = scan.nextInt();
		scan.nextLine();
		
		String[] agents = new String[num];
		double[] sales = new double[num];
		for (int i = 0; i < num; i++) {
			System.out.print("\nEnter agent " +(i+1) +" name: ");
			agents[i] = scan.nextLine();
			System.out.print("Enter total sales: ");
			sales[i] = scan.nextDouble();
			scan.nextLine();
		}
		
		displaySales(agents, sales);
		scan.close();
		
	}
	
	public static void displaySales(String agents[], double sales[]) {
		String contain = "Sales Report:\n\n";
		System.out.println("\n\nSales Report:");
		for (int i = 0; i < sales.length; i++) {
			contain += agents[i] + " - " + sales[i] + "\n";
			System.out.println(agents[i] + " - " + sales[i]);
		}
		System.out.println("\nHighest Sales: " + highestSales(sales));
		System.out.println("Met Quota: " + countMetQuota(sales));
		System.out.println("Below Quota: " + countBelowQuota(sales));
		contain += "\nHighest Sales: " + highestSales(sales) + "\n";
		contain += "Met Quota: " + countMetQuota(sales) + "\n";
		contain += "Below Quota: " + countBelowQuota(sales) + "\n\n\n";
		
		saveToFile(contain);
	}
	
	public static double highestSales(double sales[]) {
		double high = 0;
		for (int i = 0; i < sales.length; i++) {
			if (sales[i] > high) {
				high = sales[i];
			}
		}
		return high;
	}
	
	public static int countMetQuota(double sales[]) {
		int metCount = 0;
		for (int i = 0; i < sales.length; i++) {
			if (sales[i] >= 50000) {
				metCount++;
			}
		}
		return metCount;
	}
	
	public static int countBelowQuota(double sales[]) {
		int belowCount = 0;
		for (int i = 0; i < sales.length; i++) {
			if (sales[i] < 50000) {
				belowCount++;
			}
		}
		return belowCount;
	}
	
	public static void saveToFile(String contain) {
		try {
			FileWriter writer = new FileWriter("SalesReport.txt", true);
			writer.write(contain);
			writer.close();
			System.out.println("\nFile has been saved to SalesReport.txt");
		} catch (IOException e) {
			System.out.println("Error " + e);
		}
	}

}
