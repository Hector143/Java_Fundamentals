package java_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Project_1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter 5 integer: ");
		int[] integer = new int[5];
		
		for (int i = 0; i < 5; i++) {
			integer[i] = scan.nextInt();
		}
		Arrays.sort(integer);
		
		System.out.println("The smallest number is: " + integer[0]);
		System.out.println("The largest number is: " + integer[integer.length - 1]);
	}

}
