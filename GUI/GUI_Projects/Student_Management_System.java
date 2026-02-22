package GUI_Projects;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Student_Management_System implements ActionListener{
	private String[] arrclass = {"","10A","10B"};
	static JLabel title;
	static JLabel roll;
	static JLabel name;
	static JLabel age;
	static JLabel classes;
	static JLabel studentlist;
	static JTextArea result;
	static JTextField inputroll;
	static JTextField inputname;
	static JTextField inputage;
	static JTextField inputclass;
	static JComboBox box;
	static JButton add;
	static JButton view;
	static JButton search;
	static JButton delete;
	static JButton exit;
	
	
	public static void main(String[] args) {
		new Student_Management_System();

	}
	
	Student_Management_System() {
		title = new JLabel("Student Management System");
		title.setBounds(145,0,300,50);
		title.setFont(new Font("serif",Font.BOLD,24));
		title.setForeground(Color.darkGray);
		
		roll = new JLabel("Roll No:");
		roll.setBounds(20,60,80,20);
		roll.setFont(new Font("roman",Font.BOLD,15));
		
		name = new JLabel("Name:");
		name.setBounds(20,85,80,20);
		name.setFont(new Font("roman",Font.BOLD,15));
		
		age = new JLabel("Age:");
		age.setBounds(20,110,80,20);
		age.setFont(new Font("roman",Font.BOLD,15));
		
		classes = new JLabel("Class:");
		classes.setBounds(20,135,80,20);
		classes.setFont(new Font("roman",Font.BOLD,15));
		
		
		inputroll = new JTextField();
		inputroll.setBounds(100,60,100,25);
		
		inputname = new JTextField();
		inputname.setBounds(100,85,100,25);
		
		inputage = new JTextField();
		inputage.setBounds(100,110,100,25);
		
//		inputclass = new JTextField();
//		inputclass.setBounds(100,135,100,25);
		
		box = new JComboBox(arrclass);
		box.setFont(new Font("roman",Font.BOLD,15));
		box.setBounds(100,135,100,25);
		
		add = new JButton("Add Student");
		add.setBounds(10,170,150,30);
		
		view = new JButton("View Student");
		view.setBounds(180,170,150,30);
		
		search = new JButton("Search Student");
		search.setBounds(350,170,150,30);
		
		delete = new JButton("Delete Student");
		delete.setBounds(10,205,150,30);
		
		exit = new JButton("Exit");
		exit.setBounds(180,205,100,30);
		
		studentlist = new JLabel();
		studentlist.setText("- - - - - - - - - - - - - - - - - - - - Student List - - - - - - - - - - - - - - - - - - - - ");
		studentlist.setBounds(20,245,600,50);
		studentlist.setFont(new Font("roman",Font.ITALIC,19));
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.add(title);
		frame.add(name);
		frame.add(roll);
		frame.add(age);
		frame.add(classes);
		frame.add(inputroll);
		frame.add(inputname);
		frame.add(inputage);
		frame.add(box);
		frame.add(add);
		frame.add(view);
		frame.add(search);
		frame.add(delete);
		frame.add(exit);
		frame.add(studentlist);
		
		frame.setSize(600,400);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==add) {
			
		} else if (e.getSource()==view) {
			
		} else if (e.getSource()==search) {
			
		} else if (e.getSource()==delete) {
			
		} else if (e.getSource()==exit) {
			
		}
		
	}

}
