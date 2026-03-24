package Sample2ndExam.Controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Sample2ndExam.Model.Book;
import Sample2ndExam.View.mainWindow;

public class Create {
	private mainWindow view;
	private ArrayList<Book> bookList;
	private final File file = new File("books.txt");
	public Create(mainWindow view, ArrayList<Book> bookList) {
		this.view = view;
		this.bookList = bookList;
	}
	
	public void saveToFile() {
		try {
			String id = view.txtId.getText().trim();
			String title = view.txtTitle.getText().trim();
			String author = view.txtAuthor.getText().trim();
			String date = view.txtDate.getText().trim();
			String isbn = view.txtIsbn.getText().trim();
			String shelf = view.txtShelfLoc.getText().trim();
			String desc = view.txtDescript.getText().trim();
			String status = view.status.getSelectedItem().toString();
			String category = view.category.getSelectedItem().toString();
			
			if (id.isEmpty() || title.isEmpty() || author.isEmpty() ||
				date.isEmpty() || isbn.isEmpty() || shelf.isEmpty()|| desc.isEmpty()) {
				JOptionPane.showMessageDialog(null, "you must fill the Fields");
				return;
			}
			
			Book b = new Book(id,title,author,category,date,isbn,status,shelf,desc);
			bookList.add(b);
			FileWriter fw = new FileWriter(file, true);
			fw.write(b.toFileString() + "\n");
			fw.close();
			clearFields();
			JOptionPane.showMessageDialog(null, "Book Added Successfully!");
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Cannot Add File!");
		}
	}
	
	public void initFile() {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			System.err.println("Error file Creation!");
		}
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
	
}
