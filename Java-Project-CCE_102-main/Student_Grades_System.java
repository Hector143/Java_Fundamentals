package Projects_FileHandling;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;


public class Student_Grades_System {
	
	static String[] names;
	static double[] grades;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		final String filePath = "student_grades.txt";
		File file = new File(filePath);
		
		System.out.print("How many students?");
		int number = scan.nextInt();
		
		names = new String[number];
		grades = new double[number];
		
		createFile(file);
		inputStudents(scan);
		sortDescending(names, grades);
		
		double avg = getAverage(grades);
		int hi = getHighestIndex(grades);
		int lo = getLowestIndex(grades);
		
		String report = generateReport(names, grades, avg, hi, lo);
		saveToFile(report, file);
		System.out.println("Reading the file...");
		readFile(file);
		System.out.println("Saved file to " + filePath);
		scan.close();
		
	}
	
	public static File createFile(File file) {
		
		try {
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("File has been Created.");
			} else {
				System.out.println("File already Exists.");
			}
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
		return file;

	}
	
	public static void inputStudents(Scanner scan) {
		scan.nextLine();
		for (int i = 0; i < names.length; i++) {
			System.out.print("Enter student " + (i+1) + " name: ");
			names[i] = scan.nextLine();
			System.out.print("Enter grades of student " + (i+1) + " : ");
			grades[i] = scan.nextDouble();
			scan.nextLine();
			
		}
		System.out.println();
		
		
	}
	
	public static double getAverage(double[] grades) {
		double sum = 0;
		for (int i = 0; i < grades.length; i++) {
			sum += grades[i];
		}
		
		return sum / grades.length;
	}
	
	public static int getHighestIndex(double[] grades) {
		int highest = 0;
		for (int i = 1; i < grades.length; i++) {
			if (grades[i] > grades[highest]) {
				highest = i;
			}
		}
		return highest;
	}
	
	public static int getLowestIndex(double[] grades) {
		int lowest = 0;
		for (int i = 1; i < grades.length; i++) {
			if (grades[i] < grades[lowest]) {
				lowest = i;
			}
		}
		return lowest;
	}
	
	public static void sortDescending(String[] names, double[] grades) {
		for (int i = 0; i < grades.length - 1; i++) {
			for (int j = 0; j < grades.length - i - 1; j++) {
				if (grades[j] < grades[j + 1]) {
					
					double gradesSort = grades[j];
					grades[j] = grades[j + 1];
					grades[j + 1] = gradesSort;
					
					String namesSort = names[j];
					names[j] = names[j + 1];
					names[j + 1] = namesSort;
				}
			}
			
		}
	}
	
	public static String generateReport(String[] names, double[] grades, double average, int hi, int lo) {
		String report = ""; 
		
		report += "Sorted Student Grades Report\n";
		report += "----------------------------\n";
		
		for (int i = 0; i < grades.length; i++)  {
			report += names[i] + " - " + grades[i] + "\n";
			
		}
		
		report += "Average Grade: " + String.format("%.2f", average) + "\n";
		report += "Highest Grade: " + names[hi] + " (" + grades[hi] + ")" + "\n";
		report += "Lowest Grade: " + names[lo] + " (" + grades[lo] + ")" + "\n";
		
		return report;
		
	}
	
	public static void saveToFile(String report, File file) {
		try {
			FileWriter writer = new FileWriter(file);
			writer.write(report);
			writer.close();
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
		
	}
	
	public static void readFile(File file) {
		try (Scanner read = new Scanner(file)){
			while (read.hasNextLine()) {
				System.out.println(read.nextLine());
			}
			read.close();
			
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
	}

}
