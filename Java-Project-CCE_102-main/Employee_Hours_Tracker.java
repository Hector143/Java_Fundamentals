package Projects_FileHandling;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Employee_Hours_Tracker {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		initFile();
		System.out.print("Enter number of employees: ");
		int num = scan.nextInt();
		scan.nextLine();
		String[] names = new String[num];
		int[] hours = new int[num];
		for (int i = 0; i < hours.length; i++) {
			System.out.print("\nEnter name of employee " + (i+1) + ": ");
			names[i] = scan.nextLine();
			System.out.print("Enter hours worked: ");
			hours[i] = scan.nextInt();
			scan.nextLine();
		}
		displayHours(names,hours);
		scan.close();
		

	}
	
	public static File initFile() {
		File file = new File("HoursReport.txt");
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			System.out.println("Error " + e);
		}
		return file;
	}
	
	public static void displayHours(String names[], int hours[]) {
		String contain = "Employees and Hours:\n\n";
		System.out.println("\n\nEmployees and Hours:\n");
		for (int i = 0; i < hours.length; i++) {
			System.out.println(names[i] + " - " + hours[i]);
			contain += names[i] + " - " + hours[i] + "\n";
		}
		
		System.out.println("\nTotal Hours: " + totalHours(hours));
		System.out.println("Average Hours: " + averageHours(hours));
		System.out.println("Overtime Workers: " + countOvertime(hours));
		contain += "\nTotal Hours: " + totalHours(hours) + "\n";
		contain += "Average Hours: " + averageHours(hours) + "\n";
		contain += "Overtime Workers: " + countOvertime(hours) + "\n";
		
		saveToFile(contain);
	}
	
	public static int totalHours(int hours[]) {
		int sum = 0;
		for (int i = 0; i < hours.length; i++) {
			sum += hours[i];
		}
		return sum;
	}
	
	public static int averageHours(int hours[]) {
		int avg = 0;
		for (int i = 0; i < hours.length; i++) {
			avg += hours[i];
		}
		return avg / hours.length;
	}
	
	public static int countOvertime(int hours[]) {
		int count = 0;
		for (int i = 0; i < hours.length; i++) {
			if (hours[i] > 40) {
				count++;
			}
		}
		return count;
	}
	
	public static void saveToFile(String text) {
		try {
			FileWriter writer = new FileWriter(initFile(), true);
			writer.write(text);
			writer.close();
			System.out.println("\nSaved to File HoursReport.txt.");
		} catch (IOException e) {
			System.out.println("Something went wrong!");
		}
	}
	
		
	

}
