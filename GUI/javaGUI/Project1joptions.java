package javaGUI;
import java.util.Scanner;
import java.util.Random;

public class Project1joptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rant = new Random();
		int randomnumber = rant.nextInt(1, 101);
		int guess;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Guess the Number (1-100).");
		
		int attempts = 5;
		for (int i = 0; i < 5; i++) {
			guess = scanner.nextInt();
			if (guess == randomnumber) {
				System.out.println("your guessed it!");
				break;
			} else if (guess > randomnumber) {
				System.out.println("too high!");
			} else if (guess < randomnumber) {
				System.out.println("too low!");
			}
//			if (attempts == 0) {
//				System.out.println("game over");
//				break;
//			}
			
		}scanner.close();
	}

}
