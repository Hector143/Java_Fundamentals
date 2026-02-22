package Layout_Managers;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class SampleLayout2 {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		// FlowLayout
//		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
//		for (int i = 0; i < 10; i++) {
//			frame.add(new JButton("This is " + (i+1)));
//		}
		
//		frame.setLayout(new FlowLayout());
//		frame.add(new JButton("Button 1"));
//		frame.add(new JButton("Button 2"));
//		frame.add(new JButton("Button 3"));
//		frame.add(new JButton("Long-Named Button 4"));
//		frame.add(new JButton("5"));
//		frame.add(new JRadioButton("Left to Right"));
//		frame.add(new JRadioButton("Right to Left"));
//		frame.add(new JButton("Apply Orientation"));
		
		
		// BorderLayout
//		frame.add(new JButton("This is " + 1), BorderLayout.PAGE_START);
//		frame.add(new JButton("This is " + 2), BorderLayout.PAGE_END);
//		frame.add(new JButton("This is " + 3), BorderLayout.LINE_START);
//		frame.add(new JButton("This is " + 4), BorderLayout.LINE_END);
//		frame.add(new JButton("This is " + 5), BorderLayout.CENTER);
		
		// BoxLayout
		
		
		// GridBagLayout
		frame.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		
		frame.add(new JButton("This is " + 1), c);
		c.gridx = 1;
		frame.add(new JButton("This is " + 2), c);
		c.gridx = 2;
		frame.add(new JButton("This is " + 3), c);
		c.ipady = 60; // make component taller
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;
		frame.add(new JButton("This is " + 4), c);
		c.ipady = 0;		// reset to default
		c.weighty = 1.0;	// request any extra vertical space
		c.anchor = GridBagConstraints.PAGE_END; // bottom of space
		c.insets = new Insets(10,0,0,0);	// top padding
		c.gridx = 1;		// aligned with button 2
		c.gridwidth = 2;	// 2 columns wide
		c.gridy = 2;		// third row
		frame.add(new JButton("This is " + 5), c);
		
		frame.setSize(300,200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
