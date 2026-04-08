package Level_1_Basic_Array_Manipluation;

import java.util.Arrays;
import java.util.Scanner;

public class Remove_Duplicates_From_Sorted_Array {

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
		
		int[] temp = new int[num];
		int index = 0;
		
		Arrays.sort(arr);
		for (int i = 0; i < num; i++) {
			if (i == 0 || arr[i] != arr[i-1])  {
				temp[index] = arr[i];
				index++;
			}
		}
		
		System.out.println("Number of unique elements " + index);
		System.out.println("Array after removing duplicates:");
		for (int i = 0; i < index; i++) {
			System.out.print(temp[i] + " ");
		}
		
		scan.close();

	}

}
