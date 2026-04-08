package Basics_ALgorithms;

import java.util.Scanner;

public class Smallest_Element_in_an_Array2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int size = scan.nextInt();
		
		System.out.println("Enter the elements of the array: ");
		int[] elements = new int[size];
		
		int smallest = 1000000;
		for (int i = 0; i < elements.length; i++) {
			System.out.print("Element " + (i+1) + ": ");
			elements[i] = scan.nextInt(); scan.nextLine().trim();
			if (elements[i] < smallest) {
				smallest = elements[i];
			}
		}
		System.out.println("The smallest element of array is: " + smallest);
		scan.close();

	}

}
