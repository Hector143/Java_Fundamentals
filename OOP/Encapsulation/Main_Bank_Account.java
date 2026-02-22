package Encapsulation;

public class Main_Bank_Account {

	public static void main(String[] args) {
		Bank_Account b = new Bank_Account();
		
		b.setAccountNumber("SB-09876");
		b.setBalance(2000.0);
		
		String accountNumber = b.getAccountNumber();
		double balance = b.getBalance();
		
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Balance: " + balance);

	}

}
