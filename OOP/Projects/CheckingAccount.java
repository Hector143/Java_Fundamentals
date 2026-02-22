package Projects;

public class CheckingAccount extends Account{

	public CheckingAccount(int accountNumber, double balance) {
		super(accountNumber, balance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateFinalBalance() {
		return getBalance();
	}

}
