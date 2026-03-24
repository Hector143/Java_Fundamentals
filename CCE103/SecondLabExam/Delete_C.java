package SecondLabExam;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Delete_C {
	private mainWindow_V view;
	private ArrayList<Loan_M> loanList;

	public Delete_C(mainWindow_V view, ArrayList<Loan_M> loanList) {
		this.view = view;
		this.loanList = loanList;
	}
	
	public void removeLoan() {
		int selectedRow = view.table.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "Select a record to delete");
			return;
		}
		
		int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete record?", "Confirm Delete", JOptionPane.YES_NO_CANCEL_OPTION);
		if (confirm != JOptionPane.YES_OPTION) return;
		
		loanList.remove(selectedRow);
		
		saveToFile();
		clearFields();
		refreshTable();
		JOptionPane.showMessageDialog(null, "Deleted Successfully!");
	}
	
	public void saveToFile() {
		try {
			FileWriter fw = new FileWriter("loans.txt");
			for (Loan_M l : loanList) {
				fw.write(l.toFileString() + "\n");
			}
			fw.close();
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
