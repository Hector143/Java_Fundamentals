package javaGUI;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class JOptionsPane_hek {
	public static void main(String[] args) {
		//String name = JOptionPane.showInputDialog();
		
//		JOptionPane.showMessageDialog(null, "WELCOME TO GUI CODING BY HEKITROLLER");
		Scanner scan = new Scanner(System.in);
		// Variables Strings
		String[] answers = {"b","d","c","a"}; String[] answers1 = {"t","f","f","f","t"};
		String[] responses = {"","","",""}; String[] responses1 = {"","","","",""};
		String[] feedback = {"Too bad!"," You need more improvement","Well Done!","Better!","Perfect!" };
		String startTestII;
		int score; int score1;
		JOptionPane.showMessageDialog(null, "Welcome to Quiz.");
		System.out.println("Type ('yes/no') Please enter \\\"yes\\\" or \\\"no\\\" if you would like to proceed to Test I.");
		
		String startTest = JOptionPane.showInputDialog("Type \"Yes\" or \"no\" if you would like to start the Test I.");
		
		if (startTest.equalsIgnoreCase("yes")) {
			JOptionPane.showMessageDialog(null, "Test I. Multiple Choices");
			
			responses[0] = JOptionPane.showInputDialog("\nWhat is 2 + 2 = 4 - 1 that _ quick maths?" + "\na.)  2" + "\nb.)  3" + "\nc.)  4" + "\nd.)  5");
//			System.out.println("\nWhat is 2 + 2 = 4 - 1 that _ quick maths?");
//			System.out.println("a.)  2");
//			System.out.println("b.)  3");
//			System.out.println("c.)  4");
//			System.out.println("d.)  5");
//			responses[0] = scan.next();
			responses[1] = JOptionPane.showInputDialog("\nWhat is the fastest land animal in the planet?" + "\na.)  tiger" + "\nb.)  horse" + "\nc.)  giraffe" + "\nd.)  cheetah");
//			System.out.println("What is the fastest land animal in the planet?");
//			System.out.println("a.)  tiger");
//			System.out.println("b.)  horse");
//			System.out.println("c.)  giraffe");
//			System.out.println("d.)  cheetah");
//			responses[1] = scan.next();
			responses[2] = JOptionPane.showInputDialog("\nCalculate the sum of 2,4,3,1?" + "\na.)  8" + "\nb.)  9" + "\nc.)  10" + "\nd.)  12");

//			System.out.println("Calculate the sum of 2,4,3,1?");
//			System.out.println("a.)  8");
//			System.out.println("b.)  9");
//			System.out.println("c.)  10");
//			System.out.println("d.)  12");
//			responses[2] = scan.next();
			responses[2] = JOptionPane.showInputDialog("\nwhich is faster?" + "\na.)  a car" + "\nb.)  a horse" + "\nc.)  a human" + "\nd.)  zeebra");
//			System.out.println("which is faster?");
//			System.out.println("a.)  a car");
//			System.out.println("b.)  a horse");
//			System.out.println("c.)  a human");
//			System.out.println("d.)  a Lion");
//			responses[3] = scan.next();
			
			score = 0;
			for (int i = 0; i < 4; i++) {
				if (responses[i].equalsIgnoreCase(answers[i])) {
					score++;
				}
			}
			startTestII = JOptionPane.showInputDialog("Want to proceed to Test II? (\"Yes\" or \"no\")");
		
			if (startTestII.equalsIgnoreCase("yes")) {
				
			
			JOptionPane.showMessageDialog(null,"Test II. True or False. Write \"T\" if its true, then write \"F\" if it is false.");
					
					
				responses1[0] = JOptionPane.showInputDialog("\ncan a man run 100 kilometers more than a horse?");
				responses1[1] = JOptionPane.showInputDialog("is the earth flat?");
//				System.out.println("is the earth flat?");	
				responses1[2] = JOptionPane.showInputDialog("does an adult body of a human regenerates limbs if removed?");
				
//				System.out.println("does an adult body of a human regenerates limbs if removed?");
					
				responses1[3] = JOptionPane.showInputDialog("is horse faster than a racecar?");
				
					
				responses1[4] = JOptionPane.showInputDialog("inside the earth has gravity?");
//				System.out.println("inside the earth has gravity?");
//					
//				responses1[4] = scan.next();
//					
				score1 = 0;
				
				for (int o = 0; o < 5; o++) {
					if (responses1[o].equalsIgnoreCase(answers1[o])) {
						score1++;
						}
					}
				String result =JOptionPane.showInputDialog(null, "Want to see the Result? (yes/no).");
				if (result.equalsIgnoreCase("yes")) {
					JOptionPane.showMessageDialog(null, "Test I Score is: " + score +"/4." + "\nTest II. Score is: " + score1 +"/5.");
					
				} else if (result.equalsIgnoreCase("no")) {
					JOptionPane.showMessageDialog(null, "Exit Quiz.");
					
					
				}
			} else if (startTest.equalsIgnoreCase("no")) {
//				System.out.println("Test II has not been answered yet.");
//				System.out.println("Test I Score is: " + score +"/4");
				JOptionPane.showMessageDialog(null, "Exit Quiz.");
				
			}
			
		}System.exit(0);
	}
}
					
				
		
		
			
			

	
	
	
		
	
		
	
				
			
			// conditions using if when you want to show the results //
			
		
		
			
			
			
//			switch (score) {
//				case 1 :
//					System.out.println(feedback[0]);
//					break;
//				case 2 :
//					System.out.println(feedback[1]);
//					break;
//				case 3 :
//					System.out.println(feedback[2]);
//					break;
//				case 4 :
//					System.out.println(feedback[3]);
//					break;
//				case 5 :
//					System.out.println(feedback[4]);
//					break;
//				default:
//					System.out.println("You've got no brain at all");
			
//		} else if(startTestII.equalsIgnoreCase("no")) {
//			System.out.println("quiz ended. failed attempt");
//			scan.close();
//		}
		
	
		



	
		
		


