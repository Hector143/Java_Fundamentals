// Hector Josh G. Salera
package Registration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Revised_First_Diagnostic_with_File_Handling {
	public static Scanner scan = new Scanner(System.in);
	public static int counter = 0;
	public static int maximumStudent;
	public static int staffIndex = 0;
	public static int programChoice;
	public static int documentChoice;
	public static final String filePath = "Student_Registration.txt";
	public static File file = new File(filePath);
	public static String choice;
	public static String[] staff = {"Jedrick","Dinoy"};
	public static String[] Programs = {"ABM", "HSS", "STEM", "GAS"};
	public static String[] Documents = {"ID", "Birth Certificate", "No Document"};
	public static String[] name;
	public static String[] id;
	public static String[] program;
	public static String[] document;
	public static String[] date;
	public static String[] transactedStaff;

	public static void main(String[] args) {
		loginStaff();
		maximumStudent();
		settingArrays();
		menu();
		initFile();

	}

	public static void loginStaff() {
		System.out.println("Who is going to login?"
				+ "\nPress 1 to Select Jedrick"
				+ "\nPress 2 to Select Dinoy");
		System.out.print("Enter choice: ");
		staffIndex = scan.nextInt() - 1; scan.nextLine();
		if (staffIndex > 1 || staffIndex < 0) {
			System.err.println("Invalid input.\n");
			loginStaff();
		}

	}

	public static void maximumStudent() {
		System.out.print("\nPlease input maximum student: ");
		maximumStudent = scan.nextInt(); scan.nextLine();
		if (maximumStudent < 1) {
			System.out.println("Invalid input.");
			maximumStudent();
		}
	}

	public static void settingArrays() {
		name = new String[maximumStudent];
		id = new String[maximumStudent];
		program = new String[maximumStudent];
		document = new String[maximumStudent];
		date = new String[maximumStudent];
		transactedStaff = new String[maximumStudent];
	}

	public static void menu() {
		System.out.println("\n- - - - - MENU - - - - -"
				+ "\nPress 1 for Register or Add Student" 
				+ "\nPress 2 for Viewing all the Student"
				+ "\nPress 3 for Save Records of all Student"
				+ "\nPress 4 for Read Records of Students"
				+ "\nPress 5 to Exit");
		System.out.print("Enter choice: ");
		choice = scan.nextLine();
		switch(choice) {
		case "1":
			registerStudent();
			break;
		case "2":
			displayStudent();
			break;
		case "3":
			saveToFile();
			break;
		case "4":
			readFile();
			break;
		case "5":
			exit();
			break;
		default:
			System.err.println("Invalid input.");
			menu();
			break;
		}
	}

	public static void registerStudent() {
		if (counter >= maximumStudent) {
			System.err.println("Registration full. No vacant slots avaiable.\n");
			return;
		}

		System.out.print("\nEnter Student Name: ");
		name[counter] = scan.nextLine();

		System.out.print("Enter ID: ");
		id[counter] = scan.nextLine();

		selectProgramChoice();
		program[counter] = Programs[programChoice];

		selectDocumentChoice();
		document[counter] = Documents[documentChoice];

		transactedStaff[counter] = staff[staffIndex];

		System.out.print("Enter Date: ");
		date[counter] = scan.nextLine();

		counter++;
		menu();
	}

	public static void selectProgramChoice() {
		programChoice = 0;
		System.out.println("\nPlease select Program:"
				+ "\nPress 1 for ABM"
				+ "\nPress 2 for HSS"
				+ "\nPress 3 for STEM"
				+ "\nPress 4 for GAS");
		System.out.print("Enter choice: ");
		programChoice = scan.nextInt() - 1; scan.nextLine();
		if (programChoice > 3 || programChoice < 0) {
			System.err.println("Invalid input.");
			selectProgramChoice();
		}
	}

	public static void selectDocumentChoice() {
		documentChoice = 0;
		System.out.println("\nPress 1 for ID " 
				+ "\nPress 2 for Birth Certificate " 
				+ "\nPress 3 for No Document");
		System.out.print("Enter choice: ");
		documentChoice = scan.nextInt() - 1; scan.nextLine();
		if (documentChoice > 2 || documentChoice < 0) {
			System.err.println("Invalid input.");
			selectDocumentChoice();
		}
	}

	public static void displayStudent() {
		for (int i = 0; i < counter; i++) {
			System.out.println("\nStudent " + (i+1) + 
					"\nName: " + name[i] +
					"\nID: " + id[i] +
					"\nProgram: " + program[i] +
					"\nDocument: " + document[i] +
					"\nTransacted Staff: " + transactedStaff[i] +
					"\nDate: " + date[i] +
					"\n");
		}
		System.out.println("Number of Registered Students: " + counter + 
				"\nVacant Slots: " + (maximumStudent - counter));
		menu();
	}
	
	public static void initFile() {
		try {
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("File Created Successfully.");
			} else {
				System.out.println("File Already Exists.");
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage() + "\nCannot Create File");
		}
		
	}
	public static void saveToFile() {
		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write("Name\t\t | ID\t | Program\t | Document\t | Staff\t | Date\t\t |\n");
			for (int i = 0; i < counter; i++) {
				fw.write(name[i] +
						" \t\t| " + id[i] +
						" | " + program[i] +
						"\t\t | " + document[i] +
						" | " + transactedStaff[i] +
						"\t| " + date[i] +
						"\t| ");
			}
			fw.write("\n\n");
			fw.close();
			System.out.println("\nSaved to " + file.getName());
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
			menu();
		}
		menu();
	}
	
	public static void readFile() {
		try {
			Scanner read = new Scanner(file);
			System.out.println("Reading File...");
			while (read.hasNextLine()) {
				System.out.println(read.nextLine());
			}
			read.close();
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
			menu();
		}
		menu();
	}

	public static void exit() {
		System.out.println("Thank you for using the System. EXIT....");
		System.exit(0);
	}

}