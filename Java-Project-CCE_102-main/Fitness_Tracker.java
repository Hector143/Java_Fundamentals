package Projects_FileHandling;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Fitness_Tracker {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		File file = new File("fitness_report.txt");
		initFile(file);
		int[] inputMins = recordMinutes(scan);
		String cat = categorize(inputMins);
		saveReport(file,cat);
		scan.close();
	}
	
	public static void initFile(File file) {
		try {
			if(!file.exists()) {
				file.createNewFile();
			} 
		} catch(Exception e) {
			System.err.println("Something went wrong!");
		}
	}
	
	public static int[] recordMinutes(Scanner scan) {
		System.out.print("Enter number of members: ");
		int num = scan.nextInt();
		scan.nextLine();
		System.out.println();
		int[] minutes = new int[num];
		for (int i = 0; i < minutes.length; i++) {
			System.out.print("Enter minutes for Member " + (i+1) + ": ");
			minutes[i] = scan.nextInt();
			scan.nextLine();
		}
		System.out.println();
		return minutes;
	}
	
	public static String categorize(int[] minutes) {
		String cat = "";
		for (int i = 0; i < minutes.length; i++) {
			if (minutes[i] >= 90) {
				cat += "Member " + (i+1) + ": " + minutes[i] + " mins - Athlete\n";
			} else if (minutes[i] >= 45) {
				cat += "Member " + (i+1) + ": " + minutes[i] + " mins - Active\n";
			} else {
				cat += "Member " + (i+1) + ": " + minutes[i] + " mins - Beginner\n";
			}
		}
		System.out.println(cat);
		return cat;
	}
	
	public static void saveReport(File file, String report) {
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(report);
			writer.close();
			System.out.println("\nSaved report to fitness_report.txt");
		} catch (Exception e) {
			System.err.println("Something went wrong!");
		}
	}

}
