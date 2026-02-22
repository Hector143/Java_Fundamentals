package Projects;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main_LibraryManagementSystem {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("How many books are in the library? ");
		int num = scan.nextInt(); scan.nextLine();
		
		Borrowable[] book = new Borrowable[num]; 
		
		for (int i = 0; i < book.length; i++) {
			System.out.println("\nEnter details for Book " + (i+1) + ": ");
			System.out.print("Title: ");
			String title = scan.nextLine();
			
			System.out.print("Author: "); 
			String author = scan.nextLine();
			
			System.out.print("Is the book borrowed? ");
			String borrow = scan.nextLine();
			
			if (borrow.equalsIgnoreCase("yes")) {
				book[i] = new Book(title, author, true);
			} else if (borrow.equalsIgnoreCase("no")) {
				book[i] = new Book(title, author, false);
			} else {
				System.out.println("Invalid answer must be 'yes' or 'no'.");
				i--;
			}
		}
		
		String text = "";
		
		try {
			FileWriter fw = new FileWriter("library_report.txt");
			for (int i = 0; i < book.length; i++) {
				text += "Book " + (i+1) + ": " + book[i].getTitle() + " by " + book[i].getAuthor() + " - " + book[i].getStatus() + "\n";
			}
			System.out.println("\n" + text);
			fw.write(text + "\n");
			fw.close();
			System.out.println("Saved report to library_report.txt");
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		scan.close();
	}

}
