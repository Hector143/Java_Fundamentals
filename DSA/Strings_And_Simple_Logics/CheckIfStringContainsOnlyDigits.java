package Strings_And_Simple_Logics;

import java.util.Scanner;

public class CheckIfStringContainsOnlyDigits {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a String: ");
		String str = scan.nextLine();
		
		boolean containDigits = true;
		for (int i = 0; i < str.length(); i++) {
			if (!(Character.isDigit(str.charAt(i)))) {
				containDigits = false;
				break;
			}
		}
		
		if (containDigits) {
			System.out.println("String contains only digits");
		} else {
			System.out.println("String does NOT contain only digits");
		}
		scan.close();

	}

}
