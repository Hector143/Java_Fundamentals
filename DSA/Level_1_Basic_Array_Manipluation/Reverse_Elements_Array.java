package Level_1_Basic_Array_Manipluation;

import java.util.Arrays;
import java.util.Scanner;

public class Reverse_Elements_Array {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("how many elements in array? ");
		int num = scan.nextInt(); scan.nextLine().trim();
		
		int[] arr = new int[num];
		for (int i = 0; i < arr.length; i++) {
			System.out.print("Enter element [" + i  + "]: ");
			arr[i] = scan.nextInt(); scan.nextLine().trim();
		}
		scan.close();
		int[] reverse = new int[arr.length];
		int a = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			reverse[a] = arr[i];
			a++;
		}
		
		System.out.println("Original Arrays: " + Arrays.toString(arr));
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = reverse[i];
		}
		
		System.out.println("Reversed Arrays: " + Arrays.toString(arr));
		
	}

}
