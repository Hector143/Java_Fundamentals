package javaGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//https://introcs.cs.princeton.edu/java/15inout/GUI.java.html 

public class GUI implements ActionListener {
	JLabel label;
	JPanel panel;
	JFrame frame;
	int count = 0;
	
	public GUI() {
		frame = new JFrame(); // create a window frame
		JButton button = new JButton("Click me");
		button.addActionListener(this);
		
		label = new JLabel("Number of clicks: 0"); // add label
		panel = new JPanel(); // create a panel for frame
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(button);
		panel.add(label);
		
		frame.add(panel, BorderLayout.CENTER); // add panel to frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit on close so that the program stops running when the frame is closed.
		frame.setTitle("Our GUI"); // set the title of frame
		frame.pack(); // set size to its natural
		frame.setVisible(true); // make the frame visible interface
	}
	
	public static void main(String[] args) {
		new GUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		label.setText("Number of clicks: " + count);
	}

}
