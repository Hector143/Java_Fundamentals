package Projects;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main_BankAccount {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("How many bank accounts? ");
		int num = scan.nextInt(); scan.nextLine();
		
		Account[] accounts = new Account[num];
		
		
		for (int i = 0; i < accounts.length; i++) {
			System.out.println("\nEnter details for Account " + (i+1) + ": ");
			System.out.print("Account type (1 = Savings, 2 = Checking): ");
			int type = scan.nextInt(); scan.nextLine();
			
			System.out.print("Account Number: ");
			
			int accNum = scan.nextInt(); scan.nextLine();
			
			System.out.print("Initial Balance: ");
			
			double balance = scan.nextDouble(); scan.nextLine();
			
			if (type == 1) {
				accounts[i] = new SavingsAccount(accNum, balance);
			} else if (type == 2) {
				accounts[i] = new CheckingAccount(accNum, balance);
			} else {
				System.out.println("Invalid account type.");
				i--;
			}
		}
		
		String text = "";
		// or StringBuilder
		try {
			FileWriter fw = new FileWriter("bank_report.txt", true);
			for (int i = 0; i < accounts.length; i++) {

				double finalBalance = accounts[i].calculateFinalBalance();
				String typeName = (accounts[i] instanceof SavingsAccount) ? "Savings Account" : "Checking Account";
				text += "Account " + accounts[i].getAccountNumber() +
						" - " + typeName + 
						" - Final Balance: ₱" + finalBalance + "\n";
				
			}
			System.out.print("\n"+text);
			fw.write(text + "\n");
			fw.close();
			System.out.println("\nSaved report to bank_report.txt");
//			 Alternative and more efficient
//			 for (Account acc : accounts) {
//	                double finalBalance = acc.calculateFinalBalance();
//	                String typeName = (acc instanceof SavingsAccount) ? "Savings Account" : "Checking Account";
//
//	                String output = "Account " + acc.getAccountNumber() +
//	                        " - " + typeName +
//	                        " - Final Balance: ₱" + finalBalance;
//
//	                System.out.println(output);
//	                fw.write(output + "\n");
//	            }
			
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		scan.close();

	}

}
