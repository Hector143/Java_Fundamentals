package GUI_Projects;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Human_Resource_Management_System extends JFrame implements ActionListener{
	final String filePath = "employees.txt";
	String[] columnNames = {"Employee ID", "Employee Name", "Department", "Position"};
	File file = new File(filePath);
	
	JTextField inputEmployeeID;
	JTextField inputEmployeeName;
	JTextField inputDepartment;
	JTextField inputPosition;
	
	JLabel employeeIDLabel;
	JLabel employeeNameLabel;
	JLabel departmentLabel;
	JLabel positionLabel;
	
	JButton addButton;
	JButton viewButton;
	JButton updateButton; 
	
	JTable table;
	DefaultTableModel model;
	
	ArrayList<String[]> data = new ArrayList<String[]>();
	
	public static void main(String[] args) {
		new Human_Resource_Management_System().setVisible(true);
	}
	
	public Human_Resource_Management_System() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,450);
		this.setLayout(new BorderLayout());
		this.setTitle("Human Resource Management System");
		this.setLocationRelativeTo(null);
		
		JPanel componentPanel = new JPanel(new GridLayout(5,2,5,5));
		componentPanel.setBorder(new EmptyBorder(10,10,10,10));
		componentPanel.setBackground(Color.ORANGE);
		employeeIDLabel = new JLabel("ID: ");
		employeeNameLabel = new JLabel("Name: ");
		departmentLabel = new JLabel("Department: ");
		positionLabel = new JLabel("Position: ");
		inputEmployeeID = new JTextField();
		inputEmployeeName = new JTextField();
		inputDepartment = new JTextField();
		inputPosition = new JTextField();
		addButton = new JButton("Add");
		viewButton = new JButton("View");
		updateButton = new JButton("Update");
		
		componentPanel.add(employeeIDLabel);
		componentPanel.add(inputEmployeeID);
		componentPanel.add(employeeNameLabel);
		componentPanel.add(inputEmployeeName);
		componentPanel.add(departmentLabel);
		componentPanel.add(inputDepartment);
		componentPanel.add(positionLabel);
		componentPanel.add(inputPosition);
		
//		componentPanel.add(addButton);
//		componentPanel.add(viewButton);
//		componentPanel.add(updateButton);
		
		JPanel buttonPanel = new JPanel(new GridLayout(1,3,5,5));
		buttonPanel.setBorder(new EmptyBorder(10,10,10,10));
		buttonPanel.setBackground(Color.ORANGE);
		buttonPanel.add(addButton);
		buttonPanel.add(viewButton);
		buttonPanel.add(updateButton);
		
		this.add(buttonPanel, BorderLayout.SOUTH);
		
		this.add(componentPanel, BorderLayout.NORTH);
//		this.add(buttonPanel,BorderLayout.CENTER);
		
		// model is like a dynamic empty arraylist unlike jtable its already initialized
		model = new DefaultTableModel(columnNames,0) {
			public boolean isCellEditable(int row, int column) {
		    return false;
			}
		}; // this makes your table uneditable
		
		model.setColumnIdentifiers(columnNames);
		
		table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		JScrollPane scroll = new JScrollPane(table);
		this.add(scroll, BorderLayout.CENTER);
		
		addButton.addActionListener(this);
		viewButton.addActionListener(this);
		updateButton.addActionListener(this);
	}
	
	public void addEmployee()  {
		String id = inputEmployeeID.getText();
		String name = inputEmployeeName.getText();
		String dep = inputDepartment.getText();
		String pos = inputPosition.getText();
		
		try {
			FileWriter fw  = new FileWriter(file,true);
			fw.write(id + "|" +
					name + "|" +
					dep + "|" +
					pos + "\n");
			fw.close();
			
			String err[] = {id,name,dep,pos};
			data.add(err);
			JOptionPane.showMessageDialog(this, "Saved Employee records","Transaction Saved", JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
		} 
	}
	
	public void initFile() {
		try {
			if(!file.exists()) {
				file.createNewFile();
			} 
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	public void viewEmployees() {
		data.clear();
		model.setRowCount(0);
		try {
			FileReader reader = new FileReader(file);
			Scanner scanner = new Scanner(reader);
			
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String parts[] = line.split("\\|");
				data.add(parts);
				model.addRow(parts);
			}
			
			scanner.close();
		} catch (IOException ed) {
			System.out.println("Error: " + ed.getMessage());
		} 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String id = inputEmployeeID.getText();
		String name = inputEmployeeName.getText();
		String dep = inputDepartment.getText();
		String pos = inputPosition.getText();
		boolean dup = isDuplicate(id,name,dep,pos);
		if (e.getSource() == addButton) {
			if (id.isEmpty() && 
				name.isEmpty() &&
				dep.isEmpty() &&
				pos.isEmpty() ) {
				JOptionPane.showMessageDialog(this, "Invalid Input!", "Error Message", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (dup) {
				JOptionPane.showMessageDialog(this, "Already Exists.", "Invalid Input", JOptionPane.WARNING_MESSAGE);
				return;
			}
			addEmployee();
			return;
		}
		if (e.getSource() == viewButton) {
			viewEmployees();
			return;
		}
		
		if (e.getSource() == updateButton) {
			if (!id.isEmpty()) {
				updateButton(id);
			}
			
			if(!dep.isEmpty() && !pos.isEmpty()) {
				JOptionPane.showMessageDialog(null,"Successfully Updated!","Update Record", JOptionPane.INFORMATION_MESSAGE);
				inputDepartment.setText(dep);
				inputPosition.setText(pos);
				inputEmployeeName.setEditable(true);
			}
			return;
		}
		
	}
	
	
	public void updateButton(String id) {
		for (String[] emp : data) {
			if (emp[0].equals(id)) {
				JOptionPane.showMessageDialog(null,"Enter New Department and Position:");
				inputDepartment.setText(null);
				inputPosition.setText(null);
				inputEmployeeName.setEditable(false);
				return;
			}
		}
		JOptionPane.showMessageDialog(this, "Employee not found!", "Error Message", JOptionPane.ERROR_MESSAGE);
	}
	
	public boolean isDuplicate(String id, String name, String dep, String pos) {
		for (String[] err : data) {
			if (err[0].equals(id) || err[1].equals(name) || err[2].equals(dep) || err[3].equals(pos)) {
				return true;
			}
		} 
		return false;
	}
	
	

}

/*
im planning to use arraylist with this code:
as abeginner 
but the problem is i dont konw how to add th eline.split into it

package GUI_Projects;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
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
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Human_Resource_Management_System extends JFrame implements ActionListener{
	final String filePath = "employees.txt";
	File file = new File(filePath);
	
	JTextField inputEmployeeID;
	JTextField inputEmployeeName;
	JTextField inputDepartment;
	JTextField inputPosition;
	
	JLabel employeeIDLabel;
	JLabel employeeNameLabel;
	JLabel departmentLabel;
	JLabel positionLabel;
	
	JButton addButton;
	JButton viewButton;
	JButton updateButton;
	
	JTable table;
	DefaultTableModel model;
	
	ArrayList<String> data = new ArrayList<String>();
	
	public static void main(String[] args) {
		new Human_Resource_Management_System().setVisible(true);
	}
	
	public Human_Resource_Management_System() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,250);
		this.setLayout(new BorderLayout());
		this.setTitle("Human Resource Management System");
		this.setLocationRelativeTo(null);
		
		JPanel componentPanel = new JPanel(new GridLayout(5,2,5,5));
		componentPanel.setBorder(new EmptyBorder(10,10,10,10));
		employeeIDLabel = new JLabel("ID: ");
		employeeNameLabel = new JLabel("Name: ");
		departmentLabel = new JLabel("Department: ");
		positionLabel = new JLabel("Position: ");
		inputEmployeeID = new JTextField();
		inputEmployeeName = new JTextField();
		inputDepartment = new JTextField();
		inputPosition = new JTextField();
		addButton = new JButton("Add");
		viewButton = new JButton("View");
		updateButton = new JButton("Update");
		
		componentPanel.add(employeeIDLabel);
		componentPanel.add(inputEmployeeID);
		componentPanel.add(employeeNameLabel);
		componentPanel.add(inputEmployeeName);
		componentPanel.add(departmentLabel);
		componentPanel.add(inputDepartment);
		componentPanel.add(positionLabel);
		componentPanel.add(inputPosition);
		componentPanel.add(addButton);
		componentPanel.add(viewButton);
		
		this.add(componentPanel, BorderLayout.NORTH);
		
		String[] columnNames = {"Employee ID", "Employee Name", "Department", "Position"};
		
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JScrollPane scroll = new JScrollPane(table);
		this.add(scroll, BorderLayout.CENTER);
		
		addButton.addActionListener(this);
		viewButton.addActionListener(this);
		updateButton.addActionListener(this);
	}
	
	public void addEmployee()  {
		try {
			FileWriter fw  = new FileWriter(file,true);
			fw.write(inputEmployeeID.getText() + "|" +
					inputEmployeeName.getText() + "|" +
					inputDepartment.getText() + "|" +
					inputPosition.getText() + "\n");
			fw.close();
			JOptionPane.showMessageDialog(this, "Saved Employee records","Transaction Saved", JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
		} 
	}
	
	public void initFile() {
		try {
			if(!file.exists()) {
				file.createNewFile();
			} 
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	public void viewEmployees() {
		model.setRowCount(0);
		try {
			FileReader reader = new FileReader(file);
			Scanner scanner = new Scanner(reader);
			
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				data.add(line.split("\\|"));
				model.addRow(data);
			}
			
			scanner.close();
		} catch (IOException ed) {
			System.out.println("Error: " + ed.getMessage());
		} 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addButton) {
			if (inputEmployeeID.getText().isEmpty() && 
				inputEmployeeName.getText().isEmpty() &&
				inputDepartment.getText().isEmpty() &&
				inputPosition.getText().isEmpty() ) {
				JOptionPane.showMessageDialog(this, "Invalid Input!", "Error Message", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (inputEmployeeID.getText().equals(data))
			addEmployee();
			return;
		}
		if (e.getSource() == viewButton) {
			viewEmployees();
			return;
		}
		
	}
	
	

}
*/
