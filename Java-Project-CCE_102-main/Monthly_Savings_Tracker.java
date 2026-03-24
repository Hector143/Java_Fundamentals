package CCE102L2989;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Monthly_Savings_Tracker {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		readSavings(scan);
		scan.close();
		
	}
	
	public static double[] readSavings(Scanner scan) {
		File file = new File("monthly_savings_report.txt");
		initFile(file);
		String line = "";
		System.out.print("How many savings categories will you input? ");
		int num = scan.nextInt();
		scan.nextLine();
		
		System.out.print("What is your target savings goal for the month? ");
		double savings = scan.nextDouble();
		scan.nextLine();
		
		System.out.println();
		double[] save = new double[num];
		String[] text = {"Emergency Fund","Vacation Fund","Retirement Savings", "Education Fund", "House Fund", "Car Fund"};
		for (int i = 0; i < save.length; i++) {
			System.out.printf("Savings Category %d (%s): ", (i+1), text[i]);
			save[i] = scan.nextDouble();
			scan.nextLine();
			line += String.format("Savings Category %d (%s): %.1f%n", (i+1),text[i], save[i]);
		}
		System.out.println();
		double total = computeTotal(save);
		double avg = computeAverage(save);
		String summary = buildSummaryLine(total,avg,savings);
		
		line += summary;
		System.out.println(line);
		saveToFile(file, line);
		return save;
	}
	
	public static double computeTotal(double[] savings) {
		double total = 0;
		
		for (int i = 0; i < savings.length; i++) {
			total += savings[i];
		}
		return total;
	}
	
	public static double computeAverage(double[] savings) {
		double average = 0;
		
		for (int i = 0; i < savings.length; i++) {
			average += savings[i];
		}
		return average / savings.length;
	}
	
	public static String buildSummaryLine(double total, double average, double savings) {
		String data = "";
		double percentSavings = (total / savings) * 100;
		
		if (percentSavings > 100) {
			data += String.format("\nTotal Savings = %.2f, Average Savings = %.2f, %.1f%% of goal, Status = Goal Achieved%n", total, average, percentSavings);
		} else {
			data += String.format("\nTotal Savings = %.2f, Average Savings = %.2f, %.1f%% of goal, Status = Still short of Goal%n", total, average, percentSavings);
		}
		return data;
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
			fw.write(data + "\n\n");
			fw.close();
			System.out.println("\nSaved report to monthly_savings_report.txt");
		} catch (Exception e) {
			System.err.println("Error " + e);
		}
	}
}
