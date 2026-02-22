package GUI_Projects;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;

public class Library_Management_System extends JFrame implements ActionListener{
	// File Handling
	final String fileName = "borrowers.txt";
	File file = new File(fileName);
	
	// Labels
	JLabel idLabel;
	JLabel nameLabel;
	JLabel bookTitleLabel;
	JLabel bookTypeLabel;
	JLabel returnedLabel;
	
	// TextFields
	JTextField inputBorrowerID;
	JTextField inputBorrowerName;
	JTextField inputBookTitle;
	
	// RadioButtons
	ButtonGroup group;
	JRadioButton fictionBut;
	JRadioButton nonFictionBut;
	
	// Buttons
	JButton addButton;
	JButton viewButton;
	JButton returnButton;
	
	// CheckBox
	JCheckBox checkReturned;
	
	// JTable
	DefaultTableModel model;
	JTable table;
	JScrollPane scroll;
	ArrayList<String> data = new ArrayList<String>();
	
	public static void main(String[] args) {
		new Library_Management_System().setVisible(true);

	}
	
	Library_Management_System() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setTitle("Library Book Borrowing Management System");
		this.setSize(600,500);
		this.setLocationRelativeTo(null);
		
		// North
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(5,2,5,5));
		inputPanel.setBorder(new EmptyBorder(20,20,20,20));
		
		idLabel = new JLabel("Borrower ID");
		nameLabel = new JLabel("Borrower Name");
		bookTitleLabel = new JLabel("Book Title");
		bookTypeLabel = new JLabel("Book Type");
		returnedLabel = new JLabel("Returned");
		
		inputBorrowerID = new JTextField();
		inputBorrowerName = new JTextField();
		inputBookTitle = new JTextField();
		
		fictionBut = new JRadioButton("Fiction");
		nonFictionBut = new JRadioButton("Non-Fiction");
		
		group = new ButtonGroup();
		group.add(fictionBut);
		group.add(nonFictionBut);
		
		JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		radioPanel.add(fictionBut);
		radioPanel.add(nonFictionBut);
		
		JPanel checkPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		checkReturned = new JCheckBox("Returned");
		checkPanel.add(checkReturned);
		
		inputPanel.add(idLabel);
		inputPanel.add(inputBorrowerID);
		inputPanel.add(nameLabel);
		inputPanel.add(inputBorrowerName);
		inputPanel.add(bookTitleLabel);
		inputPanel.add(inputBookTitle);
		inputPanel.add(bookTypeLabel);
		inputPanel.add(radioPanel);
		inputPanel.add(returnedLabel);
		inputPanel.add(checkPanel);
		
		this.add(inputPanel, BorderLayout.NORTH);
		// Center
		
		String[] columnNames = {"Borrower ID", "Name", "Book Title", "Book Type", "Returned"};
		
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		
		table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scroll = new JScrollPane(table);
		this.add(scroll, BorderLayout.CENTER);
		// Bottom
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,20));
		
		addButton = new JButton("Add Record");
		viewButton = new JButton("View Record");
		returnButton = new JButton("Mark as Returned");
		
		buttonPanel.add(addButton);
		buttonPanel.add(viewButton);
		buttonPanel.add(returnButton);
		
		this.add(buttonPanel, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String id = inputBorrowerID.getText();
		String name = inputBorrowerName.getText();
		String title = inputBookTitle.getText();
		String type = "";
		boolean ret = false;
		if (fictionBut.isSelected()) {
			type = "Fiction";
		} else if (nonFictionBut.isSelected()) {
			type = "Non-Fiction";
		}
		
		if (checkReturned.isSelected()) {
			ret = true;
		}
		
		
		if (e.getSource() == addButton) {
			addRecord(id,name,title,type,ret);
		} else if (e.getSource() == viewButton) {
			viewRecords();
		} else if (e.getSource() == returnButton) {
			markAsReturned(id,ret);
		}

		
	}
	
	public void addRecord(String id, String name, String title, String type, boolean ret) {
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(id +"|" + name + "|" + title + "|" + type + "|" + ret + "\n");
			fw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "");
		} 
	}
	
	public void viewRecords() {
		
	}
	
	public void markAsReturned(String id, boolean ret) {
		
	}

}
