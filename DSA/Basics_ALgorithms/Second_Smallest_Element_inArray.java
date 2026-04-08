package Basics_ALgorithms;
import java.util.Arrays;
import java.util.Scanner;
public class Second_Smallest_Element_inArray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("number of elements in array: ");
		int num = scan.nextInt(); scan.nextLine().trim();
		int[] elements = new int[num];
		for(int i = 0; i < elements.length; i++) {
			elements[i] = scan.nextInt(); scan.nextLine().trim();
		}
		scan.close();
		int smallest = 1000;
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] < smallest) {
				smallest = elements[i];
			}
		}
		
		int secondSmallest = 1000;
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] != smallest && elements[i] < secondSmallest) {
				secondSmallest = elements[i];
			}
		}
		
		System.out.println(Arrays.toString(elements));
		System.out.println("The Second Smallest element in the array is: " + secondSmallest);
	}

}
