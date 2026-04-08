package Level_4_Easy_Intro_to_Patterns;

import java.util.Scanner;

public class Count_Digits_in_a_Number {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter num: ");
		int n = scan.nextInt(); 
		
		int count = 0;
		scan.close();
		for (; n > 0; n /= 10) {
			count++;
		}
		
		System.out.println("Number of digits is : " + count);

	}

}
