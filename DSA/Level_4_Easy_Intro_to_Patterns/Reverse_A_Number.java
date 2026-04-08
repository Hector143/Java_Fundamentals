package Level_4_Easy_Intro_to_Patterns;

import java.util.Scanner;

public class Reverse_A_Number {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter num: ");
		int n = scan.nextInt();
		
		System.out.println("Original num: " + n);
		System.out.print("After reversing the num: ");
		String str = Integer.toString(n);
		for (int i = str.length()-1; i >= 0; i--) {
			char c = str.charAt(i);
			System.out.print(c);
			
		}
		scan.close();
			
				
	}

}
