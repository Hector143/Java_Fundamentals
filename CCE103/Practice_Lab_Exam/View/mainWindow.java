package Practice_Lab_Exam.View;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Practice_Lab_Exam.Controller.CRUDS_Controllers;
import Practice_Lab_Exam.Model.Student;

import java.util.ArrayList;

public class mainWindow extends JFrame implements ActionListener{
	public JLabel studentIDLabel, studentNameLabel,
	courseLabel, yearLevelLabel, subjectLabel,
	midtermGradeLabel, finalGradeLabel, 
	finalAverageLabel, remarksLabel;
	public JTextField txtID, txtName, txtSubject,
	txtMidTermGrade, txtFinalGrade,
	txtFinalAverage, txtRemarks;
	public JComboBox<Object> selectCourse, selectYearLevel;
	public JButton createBut, readBut, updateBut, deleteBut, searchBut;

	public DefaultTableModel model;
	public JTable table;
	public JScrollPane scroll;
	
	public ArrayList<Student> studentList;
	public mainWindow() {
		studentList = new ArrayList<>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setSize(900,700);
		setLocationRelativeTo(null);
		setTitle("Student Enrollment and Grading Management System");

		// Top 
		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.setBackground(new Color(35, 65, 110)); // set RGB Color (background)

		JLabel headerLabel = new JLabel("Student Enrollment and Grading Managment System");
		headerLabel.setForeground(Color.WHITE); // set font color of the label
		headerLabel.setFont(new Font("SansSerif", Font.BOLD, 25)); // set font style, size 
		headerLabel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20)); // create margin or padding
		headerLabel.setHorizontalAlignment(JLabel.CENTER);

		JPanel inputPanel = new JPanel(new GridLayout(9,2,10,10));
		inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		inputPanel.setBackground(new Color(45, 85, 190));

		studentIDLabel = new JLabel("Student ID:");
		studentNameLabel = new JLabel("Student Name:");
		courseLabel = new JLabel("Course:"); 
		yearLevelLabel = new JLabel("Year Level:");
		subjectLabel = new JLabel("Subject:");
		midtermGradeLabel = new JLabel("Mid Term Grade:");
		finalGradeLabel = new JLabel("Final Grade:");
		finalAverageLabel = new JLabel("Final Average:");
		remarksLabel = new JLabel("Remarks:");
		
		studentIDLabel.setForeground(Color.white);
		studentNameLabel.setForeground(Color.white);
		courseLabel.setForeground(Color.white);
		yearLevelLabel.setForeground(Color.white);
		subjectLabel.setForeground(Color.white);
		midtermGradeLabel.setForeground(Color.white);
		finalGradeLabel.setForeground(Color.white);
		finalAverageLabel.setForeground(Color.white);
		remarksLabel.setForeground(Color.white);
		
		studentIDLabel.setFont(new Font("", Font.BOLD, 15));
		studentNameLabel.setFont(new Font("", Font.BOLD, 15));
		courseLabel.setFont(new Font("", Font.BOLD, 15));
		yearLevelLabel.setFont(new Font("", Font.BOLD, 15));
		subjectLabel.setFont(new Font("", Font.BOLD, 15));
		midtermGradeLabel.setFont(new Font("", Font.BOLD, 15));
		finalGradeLabel.setFont(new Font("", Font.BOLD, 15));
		finalAverageLabel.setFont(new Font("", Font.BOLD, 15));
		remarksLabel.setFont(new Font("", Font.BOLD, 15));
		
		txtID = new JTextField();
		txtName = new JTextField();
		txtSubject = new JTextField();
		txtMidTermGrade = new JTextField();
		txtFinalGrade = new JTextField();
		txtFinalAverage = new JTextField();
		txtRemarks = new JTextField();
		
		txtFinalAverage.setEditable(false);
		txtRemarks.setEditable(false);
		
		String[] courses = new String[] {
				"BSIT", "BSCS","BMMA", "CCJE", "CTE"
		};
		
		String[] yearLevel = new String[] {
				"1","2","3","4","5"
		};
		selectCourse = new JComboBox<Object>(courses);
		selectYearLevel = new JComboBox<Object>(yearLevel);
		
		inputPanel.add(studentIDLabel);
		inputPanel.add(txtID);
		
		inputPanel.add(studentNameLabel);
		inputPanel.add(txtName);
		
		inputPanel.add(courseLabel);
		inputPanel.add(selectCourse);
		
		inputPanel.add(yearLevelLabel);
		inputPanel.add(selectYearLevel);
		
		inputPanel.add(subjectLabel);
		inputPanel.add(txtSubject);
		
		inputPanel.add(midtermGradeLabel);
		inputPanel.add(txtMidTermGrade);
		
		inputPanel.add(finalGradeLabel);
		inputPanel.add(txtFinalGrade);
		
		inputPanel.add(finalAverageLabel);
		inputPanel.add(txtFinalAverage);
		
		inputPanel.add(remarksLabel);
		inputPanel.add(txtRemarks);
		
		topPanel.add(headerLabel, BorderLayout.NORTH);
		topPanel.add(inputPanel, BorderLayout.CENTER);
		
		// Center
		
		JPanel centerPanel = new JPanel(new BorderLayout());
		
		String[] columnNames = {"Student ID", "Name", "Course", "Year Level",
				"Subject", "Midterm", "Final", "Average", "Remarks"};
		// for table
		
		model = new DefaultTableModel(columnNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.getTableHeader().setFont(new Font("", Font.BOLD, 14));;
		table.getTableHeader().setBackground(Color.cyan);
//		table.setBackground(Color.yellow); //optional
		scroll = new JScrollPane(table);
		centerPanel.add(scroll);
		
		// Bottom
		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10,10));
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		createBut = new JButton("Add New Student");
		readBut = new JButton("Display Records");
		updateBut = new JButton("Modify Student Grades");
		deleteBut = new JButton("Delete Student");
		searchBut = new JButton("Find Student Record");
		
		createBut.addActionListener(this);
		readBut.addActionListener(this);
		updateBut.addActionListener(this);
		deleteBut.addActionListener(this);
		searchBut.addActionListener(this);
		
		createBut.setOpaque(false);
		readBut.setOpaque(false);
		updateBut.setOpaque(false);
		deleteBut.setOpaque(false);
		searchBut.setOpaque(false);

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
		CRUDS_Controllers controller = new CRUDS_Controllers(mainWindow.this, studentList);
		
		if (e.getSource() == createBut) {
			controller.addStudent();
		}
		if (e.getSource() == readBut) {
			controller.displayStudent();
		}
		if (e.getSource() == updateBut) {
			controller.modifyStudent();
		}
		if (e.getSource() == deleteBut) {
			controller.deleteStudent();
		}
		if (e.getSource() == searchBut) {
			controller.searchStudent();
		}

	}
}
