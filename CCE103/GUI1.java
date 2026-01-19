package CCE103;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;

public class GUI1 implements ActionListener{
	private String[] arrclass = {"","10A","10B","10C"};
	private JLabel title;
	private JLabel roll;
	private JLabel name;
	private JLabel age;
	private JLabel classes;
	private JLabel studentlist;
	private JLabel result;
	private JTextField inputroll;
	private JTextField inputname;
	private JTextField inputage;
	private JComboBox classbox;
	private JButton add;
	private JButton view;
	private JButton search;
	private JButton delete;
	private JButton exit;
	private JTextArea resultArea;

	private ArrayList<Student> students = new ArrayList<>();

	public static void main(String[] args) {
		new GUI1();
	}

	GUI1 () {
		title = new JLabel("Student Management System");
		title.setBounds(140,0,300,50);
		title.setFont(new Font("serif",Font.BOLD,24));

		roll = new JLabel("Roll No:");
		roll.setBounds(10,70,90,25);
		roll.setFont(new Font("roman",Font.BOLD,15));

		name = new JLabel("Name: ");
		name.setBounds(10,100,90,25);
		name.setFont(new Font("roman",Font.BOLD,15));

		age = new JLabel("Age:");
		age.setBounds(10,130,90,25);
		age.setFont(new Font("roman",Font.BOLD,15));

		classes = new JLabel("Class: ");
		classes.setBounds(10,160,90,25);
		classes.setFont(new Font("roman",Font.BOLD,15));

		inputroll = new JTextField();
		inputroll.setBounds(80,70,120,25);

		inputname = new JTextField();
		inputname.setBounds(80,100,120,25);

		inputage = new JTextField();
		inputage.setBounds(80,130,120,25);

		classbox = new JComboBox(arrclass);
		classbox.setBounds(80,160,120,25);

		add = new JButton("Add Student");
		add.setBounds(10,200,150,25);
		add.addActionListener(this);

		view = new JButton("View Student");
		view.setBounds(180,200,150,25);
		view.addActionListener(this);

		search = new JButton("Search Student");
		search.setBounds(350,200,150,25);
		search.addActionListener(this);

		delete = new JButton("Delete Student");
		delete.setBounds(95,230,150,25);
		delete.addActionListener(this); 

		exit = new JButton("Exit");
		exit.setBounds(265,230,150,25);
		exit.addActionListener(this);

		studentlist = new JLabel();
		studentlist.setText("- - - - - - - - - - - - - - - - - - - Student List - - - - - - - - - - - - - - - - - - -");
		studentlist.setFont(new Font("serif",Font.PLAIN,19));
		studentlist.setBounds(30,270,550,30);

		resultArea = new JTextArea();
		resultArea.setBounds(10, 300, 550, 150);
		resultArea.setEditable(false);

		JScrollPane scrollPane = new JScrollPane(resultArea);
		scrollPane.setBounds(10, 300, 550, 150);

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.add(title);
		frame.add(roll);
		frame.add(name);
		frame.add(age);
		frame.add(classes);
		frame.add(inputroll);
		frame.add(inputname);
		frame.add(inputage);
		frame.add(classbox);
		frame.add(add);
		frame.add(view);
		frame.add(search);
		frame.add(delete);
		frame.add(exit);
		frame.add(studentlist);
		frame.add(scrollPane);
		frame.setSize(600,500);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == add) {
			String rollNo = inputroll.getText();
			String name = inputname.getText();
			String age = inputage.getText();
			String studentClass = (String) classbox.getSelectedItem();

			if (rollNo.equals("") || name.equals("") || age.equals("") || studentClass.equals("")) {
				JOptionPane.showMessageDialog(null, "Missing Input!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			} else {
				students.add(new Student(rollNo, name, age, studentClass));
				JOptionPane.showMessageDialog(null, "Student added successfully!", "Input Successful", JOptionPane.INFORMATION_MESSAGE);
				inputroll.setText("");
				inputname.setText("");
				inputage.setText("");
				classbox.setSelectedIndex(0);
			}
		}
		
		if (e.getSource() == view) {
			if (students.isEmpty()) {
				resultArea.setText("No students to display.");
			} else {
				StringBuilder str = new StringBuilder();
				str.append("Roll No | Name   | Age | Class\n");
				str.append("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
				for (Student student : students) {
					str.append(student).append("\n");
				}
				resultArea.setText(str.toString());
			}
		}

		if (e.getSource() == search) {
	        String rollNo = inputroll.getText().trim();  
	        boolean found = false;
	        for (Student student : students) {
	            if (student.getRollNo().equals(rollNo)) {
	                resultArea.setText("Student Found:\n" + student);
	                found = true;
	                break;
	            }
	        }
	        if (!found) {
	            resultArea.setText("Student not found!");
	        }
	    }

	    if (e.getSource() == delete) {
	        String rollNo = inputroll.getText().trim();  
	        boolean deleted = false;
	        for (int i = 0; i < students.size(); i++) {
	            if (students.get(i).getRollNo().equals(rollNo)) {
	                students.remove(i);
	                resultArea.setText("Student " + rollNo + " deleted successfully.");
	                deleted = true;
	                break;
	            }
	        }
	        if (!deleted) {
	            resultArea.setText("Student not found to delete.");
	        }
	    }

		if (e.getSource() == exit) {
			System.exit(0);
		}
	}

}

// OOP Part 
class Student {
	private String rollNo;
	private String name;
	private String age;
	private String studentClass;

	public Student(String rollNo, String name, String age, String studentClass) {
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
		this.studentClass = studentClass;
	}
	
	//getters
	public String getRollNo() {
		return rollNo;
	}

	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}

	public String getStudentClass() {
		return studentClass;
	}

	@Override
	public String toString() {
		return rollNo + "     | " + name + "   | " + age + "  | " + studentClass;
	}
}
