package Basics_ALgorithms;

import java.util.Scanner;

public class Contains_Duplicate {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of elements in the array: ");
		int num = scan.nextInt();
		scan.nextLine();
		
		int[] arr = new int[num];
		
		System.out.println("Enter array elements: ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		
		boolean duplicate = false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					duplicate = true;
					break;
				}
			}
		}
		System.out.println("\nDuplicate element found: " + duplicate);
		scan.close();

	}

}
