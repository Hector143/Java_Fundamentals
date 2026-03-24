package SecondLabExam;

public class HomeLoan_M extends Loan_M implements LoanOperable{

	public HomeLoan_M(String id, String name, double amount, double rate, int term, String date, String status,
			String notes) {
		super(id, name, amount, rate, term, date, status, notes);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calculateLoan() {
		// TODO Auto-generated method stub
		return 0;
	}

}
