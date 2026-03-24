package Projects_FileHandling;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;


public class Student_Information_System {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		File file = new File("students_record.txt");
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
		captureStudentDetails(scan);
		scan.close();
		
	}
	
	public static void captureStudentDetails(Scanner scan) {
		System.out.print("How many students do you want to register? ");
		int num = scan.nextInt();
		scan.nextLine();
		String[] names = new String[num];
		int[] ages = new int[num];
		String[] grades = new String[num];
		for (int i = 0; i < num; i++) {
			System.out.println("Enter details for Student " + (i+1) +": ");
			System.out.print("Name: ");
			names[i] = scan.nextLine();
			System.out.print("Age: ");
			ages[i] = scan.nextInt();
			scan.nextLine();
			System.out.print("Grade: ");
			grades[i] = scan.nextLine();
			System.out.println();
			
		}
		
		String text = displayStudents(names,ages,grades);
		saveToFile(text);
		
	
	}
	
	public static String displayStudents(String[] names, int[] ages, String[] grades) {
		String contain = "";
		for (int i = 0; i < names.length; i++) {
			System.out.println("Student " + (i+1) +": " + names[i] +", " + ages[i] + " years old, Grade: "+ grades[i]);
			contain += names[i] + ", " + ages[i] + ", " + grades[i] + "\n";
		}
		return contain;
	}
	
	public static void saveToFile(String text) {
		try {
			FileWriter writer = new FileWriter("students_record.txt", true);
			writer.write(text);
			writer.close();
			System.out.println("\nStudent details saved successfully to student_records.txt!");
			
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
	}
	

}
