package javaGUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI_Jframe {

	public static void main(String[] args) {
		
		JFrame jframe = new JFrame();
		jframe.setBounds(0, 0, 600, 400);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 600, 400);
		panel1.setBackground(new Color(41, 234, 255));
		panel1.setLayout(null);
		jframe.add(panel1);
		
		JLabel title = new JLabel();
		title.setBounds(100, 300, 200, 50);
		title.setText("Hello World");
		title.setFont(new Font("BOLD", Font.BOLD , 30));
		panel1.add(title);
		
		jframe.setVisible(true);
	}

}
