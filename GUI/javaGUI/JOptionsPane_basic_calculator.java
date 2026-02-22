package javaGUI;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class JOptionsPane_basic_calculator {

	public static void main(String[] args) {
		int sum, difference, product, quotient = 0, options = 0;
		
		Scanner scanner = new Scanner(System.in);
		do {
			int num1 = Integer.parseInt(JOptionPane.showInputDialog("input your first number:"));
			int num2 = Integer.parseInt(JOptionPane.showInputDialog("input your second number:"));
			options = Integer.parseInt(JOptionPane.showInputDialog("What operations?"
					+ "\n[1] Addition"
					+ "\n[2] Subtraction"
					+ "\n[3] Multiplication"
					+ "\n[4] Division"
					+ "\n[5] Exit"));
			
			switch(options) 
			{
			case 1:
				sum = num1 + num2;
				JOptionPane.showMessageDialog(null, sum);
				break;
			case 2:
				difference = num1 - num2;
				JOptionPane.showMessageDialog(null, difference);
				break;
			case 3:
				product = num1 * num2;
				JOptionPane.showMessageDialog(null, product);
				break;
			case 4:
				quotient = num1 / num2;
				if (quotient == 0) {
					System.out.println("Cannot be Divided by zero!");
				} else 
				{
					JOptionPane.showMessageDialog(null, quotient);
				}
				break;
			case 5:
				break;
			default:
				System.out.println("No");
				break;
			}
		} while(options!=5) ;
		
		
		scanner.close();
					
	}

}
