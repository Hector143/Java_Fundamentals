package Attendance_Record_System;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Record {
	private JTextField inputName;
	private JTextField inputStudID;
	private JButton backButton;
	private JButton register;
	private JLabel successText;
	Record() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(300,400);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel record = new JPanel();
		
		record.setBounds(0,0,300,400);
		record.setFont(new Font("",Font.PLAIN,18));
		frame.add(record);
		frame.setVisible(true);
		
	}
}
