package GUI_Projects;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Day2_Button_Counter extends JFrame implements ActionListener{
	private static int count;
	private static JButton button1;
	private static JButton button2;
	private static JLabel label;
	public static void main(String[] args) {
		new Day2_Button_Counter();

	}
	
	Day2_Button_Counter() {
		
		label = new JLabel("0");
		label.setBounds(140,10,100,30);
		
		button1 = new JButton("Increase");
		button1.setBounds(70,50,150,30);
		button1.addActionListener(this);
		
		button2 = new JButton("Reset");
		button2.setBounds(70,100,150,30);
		button2.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,300,200);
		panel.add(label);
		panel.add(button1);
		panel.add(button2);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("Counter App");
		this.setSize(300,200);
		this.add(panel);
		this.setResizable(false);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==button1) {
			count++;
			String c = Integer.toString(count);
			label.setText(c);
		} 
		if (e.getSource() == button2) {
			count = 0;
			label.setText("0");
		}
		
	}

}
