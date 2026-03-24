package Projects_FileHandling;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Simple_Grade_Checker {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		File file = new File("grades.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("File \"grades.txt\" created successfully.");
			} else {
				System.out.println("File \"grades.txt\" already Existed.");
			}
		} catch (Exception e) {
			System.out.println("Error");
		}
		
		
		double[] scores = inputScores(scan);
		String text = classifyScores(scores);
		System.out.println("\nSaving results to grades.txt...");
		saveToFile(text, file);
		readFile(file);
		
		
		scan.close();

	}
	
	public static double[] inputScores(Scanner scan) {
		System.out.print("How many students? ");
		int num = scan.nextInt();
		scan.nextLine();
		double[] scores = new double[num];
		for (int i = 0; i < num; i++) {
			System.out.print("Student " + (i+1) +": ");
			scores[i] = scan.nextDouble();
			
		}
		
		return scores;
	}
	
	public static String classifyScores(double[] scores) {
		String text = "";
		
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] >= 75) {
				text += "Student " + (i+1) + ": " + String.format("%.1f", scores[i]) + " - " + "PASS\n";
			} else {
				text += "Student " + (i+1) + ": " + String.format("%.1f", scores[i]) + " - " + "FAIL\n";
			}
		}
		
		return text;
	}
	
	public static void saveToFile(String text, File file) {
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.write(text);
			writer.close();
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
	}
	
	public static void readFile(File file) {
		try {
			Scanner read = new Scanner(file);
			System.out.println("Reading saved file...\n");
			while(read.hasNextLine()) {
				System.out.println(read.nextLine());
			}
			System.out.println("\nSaved report to grades.txt");
			read.close();
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
	}

}
