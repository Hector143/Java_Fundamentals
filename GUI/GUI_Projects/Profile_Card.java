package GUI_Projects;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Profile_Card implements ActionListener{
	static JLabel image;
	static JLabel name;
	static JLabel course;
	static JButton button;
	static ImageIcon icon;
	
	public static void main(String[] args) {

		new Profile_Card();

	}
	
	Profile_Card() {
		
		icon = new ImageIcon("id.jpeg");
		
		image = new JLabel();
		image.setBackground(Color.white);
		image.setBounds(30,0,450,500);
		
		name = new JLabel("Name:");
		name.setBounds(30,500,100,30);
		
		course = new JLabel("Course:");
		course.setBounds(30,530,100,30);
		
		button = new JButton("Show Profile");
		button.setBounds(30,560, 130,30);
		button.addActionListener(this);
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(450,640);
		frame.add(image);
		frame.add(name);
		frame.add(course);
		frame.add(button);
		
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == button) {
			name.setText("Name: Hector");
			course.setText("Course: BSIT");
			image.setIcon(icon);
		}
		
	}

}
