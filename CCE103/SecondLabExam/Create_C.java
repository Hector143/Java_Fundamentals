package SecondLabExam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Create_C {
	private mainWindow_V view;
	private ArrayList<Loan_M> loanList;
	private String fileName = "loans.txt";
	public Create_C(mainWindow_V view, ArrayList<Loan_M> loanList) {
		this.view = view;
		this.loanList = loanList;
	}

	public void addLoanRecord() {
		try {
			File file = new File(fileName);
			if (!file.exists()) file.createNewFile();
			String id = view.txtId.getText().trim();
			String name = view.txtName.getText().trim();
			double amount = Double.parseDouble(view.txtAmount.getText().trim());
			double rate = Double.parseDouble(view.txtRate.getText().trim());
			int term = Integer.parseInt(view.txtTerm.getText().trim());
			String date = view.txtDate.getText().trim();
			String status = view.status.getSelectedItem().toString();
			String notes = view.txtNotes.getText().trim();

			if (id.isEmpty() || name.isEmpty() || date.isEmpty() 
					|| notes.isEmpty()) { 
				JOptionPane.showMessageDialog(null, "Field Missing!" ,"Error Message", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			Loan_M loan = new Loan_M(id, name, amount, rate, term, date, status, notes);
			loanList.add(loan);
			
			saveToFile();
			refreshTable();
			clearFields();
			JOptionPane.showMessageDialog(null, "Loan Added to Records!");
		} catch (NumberFormatException e ) {
			JOptionPane.showMessageDialog(null, "amount, rate and term should be number", "Error Message", JOptionPane.ERROR_MESSAGE);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Cannot find Record!" ,"Error Message", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void saveToFile() {
		try {
			FileWriter fw = new FileWriter("loans.txt", true);
			for (Loan_M l : loanList) {
				fw.write(l.toFileString() + "\n");
			}
			fw.close();
			JOptionPane.showMessageDialog(null, "Updated Successfully!");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error updating file ", "Error Message", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
	public void clearFields() {
		view.txtId.setText("");
		view.txtName.setText("");
		view.txtAmount.setText("");
		view.txtRate.setText("");
		view.txtTerm.setText("");
		view.txtDate.setText("");
		view.txtNotes.setText("");
		view.status.setSelectedItem(0);
	}
	
	public void refreshTable() {
		view.model.setRowCount(0);
		for (Loan_M l : loanList) {
			Object[] row = {l.getId(),l.getName(),l.getAmount(),
					l.getRate(), l.getTerm(), l.getDate(),
					l.getStatus(), l.getNotes()};
			view.model.addRow(row);
		}
	}

}
