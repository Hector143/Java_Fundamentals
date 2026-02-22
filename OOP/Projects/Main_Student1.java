package Projects;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main_Student1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("How many students? ");
		int numOfStud = scan.nextInt();
		scan.nextLine();
		
		System.out.print("How many grades per student? ");
		int numOfGrades = scan.nextInt(); 
		scan.nextLine();
		
		Student1[] students = new Student1[numOfStud];
		
		GradeCalculator1 calculator = new AverageGradeCalculator1();
		
		for (int i = 0; i < students.length; i++) {
			System.out.println("\nEnter details for Student " + (i+1) + ": ");
			System.out.print("Name: ");
			String name = scan.nextLine();
			
			double[] grades = new double[numOfGrades];
			for (int j = 0; j < grades.length; j++) {
				System.out.print("Grade " + (j+1) + ": ");
				grades[j] = scan.nextDouble();
				
			}
			scan.nextLine();
			students[i] = new Student1(name, grades);
			
		}
		
		String data = "";
		
		
		try {
			FileWriter fw = new FileWriter("student_report.txt");
			for (int i = 0; i < students.length; i++) {
				double average = calculator.calculateAverage(students[i].getGrades());
				String status = (average >= 70) ? "Passed" : "Failed";
				data += String.format("Student %d: %s - Average: %.1f - %s%n", (i+1),students[i].getName(), average, status);
			} 
			System.out.print("\n" +data);
			fw.write(data + "\n");
			fw.close();
			System.out.println("Saved report to student_report.txt");
		} catch (IOException e) {
			System.err.println("Error : " + e.getMessage());
		}
		scan.close();
		
	}

}
