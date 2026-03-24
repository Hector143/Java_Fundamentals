package Java_GUI_Example2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import java.util.ArrayList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;

class Student {
	private String studentID;
	private String fullName;
	private String courseEnrolled;
	private String status;
	private int yearLevel;

	public Student(String studentID,
			String fullName,
			String courseEnrolled,
			int yearLevel,
			String status) {
		this.studentID = studentID;
		this.fullName = fullName;
		this.courseEnrolled = courseEnrolled;
		this.yearLevel = yearLevel;
		this.status = status;
	}

	public String getStudentID() {
		return studentID;
	}

	public String getCourseEnrolled() {
		return courseEnrolled;
	}

	public String getFullName() {
		return fullName;
	}

	public int getYearLevel() {
		return yearLevel;
	}

	public void setCourseEnrolled(String courseEnrolled) {
		this.courseEnrolled = courseEnrolled;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String toFileString() {
		return studentID + "|" + fullName + "|" + 
				courseEnrolled + "|" + yearLevel + "|" +
				status;
	}

}

public class Student_Enrollment_Management_System extends JFrame implements ActionListener {
	
	// labels
	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel courseLabel;
	private JLabel yearLabel;
	private JLabel statusLabel;

	// inputs
	private JTextField inputID;
	private JTextField inputName;
	private JTextField inputCourse;
	private JTextField inputYear;
	private JCheckBox inputStatus;

	// buttons
	private JButton addBut;
	private JButton searchBut;
	private JButton updateBut;
	private JButton viewBut;
	private JButton deactivateBut;

	// table
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scroll;

	// list
	private ArrayList<Student> studentList = new ArrayList<Student>();
	private final String fileName = "students2.txt";
	private File file = new File(fileName);

	Student_Enrollment_Management_System() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Student Enrollment Management System");
		this.setLayout(new BorderLayout());

		// TOP
		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.setBackground(new Color(150,150,150));
		JLabel titleLabel = new JLabel("Student Enrollment Management System");
		titleLabel.setForeground(new Color(0x123456));
		titleLabel.setFont(new Font("serif", Font.BOLD, 25));
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel inputPanel = new JPanel(new GridLayout(5,2,5,5));
		inputPanel.setBackground(Color.orange);
		inputPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		idLabel = new JLabel("Student ID:");
		nameLabel = new JLabel("Full Name:");
		courseLabel = new JLabel("Course Enrolled");
		yearLabel = new JLabel("Year Level (1-4):");
		statusLabel = new JLabel("Status:");

		inputID = new JTextField();
		inputName = new JTextField();
		inputCourse = new JTextField();
		inputYear = new JTextField();

		JPanel checkPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		inputStatus = new JCheckBox("Active");
		inputStatus.setSelected(true);
		inputStatus.setOpaque(false);
		inputStatus.setFocusable(false);
		checkPanel.setOpaque(false);
		checkPanel.add(inputStatus);

		inputPanel.add(idLabel);
		inputPanel.add(inputID);
		inputPanel.add(nameLabel);
		inputPanel.add(inputName);
		inputPanel.add(courseLabel);
		inputPanel.add(inputCourse);
		inputPanel.add(yearLabel);
		inputPanel.add(inputYear);
		inputPanel.add(statusLabel);
		inputPanel.add(checkPanel);
		
		topPanel.add(titleLabel, BorderLayout.NORTH);
		topPanel.add(inputPanel, BorderLayout.CENTER);
		// CENTER
		String[] columnNames = {"Student ID", "Full Name", "Course Enrolled", "Year Level", "Status"};
		model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		scroll = new JScrollPane(table);

		// Bottom 
		JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15,15));
		buttonsPanel.setBackground(Color.gray);
		addBut = new JButton("Add Student");
		searchBut = new JButton("Search Student");
		updateBut = new JButton("Update Course");
		deactivateBut = new JButton("Deactivate Student");
		viewBut = new JButton("View All Students");

		addBut.setFocusable(false);
		searchBut.setFocusable(false);
		updateBut.setFocusable(false);
		deactivateBut.setFocusable(false);
		viewBut.setFocusable(false);

		buttonsPanel.add(addBut);
		buttonsPanel.add(searchBut);
		buttonsPanel.add(updateBut);
		buttonsPanel.add(deactivateBut);
		buttonsPanel.add(viewBut);

		addBut.addActionListener(this);
		searchBut.addActionListener(this);
		updateBut.addActionListener(this);
		deactivateBut.addActionListener(this);
		viewBut.addActionListener(this);

		this.add(topPanel, BorderLayout.NORTH);
		this.add(scroll, BorderLayout.CENTER);
		this.add(buttonsPanel, BorderLayout.SOUTH);
		this.setSize(750,500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		readFile();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addBut) {
			addStudent();
			return;
		} 

		if (e.getSource() == searchBut) {
			searchStudent();
			return;
		}
		if (e.getSource() == updateBut) {
			updateStudent();
			return;
		}
		if (e.getSource() == deactivateBut) {
			deactivateStudent();
			return;
		}
		if (e.getSource() == viewBut) {
			viewStudentRecord();
			
		}
		
	}

	private void addStudent() {
		try {
			String id = inputID.getText().trim();
			String name = inputName.getText().trim();
			String course = inputCourse.getText().trim();
			int year = Integer.parseInt(inputYear.getText().trim());
			String status = "Inactive";

			if (id.isEmpty() || name.isEmpty() || course.isEmpty()) {
				JOptionPane.showMessageDialog(this, "All Fields must be filled." , "Error Message", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (year < 1 || year > 4) {
				JOptionPane.showMessageDialog(this, "Year must be between 1-4", "Error Message", JOptionPane.ERROR_MESSAGE);
				return;
			}
			for (Student s : studentList) {
				if (s.getStudentID().equals(id)) {
					JOptionPane.showMessageDialog(this, "Duplicate Student ID!", "Error Message", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}

			if (inputStatus.isSelected()) {
				status = "Active";
			}

			Student student = new Student(id, name, course, year, status);
			studentList.add(student);

			clearFields();
			saveToFile();
			refreshTable();

			JOptionPane.showMessageDialog(this, "Student added.");
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "Year Must be a Number", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void refreshTable() {
		model.setRowCount(0);
		for (Student s : studentList) {
			model.addRow(new Object[] {
					s.getStudentID(), s.getFullName(), s.getCourseEnrolled(), s.getYearLevel(), s.getStatus()
			});
		}
	}

	private void clearFields() {
		inputID.setText("");
		inputName.setText("");
		inputCourse.setText("");
		inputYear.setText("");
	}

	private void updateStudent() {
		String id = inputID.getText().trim();
		String newCourse = inputCourse.getText().trim();
		
		for (Student s : studentList) {
			if (s.getStudentID().equals(id)) {
				s.setCourseEnrolled(newCourse);
				saveToFile();
				refreshTable();
				JOptionPane.showMessageDialog(this, "Student Updated Successfully");
				return;
			}
		}
		JOptionPane.showMessageDialog(this, "Student Not Found.", "Not Found", JOptionPane.ERROR_MESSAGE);
	}

	private void searchStudent() {
		String id = inputID.getText().trim();
		for (Student s : studentList) {
			if (s.getStudentID().equals(id)) {
				JOptionPane.showMessageDialog(this, "Student Found!"
						+ "\nID: " + s.getStudentID()  
						+ "\nName: " + s.getFullName()
						+ "\nCourse: " + s.getCourseEnrolled()
						+ "\nYear Level: " + s.getYearLevel()
						+ "\nStatus: " + s.getStatus());
				return;
			}
		}
		JOptionPane.showMessageDialog(this, "Student Not Found.", "Not Found", JOptionPane.ERROR_MESSAGE);
	}

	private void viewStudentRecord() {
		studentList.clear();
		readFile();
		refreshTable();
	}

	private void deactivateStudent() {
		String id = inputID.getText().trim();
		
		for (Student s : studentList) {
			if (s.getStudentID().equals(id)) {
				int confirm = JOptionPane.showConfirmDialog(
                        this,
                        "Deactivate this student?",
                        "Confirm",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    s.setStatus("Inactive");
                    saveToFile();
                    refreshTable();
                    JOptionPane.showMessageDialog(this, "Student deactivated.");
                }
                return;
			}
		}
		JOptionPane.showMessageDialog(this, "Student Not Found.", "Not Found", JOptionPane.ERROR_MESSAGE);
	}

	public void initFile() {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, "ERROR FILE CREATION", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void saveToFile() {
		initFile();
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (Student s : studentList) {
				writer.write(s.toFileString() + "\n");
			}
			writer.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Error Saving File", "Error Message", JOptionPane.ERROR_MESSAGE);
		} 
	}
	
	public void readFile() {
		try {
			initFile();
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			
			while ((line = reader.readLine()) != null) {
				String[] data = line.split("\\|");
				
				Student s = new Student(data[0],data[1],data[2],
						Integer.parseInt(data[3]) ,data[4]);
				studentList.add(s);
				
			}
			reader.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this, "Reading File Error" , "Error Message", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Student_Enrollment_Management_System().setVisible(true)); 

	}

}
