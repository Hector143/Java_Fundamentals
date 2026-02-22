package GUI_Projects;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class MINI_PROJECT__StudentManagement {

	public static void main(String[] args) {
		new MINI_PROJECT__StudentManagement();

	}
	
	MINI_PROJECT__StudentManagement() {
		
		JLabel title = new JLabel("STUDENT RESULT SYSTEM");
		title.setBounds(0,40,200,50);
		title.setFont(new Font("serif", Font.BOLD, 28));
		title.setForeground(Color.cyan);
		
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(8,2,10,10));
		JPanel resultPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		JFrame frame = new JFrame();
		frame.setTitle("STUDENT RESULT SYSTEM");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.getContentPane().add(title);
		frame.setSize(800,800);
		
		frame.setVisible(true);
	}

}
