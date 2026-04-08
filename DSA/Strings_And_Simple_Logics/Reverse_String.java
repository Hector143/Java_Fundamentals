package Strings_And_Simple_Logics;

import java.util.Scanner;

public class Reverse_String {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String str = scan.nextLine().trim();
		
		System.out.print("Reversed string: ");
		
		for (int i = str.length()-1; i >= 0; i--) {
			char c = str.charAt(i);
			System.out.print(c);
		}
		System.out.println();
		scan.close();
	}

}
