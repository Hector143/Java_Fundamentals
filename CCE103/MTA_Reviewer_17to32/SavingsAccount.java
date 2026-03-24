package MTA_Reviewer_17to32;

public class SavingsAccount extends Account1{
	double rate = 0.02;
	SavingsAccount(double startingBalance) {
		super(startingBalance);
	}
	@Override
	public String toString() {
		return String.valueOf(startingBalance);
	}
}

class Account1 {
	double startingBalance;
	Account1(double startingBalance) {
		this.startingBalance = startingBalance;
	}
}
