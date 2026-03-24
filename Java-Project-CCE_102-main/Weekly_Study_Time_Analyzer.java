package CCE102L2989;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Weekly_Study_Time_Analyzer {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		File file = new File("weekly_study_report.txt");
		initFile(file);
		readStudyHours(scan, file);
		scan.close();
	}
	
	public static double[] readStudyHours(Scanner scan, File file) {
		System.out.print("How many study day entries? ");
		int num = scan.nextInt();
		scan.nextLine();
		System.out.print("What is your target weekly study hours? ");
		double targetHours = scan.nextDouble();
		scan.nextLine();
		
		double[] hours = new double[num];
		for (int i = 0; i < hours.length; i++) {
			System.out.print("Day " + (i+1) + ": ");
			hours[i] = scan.nextDouble();
			scan.nextLine();
		}
		String contain = "";
		for (int i = 0; i < hours.length; i++) {
			contain += String.format("Day %d: %.1f%n", (i+1), hours[i]);
		}
		
		System.out.println("\n"+contain);
		double total = computeTotal(hours);
		double avg = computeAverage(hours);
		String summary = buildSummaryLine(total,avg,targetHours);
		contain += summary;
		System.out.println(summary);
		saveToFile(file, contain);
		return hours;
		
	}
	
	public static double computeTotal(double[] hours) {
		double total = 0;
		for (int i = 0; i < hours.length; i++) {
			total += hours[i];
		}
		return total;
	}
	
	public static double computeAverage(double[] hours) {
		double average = 0;
		for (int i = 0; i < hours.length; i++) {
			average += hours[i];
		}
		return average / hours.length;
	}
	
	public static String buildSummaryLine(double total, double average, double targetHours) {
		String line = "";
		double percentAchieved = (total / targetHours) * 100;
		if (percentAchieved >= 100) {
			line += String.format("\nTotal = %.1f, Average = %.1f, %.1f%% of goal, Status = Goal Achieved%n", total, average, percentAchieved);
		} else {
			line += String.format("\nTotal = %.1f, Average = %.1f, %.1f%% of goal, Status = Below Goal%n", total, average, percentAchieved);
		}
		return line;
	}
	
	public static void initFile(File file) {
		try{
			if(!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			System.err.println("Something went wrong!");
		}
	}

	public static void saveToFile(File file, String data) {
		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write(data);
			fw.close();
			System.out.println("\nSaved report to weekly_study_report.txt");
		} catch (Exception e) {
			System.err.println("Error " + e);
		}
	}

}
