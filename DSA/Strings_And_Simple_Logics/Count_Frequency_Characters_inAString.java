package Strings_And_Simple_Logics;

import java.util.Scanner;

public class Count_Frequency_Characters_inAString {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter String: ");
		String str = scan.nextLine();
		
		String contain = "";
		for (int i = 0; i < str.length(); i++) {
			int count = 0;
			int letcount = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					count++;
					
				}
				
			}
			
			for (int j = i + 1; j < str.length()-1; j++) {
				if (str.charAt(i) == str.charAt(j)) {
					letcount++;
				}
				
			}
			
			if (letcount != 1) {
				contain += str.charAt(i) + " = " + count + "\n";
			}
			
			
		}
		
		System.out.println(contain);

	}

}
