package Level_4_Easy_Intro_to_Patterns;

import java.util.Scanner;

public class Check_Prime_Number {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter prime num: ");
		int n = scan.nextInt(); scan.nextLine();
		
		scan.close();
		if (n <= 1) {
			System.out.println("Not Prime");
			return;
		}
		
		// step 2
		
		boolean isPrime = true;
		
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				isPrime = false;
				break;
			}
		}
		
		// step 3
		
		if (isPrime) {
			System.out.println("Prime");
		} else {
			System.out.println("Not Prime");
		}
		

	}

}
