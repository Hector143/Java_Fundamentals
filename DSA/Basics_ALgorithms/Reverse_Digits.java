package Basics_ALgorithms;

import java.util.Scanner;

public class Reverse_Digits {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter digits: ");
		int n = scan.nextInt();
		int reversed = 0;
		System.out.println("Original number: " + n);
		while (n != 0) {
			int digit = n % 10;
			reversed = reversed * 10 + digit;
			n /= 10;
		}
		System.out.println("Reversed number: " + reversed);
		

	}

}
