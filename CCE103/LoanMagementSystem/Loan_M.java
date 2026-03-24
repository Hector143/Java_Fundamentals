package LoanMagementSystem;

public class Loan_M {
	private String id;
	private String name;
	private String amount;
	private String rate;
	private String term;
	private String date;
	private String status;
	private String notes;

	public Loan_M(String id, String name, String amount, String rate, String term, String date, String status,
			String notes) {
		setId(id);
		setName(name);
		setAmount(amount);
		setRate(rate);
		setTerm(term);
		setDate(date);
		setStatus(status);
		setNotes(notes);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public String getRate() {
		return rate;
	}


	public void setRate(String rate) {
		this.rate = rate;
	}


	public String getTerm() {
		return term;
	}


	public void setTerm(String term) {
		this.term = term;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public String toFileString() {
		return id + "|" + name + "|" + amount + "|"
				+ rate + "|" + term + "|" + date + "|"
				+ status + "|" + notes ;
	}

	public String[] getFileInfo() {
		String[] info = {getId(), getName(), getAmount(), getRate(), getTerm(), getDate(), getStatus(), getNotes()};
		return info;
	}
}


