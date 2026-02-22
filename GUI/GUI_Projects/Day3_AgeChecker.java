package GUI_Projects;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Day3_AgeChecker implements ActionListener{
	static JTextField textfield;
	static JLabel label2;
	static JButton button;
	
	public static void main(String[] args) {
		new Day3_AgeChecker();

	}
	
	Day3_AgeChecker() {
		
		JLabel label1 = new JLabel("Enter Age:");
		label1.setBounds(30,30,120,30);
		
		label2 = new JLabel("");
		label2.setBounds(90,100,220,30);
		
		button = new JButton("Check Age");
		button.setBounds(60,70,150,30);
		button.addActionListener(this);
		
		textfield = new JTextField();
		textfield.setBounds(120, 30, 150, 30);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,300,200);
		panel.add(label1);
		panel.add(textfield);
		panel.add(button);
		panel.add(label2);
	
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(300,200);
		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			int age = Integer.parseInt(textfield.getText());
			if (age >= 18) {
				label2.setText("You are an Adult");
			} else {
				label2.setText("You are a Minor");
			}
		}
		
	}

}
