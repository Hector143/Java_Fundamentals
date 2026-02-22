package Projects;

public class CheckingAccount1 extends Account1 {

	public CheckingAccount1(int accountNumber, double balance) {
		super(accountNumber, balance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateFinalBalance() {
		return getBalance();
	}

}
