package LoanMagementSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CRUDS_Controller_C {
	public ArrayList<Loan_M> loanList;
	private static final String fileName = "home_loans.txt";
	private static File file = new File(fileName);
	public CRUDS_Controller_C(ArrayList<Loan_M> loanList) {
		this.loanList = loanList;
		initFile();
	}

	public void createLoan(Loan_M l) {
		loanList.add(l);
		saveToFile();
	}
	public void updateLoan(int index, Loan_M l) {
		loanList.set(index, l);
		saveToFile();
	}
	public void deleteLoan(int index) {
		loanList.remove(index);
		saveToFile();
	}
		
	public boolean isDuplicate(String id) {
		for (Loan_M l : loanList) {
			if (l.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	public void initFile() {
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveToFile() {
		try {
			FileWriter fw = new FileWriter(fileName);
			for(Loan_M l: loanList) {
				fw.write(l.toFileString() + "|");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readFromFile() {
		loanList.clear();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = br.readLine()) != null) {
				String[] split = line.split("\\|");
				Loan_M l = new Loan_M(
						split[0],
						split[1],
						split[2],
						split[3],
						split[4],
						split[5],
						split[6],
						split[7]);
				loanList.add(l);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
