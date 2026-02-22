package javaGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI_MyFrame extends JFrame implements ActionListener{
	JButton button;
	JLabel label;
	
	GUI_MyFrame() { // constructor
		// since we inherit from JFrame we can just call this because JFrame is already instantiated
		
		ImageIcon icon = new ImageIcon("point.png");
		ImageIcon icon2 = new ImageIcon("shock.png");
		
		label = new JLabel();
		label.setIcon(icon2);
		label.setBounds(200,250,150,150);
		label.setVisible(false);
		
		button = new JButton("Button");
		button.setBounds(100, 100, 250, 100);
		button.addActionListener(this); // good habit for beginners and for more detailed
//		button.addActionListener(e -> System.out.println("Poo")); // more advanced concept, this is lambda expression
		button.setText("I'm a butt.."); // overrides the text name of the button because we implemented it after .
		button.setFocusable(false);
		button.setIcon(icon);
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
		button.setFont(new Font("seris", Font.BOLD, 25));
		button.setIconTextGap(0); // only if you want it closer or adjust its gap between text and icon.
		button.setForeground(Color.BLUE);
		button.setBackground(Color.LIGHT_GRAY);
		button.setBorder(BorderFactory.createEtchedBorder());
//		button.setEnabled(false); // disables the button.
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500,500);
		this.setVisible(true);
		this.add(button);
		this.add(label);
		
		
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
//			System.out.println("Poo");
//			button.setEnabled(false); // can only be clicked once.
			label.setVisible(true);
		}
		
	}
	
	
	
}
