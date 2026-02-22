package javaGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI_Panel implements ActionListener{
	
	JPanel redPanel;
	JPanel greenPanel;
	JPanel bluePanel;
	JPanel yellowPanel;
	
	public static void main(String[] args) {
		
		// JPanel = a GUI component that functions as a container to hold other components.
		ImageIcon icon = new ImageIcon("wave.png");
		
		JLabel label = new JLabel();
		label.setText("Hi");
		label.setIcon(icon);
//		label.setVerticalAlignment(JLabel.TOP); // y axis only if u use borderlayout
//		label.setHorizontalAlignment(JLabel.CENTER); // x axis only if u use borderlayout
		label.setBounds(100, 100, 75, 75);
		
		JPanel redPanel = new JPanel();
		redPanel.setBackground(Color.red);
		redPanel.setBounds(0,0, 250, 250);
		redPanel.setLayout(null);
		
		JPanel greenPanel = new JPanel();
		greenPanel.setBackground(Color.green);
		greenPanel.setBounds(0,250, 250, 250);
		greenPanel.setLayout(null);
		
		JPanel bluePanel = new JPanel();
		bluePanel.setBackground(Color.blue);
		bluePanel.setBounds(250,0, 250, 250);
		bluePanel.setLayout(null);
		
		JPanel yellowPanel = new JPanel();
		yellowPanel.setBackground(Color.yellow);
		yellowPanel.setBounds(250,250, 250, 250);
		yellowPanel.setLayout(null);
		
		JFrame frame = new JFrame("My Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(750,750);
		frame.setVisible(true);
		greenPanel.add(label);
		frame.add(redPanel);
		frame.add(greenPanel);
		frame.add(bluePanel);
		frame.add(yellowPanel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
