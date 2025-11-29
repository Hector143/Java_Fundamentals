package java_arrays;

import java.util.Scanner;

public class java_arrays {
// multiple choice quiz made by Hector the great
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		// Variables Strings
		String[] answers = {"b","d","c","a"}; String[] answers1 = {"t","f","f","f","t"};
		String[] responses = {"","","",""}; String[] responses1 = {"","","","",""};
		String[] feedback = {"Too bad!"," You need more improvement","Well Done!","Better!","Perfect!" };
		String startTest; String startTestII;
		int score = 0;
		System.out.println("Welcome to Quiz.");
		System.out.println("Type ('yes/no') to start the test I");
		
		
		startTest = scan.nextLine();
		if (startTest.equalsIgnoreCase("yes")) {
			System.out.println("Test I. Multiple Choices");
			
			
			System.out.println("\nWhat is 2 + 2 = 4 - 1 that _ quick maths?");
			System.out.println("a.)  2");
			System.out.println("b.)  3");
			System.out.println("c.)  4");
			System.out.println("d.)  5");
			responses[0] = scan.next();
			System.out.println("What is the fastest land animal in the planet?");
			System.out.println("a.)  tiger");
			System.out.println("b.)  horse");
			System.out.println("c.)  giraffe");
			System.out.println("d.)  cheetah");
			responses[1] = scan.next();
			System.out.println("Calculate the sum of 2,4,3,1?");
			System.out.println("a.)  8");
			System.out.println("b.)  9");
			System.out.println("c.)  10");
			System.out.println("d.)  12");
			responses[2] = scan.next();
			System.out.println("which is faster?");
			System.out.println("a.)  a car");
			System.out.println("b.)  a horse");
			System.out.println("c.)  a human");
			System.out.println("d.)  a Lion");
			responses[3] = scan.next();
			
			System.out.println("Want to proceed to Test II? (yes/no)");
			startTestII = scan.next();
			if (startTestII.equalsIgnoreCase("yes")) {
				System.out.println("Test II. True or False. Write T if its true, then write f if it is false.");
					
					
				System.out.println("\ncan a man run 100 kilometers more than a horse?");
			
				responses1[0] = scan.next();
				System.out.println("is the earth flat?");
					
				responses1[1] = scan.next();
				System.out.println("does an adult body of a human regenerates limbs if removed?");
					
				responses1[2] = scan.next();
				System.out.println("is horse faster than a racecar?");
					
				responses1[3] = scan.next();
				System.out.println("inside the earth has gravity?");
					
				responses1[4] = scan.next();
					
				int score1 = 0;
				
				for (int o = 0; o < 5; o++) {
					if (responses1[o].equalsIgnoreCase(answers1[o])) {
						score1++;
						}
					}
				System.out.println("Test II Score is: " + score1 +"/5");	
				} else if (startTestII.equalsIgnoreCase("no")) {
					System.out.println("Test II has not been answered yet.");
					System.out.println("Test I Score is: " + score +"/4");
					scan.close();
					
				} 
			
			
			
			
			
			
			
			for (int i = 0; i < 4; i++) {
				if (responses[i].equalsIgnoreCase(answers[i])) {
					score++;
				}
			}
			
			// conditions using if when you want to show the results //
			
		
		
			
			
			
			switch (score) {
				case 1 :
					System.out.println(feedback[0]);
					break;
				case 2 :
					System.out.println(feedback[1]);
					break;
				case 3 :
					System.out.println(feedback[2]);
					break;
				case 4 :
					System.out.println(feedback[3]);
					break;
				case 5 :
					System.out.println(feedback[4]);
					break;
				default:
					System.out.println("You've got no brain at all");
			}
		} else if(startTest.equalsIgnoreCase("no")) {
			System.out.println("quiz ended. failed attempt");
			scan.close();
		}
		
	}
		

}
