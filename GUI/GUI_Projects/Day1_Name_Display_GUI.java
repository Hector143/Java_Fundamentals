package GUI_Projects;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Day1_Name_Display_GUI implements ActionListener{
	
	static JTextField textfield;
	static JLabel label2;
	static JButton button;
	
	public static void main(String[] args) {
		new Day1_Name_Display_GUI();
		
	}
	
	Day1_Name_Display_GUI() {

		JLabel label = new JLabel();
		label.setBounds(20,20,120,30);
		label.setText("Enter your name:");
		label2 = new JLabel("");
		label2.setBounds(120, 100, 200, 30);
		
		button = new JButton("Show Greeting");
		button.setBounds(120,60,150,30);
		button.addActionListener(this);
		
		textfield = new JTextField();
		textfield.setBounds(150,20,150,30);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,400,200);
		
		
		panel.add(label);
		panel.add(textfield);
		panel.add(button);
		panel.add(label2);
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("My First GUI");
		frame.setLayout(null);
		frame.setSize(400,200);
		frame.add(panel);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==button) {
			label2.setText("Hello, " + textfield.getText() + "👋");
		}
		
	}

}
