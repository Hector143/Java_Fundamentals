package Level_1_Basic_Array_Manipluation;

import java.util.Arrays;
import java.util.Scanner;

public class Rotate_Array_By_One {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of elements: ");
		int num = scan.nextInt(); scan.nextLine();
		
		int[] arr = new int[num];
		System.out.println("Enter array elements: ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		System.out.println("Array before rotating by one: \n" + Arrays.toString(arr));
		System.out.println("Array after rotating by one: ");
		int temp[] = new int[num];
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				temp[0] = arr[arr.length-1];
				break;
			}
			count++;
			temp[count] = arr[i];
		}
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = temp[i];
		}
		System.out.println(Arrays.toString(arr));
		scan.close();
	}

}
