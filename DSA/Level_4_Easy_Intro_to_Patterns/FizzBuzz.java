package Level_4_Easy_Intro_to_Patterns;

import java.util.Arrays;
import java.util.Scanner;

public class FizzBuzz {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of elemnts in array: ");
		int n = scan.nextInt(); scan.nextLine();
		
		String[] arr = new String[n];
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print("Element [" + i + "]: ");
			arr[i] = scan.nextLine();
		}
		
		System.out.println("Original Arrays: " + Arrays.toString(arr));
		fizzBuzz(arr);
		System.out.println("Arrays After FizzBuzz: " + Arrays.toString(arr));
		scan.close();
	}
	
	public static String[] fizzBuzz(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int num = Integer.parseInt(arr[i]);
			if (num % 5 == 0 && num % 3 == 0) {
				arr[i] = "FizzBuzz";
			} else if (num % 5 != 0 && num % 3 == 0) {
				arr[i] = "Fizz";
			} else if (num % 5 == 0 && num % 3 != 0) {
				arr[i] = "Buzz";
			} else {
				arr[i] = arr[i];
			}
		}
		return arr;
	}

}
