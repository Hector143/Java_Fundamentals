package Basics_ALgorithms;

import java.util.Scanner;

public class Array_Traversal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int size = scan.nextInt();
		
		System.out.println("Enter the elements of the array: ");
		int[] elements = new int[size];
		
		for (int i = 0; i < elements.length; i++) {
			System.out.print("Element " + (i+1) + ": ");
			elements[i] = scan.nextInt(); scan.nextLine().trim();
		}
		
		System.out.println("Print in columns:");
		
		for (int i = 0; i < elements.length; i++) {
			System.out.print(elements[i] + " ");
		}
		scan.close();

	}

}
