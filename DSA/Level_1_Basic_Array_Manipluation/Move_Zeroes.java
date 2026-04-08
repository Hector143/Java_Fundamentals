package Level_1_Basic_Array_Manipluation;

import java.util.Scanner;

public class Move_Zeroes {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of elements: ");
		int num = scan.nextInt(); scan.nextLine();
		
		int[] arr = new int[num];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		System.out.println("Array before moving zeroes: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println("\nArray after moving zeroes: ");
		int temp[] = new int[num];
		int j = 0;
		for (int i = 0; i < temp.length; i++) {
			if (arr[i] != 0) {
				temp[j] = arr[i]; // we could use temp[i] but i just use it so that it wont confuse the viewers.
				j++; 
			}
		}
		
		// since the temp array is not fully complete we should all the rest of the elments which is zeroes add to fil up the remaining temp array matches arr array length;
		while (j < arr.length) {
			temp[j] = 0;
			j++;
		}
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = temp[i];
			System.out.print(arr[i] + " ");
		}
		
		
		// easier way is
		
//		int count = 0;
//		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] != 0) 
//				arr[count++] = arr[i];
//			
//		}
//		while (count < arr.length)
//			arr[count++] = 0;
		
		
		scan.close();
	}

}
