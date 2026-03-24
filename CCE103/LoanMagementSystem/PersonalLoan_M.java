package LoanMagementSystem;

public class PersonalLoan_M extends Loan_M implements LoanOperable{


	public PersonalLoan_M(String id, String name, String amount, String rate, String term, String date, String status,
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
