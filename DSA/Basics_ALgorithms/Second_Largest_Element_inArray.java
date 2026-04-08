package Basics_ALgorithms;

import java.util.Arrays; // this is optional but i used Arrays.toString to see the stored value in the array. 
import java.util.Scanner; // when you like user inputs

public class Second_Largest_Element_inArray {

	public static void main(String[] args) {
		// optional but better when you want user input.
		Scanner scan = new Scanner(System.in);
		System.out.print("number of elements in array: ");
		// this is variable for number of elements.
		int num = scan.nextInt(); scan.nextLine();
		// make an array with a fixed size num.
		int[] elements = new int[num];
		// loop through array to input the elements.
		for(int i = 0; i < elements.length; i++) {
			elements[i] = scan.nextInt(); scan.nextLine();
		}
		
		// find largest first .
		int Largest = 0;
		System.out.println("");
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] > Largest) {
				Largest = elements[i]; // the largest keep replacing the higher elements[i] value.
			}
		}
		// get largest again but not equal to the previous largest number.
		int secLargest = 0;
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] != Largest && elements[i] > secLargest) { 
				secLargest = elements[i]; // the second largest element in array.
			}
		}
		
		System.out.println(Arrays.toString(elements)); // printing the stored arrays. which is elements
		System.out.println("Second largest element in array is: " + secLargest); // print the output
		scan.close();
	}

}

