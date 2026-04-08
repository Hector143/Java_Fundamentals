package Basics_ALgorithms;

import java.util.Scanner;

public class Average_of_Array {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int size = scan.nextInt(); scan.nextLine().trim();
		
		System.out.println("Enter the elements of the array: ");
		int[] elements = new int[size];
		int avg = 0;
		
		for (int i = 0; i < elements.length; i++) {
			System.out.print("Element " + (i+1) + ": ");
			elements[i] = scan.nextInt(); scan.nextLine().trim();
			avg += elements[i];
		}
		avg = avg / elements.length;
		System.out.println("The average of elements in the array is: " + avg);
		scan.close();

	}

}
