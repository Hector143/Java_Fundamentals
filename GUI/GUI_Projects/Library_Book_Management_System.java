package GUI_Projects;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.util.ArrayList;
import java.util.Scanner;

public class Library_Book_Management_System extends JFrame implements ActionListener{
	
//	ArrayList<String> data = new ArrayList<String>(); // this is optional 
	final String filePath = "books.txt";
	File file = new File(filePath);
	
	// Labels
	JLabel bookIDLabel;
	JLabel bookTitleLabel;
	JLabel authorNameLabel;
	JLabel genreLabel;
	
	// inputs
	JTextField inputBookID;
	JTextField inputBookTitle;
	JTextField inputAuthorName;
	JTextField inputGenre;
	
	// buttons
	JButton addBut;
	JButton viewBut;
	JButton updateBut;
	
	// Table
	JTable table;
	DefaultTableModel model;
	JScrollPane scroll;
	
	Library_Book_Management_System() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setTitle("Library Book Management System");
		this.setSize(600,500);
		this.setLocationRelativeTo(null);
		
		JPanel titlePanel = new JPanel(new BorderLayout());
		titlePanel.setBorder(new EmptyBorder(20,20,20,20));
		titlePanel.setBackground(Color.magenta);
		JLabel title = new JLabel("Library Book Management System");
		title.setFont(new Font("serif",Font.BOLD, 35));
		title.setHorizontalAlignment(JLabel.CENTER);
		
		titlePanel.add(title);
		this.add(titlePanel, BorderLayout.NORTH);
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		
		JPanel inputPanel = new JPanel(new GridLayout(4,2,5,5));
		inputPanel.setBackground(Color.orange);
		inputPanel.setBorder(new EmptyBorder(20,20,20,20)); // padding
		
		bookIDLabel = new JLabel("Book ID");
		bookTitleLabel = new JLabel("Book Title");
		authorNameLabel = new JLabel("Author Name");
		genreLabel = new JLabel("Genre");
		
		inputBookID = new JTextField();
		inputBookTitle = new JTextField();
		inputAuthorName = new JTextField();
		inputGenre = new JTextField();
		
		inputPanel.add(bookIDLabel);
		inputPanel.add(inputBookID);
		inputPanel.add(bookTitleLabel);
		inputPanel.add(inputBookTitle);
		inputPanel.add(authorNameLabel);
		inputPanel.add(inputAuthorName);
		inputPanel.add(genreLabel);
		inputPanel.add(inputGenre);
		
		String[] columnNames = {"Book ID", "Title", "Author", "Genre"};
		
		JPanel tablePanel = new JPanel(new BorderLayout());
		
		
		model = new DefaultTableModel(){
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return false; // all cells are NOT editable
		    }
		};
		model.setColumnIdentifiers(columnNames);
//		model.setColumnIdentifiers(new String[]{
//				"asdf","asdf"
//		});
		
		table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scroll = new JScrollPane(table);
		tablePanel.add(scroll);
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20,5));
		buttonPanel.setBorder(new EmptyBorder(20,20,20,20));
		buttonPanel.setBackground(Color.lightGray);
		
		addBut = new JButton("Add Book");
		viewBut = new JButton("View Books");
		updateBut = new JButton("Update Book");
		
		buttonPanel.add(addBut);
		buttonPanel.add(viewBut);
		buttonPanel.add(updateBut);
		
		mainPanel.add(inputPanel, BorderLayout.NORTH);
		mainPanel.add(tablePanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		this.add(mainPanel, BorderLayout.CENTER);
		
		addBut.addActionListener(this);
		viewBut.addActionListener(this);
		updateBut.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addBut) {
			addBook();
			return;
		}
		
		if (e.getSource() == viewBut) {
			viewBook();
			return;
		}
		
		if (e.getSource() == updateBut) {
			updateBook();
			return;
		}
		
	}
	
	public void clearField() {
		inputBookID.setText("");
		inputBookTitle.setText("");
		inputAuthorName.setText("");
		inputGenre.setText("");
	}
	public void addBook() {
		try {
			initFile();
			saveToFile();
			clearField();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Cannot Add Book!");
		}
		
	}
	
	public void viewBook() {
		try {
			readFile();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Cannot View Book!");
		}
		
	}
	
	public void updateBook() {
		String id = inputBookID.getText().trim();
		String newgenre = "";
		 if (id.isEmpty()) {
		        JOptionPane.showMessageDialog(this, "Enter Book ID to update.");
		        return;
		}
		 try {
		        BufferedReader br = new BufferedReader(new FileReader(filePath));
		        StringBuilder newContent = new StringBuilder();
		        String line;
		        boolean found = false;
		        while ((line = br.readLine()) != null) {
		            String[] split = line.split("\\|");
		            if (split[0].equals(id)) {

		                found = true;

		                String newTitle = JOptionPane.showInputDialog("Enter new Title:");
		                if (newTitle == null || newTitle.trim().isEmpty()) {
		                    br.close();
		                    return;
		                }
		                split[1] = newTitle; // replace author
		                
		                String newAuthor = JOptionPane.showInputDialog("Enter new Author:");
		                if (newAuthor == null || newAuthor.trim().isEmpty()) {
		                    br.close();
		                    return;
		                }
		                split[2] = newAuthor; // replace author
		                
		                String newGenre = JOptionPane.showInputDialog("Enter new Genre:");
		                if (newGenre == null || newGenre.trim().isEmpty()) {
		                    br.close();
		                    return;
		                }
		                split[3] = newGenre; // replace genre

		                line = split[0] + "|" + split[1] + "|" + split[2] + "|" + split[3];
		            }

		            newContent.append(line).append("\n");
		        }

		        br.close();

		        if (!found) {
		            JOptionPane.showMessageDialog(this, "Book Not Found.");
		            return;
		        }

		        // Rewrite entire file
		        FileWriter fw = new FileWriter(filePath);
		        fw.write(newContent.toString());
		        fw.close();

		        JOptionPane.showMessageDialog(this, "Book Updated Successfully!");
		        readFile();
		        clearField();

		    } catch (Exception e) {
		        JOptionPane.showMessageDialog(this, "Update Error.");
		}
//		try {
//			for (int i = 0; i < data.size(); i++) {
//				Scanner scan = new Scanner(new FileReader(file));
//				while (scan.hasNextLine()) {
//					String line = scan.nextLine();
//					String[] split = line.split("\\|");
//					if (split[0].equals(id)) {
//						JOptionPane.showMessageDialog(null, "Book Found");
//						newgenre = JOptionPane.showInputDialog("Enter new Genre: ");
//						if (!newgenre.isEmpty()) {
//							JOptionPane.showMessageDialog(null, "Update Successfully!");
//							clearField();
//							return;
//						} 
//						JOptionPane.showMessageDialog(null, "Update Successfully!");
//						clearField();
//						return;
//					}
//				}
//				scan.close();
//			}
//			JOptionPane.showMessageDialog(this, "Book Not Found.");
//			return;
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(this, "Book Not Found.");
//		}
//		return;
	}
	
	public void initFile() {
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "File Error");
		}
	}
	public void saveToFile() throws IOException {
		String id = inputBookID.getText().trim();
		String title = inputBookTitle.getText().trim();
		String author = inputAuthorName.getText().trim();
		String genre = inputGenre.getText().trim();
		
		if (id.isEmpty() || title.isEmpty() || author.isEmpty() || genre.isEmpty()) {
	        JOptionPane.showMessageDialog(this, "All fields are required.");
	        return;
	    }
		
		BufferedReader br = new BufferedReader(new FileReader(filePath));
	    String line;
	    while ((line = br.readLine()) != null) {
	        String[] split = line.split("\\|");
	        if (split[0].equals(id)) {
	            JOptionPane.showMessageDialog(this, "Book ID already exists!");
	            br.close();
	            return;
	        }
	    }
	    br.close();
	    
	    FileWriter fw = new FileWriter(filePath, true);
	    fw.write(id + "|" + title + "|" + author + "|" + genre + "\n");
	    fw.close();
	    
	    JOptionPane.showMessageDialog(this, "Book Added Successfully!");
//	    readFile();
	}
	
	public void readFile() throws IOException {
		model.setRowCount(0);
		FileReader reader = new FileReader(filePath);
		BufferedReader buffread = new BufferedReader(reader);
		try {
			String line = "";
			while ((line = buffread.readLine()) != null) {
				String[] records = line.split("\\|");
				model.addRow(records);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "File Error");
		} finally {
			buffread.close();
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Library_Book_Management_System().setVisible(true));

	}

}
