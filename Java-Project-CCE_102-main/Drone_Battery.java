package hey;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Drone_Battery {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		File file = new File("batter_report.txt");
		System.out.print("");
		initFile(file);
		String text = "";	
		double[] inputs = InputBatteryReadings(scan);
		for (int i = 0; i < inputs.length; i++) {
			String cat = categorizeChargeLevels(inputs[i]);
			text += String.format("Drone %d: %.1f%% - %s%n", (i+1), inputs[i], cat);
		}
		System.out.println("\n--- Report ---\n"+text);
		saveToFile(file, text);
		System.out.println("Data saved to battery_report.txt successfully.");
		
		scan.close();
	}
	
	public static double[] InputBatteryReadings(Scanner scan) {
		System.out.print("How many drones to monitor? ");
		int number = scan.nextInt();
		scan.nextLine();
		double[] drones = new double[number];
		for (int i = 0; i < drones.length; i++) {
			System.out.print("Enter battery level for Drone " + (i+1) + ": ");
			drones[i] = scan.nextDouble();
			scan.nextLine();
		}
		return drones;
	}
	
	
	public static String categorizeChargeLevels(double level) {
		if (level > 80) {
			return "Fully Charged";
		} else if (level >= 20) {
			return "Normal Operation";
		} else {
			return "Critical (Return to Base)";
		}
	}
	
	public static void initFile(File file) {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			System.err.println("Error " + e.getMessage());
		}
	}
	
	public static void saveToFile(File file, String text) {
		try {
			FileWriter fw = new FileWriter(file,true);
			fw.write(text);
			fw.close();
		} catch (Exception e) {
			System.err.println("Something went wrong!");
		}
	}

}
