package com.bitguru.ora.sc.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloWorld implements ActionListener{
	JButton button1; // good for using actionlisteners
	JButton button2;
	JButton button3;
	
	public void startup() {
		
		button1 = new JButton("Button One");
		button2 = new JButton("Button two");
		button3 = new JButton("Button three");
		
		button1.setFont(new Font("serif", Font.ITALIC, 16));
		button1.setForeground(Color.RED);
		button2.setEnabled(true);
		button3.setFont(new Font("Arial", Font.ITALIC, 16));
		button3.setForeground(Color.BLUE);
		
		button1.setMnemonic('o');
		button1.setDisplayedMnemonicIndex(7);
		button2.setMnemonic('t');
		button2.setDisplayedMnemonicIndex(7);
		button3.setMnemonic('h');
		
		button1.setPreferredSize(button3.getPreferredSize());
		button2.setPreferredSize(button3.getPreferredSize());
		
		
		JLabel greeting = new JLabel("Hello, World", JLabel.CENTER);
		greeting.setFont(new Font("serif", Font.BOLD, 32));
		greeting.setForeground(Color.RED);
		
		JFrame frame = new JFrame("Important Message");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getRootPane().setDefaultButton(button3);
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(button1);
		frame.getContentPane().add(button2);
		frame.getContentPane().add(button3);
		frame.getContentPane().add(greeting);
		frame.setSize(240, 160);
//		frame.pack(); // displays the window but in the smallest way possible that still fits all the components.
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		//easier 
//		 SwingUtilities.invokeLater( () -> new HelloWorld().startup() );
		SwingUtilities.invokeLater( new Runnable() {
			public void run() {
				new HelloWorld().startup();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==button1) {
			
		}
		
	}
	
	

}
