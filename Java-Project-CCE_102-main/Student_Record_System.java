package hey;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Student_Record_System {
	// view record
	// create record
	// add record
	// modify record
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		File file = new File("grades.txt");
		initFile(file);
		int choice = 0;
		int count = 0;
		final int max = 100;
		String[] name = new String[max];
		String[] course = new String[max];
		int[] age = new int[max];
		String[] subject = new String[max];
		do {
			System.out.println("--- STUDENT RECORD SYSTEM ---");
			System.out.println("1.) Add Student Record");
			System.out.println("2.) Modify Student Record");
			System.out.println("3.) View Student Record");
			System.out.println("4.) Search Student Record");
			System.out.println("5.) Save Student Record");
			System.out.println("6.) Read Student Record");
			System.out.println("7.) Exit");
			System.out.print("Enter choice: ");
			choice = scan.nextInt(); scan.nextLine();
			System.out.println();
			switch (choice) {
			case 1: 
				count = addStudent(scan, name, course, age, subject, count);
				break;
			case 2:
				modifyRecord(scan, name, course, age, subject, count);
				break;
			case 3:
				viewRecord(scan, name, course, age, subject, count);
				break;
			case 4:
				searchStudent(scan, name, course, age, subject, count);
				break;
			case 5:
				saveToFile(file, scan, name, course, age, subject, count);
				break;
			case 6: 
				readFile(file);
				break;
			case 7:
				System.out.println("System Exited.");
				System.exit(0);
			default:
				System.err.println("Invalid choice!");
				break;
			}
		} while (choice != 7);
		scan.close();
	}
	
	public static int addStudent(Scanner scan, String[] name, String[] course, int[] age, String[] subject, int count) {
		System.out.print("Enter name of student: ");
		name[count] = scan.nextLine();
		System.out.print("Enter course of "+ name[count] + ": ");
		course[count] = scan.nextLine();
		System.out.print("Enter age of "+ name[count] + ": ");
		age[count] = scan.nextInt(); scan.nextLine();
		System.out.print("Enter subject of " + name[count] + ": ");
		subject[count] = scan.nextLine();
		System.out.println();
		
		count++;
		return count;
		
	}
	
	public static void modifyRecord(Scanner scan, String[] name, String[] course, int[] age, String[] subject, int count) {
		System.out.print("Enter Student name: ");
		String studentName = scan.nextLine();
		for (int i = 0; i < count; i++) {
			if (studentName.equals(name[i])) {
				System.out.print("Enter new course of " + name[i] + ": ");
				course[i] = scan.nextLine();
				System.out.print("Enter new age of " + name[i] + ": ");
				age[i] = scan.nextInt(); scan.nextLine().trim();
				System.out.println("Enter new subject of " + name[i] + ": ");
				subject[i] = scan.nextLine();
			}
		}
		System.out.println();
		
	}
	// 67 76 32 69 8
	
	public static void viewRecord(Scanner scan, String[] name, String[] course, int[] age, String[] subject, int count) {
		System.out.println("\n---------------------------------------");
		System.out.println("\tSTUDENTS RECORD");
		System.out.println("-----------------------------------------");
		System.out.println("|Name\t\t|Course\t|Age\t|Subject\t\t|");

		for (int i = 0; i < count; i++) {
			System.out.println("|" + name[i] + "\t\t|" + course[i] + "\t|" + age[i] + "\t|" + subject[i] + "\t\t|");
		}
		System.out.println();
	}
	
	public static void searchStudent(Scanner scan, String[] name, String[] course, int[] age, String[] subject, int count) {
		System.out.print("Enter name to search: ");
		String search = scan.nextLine();
		for(int i = 0; i < count; i++) {
			if (search.equals(name[i])) {
				System.out.println("Name: " + name[i] + "\nCourse: " + course[i] + "\nAge: " + age[i] + "\nSubject: " + subject[i] + "\n");
			}
		}
		System.out.println();
	}
	
	public static void initFile(File file) {
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			System.err.println("Something went wrong!");
		}
	}
	
	public static void saveToFile(File file, Scanner scan, String[] name, String[] course, int[] age, String[] subject, int count) {
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("--- STUDENTS RECORD ---");
			bw.newLine();
			bw.write("|Name\t\t|Course\t|Age\t|Subject\t\t|");
			bw.newLine();
			System.out.println("Saved file to grades.txt\n");
			for (int i = 0; i < count; i++) {
				bw.write("|" + name[i] + "\t\t|" + course[i] + "\t|" + age[i] + "\t|" + subject[i] + "\t\t|");
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			System.err.println("Error : " + e.getMessage());
		}
	}
	
	public static void readFile(File file) {
		try {
			Scanner read = new Scanner(file);
			while (read.hasNextLine()) {
				System.out.println(read.nextLine());
			}
			read.close();
		} catch (Exception e) {
			System.err.println("Something went wrong!");
		}
	}
	
	
}
