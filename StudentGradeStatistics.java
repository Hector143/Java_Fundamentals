package hey;
import java.util.Scanner;

public class StudentGradeStatistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        int[] grades = new int[numStudents];
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter grade for student " + (i + 1) + ": ");
            grades[i] = scanner.nextInt();
        }

        int totalSum = 0;
        int highestGrade = -1; // Set an initial value for comparison
        int lowestGrade = 101; // Set an initial value for comparison
        int numPassed = 0;
        int numFailed = 0;

        for (int grade : grades) {
            totalSum += grade;
            if (grade > highestGrade) {
                highestGrade = grade;
            }
            if (grade < lowestGrade) {
                lowestGrade = grade;
            }
            if (grade >= 50) {
                numPassed++;
            } else {
                numFailed++;
                
            }
        }

        double average = (double) totalSum / numStudents;

        System.out.println("Statistics:");
        System.out.println("Average grade: " + average);
        System.out.println("Highest grade: " + highestGrade);
        System.out.println("Lowest grade: " + lowestGrade);
        System.out.println("Number of students who passed: " + numPassed);
        System.out.println("Number of students who failed: " + numFailed);

        scanner.close();
    }
}

