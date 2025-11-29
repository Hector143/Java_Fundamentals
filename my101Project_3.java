package anotherprojecthek;

import java.util.Scanner;

public class my101Project_3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int NumberOfMessages;
		int freeMessages = 100;
		int LimitMessages = 300;
		double basicRate = 5.00;
		double TaxRate = 0.14;
		double AdditionalCharge = 0.0;
		double AdditionalRate3 = 0.03;
		double AdditionalRate2 = 0.02;
		
		
		System.out.println("Enter the number of times you send a text message in a month: ");
		NumberOfMessages = scan.nextInt();
		
		if (NumberOfMessages > freeMessages) {
			int chargedMessages = NumberOfMessages - freeMessages; 
			if(NumberOfMessages <= LimitMessages) {
				AdditionalCharge = chargedMessages * AdditionalRate3;
			} else {
				int firstTierMessages = LimitMessages - freeMessages;
				int secondTierMessages = NumberOfMessages - LimitMessages;
				AdditionalCharge = (firstTierMessages * AdditionalRate3) + (secondTierMessages * AdditionalRate2);
				
			}
		} 
		
		double subtotal = basicRate + AdditionalCharge;
		double tax = subtotal * TaxRate;
		double total = subtotal + tax;
		
		System.out.println("the number of text messages sent this month: " + NumberOfMessages);
		System.out.printf("%nbase MonthlyFee: $%.2f%n", basicRate);
		System.out.printf("%nAdditional Charges: $%.2f%n" , AdditionalCharge);
		System.out.printf("%nTax(14%%): $%.2f%n" , tax);
		System.out.printf("%nTotal Bill: $%.2f%n", total);
		
			
		scan.close();	
		
		

	}

}
