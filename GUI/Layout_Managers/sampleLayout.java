package Layout_Managers;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class sampleLayout {

	public static void main(String[] args) {
		JButton button;
		JFrame frame = new JFrame("My Layouts");
		
		JPanel pane = new JPanel();
		pane.setLayout(new GridBagLayout());
		frame.setContentPane(pane);
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		
		button = new JButton("Button 1");
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1.0;
		c.gridwidth = 1;
		pane.add(button,c);
		
		button = new JButton("Button 2");
		c.gridx = 1;
		c.gridy = 0;
		pane.add(button, c);
		
		button = new JButton("Button 3");
		c.gridx = 2;
		c.gridy = 0;
		pane.add(button, c);
		
		button = new JButton("Long-Named Button 4");
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 3;
		c.weightx = 0.0;
		c.ipady = 40; // makes components tall
		pane.add(button, c);
		
		button = new JButton("5");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;       //reset to default
		c.weighty = 1.0;   //request any extra vertical space
		c.anchor = GridBagConstraints.PAGE_END; //bottom of space
		c.insets = new Insets(10,0,0,0);  //top padding
		c.gridx = 1;       //aligned with button 2
		c.gridwidth = 2;   //2 columns wide
		c.gridy = 2;       //third row
		pane.add(button, c);
		
		
		
//		for (int i = 0; i < 5; i++) {
//			frame.add(new JButton("button " + (i+1)));
//		}
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
