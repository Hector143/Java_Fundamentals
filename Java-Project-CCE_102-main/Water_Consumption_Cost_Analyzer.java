package Projects_FileHandling;

import java.util.Scanner;
import java.io.FileWriter;

public class Water_Consumption_Cost_Analyzer {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String reportText = "";
		double[] inputConsump = readConsumption(scan);
		System.out.println();
		for (int i = 0; i < inputConsump.length; i++) {
			reportText += String.format("Household %d: %.1f m³, Cost = %.1f%n", (i+1), inputConsump[i], computeCost(inputConsump[i]));
		}
		System.out.print(reportText);
		saveWaterReport(reportText);
		scan.close();
	}
	public static double[] readConsumption(Scanner scan) {
		System.out.print("How many households? ");
		int num = scan.nextInt();
		scan.nextLine();
		
		double[] consumption = new double[num];
		for (int i = 0; i < consumption.length; i++) {
			System.out.print("Household " + (i+1) + " consumption (m³): ");
			consumption[i] = scan.nextDouble();
			scan.nextLine();
		}
		return consumption;
	}
	
	public static double computeCost(double cubicMeters) {
		double compute = 0;
		if (cubicMeters > 20) {
			compute = 20 * 25.0;
			compute += (cubicMeters - 20) * 30.0;
		} else {
			compute += cubicMeters * 25.0;
			return compute;
		}
		return compute;
	}
	
	public static void saveWaterReport(String reportText) {
		try {
			FileWriter writer = new FileWriter("water_usage_report.txt", true);
			writer.write(reportText);
			writer.close();
			System.out.println("\nSaved report to water_usage_report.txt");
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
	}
}
