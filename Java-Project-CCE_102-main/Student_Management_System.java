import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

public class Student_Management_System {

	public static void main(String[] args) {
		// Created By Heat
		Scanner scan = new Scanner(System.in);
		File file = new File("students.txt");
		
		System.out.print("Enter maximum number of students: ");
		int max = scan.nextInt();
		scan.nextLine();
		
		String[] name = new String[max];
		int[] roll = new int[max];
		double[] marks = new double[max];
		
		int count = 0;
		int options = 0;
		do {
			System.out.println("\nSTUDENT MANAGEMENT SYSTEM");
			System.out.println("1 – Add Student\n2 – Update Marks\n3 – Delete Student\n4 – Display Students (Sorted by Marks)\n5 – Save Records\n6 – Display File Output\n7 – Exit\n");
			System.out.print("Choose an option: ");
			options = scan.nextInt();
			scan.nextLine();
			
			switch (options) {
			case 1:
				count = addStudent(scan,name,roll,marks,count,max);
				break;
			case 2:
				updateMarks(scan, roll, marks, count);
				break;
			case 3:
				count = deleteStudent(scan, name, roll, marks, count);
				break;
			case 4: 
				displayStudents(name, roll, marks, count);
				break;
			case 5:
				saveToFile(file, name, roll, marks, count);
				break;
			case 6:
				readFile(file);
				break;
			case 7:
				System.out.println("Program ended.");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice!");
				break;
			}
		} while (options != 6);
		scan.close();
		
	}
	
	public static int addStudent(Scanner scan, String[] name, int[] roll, double[] marks, int count, int max) {
		if (count >= max)  {
			System.out.println("Already Full!");
			return count;
		} else {
			System.out.print("Enter student name: ");
			name[count] = scan.nextLine();
			System.out.print("Enter roll number: ");
			roll[count] = scan.nextInt();
			scan.nextLine();
			System.out.print("Enter marks: ");
			marks[count] = scan.nextDouble();
			scan.nextLine();
			System.out.println("Student added!");
			
		}
		count++;
		return count;
	}
	
	public static void updateMarks(Scanner scan, int[] roll, double[] marks, int count) {
		System.out.print("Enter roll number: ");
		int rollNumber = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < count; i++) {
			if (roll[i] == rollNumber) {
				do {
					System.out.print("Enter new marks: ");
					marks[i] = scan.nextDouble();
					scan.nextLine();
					if (marks[i] < 0 || marks[i] > 100) {
						System.out.println("Invalid remarks!");
					} else {
						System.out.println("Marks updated!");
						return;
					}
				} while (marks[i] < 0 || marks[i] > 100);
				
			} 
		}
		System.out.println("error!");
	}
	
	public static int deleteStudent(Scanner scan, String[] name, int[] roll, double[] marks, int count) {
		System.out.print("Enter roll number to delete: ");
		int rollNumber = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < count; i++) {
			if (roll[i] == rollNumber) {
				for (int j = i; j < count - 1; j++) {
					name[j] = name[j+1];
					roll[j] = roll[j+1];
					marks[j] = marks[j+1];
				}
				count--;
				return count;
			}
		}
		
		System.out.println("Error!");
		return count;
		
	}
	
	public static void displayStudents(String[] name, int[] roll, double[] marks, int count) {
		String[] tempName = new String[count];
		int[] tempRoll = new int[count];
		double[] tempMarks = new double[count];
		System.out.println("--- STUDENTS SORTED BY MARKS ---");
		for (int i = 0; i < count; i++) {
			tempName[i] = name[i];
			tempRoll[i] = roll[i];
			tempMarks[i] = marks[i]; 
		}
		// i am using a bubble sort
		for (int i = 0; i < count - 1; i++) {
		    for (int j = 0; j < count - 1 - i; j++) {
		        if (tempMarks[j] < tempMarks[j + 1]) {
		            // Swap marks
		            double tempMark = tempMarks[j];
		            tempMarks[j] = tempMarks[j + 1];
		            tempMarks[j + 1] = tempMark;

		            // Swap names 
		            String tempN = tempName[j];
		            tempName[j] = tempName[j + 1];
		            tempName[j + 1] = tempN;

		            // Swap roll numbers
		            int tempR = tempRoll[j];
		            tempRoll[j] = tempRoll[j + 1];
		            tempRoll[j + 1] = tempR;
		        }
		    }
		}
		// print
		for (int i = 0; i < count; i++) {
			System.out.println((i + 1) + ".\t" + tempName[i] + " (Roll " + tempRoll[i] + ") – Marks: " + tempMarks[i]); 
		}
		return;
	}
	
	public static void saveToFile(File file, String[] name, int[] roll, double[] marks, int count) {
		try {
			FileWriter writer = new FileWriter(file, true);
			for (int i = 0; i < count; i++) {
				writer.write(name[i]+ "," + roll[i] + "," + marks[i] + "\n");
			}
			System.out.println("Records saved to students.txt");
			writer.close();
		} catch (Exception e) {
			System.out.println("Error My Friend");
		}
	}
	
	public static void readFile(File file) {
		System.out.println("Reading students.txt file...\n");
		try {
			Scanner read = new Scanner(file);
			while (read.hasNextLine()) {
				System.out.println(read.nextLine());
			}
			read.close();
		} catch (Exception e) {
			System.err.println("Error My Friend");
		}
	}
		
}
