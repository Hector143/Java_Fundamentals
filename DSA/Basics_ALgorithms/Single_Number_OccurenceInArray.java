package Basics_ALgorithms;

import java.util.Scanner;

public class Single_Number_OccurenceInArray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of elements in the array: ");
		int num = scan.nextInt(); scan.nextLine();
		
		int[] arr = new int[num];
		System.out.println("Enter array elements: ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		
		int sNum = -1;
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
				}
			}
			if (count == 1) {
				sNum = arr[i];
				break;
			}
		}
		
		
		System.out.println("\nSingle number is: " + sNum);
		scan.close();
	}

}
