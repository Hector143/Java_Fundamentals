package Level_4_Easy_Intro_to_Patterns;

import java.util.Scanner;

public class Sum_of_Digits {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter num: ");
		int n = scan.nextInt();
		
		int sum = 0;
		scan.close();
		for (; n > 0; n/=10) {
			int digit = n % 10;
			sum += digit;
		}
		
		System.out.println("Sum of digits is: " + sum);
		
	}

}
