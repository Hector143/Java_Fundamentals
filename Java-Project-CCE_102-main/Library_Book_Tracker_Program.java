package Projects_FileHandling;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Library_Book_Tracker_Program {
	static FileWriter writer;
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		File file = new File("LibraryReport.txt");
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			System.out.println("Something went wrong!");
			e.printStackTrace();
		}
		
		System.out.print("Enter number of books: ");
		int num = scan.nextInt(); 
		scan.nextLine();
		
		String[] books = new String[num];
		int[] copies = new int[num];
		for (int i = 0; i < num; i++) {
			System.out.print("Enter title of book " + (i+1) + ": ");
			books[i] = scan.nextLine().trim();
			System.out.print("Enter copies of " + books[i] +": ");
			copies[i] = scan.nextInt();
			scan.nextLine().trim();
		}
		System.out.println();
		writer = new FileWriter("LibraryReport.txt" , true);
		displayBooks(books, copies);
		displayCopies(copies);
		System.out.println("Available: " + countAvailable(copies));
		writer.write("Availble: " + countAvailable(copies) + "\n");
		System.out.println("Unavailable: " + countUnavailable(copies));
		writer.write("Unavailble: " + countUnavailable(copies) + "\n\n");
		writer.close();
		
		scan.close();
		
		
	}
	
	public static void displayBooks(String[] books, int[] copies) throws IOException {
		String contain = "Books and Copies:\n";
		
		for (int i = 0; i < books.length; i++) {
			contain += books[i] + " - " + copies[i] + "\n";
		}
		writer.write(contain + "\n");
		System.out.println(contain);
	}
	
	public static void displayCopies(int[] copies) throws IOException{
		int total = 0;
		for (int i = 0; i < copies.length; i++) {
			total += copies[i];
		}
		System.out.println("Total Copies: " + total);
		writer.write("Total Copies: " + total +"\n");
	}
	
	public static int countUnavailable(int[] copies) {
		int unAvail = 0;
		for (int i = 0; i < copies.length; i++) {
			if (!(copies[i] > 0)) {
				unAvail++;
			}
		}
		return unAvail;
	}
	
	public static int countAvailable(int[] copies) {
		int Avail = 0;
		for (int i = 0; i < copies.length; i++) {
			if (copies[i] > 0) {
				Avail++;
			}
		}
		return Avail;
	}
}
