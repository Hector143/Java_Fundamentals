package GUI_Projects;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Day4_SimpleCalculator implements ActionListener{
	static JLabel label1;
	static JLabel label2;
	static JLabel result;
	static JTextField textfield1;
	static JTextField textfield2;
	static JButton addbut;
	static JButton subbut;
	static JButton mulbut;
	static JButton divbut;
	
	public static void main(String[] args) {
		new Day4_SimpleCalculator();

	}
	
	Day4_SimpleCalculator() {
		
		JLabel title = new JLabel("Simple Calculator");
		title.setBounds(40,0,200,30);
		title.setForeground(Color.blue);
		title.setFont(new Font("serif", Font.BOLD, 24));
		
		label1 = new JLabel("Number 1:");
		label1.setBounds(30,40,100,30);
		
		label2 = new JLabel("Number 2:");
		label2.setBounds(30,70,100,30);
		
		result = new JLabel("Result: ");
		result.setBounds(30,180,100,30);
		
		textfield1 = new JTextField();
		textfield1.setBounds(100,40,120,30);
		
		textfield2 = new JTextField();
		textfield2.setBounds(100,70,120,30);
		
		addbut = new JButton("Addition");
		addbut.setBounds(20,110,110,30);
		addbut.addActionListener(this);
		
		subbut = new JButton("Subtraction");
		subbut.setBounds(130,110,110,30);
		subbut.addActionListener(this);
		
		mulbut = new JButton("Multiplication");
		mulbut.setBounds(20,140,110,30);
		mulbut.addActionListener(this);

		divbut = new JButton("Division");
		divbut.setBounds(130,140,110,30);
		divbut.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,300,300);
		panel.setBackground(Color.CYAN);
		panel.add(title);
		panel.add(label1);
		panel.add(textfield1);
		panel.add(label2);
		panel.add(textfield2);
		panel.add(addbut);
		panel.add(subbut);
		panel.add(mulbut);
		panel.add(divbut);
		panel.add(result);
		
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Simple Calculator");
		frame.setLayout(null);
		frame.setSize(300,300);
		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double num1 = Double.parseDouble(textfield1.getText());
		double num2 = Double.parseDouble(textfield2.getText());
		double r = 0;
		boolean v = true;
		if (e.getSource() == addbut) {
			r = num1 + num2;
		} 
		
		else if (e.getSource() == subbut) {
			r = num1 - num2;
		} 
		
		else if (e.getSource() == mulbut) {
			r = num1 * num2;
		}
		
		else if (e.getSource() == divbut) {
			if (num2 == 0) {
				JOptionPane.showMessageDialog(null, "Cannot be divided by zero!", "Input Failed", JOptionPane.ERROR_MESSAGE);
				v = false;
			} else {
				r = num1 / num2;
			}	
		}
		
		if (v) {
			result.setText("Result: " + Double.toString(r));
		}
	}
}
