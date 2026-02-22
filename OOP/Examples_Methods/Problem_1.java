package Examples_Methods;

import java.util.Scanner;

public class Problem_1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] scores = readScores(scan);
		
		double average = getAverage(scores);
		int highest = getHighest(scores);
		int lowest = getLowest(scores);
		
		System.out.println("-------------------------------\r\n"
				+ "      STUDENT SCORE REPORT\r\n"
				+ "-------------------------------\r\n"
				+ "");
		System.out.printf("Average Score\t: %.2f%n", average);
		System.out.println("Highest Score\t: " + highest);
		System.out.println("Lowest Score\t: " + lowest);
		scan.close();
		
		
		
		

	}
	
	public static int[] readScores(Scanner scan) {
		System.out.print("Enter number of students: ");
		int num = scan.nextInt(); scan.nextLine();
		
		int[] scores = new int[num];
		
		for(int i = 0; i < scores.length; i++) {
			System.out.print("Enter score " + (i+1) + ": ");
			scores[i] = scan.nextInt(); scan.nextLine();
		}
		
		return scores;
	}
	
	public static double getAverage(int[] scores) {
		double avg = 0;
		for (int i = 0; i < scores.length; i++) {
			avg += scores[i];
		}
		return avg / scores.length;
	}
	
	public static int getHighest(int[] scores) {
		int high = 0;
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] > high) {
				high = scores[i];
			}
		}
		return high;
	}
	
	public static int getLowest(int[] scores) {
		int low = scores[0];
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] < low) {
				low = scores[i];
			}
		}
		return low;
	}
	
	

}
