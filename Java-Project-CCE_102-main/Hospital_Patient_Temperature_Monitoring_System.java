package hey;

import java.util.Scanner;
import java.io.FileWriter;

public class Hospital_Patient_Temperature_Monitoring_System {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String text = "";
		double[] inputTemps = inputTemperatures(scan);
		for (int i = 0; i < inputTemps.length; i++) {
			String getTemp = getCondition(inputTemps[i]);
			text += String.format("Patient %d: %.1f°C - %s%n", (i+1), inputTemps[i], getTemp);
			
		}
		int feverCount = countFever(inputTemps);
		int normalCount = countNormal(inputTemps);
		int hypothermiaCount = countHypothermia(inputTemps);
		text += "\nSummary:\n";
		text += "Fever Cases: " + feverCount + "\n";
		text += "Normal Cases: " + normalCount + "\n";
		text += "Hypothermia Cases: " + hypothermiaCount + "\n";
		System.out.println(text);
		System.out.println("Patient temperature report saved to patient_temperature_report.txt");
		saveToFile(text);
		scan.close();
	}
	
	public static double[] inputTemperatures(Scanner scan) {
		System.out.print("How many patients? ");
		int patients = scan.nextInt();
		scan.nextLine();
		
		double[] temps = new double[patients];
		System.out.println("Enter body temperatures: ");
		for (int i = 0; i < temps.length; i++) {
			System.out.print("Patient " + (i+1) + ": ");
			temps[i] = scan.nextDouble();
			scan.nextLine();
		}
		System.out.println();
		return temps;
	}
	
	public static String getCondition(double temp) {
		if (temp >= 38.0) {
			return "Fever";
		} else if (temp >= 36.5) {
			return "Normal";
		} else {
			return "Hypothermia";
		}
	}
	
	public static int countFever(double[] temps) {
		int count = 0;
		for (int i = 0; i < temps.length; i++) {
			if (temps[i] >= 38.0) {
				count++;
			}
		}
		return count;
	}
	
	public static int countNormal(double[] temps) {
		int count = 0;
		for (int i = 0; i < temps.length; i++) {
			if (temps[i] >= 36.5) {
				count++;
			}
		}
		return count;
	}
	
	public static int countHypothermia(double[] temps) {
		int count = 0;
		for (int i = 0; i < temps.length; i++) {
			if (temps[i] < 36.5) {
				count++;
			}
		}
		return count;
	}
	
	
	public static void saveToFile(String text) {
		try {
			FileWriter fw = new FileWriter("patient_temperature_report.txt");
			fw.write(text);
			fw.close();
		} catch (Exception e) {
			System.err.println("Something went wrong!");
		}
	}
}
