package JFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class practice1 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("First Program");
		JButton but1 = new JButton("Click this!");
			
		
		frame.setSize(500, 400);
		frame.add(but1);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	
	}
}
