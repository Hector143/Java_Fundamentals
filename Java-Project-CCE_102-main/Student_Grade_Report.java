package hey;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Student_Grade_Report {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("How many sutdents? ");
		int num = scan.nextInt();
		scan.nextLine();
		String[] names = new String[num];
		int[] score = new int[num];
		for (int i = 0; i < num; i++) {
			System.out.print("\nStudent " + (i +1) + " Name: ");
			names[i] = scan.nextLine();
			System.out.print("Score: ");
			score[i] = scan.nextInt();	
			scan.nextLine();	
		}	
		String text = scoreRemarks(score, names);
		saveToFile(text);
		scan.close();
	}
	
	public static String scoreRemarks(int[] score, String names[]) {
		String contain = "---------------------------------------------------\n";
		contain += "\t\tSTUDENT GRADE REPORT\n";
		contain += "---------------------------------------------------\n";
		contain += "Name\t| Score | Remark\t\n";
		contain += "---------------------------------------------------\n";
		for (int i = 0; i < score.length; i++) {
			if (score[i] >= 90 && score[i] <= 100) {
				contain += names[i] + "\t| "+ score[i] + "\t| " + "Excellent" + "\n";	
			} else if (score[i] >= 80) {
				contain += names[i] + "\t| "+ score[i] + "\t| " + "Very Good" + "\n";
			} else if (score[i] >= 75) {
				contain += names[i] + "\t| "+ score[i] + "\t| " + "Passed" + "\n";
			} else if (score[i] > 0) {
				contain += names[i] + "\t| "+ score[i] + "\t| " + "Failed" + "\n";	
			} else {
				contain += names[i] + "\t| "+ score[i] + "\t| " + "Invalid Score" + "\n";		
			} 
		}
		contain += "---------------------------------------------------\n";
		System.out.println("\n"+contain);
		return contain;
	}
	public static void saveToFile(String text) {
		try {
			FileWriter writer = new FileWriter("grade_report.txt");
			writer.write(text);
			writer.close();
			System.out.println("Report saved to grade_report.txt");
		} catch (IOException e) {
			System.out.println("Something went wrong!");
		}
	}

}
