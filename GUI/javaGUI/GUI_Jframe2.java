package javaGUI;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame; 

public class GUI_Jframe2 {

	public static void main(String[] args) {
		
		
		// JFrame = a GUI window to add components to
		
		JFrame frame = new JFrame(); // creates a frame
		frame.setTitle("JFrame By Hekitroller"); // sets title of frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit out of application
		frame.setResizable(false); // prevent frame from being resized
		frame.setSize(420,420); // sets the x-dimension, and y-dimension of frame
		frame.setVisible(true); // show frame
		
		ImageIcon image = new ImageIcon("logo.png"); // create a new icon for our frame
		frame.setIconImage(image.getImage()); // change icon of frame
		frame.getContentPane().setBackground(new Color(0x123456)); // change color of frame using hexadecimal (0x000000) or rgb color like(0,0,0)
		
		
	}

}
