package Sample2ndExam.Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Sample2ndExam.Model.Book;
import Sample2ndExam.View.mainWindow;

public class Delete {
	private mainWindow view;
	private ArrayList<Book> bookList;
	private ArrayList<String> list;
	private final File file = new File("books.txt");
	public Delete(mainWindow view, ArrayList<Book> bookList) {
		this.view = view;
		this.bookList = bookList;
	}
	
	public void deleteBook() {
		int selectedRow = view.table.getSelectedRow();
		if(selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "Select a Record to Delete");
			return;
		}
		
		int confirm = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this record?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
		if (confirm != JOptionPane.YES_OPTION) return;
		bookList = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("books.txt"));
			String line;
			int rowIndex = 0;
			while ((line = br.readLine()) != null) {
				if (rowIndex != selectedRow) {
					list.add(line);
				}
				rowIndex++;
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error reading file: " + e.getMessage());
            return;
		}
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("books.txt"))) {
            for (String record : list) bw.write(record + "\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving file: " + e.getMessage());
        }

        JOptionPane.showMessageDialog(null, "Record Deleted!");
        clearFields();
        refreshTable();
	}
	
	public void clearFields() {
		view.txtId.setText("");
		view.txtTitle.setText("");
		view.txtAuthor.setText("");
		view.txtDate.setText("");
		view.txtIsbn.setText("");
		view.txtShelfLoc.setText("");
		view.txtDescript.setText("");
		view.status.setSelectedItem(0);
		view.category.setSelectedItem(0);
	}
	
	private void refreshTable() {
        view.model.setRowCount(0);
        File file = new File("books.txt");
        
        try {
        	if(!file.exists()) file.createNewFile();
        	BufferedReader br = new BufferedReader(new FileReader("books.txt"));
        	String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split("\\|");
                view.model.addRow(row);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
