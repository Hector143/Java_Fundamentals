package Strings_And_Simple_Logics;

import java.util.Scanner;

public class Palindrome_1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter String: ");
		String str = scan.nextLine();
		scan.close();
		String palindrome = "Palindrome";
		int i = 0; 
		int j = str.length()-1;
		while (i <= j) {
			if (str.charAt(i)!=str.charAt(j)) {
				palindrome = "Not Palindrome";
				break;
			}
			i++;
			j--;
		}
		System.out.println(palindrome);

	}

}
