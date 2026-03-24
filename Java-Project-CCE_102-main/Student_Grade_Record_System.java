package Projects_FileHandling;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Student_Grade_Record_System {
	static FileWriter wr;
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		File file = new File("GradeReport.txt");
		
		System.out.print("Enter number of students: ");
		int num = scan.nextInt();
		scan.nextLine();
		System.out.println();
		String names[] = new String[num];
		double grades[] = new double[num];
		for (int i = 0; i < names.length; i++) {
			System.out.print("Enter student " +(i+1) + " name: ");
			names[i] = scan.nextLine();
			System.out.print("Enter grade: ");
			grades[i] = scan.nextDouble();
			scan.nextLine();
			System.out.println();
		}
		wr = new FileWriter(file, true);
		
		displayStudents(names,grades);
		System.out.printf("%nClass Average: %.2f%n", computeAverage(grades));
		System.out.println("Passed: " + countPassed(grades));
		System.out.println("Failed: " + countFailed(grades));
		wr.write(String.format("%nClass Average: %.2f%n", computeAverage(grades)));
		wr.write("Passed: " + countPassed(grades) + "\n");
		wr.write("Failed: " + countFailed(grades) + "\n");
		wr.close();
		scan.close();
		
	}
	
	public static void displayStudents(String names[], double grades[]) throws IOException {
		System.out.println("\nStudents and Grades: \n");
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i] + " - " + grades[i]);
			wr.write(names[i] + " - " + grades[i] + "\n");
		}
	}
	
	public static double computeAverage(double grades[]) {
		double total = 0;
		for (int i = 0; i < grades.length; i++) {
			total += grades[i];
		}
		
		return total/grades.length;
	}
	
	public static int countPassed(double grades[]) {
		int passed = 0;
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] >= 75) {
				passed++;
			}
		}
		return passed;
	}
	
	public static int countFailed(double grades[]) {
		int failed = 0;
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] < 75) {
				failed++;
			}
		}
		return failed;
	}
	

}
