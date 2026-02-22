package Projects;

public class Main_level1 {

	public static void main(String[] args) {
		
		BankAccount bank = new BankAccount();
		
		bank.setAccountNumber("H-563565");
		bank.setbalance(2000.0);
		
		String accountNumber = bank.getAccountNumber();
		double balance = bank.getbalance();
		
		System.out.println("Your Account Number: " + accountNumber);
		System.out.println("Current balance : " + balance);

	}

}
