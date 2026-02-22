package GUI_Projects;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Day6_Student_Registration_Form extends JFrame implements ActionListener{
	
	static JLabel name;
	static JLabel age;
	static JLabel course;
	static JButton submit;
	static JLabel result;
	static JTextField textname;
	static JTextField textage;
	static JTextField textcourse;
	
	
	public static void main(String[] args) {
		new Day6_Student_Registration_Form();
		
	}
	
	Day6_Student_Registration_Form() {
		
		name = new JLabel("Name: ");
		name.setBounds(10,10,80,30);
		
		age = new JLabel("Age: ");
		age.setBounds(10,40,80,30);
		
		course = new JLabel("Course: ");
		course.setBounds(10,70,80,30);
	
		textname = new JTextField();
		textname.setBounds(90,10,100,30);
		
		textage = new JTextField();
		textage.setBounds(90,40,100,30);
		
		textcourse = new JTextField();
		textcourse.setBounds(90,70,100,30);
		
		submit = new JButton("Submit");
		submit.setBounds(40,110,120,40);
		submit.addActionListener(this);
		
		result = new JLabel("");
		result.setBounds(40,155,180,30);
		
		
		new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Student Form");
		setLayout(null);
		add(name);
		add(age);
		add(course);
		add(textname);
		add(textage);
		add(textcourse);
		add(submit);
		add(result);
		setSize(230,250);
		
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			result.setText(textname.getText() + ", " + textage.getText() + ", " + textcourse.getText());;
		}
		
	}
}
