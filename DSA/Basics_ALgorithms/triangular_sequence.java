package Basics_ALgorithms;

import java.util.Scanner;

public class triangular_sequence {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter Nth term in array: ");
		int n = scan.nextInt(); scan.nextLine();
		
		
		int sum = 0;
		
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		
		System.out.println("Nth term " + n + " in triangular pyramid is: " + sum);
		

	}

}
