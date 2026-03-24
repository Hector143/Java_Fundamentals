package LoanMagementSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class mainFrame_V extends JFrame implements ActionListener{
	public JLabel idLabel, nameLabel, amountLabel, rateLabel, termLabel, dateLabel, statusLabel, notesLabel;
	public JTextField txtId, txtName, txtAmount, txtRate, txtTerm, txtDate, txtStatus, txtNotes;
	public DefaultTableModel model;
	public JTable table;
	public JScrollPane scroll;
	public JButton createBut, readBut, updateBut, deleteBut, searchBut;
	public ArrayList<Loan_M> loanList = new ArrayList<>();
	public mainFrame_V() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(900,700);
		setTitle("Home Loan System");
		setLocationRelativeTo(null);

		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.setBackground(new Color(35, 65, 110));

		JLabel headerLabel = new JLabel("Home Loan Management System");
		headerLabel.setForeground(Color.white);
		headerLabel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		headerLabel.setHorizontalAlignment(JLabel.CENTER);
		headerLabel.setFont(new Font("SansSerif", Font.BOLD, 35));

		JPanel inputPanel = new JPanel(new GridLayout(8,2,10,10));
		inputPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		inputPanel.setBackground(new Color(45, 85, 190));

		idLabel = new JLabel("Loan ID");
		nameLabel = new JLabel("Loan Name");
		amountLabel = new JLabel("Loan Amount");
		rateLabel = new JLabel("Loan Rate");
		termLabel = new JLabel("Loan Term");
		dateLabel = new JLabel("Date");
		statusLabel = new JLabel("Status");
		notesLabel = new JLabel("Notes");

		idLabel.setForeground(Color.white);
		nameLabel.setForeground(Color.white);
		amountLabel.setForeground(Color.white);
		rateLabel.setForeground(Color.white);
		termLabel.setForeground(Color.white);
		dateLabel.setForeground(Color.white);
		statusLabel.setForeground(Color.white);
		notesLabel.setForeground(Color.white);

		txtId = new JTextField();
		txtName = new JTextField();
		txtAmount = new JTextField();
		txtRate = new JTextField();
		txtTerm = new JTextField();
		txtDate = new JTextField();
		txtStatus = new JTextField();
		txtNotes = new JTextField();

		inputPanel.add(idLabel); inputPanel.add(txtId);
		inputPanel.add(nameLabel); inputPanel.add(txtName);
		inputPanel.add(amountLabel); inputPanel.add(txtAmount);
		inputPanel.add(rateLabel); inputPanel.add(txtRate);
		inputPanel.add(termLabel); inputPanel.add(txtTerm);
		inputPanel.add(dateLabel); inputPanel.add(txtDate);
		inputPanel.add(statusLabel); inputPanel.add(txtStatus);
		inputPanel.add(notesLabel); inputPanel.add(txtNotes);

		topPanel.add(headerLabel, BorderLayout.NORTH);
		topPanel.add(inputPanel, BorderLayout.CENTER);

		// CENTER AREA 
		JPanel centerPanel = new JPanel(new BorderLayout());
		String[] columnNames = {"Loan ID", "Loan Name", "Loan Amount", "Loan Rate", "Loan Term", "Date", "Status", "Notes"};
		model = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getTableHeader().setBackground(Color.orange);

		scroll = new JScrollPane(table);
		centerPanel.add(scroll);

		// BOTTOM AREA
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,10));
		bottomPanel.setBackground(new Color(110, 110, 110));
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

		createBut = new JButton("Add New Loan Application");
		readBut = new JButton("Display Loan Records");
		updateBut = new JButton("Modify Loan Details");
		deleteBut = new JButton("Remove Loan Application");
		searchBut = new JButton("Find Loan Record");

		createBut.addActionListener(this);
		readBut.addActionListener(this);
		updateBut.addActionListener(this);
		deleteBut.addActionListener(this);
		searchBut.addActionListener(this);

		bottomPanel.add(createBut);
		bottomPanel.add(readBut);
		bottomPanel.add(updateBut);
		bottomPanel.add(deleteBut);
		bottomPanel.add(searchBut);

		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CRUDS_Controller_C c = new CRUDS_Controller_C(loanList);
		c.initFile();
		if (e.getSource()==createBut) {
			try {
				c.initFile();
				String id = txtId.getText().trim();
				String name = txtName.getText().trim();
				String amount = txtAmount.getText().trim();
				String rate = txtRate.getText().trim();
				String term = txtTerm.getText().trim();
				String date = txtDate.getText().trim();
				String status = txtStatus.getText().trim();
				String notes = txtNotes.getText().trim();
				
				if (id.isEmpty() || name.isEmpty() || amount.isEmpty() || rate.isEmpty() ||
						term.isEmpty() || date.isEmpty() ||status.isEmpty() || notes.isEmpty()) { 
					JOptionPane.showMessageDialog(this, "You must enter Fields");
					return;
				}
				
				if (c.isDuplicate(id)) {
					JOptionPane.showMessageDialog(this, "ID already Exists, Duplicated!");
					return;
				}
				
				Loan_M l = new Loan_M(id, name, amount, rate, term, date, status, notes);
				c.createLoan(l);
				clearFields();
				refreshTable();
				JOptionPane.showMessageDialog(this, "Loan Added Successfully!");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Cannot Add Loan!", "ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}
			return;
		}
		
		if (e.getSource()==readBut) {
			try {
				c.readFromFile();
				refreshTable();
				return;
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Cannot Read From File", "ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if (e.getSource()==updateBut) {
			try {
				int selectedRow = table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(this, "You must select a row first");
					return;
				}
				
				int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you are going to update Loan?", "Confirm Update", JOptionPane.YES_NO_CANCEL_OPTION);
				if (confirm != JOptionPane.YES_OPTION) return;
				
				String id = txtId.getText().trim();
				String name = txtName.getText().trim();
				String amount = txtAmount.getText().trim();
				String rate = txtRate.getText().trim();
				String term = txtTerm.getText().trim();
				String date = txtDate.getText().trim();
				String status = txtStatus.getText().trim();
				String notes = txtNotes.getText().trim();
				
				if (id.isEmpty() || name.isEmpty() || amount.isEmpty() || rate.isEmpty() ||
						term.isEmpty() || date.isEmpty() ||status.isEmpty() || notes.isEmpty()) { 
					JOptionPane.showMessageDialog(this, "You must enter Fields");
					return;
				}
				
				Loan_M updatedLoan = new Loan_M(
				        id, name, amount, rate, term, date, status, notes
				);
				
				c.updateLoan(selectedRow, updatedLoan);
				clearFields();
				refreshTable();
				JOptionPane.showMessageDialog(this, "Loan Updated Successfully");
				return;
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Cannot be Updated", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if (e.getSource()==deleteBut) {
			try {
				int selectedRow = table.getSelectedRow();
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(this, "You must select a row first");
					return;
				}
				
				int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you are going to delete Loan?", "Confirm Delete", JOptionPane.YES_NO_CANCEL_OPTION);
				if (confirm != JOptionPane.YES_OPTION) return;
				
				c.deleteLoan(selectedRow);
				refreshTable();
				JOptionPane.showMessageDialog(this, "Deleted Successfully");
				return;
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Loan Cannot be delete", "ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if (e.getSource()==searchBut) {
			try {
				String id = txtId.getText().trim();
				
				for (Loan_M l : loanList) {
					if (l.getId().equals(id)) {
						JOptionPane.showMessageDialog(this, "Loan Found!"
								+ "\nLoan ID: " + l.getId()
								+ "\nLoan Name: " + l.getName()
								+ "\nLoan Amount: " + l.getAmount()
								+ "\nLoan Rate: " +  l.getRate()
								+ "\nLoan Term: " + l.getTerm()
								+ "\nLoan Date: " + l.getDate()
								+ "\nLoan Status: " + l.getStatus()
								+ "\nLoan Notes: " + l.getNotes()
								);
						return;
					}
				}
				JOptionPane.showMessageDialog(this, "LOAN NOT FOUND!");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "Cannot Find Loan Records", "ERROR", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}

	}

	public void clearFields() {
		txtId.setText("");
		txtName.setText("");
		txtAmount.setText("");
		txtRate.setText("");
		txtTerm.setText("");
		txtDate.setText("");
		txtStatus.setText("");
		txtNotes.setText("");
	}

	public void refreshTable() {
		model.setRowCount(0);
		for (Loan_M l : loanList) {
			model.addRow(l.getFileInfo());
		}
	}

}
