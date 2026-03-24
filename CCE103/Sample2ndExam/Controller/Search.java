package Sample2ndExam.Controller;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Sample2ndExam.Model.Book;
import Sample2ndExam.View.mainWindow;

public class Search {
	private mainWindow view;
	private ArrayList<Book> bookList;
	private final File file = new File("books.txt");
	public Search(mainWindow view, ArrayList<Book> bookList) {
		this.view = view;
		this.bookList = bookList;
	}

	public void findBook() {
		try {
			String id = view.txtId.getText().trim();

			for (Book b : bookList) {
				if(b.getBookId().equals(id)) {
					JOptionPane.showMessageDialog(null,"Book Found!\n"
							+ "\nBook ID: " + id
							+ "\nBook Title: " + view.txtTitle.getText()
							+ "\nAuthor: " + view.txtAuthor.getText()
							+ "\nCategory: " + view.category.getSelectedItem().toString()
							+ "\nPublication Date: " + view.txtDate.getText()
							+ "\nISBN: " + view.txtIsbn.getText()
							+ "\nShelf Location: " + view.txtShelfLoc.getText()
							+ "\nDescription: " + view.txtDescript.getText());
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, 
					"Cannot Load File!", 
					"Error Message",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
}
