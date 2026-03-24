package hey;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Transaction_Log_Balance_Summary {
	static FileWriter wr;
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		File file = new File("grade_report.txt");
		String data = "";
		int options = 0;
		int balance = 0;
		int count = 1;
		data += "------------------------------------------------------------\n";
		data += "\t\t\tTRANSACTION LOG\n";
		data += "------------------------------------------------------------\n";
		data += "No.\t| Type\t\t|Amount | Result\t\t\t| Balance\n";
		data += "------------------------------------------------------------\n";
		wr = new FileWriter(file);
		wr.write(data);
		wr.flush();
		do {
			
			System.out.println("------------------------------");
			System.out.println("\tTRANSACTION MENU");
			System.out.println("------------------------------");
			System.out.println("1 - DEPOSIT");
			System.out.println("2 - WITHDRAW");
			System.out.println("3 - VIEW TRANSACTION LOG");
			System.out.println("4 - EXIT");
			System.out.print("Choice: ");
			options = scan.nextInt();
			scan.nextLine();
			System.out.println();
			switch (options) {
			case 1: 
				wr.write(count + "\t");
				wr.flush();
				balance = deposit(scan,balance);
				count++;
				break;
			case 2: 
				wr.write(count + "\t");
				wr.flush();
				balance = withdraw(scan,balance);
				count++;
				break;
			case 3: 
				displayTransactionLog(file);
				System.out.println("------------------------------------------------------------");
				System.out.println("\n\n");
				break;
			default: 
				System.out.println("Program exited.");
				wr.write("------------------------------------------------------------\n"); 
				wr.flush();
				break;
				
			}
			
			
		} while (options != 4);
		wr.write("------------------------------------------------------------\n"); 
		wr.close();
		scan.close();
		System.exit(0);

	}
	
	public static void initFile(File file) {
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.out.println("Something went wrong!");
		}
		
	}
	
	public static int deposit(Scanner scan, int balance) throws IOException {
		System.out.print("Enter amount to deposit: ");
		int deposit = scan.nextInt();
		scan.nextLine();
		wr.write("| DEPOSIT\t| " + deposit + "\t| ");
		if (deposit < 0) {
			System.out.println("FAILED - Insufifcient Funds");
			System.out.println("Current balance: " + balance);
			
			System.out.println("\n\n");
			wr.write("FAILED - Insufficient Funds\t| "  + balance + "\n");
			wr.flush();
			return balance;
		} else {
			balance += deposit;
			System.out.println("Deposit Successful!");
			System.out.println("Current balance: " + balance);
			
			wr.write("Success\t\t\t| " + balance + "\n");
			wr.flush();
			return balance;
		}
		
	}
	
	public static int withdraw(Scanner scan, int balance) throws IOException {
		System.out.print("Enter amount to withdraw: ");
		int withdraw = scan.nextInt();
		scan.nextLine();
		wr.write("| WITHDRAW\t| " + withdraw + "\t| ");
		if (withdraw >= balance) {
			System.out.println("FAILED - Insufifcient Funds");
			System.out.println("Current balance: " + balance);
			
			wr.write("FAILED - Insufficient Funds\t| "  + balance + "\n");
			wr.flush();
			return balance;
		} else {
			System.out.println("Withdrawal Successful!");
			
			balance -= withdraw;
			System.out.println("Current balance: " + balance);
			
			wr.write("Success\t\t\t| " + balance + "\n");
			wr.flush();
			return balance; 
		}
	}
	
	public static void displayTransactionLog(File file) {
		try {
			Scanner read = new Scanner(file);
			while(read.hasNextLine()) {
				System.out.println(read.nextLine());
			}
			read.close();
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
	}

}
