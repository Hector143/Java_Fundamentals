package Strings_And_Simple_Logics;

import java.util.Scanner;

public class String_Rotation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("String 1: ");
		String str1 = scan.nextLine();
		System.out.print("String 2: ");
		String str2 = scan.nextLine();
		
		if (str1.length() == str2.length() && (str1 + str1).contains(str2)) {
            System.out.println("Yes, Rotation");
        } else {
            System.out.println("Not a Rotation");
        }
		scan.close();
	}

}
