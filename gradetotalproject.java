package hectorproject;

import java.util.Scanner;

public class gradetotalproject {

	public static void main(String[] args) {
		// General Average of S.Y. 2024-2025 sum of all grades from 1st,2nd,3rd,4th quarter.
		Scanner scanner = new Scanner(System.in);
		
		double input1, input2, input3, input4;
		
		System.out.println("Enter your first quarter average grade: ");
		input1 = scanner.nextDouble(); 
		System.out.println("Enter your second quarter average grade: ");
		input2 = scanner.nextDouble();
		System.out.println("Enter your third quarter average grade: ");
		input3 = scanner.nextDouble();
		System.out.println("Enter your fourth quarter average grade: ");
		input4 = scanner.nextDouble();
		
		double gradestotal = (input1 + input2 + input3 + input4) / 4;
		if (gradestotal >= 100) {
			System.out.println("Invalid Grades!");
		} else if (gradestotal > 97.99) {
			System.out.println("With Highest Honors!");
		} else if (gradestotal > 94.99) {
			System.out.println("With High Honors!");
		} else if (gradestotal > 89.99) {
			System.out.println("With Honors!");	
		} else if (gradestotal > 74.99) {
			System.out.println("Passed");
		} else if (gradestotal < 75) {
			System.out.println("Failed!");
		}
		scanner.close();
	} 

}
