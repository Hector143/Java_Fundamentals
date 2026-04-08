package Strings_And_Simple_Logics;

import java.util.Scanner;

public class Remove_Vowels_from_String {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter a String: ");
		String str = scan.nextLine();
		
		String strN = "";
		System.out.print("final String: ");
		for (int i = 0; i < str.length(); i++) {
			if (!(str.charAt(i) == 'a' || str.charAt(i) == 'e' ||str.charAt(i) == 'i' ||
				str.charAt(i) == 'o' || str.charAt(i) == 'u' || str.charAt(i) == 'A' ||
				str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'O' ||
				str.charAt(i) == 'U' )) {
				strN += str.charAt(i);
			}
		}
		System.out.print(strN);
		scan.close();
	}

}
