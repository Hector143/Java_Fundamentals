package SecondLabExam2;

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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class mainWindow_V extends JFrame implements ActionListener {
	public JLabel idLabel, nameLabel,
	departmentLabel, salaryLabel, rateLabel,
	bonusLabel, statusLabel, notesLabel;

	public JTextField txtId, txtName, txtSalary,
	txtRate, txtBonus, txtNotes;

	public JButton createBut, readBut, updateBut,
	deleteBut, searchBut;

	public JComboBox<String> selectDepartment, selectStatus;
	public JTable table;
	public DefaultTableModel model;
	public JScrollPane scroll;

	public ArrayList<Employee_M> employeeList;
	public mainWindow_V () {
		employeeList = new ArrayList<>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Employee Payroll Management System");
		setLayout(new BorderLayout());
		

		// top part
		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.setBackground(new Color(35,65,110));
		JLabel headerLabel = new JLabel("Payroll Management System");
		headerLabel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		headerLabel.setFont(new Font("SansSerif", Font.BOLD, 35));
		headerLabel.setForeground(Color.white);
		headerLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel inputPanel = new JPanel(new GridLayout(8,2,10,10));
		inputPanel.setBackground(new Color(45,85,190));
		inputPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		idLabel = new JLabel("Employee ID:");
		nameLabel = new JLabel("Employee Name:");
		departmentLabel = new JLabel("Department:");
		salaryLabel = new JLabel("Basic Salary:");
		rateLabel = new JLabel("Tax Rate:");
		bonusLabel = new JLabel("Bonus:");
		statusLabel = new JLabel("Status:");
		notesLabel = new JLabel("Notes:");

		idLabel.setForeground(Color.white);
		nameLabel.setForeground(Color.white);
		departmentLabel.setForeground(Color.white);
		salaryLabel.setForeground(Color.white);
		rateLabel.setForeground(Color.white);
		bonusLabel.setForeground(Color.white);
		statusLabel.setForeground(Color.white);
		notesLabel.setForeground(Color.white);

		txtId = new JTextField();
		txtName = new JTextField();
		txtSalary = new JTextField();
		txtRate = new JTextField();
		txtBonus = new JTextField();
		txtNotes = new JTextField();

		selectDepartment = new JComboBox<String>(new String[] {
				"IT", "Marketing", "Accounting", "CS"
		});

		selectStatus = new JComboBox<String>(new String[] {
				"Active", "On Leave"
		});

		inputPanel.add(idLabel);
		inputPanel.add(txtId);
		inputPanel.add(nameLabel);
		inputPanel.add(txtName);
		inputPanel.add(departmentLabel);
		inputPanel.add(selectDepartment);
		inputPanel.add(salaryLabel);
		inputPanel.add(txtSalary);
		inputPanel.add(rateLabel);
		inputPanel.add(txtRate);
		inputPanel.add(bonusLabel);
		inputPanel.add(txtBonus);
		inputPanel.add(statusLabel);
		inputPanel.add(selectStatus);
		inputPanel.add(notesLabel);
		inputPanel.add(txtNotes);

		topPanel.add(headerLabel, BorderLayout.NORTH);
		topPanel.add(inputPanel, BorderLayout.CENTER);

		// center part
		String[] columnNames = new String[]{
				"Employee ID", "Employee Name","Department",
				"Salary", "Tax Rate", "Bonus", "Status",
				"Notes"
		};
		model = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getTableHeader().setBackground(Color.CYAN);
		table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
		table.setBackground(Color.yellow);
		scroll = new JScrollPane(table);


		// bottom part
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		bottomPanel.setBackground(Color.gray);
		
		createBut = new JButton("New Employee Record");
		readBut = new JButton("Display Employee Record");
		updateBut = new JButton("Update Employee Record");
		deleteBut = new JButton("Delete an employee Record");
		searchBut = new JButton("Search an Employee");

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
		add(scroll, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
		
		setSize(1000,650);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CRUD_C crud = new CRUD_C(mainWindow_V.this, employeeList);
		if (e.getSource()==createBut) {
			crud.addEmployee();
		}
		if (e.getSource()==readBut) {
			crud.displayEmployee();
		}
		if (e.getSource()==updateBut) {
			crud.updateEmployee();
		}
		if (e.getSource()==deleteBut) {
			crud.deleteEmployee();
		}
		if (e.getSource()==searchBut) {
			crud.searchEmployee();
		}

	}
}
