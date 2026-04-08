package Level_4_Easy_Intro_to_Patterns;

import java.util.Scanner;

public class Reverse_a_digits {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter num: ");
		int n = scan.nextInt();
		int rev = 0;
		
		scan.close();
		while (n > 0) {
			rev = rev * 10 + n % 10;
			n = n / 10;
		}
		
		System.out.println("digits after reversed: " + rev);

	}

}
