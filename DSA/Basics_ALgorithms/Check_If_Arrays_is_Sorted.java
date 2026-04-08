package Basics_ALgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Check_If_Arrays_is_Sorted {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("How many elements? ");
		int num = scan.nextInt(); scan.nextLine().trim();
		
		int[] arr = new int[num];
		for (int i = 0; i < arr.length; i++) {
			System.out.print("Enter element [" + i  + "]: ");
			arr[i] = scan.nextInt(); scan.nextLine().trim();
		}
		
		scan.close();
		System.out.print("\nCheck if arrays is sorted: ");
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i +1]) {
				System.out.println(Arrays.toString(arr));
				System.out.println(false);
				return;
				
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(true);
		return;

	}
	
	

}
