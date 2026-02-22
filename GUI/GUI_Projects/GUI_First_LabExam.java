// Hector Josh Salera
package GUI_Projects;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class GUI_First_LabExam extends JFrame implements ActionListener {
	// File handling
	final String filePath = "crm_records.txt";
	File file = new File(filePath);
	// JLabels
	JLabel referenceNumLabel;
	JLabel customerNameLabel;
	JLabel typeOfTransactionLabel;
	JLabel companyLabel;

	// textfield
	JTextField inputReferenceNum;
	JTextField inputCustomerName;
	// combo box
	String[] transactionList = { "Inquirires", "Complaints" };
	String[] companyList = { "Globe", "Smart", "PLDT", "Dito" };
	JComboBox typeOfTransactBox;
	JComboBox companyBox;
	// buttons
	JButton addTransactionBut;
	JButton viewTransactionBut;
	JButton updateTransactionBut;

	// Table
	JTable table;
	DefaultTableModel model;
	JScrollPane scroll;
	//
	ArrayList<String[]> data = new ArrayList<String[]>();

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new GUI_First_LabExam().setVisible(true));
	}

	GUI_First_LabExam() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.orange);
		this.setTitle("Customer Relationship Management System");
		this.setSize(700, 500);
		this.setLocationRelativeTo(null);
		// Top Panel
//		JLabel titleLabel = new JLabel("Customer Relationship Management System", FlowLayout.CENTER);
//		titleLabel.setFont(new Font("serif", Font.BOLD, 45));
//		this.add(titleLabel, BorderLayout.NORTH);

		JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
		inputPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		referenceNumLabel = new JLabel("Reference Number");
		customerNameLabel = new JLabel("Customer Name");
		inputReferenceNum = new JTextField();
		inputCustomerName = new JTextField();

		inputPanel.add(referenceNumLabel);
		inputPanel.add(inputReferenceNum);
		inputPanel.add(customerNameLabel);
		inputPanel.add(inputCustomerName);

		JPanel selectionPanel = new JPanel(new GridLayout(2, 2, 10, 10));
		selectionPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		typeOfTransactionLabel = new JLabel("Type of Transaction");
		companyLabel = new JLabel("Company");
		typeOfTransactBox = new JComboBox(transactionList);
		companyBox = new JComboBox(companyList);

		selectionPanel.add(typeOfTransactionLabel);
		selectionPanel.add(typeOfTransactBox);
		selectionPanel.add(companyLabel);
		selectionPanel.add(companyBox);
		JPanel topPanel = new JPanel(new GridLayout(1, 2));
		topPanel.add(inputPanel);
		topPanel.add(selectionPanel);

		this.add(topPanel, BorderLayout.NORTH);

		// Center Panel
		JPanel centerPanel = new JPanel(new GridLayout(1, 1));
		String[] columnNames = { "Reference Number", "Customer Name", "Type of Transaction", "Company" };
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);

		table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scroll = new JScrollPane(table);

		centerPanel.add(scroll);
		this.add(centerPanel, BorderLayout.CENTER);
		// Bottom Panel

		addTransactionBut = new JButton("Add Transaction");
		viewTransactionBut = new JButton("View Transaction");
		updateTransactionBut = new JButton("Update Transaction");
		addTransactionBut.addActionListener(this);
		viewTransactionBut.addActionListener(this);
		updateTransactionBut.addActionListener(this);
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		bottomPanel.setBackground(Color.DARK_GRAY);
		bottomPanel.add(addTransactionBut);
		bottomPanel.add(viewTransactionBut);
		bottomPanel.add(updateTransactionBut);

		this.add(bottomPanel, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addTransactionBut) {

			String refNum = inputReferenceNum.getText();
			String name = inputCustomerName.getText();
			String type = typeOfTransactBox.getSelectedItem().toString();
			String company = companyBox.getSelectedItem().toString();

			if (refNum.isEmpty() || name.isEmpty() || type.isEmpty() || company.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Invalid Input!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
				return;
			}
			addTransaction();
			return;
		}

		if (e.getSource() == viewTransactionBut) {
			JOptionPane.showMessageDialog(this, "Showing in Table");
			viewTransaction();
			return;
		}
		if (e.getSource() == updateTransactionBut) {
			updateTransaction();
			return;
		}

	}

	private void updateTransaction() {
		// TODO Auto-generated method stub

	}

	private void viewTransaction() {
		readFile();

	}

	private void addTransaction() {
		saveToFile();
	}
	
	public void initFile() {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			System.err.println("Canont Create File!");
		}
	}
	
	public void saveToFile() {
		initFile();
		String refNum = inputReferenceNum.getText();
		String name = inputCustomerName.getText();
		String type = (String) typeOfTransactBox.getSelectedItem();
		String company = (String) companyBox.getSelectedItem();
		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write(refNum + "|" + name + "|" + type + "|" + company + "\n");
			fw.close();
			JOptionPane.showMessageDialog(this, "Saved!");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void readFile() {
		try {
			FileReader reader = new FileReader(file);
			Scanner scanner = new Scanner(reader);
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] dataSplit = line.split("\\|");
				data.add(dataSplit);
				model.addRow(dataSplit);
			}
			scanner.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
		}
	}

}
