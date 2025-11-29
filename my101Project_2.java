package anotherprojecthek;

import java.util.Scanner;

public class my101Project_2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// SHOPPING CART PROGRAM
		String food;
		int quantity;
		double price;
		
		
		System.out.print("What item would you like to buy?: ");
		food = scan.nextLine();
		System.out.print("What is the price for each?: ");
		price = scan.nextDouble();
		System.out.print("How many would you like?: ");
		quantity = scan.nextInt();
		
		double sum = price * quantity;
		
		System.out.println("You have bought " + quantity + " " + food + "/s");
		System.out.println("Your total is $" + sum);
		
	}

}
