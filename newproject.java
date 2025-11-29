
package hectorproject;
import java.util.Scanner;
import java.util.Random;




public class newproject {

	public static void main(String[] args) {
		Random rant = new Random();
		var integer = rant.nextInt(100);
		String difficulty; 
		boolean finished = false;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Number Guessing Game!");
		System.out.println("\nChoose Mode:");
		System.out.println("Easy: Press '1' ");
		System.out.println("intermediate: Press '2' ");
		System.out.println("Hard: Press '3' ");
		
		System.out.println("\n\nGuess the number from 1 to 99.");
		
		int attempts = 0;
		difficulty = scan.nextLine();
		if (difficulty.equalsIgnoreCase("1")) {
			attempts = 7;
			System.out.println("you have chosen easy level!");	
		} else if (difficulty.equalsIgnoreCase("2")) {
			attempts = 5;
			System.out.println("you have chosen intermediate level");
		} else if (difficulty.equalsIgnoreCase("3")) {
			attempts = 3;
			System.out.println("you have chosen the hard level");
		}
		int guess;
		
		for (int i = 0; i < attempts; i++) {
			System.out.print("Guess (" + (i+1) + "/" + attempts + "): ");
			guess = scan.nextInt();
			if (guess == integer) {
				System.out.println("You guessed it correctly! Yay!");	
				finished = true;
				break;
			
			} else if (guess < integer) {
				System.out.println("Too low!");
			} else {
				System.out.println("Too High!");
			} 
			
			}
		
		System.out.println("you failed! the correct answer is " + integer);
		 scan.close();
		} 
		
}



