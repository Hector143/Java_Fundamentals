package Arrays_Practice;

import java.util.Scanner;

public class Arrays_Pre_Lab_Exam {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = 0;
		do {
			System.out.print("Enter number of students: ");
			num = scan.nextInt();
			scan.nextLine();
			if (num < 3 || num > 30) {
				System.out.println("Invalid. Must be between 3 and 30.");
			}
		} while (num < 3 || num > 30);
		
		System.out.println();
		String[] name = new String[num];
		for (int i = 0; i < num; i++) {
			System.out.print("Enter name for student " + (i + 1) + ": ");
			name[i] = scan.nextLine();
		}
		
		System.out.println("\n--- ENTER ATTENDANCE (1=Present, 0=Absent) ---");
		int[][] attendance = new int[num][5];
		int[] percentage = new int[num];
		int[] numberOfPresent = new int[num];
		int numOfPresent = 0;
		
		for (int i = 0; i < num; i++) {
			int percent = 0;
			numOfPresent = 0;
			for (int j = 0; j < 5; j++) {
				do {
					System.out.printf("Day %d for %s: ", (j + 1), name[i]);
					attendance[i][j] = scan.nextInt();
					if (attendance[i][j] != 1 && attendance[i][j] != 0) {
						System.out.print("Invalid input\n");
					} else {
						break;
					}
				} while (attendance[i][j] != 1 && attendance[i][j] != 0);
				scan.nextLine();
				if (attendance[i][j] == 1) {
					percent += 20;
					numOfPresent++;
				}
			}
			numberOfPresent[i] = numOfPresent;
			percentage[i] = percent;
			System.out.println("\n");
						
		}
		double[][] quizzes = new double[num][3];
		
		double getSum = 0;
		double[] avg = new double[num];
		System.out.println("--- ENTER QUIZ SCORES (0-100) ---");
		for (int i = 0; i < num; i++) {
			double sum = 0;
			for (int j = 0; j < 3; j++) {
				
				
				do {
					System.out.printf("Quiz %d for %s: ", (j+1), name[i]);
					quizzes[i][j] = scan.nextDouble();
					
					if (quizzes[i][j] <  0 || quizzes[i][j] > 100) {
						System.out.print("Invalid input\n");
					} else {
						break;
					}
				} while (quizzes[i][j] < 0 || quizzes[i][j] > 100);
				scan.nextLine();
				sum += quizzes[i][j];
			}
			getSum = sum;
			avg[i] = getSum / 3;
			System.out.println();
		}
		
		
		String[] status = new String[num];
		for (int i = 0; i < status.length; i++) {
			if (percentage[i] >= 80 && avg[i] >= 75) {
				status[i] = "PASSED";
			} else if (percentage[i] < 80 && avg[i] >= 75) {
				status[i] = "FAILED due to attendance";
			} else if (percentage[i] >= 80 && avg[i] < 75) {
				status[i] = "FAILED due to low grades";
			} else {
				status[i] = "FAILED";
			}
			
		}
		
		System.out.println("================ CLASS SUMMARY ================");
		System.out.println("Name\tPresent\tAtt%\tQuizAvg\t Status");
		for (int i = 0; i < num; i++) {
			System.out.printf("%s\t%d\t%d%%\t%.2f\t %s%n", name[i],numberOfPresent[i],percentage[i],avg[i],status[i]);
		}
			
		System.out.println("==============================================");
		scan.close();
		
	}
}
