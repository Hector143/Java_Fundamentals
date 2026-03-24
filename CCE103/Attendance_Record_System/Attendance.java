package Attendance_Record_System;
//import java.awt.geom.RoundRectangle2D;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.*;
import javax.swing.*;

public class Attendance implements ActionListener{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// striker regular TItle on the top
		// calipso regular = select option
		// recta small caps - buttons
		new Attendance();
	}
	
	public Attendance() {
//		JButton recordAttendance = new JButton("Record Attendance");
//		recordAttendance.setBounds(50,50,250,60);
//		recordAttendance.setFocusable(false);
//		recordAttendance.setFocusPainted(false);
//		recordAttendance.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
//		recordAttendance.setBorder(new RoundedBorder(150));
//		recordAttendance.setFont(new Font("SansSerif",Font.PLAIN,22));
		
		
//		RoundedButton btn = new RoundedButton("Record Attendance");
//		btn.setBounds(50,50,400,65);
//	    btn.setBackground(new Color(0xFFFFFF));
//	    btn.setForeground(Color.black);
//	    btn.setFont(new Font("SansSerif",Font.PLAIN,22));
		
		JLabel selectOption = new JLabel("SELECT OPTION");
		selectOption.setBounds(45,10,400,70);
		selectOption.setForeground(Color.black);
		selectOption.setFont(new Font("DialogInput", Font.BOLD, 46));
		
	    ShadowButton recordAttendance = new ShadowButton("RECORD ATTENDANCE");
	    recordAttendance.setBounds(50,90,350,60);
	    recordAttendance.setBackground(new Color(0xFFFFFF)); 
	    recordAttendance.setForeground(new Color(0x000000));
	    recordAttendance.setFont(new Font("",Font.PLAIN,19));
	    recordAttendance.addActionListener(e -> {
	    	if(e.getSource()==recordAttendance) {
	    		new Record();
	    	}
	    });
	    recordAttendance.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseEntered(MouseEvent e) {
	            recordAttendance.setBackground(new Color(0xE0E0E0)); // hover color
	            recordAttendance.repaint();
	        }

	        @Override
	        public void mouseExited(MouseEvent e) {
	            recordAttendance.setBackground(Color.WHITE); // normal color
	            recordAttendance.repaint();
	        }
	        
	        @Override
	        public void mousePressed(MouseEvent e) {
	            recordAttendance.setBackground(new Color(0x888888)); // pressed color
	        }

	        @Override
	        public void mouseReleased(MouseEvent e) {
	            recordAttendance.setBackground(new Color(0xE0E0E0)); // back to hover
	        }
	    });
	    
	    ShadowButton viewAttendance = new ShadowButton("VIEW ATTENDANCE");
	    viewAttendance.setBounds(50,160,350,60);
	    viewAttendance.setBackground(new Color(0xFFFFFF)); 
	    viewAttendance.setForeground(new Color(0x000000));
	    viewAttendance.setFont(new Font("",Font.PLAIN,19));
	    viewAttendance.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseEntered(MouseEvent e) {
	            viewAttendance.setBackground(new Color(0xE0E0E0)); // hover color
	            viewAttendance.repaint();
	        }

	        @Override
	        public void mouseExited(MouseEvent e) {
	            viewAttendance.setBackground(Color.WHITE); // normal color
	            viewAttendance.repaint();
	        }
	        
	        @Override
	        public void mousePressed(MouseEvent e) {
	            viewAttendance.setBackground(new Color(0x888888)); // pressed color
	        }

	        @Override
	        public void mouseReleased(MouseEvent e) {
	            viewAttendance.setBackground(new Color(0xE0E0E0)); // back to hover
	        }
	    });
	    
	    ShadowButton updateRemoveAttendance = new ShadowButton("UPDATE/REMOVE ATTENDANCE");
	    updateRemoveAttendance.setBounds(50,230,350,60);
	    updateRemoveAttendance.setBackground(new Color(0xFFFFFF)); 
	    updateRemoveAttendance.setForeground(new Color(0x000000));
	    updateRemoveAttendance.setFont(new Font("",Font.PLAIN,19));
	    updateRemoveAttendance.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseEntered(MouseEvent e) {
	            updateRemoveAttendance.setBackground(new Color(0xE0E0E0)); // hover color
	            updateRemoveAttendance.repaint();
	        }

	        @Override
	        public void mouseExited(MouseEvent e) {
	            updateRemoveAttendance.setBackground(Color.WHITE); // normal color
	            updateRemoveAttendance.repaint();
	        }
	        
	        @Override
	        public void mousePressed(MouseEvent e) {
	            updateRemoveAttendance.setBackground(new Color(0x888888)); // pressed color
	        }

	        @Override
	        public void mouseReleased(MouseEvent e) {
	            updateRemoveAttendance.setBackground(new Color(0xE0E0E0)); // back to hover
	        }
	    });
	    
	    ShadowButton exit = new ShadowButton("EXIT");
	    exit.setBounds(50,300,350,60);
	    exit.setBackground(new Color(0xFFFFFF)); 
	    exit.setForeground(new Color(0x000000));
	    exit.setFont(new Font("",Font.PLAIN,19));
	    exit.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseEntered(MouseEvent e) {
	            exit.setBackground(new Color(0xE0E0E0)); // hover color
	            exit.repaint();
	        }

	        @Override
	        public void mouseExited(MouseEvent e) {
	            exit.setBackground(Color.WHITE); // normal color
	            exit.repaint();
	        }
	        
	        @Override
	        public void mousePressed(MouseEvent e) {
	            exit.setBackground(new Color(0x888888)); // pressed color
	        }

	        @Override
	        public void mouseReleased(MouseEvent e) {
	            exit.setBackground(new Color(0xE0E0E0)); // back to hover
	        }
	    });
	    
	    ShadowButton2 panel = new ShadowButton2();
		panel.setLayout(null);
		panel.setBounds(10,130,490,400);
		panel.setBackground(new Color(0x4E68FC));
		panel.add(selectOption);
		panel.add(recordAttendance);
		panel.add(viewAttendance);
		panel.add(updateRemoveAttendance);
		panel.add(exit);
		
		JLabel AMS = new JLabel("ATTENDANCE MONITORING");
		AMS.setBounds(45,40,400,30);
		AMS.setForeground(Color.black);
		AMS.setFont(new Font("DialogInput", Font.BOLD, 30));
		
		JLabel AMS2 = new JLabel("SYSTEM");
		AMS2.setBounds(185,70,400,30);
		AMS2.setForeground(Color.black);
		AMS2.setFont(new Font("DialogInput", Font.BOLD, 30));
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setTitle("Attendance Monitoring System");
		frame.setSize(540,600);
		frame.getContentPane().setBackground(new Color(0xD2E8FA));
		frame.setResizable(false);
		frame.getContentPane().add(panel);
		frame.getContentPane().add(AMS);
//		frame.setUndecorated(true); // Remove default window borders
//		frame.setShape(new RoundRectangle2D.Double(0, 0, frame.getWidth(), frame.getHeight(), 40, 40)); // Set rounded shape with radius 40 px
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		
	}
	
	public void recordAttendance() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		if (e.getSource()==)
		
	}

}

//class RoundedButton extends JPanel {
//
//    public RoundedButton(String text) {
//        super(text);
//        setFocusPainted(false);
//        setContentAreaFilled(false);
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        Graphics2D g2 = (Graphics2D) g.create();
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//                            RenderingHints.VALUE_ANTIALIAS_ON);
//
//        if (getModel().isPressed()) {
//            g2.setColor(Color.LIGHT_GRAY);
//        } else {
//            g2.setColor(getBackground());
//        }
//
//        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 90, 90);
//        g2.dispose();
//
//        super.paintComponent(g);
//    }
//
//    @Override
//    protected void paintBorder(Graphics g) {
//        Graphics2D g2 = (Graphics2D) g;
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//                            RenderingHints.VALUE_ANTIALIAS_ON);
//        g2.setColor(getForeground());
//        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 90, 90);
//    }
//}
class ShadowButton extends JButton {

    private int radius = 90;
    private int shadowSize = 5;
    private Color shadowColor = new Color(20, 20, 170, 230); // semi-transparent

    public ShadowButton(String text) {
        super(text);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        // 🔹 Shadow
        g2.setColor(shadowColor);
        g2.fillRoundRect(
                shadowSize,
                shadowSize,
                getWidth() - shadowSize,
                getHeight() - shadowSize,
                radius,
                radius
        );

        // 🔹 Button background
        g2.setColor(getBackground());
        g2.fillRoundRect(
                0,
                0,
                getWidth() - shadowSize,
                getHeight() - shadowSize,
                radius,
                radius
        );

        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        g2.drawRoundRect(
                0,
                0,
                getWidth() - shadowSize - 1,
                getHeight() - shadowSize - 1,
                radius,
                radius
        );
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        size.width += shadowSize;
        size.height += shadowSize;
        return size;
    }
}

class ShadowButton2 extends JPanel {

    private int radius = 60;
    private int shadowSize = 15;
    private Color shadowColor = new Color(20, 20, 170, 230); // semi-transparent

    public ShadowButton2() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        // 🔹 Shadow
        g2.setColor(shadowColor);
        g2.fillRoundRect(
                shadowSize,
                shadowSize,
                getWidth() - shadowSize,
                getHeight() - shadowSize,
                radius,
                radius
        );

        // 🔹 Button background
        g2.setColor(getBackground());
        g2.fillRoundRect(
                0,
                0,
                getWidth() - shadowSize,
                getHeight() - shadowSize,
                radius,
                radius
        );

        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        g2.drawRoundRect(
                0,
                0,
                getWidth() - shadowSize - 1,
                getHeight() - shadowSize - 1,
                radius,
                radius
        );
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        size.width += shadowSize;
        size.height += shadowSize;
        return size;
    }
}
