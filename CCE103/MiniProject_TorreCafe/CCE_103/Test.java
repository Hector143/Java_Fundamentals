package CCE_103;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

public class Test extends JFrame{

	Image img = new ImageIcon("coffee1.jpg").getImage().getScaledInstance(180, 150, Image.SCALE_SMOOTH);
	ImageIcon scaledImage = new ImageIcon(img);
	Image img2 = new ImageIcon("coffee2.jpg").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
	
	Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setSize(400,400);
		setLocationRelativeTo(null);
		
//		RoundedButton button = new RoundedButton("F11");
//		button.setSize(150,60);
//		button.setVerticalAlignment(JButton.CENTER);
//		button.setHorizontalAlignment(JButton.CENTER);
		JButton button = new JButton("Torre Cafe but", scaledImage);
		button.setSize(180,170);
////		button.setLocation((400 / 4),(400 / 4));
		button.setHorizontalTextPosition(JButton.CENTER);
		button.setVerticalTextPosition(JButton.BOTTOM);
////		button.setHorizontalTextPosition(SwingConstants.CENTER);
////		button.setVerticalTextPosition(SwingConstants.BOTTOM);
//		
		button.setOpaque(false);
		button.setBorderPainted(false);
////		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		add(button);
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button.setBackground(Color.gray);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				button.setBackground(Color.white);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				button.setBackground(Color.DARK_GRAY);
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				button.setBackground(Color.WHITE);
			}
		});
		add(button);
		setVisible(true);
	}
	public static void main(String[] args) {
//		new Test().setVisible(true);	
//		for (int i = 1; i <= 12; i++) {
////			System.out.printf("centerCenterPanel.add(coffeeBut%d);%n", i);
//			System.out.printf("JButton coffeeBut%d = new JButton(\"TorreCappuccino\", scaledCoffee%d);\r\n"
//					+ "		coffeeBut%d.setSize(200,180);\r\n"
//					+ "		coffeeBut%d.setHorizontalTextPosition(JButton.CENTER);\r\n"
//					+ "		coffeeBut%d.setVerticalTextPosition(JButton.BOTTOM);\r\n"
//					+ "		coffeeBut%d.setFocusable(false);\r\n"
//					+ "		coffeeBut%d.setOpaque(false);\r\n"
//					+ "		coffeeBut%d.setContentAreaFilled(false);%n%n",i,i,i,i,i,i,i,i);
//		}
		new Test();
	}

}
