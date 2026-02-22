package javaGUI;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class GUI_JCheckBox extends JFrame implements ActionListener{
	private JButton button;
	private JCheckBox checkBox;
	ImageIcon xIcon;
	ImageIcon checkIcon;
	public static void main(String[] args) {
		new GUI_JCheckBox();

	}
	
	GUI_JCheckBox() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
			
		xIcon = new ImageIcon("x.png");
		checkIcon = new ImageIcon("check.png");
		
		button = new JButton();
		button.setText("Submit");
		button.setFocusable(false);
		button.addActionListener(this);
		
		checkBox = new JCheckBox();
		checkBox.setText("I'm not a robot");
		checkBox.setFocusable(false);
		checkBox.setFont(new Font("Consolas", Font.PLAIN, 25));
		// when deselected
		checkBox.setIcon(xIcon);
		checkBox.setSelectedIcon(checkIcon);
		
		this.add(button);
		this.add(checkBox);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			System.out.println(checkBox.isSelected());
			if (checkBox.isSelected()) {
				System.out.println("I am not a robot!");
			}
		}
		
	}

}
