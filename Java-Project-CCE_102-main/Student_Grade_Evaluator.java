package MyPackage;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Student_Grade_Evaluator {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		File file = new File("class_records.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
		
		double[] inputs = collectGrades(scan);
		String evaluate = evaluateStatus(inputs);
		exportResult(file, evaluate);
		System.out.println("\n\nSaved records to class_records.txt");
		scan.close();
	}
	
	public static double[] collectGrades(Scanner scan) {
		System.out.print("How many students in the class? ");
		int students = scan.nextInt();
		scan.nextLine();
		System.out.println("Enter grades for " + students + " students: ");
		double[] grades = new double[students];
		for (int i = 0; i < grades.length; i++) {
			System.out.print("Student " + (i+1) + ": ");
			grades[i] = scan.nextDouble();
			scan.nextLine();
			
		}
		System.out.println();
		return grades;
				
	}
	
	public static String evaluateStatus(double[] grades) {
		String status = "";
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] >= 90.0) {
				status += "Student " + (i+1) + ": " + String.format("%.1f", grades[i]) + " - " + "Dean's Lister" + "\n"; 
			} else if (grades[i] >= 75.0) {
				status += "Student " + (i+1) + ": " + String.format("%.1f", grades[i]) + " - " + "Passed" + "\n";
			} else {
				status += "Student " + (i+1) + ": " + String.format("%.1f", grades[i]) + " - " + "Failed" + "\n";
			}
		}
		System.out.println(status);
		return status;
	}
	
	public static void exportResult(File file, String text) {
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.write(text);
			writer.close();
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
	}

}
