package Projects_FileHandling;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Movie_Rental_System {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter number of movies: ");
		int num = scan.nextInt();
		scan.nextLine();
		
		String titles[] = new String[num];
		int rentals[] = new int[num];
		for (int i = 0; i < rentals.length; i++) {
			System.out.print("\nEnter title of movie "+ (i+1) + ": ");
			titles[i] = scan.nextLine();
			System.out.print("Enter rentals: ");
			rentals[i] = scan.nextInt();
			scan.nextLine();
		}
		System.out.println("\n");
		displayMovies(titles,rentals);
		System.out.println("\n");
		scan.close();
	}
	public static void displayMovies(String titles[], int rentals[]) {
		String text = "Movies and Rentals:\n\n";
		for (int i = 0; i < rentals.length; i++) {
			text += titles[i] + " - " + rentals[i] + "\n";
		}
		text += "\nMost Rented: " + mostRented(rentals) + "\n";
		text += "Popular Movies (5+ rentals): " + countPopular(rentals) + "\n";
		text += "Never Rented: " + countNeverRented(rentals) + "\n";
		System.out.print(text + "\n");
		saveToFile(text);
		
	}
	
	public static int mostRented(int rentals[]) {
		int most = 0;
		for (int i = 0; i < rentals.length; i++) {
			if (rentals[i] > most) {
				most = rentals[i];
			}
		}
		return most;
	}
	
	public static int countPopular(int rentals[]) {
		int popular = 0;
		for (int i = 0; i < rentals.length; i++) {
			if (rentals[i] >= 5) {
				popular++;
			}
		}
		return popular;
	}
	
	public static int countNeverRented(int rentals[]) {
		int never = 0;
		for (int i = 0; i < rentals.length; i++) {
			if (rentals[i] == 0) {
				never++;
			}
		}
		return never;
	}
	
	public static void saveToFile(String text) {
		try {
			FileWriter writer = new FileWriter("MovieReport.txt");
			writer.write(text);
			writer.close();
			System.out.println("\nFile Saved to MovieReport.txt");
		} catch (IOException e) {
			System.out.println("Something went wrong!");
		}
	}

	
}
