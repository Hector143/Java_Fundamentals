package Basics_ALgorithms;

import java.util.Scanner;

public class Count_Occurence_array {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of elements in the array: ");
		int num = scan.nextInt(); scan.nextLine();
		
		int[] arr = new int[num];
		System.out.println("Enter array elements: ");
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt(); scan.nextLine();
		}
		
		System.out.print("Enter element to count: ");
		int count = scan.nextInt(); scan.nextLine();
		
		int occurence = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == count) {
				occurence++;
			}
		}
		
		System.out.println("Element " + count + " occurs " + occurence + " times in the array.");
		scan.close();
	}

}
