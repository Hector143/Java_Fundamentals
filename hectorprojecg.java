package hectorproject;

import java.util.Scanner;

public class hectorprojecg {
		// We are going to make a math quiz actually not quiz its an EXAM!!! HEHE :)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String Name1; String Name2; String Name3; String Name4; String Result; String retry;
		double grades = 70;
		do {
			
		
			int score = 0;
			int countdown = 3;
			System.out.println("Quiz 'MATH' " + "\n\nNow the first question is: what is 2 + 2 = 4 - 1 that _ quick maths?");
			Name1 = scanner.nextLine();
			if (Name1.equalsIgnoreCase("3")) {
				System.out.println("You are Correct!");
				score = score + 1;
				grades = grades + 5;
			} else {
				System.out.println("Wrong!");
				score = score + 0;
				grades = grades + 0;
			}
			
			System.out.println("next question: what is 9 - 5?");
			Name2 = scanner.nextLine();
			if (Name2.equalsIgnoreCase("4")) {
				System.out.println("You are Correct!");
				score = score + 1;
				grades = grades + 5;
			} else {
				System.out.println("Wrong!");
				score = score + 0;
				grades = grades + 0;
			}
			
			System.out.println("next question: what is 5 * 2?");
			Name3 = scanner.nextLine();
			if (Name3.equalsIgnoreCase("10")) {
				System.out.println("You are Correct!");
				score = score + 1;
				grades = grades + 5;
			} else {
				System.out.println("Wrong!");
				score = score + 0;
				grades = grades + 0;
			}
			
			System.out.println("final question: what is the sum of 12,5,8,11,13,2,9?");
			Name4 = scanner.nextLine();
			if (Name4.equalsIgnoreCase("60")) {
				System.out.println("You are Correct!");
				score = score + 1;
				grades = grades + 14.99;
			} else {
				System.out.println("Wrong!");
				score = score + 0;
				grades = grades + 0;
			}
			System.out.println("Showing result... in");
			for (int i = countdown; i > 0; i--) {
	            System.out.println(i + "...");
	            try {
	                Thread.sleep(1000); // Wait for 1 second
	            } catch (InterruptedException e) {
	                System.err.println("Countdown interrupted.");
	            }
	        }
			
	        if (score >= 3) {
				System.out.println("Your Total score is " +score+"/4. You passed the quiz!"); { 
				
					if (score == 3) {
						System.out.println("\n\nYour average grade in 1st semester is: " + grades);
					} else if(score == 4) {
						System.out.println("\n\nYour average grade in 1st semester is: " + grades);
					}
				}
			} else {
				System.out.println("Your Total score is " +score+"/4. Im sorry You failed the quiz!");
				if (score == 2) {
					System.out.println("\n\nYour average grade in 1st semester is: " + grades);
				} else if(score == 1) {
					System.out.println("\n\nYour average grade in 1st semester is: " + grades);
				} else {
					System.out.println("\n\nYou are dropped out from the school");
				}
			}
	        	
	        
	        System.out.println("Retry the Quiz? (yes/no)");
	        retry = scanner.nextLine();
	        
		} while (retry.equalsIgnoreCase("yes"));
		System.out.println("Thank you for taking the Quiz!");
		scanner.close();
		System.out.println("Choose Number between 1-7.");
		
		
		
	        
        
	
		

		
			
		}

}
