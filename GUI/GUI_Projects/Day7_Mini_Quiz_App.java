package GUI_Projects;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Day7_Mini_Quiz_App implements ActionListener{
	
	static JLabel question;
	static JLabel ans;
	static JLabel result;
	static JTextField enter;
	static JButton submit;
	
	public static void main(String[] args) {
		new Day7_Mini_Quiz_App();

	}
	
	Day7_Mini_Quiz_App() {
		
		question = new JLabel("What is 2 + 2?");
		question.setBounds(10,10,120,30);
		
		ans = new JLabel("Answer: ");
		ans.setBounds(10,40,70,30);
		
		enter = new JTextField();
		enter.setBounds(80,40,70,30);
		
		submit = new JButton("Submit");
		submit.setBounds(10,80,140,20);
		submit.addActionListener(this);
		
		result = new JLabel("");
		result.setBounds(10,105,100,30);
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.getContentPane().add(question);
		frame.getContentPane().add(ans);
		frame.getContentPane().add(enter);
		frame.getContentPane().add(submit);
		frame.getContentPane().add(result);
		frame.setSize(190,200);
		frame.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit && enter.getText().equals("4")) {
			result.setText("Correct! 🎉");
			enter.setText(null);
			
		} else {
			result.setText("Incorrect!");
			enter.setText(null);
		}
			
	}
		
}
	
	


