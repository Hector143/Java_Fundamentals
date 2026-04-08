package Basics_ALgorithms;

import java.util.Scanner;

public class Largest_Element_in_an_Array {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int size = scan.nextInt();
		
		System.out.println("Enter the elements of the array: ");
		int[] elements = new int[size];
		
		int largest = 0;
		for (int i = 0; i < elements.length; i++) {
			System.out.print("Element " + (i+1) + ": ");
			elements[i] = scan.nextInt(); scan.nextLine().trim();
			if (elements[i] > largest) {
				largest = elements[i];
			}
		}
		System.out.println("The largest element of array is: " + largest);
		scan.close();

	}

}
