package SecondLabExam2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CRUD_C {
	private mainWindow_V view;
	private ArrayList<Employee_M> employeeList;
	public static final String fileName = "employee.txt";
	public static File file = new File(fileName);
	public CRUD_C(mainWindow_V view, ArrayList<Employee_M> employeeList) {
		this.view = view;
		this.employeeList = employeeList;
	}

	public void addEmployee() {
		try {
			initFile();
			String id = view.txtId.getText().trim();
			String name = view.txtName.getText().trim();
			double salary = Double.parseDouble(view.txtSalary.getText().trim());
			double rate = Double.parseDouble(view.txtRate.getText().trim());
			double bonus = Double.parseDouble(view.txtBonus.getText().trim());
			String notes = view.txtNotes.getText().trim();
			String status = view.selectStatus.getSelectedItem().toString();
			String department = view.selectDepartment.getSelectedItem().toString();
			
			if (isDuplicateId(id)) {
				JOptionPane.showMessageDialog(null, "Employee ID already exists!", "Duplicate ID!", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (id.isEmpty() || name.isEmpty() || notes.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Field Missing!" ,"Field is Empty!", JOptionPane.WARNING_MESSAGE);
				return;
			}
				
			Employee_M e = new Employee_M(id,name,department,salary,rate,bonus,status,notes);
			employeeList.add(e);
			saveToFile();
			refreshTable();
			clearFields();
			JOptionPane.showMessageDialog(null, "Added Employee Record Successfully!");
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Error saving File!");
		}
	}

	public void displayEmployee() {
		employeeList.clear(); 
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while((line = br.readLine()) != null) {
				String[] parts = line.split("\\|");

				Employee_M e = new Employee_M(
	                    parts[0],
	                    parts[1],
	                    parts[2],
	                    Double.parseDouble(parts[3]),
	                    Double.parseDouble(parts[4]),
	                    Double.parseDouble(parts[5]),
	                    parts[6],
	                    parts[7]
	            );

	            employeeList.add(e);
			}
			br.close();
			refreshTable();
		} catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Error Reading file!");
		}
	}

	public void updateEmployee() {
		int selectedRow = view.table.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "Select a record to update");
			return;
		}
		if (	view.txtId.getText().trim().isEmpty() ||
				view.txtName.getText().trim().isEmpty() ||
				view.txtSalary.getText().trim().isEmpty() || 
				view.txtRate.getText().trim().isEmpty() ||
				view.txtBonus.getText().trim().isEmpty() ||
				view.txtNotes.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "you must input Fields!");
			return;
		}
		
		try {
			int confirm = JOptionPane.showConfirmDialog(null, "Are you going to update record?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
			if (confirm != JOptionPane.YES_OPTION) return;
			Employee_M e = employeeList.get(selectedRow);

			e.setId(view.txtId.getText().trim());
			e.setName(view.txtName.getText().trim());
			e.setDepartment(view.selectDepartment.getSelectedItem().toString());
			e.setSalary(Double.parseDouble(view.txtSalary.getText().trim()));
			e.setRate(Double.parseDouble(view.txtRate.getText().trim()));
			e.setBonus(Double.parseDouble(view.txtBonus.getText().trim()));
			e.setStatus(view.selectStatus.getSelectedItem().toString());
			e.setNotes(view.txtNotes.getText().trim());

			saveToFile();
			clearFields();
			refreshTable();

			JOptionPane.showMessageDialog(null, "Updated Successfully!");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Amount, rate and term should be Numbers!");
			return;
		}
	}

	public void deleteEmployee() {
		int selectedRow = view.table.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "Select a record to delete");
			return;
		}
		
		int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete record?", "Confirm Delete", JOptionPane.YES_NO_CANCEL_OPTION);
		if (confirm != JOptionPane.YES_OPTION) return;
		
		employeeList.remove(selectedRow);
		
		saveToFile();
		clearFields();
		refreshTable();
		JOptionPane.showMessageDialog(null, "Deleted Successfully!");
	}

	public void searchEmployee() {
		String id = view.txtId.getText().trim();
		boolean found = false;
		for (Employee_M e : employeeList) {
			if (e.getId().equals(id)) {
				view.txtName.setText(e.getName());
				view.txtSalary.setText(String.valueOf(e.getSalary()));
				view.txtRate.setText(String.valueOf(e.getRate()));
				view.txtBonus.setText(String.valueOf(e.getBonus()));
				view.selectDepartment.setSelectedItem(0);
				view.selectStatus.setSelectedItem(0);
				view.txtNotes.setText(e.getNotes());

				JOptionPane.showMessageDialog(null, "Loan Record Found!");
				found = true;
				break;
			}
		}
		if (!found) {
		    JOptionPane.showMessageDialog(null, "Loan Record Not Found!");
		    clearFields();
		}
	}

	public void refreshTable() {
		view.model.setRowCount(0);
		for (Employee_M e: employeeList) {
			Object[] row = {e.getId(), e.getName(),
					e.getDepartment(), e.getSalary(),
					e.getRate(), e.getBonus(), e.getStatus(),
					e.getNotes()
			};
			view.model.addRow(row);
		}
	}
	public void clearFields() {
		view.txtId.setText("");
		view.txtName.setText("");
		view.txtSalary.setText("");
		view.txtRate.setText("");
		view.txtBonus.setText("");
		view.txtNotes.setText("");
		view.selectDepartment.setSelectedItem(0);
		view.selectStatus.setSelectedItem(0);
	}
	public void saveToFile() {
		try {
			FileWriter fw = new FileWriter(file);
			for (Employee_M e: employeeList) {
				fw.write(e.toFileString() + "\n");
			}
			fw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error saving File!");
		}
	}
	public void initFile() {
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error File Creation!");
		}
	}
	public boolean isDuplicateId(String id) {
		for (Employee_M e : employeeList) {
			if (e.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
}
