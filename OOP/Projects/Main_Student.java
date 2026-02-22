package Projects;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main_Student {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("How many students? ");
		int numOfStud = scan.nextInt(); 
		
		System.out.print("How many grades per student? ");
		int numOfGrades = scan.nextInt();
		scan.nextLine();
		
		Student[] students = new Student[numOfStud];
		
		GradeCalculator gradeCal = new AverageGradeCalculator();
		for (int i = 0; i < students.length; i++) {
			System.out.println("\nEnter details for Student " + (i+1) + ": ");
			System.out.print("Name: ");
			String name = scan.nextLine();
			
			double[] grades = new double[numOfGrades];
			for (int j = 0; j < grades.length; j++) {
				System.out.print("Grade " + (j + 1) + ": ");
				grades[j] = scan.nextDouble(); scan.nextLine();
			}
			// (optional) scan.nextLine();  this clears buffer
			System.out.println();
			students[i] = new Student(name, grades);

		}
		
		String text = "";
		
		// Output and File handling
		try {
			FileWriter fw = new FileWriter("student_report.txt", true);
			for (int i = 0; i < students.length; i++) {
				double average = gradeCal.calculateAverage(students[i].getGrades());
				String status = (average >= 75) ? "Passed" : "Failed";
				text += String.format("Student %d: %s - Average: %.1f - %s%n", (i+1), students[i].getName(), average, status);		
			}
			System.out.print(text);
			fw.write(text + "\n");
			fw.close();
			System.out.println("\nSaved report to student_report.txt");
		} catch (IOException e) {
			System.err.println("Error : " + e.getMessage());
		}
		scan.close();
	}

}
