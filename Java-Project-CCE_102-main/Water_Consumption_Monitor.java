package Projects_FileHandling;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Water_Consumption_Monitor {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		File file = new File("water_usage.txt");
		initFile(file);
		String contain = "";
		int[] inputs = inputUsage(scan);
		
		for (int i = 0; i < inputs.length; i++) {
			String getConsumpt = getConsumptionLevel(inputs[i]);
			contain += "Household " + (i+1) + ": " + inputs[i] + "L – " + getConsumpt + "\n";
		}
		System.out.print(contain);
		saveToFile(file, contain);
		System.out.println("Saved data to water_usage.txt");
		scan.close();
	}
	
	public static int[] inputUsage(Scanner scan) {
		System.out.print("How many households? ");
		int num = scan.nextInt();
		scan.nextLine();
		
		int[] liters = new int[num];
		System.out.println();
		for (int i = 0; i < liters.length; i++) {
			System.out.print("Enter liters consumed by Household " + (i+1) + ": ");
			liters[i] = scan.nextInt();
			scan.nextLine();
		}
		System.out.println();
		return liters;
	}
	
	public static String getConsumptionLevel(int liters) {
		if (liters > 500) {
			return "Excessive Use";
		} else if (liters >= 200) {
			return "Normal Use";
		} else {
			return "Low Use";
		}
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
	public static void saveToFile(File file, String data) {
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(data);
			writer.close();
		} catch (Exception e) {
			System.err.println("Something went wrong!");
		}
	}

}
