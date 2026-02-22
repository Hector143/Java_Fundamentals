package javaGUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class GUI_JLabel {

	public static void main(String[] args) {
		// JLabel = a GUI display area for a string of text, an image, or both
		
		ImageIcon image = new ImageIcon("logo.png");
		Border border = BorderFactory.createLineBorder(Color.green,3);
		
		JLabel label = new JLabel(); // create a label
		label.setText("Im the fastest typist in the world!"); //set text ofLabel
		label.setIcon(image); // set an image icon add to label
		label.setHorizontalTextPosition(JLabel.CENTER); // set text left to right or center of image icon
		label.setVerticalTextPosition(JLabel.TOP); // set text top, center, bottom of image icon
		label.setForeground(new Color(0xFF1122)); // set font color of text
		label.setFont(new Font("MV Boli",Font.BOLD, 60)); // set font of text
		label.setIconTextGap(10); // set gap of text to image
		label.setBackground(Color.black); // set background color
		label.setOpaque(true); // display background color
		label.setBorder(border); // set border of label 
		label.setVerticalAlignment(JLabel.CENTER); // set vertical position of label alignment to top bottom or center of the frame
		label.setHorizontalAlignment(JLabel.CENTER); // set horizontal position of label alignment to left right, center of the frame icon + label
		//label.setBounds(0, 0, 550, 600); // set x,y position within frame as well as dimensions
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setSize(550, 600); // alternative is pack but frame is good when you want it set size
		//frame.setLayout(null); 
		frame.setVisible(true); // set visible true otherwise frame wont pop out
		frame.add(label); // add label to frame so that it is visible (both image and text)
		frame.pack(); // make sure to add frame add label to it before you use this. it makes your frame expands based on the components you put inside
	}

}
