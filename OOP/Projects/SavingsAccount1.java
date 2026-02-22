package Projects;

public class SavingsAccount1 extends Account1 implements Taxable1{

	public SavingsAccount1(int accountNumber, double balance) {
		super(accountNumber, balance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyTax() {
		double tax = getBalance() * 0.05;
		setBalance(getBalance() - tax);
		
	}
	
	@Override
	public double calculateFinalBalance() {
		applyTax();
		return getBalance();
	}
	
}
