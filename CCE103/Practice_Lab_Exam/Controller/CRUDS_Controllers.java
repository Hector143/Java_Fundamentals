package Practice_Lab_Exam.Controller;

import Practice_Lab_Exam.Model.Student;
import Practice_Lab_Exam.View.mainWindow;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CRUDS_Controllers {
	private ArrayList<Student> studentList;
	private mainWindow view;
	public static final String fileName = "students2.txt";
	public static File file = new File(fileName);

	public CRUDS_Controllers(mainWindow view ,ArrayList<Student> studentList) { // contructors
		this.studentList = studentList;
		this.view = view;
	}

	// saveToFile 
	// refreshTable
	// clearFields

	public void initFile() {
		try {
			if(!file.exists()) {
				file.createNewFile();
			} 
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "File Error: " + ex.getMessage());
		}
	}
	public void saveToFile() {
		try (FileWriter fw = new FileWriter(fileName)){
			for(Student s : studentList) {
				fw.write(s.toFileString() + "\n");
			}
		} catch (IOException e) {
			System.err.println("Error Message");
		}
	}

	public void refreshTable() {
		view.model.setRowCount(0);

		for (Student s: studentList) {
			Object[] row = new Object[] {
					s.getStudentID(), s.getStudentName(), 
					s.getCourse(), s.getYearLevel(),
					s.getSubject(), s.getMidtermGrade(),
					s.getFinalGrade(), s.getFinalAverage(),
					s.getRemarks()
			};
			view.model.addRow(row);
		}
	}

	public void clearFields() {
		view.txtID.setText("");
		view.txtName.setText("");
		view.txtSubject.setText("");
		view.txtMidTermGrade.setText("");
		view.txtFinalGrade.setText("");
		view.txtFinalAverage.setText("");
		view.txtRemarks.setText("");
		view.selectCourse.setSelectedItem(0);
		view.selectYearLevel.setSelectedItem(0);
	}

	// for create Button
	public void addStudent() {
		try {
			initFile();
			String id = view.txtID.getText().trim();
			String name = view.txtName.getText().trim();
			String subject = view.txtSubject.getText().trim();
			String course = view.selectCourse.getSelectedItem().toString();
			String year = view.selectYearLevel.getSelectedItem().toString();
			byte mid = Byte.parseByte(view.txtMidTermGrade.getText().trim());
			byte fg = Byte.parseByte(view.txtFinalGrade.getText().trim());
			double avg = (mid + fg) / 2;
			String remark = "";

			if (avg >= 75) {
				remark = "Passed";
			} else {
				remark = "Failed";
			}

			if (id.isEmpty() || name.isEmpty() || subject.isEmpty()) {
				JOptionPane.showMessageDialog(null, "you must enter fields");
				return;
			}

			if (isDuplicate(id,name)) {
				JOptionPane.showMessageDialog(null, "Duplicate Student");
				return;
			}
			Student s = new Student(id, name, course, year, subject, mid, fg, avg, remark);
			studentList.add(s);

			saveToFile();
			clearFields();
			refreshTable();

			JOptionPane.showMessageDialog(null, "Student Added Successfully!");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "You must enter number", "You must enter Number", JOptionPane.ERROR_MESSAGE);
		} 
	}

	// search for duplicates in create button
	public boolean isDuplicate(String id, String name) {
		for (Student s : studentList) {
			if(s.getStudentID().equals(id) || s.getStudentName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	// for read Button
	public void displayStudent() {
		studentList.clear();

		try (BufferedReader br = new BufferedReader(new FileReader(file))){
			String line;
			while ((line = br.readLine()) != null) {
				String[] split = line.split("\\|");
				Student s = new Student(
						split[0],
						split[1],
						split[2],
						split[3],
						split[4],
						Byte.parseByte(split[5]),
						Byte.parseByte(split[6]),
						Double.parseDouble(split[7]),
						split[8]
						);
				studentList.add(s);
			}

			refreshTable();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Nothing to Display might be that Records are empty.", "Error Message", JOptionPane.ERROR_MESSAGE);
			return;
		}
	}

	// for update Button
	public void modifyStudent() {
		int selectedRow = view.table.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "select a row to update");
			return;
		}

		if (view.txtMidTermGrade.getText().trim().isEmpty() ||
			view.txtFinalGrade.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "You must fill midterm and finalgrade fields!");
			return;
		}

		try {
			int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you are going to update grades?", "Confirm Update", JOptionPane.YES_NO_OPTION);
			if (confirm != JOptionPane.YES_OPTION) return;

			Student s = studentList.get(selectedRow);

			byte mid = Byte.parseByte(view.txtMidTermGrade.getText().trim());
			byte fg = Byte.parseByte(view.txtFinalGrade.getText().trim());
			double avg = (mid + fg) / 2;
			String remark = "";
			if (avg >= 85 && avg < 100) {
				remark = "Good Performance";
			} else if (avg >= 75 && avg < 85) {
				remark = "Passed";
			} else {
				remark = "Failed";
			} 
			s.setStudentID(s.getStudentID());
			s.setStudentName(s.getStudentName());
			s.setCourse(s.getCourse());
			s.setYearLevel(s.getYearLevel());
			s.setSubject(s.getSubject());
			s.setMidtermGrade(mid);
			s.setFinalGrade(fg);
			s.setFinalAverage(Double.parseDouble(String.format("%.2f", avg)));
			s.setRemarks(remark);

			saveToFile();
			clearFields();
			refreshTable();

			JOptionPane.showMessageDialog(null, "Updated Successfully!");
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error: Grades should be number!", "Error Message", JOptionPane.ERROR_MESSAGE);
			return;
		}


	}

	// for delete Button
	public void deleteStudent() {
		int selectedRow = view.table.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "select a row to delete.");
			return;
		}

		int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you are going to delete?", "Confirm Delete", JOptionPane.YES_NO_CANCEL_OPTION);
		if(confirm != JOptionPane.YES_OPTION) return;

		studentList.remove(selectedRow);

		saveToFile();
		clearFields();
		refreshTable();

		JOptionPane.showMessageDialog(null, "Deleted Successfully!");
	}

	// for search Button
	public void searchStudent() {
		String id = view.txtID.getText().trim();
		for (Student s : studentList) {
			if(s.getStudentID().equals(id)) {
				JOptionPane.showMessageDialog(null, "====Student Found!====\n"
						+ "\nStudent ID: " + view.txtID.getText().trim() 
						+ "\nName: " + view.txtName.getText().trim()
						+ "\nCourse: " + view.selectCourse.getSelectedItem().toString()
						+ "\nYear: " + view.selectYearLevel.getSelectedItem().toString()
						+ "\nSubject: " + view.txtSubject.getText().trim()
						+ "\nMidTerm Grade: " + view.txtMidTermGrade.getText().trim()
						+ "\nFinal Grade: " + view.txtFinalGrade.getText().trim()
						+ "\nFinal Average: " + view.txtFinalAverage.getText().trim()
						+ "\nRemarks: " + view.txtRemarks.getText().trim()
						);
				clearFields();
				return;
			}
		}
		JOptionPane.showMessageDialog(null, "Student not Found!", "Not Found", JOptionPane.INFORMATION_MESSAGE);
	}

}
