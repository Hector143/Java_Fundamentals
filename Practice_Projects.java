package anotherprojecthek;

import java.util.Scanner;

public class Practice_Projects {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		int input1, input2;
		
		System.out.println("Enter a 1st number: ");
		input1 = scanner.nextInt();
		System.out.println("Enter a 2st number: ");
		input2 = scanner.nextInt();
		
		
		int bitwise = input1 & input2;
		
		System.out.println(bitwise);
	}

}
