package Projects;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main_BankAccount1 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		
		System.out.print("How many bank accounts? ");
		int n = scan.nextInt(); scan.nextLine();
		
		Account1[] accounts = new Account1[n];
		
		for (int i = 0; i < accounts.length; i++) {
			System.out.println("\nEnter details for Account " + (i+1) + ": ");
			System.out.print("Account type (1 = Savings, 2 = Checking): ");
			int type = scan.nextInt(); scan.nextLine();
			
			System.out.print("Account Number: ");
			int accNum = scan.nextInt(); scan.nextLine();
			
			System.out.print("Initial Balance: ");
			double balance = scan.nextDouble(); scan.nextLine();
			
			
			
			if (type == 1) {
				accounts[i] = new SavingsAccount1(accNum, balance);
			} else if (type == 2) {
				accounts[i] = new CheckingAccount1(accNum, balance);
			} else {
				System.out.println("Invalid input!");
				i--;
			}
		}
		
		String text = "";
		
		for (int i = 0; i < accounts.length; i++) {
			double finalBalance = accounts[i].calculateFinalBalance();
			String catName = (accounts[i] instanceof SavingsAccount1) ? "Savings Account": "Checking Account";
			text += "Account " + accounts[i].getAccountNumber() + " - " + catName + " - Final Balance: ₱" + finalBalance + "\n";
		}
		System.out.println("\n" + text);
		saveToFile(text);
		System.out.println("\nSaved report to bank_report1.txt");
	}
	
	
	public static void saveToFile(String text) {
		try {
			FileWriter fw = new FileWriter("bank_report1.txt", true);
			fw.write(text + "\n");
			fw.close();
		} catch (IOException e) {
			System.err.println("Something went wrong!");
		} 
	}

}
