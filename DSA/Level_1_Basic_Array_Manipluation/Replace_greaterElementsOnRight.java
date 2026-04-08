package Level_1_Basic_Array_Manipluation;

import java.util.Scanner;

public class Replace_greaterElementsOnRight {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of elements: ");
		int num = scan.nextInt();
		scan.nextLine();
		
		int[] arr = new int[num];
		System.out.println("Enter array elements: ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		
		for (int i = 0; i < arr.length; i++) {
			int max = -1; // this outputs when inner loop no longer runs.
			for (int j = i + 1 ; j < arr.length; j++) {
				if (arr[j] > max) {
					max = arr[j];
				}
			}
			arr[i] = max; // 
		}
		
		// print output
		System.out.println("Array after replacement: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		scan.close();
	}

}
