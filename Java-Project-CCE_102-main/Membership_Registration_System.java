package Projects_FileHandling;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;


public class Membership_Registration_System {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		File file = new File("membership_records.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
		String text = captureMemberDetails(scan);
		saveToFile(file,text);
		System.out.println("\nMembership details saved successfully to membership_records.txt!");
		scan.close();
	}
	
	public static String captureMemberDetails(Scanner scan) {
		String contain = "";
		System.out.print("How many members do you want to register? ");
		int num = scan.nextInt();
		scan.nextLine();
		String[] members = new String[num];
		int[] ages = new int[num];
		String[] sub = new String[num];
		for (int i = 0; i < members.length; i++) {
			System.out.println("Enter details for Member "+ (i+1) +": ");
			System.out.print("Name: ");
			members[i] = scan.nextLine();
			System.out.print("Age: ");
			ages[i] = scan.nextInt();
			scan.nextLine();
			System.out.print("Subscription Plan (Basic, Premium, VIP): ");
			sub[i] = scan.nextLine();
			System.out.println();
			contain += "Member " + (i + 1) +": " + members[i] + ", " + ages[i] + " years old, Subscription: " + sub[i] + "\n";
		}
		displayMembers(members, ages, sub);
		return contain;
		
	}
	
	public static void displayMembers(String[] members, int[] ages, String[] sub) {
		for (int i = 0; i < members.length; i++) {
			System.out.printf("Member %d: %s, %d years old, Subscription: %s%n",(i+1),members[i] , ages[i], sub[i]);
		}
	}
	
	public static void saveToFile(File file, String text) {
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.write(text);
			writer.close();
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
	}
	
	
	
}
