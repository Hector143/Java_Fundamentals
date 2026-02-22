package Projects;

public class balance {
	private double balance;
	private double amount;
	
	public balance() {
		this.balance = 0;
	}
	
	//desposit
	public void deposit(double amount) {
		if(amount > 0) {
			balance += amount;
			System.out.println("Deposited: " + amount);
		} else {
			System.out.println("Invalid deposited amount!");
		}
		
	}
	
	// withdraw
	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
			System.out.println("Withdrawn: " + amount);
		} else {
			System.out.println("Insufficient funds or Invalid amount!");
		}
	}
	
	public void checkBalance() {
		System.out.println("Current Balance: " + balance);
		
	}
}
