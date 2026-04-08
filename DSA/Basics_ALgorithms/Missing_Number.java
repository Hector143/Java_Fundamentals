package Basics_ALgorithms;

import java.util.Scanner;

public class Missing_Number {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of elements in the array: ");
		int num = scan.nextInt(); scan.nextLine();
		
		int[] arr = new int[num];
		System.out.println("Enter array elements: ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		
		
		int sum = 0;
		for (int i = 0; i < arr.length + 1; i++) {
		    sum += i;
		    
		}
		int missingNum = 0;
		int tempsum = 0;
		for (int i = 0; i < arr.length; i++) {
			tempsum += arr[i];
		}
		
		missingNum = (sum - tempsum);
		System.out.println("\nMissing number is: " + missingNum);
		scan.close();
		

	}

}
